package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.UsersPage;
import org.openqa.selenium.By;

public class Users {
    static UsersPage usersPage = new UsersPage();

    public static boolean isNavigatedToUserTab(){
        return usersPage.isUsersPageDisplayed();
    }

    public static void clickAddUser(){
        usersPage.clickAddUserBtn();
    }

    public static void typeUserName(String userName){
        usersPage.typeName(userName);
    }

    public static void typeUserEmail(String email){
        usersPage.typeEmail(email);
    }

    public static void selectLocationFromDropDown(String locationName){
        usersPage.locationSelectionDropdown(locationName);
    }

    public static void AddUser(){
        usersPage.clickOnAddUserOverlayBtn();
    }

    public static boolean isUserCreationSuccessfulOverlayDisplayed(){
        return usersPage.isSuccessOverlayDisplayed();
    }

    public static boolean isUserDeletionSuccessfulOverlayDisplayed(){
        return usersPage.isSuccessOverlayDisplayed();
    }

    public static void clickOnOkBtnInSuccessOverlay(){
        usersPage.clickOkBtn();
    }

    public static void selectUserFromUsersGrid(String userName){
        usersPage.clickOnUser(userName);
    }

    public static boolean isUserDisplayedInGrid(String username){
        return usersPage.isUserDisplayed(username);
    }

    public static void editUser(){
        usersPage.clickOnSaveChangesBtn();
    }

    public static void removeUser(){
        usersPage.clickOnDeleteBtn();
    }

    public static boolean removeConfirmationOverlayDisplayed(){
        return usersPage.isUserRemoveOverlayDisplayed();
    }
    public static boolean isUserEditable(String userName){
        return usersPage.isUserEditable(userName);
    }

}
