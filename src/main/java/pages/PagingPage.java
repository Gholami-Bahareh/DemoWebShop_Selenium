package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PagingPage {
	WebDriver driver;
    WebDriverWait wait;
    
  //constructor
    public PagingPage(WebDriver driver ) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  

        }
    
 // Locator
    
 // Methods
    

}
