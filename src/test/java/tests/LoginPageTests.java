package tests;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.LoginPage;
import page.objects.TopBarMenu;

import static org.testng.Assert.assertTrue;



public class LoginPageTests extends TestBase {

    private Logger logger = LogManager.getLogger(LoginPage.class);

        @Test
        public void successfulLoginAsFullUserAndLogOff() {
            LoginPage loginPage = new LoginPage();
            loginPage.userLogin("full", "full");
            String pageTitleCatalog = DriverManager.getWebDriver().getTitle();
            assertTrue(pageTitleCatalog.contains("Catalog"));
            logger.info("Catalog Home page is opened");
            TopBarMenu topBarMenu = new TopBarMenu();
            topBarMenu.userLogOff();
            String pageTitleLogin = DriverManager.getWebDriver().getTitle();
            assertTrue(pageTitleLogin.contains("Login"));
            logger.info("Login page is opened");
            loginPage.checkIfUsernameFieldIsEmptyOrNot(DriverManager.getWebDriver());
        }

        @Test
        public void uiLoginFormElementsOnLoginPage() {
            LoginPage loginPage = new LoginPage();
            Assert.assertEquals("Login", loginPage.getLoginFormHeadingText());
            Assert.assertTrue(loginPage.rememberMeCheckboxIsPresented());
            loginPage.getRememberMeCheckboxText();
            Assert.assertTrue(loginPage.forgotPasswordLinkIsPresented());
            Assert.assertTrue(loginPage.registerLinkIsPresented());
            loginPage.getRegisterLinkText();
        }

    @Test
    public void LoginWithInvalidCredentials() {
        LoginPage loginPage = new LoginPage();
        loginPage.userLogin("full", "1234");
        Assert.assertEquals("Invalid login attempt. Wrong credentials ?", loginPage.getInvalidLoginAttemptErrorMessageText());
        String pageTitleLogin = DriverManager.getWebDriver().getTitle();
        assertTrue(pageTitleLogin.contains("Login"));
        logger.info("User stays on the Login page");
        loginPage.userLogin("1234", "full");
        Assert.assertEquals("Invalid login attempt. Wrong credentials ?", loginPage.getInvalidLoginAttemptErrorMessageText());
        String pageTitle = DriverManager.getWebDriver().getTitle();
        assertTrue(pageTitle.contains("Login"));
        logger.info("User stays on the Login page");
        }


    @Test
    public void LoginWithEmptyUsernameAndPasswordFields() {
        LoginPage loginPage = new LoginPage();
        loginPage.userLogin("", "full");
        Assert.assertEquals("Username is required", loginPage.getUsernameIsRequiredErrorMessageText());
        String pageTitleLogin = DriverManager.getWebDriver().getTitle();
        assertTrue(pageTitleLogin.contains("Login"));
        logger.info("User stays on the Login page");
        loginPage.userLogin("full", "");
        Assert.assertEquals("Password is required", loginPage.getPasswordIsRequiredErrorMessageText());
        String pageTitle = DriverManager.getWebDriver().getTitle();
        assertTrue(pageTitle.contains("Login"));
        logger.info("User stays on the Login page");
    }

    @Test
    public void successfulLoginWithForeignCharacters() {
        LoginPage loginPage = new LoginPage();
        loginPage.userLogin("ausländisch", "ausländisch");
        String pageTitleCatalog = DriverManager.getWebDriver().getTitle();
        assertTrue(pageTitleCatalog.contains("Applications"));
        logger.info("Applications page is opened");
        }


}


