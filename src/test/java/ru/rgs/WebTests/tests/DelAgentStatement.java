package ru.rgs.WebTests.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import org.openqa.selenium.*;
import ru.rgs.WebTests.TestBase;

public class DelAgentStatement extends TestBase {

  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();




  @Test
  public void testUntitledTestCase() throws Exception {
    /*new logIn();*/
    /*wd.getCurrentUrl();*/
    wd.navigate().refresh();
    wd.manage().window().maximize();
    WebDriverWait wait = new WebDriverWait(wd, 10);
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Поиск'])[1]/following::span[1]")).click();
    wd.findElement(By.xpath("//div[@id='ext-gen1329']")).click();
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=.])[1]/following::li[1]")).click();
    wd.findElement(By.cssSelector("#ext-gen1339")).click();
    wd.findElement(By.id("button-1153-btnIconEl")).click();
    wd.findElement(By.id("button-1081-btnIconEl")).click();
    Thread.sleep(300);
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".x-grid-cell-headerId-gridcolumn-1090 > .x-grid-cell-inner")));
    Thread.sleep(300);
    wd.findElement(By.cssSelector(".x-grid-cell-headerId-gridcolumn-1090 > .x-grid-cell-inner")).click();
    wd.findElement(By.id("remove-button-1106-btnInnerEl")).click();
    wd.findElement(By.id("button-1006-btnIconEl")).click();

  }


  /*@AfterClass
  public void tearDown() {
    wd.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }*/

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = wd.switchTo().alert();
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
