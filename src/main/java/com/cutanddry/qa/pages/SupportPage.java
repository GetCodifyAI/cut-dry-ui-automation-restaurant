package com.cutanddry.qa.pages;

import com.cutanddry.qa.base.TestBase;
import org.openqa.selenium.By;

public class SupportPage extends TestBase {

    By icon_sup = By.xpath("//a[@href='https://operator-cutdry.happyfox.com/home/' and @data-tip='Support']");
    By support_center = By.xpath("//div[@class='hf-header-support-center-name']");

    public void clickIcon(){ restaurantUI.click(icon_sup); }

    public boolean isSupportCenterHeaderDisplayed(){
        try {
            return restaurantUI.openURL("https://operator-cutdry.happyfox.com/home/").isDisplayed(support_center);
        } catch (Exception e){
            return false;
        }
    }
}