package TestRunner;

import config.Setup;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.json.simple.parser.ParseException;
import pages.DashboardPage;
import pages.LoginPage;

import java.io.FileReader;
import java.io.IOException;

public class DashboardTestRunner extends Setup {

    @BeforeTest
    public void doLogin() throws IOException, ParseException, InterruptedException{

        LoginPage loginPage = new LoginPage(driver);
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("./src/test/resources/users.json"));

        JSONObject userObj = (JSONObject) jsonArray.get(jsonArray.size() - 1);
        String email = (String) userObj.get("email");
        String password = (String) userObj.get("password");

        if(System.getProperty("username")!=null && System.getProperty("password")!=null){
            loginPage.doLogin(System.getProperty("username"), System.getProperty("password"));
        }
        else{
            loginPage.doLogin(email,password);
        }

//       loginPage.doLogin("sara1234@gmail.com", "1234");
        Thread.sleep(3000);
    }

    @Test(priority = 1, description = "Add cost for an item")
    public void addCost() throws InterruptedException {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.btnAddCost.click();
        dashboardPage.addCost("Test Item", "100", "Fresh");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

    }
}
