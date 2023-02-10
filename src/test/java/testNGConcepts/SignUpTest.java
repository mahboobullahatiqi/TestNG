package testNGConcepts;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import tek.sdet.testng.utilities.ExcelReader;

public class SignUpTest {
	WebDriver driver;
	@BeforeMethod
public void beforeMethod () {
	   WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	    driver.get("https://tek-retail-ui.azurewebsites.net/auth/sign-up");
	    
	}
	@Test(dataProvider="testInput")
	 public void testSignUp(String nameValue, String emailValue,String passValue, String confirmPassValue) throws InterruptedException {
        driver.findElement(By.id("nameInput")).sendKeys(nameValue);
        driver.findElement(By.id("emailInput")).sendKeys(emailValue);
        driver.findElement(By.id("passwordInput")).sendKeys(passValue);
        driver.findElement(By.id("confirmPasswordInput")).sendKeys(confirmPassValue);
        Thread.sleep(5000);
        driver.close();
	}

	   @DataProvider(name ="testInput")
	    public Object[][]signUpData() throws IOException{
	        String path =".\\src\\test\\resources\\testData\\signup.xlsx"; // this is path 
	        List<Map<String, String>> data = ExcelReader.readSheetWithFirstRowAsHeader
	                (ExcelReader.getExcelSheet(path, 0));
	        Object[][] object = new Object[data.size()][data.get(0).size()];
	        for(int i =0; i<object.length;i++) {
	            object[i][0]= data.get(i).get("name");
	            object[i][1]= data.get(i).get("email");
	            object[i][2]= data.get(i).get("password");
	            object[i][3]= data.get(i).get("confirmPassword");
	        }
	        return object;
	    }
	
}
