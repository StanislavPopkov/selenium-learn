package ru.qalearn.action;

import com.typesafe.config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.qalearn.utils.Configs;

import java.util.concurrent.TimeUnit;

public class MainClassAction {
    private static Config config;
    public static void initConfig() {
        config = Configs.getConfig("settings.properties");
    }

    public static void main(String[] args) {
        initConfig();
        System.setProperty("webdriver.chrome.driver", config.getString("driver"));
        WebDriver driver = new ChromeDriver();
        /**
         * задаем общее ожидание для всей страницы
         */
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        /**
         * задаем явное ожидание для элемента/условия, работает 1 раз
         */
/*        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@type='submit'])[1]")));*/

/*        driver.get("https://www.selenium.dev/");
        driver.get("https://www.selenium.dev/downloads/");
        driver.navigate().to("https://www.selenium.dev/");
        driver.navigate().back();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.quit();*/

        /**
         * способы получения элемента
         */
/*        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        WebElement element = driver.findElement(By.linkText("Log in"));
        WebElement element2 = driver.findElement(By.partialLinkText("Log"));
        WebElement element3 = driver.findElement(By.name("search"));
        WebElement element4 = driver.findElement(By.className("searchButton"));
        WebElement element5 = driver.findElement(By.id("searchButton"));
        WebElement element6 = driver.findElement(By.tagName("input"));
        WebElement element7 = driver.findElement(By.cssSelector("div#simpleSearch input#searchButton"));
        WebElement visitTheMain = driver.findElement(By.xpath("(//a[@href='/wiki/Main_Page'])[3]"));*/

        /**
         * ввод текста и нажатие кнопки
         */
/*        driver.findElement(By.xpath("//input[@id='searchButton']")).click();
       driver.findElement(By.xpath("//input[@placeholder='Search Wikipedia']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search Wikipedia']")).sendKeys("values to send");

        driver.get("https://github.com/");
        WebElement element9 = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
        System.out.println(element9.getText());
        //element9.submit();
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        driver.findElement(By.xpath("//input[@placeholder='Search Wikipedia']")).sendKeys("values to send");
        driver.findElement(By.xpath("//input[@id='searchButton']")).click();
        System.out.println(driver.findElement(By.xpath("//div[@id='searchText']//input[1]")).getAttribute("value"));
        driver.findElement(By.xpath("//span[@class='oo-ui-indicatorElement-indicator oo-ui-indicator-clear']")).click();
        System.out.println(driver.findElement(By.xpath("//li[@id='n-help']//a[1]")).getText());
        driver.findElement(By.xpath("//li[@id='n-help']//a[1]")).click();*/

        /**
         * выбор чекбокса и проверка
         */
/*
        driver.get("http://programmerbook.ru/html/input/type/checkbox/");
        driver.findElement(By.xpath("//span[text()='подарки за покупку']")).click();
        System.out.println(driver.findElement(By.xpath("//span[text()='С учётом доставки курьером']")).isSelected());
        driver.findElement(By.xpath("//span[text()='С учётом доставки курьером']")).click();
        System.out.println(driver.findElement(By.xpath("//span[text()='С учётом доставки курьером']")).isSelected());

        List<WebElement> list = driver.findElements(By.xpath("//div[@class=\"exUseWindow-Main\"]"));
        list.get(1).click();
        list.forEach(webElement -> System.out.println(webElement.getText()));
*/

        /**
         * получаем таблицу и работаем с ее данными
         */
/*        driver.get("https://daruse.ru/html-table-generator");
        WebElement tableElement = driver.findElement(By.xpath("//table[@class='tftable']"));
        Table table = new Table(tableElement, driver);
        String value = table.getValueFromMapHeadingValue(3, "Заголовок 2");
        System.out.println(value);

        List<List<WebElement>> list =  table.getRowWithsColumns();
        System.out.println("size of table: rowNumber(" + list.size() + ") columnNumber(" + list.get(0).size() + ")");*/

        /**
         * действия со скрытыми элементами, перемещение
         */
/*        driver.get("https://ru.ebay.com/");
        WebElement elmentlink = driver.findElement(By.xpath("(//a[@href='https://ru.ebay.com/b/Electronics/bn_7000259124'])[2]"));
        WebElement element = driver.findElement(By.linkText("Log in"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elmentlink).build().perform();
        //вкладывание элемента
        actions.dragAndDrop(element, elmentlink).build().perform();
        //перетаскивание элемента
        actions.clickAndHold(element).moveToElement(elmentlink).release().build().perform();
        //двойной клик
        actions.doubleClick(elmentlink);
        //нажатие правой кнопкой мыши
        actions.contextClick();*/

        /**
         * работа с javascript
         */
/*
        driver.get("https://ru.ebay.com/");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0, 1000", "");
*/
        /**
         * работа с alert
         */
/*        driver.get("https://www.google.com/search?q=qwerty&oq=qwe&aqs=chrome.1.69i57j0l5j46j0.2371j0j8&sourceid=chrome&ie=UTF-8");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("confirm('Are you sure?');");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().accept();

        driver.get("https://www.google.com/search?q=qwerty&oq=qwe&aqs=chrome.1.69i57j0l5j46j0.2371j0j8&sourceid=chrome&ie=UTF-8");
        JavascriptExecutor jse2 = (JavascriptExecutor)driver;
        jse2.executeScript("confirm('Are you sure?');");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().dismiss();*/
    }

}
