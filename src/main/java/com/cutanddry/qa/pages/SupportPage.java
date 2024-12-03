package com.cutanddry.qa.pages;

import com.cutanddry.qa.base.TestBase;
import org.openqa.selenium.By;

public class SupportPage extends TestBase {

    By support_icon = By.xpath("//a[@data-tip='Support']");
    By support_center = By.xpath("//div[@class='hf-header-support-center-name']");

    public void clickOnSupport() throws InterruptedException {
        String url = restaurantUI.getText(support_icon,"href");
        restaurantUI.navigateToURL(url);
    }

    public boolean isSupportCenterHeaderDisplayed(){

        try {
            return restaurantUI.isDisplayed(support_center);
        } catch (Exception e){
            return false;
        }
    }
}
