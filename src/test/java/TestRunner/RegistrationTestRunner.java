package TestRunner;

import config.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;

import java.time.Duration;

public class RegistrationTestRunner extends Setup {
    @Test
    public void userRegistration() throws InterruptedException {
        RegistrationPage userReg = new RegistrationPage(driver);
        userReg.btnRegister.click();
        String firstname = "Taraa";
        String lastname = "sho";
        String email = "tarasho1234@gmail.com";
        String password = "1234";
        String phonenumber = "01298457890";
        String address = "Mirpur, Dhaka";
        userReg.doRegistration(firstname, lastname, email, password, phonenumber, address);

        Thread.sleep(4000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Toastify__toast")));
        String successActual = driver.findElement(By.className("Toastify__toast")).getText();
        String successExpected = "successfully!";
        System.out.println(successActual);
        Assert.assertTrue(successActual.contains(successExpected));
    }
}
