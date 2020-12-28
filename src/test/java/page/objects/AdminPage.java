package page.objects;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class AdminPage {

    private Logger logger = LogManager.getLogger(LoginPage.class);

    @FindBy(xpath = "//div/table/tbody/tr[@ng-include]")
    private List<WebElement> usersTableRaws;

    @FindBy (xpath = "//span/i[@class='fa fa-home']")
    private List<WebElement> localAccountImageUsersTable;




    public AdminPage() {
            PageFactory.initElements(DriverManager.getWebDriver(), this);
    }




    public String getUserRole(String usernameTest) {
        WaitForElement.waitUntilElementsAreVisible(localAccountImageUsersTable);

          for (WebElement item: usersTableRaws) {
              WebElement usernameColumn = item.findElement(By.cssSelector("table > tbody > tr[ng-include] > td:nth-child(2)"));
              String username = usernameColumn.getText();

              if (username.equals(usernameTest)) {
                  WebElement userRoleColumn = item.findElement(By.xpath("//div/table/tbody/tr[@ng-include]/td[@style]/div/span[@ng-if]"));
                  String userRole = userRoleColumn.getText();
                  logger.info("User role is: " + userRole);
                  return userRole;
              }
          }

      return null;
    }


}
