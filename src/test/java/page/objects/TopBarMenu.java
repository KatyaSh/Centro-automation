package page.objects;

import driver.DriverManger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;

public class TopBarMenu extends TestBase {








    public TopBarMenu () {
        PageFactory.initElements(DriverManger.getWebDriver(), this);
    }



}
