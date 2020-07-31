package entry

import arxivscraper.Scraper.newFileName
import fileio.FileIO.{copyFile, arxivPdfs}

object Main {
  def renameFile(oldName: String) =
    copyFile(oldName, newFileName(oldName))

  def renameAll() = arxivPdfs foreach renameFile

  def main(args: Array[String]): Unit = {
    println(System.getProperty("user.dir"))
    if (args.length < 1) {
      println("too few arguments")
      return
    }
    val oldName = args(0)
    renameFile(oldName)
  }
}
