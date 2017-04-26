package uk.gov.hmrc.greet

import java.io.File

/**
  * Created by rajesh on 31/03/17.
  */
object ListFiles extends App {
 println(getListOfFiles( new File(".").getCanonicalPath()))
  def getListOfFiles(dirName: String):List[File] = {
    val directory = new File(dirName)
    if (directory.exists && directory.isDirectory) {
      directory.listFiles.filter(_.isFile).toList
    } else {
      List[File]()
    }
  }
}
