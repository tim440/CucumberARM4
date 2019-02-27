package ru.rgs.WebTests.testsJava;

import org.testng.annotations.*;
import ru.rgs.WebTests.TestBase;

public class logInJava extends TestBase {


  @Test
  public void testLogin() throws InterruptedException {
    login();
  }

}
