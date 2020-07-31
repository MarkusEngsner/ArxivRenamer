package example

import arxivscraper.Scraper

object Main extends App{
  val ages = Seq(42, 75, 29, 64)
  println(s"The oldest person is ${ages.max}")
  val s = Scraper.newFileName("1901.00005")
  println(s)
}
