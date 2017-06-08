package pageobjects.yandexpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pageobjects.YandexPages;

import java.util.ArrayList;
import java.util.List;


public class YandexMarketPage extends YandexPages {
    public YandexMarketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//li[@data-department='Электроника']")
    public static WebElement electronics;

    @FindBy(how = How.XPATH, using = "//a[text() ='Телевизоры']")
    public static WebElement tvs;

    @FindBy(how = How.XPATH, using = "//a[text() ='Наушники']")
    public static WebElement headsets;

    @FindBy(how = How.NAME, using = "glf-pricefrom-var")
    public static WebElement priceFrom;

    @FindBy(how = How.CLASS_NAME, using = "button_action_n-filter-apply")
    public static WebElement apply;

    @FindBy(how = How.ID, using = "header-search")
    public static WebElement searchBar;


    @FindBy(how = How.CLASS_NAME, using = "snippet-list")
    public static List<WebElement> filterResults;


    public static int getCountOfElements() {
        List<WebElement> elements = new ArrayList<>();

        for (WebElement el : filterResults) {
            elements.addAll(el.findElements(By.xpath("./div")));
        }

        return elements.size();
    }

    public static String getItemTitle(Integer index) {

        return filterResults.get(index).findElement(By.xpath("./div")).findElement(By.className("snippet-card__header-text")).getText();
    }

    public static class TvManufacturers {

        @FindBy(how = How.XPATH, using = "//span[label[text()='LG']]")
        public static WebElement lg;

        @FindBy(how = How.XPATH, using = "//span[label[text()='Samsung']]")
        public static WebElement samsung;
    }

    public static class HeadSetManufacturers {

        @FindBy(how = How.XPATH, using = "//span[label[text()='Beats']]")
        public static WebElement beats;
    }


}
