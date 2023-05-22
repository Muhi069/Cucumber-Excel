package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    //1. By locators


    public By emailId = By.id("Email");
    public By passwordByUser = By.id("Password");
    public  By signInButton = By.xpath("//button[normalize-space()='Log in']");
    public By error1= By.cssSelector(".message-error.validation-summary-errors"); //invalid credentials
    public By error2= By.cssSelector(".message-error.validation-summary-errors"); //no user

//    public String HomePageURL= "https://localhost:44369/";


    //2. Constructor of the page class
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    //3. Page actions: features(behavior) of the page the form of methods:

//    public void goToLoginPage() {
//
//        driver.get("https://localhost:44369/login?returnUrl=%2F");
//    }

    public void doLogin(String email, String password) {
        driver.get("https://localhost:44369/login");
        driver.findElement(emailId).sendKeys(email);
        driver.findElement(passwordByUser).sendKeys(password);
//        driver.findElement(signInButton).click();
    }

    public String homePageMsg() {
        return driver.getTitle();
    }

    public String error1() {
        String err1= driver.findElement(error1).getText();
        return err1;
    }

    public String error2() {
        String err2= driver.findElement(error2).getText();
        return err2;
    }

    public void clickLoginBtn() {
        driver.findElement(signInButton);
    }

}


