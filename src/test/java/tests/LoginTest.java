
package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTest {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;

    @BeforeClass(groups = {"smoke","regression"})
    public void setup() {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/login");
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
    }

    
    @Test(groups = {"smoke", "regression"})
    public void validtestLogin() {
        loginPage.enterEmail("bahareh.r2m2@gmail.com");
        loginPage.enterPassword("123456");
        
        HomePage homePage = loginPage.clickLogin();

        Assert.assertTrue(homePage.isLogoutVisible(), "کاربر باید لاگین شده باشد");
    }
    
    @Test(groups = {"regression"})           
    public void invalidtestLogin() {
        loginPage.enterEmail("invalid@gmail.com");
        loginPage.enterPassword("000");
        loginPage.clickLoginExpectingFailure();
        
        Assert.assertTrue(loginPage.isLoginErrorVisible(), "Erroe message should be shown");
        
    }

    @AfterClass(groups = {"smoke","regression"})
    public void teardown() {
        driver.quit();
    }
}
