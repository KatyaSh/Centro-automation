package tests;

import driver.DriverManager;
import driver.DriverUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;


public class TestBase {

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage("http://localhost/Centro/");
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        DriverManager.disposeDriver();
    }

}
