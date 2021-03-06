package ru.rgs.WebTests.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Listeners;
import ru.rgs.WebTests.ErrorTestListener;

@Listeners(ErrorTestListener.class)

@CucumberOptions(
        features = "src/test/resources/bdd/exitBrowser.feature",
        plugin={"pretty", "html:build/cucumber-report"})

public class ExitBrowserRun extends AbstractTestNGCucumberTests {
}

