package tek.sdet.testng.tests.smoke;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek.sdet.testng.base.BaseUITest;
import tek.sdet.testng.config.POMFactory;
import tek.sdet.testng.utilities.ExcelReader;

public class DataProviderWithExcelExample extends BaseUITest {
	private POMFactory factory;

	@BeforeMethod
	public void initialTest() {
		this.factory = new POMFactory();
	}
	
	@Test(testName = "Successfully Login to App", dataProvider = "loginToInsuranceApp")
	public void loginWithExcelExample(String username, String password) {
		factory.csrLogin().login(username, password);
		String title = getElementText(this.factory.homePage().AppTitle);
		Assert.assertEquals(title, "TEK Insurance Portal");
	}
	
	@DataProvider(name = "loginToInsuranceApp")
	public Object[][] registerInfo() throws IOException{
		String filePath = ".\\src\\test\\resources\\testData\\Login Credentials.xlsx";
		List<Map<String, String>> temp = ExcelReader.readSheetWithFirstRowAsHeader(ExcelReader.getExcelSheet(filePath, 0));
		Object[][] obj = new Object[temp.size()][temp.get(0).size()];
		for (int i = 0; i < obj.length; i++) {
			obj[i][0] = temp.get(i).get("Username");
			obj[i][1] = temp.get(i).get("Password");
		}
		return obj;
	}
}
