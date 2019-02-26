package ru.rgs.WebTests.tests;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.rgs.WebTests.TestBase;

public class logInJava extends TestBase {


  @Test
  public void testLogin() throws InterruptedException {
    login();
  }

}
