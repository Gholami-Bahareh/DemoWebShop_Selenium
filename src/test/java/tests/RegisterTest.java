package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.RegisterPage;
import utils.Utilities;

public class RegisterTest {
	 WebDriver driver;
	 WebDriverWait wait;
	 RegisterPage registerpage;
	 Utilities utilities;
	 
	 String email;
	 

	
	//بررسی اعتبار ایمیل یا پسورد (مثلاً کوتاه بودن یا بدون کاراکتر خاص)
	//انتخاب جنسیت و اطمینان از اینکه سیستم انتخاب رو درست ثبت می‌کنه
	//بررسی اینکه دکمه ثبت فعال یا غیر فعال باشه در شرایط مختلف
	//تست رفتار فرم بعد از ثبت (مثل پیام موفقیت یا ریدایرکت)
	    
	 
	 @BeforeClass
	    public void setup() {
	        System.setProperty("webdriver.chrome.driver","D:\\chromedriver-win64\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        
	        	    }
	 
	 @BeforeMethod
	    public void generateEmail() {
		 driver.get("https://demowebshop.tricentis.com/register");
	     registerpage = new RegisterPage(driver);
		 email= Utilities.randomEmail(); 
	 }
	
	 @Test(groups = {"smoke","regression"})
	    public void validsuccessfulMaleRegister() {
		 registerpage.selectMaleGender();
		 registerpage.enterFirstName("rrr");
		 registerpage.enterLastName("eee");
		 registerpage.enterEmail(email);
		 registerpage.enterPassword("2255r88");
		 registerpage.enterConfirmPassword("2255r88");
		 registerpage.clickRegister();
		 
		 String expectedUrl = "https://demowebshop.tricentis.com/registerresult/1";
		 
		 Assert.assertTrue(registerpage.seeSuccessMessage(),"be successfull");
		 Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Redirected to new page"); //what if the URL changes?? ;)
		 
	             
    }
	 @Test(groups = {"regression"})
	    public void validsuccessfulFemaleRegister() {
		 registerpage.selectFemaleGender();
		 registerpage.enterFirstName("rrr");
		 registerpage.enterLastName("eee");
		 registerpage.enterEmail(email);
		 registerpage.enterPassword("2255r88");
		 registerpage.enterConfirmPassword("2255r88");
		 registerpage.clickRegister();
		 
		 Assert.assertTrue(registerpage.seeSuccessMessage(),"be successfull");
		 Assert.assertTrue(driver.getCurrentUrl().contains("registerresult"), "Url contains 'registerresult'");
	             
     }
	 @Test(groups = {"regression"})
	   public void registerWithDuplicateEmail() {
		// --- Arrange:first time register
		 registerpage.selectFemaleGender();
		 registerpage.enterFirstName("rrr");
		 registerpage.enterLastName("eee");
		 registerpage.enterEmail(email);
		 registerpage.enterPassword("2255r88");
		 registerpage.enterConfirmPassword("2255r88");
		 registerpage.clickRegister();

		// --- Act: register with duplicate email
		 driver.get("https://demowebshop.tricentis.com/register");
		 registerpage.enterFirstName("rrr");
		 registerpage.enterLastName("eee");
		 registerpage.enterEmail(email);
		 registerpage.enterPassword("2255r88");
		 registerpage.enterConfirmPassword("2255r88");
		 registerpage.clickRegister();
		 
		 // -- Assert: duplicate email error show
		 Assert.assertTrue(registerpage.isDuplicateEmailErrorVisible() ,"'The specified email already exists' should be visible");

	 }
	 
	 @Test(groups = {"regression"})
	   public void testEmptyRequiredFields() {
		 registerpage.clickRegister();
		 
		 Assert.assertTrue(registerpage.isFirstNameErrorVisible(), "ErrorMessageForFirstName should be visible");
		 Assert.assertTrue(registerpage.isLastNameErrorVisible(), "ErrorMessageForLastName should be visible");
		 Assert.assertTrue(registerpage.isEmailErrorVisible(), "ErrorMessageForEmail should be visible");
		 Assert.assertTrue(registerpage.isPasswordErrorVisible(), "ErrorMessageForPassword should be visible");
		 Assert.assertTrue(registerpage.isConfirmPasswordErrorVisible(), "ErrorMessageForConfirmPassword should be visible");
		 
	 }
	 
	 @AfterClass
	    public void teardown() {
	        driver.quit();
	    }
	
    

}
