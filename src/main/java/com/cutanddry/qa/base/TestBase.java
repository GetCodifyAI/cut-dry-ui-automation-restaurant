package com.cutanddry.qa.base;

import com.cutanddry.qa.common.Constants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestBase {
    private static final Logger LOGGER = Logger.getLogger(TestBase.class.getName());
    protected static WebDriver driver;
    protected static JavascriptExecutor js;
    protected static KeywordBase restaurantUI;
    protected static WebDriverWait wait;
    private static final DecimalFormat df = new DecimalFormat("#.###");

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

    public static void initializationWithUniqueUserData() {
        if (driver == null) {  // Ensure WebDriver is initialized only once
            if (Constants.BROWSER_NAME.equalsIgnoreCase("chrome")) {
                try {
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.addArguments("--user-data-dir=/tmp/chrome-user-data-" + System.currentTimeMillis());
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--disable-dev-shm-usage");
                    if (Constants.RUN_HEADLESS) {
                        chromeOptions.addArguments("--headless", "--window-size=1920,1080");
                    }
                    driver = new ChromeDriver(chromeOptions);
                    js = (JavascriptExecutor) driver;
                    wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                    driver.get(Constants.MAIN_URL);
                    restaurantUI = new KeywordBase(driver, wait);  // Initialize KeywordBase here

                    LOGGER.info("WebDriver initialized with unique user data directory and navigated to the URL: " + Constants.MAIN_URL);
                } catch (Exception e) {
                    LOGGER.log(Level.SEVERE, "Failed to initialize WebDriver with unique user data directory", e);
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
                    wait = new WebDriverWait(driver, Duration.ofSeconds(15));
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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

    // Method to close the browser and clean up resources
    public static void closeAllBrowsersAtOnce() {
        if (driver != null) {
            driver.quit();
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

    //Method to close multiple tabs
    public static void closeMultipleTabs() {
        if (driver != null) {
            // Get all the window handles
            Set<String> windowHandles = driver.getWindowHandles();

            // Iterate over all the open windows and close them
            for (String windowHandle : windowHandles) {
                driver.switchTo().window(windowHandle);
                driver.close();
            }

            driver = null;  // Reset the driver to allow re-initialization in future tests
            LOGGER.info("All browsers are closed.");
        }
    }

    public static int generateDynamicValue() {
        // Generate a random number between 1 and 100 (or any range you want)
        return (int) (Math.random() * 1000) + 1;
    }

    public static String generateThreeDigitValue() {
        int randomNumber = (int) (Math.random() * 1000) + 1;
        return String.format("%03d", randomNumber);
    }

    public static String generateUTCCurrentDateFormatted() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = new Date();
        return formatter.format(today);
    }

    public static String generateUTCYesterdayDateFormatted() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.add(Calendar.DAY_OF_YEAR, -1); // Subtract 1 day

        return formatter.format(calendar.getTime());
    }

    public static String formatDouble(double value) {
        return df.format(value);
    }

    public static String formatStringDouble(String value) {
        try {
            double doubleValue = Double.parseDouble(value); // Convert String to double
            if (doubleValue == (long) doubleValue) {
                return String.valueOf((long) doubleValue); // Remove decimal if it's .00
            } else {
                return new DecimalFormat("#.##").format(doubleValue); // Keep up to 2 decimals
            }
        } catch (NumberFormatException e) {
            return "Invalid number"; // Handle invalid input
        }
    }
    public static String generateUTCTomorrowDateFormatted() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.add(Calendar.DAY_OF_YEAR, +2); // add 1 day

        return formatter.format(calendar.getTime());
    }
    public static String generateUTCTodayDateFormatted() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));

        return formatter.format(calendar.getTime());
    }

}
