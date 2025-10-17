package tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CategoryPage;
import pages.ProductPage;

public class CategoryTest {
	WebDriver driver;
	CategoryPage categoryPage;
	
	@BeforeClass(groups = {"regression"})
    public void setup() {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
               
        	    }
	@BeforeMethod(groups = {"regression"})
	public void refresh() {
		System.out.println("refresh() running");
		 driver.get("https://demowebshop.tricentis.com/books"); 
	     categoryPage = new pages.CategoryPage(driver);
	}
	
	
	@Test(groups = {"regression"})
    public void testProductsAreDisplayed() {
                        
        int productCount = categoryPage.getNumberOfProducts();
        // Assert: show at least one product
        Assert.assertTrue( productCount > 0,  "Expected product count > 0 but found " +  productCount);
        }
	
	@Test(groups = {"regression"}) 
    public void testProductsTitleAreDisplayed() {
                        
		List<String> titles = categoryPage.getProductTitlesText();
		for (String title : titles) {
			Assert.assertFalse(title.isEmpty(),"A product has empty title!");
			        
		}
        }
	
	@Test(groups = {"regression"}) 
	public void testProductDetail() {
		List<WebElement> titleLinks = categoryPage.getAllProductTitles();
		
		 for (int i = 0; i < titleLinks.size(); i++)
		{
			ProductPage productpage  = categoryPage.clickForDetail(i);
			Assert.assertNotEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/books", "Urls should be different");
			Assert.assertTrue(productpage.isShortDescriptionVisible(), "Short Discription should be visible");
			driver.get("https://demowebshop.tricentis.com/books"); 
		}
	}
	
	@Test(groups = {"regression"})
	public void testProductSortAToZ() {
		List<String> titlesBefore = categoryPage.getProductTitlesText();
		List<String> sortedAToZ = new ArrayList<>(titlesBefore);
		Collections.sort(sortedAToZ);
		
		categoryPage.selectAToZ();
		List<String> titlesAfter = categoryPage.getProductTitlesText();	
//		Assert.assertNotEquals(titlesBefore, titlesAfter, "should not be the same");
		Assert.assertEquals(sortedAToZ, titlesAfter, "should  be the same");
	}
	
	@Test(groups = {"regression"}) 
	public void testPriceSort() {
		List<Double> priceBefore = categoryPage.getProductPrice();
		List<Double> sortedLowToHight = new ArrayList<>(priceBefore);
		Collections.sort(sortedLowToHight);
		
		categoryPage.selectLowToHigh();
		List<Double> pricesAfter = categoryPage.getProductPrice();
		Assert.assertNotEquals(priceBefore, pricesAfter, "should not be the same");
		Assert.assertEquals(sortedLowToHight, pricesAfter, "should  be the same");
		
	}
	
	 @AfterClass(groups = {"regression"})
	    public void teardown() {
	        driver.quit();
	    }
}
