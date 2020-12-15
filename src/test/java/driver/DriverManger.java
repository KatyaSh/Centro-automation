package driver;

import org.openqa.selenium.WebDriver;


public class DriverManger {

    private static WebDriver driver;

    private DriverManger() {

    }

    public static WebDriver getWebDriver() {
        if(driver==null) {
            driver = BrowserFactory.getBrowser(BrowserType.CHROME);
        }
        return driver;
    }

    public static void disposeDriver() {
        driver.close();
        driver = null;
    }


}
