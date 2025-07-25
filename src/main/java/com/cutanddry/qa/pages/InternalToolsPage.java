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
    By payDetailsToggleStable = By.xpath("//label[contains(text(), 'Pay Enabled For All Users: ')]/following-sibling::div//div[@class='react-switch-bg']/following-sibling::div[@class='react-switch-handle']");
    By payDetailsToggleStable1 = By.xpath("//label[contains(text(), 'Pay Enabled For All Users: ')]/following-sibling::div//div[@class='react-switch-bg']/following-sibling::div[@class='react-switch-handle']/parent::div/div[1]");
    By addCustomerToPayDisable = By.xpath("//label[contains(text(), 'Pay Disabled Restaurants')]/following-sibling::div/div");
    String selectDisableCustomer = "//div[contains(text(), 'NAME')]";
    String ToggleDescription = "//*[contains(text(),'TOGGLENAME')]/following-sibling::div//div[contains(@class,'react-switch-bg')]";
    By enableWillCallPickUpToggleStable = By.xpath("//div[contains(text(), 'Enable Will Call/Pickp:')]/following-sibling::div//div[@class='react-switch-bg']/following-sibling::div[@class='react-switch-handle']");
    By enableWillCallPickUpToggleStable1 = By.xpath("//div[contains(text(), 'Enable Will Call/Pickp:')]/following-sibling::div//div[@class='react-switch-bg']/following-sibling::div[@class='react-switch-handle']/parent::div/div[1]");
    By checkboxLocatorChat = By.xpath("//label[contains(text(),'Chat')]/..//input");
    By btn_saveChanges = By.xpath("(//button[text()='Save Changes'])[1]");
    By displayPurchaseHistoryToggleStable = By.xpath("//div[contains(text(), 'Display Purchase History')]/following-sibling::div//div[@class='react-switch-bg']/following-sibling::div[@class='react-switch-handle']");
    By displayPurchaseHistoryToggleStable1 = By.xpath("//div[contains(text(), 'Display Purchase History')]/following-sibling::div//div[@class='react-switch-bg']/following-sibling::div[@class='react-switch-handle']/parent::div/div[1]");
    By displayPurchasePriceOnOperatorToggleStable = By.xpath("//div[contains(text(), 'Display Purchase Price on Operator App')]/following-sibling::div//div[@class='react-switch-bg']/following-sibling::div[@class='react-switch-handle']");
    By displayPurchasePriceOnOperatorToggleStable1 = By.xpath("//div[contains(text(), 'Display Purchase Price on Operator App')]/following-sibling::div//div[@class='react-switch-bg']/following-sibling::div[@class='react-switch-handle']/parent::div/div[1]");
    By checkboxEnableFTNIPaymentGateway = By.xpath("//label[contains(text(),'Enable FTNI Payment Gateway')]/..//input");
    By hideZeroStockLabelToggleStable = By.xpath("//div[contains(text(), 'Hide zero stock label on Operator App:')]/following-sibling::div//div[@class='react-switch-bg']/following-sibling::div[@class='react-switch-handle']");
    By hideZeroStockLabelToggleStable1 = By.xpath("//div[contains(text(), 'Hide zero stock label on Operator App:')]/following-sibling::div//div[@class='react-switch-bg']/following-sibling::div[@class='react-switch-handle']/parent::div/div[1]");
    By simpleListViewDropDown = By.xpath("//div[text()='Simple List View:']/following-sibling::div/div");
    String simpleListViewDropDownOption = "(//div[text()='TYPE'])[last()]";
    By quickAddViewDropDown = By.xpath("//div[text()='Quick Add View:']/following-sibling::div/div");
    String quickAddViewDropDownOption = "(//div[text()='Quick Add View:']/following-sibling::div//div[text()='TYPE'])[last()]";
    By caseMinimumGloballyToggleStable = By.xpath("//div[contains(text(), 'Soft/Hard order Case minimum')]/following-sibling::div//div[@class='react-switch-bg']/following-sibling::div[@class='react-switch-handle']");
    By caseMinimumGloballyToggleStable1 = By.xpath("//div[contains(text(), 'Soft/Hard order Case minimum')]/following-sibling::div//div[@class='react-switch-bg']/following-sibling::div[@class='react-switch-handle']/parent::div/div[1]");










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
    public void clickPayEnabledToggle(boolean enable) {

        String handlePosition = restaurantUI.getElement(payDetailsToggleStable).getAttribute("style");
        boolean isEnabled = handlePosition.contains("translateX(29px)");

        if (enable && !isEnabled) {
            restaurantUI.clickWithScrollAndHover(payDetailsToggleStable1);
        } else if (!enable && isEnabled) {
            restaurantUI.clickWithScrollAndHover(payDetailsToggleStable1);
        }
    }
    public void addCustomerToPayDisable(String name)throws InterruptedException{
        restaurantUI.click(addCustomerToPayDisable);
        restaurantUI.scrollToElement(By.xpath(selectDisableCustomer.replace("NAME", name)));
        restaurantUI.click(By.xpath(selectDisableCustomer.replace("NAME", name)));
        restaurantUI.waitForCustom(3000);
    }
    public void enableWillCallPickUpToggle(boolean enable) {

        String handlePosition = restaurantUI.getElement(enableWillCallPickUpToggleStable).getAttribute("style");
        boolean isEnabled = handlePosition.contains("translateX(29px)");

        if (enable && !isEnabled) {
            restaurantUI.clickWithScrollAndHover(enableWillCallPickUpToggleStable1);
        } else if (!enable && isEnabled) {
            restaurantUI.clickWithScrollAndHover(enableWillCallPickUpToggleStable1);
        }
    }

    public void enableDisableToggle(String ToggleName,boolean enable ){
        String AttributeValue = restaurantUI.getElement(By.xpath(ToggleDescription.replace("TOGGLENAME",ToggleName))).getAttribute("style");
        boolean isEnabled = AttributeValue.contains("rgb(0, 136, 0)");

        if(isEnabled != enable ){
            restaurantUI.clickWithScrollAndHover(By.xpath(ToggleDescription.replace("TOGGLENAME",ToggleName)));
        }
    }
    public void clickChatCheckbox(boolean enable) {

        boolean isChecked = restaurantUI.getElement(checkboxLocatorChat).isSelected();

        if (enable && !isChecked) {
            restaurantUI.click(checkboxLocatorChat); // Check the box if not checked
        } else if (!enable && isChecked) {
            restaurantUI.click(checkboxLocatorChat); // Uncheck the box if already checked
        }
    }
    public void clickSaveChanges()throws InterruptedException{
        restaurantUI.click(btn_saveChanges);
    }
    public void displayPurchaseHistoryToggle(boolean enable) {

        String handlePosition = restaurantUI.getElement(displayPurchaseHistoryToggleStable).getAttribute("style");
        boolean isEnabled = handlePosition.contains("translateX(29px)");

        if (enable && !isEnabled) {
            restaurantUI.clickWithScrollAndHover(displayPurchaseHistoryToggleStable1);
        } else if (!enable && isEnabled) {
            restaurantUI.clickWithScrollAndHover(displayPurchaseHistoryToggleStable1);
        }
    }
    public void displayPurchasePriceOnOperatorToggle(boolean enable) {

        String handlePosition = restaurantUI.getElement(displayPurchasePriceOnOperatorToggleStable).getAttribute("style");
        boolean isEnabled = handlePosition.contains("translateX(29px)");

        if (enable && !isEnabled) {
            restaurantUI.clickWithScrollAndHover(displayPurchasePriceOnOperatorToggleStable1);
        } else if (!enable && isEnabled) {
            restaurantUI.clickWithScrollAndHover(displayPurchasePriceOnOperatorToggleStable1);
        }
    }
    public void clickEnableFTNIPaymentGatewayCheckbox(boolean enable) {

        boolean isChecked = restaurantUI.getElement(checkboxEnableFTNIPaymentGateway).isSelected();

        if (enable && !isChecked) {
            restaurantUI.click(checkboxEnableFTNIPaymentGateway); // Check the box if not checked
        } else if (!enable && isChecked) {
            restaurantUI.click(checkboxEnableFTNIPaymentGateway); // Uncheck the box if already checked
        }
    }
    public void clickHideZeroStockLabelToggle(boolean enable) {

        String handlePosition = restaurantUI.getElement(hideZeroStockLabelToggleStable).getAttribute("style");
        boolean isEnabled = handlePosition.contains("translateX(29px)");

        if (enable && !isEnabled) {
            restaurantUI.clickWithScrollAndHover(hideZeroStockLabelToggleStable1);
        } else if (!enable && isEnabled) {
            restaurantUI.clickWithScrollAndHover(hideZeroStockLabelToggleStable1);
        }
    }
    public void clickOnSimpleListViewDropdown(String type){
        restaurantUI.click(simpleListViewDropDown);
        restaurantUI.click(By.xpath(simpleListViewDropDownOption.replace("TYPE",type)));
    }
    public void clickOnQuickAddViewDropDown(String type){
        restaurantUI.click(quickAddViewDropDown);
        restaurantUI.click(By.xpath(quickAddViewDropDownOption.replace("TYPE",type)));
    }
    public void caseMinimumGloballyToggle(boolean enable) {

        String handlePosition = restaurantUI.getElement(caseMinimumGloballyToggleStable).getAttribute("style");
        boolean isEnabled = handlePosition.contains("translateX(29px)");

        if (enable && !isEnabled) {
            restaurantUI.clickWithScrollAndHover(caseMinimumGloballyToggleStable1);
        } else if (!enable && isEnabled) {
            restaurantUI.clickWithScrollAndHover(caseMinimumGloballyToggleStable1);
        }
    }


}
