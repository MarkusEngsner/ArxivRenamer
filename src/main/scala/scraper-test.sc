import arxivscraper.Scraper
import fileio.FileIO

val fileName = "2007.14729"
val s = Scraper.newFileName(fileName)
FileIO.copyFile(fileName + ".pdf", s + ".pdf")
