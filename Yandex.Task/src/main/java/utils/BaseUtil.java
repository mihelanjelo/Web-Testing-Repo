package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class BaseUtil {
    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected Actions driverAction;
    protected String jsHover = "var element = arguments[0];"
            .concat( "var mouseEventObj = document.createEvent('MouseEvents');")
            .concat( "mouseEventObj.initEvent( 'mouseover', true, true );")
            .concat( "element.dispatchEvent(mouseEventObj);");
}
