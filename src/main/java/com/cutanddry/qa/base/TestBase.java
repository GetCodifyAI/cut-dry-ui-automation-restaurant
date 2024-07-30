package com.cutanddry.qa.base;

import com.cutanddry.qa.common.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.cutanddry.qa.common.Constants.*;

public class TestBase {
    private static final Logger LOGGER = Logger.getLogger(TestBase.class.getName());
    public static WebDriver driver;

    public TestBase(){

    }

    public static void initialization(){
        if (BROWSER_NAME.equalsIgnoreCase("chrome")){
            try {
                ChromeOptions chromeOptions = new ChromeOptions();
//                chromeOptions.addArguments("--start-maximized");
//                if (RUN_HEADLESS){
//                    chromeOptions.addArguments("--headless","--window-size=1920,1080");
//                }
                driver = new ChromeDriver(chromeOptions);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                driver.get(MAIN_URL);
                LOGGER.info("WebDriver initialized and navigated to the URL: " + MAIN_URL);
            }catch (Exception e){
                LOGGER.log(Level.SEVERE, "Failed to initialize WebDriver", e);
            }

        }else {
            LOGGER.warning("WebDriver is already initialized or browser name is not 'chrome'");
        }
    }

    public static synchronized void closeAllBrowsers(){
            driver.quit();
    }
}
