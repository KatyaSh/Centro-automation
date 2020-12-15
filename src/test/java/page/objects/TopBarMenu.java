package page.objects;

import driver.DriverManager;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;

public class TopBarMenu extends TestBase {








    public TopBarMenu () {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }



}
