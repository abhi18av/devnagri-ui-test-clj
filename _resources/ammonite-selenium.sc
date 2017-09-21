

// org.seleniumhq.selenium:selenium-java:3.5.3


import $ivy.`org.seleniumhq.selenium:selenium-java:3.5.3`

import org.openqa.selenium.WebDriver;
import com.thoughtworks.selenium;
import org.openqa.selenium.chrome


val driver = new chrome.ChromeDriver




val openDevTools = Keys.chord(Keys.ALT, Keys.CONTROL, "i");
driver.findElement(By.ByTagName("body")).sendKeys(openDevTools);
