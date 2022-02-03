package org.example.HomeWork3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

// Тест 3 Осуществить поиск во вкладке "Веб-таблицы"
public class Test3 {
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
        driver.findElement(By.xpath("//div[@class='element-list collapse show']/ul/li[@id='item-3']/span[@class='text']")).click();
        driver.findElement(By.id("searchBox")).sendKeys("Cierra");

        Thread.sleep(5000);

        driver.quit();

    }
}
