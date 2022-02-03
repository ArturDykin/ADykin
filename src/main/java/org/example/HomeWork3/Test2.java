package org.example.HomeWork3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

// Тест 2 Проверка двойного и одинарного нажатия на кнопки во вкладке "Кнопки"
public class Test2 {
    public static void main( String[] args ) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        //options.addArguments("--disable-popup-blocking");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/");

        driver.findElement(By.cssSelector(".card:nth-child(1) path")).click();
        driver.findElement(By.xpath("//div[@class='element-list collapse show']/ul/li[@id='item-4']/span[@class='text']")).click();
        Actions action = new Actions(driver);
        WebElement link = driver.findElement(By.id("doubleClickBtn"));
        action.doubleClick(link).perform();
        driver.findElement(By.id("rightClickBtn")).click();
        driver.findElement(By.xpath("//div[@class='mt-4']/button[@id!='rightClickBtn']")).click();
        Thread.sleep(5000);

        driver.quit();

    }
}
