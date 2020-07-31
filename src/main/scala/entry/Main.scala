package entry

import arxivscraper.Scraper
import fileio.FileIO

object Main{
  def main(args: Array[String]): Unit = {
    println(System.getProperty("user.dir"))
    if (args.length < 1) {
      println("too few arguments")
      return
    }
    val oldName = args(0)
    val newName = Scraper.newFileName(args(0))
    FileIO.copyFile(oldName, newName)
  }
}
