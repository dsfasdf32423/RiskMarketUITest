import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageObject{
    public MainPage(WebDriver driver) { super(driver); }

    @FindBy(xpath = "//form/.//input[@placeholder=\"Укажите страну\"]")
    private  WebElement countryWidget;

    @FindBy(xpath = "//input[@placeholder=\"Туристы\"]")
    private WebElement touristWidget;

    @FindBy(xpath = "//input[@placeholder=\"дд.мм.гггг\"]")
    private WebElement touristWidgetDate;

    @FindBy(xpath = "//input[@placeholder='дд.мм.гггг — дд.мм.гггг']")
    private WebElement calendarWidget;

    @FindBy(xpath = "//span[contains(text(),'28')]")
    private WebElement calendarWidget28Date;

    @FindBy(xpath = "//span[contains(text(),'30')]")
    private WebElement calendarWidget30Date;

    @FindBy(xpath = "//span[contains(text(),'Рассчитать')]")
    private WebElement calculateButton;

    public void insertCountry(String country){
        countryWidget.click();
        countryWidget.sendKeys(country);
        countryWidget.sendKeys(Keys.ENTER);
    }
}
