package page.objects;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

import static org.testng.Assert.assertTrue;

public class TopBarMenu {

    private Logger logger = LogManager.getLogger(TopBarMenu.class);



    public TopBarMenu() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }


    @FindBy(xpath = "//img[@id='centroLogo']")
    private WebElement centroLogo;

    @FindBy(xpath = "//a[@class='nav-breadcrumb']")
    private WebElement gingerLoginLink;

    @FindBy(xpath = "//a[@id='aboutLink']")
    private WebElement aboutLinkTopMenu;

    @FindBy(xpath = "//a[@id='loginLink']")
    private WebElement loginLink;

    @FindBy(css = "#logoutForm > ul > li > a > span.truncate")
    private WebElement navbarUserMenu;

    @FindBy(css = "#logoutForm > ul > li > a > span.truncate")
    private WebElement navBarUserMenu;

    @FindBy(css = "#logoutForm > ul > li > ul > li:nth-child(8) > a")
    private WebElement logOffLink;



    public boolean centroLogoImageIsPresented () {
        WaitForElement.waitUntilElementIsVisible(centroLogo);
        boolean centroLogoIsDisplayed = centroLogo.isDisplayed();
        logger.info("Centro logo is displayed: " + centroLogoIsDisplayed);
        return centroLogoIsDisplayed;
    }

    public boolean gingerLoginLinkIsPresented () {
        WaitForElement.waitUntilElementIsVisible(gingerLoginLink);
        boolean gingerLoginLinkIsDisplayed = gingerLoginLink.isDisplayed();
        logger.info("ginger Login link is displayed: " + gingerLoginLinkIsDisplayed);
        return gingerLoginLinkIsDisplayed;
    }

    public boolean aboutLinkIsPresented () {
        WaitForElement.waitUntilElementIsVisible(aboutLinkTopMenu);
        boolean aboutLinkIsDisplayed = aboutLinkTopMenu.isDisplayed();
        logger.info("About link is displayed: " + aboutLinkIsDisplayed);
        return aboutLinkIsDisplayed;
    }

    public boolean LoginLinkIsPresented () {
        WaitForElement.waitUntilElementIsVisible(loginLink);
        boolean loginLinkIsDisplayed = loginLink.isDisplayed();
        logger.info("Log in link is displayed: " + loginLinkIsDisplayed);
        return loginLinkIsDisplayed;
    }


    public void clickOnNavbarUserMenu() {
        WaitForElement.waitUntilElementIsClickable(navBarUserMenu);
        navBarUserMenu.click();
        WaitForElement.waitUntilElementIsVisible(logOffLink);
        logger.info("User menu is opened");
    }

    public void clickOnLogOffLink() {
        WaitForElement.waitUntilElementIsVisible(logOffLink);
        logOffLink.click();
        logger.info("Log off link is clicked");
    }

    public void clickOnAboutLinkInTopMenu() {
        WaitForElement.waitUntilElementIsClickable(aboutLinkTopMenu);
        aboutLinkTopMenu.click();
        logger.info("About link is clicked");
    }

    public void clickOnLoginLinkInTopMenu() {
        WaitForElement.waitUntilElementIsClickable(loginLink);
        loginLink.click();
        logger.info("Log in link is clicked");
    }


    public void userLogOff() {
        clickOnNavbarUserMenu();
        clickOnLogOffLink();
    }





















}
