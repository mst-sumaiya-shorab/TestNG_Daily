package TestRunner;

import config.Setup;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.FileReader;
import java.io.IOException;

public class LoginTestRunner extends Setup {
    LoginPage loginPage;
    @Test(priority = 1, description = "Admin login with wrong password", groups = "smoke")

    public void adminLoginWrongPass() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.doLogin("admin@test.com", "wrongpass");
        String errorMessageActual = driver.findElement(By.tagName("p")).getText();
        String errorMessageExpected = "Invalid";
        Assert.assertTrue(errorMessageActual.contains(errorMessageExpected));


        clearCreds();
        Thread.sleep(3000);
    }

    @Test(priority = 2, description = "Admin login with right password", groups = "smoke")
    public void adminLogin() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.doLogin("admin@test.com", "admin123");
        String headerActual = driver.findElement(By.tagName("h2")).getText();
        String headExpected = "Admin Dashboard";
        Assert.assertTrue(headerActual.contains(headExpected));

        Thread.sleep(5000);
        loginPage.doLogout();
    }

    @Test(priority = 3, description = "User can login with correct creds")
    public void userLogin() throws ParseException, IOException, InterruptedException {
        loginPage = new LoginPage(driver);
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("./src/test/resources/users.json"));

        JSONObject userObj = (JSONObject) jsonArray.get(jsonArray.size() - 1);
        String email = (String) userObj.get("email");
        String password = (String) userObj.get("password");

        loginPage.doLogin(email, password);
        Assert.assertTrue(loginPage.btnProfileIcon.isDisplayed());

        Thread.sleep(5000);
        loginPage.doLogout();

    }


    public void clearCreds() {
        loginPage = new LoginPage(driver);
        loginPage.txtEmail.sendKeys(Keys.CONTROL, "a");
        loginPage.txtEmail.sendKeys(Keys.BACK_SPACE);

        loginPage.txtPassword.sendKeys(Keys.CONTROL, "a");
        loginPage.txtPassword.sendKeys(Keys.BACK_SPACE);

    }
}
