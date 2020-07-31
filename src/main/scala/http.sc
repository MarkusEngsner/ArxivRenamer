import net.ruippeixotog.scalascraper.browser.JsoupBrowser

val url = "https://arxiv.org/abs/1901.00005"
val browser = JsoupBrowser()
val doc = browser.get(url)

import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL.Parse._
import net.ruippeixotog.scalascraper.model._

def title(document: Document) = {

  val h1 = document >> extractor("#abs h1", element, asIs[Element])
  val textMaybe: Option[Node] = h1.childNodes.find(e => e.isInstanceOf[TextNode])
  textMaybe match {
    case Some(t) => {
      t match {
        case TextNode(content) => content
        case ElementNode(element) => ""
      }
    }
  }
}
//println(title(doc))
//val h1 = doc >> extractor("#abs h1", element, asIs[Element])
//h1.children

/* Authors */
//val authDiv = (doc >> extractor("#abs .authors a", elementList))
doc >> elementList("#abs .authors a")
val authList = doc >> elementList("#abs .authors a") map { e => e.text}
authList.reduce((x, y) => x + ", " + y)
//val authors = authDiv.children >> element("a")

val y = 10

