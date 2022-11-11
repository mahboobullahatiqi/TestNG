package tek.sdet.testng.tests.regression;

import com.aventstack.extentreports.service.ExtentTestManager;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tek.sdet.testng.base.BaseUITest;
import tek.sdet.testng.config.POMFactory;
import tek.sdet.testng.utilities.ExcelReader;

import java.io.IOException;

public class RegressionTest extends BaseUITest {

    private POMFactory factory;

    @BeforeMethod
    public void initialTest() {
        this.factory = new POMFactory();
    }

    @Test
    public void loginUsingDatabaseCredential() {
        //this will add extra detail to report. you can use info, pass, fail method base on situation you in.
        //adding additional detail to reports gave extra flexibility to others while reading the report only.
        ExtentTestManager.getTest().info("executing test loginUsingDatabaseCredential");
        var result = getDbUtility()
                .convertResultToMap("SELECT username, password FROM tek_insurance_app.user where account_type = 'CSR' limit 1;");
        String username = result.get(0).get("username").toString();
        String password = "tek_supervisor";

        factory.csrLogin().login(username, password);
        String title = getElementText(this.factory.homePage().AppTitle);

        Assert.assertEquals(title, "TEK Insurance Portal");
    }

    @Test
    public void loginTestWithReadingExcelSheet(){
        try {
            String filePath = System.getProperty("user.dir") + "/src/test/resources/test_data/user_detail.xlsx";
            Sheet sheet = ExcelReader.getExcelSheet(filePath, 0);
            var result=ExcelReader.readSheetWithFirstRowAsHeader(sheet);
            assert !result.isEmpty();
            String username =(String) result.get(0).get("username");
            String password = (String) result.get(0).get("password");

            factory.csrLogin().login(username, password);
            String title = getElementText(this.factory.homePage().AppTitle);

            Assert.assertEquals(title, "TEK Insurance Portal");

        }catch (IOException e) {
            ExtentTestManager.getTest().fail("Failed to Read Excel File " + e.getMessage());
            Assert.fail("Failed to Read Excel File");
        }catch (WebDriverException e) {
            ExtentTestManager.getTest().fail("Failed due to webDriver Exception " + e.getMessage());
            Assert.fail("Failed due to webDriver Exception");
        }
    }
}
