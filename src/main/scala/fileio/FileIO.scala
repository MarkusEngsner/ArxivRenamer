package fileio

import java.nio.file.Files.copy
import java.nio.file.Paths.get
import java.nio.file.StandardCopyOption.REPLACE_EXISTING
import java.io.{File}
import scala.util.matching.Regex

object FileIO {
  def copyFile(oldName: String, newName: String) = {
    def toPath(s: String) = get(s)

    copy(toPath(oldName), toPath(newName), REPLACE_EXISTING)
  }

  def arxivPdfs(): Array[File] = {
    def regexPred(regexp: Regex)(f: File): Boolean =
      regexp.unapplySeq(f.toString).isDefined

    val folder = new File(System.getProperty("user.dir"))
    val files = folder.listFiles(f => !f.isHidden && !f.isDirectory)
    val regexp = "(.*/)([0-9]{4})+[.]+([0-9]{5}).pdf".r
    files.filter(regexPred(regexp))
  }

  // /([0-9]{4})+[.]+([0-9]{5}).pdf/g
}
