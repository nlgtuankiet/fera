package com.nlgtuankiet.fera.data.ffmpeg

import com.nlgtuankiet.fera.domain.Log
import kotlinx.coroutines.suspendCancellableCoroutine
import org.zeroturnaround.exec.ProcessExecutor
import org.zeroturnaround.exec.ProcessResult
import org.zeroturnaround.exec.stream.LogOutputStream
import org.zeroturnaround.process.Processes
import javax.inject.Provider
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

// TODO improve .start on a thread pool
// TODO enable redirectError cause redirectOutput not working

private lateinit var libraryPath: Provider<String>

fun setLibraryPath(value: Provider<String>) {
  libraryPath = value
}

suspend fun runCommand(
  command: String,
  onProcess: (String) -> Unit
): Unit = suspendCancellableCoroutine { continuation ->
  println("run command: $command")
  val error = StringBuilder()
  val args = command.splitToSequence(" ")
    .map { it.trim() }
    .filter { it.isNotEmpty() }
    .toList()
  val process = ProcessExecutor(args).apply {
    readOutput(true)
    environment("LD_LIBRARY_PATH", libraryPath.get())
    redirectOutput(
      object : LogOutputStream() {
        override fun processLine(line: String) {
          if (continuation.isActive) {
            onProcess.invoke(line)
          }
        }
      }
    )
  }.start()
//    .redirectError(
//      object : LogOutputStream() {
//        override fun processLine(line: String) {
//          error.appendln(line)
//        }
//      }
//    )

  continuation.invokeOnCancellation {
    Log("cancel command: $command")
    if (!process.future.isDone) {
      // TODO interrupt?
      process.future.cancel(true)
    }
    // TODO force?
    Processes.newStandardProcess(process.process).destroyForcefully()
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

suspend fun runCommandToString(command: String): String {
  return buildString {
    runCommand(command) {
      appendLine(it)
    }
  }
}
