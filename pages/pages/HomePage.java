package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait;
	
	//Constructor
	public HomePage(WebDriver driver , WebDriverWait wait  ) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
        }
	
}


//package pages;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class LoginPage {
//	
//    WebDriver driver;
//    WebDriverWait wait;
//
//    // Constructor
//    public LoginPage(WebDriver driver , WebDriverWait wait  ) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
//        }
//    
//
//    // Locators
//    By emailField = By.id("Email");
//
//
//    // Methods
//    public void enterEmail(String email) {
//     // driver.findElement(emailField).sendKeys(email);
//        WebElement emailBox = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
//        emailBox.clear();
//        emailBox.sendKeys(email);   
//    }
//
//  
//    }
//}
