package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

public class CustomersPage extends LoginPage {

    By lbl_itemNameList = By.xpath("//td//span/div[@data-tip='View Product Details']");
//    By btn_increaseQtyFirstRow = By.xpath("//tr[1]/td[6]/div/div/div/div[3]");
By btn_increaseQtyFirstRow = By.xpath("(//tr/td//div[contains(@data-tip,'View Product Details')]/following::td//div/*[contains(@data-icon,'plus')])[1]");
//    By btn_decreaseQtyFirstRow = By.xpath("//tr[1]/td[6]/div/div/div/div[1]");
By btn_decreaseQtyFirstRow = By.xpath("(//tr/td//div[contains(@data-tip,'View Product Details')]/following::td//div/*[contains(@data-icon,'minus')])[1]");
    By btn_decreaseQtySecondRow = By.xpath("//tr[2]/td[6]/div/div/div/div[1]");
    By btn_increaseQtySecondRow = By.xpath("//tr[2]/td[6]/div/div/div/div[3]");
    By btn_checkout = By.xpath("//button[@data-for='cartCheckoutButton']");
    By txt_catalog = By.xpath("//div[contains(text(), 'Item Type')]");
    By btn_catalog = By.xpath("//div[text()='Catalog']");
    By btn_catalogToOrderGuide = By.xpath("//div[text()='Order Guide']");
    By tbx_catalogSearch = By.xpath("//input[@placeholder='Search catalog...']");
    By tbx_orderGuideSearch = By.xpath("//input[@placeholder='Search order guide...']");
    //By lbl_catalogSearchItemList = By.xpath("(//button[contains(@data-for,'tooltipundefined')]/ancestor::div[2]/following-sibling::div[2]/div/div)[1]");
    By lbl_catalogSearchItemList = By.xpath("(//button[contains(@data-for,'add-to-order-guide')]/ancestor::div[2]/following-sibling::div[2]/div/div)[1]");
    By btn_addToCart = By.xpath("//button[contains(@data-for,'tooltipundefined')]/ancestor::div[3]//div/button/*[contains(@data-icon,'plus')]");
//    By tbx_itemQuantityFirstRow = By.xpath("//tr[1]//td[6]//input");
By tbx_itemQuantityFirstRow = By.xpath("(//*[@data-input ='quantityInput'])[1]");
//    By lbl_itemPriceFirstRow = By.xpath("(//td//span//div[@data-tip='View Product Details']/ancestor::tr/td[5]//div)[1] | (//td//span//div[@data-tip='View Product Details']/ancestor::tr/td[5]//span)[1]");
//By lbl_itemPriceFirstRow = By.xpath("(//td//span//div[@data-tip='View Product Details']/ancestor::tr/td[6]//input)[1] | (//td//span//div[@data-tip='View Product Details']/ancestor::tr/td[6]//span)[1]");
By lbl_itemPriceFirstRow = By.xpath("((//td//span//div[@data-tip='View Product Details']/ancestor::tr/td[last()-2]//input)[1] | (//td//span//div[@data-tip='View Product Details']/ancestor::tr/td[last()-2]//span)[1])[1]");
    By lbl_itemPriceFirstRow1 = By.xpath("((//td//span//div[@data-tip='View Product Details']/ancestor::tr/td[last()-2]//input)[1] | (//td//span//div[@data-tip='View Product Details']/ancestor::tr/td[last()-2]//span)[1])[2]");

    By btn_increaseQtyCatalog = By.xpath("//div[contains(@class, 'card-deck')]//*[name()='svg' and contains(@data-icon, 'plus')]");
    By btn_decreaseQtyCatalog = By.xpath("//div[contains(@class, 'card-deck')]//*[name()='svg' and contains(@data-icon,'minus')]");
    By tbx_itemQuantityCatalog = By.xpath("//input[@type='number']");
    By lbl_itemPriceSearchCatalogList = By.xpath("//div[4]/div/div[1]/div/span[contains(text(), '$')]");
    By txt_addToCart = By.xpath("//button[contains(text(), 'Add to Cart')]");
    By lbl_itemPriceReviewCart = By.xpath("//tbody[2]/tr[2]/td[2]");
    By btn_increaseQtyReviewCart = By.xpath("//tr[2]/td[4]/div/div/div/div/div[3]");
    By btn_decreaseQtyReviewCart = By.xpath("//tr[2]/td[4]/div/div/div/div/div[1]");
    By tbx_itemQuantityReviewCart = By.xpath("//tr[2]/td[4]/div/div/div/div[2]/input");
    By lbl_itemPriceReviewCartFirstRow = By.xpath("//td//span//div[@data-tip='View Product Details']/ancestor::tr//td/span");
    By lbl_cartItemUnitPrice = By.xpath("(//td//span//div[@data-tip='View Product Details']/ancestor::tr/td[3]//input)[1] | (//td//span//div[@data-tip='View Product Details']/ancestor::tr/td[3]//span)[1]");
    By btn_submitOrder = By.xpath("//button[contains(text(),'Submit')]");
    By btn_duplicateOrderYes = By.xpath("//button[contains(text(), 'Yes')]");
    By lbl_thankYouForOrder = By.xpath("//*[contains(text(),'Thank you for your order!')]");
    By btn_companyDropdown = By.xpath("//button[.//span[text()='Company:']]");
    By txt_companyDropdownText = By.xpath("//a[contains(text(), 'Independent Foods Co')]");
    By btn_print = By.xpath("//button[contains(text(), 'Print')]");
    By btn_downloadOrderGuide = By.xpath("//button[contains(text(), 'Download Order Guide')]");
    By lbl_printFriendlyOrderGuide = By.xpath("//h5[contains(text(), 'Print-Friendly Order Guide')]");
    By btn_edit = By.xpath("//button[contains(., 'Edit')]");
    By txt_editOrderGuide = By.xpath("//span[contains(text(), 'Edit Order Guide')]");
    By btn_moreOptions = By.xpath("//span[contains(text(), 'More Options')]");
    By btn_exportOrderGuide = By.xpath("//a[contains(text(), 'Export Order Guide (XLSX)')]");
    By btn_importOrderGuide = By.xpath("//a[contains(text(), 'Import Order Guide (XLSX)')]");
    By btn_uploadToOrder = By.xpath("//a[contains(text(), 'Upload to Order')]");
    By btn_create = By.xpath("//button[contains(text(), 'Create')]");
    By tbx_OrderGuideName = By.xpath("//input[@placeholder='Enter Name']");
    By btn_submitOrderGuide = By.xpath("//button[contains(text(), 'Submit')]");
    By btn_addFromCatalog = By.xpath("//div[contains(text(), 'Add from Catalog')]");
    By btn_addToOrderGuide = By.xpath("//button[@data-tip='Add to Order Guide']");
    By btn_closeEditor = By.xpath("//button[contains(text(), 'Close Editor')]");
    By btn_removeFromOrderGuide = By.xpath("//button[@data-tip='Remove from Order Guide']");
    By btn_sortCustomOrder = By.xpath("//div[contains(@class, 'cd_themed_select__single-value') and text()='Custom Order']");
    By btn_sortItemCategory = By.xpath("//div[contains(@class, 'cd_themed_select__single-value') and text()='Item Categories']");
    By btn_sortAlphabetical = By.xpath("//div[contains(@class, 'cd_themed_select__single-value') and text()='Alphabetical (A-Z)']");
    By btn_selectCustomOrder = By.xpath("//div[contains(@class, 'cd_themed_select__option') and contains(text(), 'Custom Order')]");
    By btn_selectItemCategory = By.xpath("//div[contains(@class, 'cd_themed_select__option') and contains(text(), 'Item Categories')]");
    By btn_selectAlphabetical = By.xpath("//div[contains(@class, 'cd_themed_select__option') and contains(text(), 'Alphabetical (A-Z)')]");
    By txt_seaFood = By.xpath("//div[contains(@class,'flex-grow-1') and contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'seafood')]");
    By btn_browse = By.xpath("//input[@type='file']");
    By btn_uploadFile = By.xpath("//button[contains(text(), 'Upload File')]");
    By btn_next = By.xpath("//button[contains(text(), 'Next')]");
    By btn_confirm = By.xpath("//button[contains(text(), 'Confirm')]");
    By txt_successfulOrderGuide = By.xpath("//h2[contains(text(), 'Order guide updated successfully')]");
    By txt_substitutions = By.xpath("//div[contains(text(), 'Set a Substitute')]");
    By txt_invalidDeliveryDate = By.xpath("//h2[text()='Error! Invalid Delivery Date']");
    By btn_close = By.xpath("//button[contains(text(), 'Close')]");
    By btn_deliveryDate = By.xpath("//div[@class='cd_themed_select__control css-sa5o0q-control']");
    By btn_selectDeliveryDateFirstLine = By.xpath("(//div[contains(@class, 'cd_themed_select__option')])[1]");
    By btn_selectDeliveryDateSecondLine = By.xpath("(//div[contains(@class, 'cd_themed_select__option')])[2]");
    By btn_orderGuideSettings = By.xpath("//a[contains(text(), 'Order Guide Settings')]");
    By btn_orderApproval = By.xpath("//div[contains(@class, 'react-switch-handle')]");
    By btn_save = By.xpath("//button[contains(@class, 'btn btn-primary') and contains(text(), 'Save')]");
    By btn_previousDraftOrderNo = By.xpath("//div[contains(text(),'previous draft order')]/..//div[text()='No']");
    By btn_placeOrder = By.xpath("//a[contains(@class, 'btn-primary') and contains(text(), 'Place Order')]");
    By btn_increaseQtyFirstRowInWL = By.xpath("(//div[contains(@data-tip,'View Product Details')]/../../following::td//div/*[local-name()='svg' and @data-icon='plus'])[1]");
    By btn_decreaseQtyFirstRowInWL = By.xpath("(//div[contains(@data-tip,'View Product Details')]/../../following::td//div/*[local-name()='svg' and @data-icon='minus'])[1]");
    By txt_foodServiceDistCenter = By.xpath("//span[text()='Food Service Distribution Centre']");
    By txt_retailDistCenter = By.xpath("//span[text()='Retail Distribution Centre']");
    String txt_orders = "(//div[contains(text(), 'Order #')])[NUM]";
    By lbl_itemNameListWL = By.xpath("//td//span/div[@data-tip='View Product Details']");
    By tbx_searchCustomers = By.xpath("//input[@placeholder='Search Customers']");
    String btnOrderGuide = "//button[contains(text(), 'Order Guide')]";
    By btn_increaseQtyFirstRowDis = By.xpath("//tr[1]/td[8]/div/div/div/div[3]");
    By btn_pickup = By.xpath("//span[text()='Pickup']");
   // By txt_orderCutOffForPickUp = By.xpath("//span[contains(text(), '1:30am')]");
    String txt_orderCutOffForPickUp = "//span[contains(text(), 'TIME')]";
    By txt_errorSubmittingOrder= By.xpath("//div[text()='Error submitting order. Please try again.']");
    By orderCartDeletebtn = By.xpath("//td//*[name()='svg' and @data-icon='trash-can']");
    By totalValue = By.xpath("//tr[@class='_2ehv7q text-primary']/td[2]");
    By selectedSections = By.xpath("//a[contains(@class,'_1ccoy1o text-decoration-none dropdown-item') and contains(text(),'Add Section')]");
    By sectionInput = By.xpath("//label[contains(text(),'Section Name')]/following-sibling::input[@id='sectionName']");
    By saveSectionBtn = By.xpath("//button[contains(text(),'Save')]");
    String section = "//div[contains(@class,'d-flex align-items-center no-gutters')]//div[contains(text(),'SECTIONNAME')]";
    By backBtn = By.xpath("//button[contains(text(),'Back')]");
    String sectionEditBtn ="//div[contains(text(), 'NAME')]/following-sibling::div[@class='col-2 d-flex justify-content-end align-items-center']/*[local-name() = 'svg' and @data-icon='pencil']";
    By sectionDeleteBtn = By.xpath("//button[contains(text(),'Delete')]");
    By deleteConfirmationYesBtn = By.xpath("//button[contains(text(),'Yes')]");
    By unitSelectionDropdown = By.xpath("//tbody/tr/td[3]/div/div/div/div");
    By pkgOption = By.xpath("//div[contains(@class, 'cd_themed_select__option') and text()='Pkg']");
    By caseOption = By.xpath("//div[contains(@class, 'cd_themed_select__option') and text()='Case']");
    String editItemBtn = "//div[contains(translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), translate('ITEMNAME', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'))]/../following-sibling::div//*[name()='svg' and @data-icon='pencil']";
    By hideBtn = By.xpath("//button[contains(text(),'Hide Item')]");
//    String hiddenItem ="//div[contains(text(),'ITEMNAME')]";
    String hiddenItem = "//div[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), translate('ITEMNAME', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'))]";
    By showFilter = By.xpath("//div[contains(text(),'Show')]/..//input/../following-sibling::div/div");
    By activeAndHiddenOption = By.xpath("//div[contains(@class,'cd_themed_select__option css-yt9ioa-option') and text()='Active & Hidden Items']");
    By onlyActiveItemsOption = By.xpath("(//div[contains(text(),'Only Active Items')])[last()]");
    By saveAndUnhideBtn = By.xpath("//button[@class='btn btn-primary btn-block'and contains(text(),'Save and Unhide Item')]");
    String Item = "//div[text()='ITEMNAME']";
    String itemNamePdpView = "//div[contains(@class,'mb-0 pt-2 d-flex align-items-center mont _1wrelxt _1vlidrf') and contains(text(),'ITEMNAME')]";
    String itemPricePdpView = "(//div[text()='ITEMNAME']/following-sibling::div//span)[1]";
    String ItemPriceCatalogView = "//div[contains(@class, '_13kb1gk')]//div[text()= 'ITEMNAME']//ancestor::div[contains(@class, '_13kb1gk')]//div[@class='_btf6h0']//div[@class='_5kaapu']";
    By deliveryDate = By.xpath("//div[@class='text-truncate']");
    String customerCodeOnGrid = "//tr[@class='_du1frc']/td[text()='CUSTOMERCODE']";
    String customerCodeInProfilePage = "//div[@class='col' and text()='CUSTOMERCODE']";
    By editDeliveryBtn = By.xpath("//div[contains(text(), 'Delivery Days')]//following-sibling::div//div[@class='pl-0 col-sm-auto col-auto']/*");
    String cutOffDay = "//tr[td[contains(text(), 'DAY')]]//div[contains(@class, 'themed_select__control')]";
    String cutOffDaySelect = "//div[contains(@class,'themed_select__option css-yt9ioa-option') and text()='DAY']";
    String cutOffTime = "//tr[td[contains(text(), 'DAY')]]//input[@class='_1avn95e form-control']";
    By cutOffDateTimeSave = By.xpath("//button[contains(text(),'Save Changes')]");
    By orderCutOffTime = By.xpath("//span[@class='ml-1 text-nowrap _d7ebxxy']");
    String clearDeliveryDate = "//tr[td[contains(text(), 'DAY')]]//div[contains(@class, 'themed_select__control')]//div[contains(@class, 'themed_select__clear-indicator')]/*";
    By ratingOverlayIframe = By.xpath("//iframe[contains(@aria-label,'NPS Survey')]");
    By ratingOverlayCloseBtn = By.xpath("//div[contains(text(),'✕')]");
    String itemNotFoundTxt = "//div[contains(@data-tip,'View Product Details')]/..//div[contains(text(),'ITEMCODE')]";
    String catalogCardAddToOGBtn = "//div[text()='ITEMCODE']/../../..//button[@data-tip='Add to Order Guide']";
    By btn_close_ = By.xpath("//button[contains(@class, 'close')]/span[text()='×']");
    By btn_increaseQtyFirstRowClassic = By.xpath("(//tr/td//div[contains(@data-tip,'View Product Details')]/following::td//div/*[contains(@data-icon,'plus')])[1]");
    By btn_decreaseQtyFirstRowClassic = By.xpath("(//tr/td//div[contains(@data-tip,'View Product Details')]/following::td//div/*[contains(@data-icon,'minus')])[1]");
    By tbx_itemQuantityFirstRowClassic = By.xpath("(//tr/td//div[contains(@data-tip,'View Product Details')]/following::td//div/*[contains(@data-icon,'minus')]/../following-sibling::div/input)[1]");
    By lbl_caseMinNotMet = By.xpath("//h2[contains(text(), 'Case Minimum Not Met')]");
    By addNewItemBtn = By.xpath("//*[contains(text(),'Add New Item')]");
    By addItemsToOrderGuideTxt = By.xpath("//div[contains(text(),'Add Item To Order Guide')]");
    By itemNameTextField = By.xpath("//label[contains(text(),'Item Name')]/following-sibling::input");
    By itemCodeTextField = By.xpath("//*[contains(text(),'Item Code')]/../following-sibling::input");
    String unitBtn = "//label[contains(text(),'Unit')]/../following::div[contains(text(),'UNIT')]";
    String unitPrice = "//td[contains(text(),'UNIT')]/following-sibling::td/input";
    By accountingCategoryDropdown = By.xpath("//*[contains(text(),'Accounting Category')]/../following-sibling::div/div/div");
    String accountingCategory = "//div[contains(text(),'ACCOUNTINGCATAGORY')]";
    By saveItemBtn = By.xpath("//button[contains(text(),'Save Item')]");
    String addedItem = "//td[contains(text(),'ITEMCODE')]";
    By editOrder = By.xpath("//a[contains(text(),'Edit Order')]");
    By lbl_itemCodeList = By.xpath("(//td//span//div[@data-tip='View Product Details']/ancestor::tr/td[2])[1]");
    By lbl_itemPriceList = By.xpath("((//td//span//div[@data-tip='View Product Details']/ancestor::tr/td[last()-2]//input)[1] | (//td//span//div[@data-tip='View Product Details']/ancestor::tr/td[last()-2]//span)[1])[1]");
    By txt_reviewOrder = By.xpath("//div[text()='Review Order']");
    By btn_checkOutPDP = By.xpath("//button[@data-for='cartCheckoutButton' and contains(text(),'$')]");
//    String btn_catalogPDPPlusStable = "(//div[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = translate('NAME', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')]/following::div//*[name()='svg' and contains(@data-icon, 'plus')])[1]";
    String btn_catalogPDPPlusStable = "(//button[contains(@data-for,'add-to-order-guide')]/ancestor::div[2]/following-sibling::div)[1]/following-sibling::div//*[name()='svg' and contains(@data-icon, 'plus')]";
    String btn_catalogPDPMinusStable = "(//button[contains(@data-for,'add-to-order-guide')]/ancestor::div[2]/following-sibling::div)[1]/following-sibling::div//*[name()='svg' and contains(@data-icon, 'minus')]";
    String lbl_catalogSearchResultItemList = "(//div[contains(@class,'card-deck')]//div[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), translate('NAME', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'))])[last()]";
    String txt_product = "//div[contains(@class,'_3quvq7 _1vlidrf' ) and contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), translate('NAME', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'))]";
    By lbl_productDetails = By.xpath("//span[text()='Product Details']");
    By btn_catalogPlus = By.xpath("//*[name()='svg' and @data-icon='plus']");
    By itemSort = By.xpath("//div[contains(text(),'Sort Items By:')]/..//*[name()='svg']");
    By sel_delivery = By.xpath("//span[text()='Delivery']/preceding-sibling::div//*[contains(@data-icon, 'circle')]");
    By txt_orderId = By.xpath("//div[contains(text(),'Order #')]");
    By txt_customers = By.xpath("//h2[text()='Customers']");
    String btnCustomerOrderGuide = "//td[text()='CODE']/../td[8]//button";
    String businessName = "//td/following-sibling::td[contains(text(),'CUSTOMERID')]/following-sibling::td[1]";
    String SelectCustomerByCode = "//td[contains(text(),'CODE')]";
    String txt_customerProfile = "//div[contains(@class, 'd-flex') and contains(text(), 'BUSINESSNAME')]";
    By tb_orders = By.xpath("//a[text()='Orders' and @role='tab']");
    String specificOrderRecord = "//tr/td[text()='ORDER_ID']";
    String orderTitle = "//h2[contains(text(),'Order #ORDER_ID')]";
    By btn_addToCartPDP = By.xpath("(//button[contains(text(), 'Add to Cart')])[1]");
    By lbl_pickUp = By.xpath("//span[text()='Pickup/Will Call']");
    By sel_pickup = By.xpath("//span[text()='Pickup/Will Call']/preceding-sibling::div//*[contains(@data-icon, 'circle')]");
    By lbl_mailDelivery = By.xpath("//span[text()='Mail Delivery']");
    By sel_mailDelivery = By.xpath("//span[text()='Mail Delivery']/preceding-sibling::div//*[contains(@data-icon, 'circle')]");
    By btn_montanaPlaceOrder = By.xpath("//button[contains(@class, 'btn-primary') and contains(text(), 'Place Order')]");
    String catalogImage ="//img[@class='card-img-top _1d49j2h' and contains(@src,'IMG')]";
    By btn_doNotSubstitute = By.xpath("//button[text()='Do Not Substitute']");
    By btn_viewOrderInDraft = By.xpath("//button[text()='View Order in Drafts']");
    By txt_sentApproval = By.xpath("//strong[contains(text(),'Sent for approval!')]");
    By btn_increaseQtyOrderGuide = By.xpath("(//div//*[local-name()='svg' and @data-icon='plus'])[2]");
    By txt_glendaCatalog = By.xpath("//div[contains(text(), 'Brand')]");

    public boolean isPreviousDraftOrderNoDisplayed() throws InterruptedException {
        restaurantUI.waitForElementEnabledState(btn_previousDraftOrderNo, true);
        restaurantUI.waitForCustom(2000);
        return restaurantUI.isDisplayed(btn_previousDraftOrderNo);
    }

    public void clickPreviousDraftOrderNo() throws InterruptedException {
        restaurantUI.click(btn_previousDraftOrderNo);
    }
    public boolean caseMinNotMetDisplayed() throws InterruptedException {
        return restaurantUI.isDisplayed(lbl_caseMinNotMet);
    }
    public String getItemNameFirstRow() {
        try {
            restaurantUI.waitForCustom(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return restaurantUI.getText(lbl_itemNameList);
    }

    public void clickPlusQryFirstRow() throws InterruptedException {
        restaurantUI.click(btn_increaseQtyFirstRow);
        restaurantUI.waitForCustom(4000);
    }

    public void clickPlusQrySecondRow() throws InterruptedException {
        restaurantUI.click(btn_increaseQtySecondRow);
        restaurantUI.waitForCustom(4000);
    }

    public void clickMinusQryFirstRow() throws InterruptedException {
        restaurantUI.click(btn_decreaseQtyFirstRow);
        restaurantUI.waitForCustom(4000);
    }

    public void clickMinusQrySecondRow() throws InterruptedException {
        restaurantUI.click(btn_decreaseQtySecondRow);
        restaurantUI.waitForCustom(4000);
    }

    public void clickPlusQryFirstRowClassic() throws InterruptedException {
        restaurantUI.click(btn_increaseQtyFirstRowClassic);
        restaurantUI.waitForCustom(4000);
    }

    public void clickMinusQryFirstRowClassic() throws InterruptedException {
        restaurantUI.click(btn_decreaseQtyFirstRowClassic);
        restaurantUI.waitForCustom(4000);
    }

    public void clickPlusCatalog() throws InterruptedException {
        restaurantUI.waitForCustom(4000);
        restaurantUI.click(btn_increaseQtyCatalog);
    }

    public void clickMinusCatalog() throws InterruptedException {
        restaurantUI.click(btn_decreaseQtyCatalog);
        restaurantUI.waitForCustom(4000);
    }

    public String getItemNameSecondRow() {
        return restaurantUI.getText(lbl_itemNameList, 1);
    }

    public void clickOnCheckoutButton() throws InterruptedException {
        restaurantUI.waitForElementEnabledState(btn_checkout, true);
        restaurantUI.click(btn_checkout);
        restaurantUI.waitForCustom(4000);
    }

    public boolean isCatalogTextDisplayed() {
        return restaurantUI.isDisplayed(txt_catalog);
    }

    public void clickOnCatalogButton() {
        restaurantUI.click(btn_catalog);
    }
    public void clickOrderGuideTab(){
        restaurantUI.waitForVisibility(btn_catalogToOrderGuide);
        try {
            restaurantUI.waitForCustom(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        restaurantUI.click(btn_catalogToOrderGuide);
    }

    public void typeToSearchOnCatalog(String item) throws InterruptedException {
        restaurantUI.waitForCustom(3000);
        restaurantUI.clearUsingJavaScript(tbx_catalogSearch);
        restaurantUI.click(tbx_catalogSearch);
        restaurantUI.waitForCustom(2000);
        restaurantUI.sendKeys(tbx_catalogSearch, item);
        restaurantUI.waitForCustom(4000);
    }

    public void typeToSearchOnOrderGuide(String item) {
        restaurantUI.sendKeys(tbx_orderGuideSearch, item);
    }

    public String getFirstItemNameFrmSearchResults() {
        return restaurantUI.getText(lbl_catalogSearchItemList, 0);
    }

    public void clickAddToCartCatalog() throws InterruptedException {
        restaurantUI.waitForCustom(4000);
        restaurantUI.waitForVisibility(btn_addToCart);
        restaurantUI.waitForClickability(btn_addToCart);
        restaurantUI.waitForCustom(4000);
        restaurantUI.click(btn_addToCart);
        restaurantUI.waitForCustom(2000);
        restaurantUI.waitForElementEnabledState(btn_checkout, true);
    }

    public String getItemQtyFirstRow() {
        try {
            restaurantUI.waitForCustom(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return restaurantUI.getText(tbx_itemQuantityFirstRow, "value");
    }

    public String getItemQtyFirstRowClassic() {
        return restaurantUI.getText(tbx_itemQuantityFirstRowClassic, "value");
    }

    public String getItemQtyCatalog() {
        return restaurantUI.getText(tbx_itemQuantityCatalog, "value");
    }

    public Double getItemPriceCatalogSearch() {
        return Double.valueOf(restaurantUI.getText(lbl_itemPriceSearchCatalogList).replace("$", ""));
    }

   /* public Double getItemPriceFirstRow() {
        restaurantUI.waitForVisibility(lbl_itemPriceFirstRow);
        String tagName = restaurantUI.getElement(lbl_itemPriceFirstRow).getTagName();
        String priceText;
        if (tagName.equals("input")) {
            priceText = restaurantUI.getText(lbl_itemPriceFirstRow, "value");
        } else {
            priceText = restaurantUI.getText(lbl_itemPriceFirstRow);
        }
        return Double.valueOf(priceText.replace("$", "").trim());
//        return Double.valueOf(restaurantUI.getText(lbl_itemPriceFirstRow).replace("$", ""));
    }*/

    public double getItemPriceFirstRow() {
        try {
            return extractPrice(lbl_itemPriceFirstRow);
        } catch (Exception e) {
            System.out.println("Fallback to alternative price locator due to: " + e.getMessage());
            return extractPrice(lbl_itemPriceFirstRow1);
        }
    }

    private double extractPrice(By priceLocator) {
        restaurantUI.waitForVisibility(priceLocator);
        String tagName = restaurantUI.getElement(priceLocator).getTagName();
        String priceText;

        if (tagName.equals("input")) {
            priceText = restaurantUI.getText(priceLocator, "value");
        } else {
            priceText = restaurantUI.getText(priceLocator);
        }

        System.out.println("Extracted Price: " + priceText);
        return Double.valueOf(priceText.replace("$", "").replace("/cs", "").replace("/pkg", "").trim());
    }

    public Double getItemPriceOnCheckoutButton() {
        try {
            restaurantUI.waitForCustom(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Double.valueOf(restaurantUI.getText(btn_checkout).replace("$", ""));
    }

    public boolean isAddToCartTextDisplayed() {
        return restaurantUI.isDisplayed(txt_addToCart);
    }

    public Double getItemPriceReviewCart() {
        return Double.valueOf(restaurantUI.getText(lbl_itemPriceReviewCart).replace("$", ""));
    }

    public void clickPlusReviewCart() {
        restaurantUI.click(btn_increaseQtyReviewCart);
    }

    public void clickMinusReviewCart() {
        restaurantUI.click(btn_decreaseQtyReviewCart);
    }

    public String getItemQtyReviewCart() {
        return restaurantUI.getText(tbx_itemQuantityReviewCart, "value");
    }

    public Double getItemPriceReviewCartFirstRow() {
//        return Double.valueOf(restaurantUI.getText(lbl_itemPriceReviewCartFirstRow).replace("$", ""));
        restaurantUI.waitForVisibility(lbl_cartItemUnitPrice);
        String tagName = restaurantUI.getElement(lbl_cartItemUnitPrice).getTagName();
        String priceText;
        if (tagName.equals("input")) {
            priceText = restaurantUI.getText(lbl_cartItemUnitPrice, "value");
        } else {
            priceText = restaurantUI.getText(lbl_cartItemUnitPrice);
        }

        return Double.valueOf(priceText.replace("$", "").replace("/cs", "").replace("/pkg", "").trim());

    }

    public boolean isDuplicatePopupDisplayed() {
        try {
            return restaurantUI.isDisplayed(btn_duplicateOrderYes);
        } catch (Exception e) {
            return false;
        }
    }

    public void clickYesDuplicatePopup() throws InterruptedException {
        restaurantUI.waitForClickability(btn_duplicateOrderYes);
        restaurantUI.click(btn_duplicateOrderYes);
        restaurantUI.waitForInvisibility(btn_duplicateOrderYes);
    }

    public boolean isThankingForOrderPopupDisplayed() {
        try {
            restaurantUI.waitForClickability(lbl_thankYouForOrder);
            return restaurantUI.isDisplayed(lbl_thankYouForOrder);
        } catch (Exception e) {
            return false;
        }
    }
    public void clickCloseIcon(){
        restaurantUI.waitForVisibility(btn_close_);
        restaurantUI.click(btn_close_);
        restaurantUI.waitForInvisibility(btn_close_);
        restaurantUI.refreshPage();
    }
    public void submitOrder() {
        restaurantUI.waitForClickability(btn_submitOrder);
        restaurantUI.click(btn_submitOrder);
    }

    public void clickCompanyDropdown() {
        restaurantUI.waitForClickability(btn_companyDropdown);
        restaurantUI.click(btn_companyDropdown);
    }

    public boolean isCompanyDropdownTextDisplayed() {
        return restaurantUI.isDisplayed(txt_companyDropdownText);
    }

    public void clickOnPrint() {
        restaurantUI.waitForClickability(btn_print);
        restaurantUI.click(btn_print);
    }

    public void clickOnDownloadOrderGuide() {
        restaurantUI.waitForClickability(btn_downloadOrderGuide);
        restaurantUI.click(btn_downloadOrderGuide);
    }

    public boolean isPrintFriendlyPopupDisplayed() {
        return restaurantUI.isDisplayed(lbl_printFriendlyOrderGuide);
    }

    public void clickOnEdit() {
        restaurantUI.waitForClickability(btn_edit);
        restaurantUI.click(btn_edit);
    }

    public boolean isEditOrderGuideTextDisplayed() {
        if(restaurantUI.isDisplayed(ratingOverlayIframe)){
            restaurantUI.switchToFrameByElement(ratingOverlayIframe);
            restaurantUI.click(ratingOverlayCloseBtn);
            try {
                restaurantUI.waitForCustom(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            restaurantUI.waitForVisibility(txt_editOrderGuide);
        } catch (Exception e) {
            return false;
        }
        return restaurantUI.isDisplayed(txt_editOrderGuide);
    }

    public void clickOnMoreOptions() {
        restaurantUI.waitForClickability(btn_moreOptions);
        restaurantUI.click(btn_moreOptions);
    }

    public void clickOnExportOrderGuide() {
        restaurantUI.waitForClickability(btn_exportOrderGuide);
        restaurantUI.click(btn_exportOrderGuide);
    }

    public void clickOnImportOrderGuide() {
        restaurantUI.waitForClickability(btn_importOrderGuide);
        restaurantUI.click(btn_importOrderGuide);
    }

    public void clickOnUploadToOrder() {
        restaurantUI.waitForClickability(btn_uploadToOrder);
        restaurantUI.click(btn_uploadToOrder);
    }

    public void clickOnCreate() {
        restaurantUI.waitForClickability(btn_create);
        restaurantUI.click(btn_create);
    }

    public void typeOrderGuideName(String orderGuideName) {
        restaurantUI.sendKeys(tbx_OrderGuideName, orderGuideName);
    }

    public void clickSubmitOrderGuide() {
        restaurantUI.waitForClickability(btn_submitOrderGuide);
        restaurantUI.click(btn_submitOrderGuide);
    }

    public void clickOnAddFromCatalog() {
        restaurantUI.waitForClickability(btn_addFromCatalog);
        restaurantUI.click(btn_addFromCatalog);
    }

    public void clickOnAddTOOrderGuide() throws InterruptedException{
        restaurantUI.waitForVisibility(btn_addToOrderGuide);
        restaurantUI.waitForClickability(btn_addToOrderGuide);
        restaurantUI.clickUsingJavaScript(btn_addToOrderGuide);
        restaurantUI.waitForCustom(2000);
    }

    public void clickOnCloseEditor() {
        restaurantUI.click(btn_closeEditor);
        restaurantUI.refreshPage();
        try {
            restaurantUI.waitForCustom(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickOnRemoveFromOrderGuide() throws InterruptedException {
        restaurantUI.waitForVisibility(btn_removeFromOrderGuide);
        restaurantUI.click(btn_removeFromOrderGuide);
        restaurantUI.waitForCustom(4000);
    }

    public void clickDropDownCustomerOrder() {
        restaurantUI.click(btn_sortCustomOrder);
    }

    public void clickDropDownItemCategory() {
        restaurantUI.click(btn_sortItemCategory);
    }

    public void clickDropDownAlphabetical() {
        restaurantUI.click(btn_sortAlphabetical);
    }

    public void clickOnSortDropdown(){
        restaurantUI.click(itemSort);
    }

    public void selectDropDownCustomerOrder() throws InterruptedException {
        restaurantUI.click(btn_selectCustomOrder);
        restaurantUI.waitForCustom(4000);
    }

    public void selectDropDownItemCategory() throws InterruptedException {
        restaurantUI.click(btn_selectItemCategory);
        restaurantUI.waitForCustom(4000);
    }

    public void selectDropDownAlphabetical() throws InterruptedException {
        restaurantUI.click(btn_selectAlphabetical);
        restaurantUI.waitForCustom(4000);
    }

    public boolean isSeaFoodTextDisplayed() {
        try {
            restaurantUI.waitForVisibility(txt_seaFood);
        } catch (Exception e) {
            return false;
        }
        return restaurantUI.isDisplayed(txt_seaFood);
    }

    public void clickOnUploadFile() {
        restaurantUI.waitForClickability(btn_uploadFile);
        restaurantUI.click(btn_uploadFile);
    }

    public void clickOnNext() {
        restaurantUI.waitForClickability(btn_next);
        restaurantUI.click(btn_next);
    }

    public void clickOnConfirm() {
        restaurantUI.waitForVisibility(btn_confirm);
        restaurantUI.waitForClickability(btn_confirm);
        restaurantUI.click(btn_confirm);
    }

    public boolean isOrderGuideSuccessfulTextDisplayed() {
        return restaurantUI.isDisplayed(txt_successfulOrderGuide);
    }

    public boolean isSubstitutionTextDisplayed() {
        return restaurantUI.isDisplayed(txt_substitutions);
    }

    public void fileUpload(String path) {
        restaurantUI.sendKeysHiddenElements(btn_browse, path);
    }

    public boolean isInvalidDeliveryTextDisplayed() {
        return restaurantUI.isDisplayed(txt_invalidDeliveryDate);
    }

    public void clickOnClose() throws InterruptedException{
        restaurantUI.waitForCustom(4000);
        restaurantUI.click(btn_close);

    }


    public void clickOnDeliveryDate() throws InterruptedException{
        restaurantUI.waitForCustom(4000);
        restaurantUI.click(btn_deliveryDate);
    }

    public void selectDeliveryDateFirstLine() {
        restaurantUI.click(btn_selectDeliveryDateFirstLine);
    }
    public void selectDeliveryDateSecondLine()  throws InterruptedException {
        restaurantUI.waitForCustom(4000);
        restaurantUI.click(btn_selectDeliveryDateSecondLine);
        restaurantUI.waitForCustom(4000);
    }
    public void clickOnOrderGuideSettings() {
        restaurantUI.waitForClickability(btn_orderGuideSettings);
        restaurantUI.click(btn_orderGuideSettings);
    }
    public void clickOnOrderApproval() throws InterruptedException {
        if(restaurantUI.isDisplayed(ratingOverlayIframe)){
            restaurantUI.switchToFrameByElement(ratingOverlayIframe);
            restaurantUI.click(ratingOverlayCloseBtn);
            try {
                restaurantUI.waitForCustom(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        restaurantUI.click(btn_orderApproval);
        restaurantUI.waitForCustom(4000);
    }

    public boolean isRatingOverlayDisplayed(){
        return restaurantUI.isDisplayed(ratingOverlayIframe);
    }

    public void clickCloseRatingOverlay(){
        restaurantUI.switchToFrameByElement(ratingOverlayIframe);
        restaurantUI.click(ratingOverlayCloseBtn);
        try {
            restaurantUI.waitForCustom(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickOnSave() {
        restaurantUI.click(btn_save );
    }

    public void clickOnPlaceOrder() {
        restaurantUI.click(btn_placeOrder );
    }

    public void clickPlusQryFirstRowInWL() throws InterruptedException {
        restaurantUI.waitForCustom(1000);
        restaurantUI.click(btn_increaseQtyFirstRowInWL);
    }

    public boolean isMultiDistCentersDisplayed() {
        try {
            restaurantUI.waitForVisibility(txt_foodServiceDistCenter);
            restaurantUI.isDisplayed(txt_foodServiceDistCenter);
            restaurantUI.waitForVisibility(txt_retailDistCenter);
            restaurantUI.isDisplayed(txt_retailDistCenter);
        } catch (Exception e){
            return false;
        }
        return true;
    }
    public int getOrderCount(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (restaurantUI.isDisplayed(By.xpath(txt_orders.replace("NUM", String.valueOf(i))))){
                count += 1;
            };
        }
        return count;
    }
    public String getItemNameFirstRowWL() throws InterruptedException {
        restaurantUI.waitForElementEnabledState(lbl_itemNameListWL,true);
        restaurantUI.waitForCustom(3000);
        return restaurantUI.getText(lbl_itemNameListWL);
    }
    public void clickOnSearchCustomers(){
        restaurantUI.click(tbx_searchCustomers);
    }
    public void typeOnSearchCustomers(String code) throws InterruptedException {
        restaurantUI.clear(tbx_searchCustomers);
        restaurantUI.waitForCustom(3000);
        restaurantUI.sendKeys(tbx_searchCustomers, code);
        restaurantUI.waitForCustom(3000);
    }
    public void clickOnOrderGuide(String code) {
        restaurantUI.click(By.xpath(btnOrderGuide.replace("CODE", code)));
    }
    public void clickPlusQryFirstRowDis(){
        restaurantUI.click(btn_increaseQtyFirstRowDis);
    }

    public boolean isPickupTextDisplayed() {
        try {
            return restaurantUI.isDisplayed(btn_pickup);
        } catch (Exception e) {
            return false;
        }
    }
    public void clickOnPickUp() throws InterruptedException {
        restaurantUI.click(btn_pickup);
        restaurantUI.waitForCustom(4000);
    }
    public boolean isOrderCutOffDisplayed(String time) {
        try {
            return restaurantUI.isDisplayed(By.xpath(txt_orderCutOffForPickUp.replace("TIME",time)));
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSubmittingErrorDisplayed() {
        try {
            return restaurantUI.isDisplayed(txt_errorSubmittingOrder);
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnDeleteItemInCart(){
        restaurantUI.click(orderCartDeletebtn);
    }

    public Double isCartTotalBecomsZero(){
        return Double.valueOf(restaurantUI.getText(totalValue).replace("$", ""));
    }

    public void clickAddSectionFromMoreOptionsDropdown(){
        restaurantUI.click(selectedSections);
    }


    public void TypeSectionName(String sectionName){
        try {
            restaurantUI.waitForCustom(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        restaurantUI.waitForVisibility(sectionInput);
        restaurantUI.sendKeys(sectionInput,sectionName);
    }


    public void clickOnSaveBtn(){
        restaurantUI.click(saveSectionBtn);
        try {
            restaurantUI.waitForCustom(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isSectionDisplayed(String sectionName){
        try {
            restaurantUI.waitForCustom(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return restaurantUI.isDisplayed(By.xpath(section.replace("SECTIONNAME",sectionName)));
    }

    public boolean isSectionNotDisplayed(String sectionName){
        try {
            restaurantUI.waitForCustom(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        restaurantUI.waitForInvisibility(By.xpath(section.replace("SECTIONNAME",sectionName)));
        return restaurantUI.isDisplayed(By.xpath(section.replace("SECTIONNAME",sectionName)));
    }

    public void dragSectionToHigher(){
        restaurantUI.dragAndDrop(By.xpath("//div[contains(@class, '_11h2a11m') and @data-rbd-draggable-id='item-288275866']"),By.xpath("//div[@data-rbd-draggable-id='item-212365835']"));

    }

    public void clickOnBackBtn(){
        restaurantUI.click(backBtn);
    }

    public void clickOnEditSection(String name){
        restaurantUI.waitForVisibility(By.xpath(sectionEditBtn.replace("NAME", name)));
        restaurantUI.click(By.xpath(sectionEditBtn.replace("NAME", name)));
    }

    public void clickOnDeleteBtn(){
        restaurantUI.click(sectionDeleteBtn);
    }

    public void clickYesOnConfirmationOverlay() throws InterruptedException {
        restaurantUI.click(deleteConfirmationYesBtn);
        try {
            restaurantUI.waitForCustom(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        restaurantUI.waitForCustom(4000);
    }

    public void clickPkgOption(){
        restaurantUI.isDisplayed(unitSelectionDropdown);
        try {
            restaurantUI.waitForCustom(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        restaurantUI.click(unitSelectionDropdown);
        try {
            restaurantUI.waitForCustom(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        restaurantUI.waitForVisibility(pkgOption);
        restaurantUI.click(pkgOption);
    }

    public String isUnitChangedToPkg(){
        restaurantUI.waitForVisibility(unitSelectionDropdown);
        return restaurantUI.getText(unitSelectionDropdown);
    }

    public void clickCaseOption(){
        restaurantUI.isDisplayed(unitSelectionDropdown);
        try {
            restaurantUI.waitForCustom(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        restaurantUI.click(unitSelectionDropdown);
        restaurantUI.waitForVisibility(caseOption);
        restaurantUI.click(caseOption);
    }

    public String isUnitChangedToCase(){
        restaurantUI.waitForVisibility(unitSelectionDropdown);
        return restaurantUI.getText(unitSelectionDropdown);
    }

    public void clickEditItemBtn(String itemname){
        restaurantUI.click(By.xpath(editItemBtn.replace("ITEMNAME",itemname)));

    }

    public void clickOnHideBtn(){
        restaurantUI.click(hideBtn);
    }

    public boolean isHiddenItemDisplayed(String itemName){
        try {
            restaurantUI.waitForCustom(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return restaurantUI.isDisplayed(By.xpath(hiddenItem.replace("ITEMNAME",itemName)));
    }

    public void clickShowActiveAndHiddenItems(){
        restaurantUI.waitForVisibility(showFilter);
        restaurantUI.click(showFilter);
        restaurantUI.waitForVisibility(activeAndHiddenOption);
        restaurantUI.click(activeAndHiddenOption);
    }

    public void clickShowOnlyActiveItems(){
        restaurantUI.waitForVisibility(showFilter);
        restaurantUI.click(showFilter);
        restaurantUI.waitForVisibility(onlyActiveItemsOption);
        restaurantUI.click(onlyActiveItemsOption);

    }

    public void clickSaveAndUnhideBtn(){
        restaurantUI.click(saveAndUnhideBtn);
    }

    public boolean isCatalogPageImagesDisplayed(String img)throws InterruptedException{
        restaurantUI.waitForVisibility(By.xpath(catalogImage.replace("IMG",img)));
        return restaurantUI.isDisplayed(By.xpath(catalogImage.replace("IMG",img)));
    }

    public void clickItemOnCatalog(String itemName){
        restaurantUI.isDisplayed(By.xpath(Item.replace("ITEMNAME",itemName)));
        restaurantUI.click(By.xpath(Item.replace("ITEMNAME",itemName)));
    }

    public boolean isPDPViewItemNameDisplayed(String itemName){
        restaurantUI.waitForVisibility(By.xpath(itemNamePdpView.replace("ITEMNAME",itemName)));
        return restaurantUI.isDisplayed(By.xpath(itemNamePdpView.replace("ITEMNAME",itemName)));
    }

    public String getPDPViewItemName(String itemName){
        return restaurantUI.getText(By.xpath(itemNamePdpView.replace("ITEMNAME",itemName)));
    }

    public String getCatalogViewItemName(String itemName){
        return restaurantUI.getText(By.xpath(Item.replace("ITEMNAME",itemName)));
    }

    public String getPDPViewItemPrice(String itemName){
        return restaurantUI.getText(By.xpath(itemPricePdpView.replace("ITEMNAME",itemName)));
    }

    public String getCatalogViewItemPrice(String itemName){
        return restaurantUI.getText(By.xpath(ItemPriceCatalogView.replace("ITEMNAME",itemName)));
    }

    public String getDeliveryDateReviewCart(){
        return restaurantUI.getText(deliveryDate);
    }

    public void clickOnCustomer(String customerCode){
        restaurantUI.click(By.xpath(customerCodeOnGrid.replace("CUSTOMERCODE",customerCode)));
    }

    public String isCustomerCodeDisplayed(String customerCode){
        return restaurantUI.getText(By.xpath(customerCodeInProfilePage.replace("CUSTOMERCODE",customerCode)));
    }

    public void clickOnEditDeliveryDate(){
        restaurantUI.click(editDeliveryBtn);
    }

    public void clickOnpreviousDateDropdow(String Date){
        restaurantUI.click(By.xpath(cutOffDay.replace("DAY",Date)));
    }

    public void clickTodayONDropDown(String Date){
        restaurantUI.click(By.xpath(cutOffDaySelect.replace("DAY",Date)));
    }

    public void typeCutOffTime(String date , String time){
        restaurantUI.sendKeys(By.xpath(cutOffTime.replace("DAY",date)),time);
    }

    public void saveChangesBtn(){
        restaurantUI.click(cutOffDateTimeSave);
    }

    public String getCutOffTimeFromReviewCart(){
        return restaurantUI.getText(orderCutOffTime);
    }


    public void clickOnClearDeliveryDateBtn(String Date){
        restaurantUI.click(By.xpath(clearDeliveryDate.replace("DAY",Date)));
    }

    public void waitForCutOffTimeToBeOver(){
        try {
            restaurantUI.waitForCustom(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickItemFromCatalogIfNotAvailableInOG(String itemName){
        if(!restaurantUI.isDisplayed(By.xpath(itemNotFoundTxt.replace("ITEMCODE",itemName.toLowerCase())))){
            restaurantUI.click(By.xpath(catalogCardAddToOGBtn.replace("ITEMCODE",itemName)));
        }
        try {
            restaurantUI.waitForCustom(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public void clickAddNewItem(){
        restaurantUI.waitForVisibility(addNewItemBtn);
        restaurantUI.click(addNewItemBtn);
    }

    public boolean isAddItemsToOrderGuideDisplayed(){
        restaurantUI.waitForVisibility(addItemsToOrderGuideTxt);
        return restaurantUI.isDisplayed(addItemsToOrderGuideTxt);
    }

    public void setItemName(String ItemName){
        restaurantUI.sendKeys(itemNameTextField,ItemName);
    }

    public void setItemCode(String ItemCode){
        restaurantUI.sendKeys(itemCodeTextField,ItemCode);
    }

    public void setUnits(String unit){
        restaurantUI.click(By.xpath(unitBtn.replace("UNIT",unit)));
    }

    public void setPrice(String unit,String price){
        restaurantUI.sendKeys(By.xpath(unitPrice.replace("UNIT",unit)),price);
    }

    public void setAccountingCategory(String categoryName){
        restaurantUI.click(accountingCategoryDropdown);
        restaurantUI.click(By.xpath(accountingCategory.replace("ACCOUNTINGCATAGORY",categoryName)));
    }
    
    public void clickSaveItemBtn(){
        restaurantUI.click(saveItemBtn);
        try {
            restaurantUI.waitForCustom(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        restaurantUI.refreshPage();
    }

    public boolean isAddItemDisplayed(String itemCode){
        return restaurantUI.isDisplayed(By.xpath(addedItem.replace("ITEMCODE",itemCode)));
    }

    public void clickEditOrder(){
        restaurantUI.click(editOrder);
    }
    public String getItemCodeFirstRow() throws InterruptedException {
        restaurantUI.waitForVisibility(lbl_itemCodeList);
        restaurantUI.waitForCustom(3000);
        return restaurantUI.getText(lbl_itemCodeList);
    }
    public double getActiveItemPriceFirstRow() throws InterruptedException {
        try {
            return extractPrice(lbl_itemPriceList);
        } catch (Exception e) {
            System.out.println("Fallback to alternative price locator due to: " + e.getMessage());
            return extractPrice(lbl_itemPriceList);
        }
    }
    public boolean isReviewOrderTextDisplayed(){
        restaurantUI.waitForVisibility(txt_reviewOrder);
        return restaurantUI.isDisplayed(txt_reviewOrder);
    }
    public Double getItemPriceOnCheckoutButtonViaPDP() throws InterruptedException {
        restaurantUI.waitForVisibility(btn_checkOutPDP);
        restaurantUI.waitForCustom(4000);
        return Double.valueOf(restaurantUI.getText(btn_checkOutPDP).replace("$",""));
    }
    public void clickOnPlusIconInCatalogPDP(String name){
        restaurantUI.waitForVisibility(By.xpath(btn_catalogPDPPlusStable.replace("NAME", name)));
        restaurantUI.click(By.xpath(btn_catalogPDPPlusStable.replace("NAME", name)));
    }
    public void clickOnMinusIconInCatalogPDP(String name){
        restaurantUI.waitForVisibility(By.xpath(btn_catalogPDPMinusStable.replace("NAME", name)));
        restaurantUI.click(By.xpath(btn_catalogPDPMinusStable.replace("NAME", name)));
    }
    public String getFirstElementFrmCatalogSearchResults(String name){
        try {
            restaurantUI.waitForCustom(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        restaurantUI.waitForVisibility(By.xpath(lbl_catalogSearchResultItemList.replace("NAME", name)));
        return restaurantUI.getText(By.xpath(lbl_catalogSearchResultItemList.replace("NAME", name))).toLowerCase();
    }
    public void clickOnProduct(String name){
        restaurantUI.waitForVisibility(By.xpath(txt_product.replace("NAME", name)));
        restaurantUI.clickUsingJavaScript(By.xpath(txt_product.replace("NAME", name)));
    }
    public boolean isProductDetailsDisplayed(){
        return restaurantUI.isDisplayed(lbl_productDetails);
    }
    public void clickPlusSearchedSingleItem(){
        restaurantUI.click(btn_catalogPlus);
    }
    public void clickCheckOutPDP(){
        restaurantUI.click(btn_checkOutPDP);
    }

    public boolean isDeliveryOptionSelected() {
        try {
            restaurantUI.waitForVisibility(sel_delivery);
            String dataIconValue = restaurantUI.getText(sel_delivery, "data-icon").trim(); // Use getAttribute to fetch the attribute value
            return dataIconValue.equals("circle-check");
        } catch (Exception e) {
            return false;
        }
    }
    public String getOrderedId() {
        String orderId = restaurantUI.getText(txt_orderId);
        return orderId.substring(orderId.indexOf("#") + 1).trim();
    }
    public boolean isCustomersTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_customers);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_customers);
    }
    public boolean isCustomerSearchResultByCodeDisplayed(String code) throws InterruptedException {
        restaurantUI.waitForElementEnabledState(By.xpath(btnCustomerOrderGuide.replace("CODE", code)), true);
        restaurantUI.waitForCustom(4000);
        return restaurantUI.isDisplayed(By.xpath(btnCustomerOrderGuide.replace("CODE", code)));
    }
    public String getBusinessName(String customerId){
        restaurantUI.waitForVisibility(By.xpath(businessName.replace("CUSTOMERID",customerId)));
        return restaurantUI.getText(By.xpath(businessName.replace("CUSTOMERID",customerId)));
    }
    public void ClickOnCustomer(String code){
        restaurantUI.click(By.xpath(SelectCustomerByCode.replace("CODE", code)));
    }
    public boolean isCustomerProfileDisplayed(String businessName){
        try {
            restaurantUI.waitForVisibility(By.xpath(txt_customerProfile.replace("BUSINESSNAME",businessName)));
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(By.xpath(txt_customerProfile.replace("BUSINESSNAME",businessName)));
    }
    public void clickOnOrdersTab() {
        restaurantUI.click(tb_orders);
    }
    public void clickOnSpecificRecord(String orderId) {
        restaurantUI.click(By.xpath(specificOrderRecord.replace("ORDER_ID", orderId)));
    }
    public boolean isOrderIdDisplayed(String orderId) throws InterruptedException {
        restaurantUI.waitForVisibility(By.xpath(orderTitle.replace("ORDER_ID", orderId)));
        restaurantUI.waitForCustom(4000);
        return restaurantUI.isDisplayed(By.xpath(orderTitle.replace("ORDER_ID", orderId)));
    }
    public void clickAddToCart(){
        restaurantUI.click(btn_addToCartPDP);
    }
    public void selectPickUpWillCall(){
        restaurantUI.waitForVisibility(lbl_pickUp);
        restaurantUI.click(lbl_pickUp);
    }
    public boolean isPickUpOptionSelected() {
        try {
            restaurantUI.waitForVisibility(sel_pickup);
            String dataIconValue = restaurantUI.getText(sel_pickup, "data-icon").trim(); // Use getAttribute to fetch the attribute value
            return dataIconValue.equals("circle-check");
        } catch (Exception e) {
            return false;
        }
    }
    public void selectMailDelivery(){
        restaurantUI.waitForVisibility(lbl_mailDelivery);
        restaurantUI.click(lbl_mailDelivery);
    }
    public boolean isMailDeliveryOptionSelected() {
        try {
            restaurantUI.waitForVisibility(sel_mailDelivery);
            String dataIconValue = restaurantUI.getText(sel_mailDelivery, "data-icon").trim(); // Use getAttribute to fetch the attribute value
            return dataIconValue.equals("circle-check");
        } catch (Exception e) {
            return false;
        }
    }
    public void clickOnMontanaPlaceOrder() {
        restaurantUI.waitForVisibility(btn_montanaPlaceOrder);
        restaurantUI.click(btn_montanaPlaceOrder);
    }
    public void clickDoNotSubstitute()throws InterruptedException{
        restaurantUI.waitForVisibility(btn_doNotSubstitute);
        restaurantUI.click(btn_doNotSubstitute);
    }
    public void clickViewOrderInDraft() {
        restaurantUI.waitForVisibility(btn_viewOrderInDraft);
        restaurantUI.click(btn_viewOrderInDraft);
    }
    public boolean isSentApprovalDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_sentApproval);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_sentApproval);
    }
    public void clickOnPlusIconOrderGuideItem(){
        restaurantUI.click(btn_increaseQtyOrderGuide);
    }
    public boolean isUserNavigatedToChefGlendaCatalog() {
        return restaurantUI.isDisplayed(txt_glendaCatalog);
    }


}