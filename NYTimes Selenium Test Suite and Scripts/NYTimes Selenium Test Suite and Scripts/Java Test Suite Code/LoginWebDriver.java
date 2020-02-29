package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginWebDriver {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://vagur7.axshare.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLoginWebDriver() throws Exception {
    driver.get(baseUrl + "/#g=1&p=home");
    driver.findElement(By.id("u5_img")).click();
    driver.findElement(By.id("u127_img")).click();
    driver.findElement(By.cssSelector("#u284_text > p:nth-child(1) > span:nth-child(1)")).click();
    driver.findElement(By.id("u2454_input")).click();
    driver.findElement(By.id("u2454_input")).sendKeys("pereira.k@husky.com");
    driver.findElement(By.id("u2459_input")).click();
    driver.findElement(By.id("u2459_input")).sendKeys("asdf@1234");
    driver.findElement(By.id("u2466_input")).click();
    driver.findElement(By.id("u127_img")).click();
    // Warning: assertTextPresent may require manual changes
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
