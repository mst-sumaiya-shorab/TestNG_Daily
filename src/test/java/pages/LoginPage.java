package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {
    @FindBy(id = "email")
    public WebElement txtEmail;

    @FindBy(id = "password")
    public WebElement txtPassword;

    @FindBy(css = "button[type='submit']")
    public WebElement btnLogin;

    @FindBy(css = "[data-testid=AccountCircleIcon]")
    public WebElement btnProfileIcon;

    @FindBy(css = "[role=menuitem]")
    public List<WebElement> btnProfileMenus;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void doLogin(String email, String password) {
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnLogin.click();
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
  //      doLogout();
>>>>>>> 04c842f (Updated new)
>>>>>>> 2c42c66 (Upload new code)
    }

    public void doLogout() {
        btnProfileIcon.click();
        btnProfileMenus.get(1).click();

    }
}
