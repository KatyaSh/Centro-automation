package tests;

import driver.DriverManger;
import driver.DriverUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;


public class TestBase {

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        DriverManger.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage("http://localhost/Centro/");
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        DriverManger.disposeDriver();
    }

}
