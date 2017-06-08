package pageobjects.yandexpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pageobjects.YandexPages;


public class ProductPage extends YandexPages {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CLASS_NAME, using = "n-product-title")
    public static WebElement productTitle;

    public static String getTitle() {
        return productTitle.findElement(By.xpath("//*[@itemprop = 'name']")).getText();
    }
}
