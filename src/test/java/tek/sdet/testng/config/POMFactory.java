package tek.sdet.testng.config;

import tek.sdet.testng.base.BaseSetup;
import tek.sdet.testng.pages.CSRHomePage;
import tek.sdet.testng.pages.CustomerServiceLoginPage;

public class POMFactory extends BaseSetup {
    private CSRHomePage csrHomePage;
    private CustomerServiceLoginPage customerServiceLoginPage;

    public POMFactory() {
        this.csrHomePage = new CSRHomePage();
        this.customerServiceLoginPage = new CustomerServiceLoginPage();
    }

    public CSRHomePage homePage() {
        return this.csrHomePage;
    }

    public CustomerServiceLoginPage csrLogin() {
        return this.customerServiceLoginPage;
    }

}
