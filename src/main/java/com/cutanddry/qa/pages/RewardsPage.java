package com.cutanddry.qa.pages;

import com.cutanddry.qa.base.TestBase;
import org.openqa.selenium.By;

public class RewardsPage extends TestBase {

    By link_learnMore = By.xpath("//button[@class='_14btn4r p-0 _107wcic btn btn-link' and text()='Learn More']");
    By text_visibilityOfEarnRewards = By.xpath("//h4[contains(text(), 'Earn Rewards')]");
    By btn_redeemBalance = By.xpath("//button[@class='d-flex align-items-center justify-content-center cdbutton _y7yhn9 btn btn-outline-primary btn-block btn-sm' and text()='Redeem Balance']");
    By text_visibilityOfRedeemBalance = By.xpath("//div[@class='modal-title h4' and text()='Cashback Amount $146.97']");
    By btn_addMoreSuppliers = By.xpath("//button[@class='d-flex align-items-center justify-content-center cdbutton _y7yhn9 btn btn-outline-primary btn-block btn-sm' and text()='Add More Suppliers']");
    By text_visibilityOfConnectYourSupplier = By.xpath("//h4[contains(text(), 'Connect Your Suppliers')]");
    By img_connectSupplier = By.xpath("//img[contains(@src, 'ordering-supplies-images-1.s3.us-east-2.amazonaws.com')]");
    By text_visibilityOfSupplier = By.xpath("//h4[contains(text(), 'Connect to Performance Foodservice through Cut + Dry')]");
    By btn_launchpad = By.xpath("//button[@class='d-flex align-items-center justify-content-center cdbutton _y7yhn9 btn btn-outline-primary btn-block btn-sm' and text()='Go to Launchpad']");
    By text_beplLaunchpad = By.xpath("//*[contains(text(), 'Login')]");
    By btn_selectDateRange = By.xpath("//div[@class='themed_select__value-container themed_select__value-container--has-value css-1hwfws3']");
    By btn_selectAllDates = By.xpath("//div[@class='themed_select__option css-yt9ioa-option' and text()='All']");
    By link_orderID = By.xpath("//a[@class='_1xqbum8 btn btn-link' and text()='258976362']");
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

    public void clickOnRedeemBalance(){restaurantUI.click(btn_redeemBalance);
    }

    public boolean isRedeemBalanceTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(text_visibilityOfRedeemBalance);
        } catch (Exception e){
            return false;
        }
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
