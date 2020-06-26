package ru.qalearn;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.qalearn.pageobject.SignUpPage;
import ru.qalearn.utils.Configs;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {

    WebDriver driver;
    SignUpPage signUpPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", Configs.getConfig("settings.properties").getString("driver"));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/join");
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void signUpWithShortPass(){
        SignUpPage sp = signUpPage.typePassword("qwe");
        String error = sp.getPasswrodErrorText();
        Assert.assertEquals("Password is too short (minimum is 7 characters) and needs at least one number", error);
    }

    @Test
    public void signUpReservedUsernameTest(){
        SignUpPage sp = signUpPage.typeUserName("username");
        String error = sp.getUsernameErrorText();
        Assert.assertEquals("Username is a reserved word", error);
    }

    @Test
    public void signUpTakenUsername(){
        SignUpPage sp = signUpPage.typeUserName("user");
        String error = sp.getUsernameErrorText();
        Assert.assertEquals("Username is already taken", error);
    }

    @Test
    public void getHeadingTest(){
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Join GitHub", heading);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
