package arxivscraper

import net.ruippeixotog.scalascraper.browser.{Browser, JsoupBrowser}
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL.Parse._
import net.ruippeixotog.scalascraper.model.{Document, Element, ElementNode, Node, TextNode}

object Scraper {
  val baseUrl: String = "https://arxiv.org/abs/"
  val browser: Browser = JsoupBrowser()

  def title(doc: Document): String = {
    val h1 = doc >> extractor("#abs h1", element, asIs[Element])
    val textNodeMaybe = h1.childNodes.find(e => e.isInstanceOf[TextNode])
    textNodeMaybe match {
      case Some(t) => {
        t match {
          case TextNode(content) => content
          case ElementNode(element) => ""
        }
      }
    }
  }

  def authors(doc: Document): String = {
    val authorList = doc >> elementList("#abs .authors a") map { e => e.text }
    authorList.reduce((x, y) => x + ", " + y)
    // TODO: shorten list if too many authors, give option for it
  }

  def newFileName(inputFilename: String): String = {
    def inputSanitizer(s: String): String =
      if (s.takeRight(4) == ".pdf") s.dropRight(4)
      else s

    val articleId = inputSanitizer(inputFilename)
    val fullUrl = baseUrl + articleId
    val doc = browser.get(fullUrl)
    // TODO: add ID too?
    (title(doc) + " - " + authors(doc)).replace(" ", "_") + ".pdf"
  }
}
