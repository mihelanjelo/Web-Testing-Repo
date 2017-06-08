package utils;

import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;


public class BrowserFactory {

    public enum Browser {
        CHROME, FIREFOX, IE, EDGE,
        OPERA, PHANTOMJS
    }

    private static WebDriver driver;

    public static WebDriver startBrowser(Browser browserName) {
        if (browserName == Browser.CHROME) {
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
        } else if (browserName == Browser.FIREFOX) {
            FirefoxDriverManager.getInstance().setup();
            driver = new FirefoxDriver();
        } else if (browserName == Browser.IE) {
            InternetExplorerDriverManager.getInstance().setup();
            driver = new InternetExplorerDriver();
        } else if (browserName == Browser.EDGE) {
            EdgeDriverManager.getInstance().setup();
            driver = new EdgeDriver();
        } else if (browserName == Browser.OPERA) {
            OperaDriverManager.getInstance().setup();
            driver = new OperaDriver();
        } else if (browserName == Browser.PHANTOMJS) {
            PhantomJsDriverManager.getInstance().setup();
            driver = new OperaDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }
}
