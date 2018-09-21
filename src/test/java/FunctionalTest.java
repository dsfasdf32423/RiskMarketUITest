import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class FunctionalTest {
    public static WebDriver driver;
    @BeforeClass
    public static void initDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pavel.adam\\RiskMarketUITest\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }


    @Test
    public void countrySelectorTest() throws InterruptedException {
        driver.get("https://riskmarket-ext.sidenis.com");
        WebElement element = driver.findElement(By.xpath("//form/.//input[@placeholder=\"Укажите страну\"]"));
        element.click();
        element.sendKeys("Шенген");
        element.sendKeys(Keys.ENTER);
        WebElement elementEntered = driver.findElement(By.xpath("//div[@class=\"ui-select__tag-field ui-select-tag\"]"));
        assertEquals ("Шенген", elementEntered.getText());

        WebElement addTourist = driver.findElement(By.xpath("//input[@placeholder='Туристы']"));
        addTourist.click();
        WebElement date = driver.findElement(By.xpath("//input[@placeholder='дд.мм.гггг']"));
        date.sendKeys("10.");
        date.sendKeys("05.");
        date.sendKeys("19");
        date.sendKeys("90");
        date.sendKeys(Keys.ENTER);
        WebElement checkbox = driver.findElement(By.xpath("//i[@class='rm-icon rm-icon--accept']"));
        checkbox.click();
        WebElement datePolic = driver.findElement(By.xpath("//input[@placeholder='дд.мм.гггг — дд.мм.гггг']"));
        datePolic.click();
        WebElement buttonDate = driver.findElement(By.xpath("//div[@class='ui-calendar-pane__cell']//span[contains(text(),'1')]"));
        buttonDate.click();
        WebElement buttonEnter = driver.findElement(By.xpath("//span[contains(text(),'Рассчитать')]"));
        Thread.sleep(1000);
        buttonEnter.click();
        Thread.sleep(1000);
        assertEquals("https://riskmarket-ext.sidenis.com/travel/search-results",driver.getCurrentUrl());
    }

    @AfterClass
    public static void closeDriver(){
        driver.close();
        }
}