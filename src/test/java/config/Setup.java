package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
import org.testng.annotations.AfterTest;
>>>>>>> 04c842f (Updated new)
>>>>>>> 2c42c66 (Upload new code)
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class Setup {
    public WebDriver driver;

<<<<<<< HEAD
    @BeforeTest
=======
<<<<<<< HEAD
    @BeforeTest
=======
    @BeforeTest(groups = "smoke")
>>>>>>> 04c842f (Updated new)
>>>>>>> 2c42c66 (Upload new code)
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://dailyfinance.roadtocareer.net/");
    }



<<<<<<< HEAD
    //@AfterTest
=======
<<<<<<< HEAD
    //@AfterTest
=======
   @AfterTest(groups = "smoke")
>>>>>>> 04c842f (Updated new)
>>>>>>> 2c42c66 (Upload new code)
    public void closeDriver() {
        driver.quit();
    }
}
