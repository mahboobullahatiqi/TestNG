package tek.sdet.testng.tests.smoke;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek.sdet.testng.base.BaseUITest;
import tek.sdet.testng.config.POMFactory;


public class DataProviderWithArrayExample extends BaseUITest {
	private POMFactory factory;

	@BeforeMethod
	public void initialTest() {
		this.factory = new POMFactory();
	}

	@Test(testName = "Successful Login with CSR account")
	public void loginWithHardCodingTestdata() {
		factory.csrLogin().login("supervisor", "tek_supervisor");
		String title = getElementText(this.factory.homePage().AppTitle);
		Assert.assertEquals(title, "TEK Insurance Portal");
	}

	@Test(testName = "Invalid Login Error message Test. ", dataProvider = "invalidTestData")
	public void loginWithArrayExample(String username, String password, String expectedError) {
		this.factory.csrLogin().login(username, password);
		String errorMessage = this.factory.csrLogin().getErrorMessage();
		Assert.assertEquals(errorMessage, expectedError);
	}

	@DataProvider(name = "invalidTestData")
	public Object[][] invalidTestData() {
		String[][] testData = { { "supervisor", "tek_supervisor1", "Password Not Matched" },
				{ "supervisor1", "tek_supervisor", "User not found" } };
		return testData;
	}
}
