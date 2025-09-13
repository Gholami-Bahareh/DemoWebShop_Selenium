package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CategoryPage;

public class CategoryTest {
	
	@Test
    public void testProductsAreDisplayed() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/books"); // URL صفحه دسته‌بندی
        
        CategoryPage categoryPage = new CategoryPage(driver);
        int productCount = categoryPage.getNumberOfProducts();

        // Assert: حداقل یک محصول باید نمایش داده شود
        Assert.assertTrue(productCount > 0, "هیچ محصولی نمایش داده نشده!");

        driver.quit();
    }
}
