package tests;

import com.relevantcodes.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestNG;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Actions which should be performed before and after particular test actions
 * abstract because it will not be instantiated. Only for inheritance purposes
 */

abstract public class BaseTest {
    WebDriver driver;
    public WebDriverWait wait;
    Actions builder;
    static ExtentReports report;



    /**
     * @param pathToDriver
     * @param url
     * @param mode
     * @param device
     * method which starts before test run. It reads three parameters form testng file.
     * Depending on mode it runs emulation or desktop test. The method can be extended by adding more parameters
     * to emulation. E.g. Choice : "Nexus 5" will load default setting for this device

     */
    @Parameters({"pathToDriver","url","mode","device"})
    @BeforeClass(alwaysRun = true)
    public void setUpBeforeSuite(String pathToDriver, String url,String mode, String device ){

        if (mode.equalsIgnoreCase("emulation")){
            Map<String, String> mobileEmulation = new HashMap();
            mobileEmulation.put("deviceName", device);
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
            System.setProperty("webdriver.chrome.driver", pathToDriver );
            driver = new ChromeDriver(chromeOptions);
            driver.get(url);
        }

        else {
            System.setProperty("webdriver.chrome.driver", pathToDriver );
            driver = new ChromeDriver();
            builder = new Actions(driver);
            driver.manage().window().maximize();
            driver.get(url);
        }
    }




}
