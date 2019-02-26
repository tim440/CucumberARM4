package ru.rgs.WebTests.tests;

import io.qameta.allure.Story;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import org.openqa.selenium.*;
import ru.rgs.WebTests.TestBase;
@Story("ОА")
public class DelAgentStatement extends TestBase {

  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();




  @Test
  public void delAgentStatement() throws Exception {
    Thread.sleep(300);
    String currentUrl = wd.getCurrentUrl();
    /*log(currentUrl);*/
    if (!currentUrl.equals("http://arm4-test3-web.tengry.com/armweb/private/index.jsp")) {
      login();
    }
    /*wd.getCurrentUrl();*/
    wd.navigate().refresh();
    wd.manage().window().maximize();
    WebDriverWait wait = new WebDriverWait(wd, 10);
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Поиск'])[1]/following::span[1]")).click();
//Установка фильтров для поиска
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Сбросить'])[1]/following::span[1]")).click();
    //Фильтр по подразделению
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Добавить фильтр'])[1]/following::span[1]")).click();
    wd.findElement(By.xpath("//td[2]/table/tbody/tr/td[2]/div")).click();
    wd.findElement(By.xpath("//li[contains(.,'Подразделение')]")).click();
    wd.findElement(By.xpath("//table[4]/tbody/tr/td[2]/table/tbody/tr/td[2]/div")).click();
    wd.findElement(By.xpath("//span/div/table/tbody/tr/td[2]/input")).clear();
    wd.findElement(By.xpath("//span/div/table/tbody/tr/td[2]/input")).sendKeys("72850010");
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Применить фильтр'])[1]/following::span[1]")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div/div[3]/div/table/tbody/tr/td[3]/div")));
    wd.findElement(By.xpath("//div[2]/div/div[3]/div/table/tbody/tr/td[3]/div")).click();
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Выбрать'])[1]/following::span[1]")).click();
    //Фильтр по дате ОА
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Добавить фильтр'])[1]/following::span[1]")).click();
    wd.findElement(By.xpath("//div[2]/span/div/table[2]/tbody/tr/td[2]/table/tbody/tr/td[2]/div")).click();
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Номер отчёта агента'])[3]/following::li[1]")).click();
    wait.until(ExpectedConditions.elementToBeClickable(new By.ByXPath("//div[2]/span/div/table[4]/tbody/tr/td[2]/table/tbody/tr/td/input")));
    wd.findElement(By.xpath("//div[2]/span/div/table[4]/tbody/tr/td[2]/table/tbody/tr/td/input")).clear();
    wd.findElement(By.xpath("//div[2]/span/div/table[4]/tbody/tr/td[2]/table/tbody/tr/td/input")).sendKeys("11022019");
    //Фильтр по наименованию агента
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Добавить фильтр'])[1]/following::span[1]")).click();
    wd.findElement(By.xpath("//div[3]/span/div/table[2]/tbody/tr/td[2]/table/tbody/tr/td[2]/div")).click();
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Код СКК'])[3]/following::li[1]")).click();
    wd.findElement(By.xpath("//div[3]/span/div/table[4]/tbody/tr/td[2]/table/tbody/tr/td[2]/div")).click();
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Код СКК'])[5]/following::input[1]")).click();
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Код СКК'])[5]/following::input[1]")).clear();
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Код СКК'])[5]/following::input[1]")).sendKeys("72850010");
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ФИО/Наименование'])[2]/following::input[1]")).click();
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ФИО/Наименование'])[2]/following::input[1]")).clear();
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ФИО/Наименование'])[2]/following::input[1]")).sendKeys("Автотест Ф");
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Применить фильтр'])[1]/following::span[1]")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div/table/tbody/tr/td[4]/div")));
    wd.findElement(By.xpath("//div[2]/div/table/tbody/tr/td[4]/div")).click();
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Выбрать'])[1]/following::span[1]")).click();
//Поиск ОА
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Поиск'])[2]/following::span[1]")).click();

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
