package ru.rgs.WebTests;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;
import static ru.rgs.WebTests.Constants.*;


@Listeners(ErrorTestListener.class)
public class TestBase {
  /**
   * Площадка по умолчанию.
   */
  private static StandProperties STAND = StandProperties.TEST3;
  protected static String BASE_URL;
  public static FirefoxDriver  wd;
  private static String AUTH_URL;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();




  @BeforeSuite
  public static void setUp() {
    BASE_URL = STAND.getUrl();
    AUTH_URL = BASE_URL + "auth/login.jsp";
    wd = new FirefoxDriver();
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
  @Step("Login")
  protected static void login() {

    wd.get(AUTH_URL);
    wd.findElement(By.id("usernameField-inputEl")).click();
    wd.findElement(By.id("passwordField-inputEl")).clear();
    wd.findElement(By.id("passwordField-inputEl")).sendKeys(PASSWORD);
    wd.findElement(By.id("usernameField-inputEl")).clear();
    wd.findElement(By.id("usernameField-inputEl")).sendKeys(LOGIN);
    wd.findElement(By.id("button-1011-btnIconEl")).click();
    wd.findElement(By.id("acceptBtn-btnIconEl")).click();
  }

  @Step("Screenshot")
  protected static byte[] takeScreenshot(){
    return ((TakesScreenshot) wd).getScreenshotAs(OutputType.BYTES);
  }


  @AfterSuite(alwaysRun = true)
  public static void tearDown() {
    wd.quit();



  }

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