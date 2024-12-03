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
    By btn_selectDateRange = By.xpath("//div[contains(@class,'themed_select')]");
    By btn_selectAllDates = By.xpath("//div[text()='All']");
    By link_orderID = By.xpath("(//a[contains(@href,'orders-revised')])[1]");
    String viewOrderName = "//div[text() = 'itemName']";

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

    public void clickOnAddMoreSupplier(){restaurantUI.click(btn_addMoreSuppliers);
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


}
