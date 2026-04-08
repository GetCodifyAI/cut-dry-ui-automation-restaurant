package com.cutanddry.qa.pages;

import com.cutanddry.qa.base.TestBase;
import org.openqa.selenium.By;

public class RewardsPage extends TestBase {

    By link_learnMore = By.xpath("//button[contains(text(),'Learn More')]");
    By text_visibilityOfEarnRewards = By.xpath("//*[contains(text(),'Get Rewarded for Ordering')]");
    By btn_redeemBalance = By.xpath("//button[contains(text(),'Withdraw Balance')]");
    By text_visibilityOfRedeemBalance = By.xpath("//div[contains(text(),'Withdraw Rewards')]");
    By btn_addMoreSuppliers = By.xpath("//button[contains(text(),'Add More Suppliers')]");
    By text_visibilityOfConnectYourSupplier = By.xpath("//h4[contains(text(),'Connect Your Suppliers')]");
    By img_connectSupplier = By.xpath("//div[contains(@class,'px-2 col-md-4')][1]");
    By text_visibilityOfSupplier = By.xpath("//h4[contains(text(),'Connect to Performance')]");
    By btn_launchpad = By.xpath("//button[contains(text(),'Go to Launchpad')]");
    By text_beplLaunchpad = By.xpath("//p[contains(text(),'Welcome to')]");
    By btn_selectDateRange = By.xpath("(//div[text()='Date Range']/../following-sibling::div)[last()]");
    By btn_selectAllDates = By.xpath("(//div[text()='All'])[last()]");
    By link_orderID = By.xpath("(//a[contains(@href,'orders-revised')])[1]");
    String viewOrderName = "//div[text() = 'itemName']";
    By promotioOverlay = By.xpath("//*[contains(text(),'You could be earning more!')]");
    By mayBeLaterTxt = By.xpath("//*[contains(text(),'Maybe Later')]");
    By txt_rewards = By.xpath("//li[text()='Rewards']");
    String rewardsDropDown = "//div[text()='DROPDOWN']/../following-sibling::*//div[contains(text(),'Select...')]";
    String dropDownOption = "//div[contains(text(),'DROPDOWNOPTION')]";
    String dropDownResult = "//th[normalize-space(text())='Reward Provider']/../../following-sibling::*//td[contains(normalize-space(text()),'RESULT')]";
    String rewardsStatus = "//div[contains(text(),'STATUS')]";
    By btn_ExternalReward = By.xpath("//a[@role='tab' and normalize-space()='External Rewards']");


    public void clickOnLearnMore(){getRestaurantUI().click(link_learnMore);
    }

    public boolean isEarnRewardsTextDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(text_visibilityOfEarnRewards);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(text_visibilityOfEarnRewards);
    }

    public void clickOnRedeemBalance(){
        getRestaurantUI().waitForClickability(btn_redeemBalance);
        getRestaurantUI().hoverOverElement(btn_redeemBalance);
        try {
            getRestaurantUI().waitForCustom(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getRestaurantUI().clickUsingJavaScript(btn_redeemBalance);}

    public boolean isRedeemBalanceTextDisplayed(){
        getRestaurantUI().waitForVisibility(text_visibilityOfRedeemBalance);
        return getRestaurantUI().isDisplayed(text_visibilityOfRedeemBalance);
    }

    public void clickOnAddMoreSupplier(){
        getRestaurantUI().waitForVisibility(btn_addMoreSuppliers);
        getRestaurantUI().click(btn_addMoreSuppliers);
    }

    public boolean isConnectYourSupplierTextDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(text_visibilityOfConnectYourSupplier);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(text_visibilityOfConnectYourSupplier);
    }

    public void clickOnSupplierLogo(){getRestaurantUI().click(img_connectSupplier);
    }

    public boolean isSupplierTextDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(text_visibilityOfSupplier);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(text_visibilityOfSupplier);
    }

    public void clickOnLaunchpad(){getRestaurantUI().click(btn_launchpad);
    }

    public boolean isLaunchpadTextDisplayed(){
        getRestaurantUI().switchToNewTab();
        return getRestaurantUI().isDisplayed(text_beplLaunchpad);
    }

    public void clickOnDateRangeDropdown(){
        getRestaurantUI().click(btn_selectDateRange);
    }

    public void clickOnAllDateRange(){
        getRestaurantUI().click(btn_selectAllDates);
    }

    public void clickOnOrder(){
        getRestaurantUI().click(link_orderID);
    }

    public boolean isOrderTextDisplayed(String productName){
        try {
            getRestaurantUI().waitForVisibility(By.xpath(viewOrderName.replace("itemName",productName)));
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(By.xpath(viewOrderName.replace("itemName",productName)));
    }

    public boolean isPromotionOverlayDisplayed(){
        return getRestaurantUI().isDisplayed(promotioOverlay);
    }

    public void clickOnMayBeLaterTxt(){
        getRestaurantUI().click(mayBeLaterTxt);
    }
    public boolean isRewardsTextDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(txt_rewards);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_rewards);
    }
    public void clickRewardDropDown(String dropDown)throws InterruptedException{
        getRestaurantUI().waitForVisibility(By.xpath(rewardsDropDown.replace("DROPDOWN",dropDown)));
        getRestaurantUI().click(By.xpath(rewardsDropDown.replace("DROPDOWN",dropDown)));
    }
    public void clickRewardDropDownOption(String Option)throws InterruptedException{
        getRestaurantUI().waitForVisibility(By.xpath(dropDownOption.replace("DROPDOWNOPTION",Option)));
        getRestaurantUI().click(By.xpath(dropDownOption.replace("DROPDOWNOPTION",Option)));
    }
    public boolean isResultDisplayed(String result){
        return getRestaurantUI().isDisplayed(By.xpath(dropDownResult.replace("RESULT",result)));
    }
    public boolean isRewardsStatusDisplayed(String status){
        try {
            getRestaurantUI().waitForVisibility(By.xpath(rewardsStatus.replace("STATUS",status)));
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(By.xpath(rewardsStatus.replace("STATUS",status)));
    }
    public void clickOnExternalReward() throws InterruptedException {
        getRestaurantUI().clickWithFallback(btn_ExternalReward);
    }

}
