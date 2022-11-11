package tek.sdet.testng.tests.smoke;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tek.sdet.testng.base.BaseUITest;
import tek.sdet.testng.config.POMFactory;

public class TestNGParameterExample extends BaseUITest {
	
	private POMFactory factory;

	@BeforeMethod
	public void initialTest() {
		this.factory = new POMFactory();
	}

	@Test(testName = "Successful Login with CSR account")
	@Parameters({"username", "password"})
	public void loginWithParametersExample(String username, String password) {
		factory.csrLogin().login(username, password);
		String title = getElementText(this.factory.homePage().AppTitle);
		Assert.assertEquals(title, "TEK Insurance Portal");
	}

}
