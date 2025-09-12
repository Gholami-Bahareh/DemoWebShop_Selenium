package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage {
	WebDriver driver;
    WebDriverWait wait;
    
    //constructor
    public CategoryPage(WebDriver driver ) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  

        }
    
    
 // Locator ساده برای لیست محصولات
    By products = By.cssSelector(".product-item");

    // متد برای گرفتن تعداد محصولات
    public int getNumberOfProducts() {
        List<WebElement> productList = driver.findElements(products);
        return productList.size();
    }
    
    // Locators
    // Methods
	
}
