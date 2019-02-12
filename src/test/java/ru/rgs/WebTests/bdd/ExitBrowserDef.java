package ru.rgs.WebTests.bdd;

import cucumber.api.java.ru.И;
import io.qameta.allure.Step;
import ru.rgs.WebTests.TestBase;

public class ExitBrowserDef extends TestBase {
  @Step("Выход")
  @И("^Выход$")
  public void exit() {
    wd.close();
    /*wd.quit();*/
  }
}