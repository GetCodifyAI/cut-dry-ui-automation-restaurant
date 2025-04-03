package com.cutanddry.qa.pages;

import com.cutanddry.qa.base.TestBase;
import org.openqa.selenium.By;

public class InternalToolsPage extends TestBase {
    By configureSupplierLink = By.xpath("//a[contains(text(),'Configure Supplier')]");
    String editDetails = "//td[contains(text(),'SUPPLIER')]/..//td//a[contains(text(),'Edit Details')]";
    By payDetailsBtn = By.xpath("//a[contains(text(),'Pay Details')]");
    String configureInternalToolsChanges = "//label[contains(text(),'CONFIGURATION')]/..//input";
    By saveBtn = By.xpath("//button[contains(text(),'Run Invoice Sync')]/following-sibling::button[contains(text(),'Save')]");
    By successOverlay = By.xpath("//h2[contains(text(),'Succcess')]");
    By okBtn = By.xpath("//button[contains(text(),'OK')]");
    By OrderingSettingsTab = By.xpath("//a[contains(text(),'Ordering Settings')]");
    By orderMinimumGloballyToggleStable = By.xpath("//div[contains(text(), 'Enable Soft/Hard order minimum globally')]/following-sibling::div//div[@class='react-switch-bg']/following-sibling::div[@class='react-switch-handle']");
    By orderMinimumGloballyToggleStable1 = By.xpath("//div[contains(text(), 'Enable Soft/Hard order minimum globally')]/following-sibling::div//div[@class='react-switch-bg']/following-sibling::div[@class='react-switch-handle']/parent::div/div[1]");
    By orderMinimumDropDown = By.xpath("//div[text()='Order minimum type: ']/following-sibling::div/div");
    String orderMinimumDropDownOption = "(//div[text()='TYPE'])[last()]";
    By addOrderMinimum = By.xpath("//div[contains(text(),'Soft order Minimum Surcharge')]/following-sibling::div/input");
    By SaveBtn = By.xpath("//div[@class='text-right col']//button[text()='Save']");
    By checkboxLocatorCreditMemo = By.xpath("//label[contains(text(),'Enable Auto Apply Credit Memos')]/..//input");
    By reportIssueOptionToggleStable = By.xpath("//div[contains(text(), 'Enable Report Issue Option:')]/following-sibling::div//div[@class='react-switch-bg']/following-sibling::div[@class='react-switch-handle']");
    By reportIssueOptionToggleStable1 = By.xpath("//div[contains(text(), 'Enable Report Issue Option:')]/following-sibling::div//div[@class='react-switch-bg']/following-sibling::div[@class='react-switch-handle']/parent::div/div[1]");
    By hideCheckInOptionToggleStable = By.xpath("//div[contains(text(), 'Hide Check-In Option:')]/following-sibling::div//div[@class='react-switch-bg']/following-sibling::div[@class='react-switch-handle']");
    By hideCheckInOptionToggleStable1 = By.xpath("//div[contains(text(), 'Hide Check-In Option:')]/following-sibling::div//div[@class='react-switch-bg']/following-sibling::div[@class='react-switch-handle']/parent::div/div[1]");
    By successPopUp = By.xpath("//h2[contains(text(),'Success')]");









    public void clickConfigureSuppliers(){
        restaurantUI.click(configureSupplierLink);
    }

    public void clickEditDetails(String Distributor){
        restaurantUI.click(By.xpath(editDetails.replace("SUPPLIER",Distributor)));
    }

    public void clickOnPayDetailsSection(){
        restaurantUI.click(payDetailsBtn);
    }

    public void clickUncheckFromInternalTools(String Configuration){
        restaurantUI.waitForVisibility(By.xpath(configureInternalToolsChanges.replace("CONFIGURATION",Configuration)));
        if(restaurantUI.isCheckboxSelected(By.xpath(configureInternalToolsChanges.replace("CONFIGURATION",Configuration)))) {
            restaurantUI.click(By.xpath(configureInternalToolsChanges.replace("CONFIGURATION", Configuration)));
        }
    }

    public void clickSave(){
        restaurantUI.click(saveBtn);
    }

    public boolean isSuccessOverlayDisplayed(){
        return restaurantUI.isDisplayed(successOverlay);
    }

    public void clickOK(){
        restaurantUI.click(okBtn);
    }
    public void clickOnOrderingSettings(){
        restaurantUI.waitForVisibility(OrderingSettingsTab);
        restaurantUI.click(OrderingSettingsTab);
        try {
            restaurantUI.waitForCustom(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void clickTurnOnOrderMinimumGloballyToggle(boolean enable) {

        String handlePosition = restaurantUI.getElement(orderMinimumGloballyToggleStable).getAttribute("style");
        boolean isEnabled = handlePosition.contains("translateX(29px)");

        if (enable && !isEnabled) {
            restaurantUI.clickWithScrollAndHover(orderMinimumGloballyToggleStable1);
        } else if (!enable && isEnabled) {
            restaurantUI.clickWithScrollAndHover(orderMinimumGloballyToggleStable1);
        }
    }
    public void clickOnOrderMinimumDropdown(String type){
        restaurantUI.click(orderMinimumDropDown);
        restaurantUI.click(By.xpath(orderMinimumDropDownOption.replace("TYPE",type)));
    }
    public void enterOrderMinimum(String minimum){
        restaurantUI.click(addOrderMinimum);
        restaurantUI.clear(addOrderMinimum);
        restaurantUI.sendKeys(addOrderMinimum,minimum);
    }
    public void clickSaveBtn(){
        restaurantUI.scrollToElement(SaveBtn);
        restaurantUI.waitForVisibility(SaveBtn);
        restaurantUI.clickUsingJavaScript(SaveBtn);
    }
    public void clickCreditMemoCheckbox(boolean enable) {

        boolean isChecked = restaurantUI.getElement(checkboxLocatorCreditMemo).isSelected();

        if (enable && !isChecked) {
            restaurantUI.click(checkboxLocatorCreditMemo); // Check the box if not checked
        } else if (!enable && isChecked) {
            restaurantUI.click(checkboxLocatorCreditMemo); // Uncheck the box if already checked
        }
    }
    public void enableReportIssueOptionToggle(boolean enable) {

        String handlePosition = restaurantUI.getElement(reportIssueOptionToggleStable).getAttribute("style");
        boolean isEnabled = handlePosition.contains("translateX(29px)");

        if (enable && !isEnabled) {
            restaurantUI.clickWithScrollAndHover(reportIssueOptionToggleStable1);
        } else if (!enable && isEnabled) {
            restaurantUI.clickWithScrollAndHover(reportIssueOptionToggleStable1);
        }
    }
    public void disableHideCheckInOptionToggle(boolean enable) {

        String handlePosition = restaurantUI.getElement(hideCheckInOptionToggleStable).getAttribute("style");
        boolean isEnabled = handlePosition.contains("translateX(29px)");

        if (enable && !isEnabled) {
            restaurantUI.clickWithScrollAndHover(hideCheckInOptionToggleStable1);
        } else if (!enable && isEnabled) {
            restaurantUI.clickWithScrollAndHover(hideCheckInOptionToggleStable1);
        }
    }
    public boolean isSuccessPopUpDisplayed(){
        return restaurantUI.isDisplayed(successPopUp);
    }



}
