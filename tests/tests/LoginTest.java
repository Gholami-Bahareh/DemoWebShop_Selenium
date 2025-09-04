
package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver","D:\\213\\0 Real world Real job!\\Matherial for QA\\Java Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://demowebshop.tricentis.com/login");
        loginPage = new LoginPage(driver, wait);
    }

    @Test
    public void testLogin() {
        loginPage.enterEmail("test@example.com");
        loginPage.enterPassword("Password123");
        loginPage.clickLogin();
        // می‌تونی اینجا assert اضافه کنی برای بررسی اینکه HomePage باز شده
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
