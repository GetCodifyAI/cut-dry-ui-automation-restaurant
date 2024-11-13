package com.cutanddry.qa.pages;

import com.cutanddry.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreditRequestsPage extends TestBase {

    By btn_request_data = By.xpath("//label[text()='Request Date:']/following-sibling::div//div[contains(@class, 'themed_select__control')]");
    By btn_search = By.xpath("//input[@placeholder='Search' and contains(@class, 'form-control')]");
    By first_row_credit_requests = By.xpath("//table[@class='table table-hover']//tbody//tr[1]");
    By first_row_credit_view = By.xpath("//table[@class='table table-hover']//tbody//tr[1]");
    By txt_error = By.xpath("//*[contains(translate(text(), 'ERROR', 'error'), 'error')]");
    By btn_items = By.xpath("//a[@role='tab' and @data-rb-event-key='Items']");
    By header_items_table = By.xpath("//thead/tr[@class='_jg41os']");
    By btn_timeline = By.xpath("//a[@role='tab' and @data-rb-event-key='Timeline']");
    By header_timeline_table = By.xpath("//tr[@class='_jg41os' and th[text()='Timestamp'] and th[text()='Status'] and th[text()='Organization'] and th[text()='User'] and th[text()='Action']]");
    By btn_credit_view = By.xpath("//a[@role='tab' and @data-rb-event-key='Credit Request']");
    By header_credit_view_table = By.xpath("//tr[@class='_jg41os' and th[text()='Item Code'] and th[text()='Unit'] and th[text()='Price'] and th[text()='Qty.'] and th[text()='Issue'] and th[text()='Total'] and th[text()='Credit']]");
    By modal_issue_details = By.xpath("//div[@class='modal-header']//div[contains(@class, 'modal-title') and text()='Issue Details']");


    public void clickOnRequestDate() {
        //Check if it's in an iFrame
        driver.switchTo().defaultContent(); // Switch to default first if you're in another iFrame
        restaurantUI.click(btn_request_data); // Opens dropdown
    }

    public void selectTimeRange(String timeRange) {
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
        restaurantUI.sendKeys(btn_search, orderID);
        restaurantUI.waitForCustom(400);
    }

    public boolean checkIfSearchedElementVisible(String orderID) {
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

    public void clickOnFirstItemOfCreditRequests(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(first_row_credit_requests));
        restaurantUI.click(first_row_credit_requests);
    }

    public void clickOnItems(){
        restaurantUI.click(btn_items);
    }

    public boolean checkIfItemSectionVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            // Wait for the element to be visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(header_items_table));
        } catch (Exception e) {
            return false; // Element is not visible within the timeout
        }
        return driver.findElement(header_items_table).isDisplayed(); // Verify visibility
    }


    public boolean isErrorTextNotDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        try {
            // Wait to see if the error text becomes visible
            wait.until(ExpectedConditions.presenceOfElementLocated(txt_error));
            return false; // "error" text is found
        } catch (TimeoutException e) {
            return true; // No "error" text is found within the timeout
        }
    }

    public void clickOnTimeline(){
        restaurantUI.click(btn_timeline);
    }

    public boolean checkIfTimelineSectionVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Wait for the header row to be visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(header_timeline_table));
            return true; // Header row is displayed
        } catch (TimeoutException e) {
            return false; // Header row is not visible within the timeout
        }
    }

    public void clickOnCreditView(){
        restaurantUI.click(btn_credit_view);
    }

    public boolean checkIfCreditViewSectionVisible() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Wait for the header row to be visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(header_credit_view_table));
            return true; // Header row is visible
        } catch (TimeoutException e) {
            return false; // Header row is not visible within the timeout
        }
    }

    public void clickOnFirstItemOfCreditView(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(first_row_credit_view));
        restaurantUI.click(first_row_credit_view);
    }

    public boolean checkIfIssueDetailsModalDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(modal_issue_details));
            return true;
        } catch (TimeoutException e) {
            return false; // Modal Card is not displayed within the timeout
        }
    }




}
