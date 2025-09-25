package main.java.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait; 
	
	//Constructor
	public HomePage(WebDriver driver ) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
        }
	
	//Locators
	By logoutLink = By.cssSelector(".ico-logout");
	
	//Methods
	  public boolean isLogoutVisible() {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink)).isDisplayed();
	    }
	
}

