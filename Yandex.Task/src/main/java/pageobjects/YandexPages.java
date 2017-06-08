package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.yandexpages.ProductPage;
import pageobjects.yandexpages.YandexMainPage;
import pageobjects.yandexpages.YandexMarketPage;

import java.util.ArrayList;

/**
 * Base class of pages
 */
public abstract class YandexPages {

    public static ArrayList<Class> pagesList = new ArrayList<Class>() {{
        add(YandexMainPage.class);
        add(YandexMarketPage.class);
        add(ProductPage.class);
        add(YandexMarketPage.TvManufacturers.class);
        add(YandexMarketPage.HeadSetManufacturers.class);
    }};

    private static WebDriver driver;

    public YandexPages(WebDriver driver) {
        YandexPages.driver = driver;
    }

    public void init() {
        PageFactory.initElements(driver, this);
    }
}
