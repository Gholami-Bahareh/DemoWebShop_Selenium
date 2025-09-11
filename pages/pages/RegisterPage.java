package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

	WebDriver driver;
    WebDriverWait wait;
    
    //constructor
    public RegisterPage(WebDriver driver ) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  

        }
    
//پر کردن فرم با داده‌های درست و ثبت موفقیت‌آمیز
//بررسی اینکه فیلدهای ضروری خالی باشن و خطا نمایش داده بشه
//بررسی اعتبار ایمیل یا پسورد (مثلاً کوتاه بودن یا بدون کاراکتر خاص)
//انتخاب جنسیت و اطمینان از اینکه سیستم انتخاب رو درست ثبت می‌کنه
//بررسی اینکه دکمه ثبت فعال یا غیر فعال باشه در شرایط مختلف
//تست رفتار فرم بعد از ثبت (مثل پیام موفقیت یا ریدایرکت)
    
    // Locators
    By maleGenderRadio = By.id("gender-male");
    By femaleGenderRadio = By.id("gender-female");
    By firstnameField = By.id("FirstName");
    By lastnameField = By.id("LastName");
    By emailField = By.id("Email");
    By passwordField = By.id("Password");
    By confirmpasswordField = By.id("ConfirmPassword");
    By registerButton = By.id("register-button");
    By resultText = By.xpath("//div[@class='result']");
    
    //Method
    
    public void selectMaleGender() {
        WebElement malegenderBox = wait.until(ExpectedConditions.visibilityOfElementLocated(maleGenderRadio));
        malegenderBox.click();  
    }
    
    public void selectFemaleGender() {
        WebElement femalegenderBox = wait.until(ExpectedConditions.visibilityOfElementLocated(femaleGenderRadio));
        femalegenderBox.click();  
    }
    
    public void enterFirstName(String firstname) {
        WebElement firstnameBox = wait.until(ExpectedConditions.visibilityOfElementLocated(firstnameField));
        firstnameBox.clear();
        firstnameBox.sendKeys(firstname);   
    }
    
    public void enterLastName(String lastname) {
        WebElement lastnameBox = wait.until(ExpectedConditions.visibilityOfElementLocated(lastnameField));
        lastnameBox.clear();
        lastnameBox.sendKeys(lastname);   
    }
    
    public void enterEmail(String email) {
           WebElement emailBox = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
           emailBox.clear();
           emailBox.sendKeys(email);   
       }
    
    public void enterPassword(String password) {
        WebElement passwordBox = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordBox.clear();
        passwordBox.sendKeys(password);   
    }
    
    public void enterConfirmPassword(String confirmpassword) {
        WebElement confirmpasswordBox = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmpasswordField));
        confirmpasswordBox.clear();
        confirmpasswordBox.sendKeys(confirmpassword);   
    }
    
    public void clickRegister() {
        WebElement registerBox = wait.until(ExpectedConditions.visibilityOfElementLocated(registerButton));
        registerBox.click();  
        
    }
    
    public boolean seeSuccessMessage() {
    	try {
        WebElement successText = wait.until(ExpectedConditions.visibilityOfElementLocated(resultText));
        return successText.isDisplayed();   
    	} catch (Exception e) {
            return false; 
        }
    }
    }


