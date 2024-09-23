package com.cutanddry.qa.base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;


@SuppressWarnings("UnusedReturnValue")
public class KeywordBase {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;
    private static final Logger logger = LoggerFactory.getLogger(KeywordBase.class);

    public KeywordBase(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.actions = new Actions(driver);
    }

    // Open a URL
    public KeywordBase openURL(String url) {
        try {
            driver.get(url);
            logger.info("Opened URL: {}", url);
        } catch (Exception e) {
            logger.error("Failed to open URL: {}", url, e);
        }
        return this;
    }

    // Click on an element using By object
    public KeywordBase click(By by) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
            element.click();
            logger.info("Clicked on element: {}", by);
        } catch (Exception e) {
            logger.error("Failed to click on element: {}", by, e);
        }
        return this;
    }

    // Send keys to hidden element using By object
    public KeywordBase sendKeysHiddenElements(By by, String data) {
        try {
            WebElement element = driver.findElement(by);
            element.sendKeys(data);
            logger.info("Sent keys to element: {} with data: {}", by, data);
        } catch (Exception e) {
            logger.error("Failed to send keys to element: {} with data: {}", by, data, e);
        }
        return this;
    }

    public KeywordBase sendKeys(By by, String data) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            element.clear(); // Clear the field before typing
            element.sendKeys(data);
            logger.info("Sent keys to element: {} with data: {}", by, data);
        } catch (Exception e) {
            logger.error("Failed to send keys to element: {} with data: {}", by, data, e);
        }
        return this;
    }

    // Clear an input field
    public KeywordBase clear(By by) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            element.clear();
            logger.info("Cleared element: {}", by);
        } catch (Exception e) {
            logger.error("Failed to clear element: {}", by, e);
        }
        return this;
    }

    // Get text from an element
    public String getText(By by) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            String text = element.getText();
            logger.info("Got text from element: {} - Text: {}", by, text);
            return text;
        } catch (Exception e) {
            logger.error("Failed to get text from element: {}", by, e);
            return null;
        }
    }

    public String getText(By by, int index) {
        try {
            List<WebElement> elements = driver.findElements(by);
            if (index >= 0 && index < elements.size()) {
                String text = elements.get(index).getText();
                logger.info("Got text from element at index {}: {} - Text: {}", index, by, text);
                return text;
            } else {
                logger.warn("Index {} is out of bounds for elements located by: {}", index, by);
                return null;
            }
        } catch (Exception e) {
            logger.error("Failed to get text from element at index {} located by: {}", index, by, e);
            return null;
        }
    }

    public String getText(By by, String attribute) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            String value = element.getAttribute(attribute);
            logger.info("Got attribute '{}' value from element: {} - Value: {}", attribute, by, value);
            return value;
        } catch (Exception e) {
            logger.error("Failed to get attribute '{}' value from element: {}", attribute, by, e);
            return null;
        }
    }

    // Verify if an element is displayed
    public boolean isDisplayed(By by) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            boolean isDisplayed = element.isDisplayed();
            logger.info("Element is displayed: {}", by);
            return isDisplayed;
        } catch (NoSuchElementException e) {
            logger.warn("Element not found: {}", by, e);
            return false;
        } catch (Exception e) {
            logger.error("Failed to check if element is displayed: {}", by, e);
            return false;
        }
    }

    // Wait for an element to be visible
    public KeywordBase waitForVisibility(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            logger.info("Waited for visibility of element: {}", by);
        } catch (Exception e) {
            logger.error("Failed to wait for visibility of element: {}", by, e);
        }
        return this;
    }

    // Wait for an element to be clickable
    public KeywordBase waitForClickability(By by) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by));
            logger.info("Waited for clickability of element: {}", by);
        } catch (Exception e) {
            logger.error("Failed to wait for clickability of element: {}", by, e);
        }
        return this;
    }

    public KeywordBase waitForElementEnabledState(By by, boolean shouldBeEnabled) {
        try {
            wait.until((ExpectedCondition<Boolean>) driver -> {
                assert driver != null;
                WebElement element = driver.findElement(by);
                return shouldBeEnabled == element.isEnabled();
            });
            logger.info("Waited for element {} to be {}.", by, shouldBeEnabled ? "enabled" : "disabled");
        } catch (Exception e) {
            logger.error("Failed to wait for element {} to be {}.", by, shouldBeEnabled ? "enabled" : "disabled", e);
        }
        return this;
    }

    public KeywordBase waitForInvisibility(By by) {
        try {
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(by)));
            logger.info("Waited for invisibility of element: {}", by);
        } catch (Exception e) {
            logger.error("Failed to wait for invisibility of element: {}", by, e);
        }
        return this;
    }

    public KeywordBase waitForCustom(long time) throws InterruptedException {
        Thread.sleep(time);
        return this;
    }


    // Select from a dropdown by visible text
    public KeywordBase selectByVisibleText(By by, String visibleText) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
            Select select = new Select(element);
            select.selectByVisibleText(visibleText);
            logger.info("Selected by visible text: {} from element: {}", visibleText, by);
        } catch (Exception e) {
            logger.error("Failed to select by visible text: {} from element: {}", visibleText, by, e);
        }
        return this;
    }

    // Select from a dropdown by value
    public KeywordBase selectByValue(By by, String value) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
            Select select = new Select(element);
            select.selectByValue(value);
            logger.info("Selected by value: {} from element: {}", value, by);
        } catch (Exception e) {
            logger.error("Failed to select by value: {} from element: {}", value, by, e);
        }
        return this;
    }

    // Select from a dropdown by index
    public KeywordBase selectByIndex(By by, int index) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
            Select select = new Select(element);
            select.selectByIndex(index);
            logger.info("Selected by index: {} from element: {}", index, by);
        } catch (Exception e) {
            logger.error("Failed to select by index: {} from element: {}", index, by, e);
        }
        return this;
    }

    // Handle alert - accept
    public KeywordBase acceptAlert() {
        try {
            driver.switchTo().alert().accept();
            logger.info("Accepted alert");
        } catch (Exception e) {
            logger.error("Failed to accept alert", e);
        }
        return this;
    }

    // Handle alert - dismiss
    public KeywordBase dismissAlert() {
        try {
            driver.switchTo().alert().dismiss();
            logger.info("Dismissed alert");
        } catch (Exception e) {
            logger.error("Failed to dismiss alert", e);
        }
        return this;
    }

    // Get alert text
    public String getAlertText() {
        try {
            String alertText = driver.switchTo().alert().getText();
            logger.info("Got alert text: {}", alertText);
            return alertText;
        } catch (Exception e) {
            logger.error("Failed to get alert text", e);
            return null;
        }
    }

    // Switch to a frame by index
    public KeywordBase switchToFrameByIndex(int index) {
        try {
            driver.switchTo().frame(index);
            logger.info("Switched to frame by index: {}", index);
        } catch (Exception e) {
            logger.error("Failed to switch to frame by index: {}", index, e);
        }
        return this;
    }

    // Switch to a frame by name or ID
    public KeywordBase switchToFrameByNameOrId(String nameOrId) {
        try {
            driver.switchTo().frame(nameOrId);
            logger.info("Switched to frame by name or ID: {}", nameOrId);
        } catch (Exception e) {
            logger.error("Failed to switch to frame by name or ID: {}", nameOrId, e);
        }
        return this;
    }

    // Switch to a frame by WebElement
    public KeywordBase switchToFrameByElement(By by) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            driver.switchTo().frame(element);
            logger.info("Switched to frame by element: {}", by);
        } catch (Exception e) {
            logger.error("Failed to switch to frame by element: {}", by, e);
        }
        return this;
    }

    // Switch back to the default content (out of the frame)
    public KeywordBase switchToDefaultContent() {
        try {
            driver.switchTo().defaultContent();
            logger.info("Switched to default content");
        } catch (Exception e) {
            logger.error("Failed to switch to default content", e);
        }
        return this;
    }

    // Scroll to an element
    public KeywordBase scrollToElement(By by) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            logger.info("Scrolled to element: {}", by);
        } catch (Exception e) {
            logger.error("Failed to scroll to element: {}", by, e);
        }
        return this;
    }

    // Scroll by pixels
    public KeywordBase scrollByPixels(int x, int y) {
        try {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(" + x + "," + y + ");");
            logger.info("Scrolled by pixels: x={}, y={}", x, y);
        } catch (Exception e) {
            logger.error("Failed to scroll by pixels: x={}, y={}", x, y, e);
        }
        return this;
    }

    // Click using JavaScript (useful when normal click doesn't work)
    public KeywordBase clickUsingJavaScript(By by) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            logger.info("Clicked using JavaScript on element: {}", by);
        } catch (Exception e) {
            logger.error("Failed to click using JavaScript on element: {}", by, e);
        }
        return this;
    }

    // Hover over an element
    public KeywordBase hoverOverElement(By by) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            actions.moveToElement(element).perform();
            logger.info("Hovered over element: {}", by);
        } catch (Exception e) {
            logger.error("Failed to hover over element: {}", by, e);
        }
        return this;
    }

    // Drag and drop from one element to another
    public KeywordBase dragAndDrop(By sourceBy, By targetBy) {
        try {
            WebElement sourceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(sourceBy));
            WebElement targetElement = wait.until(ExpectedConditions.visibilityOfElementLocated(targetBy));
            actions.dragAndDrop(sourceElement, targetElement).perform();
            logger.info("Dragged and dropped from element: {} to element: {}", sourceBy, targetBy);
        } catch (Exception e) {
            logger.error("Failed to drag and drop from element: {} to element: {}", sourceBy, targetBy, e);
        }
        return this;
    }

    // Double-click on an element
    public KeywordBase doubleClick(By by) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
            actions.doubleClick(element).perform();
            logger.info("Double-clicked on element: {}", by);
        } catch (Exception e) {
            logger.error("Failed to double-click on element: {}", by, e);
        }
        return this;
    }

    // Right-click (context click) on an element
    public KeywordBase rightClick(By by) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
            actions.contextClick(element).perform();
            logger.info("Right-clicked on element: {}", by);
        } catch (Exception e) {
            logger.error("Failed to right-click on element: {}", by, e);
        }
        return this;
    }

    // Refresh the page
    public KeywordBase refreshPage() {
        try {
            driver.navigate().refresh();
            logger.info("Refreshed the page");
        } catch (Exception e) {
            logger.error("Failed to refresh the page", e);
        }
        return this;
    }

    // Navigate to a URL
    public KeywordBase navigateToURL(String url) {
        try {
            driver.navigate().to(url);
            logger.info("Navigated to URL: {}", url);
        } catch (Exception e) {
            logger.error("Failed to navigate to URL: {}", url, e);
        }
        return this;
    }

    // Go back in browser history
    public KeywordBase goBack() {
        try {
            driver.navigate().back();
            logger.info("Navigated back in browser history");
        } catch (Exception e) {
            logger.error("Failed to navigate back in browser history", e);
        }
        return this;
    }

    // Go forward in browser history
    public KeywordBase goForward() {
        try {
            driver.navigate().forward();
            logger.info("Navigated forward in browser history");
        } catch (Exception e) {
            logger.error("Failed to navigate forward in browser history", e);
        }
        return this;
    }

    // Maximize the browser window
    public KeywordBase maximizeWindow() {
        try {
            driver.manage().window().maximize();
            logger.info("Maximized the browser window");
        } catch (Exception e) {
            logger.error("Failed to maximize the browser window", e);
        }
        return this;
    }

    // Close the current browser window
    public KeywordBase closeBrowser() {
        try {
            driver.close();
            logger.info("Closed the browser window");
        } catch (Exception e) {
            logger.error("Failed to close the browser window", e);
        }
        return this;
    }

    // Quit the browser (close all windows)
    public KeywordBase quitBrowser() {
        try {
            driver.quit();
            logger.info("Quit the browser and closed all windows");
        } catch (Exception e) {
            logger.error("Failed to quit the browser", e);
        }
        return this;
    }

    // Method to capture a screenshot
    public void captureScreenshot(String testName) {
        try {
            // Generate a timestamp to make the filename unique
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            // Cast driver to TakesScreenshot
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            // Define the destination path
            File destFile = new File("target/surefire-reports/screenshots/" + testName + "_" + timestamp + ".png");
            // Copy the screenshot to the destination
            FileUtils.copyFile(srcFile, destFile);
            logger.info("Screenshot taken for test: " + testName + " at " + timestamp);
        } catch (IOException e) {
            logger.error("Failed to take screenshot for test: " + testName, e);
        }
    }
    public void switchToNewTab() {
        String originalWindow = driver.getWindowHandle();

        // Wait for the new tab to open (optional, depending on your application)
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> driver.getWindowHandles().size() > 1);

        // Switch to the new tab
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break; // Exit loop once switched to new tab
            }
        }
    }

}

