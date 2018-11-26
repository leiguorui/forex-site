package cn.injava.forex.core.utils;

import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import sun.plugin2.main.client.WDonatePrivilege;

import javax.imageio.ImageIO;
import javax.xml.bind.Element;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 实例SeleniumUtil
 *
 * @author 雷国瑞
 * @version 1.0
 * @since 2018-11-26 14:04:18
 */
public class SeleniumUtil {
    public static String getTradeViewImg(String currency){
        System.setProperty("webdriver.chrome.driver","D:\\workspace_personal\\forex-site\\chromedriver2.42.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.tradingview.com/chart/?symbol=FX:" + currency);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        String[] currencys = {"EURUSD", "AUDUSD", "USDCAD"};
        for (String c : currencys){
            jsExecutor.executeScript("window.open('https://www.tradingview.com/chart/?symbol=FX:"+c+"', '_blank')");
        }

        //关闭弹窗
        WebElement popElement = getElement("#body > div.tv-dialog__modal-wrap > div > div > div > div.tv-dialog__close.tv-blackfriday-popup__close.js-dialog__close", driver);
        if (popElement != null){
            popElement.click();
        }

        jsExecutor.executeScript("jQuery('#header-toolbar-screenshot > span').click();");

        //等待截图图片
        final String inputElement = "#overlap-manager-root > div > div > span > div.modal-C2LSTwhC-.dialog-2APwxL3O-.rounded-tXI9mwGE-.shadowed-2M13-xZa- > div.body-2N-vuwQW- > div > div > div.copyForm-1HuPoKA0- > div.inputWrapper-6bNZbTW4-.inputWrapper-6bNZbTW4- > input";
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                WebElement element = getElement(inputElement, d);
                return element != null && !"".equals(element.getAttribute("value"));
            }
        });

        String returnValue = (String) jsExecutor.executeScript("return jQuery('"+inputElement+"').val()");

        System.out.println("==============================");
        System.out.println(returnValue);

        //Close the browser
        driver.quit();

        return returnValue;
    }

    public static boolean elementExit(String cssSelector, WebDriver wd){
        return wd.findElements(By.cssSelector(cssSelector) ).size() != 0;
    }

    /**
     * 获取一个元素, 如果为空返回null, 不抛出异常
     */
    public static WebElement getElement(String cssSelector, WebDriver driver){
        List<WebElement> elements = driver.findElements(By.cssSelector(cssSelector));
        return elements.size() == 0 ? null : elements.get(0);
    }

    /**
     * 保存截图
     *
     * 注意: 如果保存截图失败, 可能是element还没在dom渲染
     * 需要Thread.sleep(1000);
     *
     * @param cssSelector
     * @param driver
     * @param path
     * @return
     */
    public static String saveScreenshot(String cssSelector, WebDriver driver, String path){

        String fileName = DateTime.now().toString("yyyyMMddHHmmss") + DateTime.now().getMillisOfSecond();
        fileName = path + fileName + ".png";
        try {

            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            Long offsetTop = (Long) jsExecutor.executeScript("window.scroll(0, document.querySelector(\""+cssSelector+"\").offsetTop - 0); return document.querySelector(\""+cssSelector+"\").getBoundingClientRect().top;");

            WebElement ele = driver.findElement(By.cssSelector(cssSelector));

            // Get entire page screenshot
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            BufferedImage  fullImg = ImageIO.read(screenshot);

            // Get the location of element on the page
            Point point = ele.getLocation();

            // Get width and height of the element
            int eleWidth = ele.getSize().getWidth();
            int eleHeight = ele.getSize().getHeight();

            // Crop the entire page screenshot to get only element screenshot
            BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), Math.toIntExact(offsetTop),
                    eleWidth, eleHeight);
            ImageIO.write(eleScreenshot, "png", screenshot);

            // Copy the element screenshot to disk
            File screenshotLocation = new File(fileName);
            FileUtils.copyFile(screenshot, screenshotLocation);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileName;
    }

    /**
     * 根据tab 标题切换当前tab
     */
    public static boolean swichByKey(String tabKeyWord, WebDriver driver){
        boolean flag = false;
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //todo tabKeyWord和tab string的对应关系缓存, 就不用遍历tab了
        for (String tab : tabs){
            driver.switchTo().window(tab);
            if (driver.getTitle().contains(tabKeyWord)){
                flag = true;
                break;
            }
        }

        return flag;
    }

    /**
     * 等待js加载完成
     * @return
     */
    public static boolean waitForJStoLoad(WebDriver driver) {

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        //等待dom渲染
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }

        WebDriverWait wait = new WebDriverWait(driver, 60);
        final JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long)javascriptExecutor.executeScript("return jQuery.active") == 0);
                }
                catch (Exception e) {
                    return true;
                }
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return javascriptExecutor.executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };

        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }

    /**
     * 获取tradeview的截图
     * @param driver
     * @return
     */
    public static String getTradeViewImg(WebDriver driver){

        final JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("$('#header-toolbar-screenshot > span').click()");

        String js = "return jQuery('#overlap-manager-root > div > div > span > div.modal-C2LSTwhC-.dialog-2APwxL3O-.rounded-tXI9mwGE-.shadowed-2M13-xZa- > div.body-2N-vuwQW- > div > div > div.copyForm-1HuPoKA0- > div.inputWrapper-6bNZbTW4-.inputWrapper-6bNZbTW4- > input').val()";
        final String[] returnValue = {null};

        (new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                returnValue[0] = (String) javascriptExecutor.executeScript(js);
                return returnValue[0] != null && !"".equals(returnValue[0]);
            }
        });

        String cleanValue = "jQuery('#overlap-manager-root > div > div > span > div.modal-C2LSTwhC-.dialog-2APwxL3O-.rounded-tXI9mwGE-.shadowed-2M13-xZa- > div.body-2N-vuwQW- > div > div > div.copyForm-1HuPoKA0- > div.inputWrapper-6bNZbTW4-.inputWrapper-6bNZbTW4- > input').val('')";
        javascriptExecutor.executeScript(cleanValue);

        System.out.println("----getTradeViewImg----- " + returnValue[0]);

        return returnValue[0];
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\workspace_personal\\forex-site\\chromedriver2.42.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://cn.bing.com/search?q=a&qs=n&form=QBLH&sp=-1&pq=a&sc=8-1&sk=&cvid=B113BABAC868456DB13F1178FB4A47C4");

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        String[] currencys = {"EURUSD", "AUDUSD", "USDCAD"};
        for (String c : currencys){
            jsExecutor.executeScript("window.open('https://www.tradingview.com/chart/?symbol=FX:"+c+"', '_blank')");
        }

        System.out.println("====="+driver.getTitle());

        swichByKey("EURUSD", driver);

        System.out.println("====="+driver.getTitle());

//        waitForJStoLoad(driver);

        jsExecutor.executeScript("$('body > div.tv-dialog__modal-wrap > div > div > div > div.tv-dialog__close.tv-blackfriday-popup__close.js-dialog__close').click()");

        System.out.println("====="+driver.getTitle());

//        //保存截图
        saveScreenshot("body > div.js-rootresizer__contents > div.layout__area--center > div > div.chart-container-border > div.chart-widget", driver, Paths.get("").toString());


        System.out.println("===== end");

    }
}
