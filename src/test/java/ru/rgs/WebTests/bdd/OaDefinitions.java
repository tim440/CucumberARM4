package ru.rgs.WebTests.bdd;

import cucumber.api.java.After;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import cucumber.api.java.ru.Также;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.rgs.WebTests.TestBase;


public class OaDefinitions extends TestBase {


  private TestBase tb;


  /*@Before
  public void  init(){
    tb = new TestBase(System.getProperty("browser", BrowserType.FIREFOX));


  }*/


  @Когда("^произошел вход в систему создаем ОА со списочной формы$")
  public void AddAgentStatement() throws InterruptedException {
    try {
      TestBase.setUp();
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
    } catch (NoSuchElementException e) {

    }
  }
  @Также("^Выход$")
  public void goToStatement() {
    wd.close();
    wd.quit();

  }

  /*@After
  public void stop() {

    wd.quit();
    tb = null;
  }*/

}
