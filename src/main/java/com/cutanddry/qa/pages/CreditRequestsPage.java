package com.cutanddry.qa.pages;

import com.cutanddry.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreditRequestsPage extends TestBase {

    By btn_request_data = By.xpath("//label[text()='Request Date:']/following-sibling::div//div[contains(@class, 'themed_select__control')]");
    By option_all = By.xpath("//div[contains(@class, 'themed_select__menu')]//div[contains(text(), 'All')]");
    By btn_search = By.xpath("//input[@placeholder='Search' and contains(@class, 'form-control')]");

    public void clickOnRequestDate() {
        //Check if it's in an iFrame
        driver.switchTo().defaultContent(); // Switch to default first if you're in another iFrame
        restaurantUI.click(btn_request_data); // Opens dropdown
    }

    public void selectAllTimeRange(String TimeRange) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(option_all)); // Wait until "All" is visible
        restaurantUI.click(option_all);
    }

    public void selectTimeRange(String timeRange) throws InterruptedException {
        // Dynamic XPath using the provided timeRange
        By option_dynamic = By.xpath("//div[contains(@class, 'themed_select__menu')]//div[contains(text(), '" + timeRange + "')]");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait max 10 seconds until the option is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(option_dynamic));
        restaurantUI.click(option_dynamic); // Click on the desired option
    }

    public void clickOnSearch(){
        restaurantUI.click(btn_search);
    }

    public void typeOnSearch(String orderID) throws InterruptedException {
        restaurantUI.clear(btn_search);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        restaurantUI.sendKeys(btn_search, orderID);
        restaurantUI.waitForCustom(400);
    }

    public boolean checkIfElementVisible(String orderID) {
        // Corrected XPath for dynamic value
        By visibleObject = By.xpath("//td[normalize-space(text())='" + orderID + "']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Wait for the element to be visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(visibleObject));
        } catch (Exception e) {
            return false; // Element is not visible
        }
        return restaurantUI.isDisplayed(visibleObject);
    }
}