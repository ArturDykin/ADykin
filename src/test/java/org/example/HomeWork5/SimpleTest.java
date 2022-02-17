package org.example.HomeWork5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class SimpleTest {

    static WebDriver driver;

    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/");
    }

    @Test
    @DisplayName("Тест 1. Заполнение отправка полей во вкладке Тестовое окно")
    void myActiontest() {
        driver.findElement(By.cssSelector(".card:nth-child(1) path")).click();
        driver.findElement(By.xpath("//div[@class='element-list collapse show']/ul/li[@id='item-0']/span[@class='text']")).click();
        Actions action = new Actions(driver);
        action.sendKeys(driver.findElement(By.id("userName")),"Dykin Artur")
                .click(driver.findElement(By.id("userEmail")))
                .sendKeys("123@mail.ru")
                .click(driver.findElement(By.id("currentAddress")))
                .sendKeys("Москва")
                .click(driver.findElement(By.id("permanentAddress")))
                .sendKeys("Москва д.1")
                .click(driver.findElement(By.id("submit")))
                .build()
                .perform();
       // Assertions.assertTrue(driver.findElement(By.id("userName")).getText().equals("Тест упал"));
    }

    @Test
    @DisplayName("Тест 2. Проверка двойного и одинарного нажатия на кнопки во вкладке Кнопки")
    void myActiontest2() {
        driver.findElement(By.cssSelector(".card:nth-child(1) path")).click();
        driver.findElement(By.xpath("//div[@class='element-list collapse show']/ul/li[@id='item-4']/span[@class='text']")).click();
        Actions action = new Actions(driver);
        WebElement link = driver.findElement(By.id("doubleClickBtn"));
        action.doubleClick(link).perform();
        // Assertions.assertTrue(driver.findElement(By.id("doubleClickBtn")).getText().equals("Тест упал"));
    }
    @Test
    @DisplayName("Тест 3. Осуществить поиск во вкладке Веб-таблицы")
    void myActiontest3() {
        driver.findElement(By.cssSelector(".card:nth-child(1) path")).click();
        driver.findElement(By.xpath("//div[@class='element-list collapse show']/ul/li[@id='item-3']/span[@class='text']")).click();
        driver.findElement(By.id("searchBox")).sendKeys("Cierra");
        // Assertions.assertTrue(driver.findElement(By.id("searchBox")).getText().equals("Тест упал"));
    }
    @Test
    @DisplayName("Тест 4. Обозначить чекбоксом приватный документ")
    void myActiontest4(){
        driver.findElement(By.cssSelector(".card:nth-child(1) path")).click();
        driver.findElement(By.xpath("//div[@class='element-list collapse show']/ul/li[@id='item-1']/span[@class='text']")).click();
//        Actions action = new Actions(driver);
//        action.click(driver.findElement(By.cssSelector(".rct-icon-expand-close"),
//               (driver.findElement(By.xpath("//li[2]/span/button[@class='rct-collapse rct-collapse-btn']"))
//               .click(driver.findElement(By.cssSelector(".rct-node-collapsed:nth-child(2) .rct-collapse > .rct-icon")),
//               (By.cssSelector(".rct-node-leaf:nth-child(2) .rct-checkbox > .rct-icon"))
//                       .perform();

        driver.findElement(By.cssSelector(".rct-icon-expand-close")).click();
        driver.findElement(By.xpath("//li[2]/span/button[@class='rct-collapse rct-collapse-btn']")).click();
        driver.findElement(By.cssSelector(".rct-node-collapsed:nth-child(2) .rct-collapse > .rct-icon")).click();
        driver.findElement(By.cssSelector(".rct-node-leaf:nth-child(2) .rct-checkbox > .rct-icon")).click();

////        // Assertions.assertTrue(driver.findElement(By.id("userName")).getText().equals("Тест упал"));
    }

    @Test
    @DisplayName("Тест 5. Перенос обьекта методом drag and drop в другой обьект")
    void myActiontest5() {
        driver.findElement(By.cssSelector("div:nth-child(5) > div > div.avatar.mx-auto.white > svg")).click();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");
        driver.findElement(By.xpath("//div[@class='element-list collapse show']/ul/li[@id='item-3']/span[@class='text']")).click();
        Actions action = new Actions(driver);
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        action.pause(2000);
        action.dragAndDrop(draggable, droppable).release().build().perform();

        // Assertions.assertTrue(driver.findElement(By.id("draggable")).getText().equals("Тест упал"));
    }
    @Test
    @DisplayName("Тест 6. Перенос обьекта методом drag and drop на конкретное расстояние")
    void myActiontest6() {
        driver.findElement(By.cssSelector("div:nth-child(5) > div > div.avatar.mx-auto.white > svg")).click();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");
        driver.findElement(By.xpath("//div[@class='element-list collapse show']/ul/li[@id='item-4']/span[@class='text']")).click();
        Actions action = new Actions(driver);
        WebElement dragBox = driver.findElement(By.id("dragBox"));
        action.pause(2000);
        action.dragAndDropBy(dragBox, 100, 0).release().build().perform();

        // Assertions.assertTrue(driver.findElement(By.id("dragBox")).getText().equals("Тест упал"));
    }
    @AfterEach
    void getQuit() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

    @BeforeEach
    void goTo(){
        Assertions.assertDoesNotThrow( ()-> driver.navigate().to("https://demoqa.com/"),
                "Страница не доступна");
    }
}
