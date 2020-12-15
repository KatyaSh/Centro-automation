package driver;

public class DriverUtils {

    public static void setInitialConfiguration() {

        DriverManger.getWebDriver().manage().window().maximize();
    }

    public static void navigateToPage(String pageUrl) {

        DriverManger.getWebDriver().navigate().to(pageUrl);
    }
}
