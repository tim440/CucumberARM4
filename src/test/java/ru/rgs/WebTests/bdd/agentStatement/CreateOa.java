package ru.rgs.WebTests.bdd.agentStatement;

import cucumber.api.java.Before;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.rgs.WebTests.TestBase;

import java.time.Instant;
@Feature("Отчет агента")
@Story("ОА")
public class CreateOa extends TestBase {


  private Instant wait;


  /*@Before
  public void init() {
    if(wd == null) {
      TestBase.setUp();
    }
  }*/


  /*@Когда("^произошел вход в систему")
  public void Login() {

      TestBase.setUp();
  }*/

  @Step("Открываем форму создания ОА из списочной")
  @Когда("^Открываем форму создания ОА из списочной$")
  public void OpenNewForm() throws InterruptedException {
    if(wd == null) {
      TestBase.setUp();
    }
    Thread.sleep(300);
    String currentUrl = wd.getCurrentUrl();
    /*log(currentUrl);*/
    if (!currentUrl.equals("http://arm4-test3-web.tengry.com/armweb/private/index.jsp")) {
      login();
    }
    try {
      /*wd.manage().window().maximize();*/
      /*wd.navigate().refresh();*/
      WebDriverWait wait = new WebDriverWait(wd, 4);
      try {
        Thread.sleep(300);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      if (isElementPresent((By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Продолжить'])[1]/following::span[1]")))) {
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Продолжить'])[1]/following::span[1]")).click();
      }
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Поиск'])[1]/following::span[1]")));
      wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Поиск'])[1]/following::span[1]")).click();
      wd.findElement(By.linkText("Создать")).click();
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
    } catch (InterruptedException ex) {
      ex.printStackTrace();
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
  public void submitOA() throws InterruptedException {
    try {
      WebDriverWait wait = new WebDriverWait(wd, 3);
      wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Сохранить'])[1]/following::span[1]")).click();
      try {
        Thread.sleep(300);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      wait.until(ExpectedConditions.elementToBeClickable
              (By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='OK'])[1]/following::span[1]")));
      if (isElementPresent(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='OK'])[1]/following::span[1]"))) {


        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='OK'])[1]/following::span[1]")).click();
      }
      else {
        Assert.assertTrue(isElementPresent(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='OK'])[1]/following::span[1]")));
      }
      /*wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='OK'])[1]/following::span[1]")));
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
