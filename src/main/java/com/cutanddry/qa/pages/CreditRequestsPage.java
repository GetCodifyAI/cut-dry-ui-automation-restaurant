package com.cutanddry.qa.pages;

import com.cutanddry.qa.base.TestBase;
import org.openqa.selenium.By;

public class CreditRequestsPage extends TestBase {
    By btn_report_issue = By.xpath("//button[@class='mr-3 btn btn-outline-danger']");
    By txt_report_issue = By.xpath("//h2[@class='mb-0 _1vx3fhy' and text()='Which items had an issue?']");
    By btn_first_row = By.xpath("//tr[@class='_du1frc']");
    By txt_tell_us = By.xpath("//div[@class='mont modal-title h4' and text()='Tell us more...']");
    By btn_issue_option = By.xpath("//div[@class='themed_select__value-container css-1hwfws3']");
    By btn_first_option = By.xpath("//div[@id='react-select-2-option-1']");
    By btn_continue = By.xpath("//button[@class='btn btn-primary btn-block']");
    By txt_credit_requested = By.xpath("//td[text()='Credit Requested']");
    By btn_save_checkin = By.xpath("//button[@class = 'btn btn-primary' and text() = 'Save Check-In']");
    By txt_submit_credit_request = By.xpath("//h2[@class = 'swal2-title' and text() = 'Submit Credit Request?']");
    By btn_yes = By.xpath("//button[@class = 'swal2-confirm swal2-styled' and text() = 'Yes']");
    By txt_sent_request = By.xpath("//h2[@class = 'swal2-title' and text() = 'Credit Request Sent!']");
    By btn_close = By.xpath("//button[@class = 'swal2-confirm swal2-styled' and text() = 'Close']");
    By txt_credit_status = By.xpath("//div[@class='themed_select__single-value themed_select__single-value--is-disabled css-107lb6w-singleValue' and text()='Credit Status: Requested']");

    public void clickReportIssue(){
        restaurantUI.click(btn_report_issue);
    }
    public boolean isReportIssueSectionDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_report_issue);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_report_issue);
    }
    public void clickOneItem(){
        restaurantUI.click(btn_first_row);
    }
    public boolean isIssuePopUpDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_tell_us);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_tell_us);
    }
    public void clickIssueOption() throws InterruptedException{
        restaurantUI.click(btn_issue_option);
        restaurantUI.waitForCustom(2000);
        restaurantUI.click(btn_first_option);
    }
    public void clickContinue(){
        restaurantUI.click(btn_continue);
    }
    public boolean isCreditRequestedDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_credit_requested);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_credit_requested);
    }
    public void clickSaveCheckIn(){
        restaurantUI.click(btn_save_checkin);
    }
    public boolean isSubmitCreditRequestPopupDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_submit_credit_request);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_submit_credit_request);
    }
    public void clickYes(){
        restaurantUI.click(btn_yes);
    }
    public boolean isCreditRequestSentPopupDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_sent_request);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_sent_request);
    }
    public void clickClose(){
        restaurantUI.click(btn_close);
    }
    public boolean isCreditStatusRequestedDisplay(){
        try {
            restaurantUI.waitForVisibility(txt_credit_status);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_credit_status);
    }

}
