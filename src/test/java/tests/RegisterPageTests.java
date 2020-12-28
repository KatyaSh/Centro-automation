package tests;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.AdminPage;
import page.objects.LoginPage;
import page.objects.RegisterPage;
import page.objects.TopBarMenu;
import waits.WaitForElement;

import static org.testng.Assert.assertTrue;

public class RegisterPageTests extends TestBase{

    private Logger logger = LogManager.getLogger(RegisterPage.class);

    @Test
    public void uiRegisterFormElementsOnRegisterPage() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickOnRegisterLink();
        String pageTitleLogin = DriverManager.getWebDriver().getTitle();
        assertTrue(pageTitleLogin.contains("Register"));
        RegisterPage registerPage = new RegisterPage();
        Assert.assertEquals("Register.",registerPage.getRegisterFormHeaderText());
        Assert.assertEquals("Create a new account.",registerPage.getRegisterHeadingText());
        Assert.assertTrue(registerPage.rememberMeCheckboxIsPresented());
        registerPage.getRememberMeCheckboxText();
    }

    @Test
    public void successfulRegistrationOfNewUser() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickOnRegisterLink();
        String pageTitleRegister = DriverManager.getWebDriver().getTitle();
        assertTrue(pageTitleRegister.contains("Register"));
        RegisterPage registerPage = new RegisterPage();
        registerPage.userRegistration("abc1", "abc@gmail.com", "abc", "1234567", "1234567");
        String pageTitleCatalog = DriverManager.getWebDriver().getTitle();
        assertTrue(pageTitleCatalog.contains("Applications"));
        logger.info("Applications page is opened");
        TopBarMenu topBarMenu = new TopBarMenu();
        topBarMenu.clickOnAdminLink();
        String pageTitleAdmin = DriverManager.getWebDriver().getTitle();
        assertTrue(pageTitleAdmin.contains("Administration"));
        AdminPage adminPage = new AdminPage();
        Assert.assertEquals(adminPage.getUserRole("abc1"), "Everyone");
    }









}
