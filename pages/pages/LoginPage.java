package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public LoginPage(WebDriver driver ) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  

        }
    

    // Locators
    By emailField = By.id("Email");
    By passwordField = By.id("Password");
    By loginButton = By.cssSelector("input[value='Log in']");
        //By.xpath("//input[@value= 'Log in']")
    By errorMessage = By.cssSelector(".message-error");

    // Methods
    public void enterEmail(String email) {
     // driver.findElement(emailField).sendKeys(email);
        WebElement emailBox = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailBox.clear();
        emailBox.sendKeys(email);   
    }

    public void enterPassword(String password) {
     // driver.findElement(passwordField).sendKeys(password);
        WebElement passwordBox = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordBox.clear();
        passwordBox.sendKeys(password);	
    }

    public HomePage clickLogin() {
      //  driver.findElement(loginButton).click();
        WebElement loginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(loginButton));
        loginBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ico-logout") )) ;    //a[@class='ico-logout']         .ico-logout   
        return new HomePage(driver);
       
    }
    
    public boolean isLoginErrorVisible() {
        try {
            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
            return errorMsg.isDisplayed(); 
        } catch (Exception e) {
            return false; 
        }
    }
    
   
}
