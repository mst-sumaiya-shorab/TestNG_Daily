package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class Setup {
public WebDriver driver;

@BeforeTest(groups = "smoke")
public void setup() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    driver.get("https://dailyfinance.roadtocareer.net/");
}

@AfterTest(groups = "smoke")
public void closeDriver() {
    driver.quit();
}
}
