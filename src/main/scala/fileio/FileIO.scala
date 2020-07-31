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

  def arxivPdfs(): Array[String] = {
    def regexPred(reg: Regex)(dir: File, name: String): Boolean =
      reg.unapplySeq(name).isDefined

    val folder = new File(System.getProperty("user.dir"))
    val regexp = "([0-9]{4})+[.]+([0-9]{5}).pdf".r
    folder list regexPred(regexp)
  }
}
