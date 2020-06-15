package com.nlgtuankiet.fera.codegen

import kotlinx.coroutines.*
import org.zeroturnaround.exec.ProcessExecutor
import org.zeroturnaround.exec.ProcessResult
import org.zeroturnaround.exec.stream.LogOutputStream
import org.zeroturnaround.process.Processes
import java.io.File
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.random.Random


suspend fun testCoroutine() = coroutineScope {
  val job  = launch {
    runCommand("ffmpeg -y -i http://distribution.bbb3d.renderfarming.net/video/mp4/bbb_sunflower_1080p_60fps_normal.mp4 a.mp3") {
      println(it)
    }
  }
  delay(10000)
  println("cancel")
  job.cancel()
  delay(3000)
  println("after delay")
}

// TODO improve .start on a thread pool
// TODO cancelation not working!
// TODO enable redirectError cause redirectOutput not working
suspend fun runCommand(
  command: String,
  onProcess: (String) -> Unit
): Unit = suspendCancellableCoroutine { continuation ->
  println("command: $command")
  val error = StringBuilder()
  val args = command.splitToSequence(" ")
    .map { it.trim() }
    .filter { it.isNotEmpty() }
    .toList()
  val process = ProcessExecutor(args)
    .readOutput(true)
    .redirectOutput(
      object : LogOutputStream() {
        override fun processLine(line: String) {
          onProcess.invoke(line)
        }
      }
    )

//    .redirectError(
//      object : LogOutputStream() {
//        override fun processLine(line: String) {
//          error.appendln(line)
//        }
//      }
//    )
    .start()

  continuation.invokeOnCancellation {
    println("got cancel")
    if (!process.future.isDone) {
      // TODO interrupt?
      process.future.cancel(true)
    }
    if (process.process.isAlive) {
      // TODO force?
      Processes.newStandardProcess(process.process).destroyForcefully()
    }
  }

  val result: Result<ProcessResult?> = runCatching { process.future.get() }
  result
    .onFailure {
      continuation.resumeWithException(
        RuntimeException(
          "Cannot get process result",
          result.exceptionOrNull()
        )
      )
    }
    .onSuccess {
      if (it == null) {
        continuation.resumeWithException(RuntimeException("Process run success with cannot get result"))
      } else {
        when {
          error.isNotEmpty() -> {
            error.append(" error code: ${it.exitValue}")
            continuation.resumeWithException(RuntimeException(error.toString()))
          }
          it.exitValue != 0 -> {
            continuation.resumeWithException(RuntimeException("Execute failed code: ${it.exitValue}"))
          }
          else -> {
            continuation.resume(Unit)
          }
        }
      }

    }
}