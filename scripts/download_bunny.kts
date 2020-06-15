import java.io.File
import java.net.URL

// adb shell echo \$EXTERNAL_STORAGE | xargs -I {} adb push ./app/src/androidTest/assets/. "{}/fera_test_resources"

fun downloadBunnySampleVideo() {
  val url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
  val connection = URL(url).openConnection()
  File("./app/src/androidTest/res/raw/bunny_720.mp4").outputStream().use { outputStream ->
    val inputStream = connection.getInputStream()
    val contentLength = connection.contentLength
    println("Prepare to download ${contentLength.toFloat() / 1024 / 1024}Mb")
    var bytesCopied: Long = 0
    val bufferSize = 8 * 1024
    val buffer = ByteArray(bufferSize)
    var bytes = inputStream.read(buffer)
    var percent = 0L
    while (bytes >= 0) {
      outputStream.write(buffer, 0, bytes)
      bytesCopied += bytes
      val newPercent = bytesCopied * 100 / contentLength
      if (newPercent != percent) {
        percent = newPercent
        println("Download $percent%")
      }
      bytes = inputStream.read(buffer)
    }
  }
}

downloadBunnySampleVideo()