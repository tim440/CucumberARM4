package ru.rgs.WebTests.bdd;

import cucumber.api.java.Before;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.rgs.WebTests.TestBase;


@Story("Вход в систему")
public class Login extends TestBase {

  @Before
  public void init() {
    TestBase.setUp();
  }

  @Step("Открытие страницы аутентефикации")
  @Когда("^произошел переход на страницу аутентификации$")
  public void goToLoginPage() {


    wd.get(AUTH_URL);


  }

  @Step("Ввод логина и пароля")
  @Тогда("^вводим Логин (.+) и пароль (.+)$")
  public void setLoginPassowrd(String login, String password) {

    WebDriverWait wait = new WebDriverWait(wd, 4);

    String currentUrl = wd.getCurrentUrl();
    log(currentUrl);
    if (!currentUrl.equals("http://arm4-test3-web.tengry.com/armweb/private/index.jsp")) {

      wd.findElement(By.id("usernameField-inputEl")).click();
      wd.findElement(By.id("passwordField-inputEl")).clear();
      wd.findElement(By.id("passwordField-inputEl")).sendKeys(password);
      wd.findElement(By.id("usernameField-inputEl")).clear();
      wd.findElement(By.id("usernameField-inputEl")).sendKeys(login);
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Войти'])[1]/following::span[1]")));
      wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Войти'])[1]/following::span[1]")).click();
      /*wd.findElement(By.id("button-1011-btnIconEl")).click();*/
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Принять'])[1]/following::span[1]")));
      wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Принять'])[1]/following::span[1]")).click();
    }
  }

}
