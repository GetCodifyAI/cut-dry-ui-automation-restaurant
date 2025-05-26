package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.ChatPage;

public class Chat {

    static ChatPage chatPage = new ChatPage();

    public static void clickOnRestaurantChat() {
        chatPage.clickOnRestaurantChat();
    }
    public static void sendRestaurantMessage(String msg) throws InterruptedException {
        chatPage.clickOnMessage();
        chatPage.typeOnMessage(msg);
        chatPage.clickSendButton();
    }
    public static String getLastMessageDisplayed(String message) throws InterruptedException {
        return chatPage.getLastMessageDisplayed(message);
    }


}

