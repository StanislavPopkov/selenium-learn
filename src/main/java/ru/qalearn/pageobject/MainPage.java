package ru.qalearn.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//a[text()='Sign in']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[text()='Sign up']")
    private WebElement signUpButton;
    @FindBy(xpath = ".//*[@id='user[login]']")
    private WebElement userNameField;
    @FindBy(xpath = ".//*[@id='user[email]']")
    private WebElement emailField;
    @FindBy(xpath = ".//*[@id='user[password]']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[text()='Sign up for GitHub']")
    private WebElement signUpFormButton;

    public LoginPage clickSignIn(){
        signInButton.click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUpButton(){
        signUpButton.click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickSignUpFormButton(){
        signUpFormButton.click();
        return new SignUpPage(driver);
    }

    public MainPage typeUserName(String username){
        userNameField.sendKeys(username);
        return this;
    }

    public MainPage typePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    public MainPage typeEmail(String email){
        emailField.sendKeys(email);
        return this;
    }

    public SignUpPage register(String username, String email, String password){
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePassword(password);
        this.clickSignUpFormButton();
        return new SignUpPage(driver);
    }
}
