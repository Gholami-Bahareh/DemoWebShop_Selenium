package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage {
	WebDriver driver;
    WebDriverWait wait;
    
    //constructor
    public CategoryPage(WebDriver driver ) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  

        }
    
    
    // Locator
    By products = By.cssSelector(".product-item");
    By titles = By.cssSelector(".product-title");

    // Methods
    public int getNumberOfProducts() {
    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(products));
        List<WebElement> productList = driver.findElements(products);
        return productList.size();
    }
    
    public List<String> getProductTitles() { 
    	List<WebElement> productTitle = driver.findElements(titles);
    	List<String> titleText = new ArrayList<>();
    	for (WebElement title : productTitle ) {
    	 String text = title.getText();
    	 titleText.add(text); 	}
    	return titleText;
    	 	
    }
    
       
	
}
