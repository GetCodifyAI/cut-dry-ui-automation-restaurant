package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

public class ChatPage extends LoginPage {

    By btn_chat_restaurant = By.xpath("//div[contains(text(), 'Independent Foods Co')]");
    By btn_hayes_restaurant = By.xpath("//div[text()='Hayes']");
    By tbx_Message = By.xpath("//input[@placeholder='Message...']");
    By icon_send = By.xpath("//span[contains(@class, '_1j33wau')]");
    String txt_lastMessage = "(//div[contains(text(),'MESSAGE')])[last()]";
    By txt_defaultMsg = By.xpath("//div[text()='Send us messages through this chat interface to clarify issues with products and orders.']");

    public void clickOnRestaurantChat() {
        restaurantUI.waitForVisibility(btn_chat_restaurant);
        restaurantUI.click(btn_chat_restaurant);
        restaurantUI.waitForVisibility(btn_hayes_restaurant);
        restaurantUI.click(btn_hayes_restaurant);
    }
    public void clickOnMessage(){
        restaurantUI.waitForVisibility(tbx_Message);
        restaurantUI.click(tbx_Message);
    }
    public void typeOnMessage(String msg) throws InterruptedException {
        restaurantUI.clear(tbx_Message);
        restaurantUI.waitForCustom(3000);
        restaurantUI.sendKeys(tbx_Message, msg);
    }
    public void clickSendButton(){
        restaurantUI.waitForElementEnabledState(icon_send,true);
        restaurantUI.waitForClickability(icon_send);
        restaurantUI.click(icon_send);
        restaurantUI.waitForVisibility(icon_send);
    }
    public String getLastMessageDisplayed(String message) throws InterruptedException {
        restaurantUI.waitForCustom(5000);
        restaurantUI.refreshPage();
        return restaurantUI.getText(By.xpath(txt_lastMessage.replace("MESSAGE",message)));
    }
    
}
