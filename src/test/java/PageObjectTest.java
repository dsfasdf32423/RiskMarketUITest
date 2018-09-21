import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PageObjectTest extends FunctionalTest {
    @Test
    public void MainTest(){
        driver.get("https://riskmarket-ext.sidenis.com");
        MainPage mainPage = new MainPage(driver);
        mainPage.insertCountry("Шенген");
       // mainPage.countryWidget.click();


    }
}
