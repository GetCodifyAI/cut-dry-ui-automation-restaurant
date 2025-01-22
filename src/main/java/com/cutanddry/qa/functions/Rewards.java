package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.RewardsPage;

public class Rewards {

    static com.cutanddry.qa.pages.RewardsPage RewardsPage = new RewardsPage();

    public static void learnMore(){
        RewardsPage.clickOnLearnMore();
    }

    public static boolean isEarnRewardsTextDisplayed(){
        return RewardsPage.isEarnRewardsTextDisplayed();
    }

    public static void redeemBalance(){
        RewardsPage.clickOnRedeemBalance();
    }

    public static boolean isRedeemBalanceTextDisplayed(){
        return RewardsPage.isRedeemBalanceTextDisplayed();
    }

    public static void addSupplier(){
        RewardsPage.clickOnAddMoreSupplier();
    }

    public static boolean isConnectYourSupplierTextDisplayed(){
        return RewardsPage.isConnectYourSupplierTextDisplayed();
    }

    public static void connectSupplier(){
        RewardsPage.clickOnSupplierLogo();
    }

    public static boolean isSupplierTextDisplayed(){
        return RewardsPage.isSupplierTextDisplayed();
    }

    public static void goToLaunchpad(){
        RewardsPage.clickOnLaunchpad();
    }

    public static boolean isLaunchpadTextDisplayed(){
        return RewardsPage.isLaunchpadTextDisplayed();
    }

    public static void selectAllDateRange(){
        RewardsPage.clickOnDateRangeDropdown();
    }

    public static void clickAllDateRange(){
        RewardsPage.clickOnAllDateRange();
    }

    public static void clickOnOrder(){
        RewardsPage.clickOnOrder();
    }

    public static boolean isOrderTextDisplayed(String itemName){
        return RewardsPage.isOrderTextDisplayed(itemName);
    }

    public static void closePromotionOverlayIfDisplayed(){
        if(RewardsPage.isPromotionOverlayDisplayed()){
            RewardsPage.clickOnMayBeLaterTxt();
        }
    }
    public static boolean isRewardsTextDisplayed(){
        return RewardsPage.isRewardsTextDisplayed();
    }
    public static void selectRewardsFilter(String dropDown ,String dropDownOption)throws InterruptedException{
        RewardsPage.clickRewardDropDown(dropDown);
        RewardsPage.clickRewardDropDownOption(dropDownOption);
    }
    public static boolean isResultDisplayed(String result){
        return RewardsPage.isResultDisplayed(result);
    }
    public static boolean isRewardsStatusDisplayed(String status){
        return RewardsPage.isRewardsStatusDisplayed(status);
    }
}

