package ru.rgs.WebTests.bdd;

import cucumber.api.java.After;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Также;
import cucumber.api.java.ru.Тогда;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import ru.rgs.WebTests.ErrorTestListener;
import ru.rgs.WebTests.TestBase;

import java.time.Instant;


public class CreateOaDef extends TestBase {


  private Instant wait;


  /*@Before
  public void  init(){
    tb = new TestBase(System.getProperty("browser", BrowserType.FIREFOX));


  }*/


  @Когда("^произошел вход в систему")
  public void Login() {

      TestBase.setUp();

  }
  @Step("Открываем форму создания ОА из списочной")
  @И("^Открываем форму создания ОА из списочной$")
  public void OpenNewForm(){
    try {
      /*wd.manage().window().maximize();*/
      /*wd.navigate().refresh();*/
      wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Поиск'])[1]/following::span[1]")).click();
      wd.findElement(By.id("create-button-1104-btnInnerEl")).click();
      try {
        Thread.sleep(300);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    } catch (NoSuchElementException e) {

    }
  }
  @Step("заполняем фому ОА датой создания")
  @И("^заполняем фому ОА датой создания (.+)$")
  public void fillForm(String statementDate) {
    WebDriverWait wait = new WebDriverWait(wd, 3);
    try {
      Thread.sleep(300);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    try {
      wait.until(ExpectedConditions.elementToBeClickable(By.name("statementDate")));
      wd.findElement(By.name("statementDate")).click();
      wd.findElement(By.name("statementDate")).sendKeys(statementDate);
      wd.findElement(By.name("statementNumber")).click();
          } catch (NoSuchElementException e) {
    }
  }
@Step("Сохранение ОА")
  @Тогда("^сохраняем ОА$")
  public void submitOA() {
    try {
      wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Сохранить'])[1]/following::span[1]")).click();
      if (isElementPresent(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='OK'])[1]/following::span[1]"))) {
        new Select(wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='OK'])[1]/following::span[1]")));
      } else {
        Assert.assertTrue(isElementPresent(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='OK'])[1]/following::span[1]")));
      }
/*      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='OK'])[1]/following::span[1]")));
      wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='OK'])[1]/following::span[1]")).click();*/
      wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Закрыть'])[1]/following::span[1]")).click();
    } catch (NoSuchElementException e) {

    }

  }

 /* @After
  public void stop() {
    wd.close();
    *//*wd.quit();*//*

  }*/

}