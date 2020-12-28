package tests;

import driver.DriverManager;
import driver.DriverUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static navigation.ApplicationURLs.APPLICATION_URL;


public class TestBase {

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        DriverManager.disposeDriver();
    }

}
