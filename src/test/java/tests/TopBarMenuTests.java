package tests;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.LoginPage;
import page.objects.TopBarMenu;

import static org.testng.Assert.assertTrue;

public class TopBarMenuTests extends TestBase {

    private Logger logger = LogManager.getLogger(TopBarMenu.class);


    @Test
    public void uiTopBarElementsOnLoginPage(){
        TopBarMenu topBarMenu = new TopBarMenu();
        Assert.assertTrue(topBarMenu.centroLogoImageIsPresented());
        Assert.assertTrue(topBarMenu.gingerLoginLinkIsPresented());
        Assert.assertTrue(topBarMenu.aboutLinkIsPresented());
        Assert.assertTrue(topBarMenu.LoginLinkIsPresented());
    }

    @Test
    public void linksNavigationOnLoginPageForUnauthorizedUser(){
        TopBarMenu topBarMenu = new TopBarMenu();
        topBarMenu.clickOnAboutLinkInTopMenu();
        String pageTitleAbout = DriverManager.getWebDriver().getTitle();
        assertTrue(pageTitleAbout.contains("About"));
        logger.info("About page is opened");
        topBarMenu.clickOnLoginLinkInTopMenu();
        String pageTitleLogin = DriverManager.getWebDriver().getTitle();
        assertTrue(pageTitleLogin.contains("Login"));
        logger.info("Login page is opened");
    }

}
