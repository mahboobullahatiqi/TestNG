package tek.sdet.testng.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.testng.utilities.CommonUtility;

public class CSRHomePage extends CommonUtility {
    public CSRHomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//mat-toolbar/span[text()='TEK Insurance Portal']")
    public WebElement AppTitle;

    @FindBy(xpath = "//mat-toolbar/button[2]")
    public WebElement profileMenu;

    @FindBy(id = "logout")
    public WebElement logoutButton;
    
    @FindBy(xpath = "//span[text()='Accounts']")
    public WebElement accountsBttn;
    
    @FindBy(xpath = "//table//tr//th")
    public List<WebElement> tableHeaders;

    public void logout() {
        click(profileMenu);
        click(logoutButton);
    }
}
