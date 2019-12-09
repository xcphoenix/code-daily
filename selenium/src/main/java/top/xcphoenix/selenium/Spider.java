package top.xcphoenix.selenium;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

/**
 * @author      xuanc
 * @date        2019/12/8 下午7:09
 * @version     1.0
 */
public class Spider {

    public static WebDriver driver;

    public static void main(String[] args) {
        beforeMethod();

        // driver.navigate().to("https://blog.csdn.net/qq_39802740/article/details/82015197");

        String strPageTitle = driver.getTitle();
        System.out.println("Page title: - "+strPageTitle);
        System.out.println("Web Content: - \n" + driver.getPageSource());

        afterMethod();
    }

    public static void beforeMethod() {
        File file = new File("/home/xuanc/下载/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        // https://github.com/lightbody/browsermob-proxy#using-with-selenium
        BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.blacklistRequests("https://.*/.*.css.*",200);
        proxy.blacklistRequests("https://.*/.*.js.*",200);
        proxy.blacklistRequests("https://.*/.*.ico.*",200);
        proxy.blacklistRequests("https://adaccount.csdn.net/",200);
        proxy.blacklistRequests("http://www/.google/.*.css.*",200);
        proxy.start();
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

        final ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("blink-settings=imagesEnabled=false");
        chromeOptions.setCapability(CapabilityType.PROXY, seleniumProxy);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        long start = System.currentTimeMillis();
        driver.get("https://blog.csdn.net/qq_39802740/article/details/82015197");
        System.out.println("耗时 => " + (System.currentTimeMillis() - start));
    }

    public static void afterMethod() {
        driver.quit();
    }

}
