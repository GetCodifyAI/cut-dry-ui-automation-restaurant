package com.cutanddry.qa.functions;


import com.cutanddry.qa.pages.OrderPage;

public class Order {
    static OrderPage orderPage = new OrderPage();

    public static void clickAddNewSupplier(){
        orderPage.clickAddNewSupplier();
    }
    public static boolean isAddedNewSupplierDisplayed(String supplier)throws InterruptedException{
        return orderPage.isAddedNewSupplierDisplayed(supplier);
    }
    public static void goToOrder(){
        orderPage.clickOrder();
    }
    public static boolean isPlaceOrderTextDisplayed(){
        return orderPage.isPlaceOrderTextDisplayed();
    }
    public static void selectOneSupplier(String editSupplierName) throws InterruptedException {
        orderPage.clickOnOneSupplier(editSupplierName);
    }
    public static void clickFinishSetup(){
        orderPage.clickFinishSetup();
    }
    public static boolean isNavigateEditOrderGuide(){
        return orderPage.isNavigateEditOrderGuide();
    }
    public static void clickUploadFile(){
        orderPage.clickUploadFile();
    }
    public static void clickNext(){
        orderPage.clickNext();
    }
    public static void clickConfirm(){
        orderPage.clickConfirm();
    }
    public static void clickOK()throws InterruptedException{
        orderPage.clickOK();
    }
    public static boolean isNewlyAddedOrderGuideDisplayed(){
        return orderPage.isNewlyAddedOrderGuideDisplayed();
    }
    public static void clickEditSupplier()throws InterruptedException{
        orderPage.clickThreeDotDropDown();
        orderPage.clickEditSupplierOption();
    }


}
