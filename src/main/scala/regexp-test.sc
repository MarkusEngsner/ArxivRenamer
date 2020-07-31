import arxivscraper.Scraper
import fileio.FileIO.{arxivPdfs, copyFile}
import entry.Main.renameFile

val fileNames = arxivPdfs()
fileNames.foreach(
  renameFile
//  s => copyFile(s, Scraper.newFileName(s))
)