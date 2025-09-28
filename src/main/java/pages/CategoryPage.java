package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
    By description = By.cssSelector(".short-description");
    By actualprices = By.cssSelector(".price.actual-price");
    By oldprices = By.cssSelector(".price.old-price");
    By sortDropdown = By.id("products-orderby");

    // Methods
    public int getNumberOfProducts() {
    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(products));
        List<WebElement> productList = driver.findElements(products);
        return productList.size();
    }
    
       
    public List<String> getProductTitlesText() { 
    	List<WebElement> productTitle = driver.findElements(titles);
    	List<String> titleText = new ArrayList<>();
    	for (WebElement title : productTitle ) {
    	 String text = title.getText();
    	 titleText.add(text); 	}
    	return titleText;	 	
    }
    
    public List<Double> getProductPrice(){
    	List<WebElement> productPriceElemets = driver.findElements(actualprices);
    	List<Double> priceValues = new ArrayList<>();
    	for (WebElement priceElement : productPriceElemets ) {
       	 String text = priceElement.getText();
       	 System.out.println("Price text: '" + text + "'");  // ← اضافه کن
       	 Double value = Double.parseDouble(text);
       	 priceValues.add(value); 	
       	 }
       	return priceValues;
    	
    }

    
    public List<WebElement> getAllProductTitles() {
    	List<WebElement> productTitle = driver.findElements(titles);
    	return productTitle;
    }
    

    public void selectLowToHigh() {
    	WebElement dropdownElement = driver.findElement(sortDropdown);
    	Select dropdown = new Select(dropdownElement);
    	dropdown.selectByVisibleText("Price: Low to High");
    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(products));
    };
    
    public void selectAToZ() {
    	WebElement dropdownElement = driver.findElement(sortDropdown);
    	Select dropdown = new Select(dropdownElement);
    	dropdown.selectByVisibleText("Name: A to Z");
    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(products));
    };
	
    
    public ProductPage clickForDetail(int index) {
    	List<WebElement> productTitle = driver.findElements(titles);
    	productTitle.get(index).click();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".short-description") )) ;    //a[@class='ico-logout']    
            return new ProductPage(driver);
    }
  

}
