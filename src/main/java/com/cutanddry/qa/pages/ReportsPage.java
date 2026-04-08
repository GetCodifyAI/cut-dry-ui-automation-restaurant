package com.cutanddry.qa.pages;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.common.Constants;
import org.openqa.selenium.By;

public class ReportsPage extends TestBase {

    By btn_disabledGenerateReport = By.xpath("//button[@class='btn btn-primary js_generate pull-right' and @disabled]");
    By btn_generateReport = By.xpath("//button[@class='btn btn-primary js_generate pull-right' and text()='Generate Report']");
    By btn_selectReportType = By.xpath("//span[text()='Select Report Type']");
    By btn_monthlyExpensesByVendor = By.xpath("//a[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'REPORT')]");
    String reportTypeOption = "//a[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'REPORT')]";
    String generatedReport = "//div[@class='ibox-title']//strong[contains(text(), 'GENERATED_REPORT')]";
    By btn_table = By.xpath("//button[contains(., 'Table')]");
    By btn_csv = By.xpath("//a[contains(text(), 'CSV') and @data-id='__csv']");
    By txt_csv = By.xpath("//button[contains(., 'CSV')]");
    By txt_reports = By.xpath("//li[contains(text(),'Reports')]");
    String txt_option = "//a[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'TXT')]";
    String reportForAllVV= "//tr/td/input[contains(@value,'GATEKEEPERFEATURE')]/..//following-sibling::td//input[contains(@value,'active_for_all_vv')]";
    By dataRangeDropDown = By.xpath("//input[contains(@class,'date-range')]");
    String dataRangeOption = "//li[contains(text(),'Last 3 months')]";
    By searchBox = By.xpath("//input[@type='search']");
  //  String searchResult = "//td[text()='RESULT']";
    String searchResult = "//td[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'RESULT')]";


    public boolean isReportingTextDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(txt_reports);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_reports);
    }
    public boolean isDisabledGenerateReportButtonDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(btn_disabledGenerateReport);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(btn_disabledGenerateReport);
    }

    public void clickOnGenerateReports(){
        getRestaurantUI().click(btn_generateReport);
    }

    public void clickOnDropdownReportType(){
        getRestaurantUI().click(btn_selectReportType);
    }

    public void clickOnMonthlyExpensesByVendor(){
        getRestaurantUI().click(btn_monthlyExpensesByVendor);
    }
    public void clickOnReportTypeOption(String report){
        getRestaurantUI().waitForVisibility(By.xpath(reportTypeOption.replace("REPORT", report)));
        getRestaurantUI().click(By.xpath(reportTypeOption.replace("REPORT", report)));
    }
    public boolean isGeneratedReportDisplayed(String report){
        try {
            getRestaurantUI().waitForVisibility(By.xpath(generatedReport.replace("GENERATED_REPORT", report)));
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(By.xpath(generatedReport.replace("GENERATED_REPORT", report)));
    }
    public boolean isReportTypeDisplayed(String txt){
        try {
            getRestaurantUI().waitForVisibility(By.xpath(txt_option.replace("TXT", txt)));
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(By.xpath(txt_option.replace("TXT", txt)));
    }
    public void clickOnDropdownTable(){
        getRestaurantUI().click(btn_table);
    }

    public void clickOnCsv(){
        getRestaurantUI().click(btn_csv);
    }

    public boolean isCSVTextDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(txt_csv);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_csv);
    }

    public void turnOnReportsForWhiteLabelCustomers(){
        try {
            getRestaurantUI().waitForCustom(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getRestaurantUI().OpenNewTabAndSwitchToIt();
        getRestaurantUI().navigateToURL(Constants.GATE_KEEPER_URL);
        getRestaurantUI().scrollToElement(By.xpath(reportForAllVV.replace("GATEKEEPERFEATURE","reports_for_white_label")));
        if(!getRestaurantUI().isCheckboxSelected(By.xpath(reportForAllVV.replace("GATEKEEPERFEATURE","reports_for_white_label")))){
            getRestaurantUI().click(By.xpath(reportForAllVV.replace("GATEKEEPERFEATURE","reports_for_white_label")));
        }
        getRestaurantUI().CloseNewTabAndSwitchToOriginal();
    }
    public void searchData(String text){
        getRestaurantUI().waitForVisibility(searchBox);
        getRestaurantUI().clear(searchBox);
        getRestaurantUI().sendKeys(searchBox,text);
    }
    public boolean isSearchResultDisplayed(String result){
        try {
            getRestaurantUI().waitForVisibility(By.xpath(searchResult.replace("RESULT", result)));;
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(By.xpath(searchResult.replace("RESULT", result)));
    }


}
