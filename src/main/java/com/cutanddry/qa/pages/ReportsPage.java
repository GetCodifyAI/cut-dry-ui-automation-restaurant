package com.cutanddry.qa.pages;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.common.Constants;
import org.openqa.selenium.By;

public class ReportsPage extends TestBase {

    By btn_disabledGenerateReport = By.xpath("//button[@class='btn btn-primary js_generate pull-right' and @disabled]");
    By btn_generateReport = By.xpath("//button[@class='btn btn-primary js_generate pull-right' and text()='Generate Report']");
    By btn_selectReportType = By.xpath("//span[text()='Select Report Type']");
    By btn_monthlyExpensesByVendor = By.xpath("//a[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'monthly expenses by vendor')]");
    By txt_monthlyExpensesByVendor = By.xpath("//div[@class='ibox-title']//strong[contains(text(), 'Monthly expenses by')]");
    By btn_table = By.xpath("//button[contains(., 'Table')]");
    By btn_csv = By.xpath("//a[contains(text(), 'CSV') and @data-id='__csv']");
    By txt_csv = By.xpath("//button[contains(., 'CSV')]");
    By txt_reports = By.xpath("//li[contains(text(),'Reports')]");
    String txt_option = "//a[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'TXT')]";
    String reportForAllVV= "//tr/td/input[contains(@value,'GATEKEEPERFEATURE')]/..//following-sibling::td//input[contains(@value,'active_for_all_vv')]";


    public boolean isReportingTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_reports);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_reports);
    }
    public boolean isDisabledGenerateReportButtonDisplayed(){
        try {
            restaurantUI.waitForVisibility(btn_disabledGenerateReport);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(btn_disabledGenerateReport);
    }

    public void clickOnGenerateReports(){
        restaurantUI.click(btn_generateReport);
    }

    public void clickOnDropdownReportType(){
        restaurantUI.click(btn_selectReportType);
    }

    public void clickOnMonthlyExpensesByVendor(){
        restaurantUI.click(btn_monthlyExpensesByVendor);
    }


    public boolean isMonthlyExpensesByVendorDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_monthlyExpensesByVendor);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_monthlyExpensesByVendor);
    }
    public boolean isReportTypeDisplayed(String txt){
        try {
            restaurantUI.waitForVisibility(By.xpath(txt_option.replace("TXT", txt)));
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(By.xpath(txt_option.replace("TXT", txt)));
    }
    public void clickOnDropdownTable(){
        restaurantUI.click(btn_table);
    }

    public void clickOnCsv(){
        restaurantUI.click(btn_csv);
    }

    public boolean isCSVTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_csv);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_csv);
    }

    public void turnOnReportsForWhiteLabelCustomers(){
        try {
            restaurantUI.waitForCustom(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        restaurantUI.OpenNewTabAndSwitchToIt();
        restaurantUI.navigateToURL(Constants.GATE_KEEPER_URL);
        restaurantUI.scrollToElement(By.xpath(reportForAllVV.replace("GATEKEEPERFEATURE","reports_for_white_label")));
        if(!restaurantUI.isCheckboxSelected(By.xpath(reportForAllVV.replace("GATEKEEPERFEATURE","reports_for_white_label")))){
            restaurantUI.click(By.xpath(reportForAllVV.replace("GATEKEEPERFEATURE","reports_for_white_label")));
        }
        restaurantUI.CloseNewTabAndSwitchToOriginal();
    }

}
