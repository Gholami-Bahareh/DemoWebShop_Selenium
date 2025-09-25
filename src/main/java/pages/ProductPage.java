package main.java.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	WebDriver driver;
	WebDriverWait wait; 
		
	//Constructor
	public ProductPage(WebDriver driver ) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
	        }
		
	//Locators
	By shortDescription = By.cssSelector(".short-description");
	
	//Methods
	public boolean isShortDescriptionVisible() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(shortDescription)).isDisplayed();
	}

	}

