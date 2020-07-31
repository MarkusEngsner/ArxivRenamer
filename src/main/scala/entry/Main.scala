package entry

import arxivscraper.Scraper.newFileName
import fileio.FileIO.{copyFile, arxivPdfs}

object Main {
  def renameFile(oldName: String) =
    copyFile(oldName, newFileName(oldName))

  def renameArray(arr: Array[String]) = arr foreach renameFile

  def renameAll() = renameArray(arxivPdfs())

  /* Usage:
    First argument: all or list of filenames
   */
  def main(args: Array[String]): Unit = {
    println(System.getProperty("user.dir"))
    if (args.length < 1) {
      println("too few arguments")
      return
    }
    if (args(0) == "all") renameAll()
    else renameArray(args)
  }
}
