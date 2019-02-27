package ru.rgs.WebTests.testsJava;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.rgs.WebTests.TestBase;

public class AddAgentStatement extends TestBase {

  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();


  @Test
  public static void testAddAgentStatement() throws Exception {
    wd.manage().window().maximize();
    wd.navigate().refresh();
    WebDriverWait wait = new WebDriverWait(wd, 3);
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Поиск'])[1]/following::span[1]")).click();
     wd.findElement(By.id("create-button-1104-btnInnerEl")).click();
    Thread.sleep(300);
    wait.until(ExpectedConditions.elementToBeClickable(By.id("datefield-1179-inputEl")));
    wd.findElement(By.id("datefield-1179-inputEl")).click();
    wd.findElement(By.id("ext-gen1856")).click();
    wd.findElement(By.id("button-1441-btnIconEl")).click();
    wd.findElement(By.id("textfield-1178-inputEl")).click();
    wd.findElement(By.id("save-button-1409-btnInnerEl")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.id("button-1005-btnIconEl")));
    wd.findElement(By.id("button-1005-btnIconEl")).click();
    wd.findElement(By.xpath("//span[@id='cancel-button-1431-btnEl']/span")).click();
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

