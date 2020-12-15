package tests;

import driver.DriverManager;
import org.testng.annotations.Test;
import page.objects.LoginPage;
import static org.testng.Assert.assertTrue;



public class LoginPositiveTests extends TestBase {


        @Test
        public void successfulLoginAsFullUser() throws InterruptedException {
            LoginPage loginPage = new LoginPage();
            loginPage.typeIntoUsernameField("full");
            loginPage.typeIntoPasswordField("full");
            loginPage.clickOnLoginButton();
            String pageTitle = DriverManager.getWebDriver().getTitle();
            assertTrue(pageTitle.contains("Catalog"));
        }

}


