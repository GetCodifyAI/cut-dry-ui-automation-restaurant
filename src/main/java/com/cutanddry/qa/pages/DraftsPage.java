package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

public class DraftsPage extends LoginPage{
    String firstDraftOrder = "(//td[contains(text(),'SUPPLIER')]/parent::tr[contains(@href,'/place-order')])[1]";

    public void clickFirstDraftOrder(String SupplierName){
        restaurantUI.click(By.xpath(firstDraftOrder.replace("SUPPLIER",SupplierName)));
    }

}
