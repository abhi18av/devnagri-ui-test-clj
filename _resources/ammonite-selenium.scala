

// org.seleniumhq.selenium:selenium-java:3.5.3

//"org.scalatest" % "scalatest_2.11" % "3.0.1" % "test"

//import $ivy.`org.scalatest:scalatest_2.11:3.0.1`

import $ivy.`org.scalatest::scalatest:3.0.1`
import $ivy.`org.seleniumhq.selenium:selenium-java:3.5.3`



import org.scalatest.FlatSpec
import org.scalatest._

import org.openqa.selenium.WebDriver;
//import com.thoughtworks.selenium;
import org.openqa.selenium.chrome


val driver = new chrome.ChromeDriver




driver.get("http://test.devanagri.co.in")

