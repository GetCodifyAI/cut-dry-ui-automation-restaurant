package com.cutanddry.qa.pages;

import com.cutanddry.qa.base.TestBase;
import org.openqa.selenium.By;

public class RewardsPage extends TestBase {

    By link_learnMore = By.xpath("//button[contains(text(),'Learn More')]");
    By text_visibilityOfEarnRewards = By.xpath("//h4[contains(text(),'Earn Rewards Ordering Here')]");
    By btn_redeemBalance = By.xpath("//button[contains(text(),'Redeem Balance')]");
    By text_visibilityOfRedeemBalance = By.xpath("//div[contains(text(),'Cashback Amount')]");
    By btn_addMoreSuppliers = By.xpath("//button[contains(text(),'Add More Suppliers')]");
    By text_visibilityOfConnectYourSupplier = By.xpath("//h4[contains(text(),'Connect Your Suppliers')]");
    By img_connectSupplier = By.xpath("//div[contains(@class,'px-2 col-md-4')][1]");
    By text_visibilityOfSupplier = By.xpath("//h4[contains(text(),'Connect to Performance')]");
    By btn_launchpad = By.xpath("//button[contains(text(),'Go to Launchpad')]");
    By text_beplLaunchpad = By.xpath("//p[contains(text(),'Welcome to')]");
    By btn_selectDateRange = By.xpath("//label[text()='Date Range']/following-sibling::div");
    By btn_selectAllDates = By.xpath("//div[text()='All']");
    By link_orderID = By.xpath("(//a[contains(@href,'orders-revised')])[1]");
    String viewOrderName = "//div[text() = 'itemName']";
    By promotioOverlay = By.xpath("//*[contains(text(),'You could be earning more!')]");
    By mayBeLaterTxt = By.xpath("//*[contains(text(),'Maybe Later')]");
    By txt_rewards = By.xpath("//div[text()='Cut+Dry Rewards']");
    String rewardsDropDown = "//label[text()='DROPDOWN']/following-sibling::*//div[contains(text(),'Select...')]";
    String dropDownOption = "//div[contains(text(),'DROPDOWNOPTION')]";
    String dropDownResult = "//td[contains(text(),'RESULT')]";
    String rewardsStatus = "//button[contains(text(),'STATUS')]";

    public void clickOnLearnMore(){restaurantUI.click(link_learnMore);
    }

    public boolean isEarnRewardsTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(text_visibilityOfEarnRewards);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(text_visibilityOfEarnRewards);
    }

    public void clickOnRedeemBalance(){
        restaurantUI.waitForClickability(btn_redeemBalance);
        restaurantUI.hoverOverElement(btn_redeemBalance);
        try {
            restaurantUI.waitForCustom(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        restaurantUI.clickUsingJavaScript(btn_redeemBalance);}

    public boolean isRedeemBalanceTextDisplayed(){
        restaurantUI.waitForVisibility(text_visibilityOfRedeemBalance);
        return restaurantUI.isDisplayed(text_visibilityOfRedeemBalance);
    }

    public void clickOnAddMoreSupplier(){
        restaurantUI.waitForVisibility(btn_addMoreSuppliers);
        restaurantUI.click(btn_addMoreSuppliers);
    }

    public boolean isConnectYourSupplierTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(text_visibilityOfConnectYourSupplier);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(text_visibilityOfConnectYourSupplier);
    }

    public void clickOnSupplierLogo(){restaurantUI.click(img_connectSupplier);
    }

    public boolean isSupplierTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(text_visibilityOfSupplier);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(text_visibilityOfSupplier);
    }

    public void clickOnLaunchpad(){restaurantUI.click(btn_launchpad);
    }

    public boolean isLaunchpadTextDisplayed(){
        restaurantUI.switchToNewTab();
        return restaurantUI.isDisplayed(text_beplLaunchpad);
    }

    public void clickOnDateRangeDropdown(){
        restaurantUI.click(btn_selectDateRange);
    }

    public void clickOnAllDateRange(){
        restaurantUI.click(btn_selectAllDates);
    }

    public void clickOnOrder(){
        restaurantUI.click(link_orderID);
    }

    public boolean isOrderTextDisplayed(String productName){
        try {
            restaurantUI.waitForVisibility(By.xpath(viewOrderName.replace("itemName",productName)));
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(By.xpath(viewOrderName.replace("itemName",productName)));
    }

    public boolean isPromotionOverlayDisplayed(){
        return restaurantUI.isDisplayed(promotioOverlay);
    }

    public void clickOnMayBeLaterTxt(){
        restaurantUI.click(mayBeLaterTxt);
    }
    public boolean isRewardsTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_rewards);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_rewards);
    }
    public void clickRewardDropDown(String dropDown)throws InterruptedException{
        restaurantUI.waitForVisibility(By.xpath(rewardsDropDown.replace("DROPDOWN",dropDown)));
        restaurantUI.click(By.xpath(rewardsDropDown.replace("DROPDOWN",dropDown)));
    }
    public void clickRewardDropDownOption(String Option)throws InterruptedException{
        restaurantUI.waitForVisibility(By.xpath(dropDownOption.replace("DROPDOWNOPTION",Option)));
        restaurantUI.click(By.xpath(dropDownOption.replace("DROPDOWNOPTION",Option)));
    }
    public boolean isResultDisplayed(String result){
        try {
            restaurantUI.waitForVisibility(By.xpath(dropDownResult.replace("RESULT",result)));
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(By.xpath(dropDownResult.replace("RESULT",result)));
    }
    public boolean isRewardsStatusDisplayed(String status){
        try {
            restaurantUI.waitForVisibility(By.xpath(rewardsStatus.replace("STATUS",status)));
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(By.xpath(rewardsStatus.replace("STATUS",status)));
    }

}
