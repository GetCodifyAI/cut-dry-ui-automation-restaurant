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
    By txt_credit_request = By.xpath("//h3[@class='mt-2 mont' and text()='Credit Requests']");
    By first_row_credit_requests = By.xpath("//table[@class='table table-hover']//tbody//tr[1]");
    By txt_credit_request_section = By.xpath("//h2[@class='mb-0 _1vx3fhy' and starts-with(text(), 'Order #')]");
    By btn_process_credit = By.xpath("//button[@class='mr-3 btn btn-primary' and text()='Process Credit']");
    By txt_process_credit = By.xpath("//h2[@class='mb-0 _1vx3fhy' and text()='Process Credit']");
    By btn_check_box = By.xpath("//td/div[@class='d-flex align-items-center justify-content-center _du1frc']");
    By btn_approve_credit = By.xpath("//button[@class='btn btn-primary' and text()='Approve Credit']");
    By btn_decline_credit = By.xpath("//button[@class='mr-3 btn btn-outline-primary' and text()='Decline Credit']");
    By txt_approve_credit = By.xpath("//div[@class='mont modal-title h4' and text()='Approve Credit']");
    By txt_decline_credit = By.xpath("//div[@class='mont modal-title h4' and text()='Decline Credit']");
    By btn_submit = By.xpath("//button[@class='btn btn-primary btn-block']");
    By txt_confirm_approve = By.xpath("//h2[@id='swal2-title' and text()='Confirm Approval?']");
    By txt_confirm_decline_= By.xpath("//h2[@id='swal2-title' and text()='Decline Credit?']");
    By btn_confirm = By.xpath("//button[@class='swal2-confirm order-2 swal2-styled' and text()='Confirm']");
    By txt_approved_credit = By.xpath("//h2[@id='swal2-title' and text()='Credit Request Approved!']");
    By txt_declined_credit = By.xpath("//h2[@id='swal2-title' and text()='Credit Request Declined!']");
    By txt_credit_approved = By.xpath("//td/span[@Class='_1a5re9s' and text()='Credit Approved']");
    By txt_credit_declined = By.xpath("//td/span[@Class='_1a5re9s' and text()='Credit Declined']");




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
    //----------------------

    public boolean isCreditRequestSectionDisplay(){
        try {
            restaurantUI.waitForVisibility(txt_credit_request);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_credit_request);
    }
    public void clickCreditRequest(){
        restaurantUI.click(first_row_credit_requests);
    }
    public boolean isOrderCreditRequestSectionDisplay(){
        try {
            restaurantUI.waitForVisibility(txt_credit_request_section);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_credit_request_section);
    }
    public void clickProcessCredit(){
        restaurantUI.click(btn_process_credit);
    }
    public boolean isProcessCreditSectionDisplay(){
        try {
            restaurantUI.waitForVisibility(txt_process_credit);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_process_credit);
    }
    public void clickSelectItem(){
        restaurantUI.click(btn_check_box);
    }
    public void clickApproveCredit(){
        restaurantUI.click(btn_approve_credit);
    }
    public boolean isApproveCreditPopUpDisplay(){
        try {
            restaurantUI.waitForVisibility(txt_approve_credit);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_approve_credit);
    }
    public void clickSubmit(){
        restaurantUI.click(btn_submit);
    }
    public boolean isConfirmApprovalPopUpDisplay(){
        try {
            restaurantUI.waitForVisibility(txt_confirm_approve);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_confirm_approve);
    }
    public void clickConfirm(){
        restaurantUI.click(btn_confirm);
    }
    public boolean isCreditRequestApprovedPopUpDisplay(){
        try {
            restaurantUI.waitForVisibility(txt_approved_credit);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_approved_credit);
    }
    public boolean isCreditApprovedDisplay(){
        try {
            restaurantUI.waitForVisibility(txt_credit_approved);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_credit_approved);
    }
    public void clickDeclineCredit(){
        restaurantUI.click(btn_decline_credit);
    }
    public boolean isDeclineCreditPopUpDisplay(){
        try {
            restaurantUI.waitForVisibility(txt_decline_credit);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_decline_credit);
    }
    public boolean isConfirmDeclinePopUpDisplay(){
        try {
            restaurantUI.waitForVisibility(txt_confirm_decline_);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_confirm_decline_);
    }
    public boolean isCreditRequestDeclinedPopUpDisplay(){
        try {
            restaurantUI.waitForVisibility(txt_declined_credit);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_declined_credit);
    }
    public boolean isCreditDeclinedDisplay(){
        try {
            restaurantUI.waitForVisibility(txt_credit_declined);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_credit_declined);
    }





}
