package com.cutanddry.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

public class UsersPage extends LoginPage {
    By usersTab = By.xpath("//h2[@class='font-weight-900 m-0 mont' and contains(text(),'Team')]");
    By addUserBtn = By.xpath("//button[contains(text(),'Add User')]");
    By nameTextField = By.xpath("//div[@class='form-group']//label[contains(text(), 'Name')]/following-sibling::input");
    By emailTextField = By.xpath("//div[@class='form-group']//label[contains(text(), 'Email')]/following-sibling::input");
    By locationDropDown = By.xpath("//div[contains(@class,'themed_select__value-container--is-multi')]");
    By employeeDropDown = By.xpath("//div[contains(@class,'themed_select__value-container--has-value')]");
    By employeeList = By.xpath("  //div[@class='themed_select__menu-list css-11unzgr']");
    String locationName = "//div[contains(@class,'themed_select__option css-yt9ioa-option') and contains(text(),'LOCATIONNAME')]";
    By addUserOverlayBtn = By.xpath("//button[contains(@class,'btn btn-primary btn-block') and contains(text(),'Add User')]");
    By locationTxt = By.xpath("//label[@class='form-label' and contains(text(),'Location')]");
    By successTxt = By.xpath("//h2[contains(@id,'swal2-title') and contains(text(),'Success')]");
    By btn_ok = By.xpath("//button[contains(@class,'swal2-confirm swal2-styled') and contains(text(),'OK')]");
    String user = "//tr[contains(@class,'_13xlah4')]//td[text()='USERNAME']";
    By saveChangeBtn = By.xpath("//button[contains(@class,'btn btn-primary btn-block') and contains(text(),'Save Changes')]");
    By removeUserBtn = By.xpath("//button[contains(@class,'btn btn-link') and contains(text(),'Remove User')]");
    By userRemoveOverlay = By.xpath("//h2[@id='swal2-title' and contains(text(),'Are you sure you want to remove this user?')]");

    public boolean isUsersPageDisplayed() {
        return restaurantUI.isDisplayed(usersTab);
    }

    public void clickAddUserBtn(){
        restaurantUI.click(addUserBtn);
    }

    public void typeName(String userName){
        restaurantUI.sendKeys(nameTextField,userName);
    }

    public void typeEmail(String userEmail){
        restaurantUI.sendKeys(emailTextField,userEmail);
    }

    public void locationSelectionDropdown(String locationName){
        restaurantUI.click(locationDropDown);
        restaurantUI.sendKeysAndEnter(locationDropDown,locationName);
        restaurantUI.click(locationTxt);
    }

    public boolean employeeSelectionDropdown(String emp){
        restaurantUI.click(employeeDropDown);
        boolean out = restaurantUI.getText(employeeList).contains(emp);
        restaurantUI.click(employeeDropDown);
        return out;
    }
    public void clickOnAddUserOverlayBtn(){
        restaurantUI.click(addUserOverlayBtn);
    }

    public boolean isSuccessOverlayDisplayed(){
        return restaurantUI.isDisplayed(successTxt);
    }

    public void clickOkBtn(){
        try {
            restaurantUI.waitForCustom(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        restaurantUI.click(btn_ok);
    }

    public void clickOnUser(String username){
        restaurantUI.click(By.xpath(user.replace("USERNAME", username)));
    }

    public boolean isUserDisplayed(String username){
        return restaurantUI.isDisplayed(By.xpath(user.replace("USERNAME", username)));
    }

    public void clickOnSaveChangesBtn(){
        restaurantUI.click(saveChangeBtn);
    }

    public void clickOnDeleteBtn(){
        restaurantUI.click(removeUserBtn);
    }

    public boolean isUserRemoveOverlayDisplayed(){
        return restaurantUI.isDisplayed(userRemoveOverlay);
    }
    public boolean isUserEditable(String username){
        try {
            restaurantUI.waitForClickability(By.xpath(user.replace("USERNAME", username)));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
