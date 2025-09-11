package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegisterPage;

public class RegisterTest {
	 WebDriver driver;
	 WebDriverWait wait;
	 RegisterPage registerpage;
	 
	 
	 @BeforeClass
	    public void setup() {
	        System.setProperty("webdriver.chrome.driver","D:\\chromedriver-win64\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.get("https://demowebshop.tricentis.com/register");
	        registerpage = new RegisterPage(driver);
	        driver.manage().window().maximize();
	    }
	
	 @Test
	    public void validsuccessfulRegister() {
		 registerpage.selectMaleGender();
		 registerpage.enterFirstName("rrr");
		 registerpage.enterLastName("eee");
		 registerpage.enterEmail("bnh.r2rrrrm2@gmail.com");
		 registerpage.enterPassword("2255r88");
		 registerpage.enterConfirmPassword("2255r88");
		 registerpage.clickRegister();
		 
		 Assert.assertTrue(registerpage.seeSuccessMessage(),"be successfull");
	             
    }
	 
	 @AfterClass
	    public void teardown() {
	        driver.quit();
	    }
	
    

}
