package com.cutanddry.qa.pages;

import com.cutanddry.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HistoryPage extends TestBase {

    By btn_history = By.xpath("//a[contains(., 'History')]");
    By txt_history = By.xpath("//h2[text()='Order History']");
    By btn_search = By.xpath("//*[@id=\"react-boot-root\"]/div[3]/div/div/div[2]/div[4]/div/div[2]/div/div/input");

    public void clickHistory(){ restaurantUI.click(btn_history); }

    public boolean isHistoryTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_history);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_history);
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






}
