import java.io.{File, FileInputStream, FileOutputStream}

val folder = new File(System.getProperty("user.dir"))
val allFiles = folder.listFiles()
allFiles.count(p => true)
val files = folder.listFiles(f => !f.isHidden && !f.isDirectory)
files.count(p => true)
def regPred(regexp: scala.util.matching.Regex)(f: File): Boolean = {
  // The greedy slash match might cause issues if ran in root directory.
  // Needs to be tested.
  regexp.unapplySeq(f.toString).isDefined
}

val regexp = "(.*/)([0-9]{4})+[.]+([0-9]{5}).pdf".r
files.filter(regPred(regexp))
