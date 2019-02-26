package ru.rgs.WebTests.bdd;


import cucumber.api.java.Before;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.rgs.WebTests.TestBase;

@Story("ОА")
public class DelAgentStatement extends TestBase {

 /* @Before
  public void init() throws InterruptedException {
    preCondition();
  }*/

  @Step("открываем списочную ОА")
  @Когда("^открываем списочную ОА$")
  public void openList() throws Exception {
    preCondition();
    WebDriverWait wait = new WebDriverWait(wd, 10);
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Поиск'])[1]/following::span[1]")).click();


  }

  @Тогда("^указываем фильтры \"Подразделение\" - (.+) ,\"дата ОА\" - (.+), \"агент\" - (.+)$")
          public void setFilter(String bid, String date, String agent) {
    WebDriverWait wait = new WebDriverWait(wd, 10);
    //Установка фильтров для поиска
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Сбросить'])[1]/following::span[1]")).click();
    //Фильтр по подразделению
    setBid(wait,bid);
    //Фильтр по дате ОА
    setDate(wait,date);
    //Фильтр по наименованию агента
    setAgent(wait, bid, agent);
  }

  @И("^удаляем отчет агента$")
  public void delAgentStatement() throws InterruptedException {
    //Поиск ОА и удаление
    WebDriverWait wait = new WebDriverWait(wd, 10);
    findAndDel(wait);
  }

  @Step("Запуск поиска и удаление")
  private void findAndDel(WebDriverWait wait) throws InterruptedException {
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Поиск'])[2]/following::span[1]")).click();

    Thread.sleep(300);
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".x-grid-cell-headerId-gridcolumn-1090 > .x-grid-cell-inner")));
    Thread.sleep(300);
    wd.findElement(By.cssSelector(".x-grid-cell-headerId-gridcolumn-1090 > .x-grid-cell-inner")).click();
    wd.findElement(By.id("remove-button-1106-btnInnerEl")).click();
    wd.findElement(By.id("button-1006-btnIconEl")).click();
  }

  @Step("Установка фильтра по агенту")
  private void setAgent(WebDriverWait wait, String bid, String agent) {
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Добавить фильтр'])[1]/following::span[1]")).click();
    wd.findElement(By.xpath("//div[3]/span/div/table[2]/tbody/tr/td[2]/table/tbody/tr/td[2]/div")).click();
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Код СКК'])[3]/following::li[1]")).click();
    wd.findElement(By.xpath("//div[3]/span/div/table[4]/tbody/tr/td[2]/table/tbody/tr/td[2]/div")).click();
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Код СКК'])[5]/following::input[1]")).click();
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Код СКК'])[5]/following::input[1]")).clear();
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Код СКК'])[5]/following::input[1]")).sendKeys(bid);
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ФИО/Наименование'])[2]/following::input[1]")).click();
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ФИО/Наименование'])[2]/following::input[1]")).clear();
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ФИО/Наименование'])[2]/following::input[1]")).sendKeys(agent);
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Применить фильтр'])[1]/following::span[1]")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div/table/tbody/tr/td[4]/div")));
    wd.findElement(By.xpath("//div[2]/div/table/tbody/tr/td[4]/div")).click();
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Выбрать'])[1]/following::span[1]")).click();
  }

  @Step("Установка фильтра по дате")
  private void setDate(WebDriverWait wait, String date) {
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Добавить фильтр'])[1]/following::span[1]")).click();
    wd.findElement(By.xpath("//div[2]/span/div/table[2]/tbody/tr/td[2]/table/tbody/tr/td[2]/div")).click();
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Номер отчёта агента'])[3]/following::li[1]")).click();
    wait.until(ExpectedConditions.elementToBeClickable(new By.ByXPath("//div[2]/span/div/table[4]/tbody/tr/td[2]/table/tbody/tr/td/input")));
    wd.findElement(By.xpath("//div[2]/span/div/table[4]/tbody/tr/td[2]/table/tbody/tr/td/input")).clear();
    wd.findElement(By.xpath("//div[2]/span/div/table[4]/tbody/tr/td[2]/table/tbody/tr/td/input")).sendKeys(date);
  }

  @Step("Установка фильтра по подразделению")
  private void setBid(WebDriverWait wait,String bid) {
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Добавить фильтр'])[1]/following::span[1]")).click();
    wd.findElement(By.xpath("//td[2]/table/tbody/tr/td[2]/div")).click();
    wd.findElement(By.xpath("//li[contains(.,'Подразделение')]")).click();
    wd.findElement(By.xpath("//table[4]/tbody/tr/td[2]/table/tbody/tr/td[2]/div")).click();
    wd.findElement(By.xpath("//span/div/table/tbody/tr/td[2]/input")).clear();
    wd.findElement(By.xpath("//span/div/table/tbody/tr/td[2]/input")).sendKeys(bid);
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Применить фильтр'])[1]/following::span[1]")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div/div[3]/div/table/tbody/tr/td[3]/div")));
    wd.findElement(By.xpath("//div[2]/div/div[3]/div/table/tbody/tr/td[3]/div")).click();
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Выбрать'])[1]/following::span[1]")).click();
  }

  @Step("Проверка что вход в систему произведен")
  private void preCondition() throws InterruptedException {
    Thread.sleep(300);
    String currentUrl = wd.getCurrentUrl();
    /*log(currentUrl);*/
    if (!currentUrl.equals("http://arm4-test3-web.tengry.com/armweb/private/index.jsp")) {
      login();
    }
    /*wd.getCurrentUrl();*/
    wd.navigate().refresh();
    wd.manage().window().maximize();

  }
}
