package tests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CategoryPage;

public class CategoryTest {
	WebDriver driver;
	CategoryPage categoryPage;
	
	@BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
               
        	    }
	@BeforeMethod
	public void refresh() {
		 driver.get("https://demowebshop.tricentis.com/books"); 
	     categoryPage = new pages.CategoryPage(driver);
	}
	
	
	@Test
    public void testProductsAreDisplayed() {
                        
        int productCount = categoryPage.getNumberOfProducts();
        // Assert: show at least one product
        Assert.assertTrue( productCount > 0,  "Expected product count > 0 but found " +  productCount);
        }
	
	@Test
    public void testProductsTitleAreDisplayed() {
                        
		List<String> titles = categoryPage.getProductTitles();
		for (String title : titles) {
			Assert.assertFalse(title.isEmpty(),"A product has empty title!");
			        
		}
        }
	
	 @AfterClass
	    public void teardown() {
	        driver.quit();
	    }
}
