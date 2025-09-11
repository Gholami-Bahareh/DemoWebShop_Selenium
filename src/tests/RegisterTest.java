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
	 

	//پر کردن فرم با داده‌های درست و ثبت موفقیت‌آمیز
	//بررسی اینکه فیلدهای ضروری خالی باشن و خطا نمایش داده بشه
	//بررسی اعتبار ایمیل یا پسورد (مثلاً کوتاه بودن یا بدون کاراکتر خاص)
	//انتخاب جنسیت و اطمینان از اینکه سیستم انتخاب رو درست ثبت می‌کنه
	//بررسی اینکه دکمه ثبت فعال یا غیر فعال باشه در شرایط مختلف
	//تست رفتار فرم بعد از ثبت (مثل پیام موفقیت یا ریدایرکت)
	    
	 
	 @BeforeClass
	    public void setup() {
	        System.setProperty("webdriver.chrome.driver","D:\\chromedriver-win64\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.get("https://demowebshop.tricentis.com/register");
	        registerpage = new RegisterPage(driver);
	        driver.manage().window().maximize();
	    }
	 
	 @BeforeMethod
	    public void generateEmail() {
		 email= Utilities.randomEmail(); 
	 }
	
	 @Test
	    public void validsuccessfulMaleRegister() {
		 registerpage.selectMaleGender();
		 registerpage.enterFirstName("rrr");
		 registerpage.enterLastName("eee");
		 registerpage.enterEmail(email);
		 registerpage.enterPassword("2255r88");
		 registerpage.enterConfirmPassword("2255r88");
		 registerpage.clickRegister();
		 
		 Assert.assertTrue(registerpage.seeSuccessMessage(),"be successfull");
	             
    }
	 @Test
	    public void validsuccessfulFemaleRegister() {
		 registerpage.selectFemaleGender();
		 registerpage.enterFirstName("rrr");
		 registerpage.enterLastName("eee");
		 registerpage.enterEmail(email);
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
