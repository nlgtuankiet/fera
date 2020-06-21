package com.nlgtuankiet.fera.function

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.FirestoreOptions
import com.google.cloud.functions.HttpFunction
import com.google.cloud.functions.HttpRequest
import com.google.cloud.functions.HttpResponse
import com.google.cloud.storage.Acl
import com.google.cloud.storage.BlobId
import com.google.cloud.storage.BlobInfo
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.StorageClient
import java.util.Base64

private val firebaseApp by lazy {
  val serviceAccountStream = Base64.getDecoder()
    .decode(System.getenv("FERA_AED_SA_B64"))
    .inputStream()
  val firebaseOption = FirebaseOptions.builder()
    .setCredentials(GoogleCredentials.fromStream(serviceAccountStream))
    .setFirestoreOptions(
      FirestoreOptions.newBuilder()
        .build()
    )
    .build()
  FirebaseApp.initializeApp(firebaseOption)
}

private val bucket by lazy {
  StorageClient.getInstance(firebaseApp).bucket("fera-verto.appspot.com")
}

@Suppress("unused")
class UploadApk : HttpFunction {

  @OptIn(ExperimentalStdlibApi::class)
  override fun service(request: HttpRequest, response: HttpResponse) {
    // TODO improve with buffer
    require(request.method.equals("post", true))
    val fileName = request.parts.getValue("fileName")
      .inputStream.use { it.readBytes().decodeToString() }
    val fileBytes = request.parts.getValue("fileContent")
      .inputStream.use { it.readBytes() }
    bucket.storage.create(
      BlobInfo.newBuilder(BlobId.of(bucket.name, "apk/$fileName"))
        .setAcl(
          listOf(
            Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER)
          )
        )
        .build(),
      fileBytes
    )
    response.setStatusCode(200)
  }
}

suspend fun main(args: Array<String>) {
  val command = args[0]
  when(command) {
    "insightOf" -> insightOf(args[1], args[2])
  }
}
