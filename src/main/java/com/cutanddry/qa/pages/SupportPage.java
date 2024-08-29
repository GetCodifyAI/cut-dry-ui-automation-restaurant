package com.cutanddry.qa.pages;

import com.cutanddry.qa.base.TestBase;
import org.openqa.selenium.By;

public class SupportPage extends TestBase {

    By support_icon = By.xpath("//a[@data-tip='Support']");
    By support_center = By.xpath("//div[@class='hf-header-support-center-name']");

    public void clickIcon(){ restaurantUI.click(support_icon); }

    public boolean isSupportCenterHeaderDisplayed(){
        String url = restaurantUI.getText(support_icon,"href");
        try {
            return restaurantUI.navigateToURL(url).isDisplayed(support_center);
        } catch (Exception e){
            return false;
        }
    }
}
