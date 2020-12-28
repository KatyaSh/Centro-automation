package page.objects;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class RegisterPage {

    private Logger logger = LogManager.getLogger(LoginPage.class);

    @FindBy (xpath = "//div[@class='panel panel-default panel-body']/h2")
    private WebElement registerFormHeader;

    @FindBy (xpath = "//form[@role='form']/h4")
    private WebElement registerFormHeaderText;

    @FindBy(id="UserName")
    private WebElement usernameField;

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "DisplayName")
    private WebElement nameField;

    @FindBy(id = "DisplayName")
    private WebElement displayNameField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(id = "RememberBrowser")
    private WebElement rememberMeCheckbox;

    @FindBy(xpath = "//input[@id = 'RememberBrowser']/following-sibling::label")
    private WebElement rememberMeCheckboxText;

    @FindBy(xpath = "//input[@type ='submit']")
    private WebElement registerButton;

    @FindBy(xpath ="//span[@data-valmsg-for='UserName']")
    private WebElement usernameIsRequiredErrorMessage;

    @FindBy(xpath ="//span[@data-valmsg-for='Email']")
    private WebElement emailAddressIsRequiredErrorMessage;

    @FindBy(xpath ="//span[@data-valmsg-for='DisplayName']")
    private WebElement displayNameIsRequiredErrorMessage;

    @FindBy(xpath ="//span[@data-valmsg-for='Password']")
    private WebElement passwordIsRequiredErrorMessage;

    @FindBy(xpath ="//span[@data-valmsg-for='ConfirmPassword']")
    private WebElement passwordsEnteredDoNotMatchErrorMessage;

    @FindBy(xpath = "//div[@class='validation-summary-errors']/ul/li")
    private WebElement usernameAndPasswordErrorsValidationMessage;


    public RegisterPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public String getRegisterFormHeaderText() {
        String text = registerFormHeader.getText();
        logger.info("Register form header is: " + text);
        return text;
    }

    public String getRegisterHeadingText() {
        String text = registerFormHeaderText.getText();
        logger.info("Register form header text is: " + text);
        return text;
    }

    public boolean rememberMeCheckboxIsPresented() {
        WaitForElement.waitUntilElementIsVisible(rememberMeCheckbox);
        boolean checkboxIsDisplayed = rememberMeCheckbox.isDisplayed();
        logger.info("Remember checkbox is presented: " + checkboxIsDisplayed);
        return checkboxIsDisplayed;
    }

    public String getRememberMeCheckboxText() {
        WaitForElement.waitUntilElementIsVisible(rememberMeCheckbox);
        String text = rememberMeCheckboxText.getText();
        logger.info("Remember me text is: " + text);
        return text;
    }

    public void typeIntoUsernameField(String username) {
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.click();
        usernameField.clear();
        usernameField.sendKeys(username);
        logger.info("The username " + username +" is typed");
    }

    public void typeIntoEmailField(String email) {
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
        logger.info("The email " + email + " is typed");
    }

    public void typeIntoNameField(String name) {
        displayNameField.click();
        displayNameField.clear();
        displayNameField.sendKeys(name);
        logger.info("The displayed name " + name + " is typed");
    }

    public void typeIntoPasswordField(String password) {
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
        logger.info("The password " + password + " is typed");
    }

    public void typeIntoConfirmPasswordField(String password) {
        confirmPasswordField.click();
        confirmPasswordField.clear();
        confirmPasswordField.sendKeys(password);
        logger.info("The confirm password " + password + " is typed");
    }

    public void clickOnRegisterButton() {
        WaitForElement.waitUntilElementIsClickable(registerButton);
        registerButton.click();
        logger.info("Register button is clicked");
    }

    public void userRegistration(String username, String email, String name, String password, String confirmPassword) {
        WaitForElement.waitUntilElementIsVisible(registerButton);
        typeIntoUsernameField(username);
        typeIntoEmailField(email);
        typeIntoNameField(name);
        typeIntoPasswordField(password);
        typeIntoConfirmPasswordField(confirmPassword);
        clickOnRegisterButton();
    }







}
