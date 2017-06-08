package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;


public class Facade {

    /**
     * @param driver webdriver
     * @param pagesList list of page classes, that will be initialized
     */
    public static void initPages(WebDriver driver, ArrayList<Class> pagesList) {
        for (Class c : pagesList) {
            PageFactory.initElements(driver, c);
        }
    }
}