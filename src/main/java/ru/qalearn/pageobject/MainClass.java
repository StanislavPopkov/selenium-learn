package ru.qalearn.pageobject;

import com.typesafe.config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.qalearn.utils.Configs;

import java.util.concurrent.TimeUnit;

public class MainClass {
    static WebDriver driver;
    private static Config config;

    public static void initConfig() {
        config = Configs.getConfig("settings.properties");
    }
    public static void main(String[] args) {
        initConfig();
        System.setProperty("webdriver.chrome.driver", config.getString("driver"));
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://github.com");

        MainPage mainPage = new MainPage(driver);

        mainPage.register("testusername", "qweqew@cxcv.com", "qweqwe2SDD33");
    }
}
