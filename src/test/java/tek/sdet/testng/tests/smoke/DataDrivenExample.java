package tek.sdet.testng.tests.smoke;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import tek.sdet.testng.base.BaseUITest;
import tek.sdet.testng.utilities.ExcelReader;

public class DataDrivenExample extends BaseUITest {
	@Test @DataProvider(name = "loginToInsuranceApp")
	public void addClients (String email, String password) throws InterruptedException {
		
		getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("email");
		getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys("password");
		getDriver().findElement(By.xpath("//span[text()='Login']")).click();
		Thread.sleep(3000);
		getDriver().findElement(By.xpath("//span[text()='Accounts']")).click();
		getDriver().findElement(By.xpath("//button[@color='primary']")).click();
		Thread.sleep(3000);
		getDriver().findElement(By.xpath("//input[@name='email']")).click();
		Thread.sleep(3000);
		getDriver().findElement(By.xpath("//mat-select[@name='title']")).click();
	}
		
	@DataProvider(name = "loginToInsuranceApp")
		public Object[][] registerInfo() throws IOException{
		
			String filePath = ".\\src\\test\\resources\\testData\\xl sheet.xlsx";
			List<Map<String, String>> temp = ExcelReader.readSheetWithFirstRowAsHeader(ExcelReader.getExcelSheet(filePath, 0));
			Object[][] obj = new Object[temp.size()][temp.get(0).size()];
			for (int i = 0; i < obj.length; i++) {
				obj[i][0] = temp.get(i).get("email");
				obj[i][1] = temp.get(i).get("title");
				obj[i][2] = temp.get(i).get("firstName");
				obj[i][3] = temp.get(i).get("lastName");
			}
			return obj;
		}

}
