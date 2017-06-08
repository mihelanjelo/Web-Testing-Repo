package pageobjects.yandexpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pageobjects.YandexPages;


public class YandexMainPage extends YandexPages {
    public YandexMainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//a[@data-id='market']")
    public static WebElement market;
}
