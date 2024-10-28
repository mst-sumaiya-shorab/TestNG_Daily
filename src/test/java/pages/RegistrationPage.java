package pages;

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

    public void doRegistration(String firstname, String lastname, String email, String password, String phonenumber, String address) {

        txtFirstName.sendKeys(firstname);
        txtLastName.sendKeys(lastname);
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        txtPhoneNumber.sendKeys(phonenumber);
        txtAddress.sendKeys(address);
        btnGender.get(1).click();
        chkAccept.click();
        btnSubmitReg.click();

    }


}
