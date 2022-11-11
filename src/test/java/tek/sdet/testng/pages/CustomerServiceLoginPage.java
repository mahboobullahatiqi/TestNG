package tek.sdet.testng.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.testng.utilities.CommonUtility;

public class CustomerServiceLoginPage extends CommonUtility {
    public CustomerServiceLoginPage() {
        PageFactory.initElements(getDriver(), this);
    }


    @FindBy(id = "mat-input-0")
    public WebElement usernameInput;

    @FindBy(id = "mat-input-1")
    public WebElement passwordInput;

    @FindBy(xpath = "//span[contains(text(),'CSR Portal')]/..")
    public WebElement csrPortalLink;

    @FindBy(xpath = "//app-banner/div[contains(@class,'error')]")
    public WebElement errorMessage;
    @FindBy(id = "loginButton")
    public WebElement loginButton;


    public void login(String username, String password) {
       // click(csrPortalLink);
        sendText(usernameInput, username);
        sendText(passwordInput, password);
        click(loginButton);
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
