package page.objects;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;



public class LoginPage {

    private Logger logger = LogManager.getLogger(LoginPage.class);

    @FindBy(id ="UserName")
    private WebElement usernameField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//section[@id='loginForm']/preceding-sibling::h2")
    private WebElement loginFormHeading;

    @FindBy(xpath = "//input[@id='RememberMe']")
    private WebElement rememberMeCheckbox;

    @FindBy(xpath = "//input[@id='RememberMe']/following-sibling::label[@for='RememberMe']")
    private WebElement rememberMeCheckboxText;

    @FindBy(xpath = "//p/a[@href='/Centro/Account/PasswordForgot']")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//p/a[@href='/Centro/Account/Register']")
    private WebElement registerLink;

    @FindBy(xpath = "//input[@id = 'hdnValue']/preceding-sibling::p")
    private WebElement registerLinkText;

    @FindBy(xpath = "//div[@class='validation-summary-errors']/ul/li")
    private WebElement invalidLoginAttemptErrorMessage;

    @FindBy(xpath = "//div/span[@data-valmsg-for='UserName']")
    private WebElement usernameIsRequiredErrorMessage;

    @FindBy(xpath = "//div/span[@data-valmsg-for='Password']")
    private WebElement passwordIsRequiredErrorMessage;


    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }


    public String getLoginFormHeadingText() {
        String text = loginFormHeading.getText();
        logger.info("login  form header is: " + text);
        return text;
    }

    public boolean rememberMeCheckboxIsPresented () {
        WaitForElement.waitUntilElementIsVisible(rememberMeCheckbox);
        boolean checkboxIsDisplayed = rememberMeCheckbox.isDisplayed();
        logger.info("Remember checkbox is presented: " + checkboxIsDisplayed);
        return checkboxIsDisplayed;
    }

    public String getRememberMeCheckboxText () {
        WaitForElement.waitUntilElementIsVisible(rememberMeCheckbox);
        String text = rememberMeCheckboxText.getText();
        logger.info("Remember me text is: " + text);
        return text;
    }

    public boolean forgotPasswordLinkIsPresented () {
        WaitForElement.waitUntilElementIsVisible(forgotPasswordLink);
        boolean forgotPasswordLinkIsDisplayed = forgotPasswordLink.isDisplayed();
        logger.info("Forgot your password link is displayed: "+ forgotPasswordLinkIsDisplayed);
        return forgotPasswordLinkIsDisplayed;
    }

    public boolean  registerLinkIsPresented() {
        WaitForElement.waitUntilElementIsVisible(registerLink);
        boolean registerLinkIsDisplayed = registerLink.isDisplayed();
        logger.info("Register link is displayed: " + registerLinkIsDisplayed);
        return registerLinkIsDisplayed;
    }

    public String getRegisterLinkText () {
        WaitForElement.waitUntilElementIsVisible(registerLink);
        String text = registerLinkText.getText();
        logger.info("Register link text is: " + text);
        return text;
    }

    public void typeIntoUsernameField(String username) {
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.click();
        usernameField.clear();
        usernameField.sendKeys(username);
        logger.info("The username " + username +" is typed");
    }

    public void typeIntoPasswordField(String password) {
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
        logger.info("The password " + password + " is typed");
    }

    public void clickOnLoginButton() {
        WaitForElement.waitUntilElementIsClickable(loginButton);
        loginButton.click();
        logger.info("Login button is clicked");
    }

    public void userLogin(String username, String password) {
        typeIntoUsernameField(username);
        typeIntoPasswordField(password);
        clickOnLoginButton();
    }

    public String getInvalidLoginAttemptErrorMessageText () {
        String text = invalidLoginAttemptErrorMessage.getText();
        logger.info("Error message text for invalid login attempt is: " + text);
        return text;
    }

    public String getUsernameIsRequiredErrorMessageText () {
        String text = usernameIsRequiredErrorMessage.getText();
        logger.info("Error message text for empty username filed is: " + text);
        return text;
    }

    public String getPasswordIsRequiredErrorMessageText () {
        String text = passwordIsRequiredErrorMessage.getText();
        logger.info("Error message text for empty password filed is: " + text);
        return text;
    }

    public void clickOnRememberMeCheckbox() {
        WaitForElement.waitUntilElementIsClickable(rememberMeCheckbox);
        rememberMeCheckbox.click();
        logger.info("Remember me checkbox is clicked");
    }

    public void checkIfUsernameFieldIsEmptyOrNot (WebDriver driver) {
        String textInsideInputBox = usernameField.getAttribute("value");
        if(textInsideInputBox.isEmpty()) {
            System.out.println("the username field is empty");
        }
        else {
        System.out.println("the username field is not empty. The value is:" + textInsideInputBox);
        }
    }



}
