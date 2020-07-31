import java.io.{File, FilenameFilter}

import scala.util.matching.Regex


val folder = new File(System.getProperty("user.dir"))

def regexPred(regexp: Regex)(f: String): Boolean =
  regexp.unapplySeq(f).isDefined

val regexp = "([0-9]{4})+[.]+([0-9]{5}).pdf".r
val files = folder.list(
  (dir: File, name: String) => {
    regexp.unapplySeq(name).isDefined
  }
)
files.count(p => true)
