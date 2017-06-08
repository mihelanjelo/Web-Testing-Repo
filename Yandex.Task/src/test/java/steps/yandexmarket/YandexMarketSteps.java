package steps.yandexmarket;

import cucumber.api.Scenario;
import cucumber.api.java8.En;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.Facade;
import pageobjects.YandexPages;
import pageobjects.yandexpages.ProductPage;
import pageobjects.yandexpages.YandexMainPage;
import pageobjects.yandexpages.YandexMarketPage;
import utils.BaseUtil;
import utils.BrowserFactory;

import java.util.concurrent.TimeUnit;


public class YandexMarketSteps extends BaseUtil implements En {

    private String itemTitle;

    public YandexMarketSteps() {

        //Hook
        After((Scenario scenario) -> {
            if (scenario.isFailed()) {
                System.out.println("Scenario: ".concat(scenario.getName()).concat(" is failed"));
            }
            if (driver != null) {
                driver.quit();
            }
        });

        //Steps
        Given("^browser \"([^\"]*)\"$", (BrowserFactory.Browser name) -> {
            driver = BrowserFactory.startBrowser(name);
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            driverWait = new WebDriverWait(driver, 1);
            driverAction = new Actions(driver);
            Facade.initPages(driver, YandexPages.pagesList);
        });
        And("^move to \"([^\"]*)\"$", (String url) -> {
            driver.get(url);
        });
        And("^move to yandex market$", () -> {
            YandexMainPage.market.click();
        });
        And("^select electronics$", () -> {
            driverAction.moveToElement(YandexMarketPage.electronics).perform();
        });
        When("^select TVs$", () -> {
            try {
                driverWait.until(ExpectedConditions.elementToBeClickable(YandexMarketPage.tvs));
                YandexMarketPage.tvs.click();
            } catch (org.openqa.selenium.TimeoutException e) {

                System.out.println("Hover was failed,test will use javascript to hover ".concat(YandexMarketPage.electronics.toString().concat("\n")));

                ((JavascriptExecutor) driver).executeScript(jsHover, YandexMarketPage.electronics);
                driverWait.until(ExpectedConditions.elementToBeClickable(YandexMarketPage.tvs));
                YandexMarketPage.tvs.click();
            }
        });
        And("^set searching parameter from (\\d+) rub$", (Integer value) -> {
            YandexMarketPage.priceFrom.sendKeys(value.toString());
        });
        And("^select manufacturers as Samsung and LG$", () -> {
            YandexMarketPage.TvManufacturers.samsung.click();
            YandexMarketPage.TvManufacturers.lg.click();
        });
        And("^press apply$", () -> {
            YandexMarketPage.apply.click();
        });
        Then("^count of items should be (\\d+)$", (Integer expected) -> {
            driverWait.until(driver -> YandexMarketPage.filterResults);
            Integer actual = YandexMarketPage.getCountOfElements();
            Assert.assertEquals(expected, actual);
        });
        When("^remember the first element of a list$", () -> {
            itemTitle = YandexMarketPage.getItemTitle(0);
        });
        And("^input remembered value into search bar$", () -> {
            YandexMarketPage.searchBar.sendKeys(itemTitle, Keys.ENTER);
        });
        Then("^remembered value should be equal to item name$", () -> {
            Assert.assertEquals(itemTitle, ProductPage.getTitle());
        });
        When("^select headsets$", () -> {
            try {
                driverWait.until(ExpectedConditions.elementToBeClickable(YandexMarketPage.headsets));
                YandexMarketPage.headsets.click();
            } catch (org.openqa.selenium.TimeoutException e) {

                System.out.println("Hover was failed,test will use javascript to hover ".concat(YandexMarketPage.electronics.toString().concat("\n")));

                ((JavascriptExecutor) driver).executeScript(jsHover, YandexMarketPage.electronics);
                driverWait.until(ExpectedConditions.elementToBeClickable(YandexMarketPage.headsets));
                YandexMarketPage.headsets.click();
            }
        });
        And("^select manufacturers as Beats$", () -> {
            YandexMarketPage.HeadSetManufacturers.beats.click();
        });
    }
}
