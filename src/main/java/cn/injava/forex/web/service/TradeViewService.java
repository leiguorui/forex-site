package cn.injava.forex.web.service;

import cn.injava.forex.core.utils.SeleniumUtil;
import cn.injava.forex.web.dao.NewsDao;
import cn.injava.forex.web.model.News;
import cn.injava.forex.web.model.PageModel;
import org.apache.commons.lang3.StringEscapeUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.nio.file.Paths;
import java.util.List;

/**
 * tradeview 获取价格图片
 *
 * Created by Administrator on 2016/2/15.
 */
@Service
public class TradeViewService {

    private String[] currencys = {"EURUSD", "AUDUSD", "USDCAD"};
    WebDriver driver;
    JavascriptExecutor jsExecutor;

    @PostConstruct
    public void initIt() throws Exception {
        System.setProperty("webdriver.chrome.driver","D:\\workspace_personal\\forex-site\\chromedriver2.42.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        jsExecutor = (JavascriptExecutor) driver;

        driver.get("https://cn.bing.com/search?q=a&qs=n&form=QBLH&sp=-1&pq=a&sc=8-1&sk=&cvid=B113BABAC868456DB13F1178FB4A47C4");

        String[] currencys = {"EURUSD", "AUDUSD", "USDCAD"};
        for (String c : currencys){
            jsExecutor.executeScript("window.open('https://www.tradingview.com/chart/?symbol=FX:"+c+"', '_blank')");
        }

        System.out.println("==============");

    }

    @PreDestroy
    public void cleanUp() throws Exception {
        if (driver != null){
            driver.quit();
        }
    }

    public String screenShot(String currency){
        SeleniumUtil.swichByKey(currency, driver);
        jsExecutor.executeScript("$('body > div.tv-dialog__modal-wrap > div > div > div > div.tv-dialog__close.tv-blackfriday-popup__close.js-dialog__close').click()");
        return SeleniumUtil.saveScreenshot("body > div.js-rootresizer__contents > div.layout__area--center > div > div.chart-container-border > div.chart-widget", driver, "D:\\workspace_personal\\forex-site\\");
    }

}
