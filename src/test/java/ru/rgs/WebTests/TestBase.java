package ru.rgs.WebTests;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

import static ru.rgs.WebTests.Constants.LOGIN;
import static ru.rgs.WebTests.Constants.PASSWORD;


@Listeners(ErrorTestListener.class)
public class TestBase {
  /**
   * Площадка по умолчанию.
   */
  private static StandProperties STAND = StandProperties.TEST3;
  protected static ChromeDriver wd;
  private static String AUTH_URL;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();


  @BeforeSuite
  public static void setUp() {
    String BASE_URL = STAND.getUrl();
    AUTH_URL = BASE_URL + "auth/login.jsp";
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    wd.manage().window().maximize();
    login();

  }


  /*@BeforeMethod
  public void setUp() {


    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wd.manage().window().maximize();
    login();
  }*/
  @Step("Вход в систему")
  protected static void login() {
    WebDriverWait wait = new WebDriverWait(wd, 3);
    wd.get(AUTH_URL);
    wd.findElement(By.id("usernameField-inputEl")).click();
    wd.findElement(By.id("passwordField-inputEl")).clear();
    wd.findElement(By.id("passwordField-inputEl")).sendKeys(PASSWORD);
    wd.findElement(By.id("usernameField-inputEl")).clear();
    wd.findElement(By.id("usernameField-inputEl")).sendKeys(LOGIN);
    wd.findElement(By.id("button-1011-btnIconEl")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.id("acceptBtn-btnIconEl")));
    wd.findElement(By.id("acceptBtn-btnIconEl")).click();
  }

  @Step("Screenshot")
  static byte[] takeScreenshot() {
    return ((TakesScreenshot) wd).getScreenshotAs(OutputType.BYTES);
  }


  @AfterSuite(alwaysRun = true)
  public static void tearDown() {
    wd.quit();


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

  protected boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}