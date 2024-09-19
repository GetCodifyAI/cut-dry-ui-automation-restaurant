package com.cutanddry.qa.base;

import com.cutanddry.qa.common.Constants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestBase {
    private static final Logger LOGGER = Logger.getLogger(TestBase.class.getName());
    protected static WebDriver driver;
    protected static JavascriptExecutor js;
    protected static KeywordBase restaurantUI;
    protected static WebDriverWait wait;

    // Initialization method to set up the WebDriver and other components
    public static void initialization() {
        if (driver == null) {  // Ensure WebDriver is initialized only once
            if (Constants.BROWSER_NAME.equalsIgnoreCase("chrome")) {
                try {
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    if (Constants.RUN_HEADLESS) {
                        chromeOptions.addArguments("--headless", "--window-size=1920,1080");
                    }
                    driver = new ChromeDriver(chromeOptions);
                    js = (JavascriptExecutor) driver;
                    wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                    driver.get(Constants.MAIN_URL);
                    restaurantUI = new KeywordBase(driver, wait);  // Initialize KeywordBase here

                    LOGGER.info("WebDriver initialized and navigated to the URL: " + Constants.MAIN_URL);
                } catch (Exception e) {
                    LOGGER.log(Level.SEVERE, "Failed to initialize WebDriver", e);
                }
            } else {
                LOGGER.warning("Unsupported browser or WebDriver is already initialized.");
            }
        }
    }

    public static void secInitialization() {
        if (driver == null) {  // Ensure WebDriver is initialized only once
            if (Constants.BROWSER_NAME.equalsIgnoreCase("chrome")) {
                try {
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    if (Constants.RUN_HEADLESS) {
                        chromeOptions.addArguments("--headless", "--window-size=1920,1080");
                    }
                    driver = new ChromeDriver(chromeOptions);
                    js = (JavascriptExecutor) driver;
                    wait = new WebDriverWait(driver, Duration.ofSeconds(40));
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
                    driver.get(Constants.SEC_URL);
                    restaurantUI = new KeywordBase(driver, wait);  // Initialize KeywordBase here

                    LOGGER.info("WebDriver initialized and navigated to the URL: " + Constants.SEC_URL);
                } catch (Exception e) {
                    LOGGER.log(Level.SEVERE, "Failed to initialize WebDriver", e);
                }
            } else {
                LOGGER.warning("Unsupported browser or WebDriver is already initialized.");
            }
        }
    }

    // Method to close the browser and clean up resources
    public static void closeAllBrowsers() {
        if (driver != null) {
            driver.close();
            driver = null;  // Reset the driver to allow re-initialization in future tests
            LOGGER.info("All browsers are closed.");
        }
    }

    public static void takeScreenshotOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            String testName = result.getName();
            restaurantUI.captureScreenshot(testName);
        }
    }
}
