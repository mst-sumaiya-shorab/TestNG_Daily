package TestRunner;

import config.Setup;
import pages.LoginPage;
import utils.Utils;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;


import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.json.simple.parser.ParseException;
import java.io.IOException;

public class ProfileTestRunner extends Setup {
    @Test(priority = 1)
    public void doLogin() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("sara1234@gmail.com", "1234");
        Utils.getToken(driver);
    }
    @BeforeTest
    public void setToken() throws ParseException, IOException, InterruptedException{
        Utils.setAuth(driver);
    }

    @Test(priority = 2)
    public void seeProfile() {
        driver.get("https://dailyfinance.roadtocareer.net/user");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.btnProfileIcon.click();
        loginPage.btnProfileMenus.get(0).click();
    }
}
