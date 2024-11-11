package pages;

import config.UserModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegistrationPage {

    @FindBy(css = "a[href='/register']")
    public WebElement btnRegister;

    @FindBy(id = "firstName")
    public WebElement txtFirstName;

    @FindBy(id = "lastName")
    public WebElement txtLastName;

    @FindBy(id = "email")
    public WebElement txtEmail;

    @FindBy(id = "password")
    public WebElement txtPassword;

    @FindBy(id = "phoneNumber")
    public WebElement txtPhoneNumber;

    @FindBy(id = "address")
    public WebElement txtAddress;

    @FindBy(css = "[type=radio]")
    List<WebElement> btnGender;

    @FindBy(css = "[type=checkbox]")
    public WebElement chkAccept;

    @FindBy(id = "register")
    public WebElement btnSubmitReg;

    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void doRegistration(UserModel userModel) throws InterruptedException {

        txtFirstName.sendKeys(userModel.getFirstname());
        txtLastName.sendKeys(userModel.getLastname()!=null? userModel.getLastname() : "");
        txtEmail.sendKeys(userModel.getEmail());
        txtPassword.sendKeys(userModel.getPassword());
        txtPhoneNumber.sendKeys(userModel.getPhonenumber());
        txtAddress.sendKeys(userModel.getAddress()!=null? userModel.getAddress() : "");
        btnGender.get(1).click();
        chkAccept.click();

<<<<<<< HEAD
        Thread.sleep(5000);
=======
<<<<<<< HEAD
        Thread.sleep(5000);
=======
        Thread.sleep(3000);
>>>>>>> 04c842f (Updated new)
>>>>>>> 2c42c66 (Upload new code)
        btnSubmitReg.click();

    }


}
