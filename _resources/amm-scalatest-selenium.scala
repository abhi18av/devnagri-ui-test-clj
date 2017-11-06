
import $ivy.`org.scalatest:scalatest_2.11:3.0.1`
import $ivy.`org.seleniumhq.selenium:selenium-java:3.5.3`


import org.scalatest.FlatSpec
import org.scalatest._

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome
import Matchers._




import org.scalatest._
import selenium._
import org.openqa.selenium._
import htmlunit._
import org.scalactic._



class SearchSpec extends FlatSpec with Matchers with WebBrowser {

  implicit val webDriver: WebDriver = new HtmlUnitDriver

  val host = "https://google.com"

  "The query for cheese!" should "display the results" in {

    go to "http://www.google.com"
//    click on "q"
//    textField("q").value = "Cheese!"
//    submit()
      // Google's search is rendered dynamically with JavaScript.
//    eventually { title should be ("Cheese! - Google Search") }

  }
}


