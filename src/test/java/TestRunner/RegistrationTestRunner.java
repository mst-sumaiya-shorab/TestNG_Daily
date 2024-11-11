package TestRunner;

import com.github.javafaker.Faker;
import config.Setup;
import config.UserModel;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utils.Utils;

import java.io.IOException;
import java.time.Duration;

public class RegistrationTestRunner extends Setup {

//    @Test(priority = 1, description = "User can register by providing all info without dynamic", enabled = false)
//
//    public void userRegistration() throws InterruptedException, IOException, ParseException {
//        RegistrationPage userReg = new RegistrationPage(driver);
//        Faker faker = new Faker();
//        userReg.btnRegister.click();
//        String firstname = faker.name().firstName();
//        String lastname = faker.name().lastName();
//        String email = faker.internet().emailAddress();
//        String password = "1234";
//        String phonenumber = "01234" + Utils.generateRandomNumber(100000, 999999);
//        String address = faker.address().fullAddress();
//        userReg.doRegistration(firstname, lastname, email, password, phonenumber, address);
//
//        Thread.sleep(4000);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Toastify__toast")));
//        String successActual = driver.findElement(By.className("Toastify__toast")).getText();
//        String successExpected = "successfully!";
//        System.out.println(successActual);
//        Assert.assertTrue(successActual.contains(successExpected));
//
//        JSONObject userObj = new JSONObject();
//        userObj.put("firstName", firstname);
//        userObj.put("lastName", lastname);
//        userObj.put("email", email);
//        userObj.put("password", password);
//        userObj.put("phoneNumber", phonenumber);
//        userObj.put("address", address);
//
//        Utils.saveUserInfo("./src/test/resources/users.json", userObj);
//    }

    @Test(priority = 1, description = "User can register by dynamic all info", groups = "smoke")

    public void userRegDynamic() throws InterruptedException, IOException, ParseException {
        RegistrationPage userReg = new RegistrationPage(driver);
        Faker faker = new Faker();
        userReg.btnRegister.click();
        String firstname = faker.name().firstName();
        String lastname = faker.name().lastName();

        String email = faker.internet().emailAddress();

        String email =  Utils.generateRandomName() + "@gmail.com";

        String password = "1234";
        String phonenumber = "01234" + Utils.generateRandomNumber(100000, 999999);
        String address = faker.address().fullAddress();

        UserModel userModel = new UserModel();
        userModel.setFirstname(firstname);
        userModel.setLastname(lastname);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setPhonenumber(phonenumber);
        userModel.setAddress(address);
        userReg.doRegistration(userModel);


        doRegAssertion();

        JSONObject userObj = new JSONObject();
        userObj.put("firstName", firstname);
        userObj.put("lastName", lastname);
        userObj.put("email", email);
        userObj.put("password", password);
        userObj.put("phoneNumber", phonenumber);
        userObj.put("address", address);


        Utils.saveUserInfo("./src/test/resources/users.json", userObj);
        Thread.sleep(5000);

    }


    @Test(priority = 2, description = "User can register only Mandatory Fields")

    public void userRegMandatoryFields() throws InterruptedException, IOException, ParseException {


        RegistrationPage userReg = new RegistrationPage(driver);
        Faker faker = new Faker();
        userReg.btnRegister.click();
        String firstname = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String email = Utils.generateRandomName() + "@gmail.com";

        String password = "1234";
        String phonenumber = "01234" + Utils.generateRandomNumber(100000, 999999);


        UserModel userModel = new UserModel();
        userModel.setFirstname(firstname);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setPhonenumber(phonenumber);
        userReg.doRegistration(userModel);

        doRegAssertion();

        JSONObject userObj = new JSONObject();
        userObj.put("firstName", firstname);
        userObj.put("email", email);
        userObj.put("password", password);
        userObj.put("phoneNumber", phonenumber);

        Utils.saveUserInfo("./src/test/resources/users.json", userObj);

    }

    public void doRegAssertion() throws InterruptedException {

        Thread.sleep(4000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Toastify__toast")));
        String successActual = driver.findElement(By.className("Toastify__toast")).getText();
        String successExpected = "successfully!";
        System.out.println(successActual);
        Assert.assertTrue(successActual.contains(successExpected));
    }
}
