package org.example.HomeWork3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

// Тест 4 Обозначить чекбоксом приватный документ
public class Test4 {
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
        driver.findElement(By.xpath("//div[@class='element-list collapse show']/ul/li[@id='item-1']/span[@class='text']")).click();
        driver.findElement(By.cssSelector(".rct-icon-expand-close")).click();
        driver.findElement(By.xpath("//li[2]/span/button[@class='rct-collapse rct-collapse-btn']")).click();
        driver.findElement(By.cssSelector(".rct-node-collapsed:nth-child(2) .rct-collapse > .rct-icon")).click();
        driver.findElement(By.cssSelector(".rct-node-leaf:nth-child(2) .rct-checkbox > .rct-icon")).click();

        Thread.sleep(5000);

        driver.quit();

    }
}
