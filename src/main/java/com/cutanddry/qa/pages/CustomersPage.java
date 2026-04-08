package com.cutanddry.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CustomersPage extends LoginPage {

    By lbl_itemNameList = By.xpath("//td//span/div[@data-tip='View Product Details']");
//    By btn_increaseQtyFirstRow = By.xpath("//tr[1]/td[6]/div/div/div/div[3]");
By btn_increaseQtyFirstRow = By.xpath("(//tr/td//div[contains(@data-tip,'View Product Details')]/following::td//div/*[contains(@data-icon,'plus')])[1]");
//    By btn_decreaseQtyFirstRow = By.xpath("//tr[1]/td[6]/div/div/div/div[1]");

By btn_decreaseQtyFirstRow = By.xpath("(//tr/td//div[contains(@data-tip,'View Product Details')]/following::td//div/*[contains(@data-icon,'minus')])[1]");
    By btn_decreaseQtySecondRow = By.xpath("//tr[2]/td[6]/div/div/div/div[1]");
    By btn_increaseQtySecondRow = By.xpath("(//tr/td//div[contains(@data-tip,'View Product Details')]/following::td//div/*[contains(@data-icon,'plus')])[2]");
    By btn_checkout = By.xpath("//button[@data-for='cartCheckoutButton']");
    By txt_catalog = By.xpath("//span[contains(text(), 'Catalog')]");
    By btn_catalog = By.xpath("//span[text()='Catalog']");
    By btn_catalogToOrderGuide = By.xpath("//span[text()='Order Guide']");
    By tbx_catalogSearch = By.xpath("//input[@placeholder='Search catalog...']");
    By tbx_orderGuideSearch = By.xpath("//input[@placeholder='Search order guide...']");
    //By lbl_catalogSearchItemList = By.xpath("(//button[contains(@data-for,'tooltipundefined')]/ancestor::div[2]/following-sibling::div[2]/div/div)[1]");
    By lbl_catalogSearchItemList = By.xpath("(//button[contains(@data-for,'add-to-order-guide')]/ancestor::div[2]/following-sibling::div[2]/div/div)[1]");
    By btn_addToCart = By.xpath("(//button[normalize-space()='Add to Cart' and not(@disabled)])[1]");
//    By tbx_itemQuantityFirstRow = By.xpath("//tr[1]//td[6]//input");
By tbx_itemQuantityFirstRow = By.xpath("(//*[@data-input ='quantityInput'])[1]");
//    By lbl_itemPriceFirstRow = By.xpath("(//td//span//div[@data-tip='View Product Details']/ancestor::tr/td[5]//div)[1] | (//td//span//div[@data-tip='View Product Details']/ancestor::tr/td[5]//span)[1]");
//By lbl_itemPriceFirstRow = By.xpath("(//td//span//div[@data-tip='View Product Details']/ancestor::tr/td[6]//input)[1] | (//td//span//div[@data-tip='View Product Details']/ancestor::tr/td[6]//span)[1]");
By lbl_itemPriceFirstRow = By.xpath("((//td//span//div[@data-tip='View Product Details']/ancestor::tr/td[last()-2]//input)[1] | (//td//span//div[@data-tip='View Product Details']/ancestor::tr/td[last()-2]//span)[1])[1]");
    By lbl_itemPriceFirstRow1 = By.xpath("((//td//span//div[@data-tip='View Product Details']/ancestor::tr/td[last()-2]//input)[1] | (//td//span//div[@data-tip='View Product Details']/ancestor::tr/td[last()-2]//span)[1])[2]");

    By btn_increaseQtyCatalog = By.xpath("//div[contains(@class, 'card-deck')]//*[name()='svg' and contains(@data-icon, 'plus')]");
    By btn_decreaseQtyCatalog = By.xpath("//div[contains(@class, 'card-deck')]//*[name()='svg' and contains(@data-icon,'minus')]");
    By tbx_itemQuantityCatalog = By.xpath("//input[@type='number']");
    By lbl_itemPriceSearchCatalogList = By.xpath("//div[5]/div/div[1]/div/span[contains(text(), '$')]");
    By txt_addToCart = By.xpath("//button[contains(text(), 'Add to Cart')]");
    By lbl_itemPriceReviewCart = By.xpath("//td[text()='Total:']/following-sibling::td");
    By btn_increaseQtyReviewCart = By.xpath("//tr[2]/td[4]/div/div/div/div/div[3]");
    By btn_increaseQtyByStepClick = By.xpath("//div[@class='d-flex align-items-center justify-content-center _ikqwqe _du1frc _1lliqxl btn-secondary _1pcpsid py-2 ml-2 text-center align-middle']");
    By btn_decreaseQtyReviewCart = By.xpath("//tr[2]/td[4]/div/div/div/div/div[1]");
    By tbx_itemQuantityReviewCart = By.xpath("//tr[2]/td[4]/div/div/div/div[2]/input");
    By lbl_itemPriceReviewCartFirstRow = By.xpath("//td//span//div[@data-tip='View Product Details']/ancestor::tr//td/span");
    By lbl_cartItemUnitPrice = By.xpath("(//td//span//div[@data-tip='View Product Details']/ancestor::tr/td[3]//input)[1] | (//td//span//div[@data-tip='View Product Details']/ancestor::tr/td[3]//span)[1]");
    By btn_submitOrder = By.xpath("//button[contains(text(),'Submit')]");
    By btn_duplicateOrderYes = By.xpath("//button[contains(text(), 'Yes')]");
    By lbl_thankYouForOrder = By.xpath("//*[contains(text(),'Thank you for your order!')]");
    By btn_companyDropdown = By.xpath("//button[.//span[text()='Company:']]");
    By txt_companyDropdownText = By.xpath("//a[contains(text(), 'Independent Foods Co')]");
    By btn_print = By.xpath("//*[contains(text(),'Print Order Guide') and .//*[local-name()='svg' and @data-icon='cdPrinter']]");
    By btn_downloadOrderGuide = By.xpath("//button[contains(text(), 'Download Order Guide')]");
    By lbl_printFriendlyOrderGuide = By.xpath("//h5[contains(text(), 'Print-Friendly Order Guide')]");
    By btn_edit = By.xpath("//a[contains(., 'Edit')]");
    By txt_editOrderGuide = By.xpath("//span[contains(text(), 'Edit Order Guide')]");
    By btn_moreOptions = By.xpath("//span[contains(text(), 'More Options')]");
    By btn_exportOrderGuide = By.xpath("//a[contains(text(), 'Export Order Guide (XLSX)')]");
    By btn_importOrderGuide = By.xpath("//a[contains(text(), 'Import Order Guide (XLSX)')]");
    By btn_uploadToOrder = By.xpath("//a[contains(text(), 'Upload to Order')]");
    By btn_create = By.xpath("//div[contains(text(), 'Create')]");
    By tbx_OrderGuideName = By.xpath("//input[@placeholder='Enter Name']");
    By btn_submitOrderGuide = By.xpath("//button[contains(text(), 'Submit')]");
    By btn_addFromCatalog = By.xpath("//div[contains(text(), 'Add from Catalog')]");
    By btn_addToOrderGuide = By.xpath("//button[@data-tip='Add to Order Guide']");
    By btn_closeEditor = By.xpath("//*[contains(text(), 'Close Editor')]");
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
//    By btn_deliveryDate = By.xpath("//div[@class='cd_themed_select__control css-sa5o0q-control']");
    By btn_deliveryDate = By.xpath("//div[text()='Delivery Date:']/../following-sibling::div//*[name()='svg' and @data-icon='calendar-date-vect']");
    By btn_selectDeliveryDateFirstLine = By.xpath("(//div[contains(@class, 'cd_themed_select__option')])[1]");
    By btn_selectDeliveryDateSecondLine = By.xpath("(//div[contains(@class, 'cd_themed_select__option')])[2]");
    By btn_orderGuideSettings = By.xpath("//div[contains(text(), 'Order Guide Settings')]");
    By btn_orderApproval = By.xpath("//div[contains(@class, 'react-switch-handle')]");
    By btn_save = By.xpath("//button[@type='button' and normalize-space()='Save']");
    By btn_previousDraftOrderNo = By.xpath("//div[contains(text(),'previous draft order')]/..//div[text()='No']");
    By btn_placeOrder = By.xpath("//a[contains(@class, 'btn-primary') and contains(text(), 'Place Order')]");
    By btn_increaseQtyFirstRowInWL = By.xpath("(//div[contains(@data-tip,'View Product Details')]/../../following::td//div/*[local-name()='svg' and @data-icon='plus'])[1]");
    By btn_decreaseQtyFirstRowInWL = By.xpath("(//div[contains(@data-tip,'View Product Details')]/../../following::td//div/*[local-name()='svg' and @data-icon='minus'])[1]");
    By txt_foodServiceDistCenter = By.xpath("//span[text()='Food Service Distribution Centre']");
    By txt_retailDistCenter = By.xpath("//span[text()='Retail Distribution Centre']");
    String txt_orders = "(//div[contains(text(), 'Order Number #')])[NUM]";
    By lbl_itemNameListWL = By.xpath("//td//span/div[@data-tip='View Product Details']");
    By tbx_searchCustomers = By.xpath("//input[@placeholder='Search Customers']");
    String btnOrderGuide = "//button[contains(text(), 'Order Guide')]";
    By btn_increaseQtyFirstRowDis = By.xpath("//tr[1]/td[8]/div/div/div/div[3]");
    By btn_pickup = By.xpath("//span[text()='Pickup']");
   // By txt_orderCutOffForPickUp = By.xpath("//span[contains(text(), '1:30am')]");
    String txt_orderCutOffForPickUp = "//span[contains(text(), 'TIME')]";
    By txt_errorSubmittingOrder= By.xpath("//div[text()='Error submitting order. Please try again.']");
    By orderCartDeletebtn = By.xpath("//td//*[name()='svg' and @data-icon='trash-can']");
    By totalValue = By.xpath("//td[contains(text(),'Total:')]/following-sibling::td");
    By selectedSections = By.xpath("//a[contains(@class,'_1ccoy1o text-decoration-none dropdown-item') and contains(text(),'Add Section')]");
    By sectionInput = By.xpath("//label[contains(text(),'Section Name')]/following-sibling::input[@id='sectionName']");
    By saveSectionBtn = By.xpath("//button[contains(text(),'Save')]");
    String section = "//div[contains(@class,'d-flex align-items-center no-gutters')]//div[text()='SECTIONNAME']";
    By backBtn = By.xpath("//button[contains(text(),'Back')]");
    String sectionEditBtn ="//div[text()='NAME']/following-sibling::div[@class='col-2 d-flex justify-content-end align-items-center']/*[local-name() = 'svg' and @data-icon='pencil']";
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
    By lbl_caseMinNotMet = By.xpath("//div[contains(text(), 'Case Minimum Not Met')] | //div[contains(text(), 'Order Minimum Not Met')]");
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
    By editOrderPage = By.xpath("(//div[contains(text(),'Edit Order #')])[last()]");
    By lbl_itemCodeList = By.xpath("(//td//span//div[@data-tip='View Product Details']/ancestor::tr/td[2])[1]");
    By lbl_itemPriceList = By.xpath("((//td//span//div[@data-tip='View Product Details']/ancestor::tr/td[last()-2]//input)[1] | (//td//span//div[@data-tip='View Product Details']/ancestor::tr/td[last()-2]//span)[1])[1]");
    By txt_reviewOrder = By.xpath("//div[text()='Review Order']");
    By btn_checkOutPDP = By.xpath("//button[@data-for='cartCheckoutButton' and contains(text(),'$')]");
//    String btn_catalogPDPPlusStable = "(//div[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = translate('NAME', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')]/following::div//*[name()='svg' and contains(@data-icon, 'plus')])[1]";
    String btn_catalogPDPPlusStable = "(//button[contains(@data-for,'add-to-order-guide')]/ancestor::div[2]/following-sibling::div)[1]/following-sibling::div//*[name()='svg' and contains(@data-icon, 'plus')]";
    String btn_catalogPDPMinusStable = "(//button[contains(@data-for,'add-to-order-guide')]/ancestor::div[2]/following-sibling::div)[1]/following-sibling::div//*[name()='svg' and contains(@data-icon, 'minus')]";
    String lbl_catalogSearchResultItemList = "(//div[contains(@class,'card-deck')]//div[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), translate('NAME', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'))])[last()]";
    String txt_product = "//div[contains(@class,'_3quvq7 _1vlidrf' ) and contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), translate('NAME', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'))]";
    String txt_productStableToPdp = "//div[contains(@class,'_3quvq7' ) and contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), translate('NAME', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'))]";
    By lbl_productDetails = By.xpath("//span[text()='Product Details']");
    By btn_catalogPlus = By.xpath("//*[name()='svg' and @data-icon='plus']");
    By itemSort = By.xpath("//div[contains(text(),'Sort Items By:')]/..//*[name()='svg']");
    By sel_delivery = By.xpath("//span[text()='Delivery']/preceding-sibling::div//*[contains(@data-icon, 'circle')]");
    By txt_orderId = By.xpath("//div[contains(text(),'Order Number #')]");
    By txt_customers = By.xpath("//h2[text()='Customers']");
    String btnCustomerOrderGuide = "//td[text()='CODE']/../td[8]//button";
    String businessName = "//td/following-sibling::td[contains(text(),'CUSTOMERID')]/following-sibling::td[1]";
    String SelectCustomerByCode = "//td[contains(text(),'CODE')]";
    String txt_customerProfile = "//div[contains(@class, 'd-flex') and contains(text(), 'BUSINESSNAME')]";
    By tb_orders = By.xpath("//a[text()='Orders' and @role='tab']");
    String specificOrderRecord = "//tr//*[text()='ORDER_ID']";
    String orderTitle = "//div[contains(text(),'Order #ORDER_ID')]";
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
    By btn_placeOrderSW = By.xpath("//button[contains(text(), 'Place Order')]");


    By lbl_firstMultiOUMItemName = By.xpath("(//*[local-name()='svg' and @data-icon='chevron-down'])[2]/ancestor::tr/td//span/div[@data-tip='View Product Details']");
    By lbl_firstMultiOUMItemCode = By.xpath("(//*[local-name()='svg' and @data-icon='chevron-down'])[2]/ancestor::tr/td[2]");
    By lbl_itemPriceListMultiOUM = By.xpath("(((//*[local-name()='svg' and @data-icon='chevron-down'])[2]/ancestor::tr/td[last()-2]//input)[1] | ((//*[local-name()='svg' and @data-icon='chevron-down'])[2]/ancestor::tr/td[last()-2]//span)[1])[1]");
    By lbl_itemPriceListMultiOUM1 = By.xpath("((//*[local-name()='svg' and @data-icon='chevron-down'])[2]/ancestor::tr/td[last()-2]/div/div/div)[1] | ((//*[local-name()='svg' and @data-icon='chevron-down'])[2]/ancestor::tr/td[last()-2]//span)[1])[2]");

    By lbl_firstMultiOUMItemNameCoupa = By.xpath("(//*[local-name()='svg' and @data-icon='chevron-down'])[1]/ancestor::tr/td//span/div[@data-tip='View Product Details']");
    By lbl_firstMultiOUMItemCodeCoupa = By.xpath("(//*[local-name()='svg' and @data-icon='chevron-down'])[1]/ancestor::tr/td[2]");
    By lbl_itemPriceListMultiOUMCoupa = By.xpath("(((//*[local-name()='svg' and @data-icon='chevron-down'])[1]/ancestor::tr/td[last()-2]//input)[1] | ((//*[local-name()='svg' and @data-icon='chevron-down'])[1]/ancestor::tr/td[last()-2]//span)[1])[1]");
    By lbl_itemPriceListMultiOUM1Coupa = By.xpath("((//*[local-name()='svg' and @data-icon='chevron-down'])[1]/ancestor::tr/td[last()-2]/div/div/div)[1] | ((//*[local-name()='svg' and @data-icon='chevron-down'])[1]/ancestor::tr/td[last()-2]//span)[1])[2]");

    String lbl_firstMultiOUMItemCodeLB = "(//*[local-name()='svg' and @data-icon='chevron-down'])/ancestor::tr/td[COUNT]//div[contains(text(),'LB')]/ancestor::td/parent::tr/td[2]";
    String lbl_firstMultiOUMItemNameLB = "(//*[local-name()='svg' and @data-icon='chevron-down'])/ancestor::tr/td[COUNT]//div[contains(text(),'LB')]/ancestor::td/parent::tr/td//span/div[@data-tip='View Product Details']";
    By lbl_orderGuideTableColumn = By.xpath("//table/thead/tr/td");
    String lbl_orderGuideTableColumnName = "//table/thead/tr/td[COUNT]";

    By lbl_itemCodeLists = By.xpath("//td//span//div[@data-tip='View Product Details']/ancestor::tr/td[2]");
    String lbl_ListsMultiOUMExist = "//td//span//div[@data-tip='View Product Details']/ancestor::tbody/tr[ROW_COUNT]/td//*[local-name()='svg' and @data-icon='chevron-down']";
    String lbl_firstSingleOUMItemName = "//td//span//div[@data-tip='View Product Details']/ancestor::tbody/tr[ROW_COUNT]/td//span/div[@data-tip='View Product Details']";
    String lbl_firstSingleOUMItemCode = "//td//span//div[@data-tip='View Product Details']/ancestor::tbody/tr[ROW_COUNT]/td[2]";

    String tbx_itemQuantityUOM = "(//td[text()='CODE']/following-sibling::*//div/input[@data-input ='quantityInput'])[UOM]";
    String multiUomDropDownOG = "(//td[text()='CODE']/following-sibling::*//div/*[local-name()='svg'])[1]";
    String btn_OGAddToCartPlusQuantity ="(//td[text()='CODE']/following-sibling::*//div/*[local-name()='svg' and @data-icon='plus'])[UOM]";
    String btn_OGRemoveToCartMinusQuantity ="(//td[text()='CODE']/following-sibling::*//div/*[local-name()='svg' and @data-icon='minus'])[UOM]";
    By multiUomOption =By.xpath("//div[text()='Multiple Units']");
    String lbl_itemPriceMultiOUM = "((//button/*[local-name()='svg' and @data-icon='chevron-up'])[1]/ancestor::tr/td[last()-2]//input)[UOM] | ((//button/*[local-name()='svg' and @data-icon='chevron-up'])[1]/ancestor::tr/td[last()-2]//span[1])[UOM]";
    By btn_orderCheckoutReview = By.xpath("//button[contains(@data-tip, 'Click here to checkout')][normalize-space()!='']");
    String lbl_cartItemUnitPriceReviewMultiUOM = "(//td//span//div[@data-tip='View Product Details']/ancestor::tr/td[3]//input)[UOM] | (//td//span//div[@data-tip='View Product Details']/ancestor::tr/td[3]//span[1])[UOM]";
    By combinedOrderPopUp = By.xpath("//div[contains(text(), 'Do you want to combine your orders?')]");
    By combinedOrderContinue = By.xpath("//button[contains(text(), 'Continue')]");
    By txtSetSubstitution = By.xpath("//div[contains(text(),'Item Substitution')]");
    By txtSetSubstitutionPopUp = By.xpath("//div[contains(text(),'Set Substitute Items')]");
    By btn_chooseSub = By.xpath("(//button[contains(text(),'Choose Sub')])[last()]");
    By btn_selectSub = By.xpath("//div[contains(text(), 'Substitute with:')]");
    By btn_closeSub = By.xpath("//*[local-name()='svg' and @data-icon='xmark']");
    By btn_editSub = By.xpath("(//*[local-name()='svg' and @data-icon='edit'])[last()]");
    By btn_notSelectSub = By.xpath("//div[contains(text(), 'Not Selected')]/preceding-sibling::*[1][local-name()='svg' and @data-icon='circle']");
    By btn_saveSelection = By.xpath("//button[normalize-space(text())='Save Selection']");
    By lbl_topCategoryPicks = By.xpath("//*[text()='Category']");
    By section_compareSimilar = By.xpath("//div[text()='Compare Similar Items']");
    String lbl_recommendedForYouItem = "//div[contains(text(), 'Recommended for You')]//following-sibling::div//div[text()='CODE']";
    String lbl_recommendedBySalesRep = "//div[contains(text(), 'Recommended by')]//following-sibling::div//div[contains(text(), 'CODE')]";
    By section_dontForget = By.xpath("//div[text()=\"Don't Forget to Order\"]");
    By section_moreFromThisBrand = By.xpath("//div[contains(text(), 'More From')]");
    By txtSubstitution = By.xpath("//div[contains(text(),'Substitution')]");

    String dynamicToXPath = "(//div[contains(@class,'react-datepicker__day--highlighted')]/preceding::div[contains(@class, 'react-datepicker__day') and text()='DAY'])[last()]";
    By txt_popupAlertOrderMin = By.xpath("//div[text()='Order Minimum Not Met']");
    By txt_minOrderBanner = By.xpath("//div[contains(text(), 'Add a few more items worth') and contains(text(), 'to meet minimum order amount')]");
    By btn_OK = By.xpath("//button[text()='OK']");
    By btn_yes = By.xpath("//button[text()='Yes']");
    By btn_cancel= By.xpath("//button[text()='Cancel']");
    By btn_invoice = By.xpath("//a[text()='Invoices']");
    By cb_inInvoiceTable = By.xpath("//table/tbody/tr[1]/td[1]//div[contains(@class, '_du1frc')]");
    By substitutionsAccessEditBtn = By.xpath("//div[contains(text(), 'Substitutions')]//following-sibling::div//div//*[name()='svg' and contains(@data-icon, 'pen-to-square')]");
    By substitutionDropDown = By.xpath("//div[contains(text(), 'Substitutions')]//following-sibling::div/div/div/div");
    String substitutionOption = "//div[contains(text(), 'Substitutions')]//following-sibling::*//div[text()='STATUS']";
    By Savebtn = By.xpath("//button[normalize-space(text())='Save']");
    String recentOrder = "//span[text()='Recent Orders']/../following-sibling::div//td[text()='ID']";
    By btn_previousDraftOrderYes = By.xpath("//div[contains(text(),'previous draft order')]/..//div[text()='Yes']");
    String removeItemOnOG = "//div[contains(text(),'NAME')]/../../preceding-sibling::div[2]//button[@data-tip='Remove from Order Guide']";
    By tbx_homeSearch = By.xpath("//input[@placeholder='Search items by name or code...']");
    By btn_homeSearch = By.xpath("//button/*[local-name()='svg' and @data-icon='magnifying-glass']");
    By txt_editItem = By.xpath("//*[contains(text(), 'Edit Item')]");
    By caseUnit = By.xpath("//label[text()='Unit']/../following-sibling::div[text()='Case']");
    String multiUomDropDownIndicator = "//td[text()='CODE']/following-sibling::td[1]//div/*[local-name()='svg']";
    By txt_recentOrder = By.xpath("//span[text()='Recent Orders']");
    By txt_doNotSubstitute = By.xpath("//div[text()='Do not substitute']");
    String lastColumn = "//td[6][contains(text(),'COLUMN')]";
    String txt_customerCode = "//td[text()='CODE']";
    By btn_editAccHold = By.xpath("//div[contains(text(),'Account Holds')]/..//*[local-name() = 'svg' and @data-icon='pen-to-square']");
    By dropdown_acc = By.xpath("//div[text()='Account Holds']/following-sibling::div//div[contains(@class, 'themed_select__value-container')]");
    By txt_hardHold = By.xpath("//div[contains(@class, 'themed_select__option') and  text()='Hard Hold']");
    By btn_save_DP = By.xpath("//button[normalize-space(text())='Save']");
    By lbl_hardHold = By.xpath("//div[text()='Account Holds']/following-sibling::div//span[contains(@class, 'badge') and text()='Hard Hold']");
    By accountOnHold = By.xpath("//h2[text()='Account on hold!']");
    String accountHoldMessage = "//p[text()='MESSAGE']";
    String dynamicToXPathStable = "//div[contains(@class,'react-datepicker')]/preceding::div[contains(@class, 'react-datepicker__day') and contains(@aria-disabled, 'false') and text()='DAY']";
    String deliveryDateOrderHistory = "//*[contains(text(),'#') and text()='ID']/../../preceding-sibling::td[2][contains(text(),'DATE')]";
    By btn_pickUpDateStable = By.xpath("//div[text()='Pickup Date:']/../following-sibling::div//*[name()='svg' and @data-icon='calendar-date-vect']");
    String fulfillmentTypeOrderHistory = "//*[contains(text(),'#') and text()='ID']/../../preceding-sibling::td[2]//*[text()='TYPE']";
    By btn_nextMonth = By.xpath("//button[contains(@aria-label,'Next Month')]");
    String reviewOrderFulfilment = "//span[contains(text(),'TYPE')]";
    By btn_deleteOrderGuide = By.xpath("//div[contains(text(), 'Delete Order Guide')]");
    By icon_deleteSearchItem = By.xpath("(//*[local-name()='svg' and @data-icon='circle-xmark'])[1]");
    By txt_purchaseHistoryCatalog = By.xpath("//div[text()='Purchase History']");
    String lastOrderDetails = "//div[text()='ORDER']";
    String lbl_lastOrderDetails = "(//div[contains(@class,'card-deck')]//div[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), translate(\"NAME\", 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'))])[last()]/../following-sibling::div/div";
    String purchaseHistoryOG = "(//td[text()='CODE']/following-sibling::td[2]/div/div)[1]";
    String txt_specialOrderNote = "//div[text()='NOTE']";
    By lbl_orderGuide = By.xpath("//div[text()='Order Guide:']/following-sibling::div//div[@class='cd_themed_select__single-value css-1uccc91-singleValue']");
    String dropDownOrderGuide =  "(//div[contains(text(), 'Order Guide:')]//following::div[contains(text(), 'NAME')])[last()]";
    By btn_listView = By.xpath("//button//*[local-name()='svg' and @data-icon='cdNewList']");
    By btn_addToOrderGuideListView = By.xpath("//td/button[@data-tip='Add to Order Guide']");
    By lbl_locationGuide = By.xpath("//div[text()='Location/Guide:']/following-sibling::div//div[@class='cd_themed_select__single-value css-1uccc91-singleValue']");
    String dropDownLocationOrderGuide =  "(//div[contains(text(), 'Location/Guide:')]//following::div[contains(text(), 'NAME')])[last()]";
    By catalogAccessEditBtn = By.xpath("//div[contains(text(), 'Catalog Access')]//following-sibling::div//div[@class='pl-0 col-sm-auto col-auto']//*[name()='svg' and contains(@data-icon, 'pen-to-square')]");
    By catalogAccessDisableOption = By.xpath("//div[contains(text(),'Internal Only')]");
    By catalogAccessEnableOption = By.xpath("//div[contains(text(),'Visible to All')]");
    By lbl_catalogAccessEnable = By.xpath("//div[contains(text(), 'Catalog Access')]//following-sibling::div//*[contains(text(),'Visible to All')]");
    By catalogAccessDisableTxt = By.xpath("//div[@class='list-group-item']//div[text()='Internal Only']");
    By txt_poNumber = By.xpath("//div[contains(text(),'PO Number')]/following-sibling::div/input");
    String pONumberError = "//h2[text()='ERROR']";
    String catalogFilter = "//div[contains(text(),'FILTER')]";
    String catalogFilterTag = "//div[contains(text(),'TAG')]";
    By txt_editOrderGuideCatalog = By.xpath("//div[contains(text(), 'Edit Order Guide')]");
    String catalogFilterTagNewArrival = "//span[contains(text(),'TAG')]";
    String newItemTagCatalog = "(//div[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), translate(\"NAME\", 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'))]/../../following-sibling::div//span[text()='TAG'])[last()]";
    String itemTagOG = "//div[contains(text(),'NAME')]/../../following-sibling::div//span[text()='TAG']";
    String newItemTagPDP = "//div[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), translate(\"NAME\", 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'))]/following-sibling::div//span[text()='TAG']";
    String catalogSearchItemCode = "//div[contains(@class,'card-deck')]//div[contains(., 'CODE')]";
    By btn_cartSummery = By.xpath("(//*[local-name() = 'svg' and @data-icon='chevron-down'])[2]");
    String cartSummary = "//span[text()='COUNT']";
    String cartSummaryValue = "//div[contains(text(),'NAME')]";
    By btn_menu = By.xpath("//*[local-name() = 'svg' and @data-icon='bars']");
    String txt_userName = "//div[contains(text(),'NAME')]";
    String txt_distributorName = "//span[contains(text(),'NAME')]";
    By btn_closeMenu = By.xpath("//*[local-name() = 'svg' and @data-icon='cdCancel']");
    String btn_catalogPlusStable = "((//div[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = translate(\"NAME\", 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')])[2]/../../following::div//*[name()='svg' and contains(@data-icon, 'plus')])[1]";
    By btn_sendERP = By.xpath("//span[text()='Send to ERP']");
    String txt_notesToCustomer = "//div[text()='Notes to Customer']/following-sibling::div[text()='NOTE']";
    By txt_submitERP = By.xpath("//h2[text()='Submit Order to ERP?']");
    By txt_OrderSentERP = By.xpath("//h2[text()='Order sent to ERP!']");
    String txt_OrderSubmissionStep = "//td[text()='STEP']";
    By btn_timeline = By.xpath("//a[@role='tab' and @data-rb-event-key='Timeline']");
    String submittedOrder = "//*[contains(text(),'#') and text()='ID']";
    By dropdown_option_SimpleListView = By.xpath("//div[text()='Simple List View']");
    By txt_simpleListView = By.xpath("//div[text()='Simple List View']");
    String sortOptionOG = "(//div[contains(text(), 'Sort Items By:')]//following::div[contains(text(), 'OPTION')])[last()]";
    String sortResult = "(//td//span[text()='OPTION'])[1]";
    By dropdown_SortOptions = By.xpath("(//div[contains(text(),'Sort Items By')])[last()]/following-sibling::div/div");
    By btn_OGAndCatalogSearch = By.xpath("//div//*[name()='svg' and contains(@data-icon, 'cdSearch')]");
    String txt_productStable = "//div[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), translate('NAME', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'))]";
    String txt_productStableAddToCart = "//div[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), translate('NAME', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'))]/../../following-sibling::div//*[name()='svg' and contains(@data-icon, 'plus')]";
    By btn_uploadOrder = By.xpath("//button[contains(text(), 'Upload Order')]");
    By txt_uploadToOrder = By.xpath("//div[contains(text(), 'Upload to Order')]");
    String tbx_itemQuantity = "//td[text()='CODE']/following-sibling::*//div/input[@data-input ='quantityInput']";
    String btn_editRecentOrder = "//td[text()='ORDERID']/following-sibling::td/button[text()='Edit Order']";
    String btn_editRecentOrderQuantity = "//td[text()='ORDERID']/following-sibling::td[text()='QUANTITY']";
    String btn_editRecentOrderPrice = "//td[text()='ORDERID']/following-sibling::td[3]";
    By dropdown_option_QuickAdd = By.xpath("//div[text()='Quick Add View']");
    By txt_QuickAddView = By.xpath("//div[text()='Quick Add View']");
    By lbl_itemCode = By.xpath("(//div[text()='Item Code']/../../../../following-sibling::td//input)[1]");
    By lbl_itemQuantity = By.xpath("(//div[text()='Item Code']/../../../../following-sibling::td//input)[2]");
    By lbl_SimpleListQuantity = By.xpath("(//tbody[1]/tr[2]/td[7]/span[1]/div[1]/div[1]/div[1]/div[2]/input[1])");
    By btn_verifyItem = By.xpath("//button[text()='Verify Items']");
    By btn_saveAndReview = By.xpath("//button[text()='Save & Review']");
    String quantityReviewPage = "//td[text()='CODE']/following-sibling::*//input";
    By dropdown_option_OrderGuideView = By.xpath("//div[text()='Order Guide View']");
    String quantitySimpleListView = "//span[text()='CODE']/../following-sibling::*//input";
    By txt_itemVerified = By.xpath("//div[text()='Items Verified Successfully']");
    By btn_increaseQtyFirstRowStable = By.xpath("(//table/tbody/tr//*[local-name()='svg' and @data-icon='plus'])[1]");
    By dropdown_option_ManageStandingOrders = By.xpath("//div[text()='Manage Standing Orders']");
    By txt_ManageStandingOrders = By.xpath("//div[text()='Manage Standing Orders']");
    By btn_CreateStandingOrders = By.xpath("//button[text()='Create a Standing Order']");
    By btn_removeDelivery = By.xpath("(//div[contains(@class, 'cd_themed_select__clear-indicator')])[1]");
    By dropdown_delivery = By.xpath("(//div[contains(@class,'cd_themed_select__dropdown-indicator')])[1]");
    String txt_deliveryDay = "//div[text()='DAY']/preceding-sibling::input[@type='checkbox']";
    String txt_deliveryLastBeforeDay = "(//div[contains(@class, 'cd_themed_select__option')]//input[@type='checkbox'])[last()-1]";
    By btn_setStandingOrder = By.xpath("//button[text()='Set Standing Order']");
    By btn_resetStandingOrder = By.xpath("//button[text()='Reset Standing Order']");
    By txt_success = By.xpath("//h2[text()='Success']");
    By txt_reviewStandingOrders = By.xpath("//div[text()='Review Standing Order']");
    By btn_editStandingOrderIcon = By.xpath("//span[text()='Edit']");
    By btn_deleteStandingOrderIcon = By.xpath("//button[.//span[text()='Edit']]/following-sibling::button[1]");
    By txt_deletePopup = By.xpath("//h2[text()='Are you sure?']");
    String standingOrder = "//div[text()=' (QUANTITY items for $PRICE)']";
    By btn_pauseStandingOrderIcon = By.xpath("//button/*[contains(@data-icon,'circle-pause')]");
    By txt_pausedStandingOrders = By.xpath("//div[contains(text(),'(Paused) ')]");
    By btn_resumeStandingOrderIcon = By.xpath("//button/*[contains(@data-icon,'circle-play')]");
    String btn_addToRecentOrder = "//td[text()='ORDERID']/following-sibling::td/button[text()='Add to Order']";
    String increaseQuantityReviewPage = "//td[text()='CODE']/following-sibling::td//div/*[contains(@data-icon,'plus')]";
    String decreaseQuantityReviewPage = "//td[text()='CODE']/following-sibling::td//div/*[contains(@data-icon,'minus')]";
    String trashCanReviewPage = "//td[text()='CODE']/following-sibling::td//div/*[contains(@data-icon,'trash-can')]";
    String btn_addRecentOrder = "//td[text()='ORDERID']/following-sibling::td/button[text()='Add to Order']";
    By btn_calculateOrderQty = By.xpath("(//td//span//div[@data-tip='View Product Details']/../../../../../following-sibling::td[3]/div/div/div)[1]");
    By lbl_calculateOrderQty = By.xpath("//div[contains(text(),'Calculate Order Quantity')]");
    By lbl_parValue = By.xpath("//div[contains(text(),'Par')]/../following-sibling::div//input");
    By lbl_OnSiteInvValue = By.xpath("//div[contains(text(),'On-Site Inv')]/../following-sibling::div//input");
    By lbl_ItemTotal= By.xpath("//div[contains(text(),'Item Total')]/../following-sibling::div//input");
    By btn_clearAll = By.xpath("//div[text()='Clear All']");
    String cartSummeryValue = "//div[contains(text(),'OPTION')]/following-sibling::div";
    String revenueSummeryValue = "(//div[contains(text(),'OPTION')]/following-sibling::div/span)[1]";
    String txt_preAuthorization = "//h2[text()='MESSAGE']";
    By txt_confirmPayment = By.xpath("//div[text()='Confirm Payment']");
    By btn_continue = By.xpath("//button[contains(text(), 'Continue')]");
    String sortOptionsOG = "//span[contains(text(), 'OPTION')]";
    By lbl_deliveryTo = By.xpath("//div[text()='Delivery To:']/following-sibling::div");
    By deliveryAddress = By.xpath("//div[text()='Delivery To:']/following-sibling::*//div[contains(@id,'react-select')]");
    By deliveryAddressOption = By.xpath("(//div[text()='Delivery To:']/following-sibling::*//div[contains(@id,'react-select')])[2]");
    By singleDeliveryAddress = By.xpath("//div[text()='Delivery To:']/following-sibling::div/div[text()='Avcoa Vending']");
    By btn_accHoldClose_ = By.xpath("(//button[contains(@class, 'close')]/span[text()='×'])[last()]");
    String accountOnHoldBanner = "//span[text()='MESSAGE']";
    String distributorCenter = "//div[contains(text(),'Distribution Center')]/../../following-sibling::div//*[text()='CENTER']";
    String listViewTag = "//td[contains(text(),'NAME')]//span[contains(text(),'TAG')]";
    String orderGuideLocation =  "//div[contains(text(), 'Location/Guide:')]//following::div[text()= 'NAME']";
    By txtCatalog = By.xpath("//div[text()='Catalog']");
    By btn_placeOrderSoftOrderMinimum = By.xpath("//button[text()='Place Order']");
    By orderMinimumeditBtn = By.xpath("//*[contains(text(),'Order Minimum')]/following-sibling::div//*[local-name()='svg' and @data-icon='pen-to-square']");
    String orderMinimumSelectionRadioBtn = "//*[contains(text(),'ORDERMINIMUM')]/../input";
    By orderMinimumOverlayCloseBtn = By.xpath("//*[contains(text(),'Edit Order Minimum')]/../following-sibling::button/span[normalize-space()='×']");
    By customer_Holds = By.xpath("//span[contains(text(),'Credit') or contains(text(),'Hard') or contains(text(),'General')]");
    By btn_saveEditShipAddress = By.xpath("//button[contains(text(),'Save Changes')]");
    By txt_none = By.xpath("//div[contains(@class, 'themed_select__option') and  text()='None']");
    By btn_saveEditPriceVisibility = By.xpath("//button[normalize-space()='Save']");







    By txt_itemVerifiedFailed = By.xpath("//div[@class='_6ym2rgf']");
    By txt_MaxQuantityExceededErrorMsg = By.xpath("//span[@class='p-1 _2h0ira _wjtawc _1ety1lk']");
    String quantityInputSimpleListViewByIndex = "(//table//tbody//tr//input[@data-input='quantityInput'])[INDEX]";
    By txt_maxQuantityErrorModal = By.xpath("//h2[contains(text(),'Maximum')] | //div[contains(text(),'maximum')] | //h2[contains(text(),'Error')]");
    By btn_errorModalOk = By.xpath("//button[contains(text(),'OK')] | //button[contains(text(),'Ok')] | //button[contains(text(),'Close')]");

    By txt_maxQuantityExceededModal = By.xpath("//div[@role='dialog']");
    By txt_maxQuantityExceededMessage = By.xpath("//div[@id='swal2-content' and text()='You have reached the maximum order quantity for this item.']");
    By btn_maxQuantityModalOk = By.xpath("//button[text()='OK']");
    By btn_increaseQtyFirstRowDisabled = By.xpath("//div[@class='d-flex align-items-center justify-content-center _ikqwqe btn-secondary disabled _1pcpsid py-2 ml-2 text-center align-middle']");
    String btn_catalogPDPPlusDisabled = "(//button[contains(@data-for,'add-to-order-guide')]/ancestor::div[2]/following-sibling::div)[1]/following-sibling::div//*[name()='svg' and contains(@data-icon, 'plus')]/ancestor::button[@disabled]";
    String btn_reviewCartPlusDisabled = "//td[text()='CODE']/following-sibling::*//div/*[local-name()='svg' and @data-icon='plus']/ancestor::button[@disabled]";
    String tbx_itemQuantityByCode = "(//button[contains(@data-for,'add-to-order-guide')]/ancestor::div[2]/following-sibling::div)[1]/following-sibling::div//*//input[@data-input='quantityInput']";
    String getTxtCatalogPdpItemCount = "//input[@data-input='quantityInput']";


    By txt_orderGuideSettingsOverlay = By.xpath("//div[contains(text(), 'Order Guide Settings')]");
    By txt_orderMinimumField = By.xpath("//div[contains(text(), 'Min. Order Amount')]");
    By txt_orderCaseMinimumField = By.xpath("//div[contains(text(), 'Min. Order Cases')] | //div[contains(text(), 'Case Minimum')]");
    By txt_deliveryDaysField = By.xpath("//div[contains(text(), 'Delivery Days')]");
    By tbx_orderMinimumInput = By.xpath("//label[normalize-space()='Min. Order Amount']/following-sibling::input");
    By tbx_orderCaseMinimumInput = By.xpath("//label[normalize-space()='Min. Order Cases']/following-sibling::input");
    By btn_saveOrderGuideSettings = By.xpath("//button[contains(text(), 'Save')]");
    By btn_closeOrderGuideSettings = By.xpath("//button[contains(@class, 'close')]/span[text()='×'] | //button[contains(text(), 'Close')]");
    String txt_deliveryDayCheckbox = "//div[text()='DAY']/preceding-sibling::input[@type='checkbox'] | //label[contains(text(), 'DAY')]/input[@type='checkbox']";
    String txt_removeDeliveryDay =
            "//div[contains(@class,'themed_select__multi-value')]" +
                    "[.//div[normalize-space()='DAY']]" +
                    "//div[contains(@class,'themed_select__multi-value__remove')]";

    By btn_backToCart =
            By.xpath("//button[@data-testid='order-minimum-back']");

    By txt_popupAlertCaseMin = By.xpath("//h2[normalize-space()='Case Minimum Not Met']");
    By btn_ramona =
            By.xpath("//div[@class='w-100' and normalize-space()='Ramona']");

    By MinOrderAmountLabel = By.xpath("//label[normalize-space(text())='Min. Order Amount']");
    By MinOrderCaseLabel = By.xpath("//label[normalize-space(text())='Min. Order Cases']");
    By DeliveryDateLabel = By.xpath("//label[normalize-space(text())='Delivery Days']");

    By priceVisibilityEditBtn = By.xpath("//div[contains(text(), 'Price Visibility')]//following-sibling::div//div//*[name()='svg' and contains(@data-icon, 'pen-to-square')]");
    By priceVisibilityDropDown = By.xpath("//div[contains(text(), 'Price Visibility')]//following-sibling::div/div/div/div");
    String priceVisibilityOption = "//div[contains(text(), 'Price Visibility')]//following-sibling::*//div[text()='STATUS']";

    By txt_generalHold = By.xpath("//div[contains(@class, 'themed_select__option') and text()='General Hold']");
    By lbl_generalHold = By.xpath("//div[text()='Account Holds']/following-sibling::div//span[contains(@class, 'badge') and text()='General Hold']");
    By btn_contactSupplier = By.xpath("//button[contains(text(),'Contact Supplier')]");
    By btn_viewDetails = By.xpath("//button[contains(text(),'View Details')]");
    String generalHoldModalMessage = "//p[contains(text(),'MESSAGE')]";
    By generalHoldBanner = By.xpath("//div[contains(@class,'alert') or contains(@class,'banner')]//span[contains(text(),'hold') or contains(text(),'Hold')]");
    By chatWindowPlaceholderText = By.xpath("//input[@placeholder='Message...']");
    By contactSupplierBtn = By.xpath("//button[normalize-space()='Contact Supplier']");

    By lnk_addInstructionsFirstItem = By.xpath("(//div[normalize-space()='Add Instructions'])[2]");
    String lnk_addInstructionsByItemCode = "//td[text()='ITEMCODE']/ancestor::tr//span[contains(text(),'Add Instructions')] | //td[text()='ITEMCODE']/ancestor::tr//a[contains(text(),'Add Instructions')]";
    String lnk_instructionsByItemCode = "//td[text()='ITEMCODE']/ancestor::tr//span[contains(text(),'Instructions')] | //td[text()='ITEMCODE']/ancestor::tr//a[contains(text(),'Instructions')]";
    By txt_itemInstructionModal = By.xpath("//div[contains(@class,'modal')]//div[contains(text(),'Item Instruction')] | //div[contains(@class,'modal')]//h5[contains(text(),'Instruction')]");
    By tbx_itemInstructionInput = By.xpath("//textarea[@placeholder='Enter instructions here...']");
    By btn_updateItemInstruction = By.xpath("//button[normalize-space()='Update']");
    By btn_cancelItemInstruction = By.xpath("//button[normalize-space()='Cancel']");
    String txt_instructionsDisplayByItemCode = "//td[text()='ITEMCODE']/ancestor::tr//span[contains(text(),'Instructions:')]";
    String txt_instructionsTextByItemCode = "//td[text()='ITEMCODE']/ancestor::tr//span[contains(text(),'Instructions:')]/following-sibling::span | //td[text()='ITEMCODE']/ancestor::tr//span[contains(@class,'instruction')]";
    By lnk_EditInstructionsItem = By.xpath("//div[normalize-space()='Instructions:']");

    By itemSavedInstruction = By.xpath("//*[@data-testid='instruction-value']");
    By messageInInstructionHistory = By.xpath("//p[normalize-space()='Please slice thin']");


    By lbl_specialInstructions = By.xpath("//div[contains(text(),'Special Instructions')]");
    By txt_specialInstructionsTextArea = By.xpath("//div[contains(text(),'Special Instructions')]/following-sibling::div//textarea | //textarea[@placeholder='Enter special instructions...'] | //div[contains(text(),'Special Instructions')]/..//textarea");
    By icon_specialInstructionsTooltip = By.xpath("//div[contains(text(),'Special Instructions')]//*[local-name()='svg' and (@data-icon='circle-info' or @data-icon='info-circle')] | //div[contains(text(),'Special Instructions')]//button[contains(@data-tip,'')]");
    By get_specialInstructionsInHistory = By.xpath("//div[normalize-space()='Please deliver to back door. Call upon arrival.']");

    By txt_priceDisclaimer = By.xpath("//div[normalize-space()='*Prices are subject to change. Weighed item prices are estimated.']");
    By btn_saveDraft = By.xpath("//div[normalize-space(text())='Save Draft']");
    By btn_switchToOfflineMode = By.xpath("//a[contains(text(), 'Switch to Offline Mode')] | //div[contains(text(), 'Switch to Offline Mode')]");
    By btn_activateOfflineMode = By.xpath("//button[contains(text(), 'Activate Offline Mode')]");
    By txt_offlineModeActive = By.xpath("//*[contains(text(), 'Offline Mode')] | //*[contains(text(), 'offline mode')]");
    String dropDownSupplierLocationOrderGuide =  "(//div[contains(text(), 'Location/Guide:')]//following::div[contains(text(), 'NAME')])[1]";
    By catelogPageQuantityInput = By.xpath("//input[@data-input='quantityInput']");

    String txt_itemUnavailableTag = "//td[text()='CODE']/ancestor::tr//span[contains(text(),'Unavailable')] | //div[contains(text(),'CODE')]/ancestor::tr//span[contains(text(),'Unavailable')]";
    String txt_itemRowByCode = "//td[text()='CODE'] | //div[contains(@data-tip,'View Product Details')]//div[contains(text(),'CODE')]";
    By txt_noItemsFoundCatalog = By.xpath("//div[contains(text(),'No items found')] | //div[contains(text(),'No results')] | //div[contains(text(),'no items')]");


//###################################

    By lbl_headerCartTotal = By.xpath("//button[@data-for='cartCheckoutButton']//span[contains(text(),'$')] | //div[contains(@class,'order-summary')]//span[contains(text(),'$')]");
    By lbl_headerLineItemsCount = By.xpath("//div[contains(@class,'d-flex')]//span[contains(@class,'badge') or contains(@class,'count')][preceding-sibling::*[local-name()='svg' and (@data-icon='list' or @data-icon='bars')]] | //*[local-name()='svg' and (@data-icon='list' or @data-icon='bars')]/following-sibling::span");
    By lbl_headerQuantityCount = By.xpath("//div[contains(@class,'d-flex')]//span[contains(@class,'badge') or contains(@class,'count')][preceding-sibling::*[local-name()='svg' and (@data-icon='shopping-bag' or @data-icon='bag-shopping')]] | //*[local-name()='svg' and (@data-icon='shopping-bag' or @data-icon='bag-shopping')]/following-sibling::span");
    By lbl_headerOrderMinimum = By.xpath("//button[@data-for='cartCheckoutButton']//span[contains(text(),'/')]/following-sibling::span | //div[contains(@class,'order-summary')]//span[contains(text(),'/')]");
    By lbl_orderSummaryWidget = By.xpath("//div[contains(text(),'Order Summary')] | //div[contains(@class,'order-summary')]");
    By btn_checkoutButtonPrice = By.xpath("//button[@data-for='cartCheckoutButton']");
    By txt_brandColumnHeader = By.xpath("//th[contains(text(),'Brand')] | //td[contains(text(),'Brand')] | //div[contains(@class,'header') and contains(text(),'Brand')]");
    By txt_catalogListViewTable = By.xpath("//table[contains(@class,'table')] | //table//thead");
    String txt_brandColumnData = "//table//tbody//tr[INDEX]//td[contains(@class,'brand')] | //table//tbody//tr[INDEX]/td[3]";
    By txt_firstItemBrandInListView = By.xpath("(//table//tbody//tr//td[3])[1]");
    By txt_firstItemNameInListView = By.xpath("(//table//tbody//tr//td[1]//div[@data-tip='View Product Details'] | //table//tbody//tr//td[1]//span)[1]");
    By editItemNameTextField = By.xpath("//label[contains(text(),'Item Name')]/following-sibling::input");

    By tbx_titleStandingOrder = By.xpath("//input[@placeholder='Enter title']");
    By txt_cartEmpty = By.xpath("//button[@data-tip='Your cart is empty']");

    public boolean isPreviousDraftOrderNoDisplayed() throws InterruptedException {
        /*getRestaurantUI().waitForElementEnabledState(btn_previousDraftOrderNo, true);
        getRestaurantUI().waitForCustom(2000);*/
        return getRestaurantUI().isDisplayed(btn_previousDraftOrderNo);
    }

    public void clickPreviousDraftOrderNo() throws InterruptedException {
        getRestaurantUI().click(btn_previousDraftOrderNo);
    }
    public boolean caseMinNotMetDisplayed() throws InterruptedException {
        return getRestaurantUI().isDisplayed(lbl_caseMinNotMet);
    }
    public String getItemNameFirstRow() {
        getRestaurantUI().waitForVisibility(lbl_itemNameList);
        return getRestaurantUI().getText(lbl_itemNameList);
    }

    public void clickPlusQryFirstRow() throws InterruptedException {
        getRestaurantUI().click(btn_increaseQtyFirstRow);
        getRestaurantUI().waitForCustom(4000);
    }

    public void clickPlusQrySecondRow() throws InterruptedException {
        getRestaurantUI().click(btn_increaseQtySecondRow);
        getRestaurantUI().waitForCustom(4000);
    }

    public void clickMinusQryFirstRow() throws InterruptedException {
        getRestaurantUI().click(btn_decreaseQtyFirstRow);
        getRestaurantUI().waitForCustom(4000);
    }

    public void clickMinusQrySecondRow() throws InterruptedException {
        getRestaurantUI().click(btn_decreaseQtySecondRow);
        getRestaurantUI().waitForCustom(4000);
    }

    public void clickPlusQryFirstRowClassic() throws InterruptedException {
        getRestaurantUI().click(btn_increaseQtyFirstRowClassic);
        getRestaurantUI().waitForCustom(4000);
    }

    public void clickMinusQryFirstRowClassic() throws InterruptedException {
        getRestaurantUI().click(btn_decreaseQtyFirstRowClassic);
        getRestaurantUI().waitForCustom(4000);
    }

    public void clickPlusCatalog() throws InterruptedException {
        getRestaurantUI().waitForCustom(4000);
        getRestaurantUI().click(btn_increaseQtyCatalog);
    }

    public void clickMinusCatalog() throws InterruptedException {
        getRestaurantUI().click(btn_decreaseQtyCatalog);
        getRestaurantUI().waitForCustom(4000);
    }

    public String getItemNameSecondRow() {
        return getRestaurantUI().getText(lbl_itemNameList, 1);
    }

    public void clickOnCheckoutButton() throws InterruptedException {
        getRestaurantUI().waitForElementEnabledState(btn_checkout, true);
        getRestaurantUI().click(btn_checkout);
        getRestaurantUI().waitForCustom(4000);
    }

    public boolean isCatalogTextDisplayed() {
        return getRestaurantUI().isDisplayed(txt_catalog);
    }

    public void clickOnCatalogButton() {
        getRestaurantUI().click(btn_catalog);
    }
    public void clickOrderGuideTab(){
        getRestaurantUI().waitForVisibility(btn_catalogToOrderGuide);
        try {
            getRestaurantUI().waitForCustom(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getRestaurantUI().click(btn_catalogToOrderGuide);
    }

    public void typeToSearchOnCatalog(String item) throws InterruptedException {
        getRestaurantUI().waitForCustom(3000);
        getRestaurantUI().click(icon_deleteSearchItem);
        getRestaurantUI().clearUsingJavaScript(tbx_catalogSearch);
        getRestaurantUI().click(tbx_catalogSearch);
        getRestaurantUI().waitForCustom(2000);
        getRestaurantUI().sendKeys(tbx_catalogSearch, item);
        getRestaurantUI().click(btn_OGAndCatalogSearch);
        getRestaurantUI().waitForCustom(4000);
    }

    public void typeToSearchOnOrderGuide(String item) {
        getRestaurantUI().click(icon_deleteSearchItem);
        getRestaurantUI().sendKeys(tbx_orderGuideSearch, item);
        getRestaurantUI().click(btn_OGAndCatalogSearch);
        try {
            getRestaurantUI().waitForCustom(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public String getFirstItemNameFrmSearchResults() {
        return getRestaurantUI().getText(lbl_catalogSearchItemList, 0);
    }

    public void clickAddToCartCatalog() throws InterruptedException {
        getRestaurantUI().waitForCustom(4000);
        getRestaurantUI().waitForVisibility(btn_addToCart);
        getRestaurantUI().waitForClickability(btn_addToCart);
        getRestaurantUI().waitForCustom(4000);
        getRestaurantUI().clicked(btn_addToCart);
        getRestaurantUI().waitForCustom(2000);
        getRestaurantUI().waitForElementEnabledState(btn_checkout, true);
    }

    public String getItemQtyFirstRow() {
        getRestaurantUI().waitForVisibility(tbx_itemQuantityFirstRow);
        return getRestaurantUI().getText(tbx_itemQuantityFirstRow, "value");
    }

    public String getItemQtyFirstRowClassic() {
        return getRestaurantUI().getText(tbx_itemQuantityFirstRowClassic, "value");
    }

    public String getItemQtyCatalog() {
        return getRestaurantUI().getText(tbx_itemQuantityCatalog, "value");
    }

    public Double getItemPriceCatalogSearch() {
        return Double.valueOf(getRestaurantUI().getText(lbl_itemPriceSearchCatalogList).replace("$", ""));
    }

   /* public Double getItemPriceFirstRow() {
        getRestaurantUI().waitForVisibility(lbl_itemPriceFirstRow);
        String tagName = getRestaurantUI().getElement(lbl_itemPriceFirstRow).getTagName();
        String priceText;
        if (tagName.equals("input")) {
            priceText = getRestaurantUI().getText(lbl_itemPriceFirstRow, "value");
        } else {
            priceText = getRestaurantUI().getText(lbl_itemPriceFirstRow);
        }
        return Double.valueOf(priceText.replace("$", "").trim());
//        return Double.valueOf(getRestaurantUI().getText(lbl_itemPriceFirstRow).replace("$", ""));
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
        getRestaurantUI().waitForVisibility(priceLocator);
        String tagName = getRestaurantUI().getElement(priceLocator).getTagName();
        String priceText;

        if (tagName.equals("input")) {
            priceText = getRestaurantUI().getText(priceLocator, "value");
        } else {
            priceText = getRestaurantUI().getText(priceLocator);
        }

        System.out.println("Extracted Price: " + priceText);
        return Double.valueOf(priceText.replace("$", "").replace("/cs", "").replace("/pkg", "").trim());
    }

    public Double getItemPriceOnCheckoutButton() {
        getRestaurantUI().waitForVisibility(btn_checkout);
        return Double.valueOf(getRestaurantUI().getText(btn_checkout).replace("$", ""));
    }

    public boolean isAddToCartTextDisplayed() {
        return getRestaurantUI().isDisplayed(txt_addToCart);
    }

    public Double getItemPriceReviewCart() {
        return Double.valueOf(getRestaurantUI().getText(lbl_itemPriceReviewCart).replace("$", ""));
    }

    public void clickPlusReviewCart() {
        getRestaurantUI().click(btn_increaseQtyReviewCart);
    }

    public void clickPlusReviewCartForOneStep() {
        getRestaurantUI().click( btn_increaseQtyByStepClick);
    }

    public void clickMinusReviewCart() {
        getRestaurantUI().click(btn_decreaseQtyReviewCart);
    }

    public String getItemQtyReviewCart() {
        return getRestaurantUI().getText(tbx_itemQuantityReviewCart, "value");
    }

    public Double getItemPriceReviewCartFirstRow() {
//        return Double.valueOf(getRestaurantUI().getText(lbl_itemPriceReviewCartFirstRow).replace("$", ""));
        getRestaurantUI().waitForVisibility(lbl_cartItemUnitPrice);
        String tagName = getRestaurantUI().getElement(lbl_cartItemUnitPrice).getTagName();
        String priceText;
        if (tagName.equals("input")) {
            priceText = getRestaurantUI().getText(lbl_cartItemUnitPrice, "value");
        } else {
            priceText = getRestaurantUI().getText(lbl_cartItemUnitPrice);
        }

        return Double.valueOf(priceText.replace("$", "").replace("/cs", "").replace("/pkg", "").trim());

    }

    public boolean isDuplicatePopupDisplayed() {
        return getRestaurantUI().isDisplayed(btn_duplicateOrderYes);
    }

    public void clickYesDuplicatePopup() throws InterruptedException {
        getRestaurantUI().waitForClickability(btn_duplicateOrderYes);
        getRestaurantUI().click(btn_duplicateOrderYes);
        getRestaurantUI().waitForInvisibility(btn_duplicateOrderYes);
    }

    public boolean isThankingForOrderPopupDisplayed() {
        try {
            getRestaurantUI().waitForClickability(lbl_thankYouForOrder);
            return getRestaurantUI().isDisplayed(lbl_thankYouForOrder);
        } catch (Exception e) {
            return false;
        }
    }
    public void clickCloseIcon(){
        getRestaurantUI().waitForVisibility(btn_close_);
        getRestaurantUI().click(btn_close_);
        getRestaurantUI().waitForInvisibility(btn_close_);
        getRestaurantUI().refreshPage();
    }

    public void clickCloseWithoutRefresh(){
        getRestaurantUI().waitForVisibility(btn_close_);
        getRestaurantUI().click(btn_close_);
    }

    public void submitOrder() throws InterruptedException {
        getRestaurantUI().waitForClickability(btn_submitOrder);
        getRestaurantUI().click(btn_submitOrder);
        clickYesDuplicatePopup();
    }

    public void submitOrderWithoutClickPopUpYes() throws InterruptedException {
        getRestaurantUI().waitForClickability(btn_submitOrder);
        getRestaurantUI().click(btn_submitOrder);
    }

    public void clickCompanyDropdown() {
        getRestaurantUI().waitForClickability(btn_companyDropdown);
        getRestaurantUI().click(btn_companyDropdown);
    }

    public boolean isCompanyDropdownTextDisplayed() {
        return getRestaurantUI().isDisplayed(txt_companyDropdownText);
    }

    public void clickOnPrint() {
        getRestaurantUI().waitForClickability(btn_print);
        getRestaurantUI().click(btn_print);
    }

    public void clickOnDownloadOrderGuide() {
        getRestaurantUI().waitForClickability(btn_downloadOrderGuide);
        getRestaurantUI().click(btn_downloadOrderGuide);
    }

    public boolean isPrintFriendlyPopupDisplayed() {
        return getRestaurantUI().isDisplayed(lbl_printFriendlyOrderGuide);
    }

    public void clickOnEdit() {
        getRestaurantUI().waitForClickability(btn_edit);
        getRestaurantUI().clickUsingJavaScript(btn_edit);
    }

    public boolean isEditOrderGuideTextDisplayed() {
        if(getRestaurantUI().isDisplayed(ratingOverlayIframe)){
            getRestaurantUI().switchToFrameByElement(ratingOverlayIframe);
            getRestaurantUI().click(ratingOverlayCloseBtn);
            try {
                getRestaurantUI().waitForCustom(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            getRestaurantUI().waitForVisibility(txt_editOrderGuide);
        } catch (Exception e) {
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_editOrderGuide);
    }

    public void clickOnMoreOptions() {
        getRestaurantUI().waitForClickability(btn_moreOptions);
        getRestaurantUI().click(btn_moreOptions);
    }

    public void clickOnExportOrderGuide() {
        getRestaurantUI().waitForClickability(btn_exportOrderGuide);
        getRestaurantUI().click(btn_exportOrderGuide);
    }

    public void clickOnImportOrderGuide() {
        getRestaurantUI().waitForClickability(btn_importOrderGuide);
        getRestaurantUI().click(btn_importOrderGuide);
    }

    public void clickOnUploadToOrder() {
        getRestaurantUI().waitForClickability(btn_uploadToOrder);
        getRestaurantUI().click(btn_uploadToOrder);
    }

    public void clickOnCreate() {
        getRestaurantUI().waitForClickability(btn_create);
        getRestaurantUI().click(btn_create);
    }

    public void typeOrderGuideName(String orderGuideName) {
        getRestaurantUI().sendKeys(tbx_OrderGuideName, orderGuideName);
    }

    public void clickSubmitOrderGuide() {
        getRestaurantUI().waitForClickability(btn_submitOrderGuide);
        getRestaurantUI().click(btn_submitOrderGuide);
    }

    public void clickOnAddFromCatalog() {
        getRestaurantUI().waitForClickability(btn_addFromCatalog);
        getRestaurantUI().click(btn_addFromCatalog);
    }

    public void clickOnAddTOOrderGuide() throws InterruptedException{
        getRestaurantUI().waitForVisibility(btn_addToOrderGuide);
        getRestaurantUI().waitForClickability(btn_addToOrderGuide);
        getRestaurantUI().clickUsingJavaScript(btn_addToOrderGuide);
        getRestaurantUI().waitForCustom(2000);
    }

    public void clickOnCloseEditor() throws InterruptedException {
        getRestaurantUI().click(btn_closeEditor);
        getRestaurantUI().refreshPage();
        try {
            getRestaurantUI().waitForCustom(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
public void clickOnCloseOrderGuideEditor(){
    getRestaurantUI().waitForClickability(btn_closeEditor);
    getRestaurantUI().clickUsingJavaScript(btn_closeEditor);
    getRestaurantUI().waitForVisibility(tbx_orderGuideSearch);
}

    public void clickOnRemoveFromOrderGuide() throws InterruptedException {
        getRestaurantUI().waitForVisibility(btn_removeFromOrderGuide);
        getRestaurantUI().click(btn_removeFromOrderGuide);
        getRestaurantUI().waitForCustom(4000);
    }

    public void clickDropDownCustomerOrder() {
        getRestaurantUI().click(btn_sortCustomOrder);
    }

    public void clickDropDownItemCategory() {
        getRestaurantUI().click(btn_sortItemCategory);
    }

    public void clickDropDownAlphabetical() {
        getRestaurantUI().click(btn_sortAlphabetical);
    }

    public void clickOnSortDropdown(){
        getRestaurantUI().click(itemSort);
    }

    public void selectDropDownCustomerOrder() throws InterruptedException {
        getRestaurantUI().click(btn_selectCustomOrder);
        getRestaurantUI().waitForCustom(4000);
    }

    public void selectDropDownItemCategory() throws InterruptedException {
        getRestaurantUI().click(btn_selectItemCategory);
        getRestaurantUI().waitForCustom(4000);
    }

    public void selectDropDownAlphabetical() throws InterruptedException {
        getRestaurantUI().click(btn_selectAlphabetical);
        getRestaurantUI().waitForCustom(4000);
    }

    public boolean isSeaFoodTextDisplayed() {
        try {
            getRestaurantUI().waitForVisibility(txt_seaFood);
        } catch (Exception e) {
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_seaFood);
    }

    public void clickOnUploadFile() {
        getRestaurantUI().waitForClickability(btn_uploadFile);
        getRestaurantUI().click(btn_uploadFile);
    }

    public void clickOnNext() {
        getRestaurantUI().waitForClickability(btn_next);
        getRestaurantUI().click(btn_next);
    }

    public void clickOnConfirm() {
        getRestaurantUI().waitForVisibility(btn_confirm);
        getRestaurantUI().waitForClickability(btn_confirm);
        getRestaurantUI().click(btn_confirm);
    }

    public boolean isOrderGuideSuccessfulTextDisplayed() {
        return getRestaurantUI().isDisplayed(txt_successfulOrderGuide);
    }

    public boolean isSubstitutionTextDisplayed() {
        return getRestaurantUI().isDisplayed(txt_substitutions);
    }

    public void fileUpload(String path) {
        getRestaurantUI().sendKeysHiddenElements(btn_browse, path);
    }

    public boolean isInvalidDeliveryTextDisplayed() {
        return getRestaurantUI().isDisplayed(txt_invalidDeliveryDate);
    }

    public void clickOnClose() throws InterruptedException{
        getRestaurantUI().waitForClickability(btn_close);
        getRestaurantUI().click(btn_close);

    }


    public void clickOnDeliveryDate() throws InterruptedException{
        getRestaurantUI().waitForClickability(btn_deliveryDate);
        getRestaurantUI().click(btn_deliveryDate);
    }

    public void selectDeliveryDateLine(String date) throws InterruptedException {
        By lbl_selectStartDate = By.xpath(dynamicToXPath.replace("DAY", date));
        getRestaurantUI().waitForVisibility(lbl_selectStartDate);
        getRestaurantUI().click(lbl_selectStartDate);
        getRestaurantUI().waitForCustom(5000);
    }
    
    public void selectDeliveryDateSecondLine()  throws InterruptedException {
        getRestaurantUI().waitForClickability(btn_selectDeliveryDateSecondLine);
        getRestaurantUI().click(btn_selectDeliveryDateSecondLine);
        getRestaurantUI().waitForCustom(4000);
    }
    public void clickOnOrderGuideSettings() {
        getRestaurantUI().waitForClickability(btn_orderGuideSettings);
        getRestaurantUI().click(btn_orderGuideSettings);
    }
    public void clickOnOrderApproval() throws InterruptedException {
        if(getRestaurantUI().isDisplayed(ratingOverlayIframe)){
            getRestaurantUI().switchToFrameByElement(ratingOverlayIframe);
            getRestaurantUI().click(ratingOverlayCloseBtn);
            try {
                getRestaurantUI().waitForCustom(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        getRestaurantUI().click(btn_orderApproval);
        getRestaurantUI().waitForCustom(4000);
    }

    public boolean isRatingOverlayDisplayed(){
        return getRestaurantUI().isDisplayed(ratingOverlayIframe,5);
    }

    public void clickCloseRatingOverlay(){
        getRestaurantUI().switchToFrameByElement(ratingOverlayIframe);
        getRestaurantUI().click(ratingOverlayCloseBtn);
        try {
            getRestaurantUI().waitForCustom(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickOnSave() {
        getRestaurantUI().click(btn_save);
    }

    public void clickOnPlaceOrder() {
        getRestaurantUI().isDisplayed(btn_placeOrder);
        getRestaurantUI().click(btn_placeOrder );
    }

    public void clickPlusQryFirstRowInWL() throws InterruptedException {
        getRestaurantUI().waitForCustom(1000);
        getRestaurantUI().click(btn_increaseQtyFirstRowInWL);
    }

    public boolean isMultiDistCentersDisplayed() {
        try {
            getRestaurantUI().waitForVisibility(txt_foodServiceDistCenter);
            getRestaurantUI().isDisplayed(txt_foodServiceDistCenter);
            getRestaurantUI().waitForVisibility(txt_retailDistCenter);
            getRestaurantUI().isDisplayed(txt_retailDistCenter);
        } catch (Exception e){
            return false;
        }
        return true;
    }
    public int getOrderCount(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (getRestaurantUI().isDisplayed(By.xpath(txt_orders.replace("NUM", String.valueOf(i))))){
                count += 1;
            };
        }
        return count;
    }
    public String getItemNameFirstRowWL() throws InterruptedException {
        getRestaurantUI().waitForElementEnabledState(lbl_itemNameListWL,true);
        getRestaurantUI().waitForCustom(3000);
        return getRestaurantUI().getText(lbl_itemNameListWL);
    }
    public void clickOnSearchCustomers(){
        getRestaurantUI().click(tbx_searchCustomers);
    }
    public void typeOnSearchCustomers(String code) throws InterruptedException {
        getRestaurantUI().clear(tbx_searchCustomers);
        getRestaurantUI().waitForCustom(3000);
        getRestaurantUI().sendKeys(tbx_searchCustomers, code);
        getRestaurantUI().waitForCustom(3000);
    }
    public void clickOnOrderGuide(String code) {
        getRestaurantUI().click(By.xpath(btnOrderGuide.replace("CODE", code)));
    }
    public void clickPlusQryFirstRowDis(){
        getRestaurantUI().click(btn_increaseQtyFirstRowDis);
    }

    public boolean isPickupTextDisplayed() {
        try {
            return getRestaurantUI().isDisplayed(btn_pickup);
        } catch (Exception e) {
            return false;
        }
    }
    public void clickOnPickUp() throws InterruptedException {
        getRestaurantUI().click(btn_pickup);
        getRestaurantUI().waitForCustom(4000);
    }
    public boolean isOrderCutOffDisplayed(String time) {
        try {
            return getRestaurantUI().isDisplayed(By.xpath(txt_orderCutOffForPickUp.replace("TIME",time)));
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSubmittingErrorDisplayed() {
        try {
            return getRestaurantUI().isDisplayed(txt_errorSubmittingOrder);
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnDeleteItemInCart(){
        getRestaurantUI().click(orderCartDeletebtn);
    }

    public Double isCartTotalBecomsZero(){
        return Double.valueOf(getRestaurantUI().getText(totalValue).replace("$", ""));
    }

    public void clickAddSectionFromMoreOptionsDropdown(){
        getRestaurantUI().click(selectedSections);
    }


    public void TypeSectionName(String sectionName){
        try {
            getRestaurantUI().waitForCustom(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getRestaurantUI().waitForVisibility(sectionInput);
        getRestaurantUI().sendKeys(sectionInput,sectionName);
    }


    public void clickOnSaveBtn(){
        getRestaurantUI().click(saveSectionBtn);
        try {
            getRestaurantUI().waitForCustom(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isSectionDisplayed(String sectionName){
        try {
            getRestaurantUI().waitForCustom(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return getRestaurantUI().isDisplayed(By.xpath(section.replace("SECTIONNAME",sectionName)));
    }

    public boolean isSectionNotDisplayed(String sectionName){
        try {
            getRestaurantUI().waitForCustom(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getRestaurantUI().waitForInvisibility(By.xpath(section.replace("SECTIONNAME",sectionName)));
        return getRestaurantUI().isDisplayed(By.xpath(section.replace("SECTIONNAME",sectionName)));
    }

    public void dragSectionToHigher(){
        getRestaurantUI().dragAndDrop(By.xpath("//div[contains(@class, '_11h2a11m') and @data-rbd-draggable-id='item-288275866']"),By.xpath("//div[@data-rbd-draggable-id='item-212365835']"));

    }

    public void clickOnBackBtn(){
        getRestaurantUI().click(backBtn);
    }

    public void clickOnEditSection(String name){
        getRestaurantUI().waitForVisibility(By.xpath(sectionEditBtn.replace("NAME", name)));
        getRestaurantUI().scrollToElementStable(By.xpath(sectionEditBtn.replace("NAME", name)));
        getRestaurantUI().click(By.xpath(sectionEditBtn.replace("NAME", name)));
    }

    public void clickOnDeleteBtn(){
        getRestaurantUI().scrollToElement(sectionDeleteBtn);
        getRestaurantUI().click(sectionDeleteBtn);
    }

    public void clickYesOnConfirmationOverlay() throws InterruptedException {
        getRestaurantUI().click(deleteConfirmationYesBtn);
        try {
            getRestaurantUI().waitForCustom(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getRestaurantUI().waitForCustom(4000);
    }

    public void clickPkgOption(){
        getRestaurantUI().isDisplayed(unitSelectionDropdown);
        getRestaurantUI().waitForClickability(unitSelectionDropdown);
        getRestaurantUI().click(unitSelectionDropdown);
        try {
            getRestaurantUI().waitForCustom(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getRestaurantUI().waitForVisibility(pkgOption);
        getRestaurantUI().click(pkgOption);
    }

    public String isUnitChangedToPkg(){
        getRestaurantUI().waitForVisibility(unitSelectionDropdown);
        return getRestaurantUI().getText(unitSelectionDropdown);
    }

    public void clickCaseOption(){
        getRestaurantUI().isDisplayed(unitSelectionDropdown);
        getRestaurantUI().waitForClickability(unitSelectionDropdown);
        getRestaurantUI().click(unitSelectionDropdown);
        getRestaurantUI().waitForVisibility(caseOption);
        getRestaurantUI().click(caseOption);
    }

    public String isUnitChangedToCase(){
        getRestaurantUI().waitForVisibility(unitSelectionDropdown);
        return getRestaurantUI().getText(unitSelectionDropdown);
    }

    public void clickEditItemBtn(String itemname) throws InterruptedException {
        getRestaurantUI().waitForCustom(3000);
        getRestaurantUI().waitForVisibility(By.xpath(editItemBtn.replace("ITEMNAME",itemname)));
        getRestaurantUI().click(By.xpath(editItemBtn.replace("ITEMNAME",itemname)));

    }

    public void clickOnHideBtn(){
        getRestaurantUI().click(hideBtn);
    }

    public boolean isHiddenItemDisplayed(String itemName){
        try {
            getRestaurantUI().waitForCustom(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return getRestaurantUI().isDisplayed(By.xpath(hiddenItem.replace("ITEMNAME",itemName)));
    }

    public void clickShowActiveAndHiddenItems(){
        getRestaurantUI().waitForVisibility(showFilter);
        getRestaurantUI().click(showFilter);
        getRestaurantUI().waitForVisibility(activeAndHiddenOption);
        getRestaurantUI().click(activeAndHiddenOption);
    }

    public void clickShowOnlyActiveItems(){
        getRestaurantUI().waitForVisibility(showFilter);
        getRestaurantUI().click(showFilter);
        getRestaurantUI().waitForVisibility(onlyActiveItemsOption);
        getRestaurantUI().click(onlyActiveItemsOption);

    }

    public void clickSaveAndUnhideBtn(){
        getRestaurantUI().click(saveAndUnhideBtn);
    }

    public boolean isCatalogPageImagesDisplayed(String img)throws InterruptedException{
        getRestaurantUI().waitForVisibility(By.xpath(catalogImage.replace("IMG",img)));
        return getRestaurantUI().isDisplayed(By.xpath(catalogImage.replace("IMG",img)));
    }

    public void clickItemOnCatalog(String itemName){
        getRestaurantUI().isDisplayed(By.xpath(Item.replace("ITEMNAME",itemName)));
        getRestaurantUI().click(By.xpath(Item.replace("ITEMNAME",itemName)));
    }

    public boolean isPDPViewItemNameDisplayed(String itemName){
        getRestaurantUI().waitForVisibility(By.xpath(itemNamePdpView.replace("ITEMNAME",itemName)));
        return getRestaurantUI().isDisplayed(By.xpath(itemNamePdpView.replace("ITEMNAME",itemName)));
    }

    public String getPDPViewItemName(String itemName){
        return getRestaurantUI().getText(By.xpath(itemNamePdpView.replace("ITEMNAME",itemName)));
    }

    public String getCatalogViewItemName(String itemName){
        return getRestaurantUI().getText(By.xpath(Item.replace("ITEMNAME",itemName)));
    }

    public String getPDPViewItemPrice(String itemName){
        return getRestaurantUI().getText(By.xpath(itemPricePdpView.replace("ITEMNAME",itemName)));
    }

    public String getCatalogViewItemPrice(String itemName){
        return getRestaurantUI().getText(By.xpath(ItemPriceCatalogView.replace("ITEMNAME",itemName)));
    }

    public String getDeliveryDateReviewCart(){
        return getRestaurantUI().getText(deliveryDate);
    }

    public void clickOnCustomer(String customerCode){
        getRestaurantUI().click(By.xpath(customerCodeOnGrid.replace("CUSTOMERCODE",customerCode)));
    }

    public String isCustomerCodeDisplayed(String customerCode){
        return getRestaurantUI().getText(By.xpath(customerCodeInProfilePage.replace("CUSTOMERCODE",customerCode)));
    }

    public void clickOnEditDeliveryDate(){
        getRestaurantUI().click(editDeliveryBtn);
    }

    public void clickOnpreviousDateDropdow(String Date){
        getRestaurantUI().click(By.xpath(cutOffDay.replace("DAY",Date)));
    }

    public void clickTodayONDropDown(String Date){
        getRestaurantUI().click(By.xpath(cutOffDaySelect.replace("DAY",Date)));
    }

    public void typeCutOffTime(String date , String time){
        getRestaurantUI().sendKeys(By.xpath(cutOffTime.replace("DAY",date)),time);
    }

    public void saveChangesBtn(){
        getRestaurantUI().click(cutOffDateTimeSave);
    }

    public String getCutOffTimeFromReviewCart(){
        return getRestaurantUI().getText(orderCutOffTime);
    }


    public void clickOnClearDeliveryDateBtn(String Date){
        getRestaurantUI().click(By.xpath(clearDeliveryDate.replace("DAY",Date)));
    }

    public void waitForCutOffTimeToBeOver(){
        try {
            getRestaurantUI().waitForCustom(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickItemFromCatalogIfNotAvailableInOG(String itemName){
        if(!getRestaurantUI().isDisplayed(By.xpath(itemNotFoundTxt.replace("ITEMCODE",itemName.toLowerCase())))){
            getRestaurantUI().click(By.xpath(catalogCardAddToOGBtn.replace("ITEMCODE",itemName)));
        }
        try {
            getRestaurantUI().waitForCustom(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public void clickAddNewItem(){
        getRestaurantUI().waitForVisibility(addNewItemBtn);
        getRestaurantUI().click(addNewItemBtn);
    }

    public boolean isAddItemsToOrderGuideDisplayed(){
        getRestaurantUI().waitForVisibility(addItemsToOrderGuideTxt);
        return getRestaurantUI().isDisplayed(addItemsToOrderGuideTxt);
    }

    public void setItemName(String ItemName){
        getRestaurantUI().sendKeys(itemNameTextField,ItemName);
    }

    public void setItemCode(String ItemCode){
        getRestaurantUI().sendKeys(itemCodeTextField,ItemCode);
    }

    public void setUnits(String unit){
        getRestaurantUI().click(By.xpath(unitBtn.replace("UNIT",unit)));
    }

    public void setPrice(String unit,String price){
        getRestaurantUI().sendKeys(By.xpath(unitPrice.replace("UNIT",unit)),price);
    }

    public void setAccountingCategory(String categoryName){
        getRestaurantUI().click(accountingCategoryDropdown);
        getRestaurantUI().click(By.xpath(accountingCategory.replace("ACCOUNTINGCATAGORY",categoryName)));
    }
    
    public void clickSaveItemBtn(){
        getRestaurantUI().click(saveItemBtn);
        try {
            getRestaurantUI().waitForCustom(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getRestaurantUI().refreshPage();
    }

    public boolean isAddItemDisplayed(String itemCode){
        return getRestaurantUI().isDisplayed(By.xpath(addedItem.replace("ITEMCODE",itemCode)));
    }

    public void clickEditOrder(){
        getRestaurantUI().click(editOrder);
        try {
            getRestaurantUI().waitForCustom(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String getItemCodeFirstRow() throws InterruptedException {
        getRestaurantUI().waitForVisibility(lbl_itemCodeList);
        getRestaurantUI().waitForCustom(3000);
        return getRestaurantUI().getText(lbl_itemCodeList);
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
        getRestaurantUI().waitForVisibility(txt_reviewOrder);
        return getRestaurantUI().isDisplayed(txt_reviewOrder);
    }
    public boolean isEditOrderTextDisplayed(){
        getRestaurantUI().waitForVisibility(editOrderPage);
        return getRestaurantUI().isDisplayed(editOrderPage);
    }
    public Double getItemPriceOnCheckoutButtonViaPDP() throws InterruptedException {
        getRestaurantUI().waitForVisibility(btn_checkOutPDP);
        getRestaurantUI().waitForCustom(8000);
        return Double.valueOf(getRestaurantUI().getText(btn_checkOutPDP).replace("$",""));
    }
    public void clickOnPlusIconInCatalogPDP(String name){
        getRestaurantUI().waitForVisibility(By.xpath(btn_catalogPDPPlusStable.replace("NAME", name)));
        getRestaurantUI().click(By.xpath(btn_catalogPDPPlusStable.replace("NAME", name)));
    }
    public void clickOnMinusIconInCatalogPDP(String name){
        getRestaurantUI().waitForVisibility(By.xpath(btn_catalogPDPMinusStable.replace("NAME", name)));
        getRestaurantUI().click(By.xpath(btn_catalogPDPMinusStable.replace("NAME", name)));
    }
    public String getFirstElementFrmCatalogSearchResults(String name){
        try {
            getRestaurantUI().waitForCustom(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getRestaurantUI().waitForVisibility(By.xpath(lbl_catalogSearchResultItemList.replace("NAME", name)));
        return getRestaurantUI().getText(By.xpath(lbl_catalogSearchResultItemList.replace("NAME", name))).toLowerCase();
    }
    public void clickOnProduct(String name){
        getRestaurantUI().waitForVisibility(By.xpath(txt_product.replace("NAME", name)));
        getRestaurantUI().clickUsingJavaScript(By.xpath(txt_product.replace("NAME", name)));
    }
    public void clickOnProductStablePDP(String name){
        getRestaurantUI().waitForVisibility(By.xpath(txt_productStableToPdp.replace("NAME", name)));
        getRestaurantUI().clickUsingJavaScript(By.xpath(txt_productStableToPdp.replace("NAME", name)));
    }
    public boolean isProductDetailsDisplayed(){
        return getRestaurantUI().isDisplayed(lbl_productDetails);
    }
    public void clickPlusSearchedSingleItem(){
        getRestaurantUI().click(btn_catalogPlus);
    }
    public void clickCheckOutPDP(){
        getRestaurantUI().click(btn_checkOutPDP);
    }

    public boolean isDeliveryOptionSelected() {
        try {
            getRestaurantUI().waitForVisibility(sel_delivery);
            String dataIconValue = getRestaurantUI().getText(sel_delivery, "data-icon").trim(); // Use getAttribute to fetch the attribute value
            return dataIconValue.equals("circle-check");
        } catch (Exception e) {
            return false;
        }
    }
    public String getOrderedId() {
        String orderId = getRestaurantUI().getText(txt_orderId);
        return orderId.substring(orderId.indexOf("#") + 1).trim();
    }
    public boolean isCustomersTextDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(txt_customers);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_customers);
    }
    public boolean isCustomerSearchResultByCodeDisplayed(String code) throws InterruptedException {
        getRestaurantUI().waitForElementEnabledState(By.xpath(btnCustomerOrderGuide.replace("CODE", code)), true);
        getRestaurantUI().waitForCustom(4000);
        return getRestaurantUI().isDisplayed(By.xpath(btnCustomerOrderGuide.replace("CODE", code)));
    }
    public String getBusinessName(String customerId){
        getRestaurantUI().waitForVisibility(By.xpath(businessName.replace("CUSTOMERID",customerId)));
        return getRestaurantUI().getText(By.xpath(businessName.replace("CUSTOMERID",customerId)));
    }
    public void ClickOnCustomer(String code){
        getRestaurantUI().click(By.xpath(SelectCustomerByCode.replace("CODE", code)));
    }
    public boolean isCustomerProfileDisplayed(String businessName){
        String result = businessName.substring(0, businessName.indexOf("Test"));
        System.out.println(result);
        try {
            getRestaurantUI().waitForCustom(3000);
            getRestaurantUI().waitForVisibility(By.xpath(txt_customerProfile.replace("BUSINESSNAME",result)));
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(By.xpath(txt_customerProfile.replace("BUSINESSNAME",result)));
    }
    public void clickOnOrdersTab() {
        getRestaurantUI().click(tb_orders);
    }
    public void clickOnSpecificRecord(String orderId) {
        getRestaurantUI().click(By.xpath(specificOrderRecord.replace("ORDER_ID", orderId)));
    }
    public boolean isOrderIdDisplayed(String orderId) throws InterruptedException {
        getRestaurantUI().waitForVisibility(By.xpath(orderTitle.replace("ORDER_ID", orderId)));
        getRestaurantUI().waitForCustom(4000);
        return getRestaurantUI().isDisplayed(By.xpath(orderTitle.replace("ORDER_ID", orderId)));
    }
    public void clickAddToCart(){
        getRestaurantUI().click(btn_addToCartPDP);
    }
    public void selectPickUpWillCall(){
        getRestaurantUI().waitForVisibility(lbl_pickUp);
        getRestaurantUI().click(lbl_pickUp);
    }
    public boolean isPickUpOptionSelected() {
        try {
            getRestaurantUI().waitForVisibility(sel_pickup);
            String dataIconValue = getRestaurantUI().getText(sel_pickup, "data-icon").trim(); // Use getAttribute to fetch the attribute value
            return dataIconValue.equals("circle-check");
        } catch (Exception e) {
            return false;
        }
    }
    public void selectMailDelivery(){
        getRestaurantUI().waitForVisibility(lbl_mailDelivery);
        getRestaurantUI().click(lbl_mailDelivery);
    }
    public boolean isMailDeliveryOptionSelected() {
        try {
            getRestaurantUI().waitForVisibility(sel_mailDelivery);
            String dataIconValue = getRestaurantUI().getText(sel_mailDelivery, "data-icon").trim(); // Use getAttribute to fetch the attribute value
            return dataIconValue.equals("circle-check");
        } catch (Exception e) {
            return false;
        }
    }
    public void clickOnMontanaPlaceOrder() {
        getRestaurantUI().waitForVisibility(btn_montanaPlaceOrder);
        getRestaurantUI().click(btn_montanaPlaceOrder);
    }
    public void clickDoNotSubstitute()throws InterruptedException{
        getRestaurantUI().waitForVisibility(btn_doNotSubstitute);
        getRestaurantUI().click(btn_doNotSubstitute);
    }
    public void clickViewOrderInDraft() {
        getRestaurantUI().waitForVisibility(btn_viewOrderInDraft);
        getRestaurantUI().click(btn_viewOrderInDraft);
    }
    public boolean isSentApprovalDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(txt_sentApproval);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_sentApproval);
    }
    public void clickOnPlusIconOrderGuideItem(){
        getRestaurantUI().click(btn_increaseQtyOrderGuide);
    }
    public boolean isUserNavigatedToChefGlendaCatalog() {
        return getRestaurantUI().isDisplayed(txt_glendaCatalog);
    }
    public void clickOnPlaceOrderSW() {
        getRestaurantUI().click(btn_placeOrderSW );
    }

    public String getItemNameFirstMultiOUM() throws InterruptedException {
//        getRestaurantUI().scrollToElementStable(lbl_firstMultiOUMItemName,3);
        getRestaurantUI().scrollToElementAccurate(lbl_firstMultiOUMItemName,2);
        getRestaurantUI().waitForElementEnabledState(lbl_firstMultiOUMItemName,true);
        getRestaurantUI().waitForCustom(3000);
        return getRestaurantUI().getText(lbl_firstMultiOUMItemName);
    }

    public String IsCustomOrderTextDisplayed() throws InterruptedException {
        getRestaurantUI().waitForVisibility(btn_sortCustomOrder);
        getRestaurantUI().waitForCustom(4000);
        String dropdownText = getRestaurantUI().getText(btn_sortCustomOrder);
        return dropdownText;

    }


    public String getItemCodeFirstMultiOUM() throws InterruptedException {
//        getRestaurantUI().scrollToElementStable(lbl_firstMultiOUMItemCode,3);
        getRestaurantUI().waitForVisibility(lbl_firstMultiOUMItemCode);
        getRestaurantUI().waitForCustom(3000);
        return getRestaurantUI().getText(lbl_firstMultiOUMItemCode);
    }

    private double extractPriceStable(By priceLocator) throws InterruptedException {
        getRestaurantUI().waitForVisibility(priceLocator);
        String tagName = getRestaurantUI().getElement(priceLocator).getTagName();
        String priceText;

        if (tagName.equals("input")) {
            priceText = getRestaurantUI().getText(priceLocator, "value");
        } else if (tagName.equals("div")) {
            priceText = getRestaurantUI().getText(priceLocator);
        } else {
            priceText = getRestaurantUI().getText(priceLocator);
        }

        System.out.println("Extracted Price: " + priceText);
        priceText = priceText.replace("$", "").replace(",", "").split("/")[0].trim();

        return Double.valueOf(priceText);
    }

    public double getActiveItemPriceFirstMultiOUMRowStable() throws InterruptedException {
        try {
            return extractPriceStable(lbl_itemPriceListMultiOUM);
        } catch (Exception e) {
            System.out.println("Fallback to alternative price locator due to: " + e.getMessage());
            return extractPriceStable(lbl_itemPriceListMultiOUM1);
        }
    }

    public String getItemCodeFirstMultiOUMLB() throws InterruptedException {
        int totalColumnCount = getRestaurantUI().countElements(lbl_orderGuideTableColumn);

        for (int i = 1; i <= totalColumnCount; i++) {
            String columnName = getRestaurantUI().getText(By.xpath(lbl_orderGuideTableColumnName.replace("COUNT", String.valueOf(i))));
            if ("price".equalsIgnoreCase(columnName)) {
                getRestaurantUI().waitForVisibility(By.xpath(lbl_firstMultiOUMItemCodeLB.replace("COUNT", String.valueOf(i))));
                getRestaurantUI().waitForCustom(3000);
                return getRestaurantUI().getText(By.xpath(lbl_firstMultiOUMItemCodeLB.replace("COUNT", String.valueOf(i))));
            }
        }
        return null;
    }

    public String getItemNameFirstMultiOUMLB() throws InterruptedException {
        int totalColumnCount = getRestaurantUI().countElements(lbl_orderGuideTableColumn);

        for (int i = 1; i <= totalColumnCount; i++) {
            String columnName = getRestaurantUI().getText(By.xpath(lbl_orderGuideTableColumnName.replace("COUNT", String.valueOf(i))));
            if ("price".equalsIgnoreCase(columnName)) {
                getRestaurantUI().scrollToElementStable(By.xpath(lbl_firstMultiOUMItemNameLB.replace("COUNT", String.valueOf(i))),3);
                getRestaurantUI().waitForVisibility(By.xpath(lbl_firstMultiOUMItemNameLB.replace("COUNT", String.valueOf(i))));
                getRestaurantUI().waitForCustom(3000);
                return getRestaurantUI().getText(By.xpath(lbl_firstMultiOUMItemNameLB.replace("COUNT", String.valueOf(i))));
            }
        }
        return null;
    }

    public String getItemUOMQuantity(String code,String uom){
        return getRestaurantUI().getText(By.xpath(tbx_itemQuantityUOM.replace("CODE", code).replace("UOM", uom)), "value");
    }

    public void ClickOnMultiUomDropDownOG(String code)throws InterruptedException{
        getRestaurantUI().waitForVisibility(By.xpath(multiUomDropDownOG.replace("CODE", code)));
        getRestaurantUI().click(By.xpath(multiUomDropDownOG.replace("CODE", code)));
        getRestaurantUI().click(multiUomOption);
        getRestaurantUI().waitForCustom(3000);
    }
    public void clickOGAddToCartPlusIcon(String code,String uom)throws InterruptedException{
        getRestaurantUI().waitForVisibility(By.xpath(btn_OGAddToCartPlusQuantity.replace("CODE", code).replace("UOM", uom)));
        getRestaurantUI().click(By.xpath(btn_OGAddToCartPlusQuantity.replace("CODE", code).replace("UOM", uom)));
        getRestaurantUI().waitForCustom(3000);
    }

    public void clickAddToCartMinusIcon(String code,String uom) throws InterruptedException {
        getRestaurantUI().waitForVisibility(By.xpath(btn_OGRemoveToCartMinusQuantity.replace("CODE", code).replace("UOM", uom)));
        getRestaurantUI().click(By.xpath(btn_OGRemoveToCartMinusQuantity.replace("CODE", code).replace("UOM", uom)));
        getRestaurantUI().waitForCustom(3000);
    }

    public double getActiveItemPriceMultiOUM(String position) throws InterruptedException {
        return extractPriceStable(By.xpath(lbl_itemPriceMultiOUM.replace("UOM", position)));
    }

    public Double getItemPriceOnMultiOUMCheckout() throws InterruptedException {
        getRestaurantUI().waitForVisibility(btn_orderCheckoutReview);
        getRestaurantUI().waitForCustom(4000);
        String priceText = getRestaurantUI().getText(btn_orderCheckoutReview).replace("$", "").replace(",", "");
        return Double.valueOf(priceText);
    }

    public Double getItemPriceReviewCartMultiUOM(String position) {
        getRestaurantUI().waitForVisibility(By.xpath(lbl_cartItemUnitPriceReviewMultiUOM.replace("UOM", position)));
        String tagName = getRestaurantUI().getElement(By.xpath(lbl_cartItemUnitPriceReviewMultiUOM.replace("UOM", position))).getTagName();
        String priceText;
        if (tagName.equals("input")) {
            priceText = getRestaurantUI().getText(By.xpath(lbl_cartItemUnitPriceReviewMultiUOM.replace("UOM", position)), "value");
        } else {
            priceText = getRestaurantUI().getText(By.xpath(lbl_cartItemUnitPriceReviewMultiUOM.replace("UOM", position)));
        }

        return Double.valueOf(priceText.replace("$", "").replace("/cs", "").replace("/pkg", "").trim());

    }
    public boolean isCombinedPopupDisplayed() {
        return getRestaurantUI().isDisplayed(combinedOrderPopUp);
    }
    public void clickContinueCombined(){
        getRestaurantUI().click(combinedOrderContinue);
    }
    public boolean isSetSubstitutionTextDisplayed()throws InterruptedException{
        getRestaurantUI().waitForVisibility(txtSetSubstitution);
        return getRestaurantUI().isDisplayed(txtSetSubstitution);
    }
    public void clickChooseSub(){
        getRestaurantUI().click(btn_chooseSub);
    }
    public void clickSelectSub(){
        getRestaurantUI().waitForVisibility(btn_selectSub);
        getRestaurantUI().clickUsingJavaScript(btn_selectSub);
    }
    public void clickCloseSub(){
        getRestaurantUI().click(btn_closeSub);
    }
    public void clickEditSub(){
        getRestaurantUI().click(btn_editSub);
    }
    public void clickRemovePreviousSub(){
        getRestaurantUI().click(btn_notSelectSub);
    }
    public void clickSaveSelection(){
        getRestaurantUI().waitForVisibility(btn_saveSelection);
        getRestaurantUI().click(btn_saveSelection);
    }
    public boolean isTopCategoryPicksDisplayed(){
        return getRestaurantUI().isDisplayed(lbl_topCategoryPicks);
    }
    public boolean isCompareSimilarItemsDisplayed(){
        return getRestaurantUI().isDisplayed(section_compareSimilar);
    }
    public boolean isRecommendedForYouItemNameDisplayed(String code){
        return getRestaurantUI().isDisplayed(By.xpath(lbl_recommendedForYouItem.replace("CODE",code )));
    }
    public boolean isRecommendedBySalesRepDisplayed(String code) {
        return getRestaurantUI().isDisplayed(By.xpath(lbl_recommendedBySalesRep.replace("CODE", '#'+code)));
    }
    public boolean isDontForgetToOrderDisplayed(){
        getRestaurantUI().scrollToElement(section_dontForget);
        return getRestaurantUI().isDisplayed(section_dontForget);
    }
    public boolean isMoreFromThisBrandDisplayed(){
        return getRestaurantUI().isDisplayed(section_moreFromThisBrand);
    }

    public String getItemNameFirstMultiOUMCoupa() throws InterruptedException {
      getRestaurantUI().uiScrollTop();
        getRestaurantUI().scrollToElementStpByStep(lbl_firstMultiOUMItemNameCoupa,3);
//        getRestaurantUI().waitForElementEnabledState(lbl_firstMultiOUMItemNameCoupa,true);
        getRestaurantUI().waitForCustom(3000);
        return getRestaurantUI().getText(lbl_firstMultiOUMItemNameCoupa);
    }


    public String getItemCodeFirstMultiOUMCoupa() throws InterruptedException {
//        getRestaurantUI().scrollToElementStable(lbl_firstMultiOUMItemCodeCoupa,3);
        getRestaurantUI().waitForVisibility(lbl_firstMultiOUMItemCodeCoupa);
        getRestaurantUI().waitForCustom(3000);
        return getRestaurantUI().getText(lbl_firstMultiOUMItemCodeCoupa);
    }

    public double getActiveItemPriceFirstMultiOUMRowStableCoupa() throws InterruptedException {
        try {
            return extractPriceStable(lbl_itemPriceListMultiOUMCoupa);
        } catch (Exception e) {
            System.out.println("Fallback to alternative price locator due to: " + e.getMessage());
            return extractPriceStable(lbl_itemPriceListMultiOUM1Coupa);
        }
    }

    private double extractPriceStableCoupa(By priceLocator) throws InterruptedException {
        getRestaurantUI().waitForVisibility(priceLocator);
        String tagName = getRestaurantUI().getElement(priceLocator).getTagName();
        String priceText;

        if (tagName.equals("input")) {
            priceText = getRestaurantUI().getText(priceLocator, "value");
        } else if (tagName.equals("div")) {
            priceText = getRestaurantUI().getText(priceLocator);
        } else {
            priceText = getRestaurantUI().getText(priceLocator);
        }

        System.out.println("Extracted Price: " + priceText);
        priceText = priceText.replace("$", "").replace(",", "").split("/")[0].trim();

        return Double.valueOf(priceText);
    }
    public void refreshCustomersPage(){
        getRestaurantUI().refreshPage();
    }
    public boolean isAddSubstitutionTextDisplayed()throws InterruptedException{
        getRestaurantUI().waitForVisibility(txtSubstitution);
        return getRestaurantUI().isDisplayed(txtSubstitution);
    }
    public void clickSubstitution()throws InterruptedException{
        getRestaurantUI().click(txtSubstitution);
    }
    public boolean isSetSubstitutionPopUpDisplayed()throws InterruptedException{
        getRestaurantUI().waitForVisibility(txtSetSubstitutionPopUp);
        return getRestaurantUI().isDisplayed(txtSetSubstitutionPopUp);
    }
    public boolean isOrderMinPopupDisplayed(){
        getRestaurantUI().waitForVisibility(txt_popupAlertOrderMin);
        return getRestaurantUI().isDisplayed(txt_popupAlertOrderMin);
    }
    public boolean isMinOrderBannerDisplayed(){
        getRestaurantUI().waitForVisibility(txt_minOrderBanner);
//        getRestaurantUI().waitForVisibility(txt_minOrderBanner);
        getRestaurantUI().refreshPage();
        return getRestaurantUI().isDisplayed(txt_minOrderBanner);
    }
    public void clickOK(){
        getRestaurantUI().waitForClickability(btn_OK);
        getRestaurantUI().click(btn_OK);
    }
    public void clickOnYes(){
        getRestaurantUI().waitForVisibility(btn_yes);
        getRestaurantUI().click(btn_yes);
    }
    public void clickOnCancel(){
        getRestaurantUI().waitForVisibility(btn_cancel);
        getRestaurantUI().click(btn_cancel);
    }
    public void clickonInvoice(){
        getRestaurantUI().click(btn_invoice);
    }
    public boolean isFirstRecordDisplayed(){
        return getRestaurantUI().isDisplayed(cb_inInvoiceTable);
    }
    public void clickEditSubstitutionsAccess(){
        getRestaurantUI().waitForVisibility(substitutionsAccessEditBtn);
        getRestaurantUI().scrollToElementCenter(substitutionsAccessEditBtn);
        getRestaurantUI().clickWithFallback(substitutionsAccessEditBtn);
    }
    public void editSubstitutionStatus(String status){
        getRestaurantUI().click(substitutionDropDown);
        getRestaurantUI().waitForVisibility(By.xpath(substitutionOption.replace("STATUS", status)));
        getRestaurantUI().click(By.xpath(substitutionOption.replace("STATUS", status)));
    }
    public void saveCatalogAccessChanges(){
        getRestaurantUI().clickWithScrollAndHover(Savebtn);
        try {
            getRestaurantUI().waitForCustom(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public double getCatalogItemPrice(String name) throws InterruptedException {
        try {
            return extractPrice(By.xpath(ItemPriceCatalogView.replace("ITEMNAME", name)));
        } catch (Exception e) {
            System.out.println("Fallback to alternative price locator due to: " + e.getMessage());
            return extractPrice(By.xpath(ItemPriceCatalogView.replace("ITEMNAME", name)));
        }
    }
    public boolean isRecentOrderDisplayed(String id)throws InterruptedException{
        getRestaurantUI().scrollToElement(By.xpath(recentOrder.replace("ID",id)));
        return getRestaurantUI().isDisplayed(By.xpath(recentOrder.replace("ID",id)));
    }
    public void isPreviousDraftOrderYesDisplayed() throws InterruptedException {
         getRestaurantUI().click(btn_previousDraftOrderYes);
    }
    public void clickOnRemoveFromOrderGuideStable(String name) throws InterruptedException {
        getRestaurantUI().waitForVisibility(By.xpath(removeItemOnOG.replace("NAME",name)));
        getRestaurantUI().click(By.xpath(removeItemOnOG.replace("NAME",name)));
        getRestaurantUI().waitForCustom(4000);
    }
    public void typeToSearchOnHome(String item) throws InterruptedException {
        getRestaurantUI().waitForCustom(3000);
        getRestaurantUI().clearUsingJavaScript(tbx_homeSearch);
        getRestaurantUI().click(tbx_homeSearch);
        getRestaurantUI().waitForCustom(2000);
        getRestaurantUI().sendKeys(tbx_homeSearch, item);
        getRestaurantUI().waitForCustom(4000);
    }
    public void clickSearchHome()throws InterruptedException{
        getRestaurantUI().click(btn_homeSearch);
    }
    public boolean isEditItemPopupDisplayed(){
        getRestaurantUI().waitForVisibility(txt_editItem);
        return getRestaurantUI().isDisplayed(txt_editItem);
    }
    public void clickOnCaseUnit()throws InterruptedException{
        getRestaurantUI().waitForClickability(caseUnit);
        getRestaurantUI().clickUsingJavaScript(caseUnit);
    }
    public boolean isMultiUomDropDownDisplayed(String code)throws InterruptedException{
        getRestaurantUI().waitForVisibility(By.xpath(multiUomDropDownIndicator.replace("CODE", code)));
        return getRestaurantUI().isDisplayed(By.xpath(multiUomDropDownIndicator.replace("CODE", code)));
    }
    public void clickSaveOnUOMEditor(){
        getRestaurantUI().waitForClickability(saveItemBtn);
        getRestaurantUI().clickUsingJavaScript(saveItemBtn);
        try {
            getRestaurantUI().waitForCustom(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isRecentOrderTextDisplayed()throws InterruptedException{
        getRestaurantUI().scrollToElement(txt_recentOrder);
        return getRestaurantUI().isDisplayed(txt_recentOrder);
    }
    public boolean isDoNotSubstituteTextDisplay()throws InterruptedException{
        return getRestaurantUI().isDisplayed(txt_doNotSubstitute);
    }
    public void clickClosePopUp(){
        getRestaurantUI().waitForVisibility(btn_close_);
        getRestaurantUI().click(btn_close_);
    }
    public boolean isLastColumnDisplay(String column)throws InterruptedException{
        return getRestaurantUI().isDisplayed(By.xpath(lastColumn.replace("COLUMN",column)));
    }
    public void clickOnCustomerCode(String code) {
        getRestaurantUI().click(By.xpath(txt_customerCode.replace("CODE", code)));
    }
    public void clickOnEditAccHolds(){
        try {
            getRestaurantUI().waitForCustom(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getRestaurantUI().waitForVisibility(btn_editAccHold);
        getRestaurantUI().click(btn_editAccHold);
    }
    public void clickOnAccDropdown(){
        getRestaurantUI().waitForVisibility(dropdown_acc);
        getRestaurantUI().click(dropdown_acc);
    }
    public void clickOnHardHold(){
        getRestaurantUI().waitForVisibility(txt_hardHold);
        getRestaurantUI().click(txt_hardHold);
    }
    public void clickOnSaveDP(){
        getRestaurantUI().waitForVisibility(btn_save_DP);
        getRestaurantUI().clickWithFallback(btn_save_DP);
        try {
            getRestaurantUI().waitForCustom(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isHardHoldSelected(){
        return getRestaurantUI().isDisplayed(lbl_hardHold);
    }
    public boolean isAccountHoldPopUpDisplay()throws InterruptedException{
        return getRestaurantUI().isDisplayed(accountOnHold);
    }
    public boolean isAccountHoldMessageDisplay(String message)throws InterruptedException{
        return getRestaurantUI().isDisplayed(By.xpath(accountHoldMessage.replace("MESSAGE",message)));
    }
    public void increaseFirstRowQtySpecificCustomer() throws InterruptedException {
        getRestaurantUI().click(btn_increaseQtyFirstRow);
    }
    public boolean isDeliveryDateOrderHistoryDisplayed(String id , String date){
        return getRestaurantUI().isDisplayed(By.xpath(deliveryDateOrderHistory.replace("ID", id).replace("DATE",date)));
    }
    public void clickOnPickUpDateStable() throws InterruptedException{
        getRestaurantUI().waitForCustom(4000);
        getRestaurantUI().click(btn_pickUpDateStable);
    }
    public boolean isFulfilmentTypeOrderHistoryDisplayed(String id , String type){
        return getRestaurantUI().isDisplayed(By.xpath(fulfillmentTypeOrderHistory.replace("ID", id).replace("TYPE",type)));
    }
    public void selectDeliveryDateLineStable(String day, boolean isNextMonth) throws InterruptedException {
        if (isNextMonth) {
            getRestaurantUI().click(btn_nextMonth);
            getRestaurantUI().waitForCustom(1000); // wait after clicking next month
        }

        By lbl_selectStartDate = By.xpath(dynamicToXPathStable.replace("DAY", day));
        getRestaurantUI().waitForVisibility(lbl_selectStartDate);
        getRestaurantUI().click(lbl_selectStartDate);
        getRestaurantUI().waitForCustom(5000);
    }
    public boolean isReviewOrderFulfilmentTypeDisplayed(String type){
        return getRestaurantUI().isDisplayed(By.xpath(reviewOrderFulfilment.replace("TYPE",type)));
    }
    public boolean isEditOrderGuideOptionDisplay()throws InterruptedException{
        return getRestaurantUI().isDisplayed(btn_edit);
    }
    public boolean isAddFromCatalogHeartItemDisplay(){
        return getRestaurantUI().isDisplayed(btn_addToOrderGuide);
    }
    public void clickOnDeleteOrderGuide(){
        getRestaurantUI().waitForClickability(btn_deleteOrderGuide);
        getRestaurantUI().click(btn_deleteOrderGuide);
    }
    public boolean isPurchaseHistoryDisplay(){
        return getRestaurantUI().isDisplayed(txt_purchaseHistoryCatalog);
    }
    public boolean isLastOrderDisplay(String order){
        return getRestaurantUI().isDisplayed(By.xpath(lastOrderDetails.replace("ORDER",order)));
    }
    public void clickLastOrderDetailsCatalog(String name)throws InterruptedException{
        getRestaurantUI().click(By.xpath(lbl_lastOrderDetails.replace("NAME",name)));
    }
    public void clickLastOrderOG(String code)throws InterruptedException{
        getRestaurantUI().click(By.xpath(purchaseHistoryOG.replace("CODE",code)));
    }
    public boolean isSpecialOrderNoteDisplay(String note)throws InterruptedException{
        return getRestaurantUI().isDisplayed(By.xpath(txt_specialOrderNote.replace("NOTE",note)));
    }
    public void clickOGDropdown(){
        getRestaurantUI().waitForVisibility(lbl_orderGuide);
        getRestaurantUI().click(lbl_orderGuide);
    }
    public void selectOrderGuide(String name){
        getRestaurantUI().waitForVisibility(By.xpath(dropDownOrderGuide.replace("NAME",name)));
        getRestaurantUI().click(By.xpath(dropDownOrderGuide.replace("NAME",name)));
    }
    public void clickCatalogListView(){
        getRestaurantUI().click(btn_listView);
    }
    public boolean isAddToOrderGuideListViewDisplay(){
        return getRestaurantUI().isDisplayed(btn_addToOrderGuideListView);
    }
    public void clickLocationGuide(){
        getRestaurantUI().click(lbl_locationGuide);
    }
    public boolean IsLocationOrderGuideDisplay(String name){
       return getRestaurantUI().isDisplayed(By.xpath(dropDownLocationOrderGuide.replace("NAME",name)));
    }
    public void clickEditCatalogAccess(){
        getRestaurantUI().click(catalogAccessEditBtn);
    }
    public void clickOnDisableCatalogAccessOption(){
        getRestaurantUI().click(catalogAccessEnableOption);
        getRestaurantUI().waitForVisibility(catalogAccessDisableOption);
        getRestaurantUI().click(catalogAccessDisableOption);
    }

    public void clickOnEnableCatalogAccessOption(){
        getRestaurantUI().click(catalogAccessDisableOption);
        getRestaurantUI().waitForVisibility(catalogAccessEnableOption);
        getRestaurantUI().click(catalogAccessEnableOption);
    }
    public boolean isCatalogAccessEnableDisplayed(){
        return getRestaurantUI().isDisplayed(lbl_catalogAccessEnable,10);
    }
    public boolean isCatalogAccessDisabled(){
        getRestaurantUI().refreshPage();
        return getRestaurantUI().isDisplayed(catalogAccessDisableTxt);
    }
    public boolean isCatalogButtonDisplay() {
        return getRestaurantUI().isDisplayed(btn_catalog);
    }
    public void typePONumber(String poNumber) throws InterruptedException {
        getRestaurantUI().waitForVisibility(txt_poNumber);
        getRestaurantUI().clear(txt_poNumber);
        getRestaurantUI().sendKeys(txt_poNumber,poNumber);
    }
    public boolean isPONumberErrorDisplay(String error){
        return getRestaurantUI().isDisplayed(By.xpath(pONumberError.replace("ERROR", error)));
    }
    public boolean isCatalogFilterDisplayed(String filter){
        return getRestaurantUI().isDisplayed(By.xpath(catalogFilter.replace("FILTER", filter)));
    }
    public void clickCatalogFilter(String filter)throws InterruptedException{
        getRestaurantUI().click(By.xpath(catalogFilter.replace("FILTER", filter)));
    }
    public boolean isCatalogFilterTagDisplayed(String tag){
        return getRestaurantUI().isDisplayed(By.xpath(catalogFilterTag.replace("TAG", tag)));
    }
    public boolean isEditOrderGuideTextCatalogDisplayed() {
        return getRestaurantUI().isDisplayed(txt_editOrderGuideCatalog);
    }
    public boolean isCatalogNewArrivalFilterTagDisplayed(String tag){
        return getRestaurantUI().isDisplayed(By.xpath(catalogFilterTagNewArrival.replace("TAG", tag)));
    }
    public boolean isCatalogFilterDisplayTag(String name,String tag){
        return getRestaurantUI().isDisplayed(By.xpath(newItemTagCatalog.replace("NAME", name).replace("TAG",tag)));
    }
    public boolean isOrderGuideItemTagDisplayTag(String name,String tag){
        return getRestaurantUI().isDisplayed(By.xpath(itemTagOG.replace("NAME", name).replace("TAG",tag)));
    }
    public boolean isPDPItemDisplayTag(String name,String tag){
        return getRestaurantUI().isDisplayed(By.xpath(newItemTagPDP.replace("NAME", name).replace("TAG",tag)));
    }
    public boolean isCatalogSearchItemCodeDisplay(String code){
        return getRestaurantUI().isDisplayed(By.xpath(catalogSearchItemCode.replace("CODE", code)));
    }
    public void clickCartSummery()throws InterruptedException{
        getRestaurantUI().click(btn_cartSummery);
    }
    public boolean isCartSummaryDisplay(String count){
        return getRestaurantUI().isDisplayed(By.xpath(cartSummary.replace("COUNT", count)));
    }
    public boolean isCartSummaryValueDisplay(String name){
        return getRestaurantUI().isDisplayed(By.xpath(cartSummaryValue.replace("NAME", name)));
    }
    public void clickMenu()throws InterruptedException{
        getRestaurantUI().click(btn_menu);
    }
    public boolean isUserNameDisplay(String name){
        return getRestaurantUI().isDisplayed(By.xpath(txt_userName.replace("NAME", name)));
    }
    public boolean isDistributorNameDisplay(String name){
        return getRestaurantUI().isDisplayed(By.xpath(txt_distributorName.replace("NAME", name)));
    }
    public void clickCloseMenu()throws InterruptedException{
        getRestaurantUI().click(btn_closeMenu);
    }
    public void clickOnPlusIconInCatalogStable(String name){
        getRestaurantUI().waitForVisibility(By.xpath(btn_catalogPlusStable.replace("NAME", name)));
        getRestaurantUI().click(By.xpath(btn_catalogPlusStable.replace("NAME", name)));
    }
    public void clickSendToERP()throws InterruptedException{
        getRestaurantUI().click(btn_sendERP);
    }
    public boolean isSendToERPButtonDisplayed()throws InterruptedException{
        return getRestaurantUI().isDisplayed(btn_sendERP);
    }
    public boolean isNotesToCustomerDisplayed(String note){
        return getRestaurantUI().isDisplayed(By.xpath(txt_notesToCustomer.replace("NOTE",note)));
    }
    public boolean isSubmitERPPopUpDisplayed()throws InterruptedException{
        return getRestaurantUI().isDisplayed(txt_submitERP);
    }
    public boolean isOrderSentERPPopUpDisplayed()throws InterruptedException{
        return getRestaurantUI().isDisplayed(txt_OrderSentERP);
    }
    public boolean isOrderSubmissionStepDisplayed(String step){
        return getRestaurantUI().isDisplayed(By.xpath(txt_OrderSubmissionStep.replace("STEP",step)));
    }
    public void clickOnTimeline() {
        getRestaurantUI().clickUsingJavaScript(btn_timeline);
    }
    public void clickConfirm(){
        getRestaurantUI().waitForClickability(btn_confirm);
        getRestaurantUI().click(btn_confirm);
    }
    public void clickSubmittedOrder(String id){
        getRestaurantUI().click(By.xpath(submittedOrder.replace("ID", id)));
    }
    public void clickSimpleListView(){
        getRestaurantUI().waitForClickability(dropdown_option_SimpleListView);
        getRestaurantUI().click(dropdown_option_SimpleListView);
    }
    public boolean isSimpleListViewTextDisplay()throws InterruptedException{
        return getRestaurantUI().isDisplayed(txt_simpleListView);
    }
    public void clickSortOptionOG(String option)throws InterruptedException{
        getRestaurantUI().click(By.xpath(sortOptionOG.replace("OPTION",option)));
    }
    public boolean isSortOptionDisplay(String option)throws InterruptedException{
        getRestaurantUI().waitForVisibility(By.xpath(sortResult.replace("OPTION",option)));
        return getRestaurantUI().isDisplayed(By.xpath(sortResult.replace("OPTION",option)));
    }
    public void selectSortOptions(){
        getRestaurantUI().waitForVisibility(dropdown_SortOptions);
        getRestaurantUI().click(dropdown_SortOptions);
    }
    public void clickOnProductStable(String name){
        getRestaurantUI().scrollToElementStable(By.xpath(txt_productStable.replace("NAME", name)));
        getRestaurantUI().waitForVisibility(By.xpath(txt_productStable.replace("NAME", name)));
        getRestaurantUI().clickUsingJavaScript(By.xpath(txt_productStable.replace("NAME", name)));
    }
    public void clickOnPlusIconCatalogStable(String name){
        getRestaurantUI().scrollToElement(By.xpath(txt_productStableAddToCart.replace("NAME", name)));
        getRestaurantUI().waitForVisibility(By.xpath(txt_productStableAddToCart.replace("NAME", name)));
        getRestaurantUI().click(By.xpath(txt_productStableAddToCart.replace("NAME", name)));
    }
    public void clickOnUploadOrder() {
        getRestaurantUI().waitForClickability(btn_uploadOrder);
        getRestaurantUI().click(btn_uploadOrder);
    }
    public boolean isUploadToOrderTextDisplay()throws InterruptedException{
        return getRestaurantUI().isDisplayed(txt_uploadToOrder);
    }
    public String getItemQuantity(String code){
        return getRestaurantUI().getText(By.xpath(tbx_itemQuantity.replace("CODE", code)), "value");
    }
    public void clickRecentSubmitOrder(String id)throws InterruptedException{
        getRestaurantUI().scrollToElementStable(By.xpath(btn_editRecentOrder.replace("ORDERID",id)));
        getRestaurantUI().clickUsingJavaScript(By.xpath(btn_editRecentOrder.replace("ORDERID",id)));
    }
    public boolean isRecentSubmitOrderDisplay(String id)throws InterruptedException{
        return getRestaurantUI().isDisplayed(By.xpath(btn_editRecentOrder.replace("ORDERID",id)));
    }
    public boolean isRecentSubmitOrderQuantityDisplay(String id,String quantity)throws InterruptedException{
        return getRestaurantUI().isDisplayed(By.xpath(btn_editRecentOrderQuantity.replace("ORDERID",id).replace("QUANTITY",quantity)));
    }
    public double getRecentItemPrice(String id) throws InterruptedException {
        try {
            return extractPrice(By.xpath(btn_editRecentOrderPrice.replace("ORDERID",id)));
        } catch (Exception e) {
            System.out.println("Fallback to alternative price locator due to: " + e.getMessage());
            return extractPrice(By.xpath(btn_editRecentOrderPrice.replace("ORDERID",id)));
        }
    }
    public void clickQuickAdd()throws InterruptedException{
        getRestaurantUI().click(dropdown_option_QuickAdd);
    }
    public boolean isQuickAddViewDisplay()throws InterruptedException{
        return getRestaurantUI().isDisplayed(txt_QuickAddView);
    }
    public boolean isQuickAddOptionDisplay()throws InterruptedException{
        return getRestaurantUI().isDisplayed(dropdown_option_QuickAdd);
    }
    public void enterItemCodeQuickAdd(String code)throws InterruptedException{
        getRestaurantUI().click(lbl_itemCode);
        getRestaurantUI().sendKeys(lbl_itemCode,code);
    }
    public void enterItemQuantity(String code)throws InterruptedException{
        getRestaurantUI().click(lbl_itemQuantity);
        getRestaurantUI().sendKeys(lbl_itemQuantity,code);
    }

    public void enterItemQuantityWithClear(String code) throws InterruptedException {
        getRestaurantUI().click(lbl_itemQuantity);
        getRestaurantUI().sendKeys(lbl_itemQuantity, Keys.chord(Keys.CONTROL, "a"));
        getRestaurantUI().sendKeys(lbl_itemQuantity, Keys.DELETE.toString());
        getRestaurantUI().sendKeys(lbl_itemQuantity, code);
    }


    public void clickVerifyItem()throws InterruptedException{
        getRestaurantUI().click(btn_verifyItem);
    }
    public void clickSaveAndReview()throws InterruptedException{
        getRestaurantUI().waitForCustom(5000);
        getRestaurantUI().click(btn_saveAndReview);
    }
    public boolean isPreviousDraftOrderNoDisplayedSub() throws InterruptedException {
        return getRestaurantUI().isDisplayed(btn_previousDraftOrderNo,5);
    }
    public String getItemQuantityReviewPage(String code){
        getRestaurantUI().waitForVisibility(By.xpath(quantityReviewPage.replace("CODE",code)));
        return getRestaurantUI().getText(By.xpath(quantityReviewPage.replace("CODE",code)), "value");
    }
    public void clickOrderGuideView(){
        getRestaurantUI().waitForClickability(dropdown_option_OrderGuideView);
        getRestaurantUI().click(dropdown_option_OrderGuideView);
    }
    public String getItemQuantitySimpleListView(String code){
        getRestaurantUI().waitForVisibility(By.xpath(quantitySimpleListView.replace("CODE",code)));
        return getRestaurantUI().getText(By.xpath(quantitySimpleListView.replace("CODE",code)), "value");
    }
    public void clearSearchField()throws InterruptedException{
        getRestaurantUI().click(icon_deleteSearchItem);
        getRestaurantUI().waitForCustom(3000);
    }
    public boolean isItemVerifiedPopUpDisplay()throws InterruptedException{
        getRestaurantUI().waitForCustom(5000);
        return getRestaurantUI().isDisplayed(txt_itemVerified);
    }
    public void clickPlusQryFirstRowStable(){
        getRestaurantUI().click(btn_increaseQtyFirstRowStable);
    }
    public boolean isManageStandingOrdersDisplay()throws InterruptedException{
        return getRestaurantUI().isDisplayed(dropdown_option_ManageStandingOrders);
    }
    public void clickManageStandingOrders()throws InterruptedException{
        getRestaurantUI().click(dropdown_option_ManageStandingOrders);
        getRestaurantUI().waitForCustom(4000);
    }
    public boolean isManageStandingOrdersPopUpDisplay()throws InterruptedException{
        return getRestaurantUI().isDisplayed(txt_ManageStandingOrders);
    }
    public boolean isCreateStandingOrdersButtonDisplay()throws InterruptedException{
        return getRestaurantUI().isDisplayed(btn_CreateStandingOrders);
    }
    public void clickCreateStandingOrders()throws InterruptedException{
        getRestaurantUI().click(btn_CreateStandingOrders);
        getRestaurantUI().waitForCustom(4000);
    }
    public void clickOnRemoveDelivery() {
        if (getRestaurantUI().isDisplayed(btn_removeDelivery)){
            getRestaurantUI().click(btn_removeDelivery);
        }
    }
    public void clickOnDropdownDelivery() {
        getRestaurantUI().click(dropdown_delivery);
    }
    public void clickOnDeliveryDateStanding(String day) {
        getRestaurantUI().waitForVisibility(By.xpath(txt_deliveryDay.replace("DAY", day)));
        getRestaurantUI().click(By.xpath(txt_deliveryDay.replace("DAY", day)));
        getRestaurantUI().waitForElementEnabledState(By.xpath(txt_deliveryDay.replace("DAY", day)),true);
    }
    public void clickOnDeliveryDateAsLastBefore() {
        getRestaurantUI().waitForVisibility(By.xpath(txt_deliveryLastBeforeDay));
        getRestaurantUI().click(By.xpath(txt_deliveryLastBeforeDay));
        getRestaurantUI().waitForElementEnabledState(By.xpath(txt_deliveryLastBeforeDay),true);
    }
    public void setStandingOrder(){
        getRestaurantUI().waitForElementEnabledState(btn_setStandingOrder,true);
        getRestaurantUI().waitForClickability(btn_setStandingOrder);
        try {
            getRestaurantUI().waitForCustom(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getRestaurantUI().click(btn_setStandingOrder);
    }
    public void resetStandingOrder(){
        getRestaurantUI().waitForElementEnabledState(btn_resetStandingOrder,true);
        getRestaurantUI().waitForClickability(btn_resetStandingOrder);
        getRestaurantUI().click(btn_resetStandingOrder);
    }
    public boolean isStandingOrderSuccessPopupDisplayed(){
        getRestaurantUI().waitForVisibility(txt_success);
        return getRestaurantUI().isDisplayed(txt_success);
    }
    public boolean isReviewStandingOrdersDisplayed(){
        getRestaurantUI().waitForVisibility(txt_reviewStandingOrders);
        return getRestaurantUI().isDisplayed(txt_reviewStandingOrders);
    }
    public void clickOnStandingOrderEditIcon() throws InterruptedException {
        getRestaurantUI().waitForVisibility(btn_editStandingOrderIcon);
        getRestaurantUI().clickWithFallback(btn_editStandingOrderIcon);
        getRestaurantUI().waitForCustom(3000);
    }
    public void clickOnStandingOrderDeleteIcon() throws InterruptedException {
        getRestaurantUI().waitForVisibility(btn_deleteStandingOrderIcon);
        getRestaurantUI().clickWithFallback(btn_deleteStandingOrderIcon);
        getRestaurantUI().waitForVisibility(txt_deletePopup);
        getRestaurantUI().waitForClickability(btn_yes);
        getRestaurantUI().click(btn_yes);
        getRestaurantUI().waitForCustom(2000);

    }
    public boolean isStandingOrdersDeletedIconDisplay(){
        return getRestaurantUI().isDisplayed(btn_deleteStandingOrderIcon);
    }
    public boolean isSubmittedStandingOrderDisplayed(String quantity ,String price) {
        try {
            getRestaurantUI().waitForVisibility(By.xpath(standingOrder.replace("QUANTITY", quantity).replace("PRICE", price)));
        } catch (Exception e) {
            return false;
        }
        return getRestaurantUI().isDisplayed(By.xpath(standingOrder.replace("QUANTITY", quantity).replace("PRICE", price)));
    }
    public void clickOnStandingOrderPauseIcon() throws InterruptedException {
        getRestaurantUI().waitForVisibility(btn_pauseStandingOrderIcon);
        getRestaurantUI().clickWithFallback(btn_pauseStandingOrderIcon);
        getRestaurantUI().waitForCustom(3000);
    }
    public boolean isStandingOrdersPaused(){
        return getRestaurantUI().isDisplayed(txt_pausedStandingOrders);
    }
    public void clickOnStandingOrderResumeIcon() throws InterruptedException {
        getRestaurantUI().waitForVisibility(btn_resumeStandingOrderIcon);
        getRestaurantUI().clickWithFallback(btn_resumeStandingOrderIcon);
        getRestaurantUI().waitForCustom(3000);
    }
    public void clickAddToRecentSubmitOrder(String id)throws InterruptedException{
        getRestaurantUI().scrollToElementStable(By.xpath(btn_addToRecentOrder.replace("ORDERID",id)));
        getRestaurantUI().clickUsingJavaScript(By.xpath(btn_addToRecentOrder.replace("ORDERID",id)));
    }
    public void increaseReviewQtyStable(String code){
        getRestaurantUI().click(By.xpath(increaseQuantityReviewPage.replace("CODE",code)));
    }
    public void decreaseReviewQtyStable(String code){
        getRestaurantUI().click(By.xpath(decreaseQuantityReviewPage.replace("CODE",code)));
    }
    public boolean isTrashCanReviewPage(String code){
        return getRestaurantUI().isDisplayed(By.xpath(trashCanReviewPage.replace("CODE",code)));
    }
    public boolean isRecentAddedOrderDisplay(String id)throws InterruptedException{
        return getRestaurantUI().isDisplayed(By.xpath(btn_addRecentOrder.replace("ORDERID",id)));
    }
    public void editCalculateOrderQty(){
        getRestaurantUI().click(btn_calculateOrderQty);
    }
    public boolean isCalculateOrderQtyDisplayed(){
        return getRestaurantUI().isDisplayed(lbl_calculateOrderQty);
    }
    public void enterParValue(String num) throws InterruptedException {
        getRestaurantUI().clearUsingJavaScript(lbl_parValue);
        getRestaurantUI().sendKeys(lbl_parValue, num);
        getRestaurantUI().waitForCustom(1000);
    }
    public void enterOnSiteInvValue(String num) throws InterruptedException {
        getRestaurantUI().clearUsingJavaScript(lbl_OnSiteInvValue);
        getRestaurantUI().sendKeys(lbl_OnSiteInvValue, num);
        getRestaurantUI().waitForCustom(1000);
    }
    public double getItemPriceTotal() throws InterruptedException {
        try {
            return extractPriceStable(lbl_ItemTotal);
        } catch (Exception e) {
            System.out.println("Fallback to alternative price locator due to: " + e.getMessage());
            return extractPriceStable(lbl_ItemTotal);
        }
    }
    public void clickClearAll()throws InterruptedException{
        getRestaurantUI().waitForClickability(btn_clearAll);
        getRestaurantUI().click(btn_clearAll);
    }
    public String getCartSummeryValue(String option) throws InterruptedException {
        getRestaurantUI().waitForVisibility(By.xpath(cartSummeryValue.replace("OPTION",option)));
        getRestaurantUI().waitForCustom(3000);
        String rawText = getRestaurantUI().getText(By.xpath(cartSummeryValue.replace("OPTION",option)));
        return rawText.replace(":", "").trim();
    }
    public double getOrderMinimumValueStable(String option) throws InterruptedException {
        try {
            return extractOrderMinimumValue(By.xpath(revenueSummeryValue.replace("OPTION",option)));
        } catch (Exception e) {
            System.out.println("Fallback to alternative price locator due to: " + e.getMessage());
            return extractOrderMinimumValue(By.xpath(revenueSummeryValue.replace("OPTION",option)));
        }
    }
    private double extractOrderMinimumValue(By priceLocator) throws InterruptedException {
        getRestaurantUI().waitForVisibility(priceLocator);
        String tagName = getRestaurantUI().getElement(priceLocator).getTagName();
        String priceText;

        if (tagName.equals("input")) {
            priceText = getRestaurantUI().getText(priceLocator, "value");
        } else if (tagName.equals("div")) {
            priceText = getRestaurantUI().getText(priceLocator);
        } else {
            priceText = getRestaurantUI().getText(priceLocator);
        }

        System.out.println("Extracted Price: " + priceText);
        priceText = priceText.replace(":", "").replace("$", "").split("/")[0].trim();

        return Double.valueOf(priceText);
    }
    public boolean isPreAuthorizationTextDisplay(String message)throws InterruptedException{
        return getRestaurantUI().isDisplayed(By.xpath(txt_preAuthorization.replace("MESSAGE",message)));
    }
    public boolean isConfirmPaymentTextDisplay()throws InterruptedException{
        return getRestaurantUI().isDisplayed(txt_confirmPayment);
    }
    public void clickContinue(){
        getRestaurantUI().click(btn_continue);
    }
    public void clickSortOptionsOG(String option)throws InterruptedException{
        getRestaurantUI().click(By.xpath(sortOptionsOG.replace("OPTION",option)));
    }
    public void clickDeliveryTo()throws InterruptedException{
        getRestaurantUI().click(lbl_deliveryTo);
    }
    public int isDeliveryAddressDisplay() throws InterruptedException {
        return getRestaurantUI().countDisplayedElements(deliveryAddress);
    }
    public void clickDeliveryAddress()throws InterruptedException{
        getRestaurantUI().click(deliveryAddressOption);
    }
    public boolean isSingleAddressDisplay()throws InterruptedException{
        return getRestaurantUI().isDisplayed(singleDeliveryAddress);
    }
    public void clickAccHoldCloseIcon(){
        getRestaurantUI().waitForVisibility(btn_accHoldClose_);
        getRestaurantUI().click(btn_accHoldClose_);
    }
    public boolean isAccountHoldPopUpDisplay(String message)throws InterruptedException{
        return getRestaurantUI().isDisplayed(By.xpath(accountOnHoldBanner.replace("MESSAGE",message)));
    }
    public void selectDistributorCenter(String center)throws InterruptedException{
        getRestaurantUI().click(By.xpath(distributorCenter.replace("CENTER",center)));
        getRestaurantUI().waitForCustom(3000);
    }
    public boolean isCatalogFilterDisplayTagList(String name,String tag){
        return getRestaurantUI().isDisplayed(By.xpath(listViewTag.replace("NAME", name).replace("TAG",tag)));
    }
    public boolean IsChangeLocationOrderGuideDisplay(String name){
        return getRestaurantUI().isDisplayed(By.xpath(orderGuideLocation.replace("NAME",name)));
    }
    public boolean isCustomerOrderGuideDisplayed(){
        return getRestaurantUI().isDisplayed(btn_catalogToOrderGuide);
    }
    public boolean isCatalogDisplayed(){
        return getRestaurantUI().isDisplayed(txtCatalog);
    }
    public void clickPlaceOrderSoftOrderMinimum(){
        getRestaurantUI().click(btn_placeOrderSoftOrderMinimum);
    }
    public void selectOrderMinimum(String orderMinimum){
        getRestaurantUI().click(orderMinimumeditBtn);
        if(!getRestaurantUI().isCheckboxOrRadioBtnSelected(By.xpath(orderMinimumSelectionRadioBtn.replace("ORDERMINIMUM",orderMinimum)))){
            getRestaurantUI().click(By.xpath(orderMinimumSelectionRadioBtn.replace("ORDERMINIMUM",orderMinimum)));
            getRestaurantUI().click(btn_saveEditShipAddress);
        }
        getRestaurantUI().click(orderMinimumOverlayCloseBtn);
    }
    public boolean isCustomerOnHold(){
        return getRestaurantUI().isDisplayed(customer_Holds);
    }
    public void clickOnNone(){
        getRestaurantUI().waitForVisibility(txt_none);
        getRestaurantUI().click(txt_none);
    }

    public boolean isItemVerifiedFailedPopUpDisplay()throws InterruptedException{
        getRestaurantUI().waitForCustom(5000);
        return getRestaurantUI().isDisplayed(txt_itemVerifiedFailed);
    }

    public boolean  isMaxQuantityExceededErrorMsg() throws InterruptedException{
        getRestaurantUI().waitForCustom(5000);
        return getRestaurantUI().isDisplayed(txt_MaxQuantityExceededErrorMsg);
    }

    public void enterItemQuantitySimpleList(String code)throws InterruptedException{
        getRestaurantUI().click(lbl_SimpleListQuantity);
        getRestaurantUI().sendKeys(lbl_SimpleListQuantity,code);
        getRestaurantUI().pressTabKey();
    }

    public void enterQuantitySimpleListViewByIndex(int index, String quantity) throws InterruptedException {
        By locator = By.xpath(quantityInputSimpleListViewByIndex.replace("INDEX", String.valueOf(index)));
        getRestaurantUI().waitForVisibility(locator);
        getRestaurantUI().clearUsingJavaScript(locator);
        getRestaurantUI().sendKeys(locator, quantity);
        getRestaurantUI().waitForCustom(500);
    }
    public void tabAwayFromQuantityField() throws InterruptedException {
        getRestaurantUI().pressTab();
        getRestaurantUI().waitForCustom(1000);
    }
    public boolean isMaxQuantityErrorModalDisplayed() throws InterruptedException {
        getRestaurantUI().waitForCustom(2000);
        return getRestaurantUI().isDisplayed(txt_maxQuantityErrorModal);
    }
    public void clickErrorModalOkButton() throws InterruptedException {
        if (getRestaurantUI().isDisplayed(btn_errorModalOk)) {
            getRestaurantUI().click(btn_errorModalOk);
            getRestaurantUI().waitForCustom(1000);
        }
    }
    public String getQuantitySimpleListViewByIndex(int index) {
        By locator = By.xpath(quantityInputSimpleListViewByIndex.replace("INDEX", String.valueOf(index)));
        getRestaurantUI().waitForVisibility(locator);
        return getRestaurantUI().getText(locator, "value");
    }

    public boolean isMaxQuantityExceededModalDisplayed() throws InterruptedException {
        getRestaurantUI().waitForCustom(2000);
        return getRestaurantUI().isDisplayed(txt_maxQuantityExceededModal);
    }

    public boolean isMaxQuantityExceededMessageDisplayed() throws InterruptedException {
        return getRestaurantUI().isDisplayed(txt_maxQuantityExceededMessage);
    }

    public void clickMaxQuantityModalOk() throws InterruptedException {
        getRestaurantUI().click(btn_maxQuantityModalOk);
        getRestaurantUI().waitForCustom(2000);
    }

    public boolean isPlusButtonDisabledFirstRow() throws InterruptedException {
        getRestaurantUI().waitForCustom(1000);
        return getRestaurantUI().isDisplayed(btn_increaseQtyFirstRowDisabled);
    }

    public boolean isPlusButtonDisabledCatalogPDP(String name) throws InterruptedException {
        getRestaurantUI().waitForCustom(1000);
        return getRestaurantUI().isDisplayed(By.xpath(btn_catalogPDPPlusDisabled.replace("NAME", name)));
    }

    public boolean isPlusButtonDisabledReviewCart(String code) throws InterruptedException {
        getRestaurantUI().waitForCustom(1000);
        return getRestaurantUI().isDisplayed(By.xpath(btn_reviewCartPlusDisabled.replace("CODE", code)));
    }

    public String getItemQuantityByCode(String code) throws InterruptedException {
        getRestaurantUI().waitForCustom(1000);
        return getRestaurantUI().getText(By.xpath(tbx_itemQuantityByCode.replace("CODE", code)), "value");
    }

    public void setItemQuantityByCode(String code, String quantity) throws InterruptedException {
        By quantityInput = By.xpath(tbx_itemQuantityByCode.replace("CODE", code));
        getRestaurantUI().clearUsingJavaScript(quantityInput);
        getRestaurantUI().clearWithKeys(quantityInput);
        getRestaurantUI().sendKeys(quantityInput, quantity);
        getRestaurantUI().waitForCustom(2000);
    }

    public void setCatalogPdpItemCount(String count,String name) throws InterruptedException {
        By qty = By.xpath("//input[@data-input='quantityInput']");

        getRestaurantUI().click(By.xpath(btn_catalogPDPPlusStable.replace("NAME", name)));
        getRestaurantUI().clearWithKeys(qty);
        getRestaurantUI().waitForCustom(2000);
        getRestaurantUI().sendKeysRaw(qty, count);
    }

    public boolean isOrderGuideSettingsDisplayed() {
        try {
            getRestaurantUI().waitForVisibility(txt_orderGuideSettingsOverlay);
            return getRestaurantUI().isDisplayed(txt_orderGuideSettingsOverlay);
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isOrderMinimumFieldDisplayed() {
        return getRestaurantUI().isDisplayed(txt_orderMinimumField);
    }
    public boolean isOrderCaseMinimumFieldDisplayed() {
        return getRestaurantUI().isDisplayed(txt_orderCaseMinimumField);
    }
    public boolean isDeliveryDaysFieldDisplayed() {
        return getRestaurantUI().isDisplayed(txt_deliveryDaysField);
    }
    public void setOrderMinimumValue(String amount) throws InterruptedException {
        getRestaurantUI().waitForVisibility(tbx_orderMinimumInput);
        getRestaurantUI().clearUsingJavaScript(tbx_orderMinimumInput);
        getRestaurantUI().sendKeys(tbx_orderMinimumInput, amount);
        getRestaurantUI().waitForCustom(1000);
    }
    public void setOrderCaseMinimumValue(String amount) throws InterruptedException {
        getRestaurantUI().waitForVisibility(tbx_orderCaseMinimumInput);
        getRestaurantUI().clearUsingJavaScript(tbx_orderCaseMinimumInput);
        getRestaurantUI().sendKeys(tbx_orderCaseMinimumInput, amount);
        getRestaurantUI().waitForCustom(1000);
    }

    public void removeDeliveryDayFromSettings(String day) throws InterruptedException {
        By removeDayBtn = By.xpath(
                txt_removeDeliveryDay.replace("DAY", day)
        );

        if (getRestaurantUI().isDisplayed(removeDayBtn)) {
            getRestaurantUI().click(removeDayBtn);
            getRestaurantUI().waitForCustom(500);
        }
    }

    public void clickSaveOrderGuideSettingsBtn() throws InterruptedException {
        getRestaurantUI().click(btn_saveOrderGuideSettings);
        getRestaurantUI().waitForCustom(2000);
    }
    public void clickCloseOrderGuideSettingsBtn() throws InterruptedException {
        getRestaurantUI().click(btn_closeOrderGuideSettings);
        getRestaurantUI().waitForCustom(2000);
    }

    public void clickBackToCartFromOrderMinimumPopup() {
        getRestaurantUI().waitForVisibility(txt_popupAlertOrderMin);
        getRestaurantUI().waitForClickability(btn_backToCart);
        getRestaurantUI().click(btn_backToCart);
    }


    public boolean isCaseMinPopupDisplayed(){
        getRestaurantUI().waitForVisibility(txt_popupAlertCaseMin);
        return getRestaurantUI().isDisplayed(txt_popupAlertCaseMin);
    }

    public void clickOnBtnForRamona(){
        getRestaurantUI().click(btn_ramona);
    }


    public boolean isDisplayedMinOrderAmountLabel() throws InterruptedException {
        return getRestaurantUI().isDisplayed(MinOrderAmountLabel);
    }

    public boolean isDisplayedMinOrderCaseLabel() throws InterruptedException {
        return getRestaurantUI().isDisplayed(MinOrderCaseLabel);
    }

    public boolean isDisplayedDeliveryDaysLabel() throws InterruptedException {
        return getRestaurantUI().isDisplayed(DeliveryDateLabel );
    }

    public void clickEditPriceVisibility(){
        getRestaurantUI().isDisplayed(priceVisibilityEditBtn);
        getRestaurantUI().click(priceVisibilityEditBtn);
    }

    public void editPriceVisibilityStatus(String status){
        getRestaurantUI().click(priceVisibilityDropDown);
        getRestaurantUI().waitForVisibility(By.xpath(priceVisibilityOption.replace("STATUS", status)));
        getRestaurantUI().click(By.xpath(priceVisibilityOption.replace("STATUS", status)));
    }

    public void savePriceVisibilityChanges(){
        getRestaurantUI().click(btn_saveEditPriceVisibility);
    }

    public void clickOnGeneralHold(){
        getRestaurantUI().waitForVisibility(txt_generalHold);
        getRestaurantUI().click(txt_generalHold);
    }
    public boolean isGeneralHoldSelected(){
        return getRestaurantUI().isDisplayed(lbl_generalHold);
    }
    public boolean isContactSupplierButtonDisplayed() throws InterruptedException {
        return getRestaurantUI().isDisplayed(btn_contactSupplier);
    }
    public void clickContactSupplierButton() throws InterruptedException {
        getRestaurantUI().waitForVisibility(btn_contactSupplier);
        getRestaurantUI().click(btn_contactSupplier);
    }
    public boolean isViewDetailsButtonDisplayed() throws InterruptedException {
        return getRestaurantUI().isDisplayed(btn_viewDetails);
    }
    public void clickViewDetailsButton() throws InterruptedException {
        getRestaurantUI().waitForVisibility(btn_viewDetails);
        getRestaurantUI().click(btn_viewDetails);
    }
    public boolean isGeneralHoldModalMessageDisplayed(String message) throws InterruptedException {
        return getRestaurantUI().isDisplayed(By.xpath(generalHoldModalMessage.replace("MESSAGE", message)));
    }
    public boolean isGeneralHoldBannerDisplayed() throws InterruptedException {
        return getRestaurantUI().isDisplayed(generalHoldBanner);
    }

    public boolean isChatWindowDisplay()throws InterruptedException{
        getRestaurantUI().waitForVisibility(chatWindowPlaceholderText);
        return getRestaurantUI().isDisplayed(chatWindowPlaceholderText);
    }

    public boolean isHistoryInstructionDisplaed(){
        getRestaurantUI().waitForVisibility(messageInInstructionHistory);
        return getRestaurantUI().isDisplayed(messageInInstructionHistory);
    }

    public boolean isSpecialInstructionDisplay(){
        getRestaurantUI().waitForVisibility(get_specialInstructionsInHistory);
        return getRestaurantUI().isDisplayed(get_specialInstructionsInHistory);
    }

    public void ClickContactSupplier (){
        getRestaurantUI().waitForVisibility(contactSupplierBtn);
        getRestaurantUI().click(contactSupplierBtn);
    }

    public boolean isAddInstructionsLinkDisplayed() {
        try {
            getRestaurantUI().waitForVisibility(lnk_addInstructionsFirstItem);
            return getRestaurantUI().isDisplayed(lnk_addInstructionsFirstItem);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isAddInstructionsLinkDisplayedForItem(String itemCode) {
        try {
            By locator = By.xpath(lnk_addInstructionsByItemCode.replace("ITEMCODE", itemCode));
            return getRestaurantUI().isDisplayed(locator);
        } catch (Exception e) {
            return false;
        }
    }

    public void clickAddInstructionsForFirstItem() throws InterruptedException {
        getRestaurantUI().waitForVisibility(lnk_addInstructionsFirstItem);
        getRestaurantUI().click(lnk_addInstructionsFirstItem);
        getRestaurantUI().waitForCustom(1000);
    }
    public void clickEditInstructionsForFirstItem() throws InterruptedException {
        getRestaurantUI().waitForVisibility(lnk_EditInstructionsItem);
        getRestaurantUI().click(lnk_EditInstructionsItem);
        getRestaurantUI().waitForCustom(1000);
    }

    public void clickAddInstructionsForItem(String itemCode) throws InterruptedException {
        By locator = By.xpath(lnk_addInstructionsByItemCode.replace("ITEMCODE", itemCode));
        getRestaurantUI().waitForVisibility(locator);
        getRestaurantUI().click(locator);
        getRestaurantUI().waitForCustom(1000);
    }

    public void clickInstructionsLinkForItem(String itemCode) throws InterruptedException {
        By locator = By.xpath(lnk_instructionsByItemCode.replace("ITEMCODE", itemCode));
        getRestaurantUI().waitForVisibility(locator);
        getRestaurantUI().click(locator);
        getRestaurantUI().waitForCustom(1000);
    }

    public boolean isItemInstructionModalDisplayed() {
        try {
            getRestaurantUI().waitForVisibility(txt_itemInstructionModal);
            return getRestaurantUI().isDisplayed(txt_itemInstructionModal);
        } catch (Exception e) {
            return false;
        }
    }

    public void enterItemInstructions(String instructions) throws InterruptedException {
        getRestaurantUI().waitForVisibility(tbx_itemInstructionInput);
        getRestaurantUI().clear(tbx_itemInstructionInput);
        getRestaurantUI().sendKeys(tbx_itemInstructionInput, instructions);
        getRestaurantUI().waitForCustom(1000);
    }

    public void clearItemInstructions() throws InterruptedException {
        getRestaurantUI().waitForVisibility(tbx_itemInstructionInput);
        getRestaurantUI().clearWithAllSelect(tbx_itemInstructionInput);
        getRestaurantUI().waitForCustom(1000);
    }

    public String getItemInstructionsText() {
        getRestaurantUI().waitForVisibility(tbx_itemInstructionInput);
        return getRestaurantUI().getAttributeValue(tbx_itemInstructionInput, "value");
    }

    public String getItemSavedInstructionsText() {
        getRestaurantUI().waitForVisibility(itemSavedInstruction);
        return getRestaurantUI().getAttributeValue(itemSavedInstruction, "value");
    }

    public void clickSaveItemInstructions() throws InterruptedException {
        getRestaurantUI().waitForVisibility(btn_updateItemInstruction);
        getRestaurantUI().click(btn_updateItemInstruction);
        getRestaurantUI().waitForCustom(1000);
    }

    public void clickCancelItemInstructions() throws InterruptedException {
        getRestaurantUI().waitForVisibility(btn_cancelItemInstruction);
        getRestaurantUI().click(btn_cancelItemInstruction);
        getRestaurantUI().waitForCustom(1000);
    }

    public boolean isInstructionsDisplayedForItem(String itemCode) {
        try {
            By locator = By.xpath(txt_instructionsDisplayByItemCode.replace("ITEMCODE", itemCode));
            return getRestaurantUI().isDisplayed(locator);
        } catch (Exception e) {
            return false;
        }
    }

    public String getDisplayedInstructionsForItem(String itemCode) {
        By locator = By.xpath(txt_instructionsTextByItemCode.replace("ITEMCODE", itemCode));
        getRestaurantUI().waitForVisibility(locator);
        return getRestaurantUI().getText(locator);
    }

    public boolean isSpecialInstructionsSectionDisplayed() throws InterruptedException {
        return getRestaurantUI().isDisplayed(lbl_specialInstructions, 5);
    }

    public boolean isSpecialInstructionsTextAreaDisplayed() throws InterruptedException {
        return getRestaurantUI().isDisplayed(txt_specialInstructionsTextArea, 5);
    }

    public void typeSpecialInstructions(String instructions) throws InterruptedException {
        getRestaurantUI().waitForVisibility(txt_specialInstructionsTextArea);
        getRestaurantUI().clear(txt_specialInstructionsTextArea);
        getRestaurantUI().sendKeys(txt_specialInstructionsTextArea, instructions);
    }

    public String getSpecialInstructionsText() throws InterruptedException {
        getRestaurantUI().waitForVisibility(txt_specialInstructionsTextArea);
        return getRestaurantUI().getAttributeValue(txt_specialInstructionsTextArea, "value");
    }

    public void clearSpecialInstructions() throws InterruptedException {
        getRestaurantUI().waitForVisibility(txt_specialInstructionsTextArea);
        WebElement element = getRestaurantUI().getElement(txt_specialInstructionsTextArea);
        element.click();
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.DELETE);
        element.sendKeys(Keys.TAB);
    }

    public boolean isSpecialInstructionsTooltipDisplayed() throws InterruptedException {
        return getRestaurantUI().isDisplayed(icon_specialInstructionsTooltip, 5);
    }

    public void hoverOnSpecialInstructionsTooltip() throws InterruptedException {
        getRestaurantUI().waitForVisibility(icon_specialInstructionsTooltip);
        getRestaurantUI().hoverOverElement(icon_specialInstructionsTooltip);
    }

    public void clickBrowserNativeBackButton() throws InterruptedException {
        getRestaurantUI().goBack();
        getRestaurantUI().waitForCustom(2000);
    }

    public boolean isPriceDisclaimerTextDisplayed(){
        return getRestaurantUI().isDisplayed(txt_priceDisclaimer, 5);
    }
    public boolean IsSupplierLocationOrderGuideDisplay(String name){
        return getRestaurantUI().isDisplayed(By.xpath(dropDownSupplierLocationOrderGuide.replace("NAME",name)));
    }

    public void clickOnSaveDraft() {
        getRestaurantUI().waitForClickability(btn_saveDraft);
        getRestaurantUI().click(btn_saveDraft);
    }

    public boolean isSaveDraftOptionDisplayed() {
        try {
            getRestaurantUI().waitForVisibility(btn_saveDraft);
            return getRestaurantUI().isDisplayed(btn_saveDraft);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSaveDraftOptionNotDisplayed() {
        try {
            return !getRestaurantUI().isDisplayed(btn_saveDraft);
        } catch (Exception e) {
            return true;
        }
    }

    public boolean isDeleteOrderGuideOptionDisplayed(){
        return getRestaurantUI().isDisplayed(btn_deleteOrderGuide);
    }

    public boolean isOrderGuidePresentInDropdown(String orderGuideName) {
        String dynamicXpath = dropDownOrderGuide.replace("NAME", orderGuideName);
        try {
            return getRestaurantUI().isDisplayed(By.xpath(dynamicXpath));
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnSwitchToOfflineMode() {
        getRestaurantUI().waitForClickability(btn_switchToOfflineMode);
        getRestaurantUI().click(btn_switchToOfflineMode);
    }

    public void clickOnActivateOfflineMode() throws InterruptedException {
        getRestaurantUI().waitForClickability(btn_activateOfflineMode);
        getRestaurantUI().click(btn_activateOfflineMode);
        getRestaurantUI().waitForCustom(2000);
    }

    public boolean isOfflineModeActive() {
        try {
            getRestaurantUI().waitForVisibility(txt_offlineModeActive);
            return getRestaurantUI().isDisplayed(txt_offlineModeActive);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSwitchToOfflineModeOptionDisplayed() {
        try {
            return getRestaurantUI().isDisplayed(btn_switchToOfflineMode);
        } catch (Exception e) {
            return false;
        }

    }

    public void setItemQuantityFirstRow(String quantity) throws InterruptedException {
        getRestaurantUI().clearUsingJavaScript(tbx_itemQuantityFirstRow);
        getRestaurantUI().clearWithKeys(tbx_itemQuantityFirstRow);
        getRestaurantUI().sendKeys(tbx_itemQuantityFirstRow, quantity);
        getRestaurantUI().waitForCustom(2000);
    }

    public boolean isItemUnavailableTagDisplayed(String code) throws InterruptedException {
        getRestaurantUI().waitForCustom(2000);
        return getRestaurantUI().isDisplayed(By.xpath(txt_itemUnavailableTag.replace("CODE", code)));
    }

    public boolean isItemRowDisplayedByCode(String code) throws InterruptedException {
        getRestaurantUI().waitForCustom(2000);
        try {
            return getRestaurantUI().isDisplayed(By.xpath(txt_itemRowByCode.replace("CODE", code)));
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isNoItemsFoundInCatalog() throws InterruptedException {
        getRestaurantUI().waitForCustom(3000);
        try {
            return getRestaurantUI().isDisplayed(txt_noItemsFoundCatalog);
        } catch (Exception e) {
            return false;
        }
    }


    //####################################################################################

    public String getHeaderCartTotal() throws InterruptedException {
        getRestaurantUI().waitForCustom(2000);
        try {
            return getRestaurantUI().getText(lbl_headerCartTotal);
        } catch (Exception e) {
            return getRestaurantUI().getText(btn_checkoutButtonPrice);
        }
    }

    public String getHeaderLineItemsCount() throws InterruptedException {
        getRestaurantUI().waitForCustom(2000);
        try {
            return getRestaurantUI().getText(lbl_headerLineItemsCount);
        } catch (Exception e) {
            return "0";
        }
    }

    public String getHeaderQuantityCount() throws InterruptedException {
        getRestaurantUI().waitForCustom(2000);
        try {
            return getRestaurantUI().getText(lbl_headerQuantityCount);
        } catch (Exception e) {
            return "0";
        }
    }

    public boolean isOrderSummaryWidgetDisplayed() throws InterruptedException {
        getRestaurantUI().waitForCustom(2000);
        try {
            return getRestaurantUI().isDisplayed(lbl_orderSummaryWidget);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isCartTotalBelowMinimum() throws InterruptedException {
        getRestaurantUI().waitForCustom(2000);
        try {
            String checkoutButtonClass = getRestaurantUI().getAttributeValue(btn_checkoutButtonPrice, "class");
            return checkoutButtonClass != null && (checkoutButtonClass.contains("danger") || checkoutButtonClass.contains("red"));
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnOrderSummaryWidget() throws InterruptedException {
        getRestaurantUI().waitForCustom(2000);
        getRestaurantUI().click(lbl_orderSummaryWidget);
        getRestaurantUI().waitForCustom(2000);
    }

    public void setItemQuantitySecondRow(String quantity) throws InterruptedException {
        By tbx_itemQuantitySecondRow = By.xpath("(//*[@data-input='quantityInput'])[2]");
        getRestaurantUI().clearUsingJavaScript(tbx_itemQuantitySecondRow);
        getRestaurantUI().clearWithKeys(tbx_itemQuantitySecondRow);
        getRestaurantUI().sendKeys(tbx_itemQuantitySecondRow, quantity);
        getRestaurantUI().waitForCustom(2000);
    }

    public void setItemQuantityThirdRow(String quantity) throws InterruptedException {
        By tbx_itemQuantityThirdRow = By.xpath("(//*[@data-input='quantityInput'])[3]");
        getRestaurantUI().clearUsingJavaScript(tbx_itemQuantityThirdRow);
        getRestaurantUI().clearWithKeys(tbx_itemQuantityThirdRow);
        getRestaurantUI().sendKeys(tbx_itemQuantityThirdRow, quantity);
        getRestaurantUI().waitForCustom(2000);
    }

    public boolean isBrandColumnHeaderDisplayed() throws InterruptedException {
        getRestaurantUI().waitForCustom(3000);
        return getRestaurantUI().isDisplayed(txt_brandColumnHeader);
    }

    public boolean isCatalogListViewTableDisplayed() throws InterruptedException {
        getRestaurantUI().waitForCustom(2000);
        return getRestaurantUI().isDisplayed(txt_catalogListViewTable);
    }

    public String getFirstItemBrandInListView() throws InterruptedException {
        getRestaurantUI().waitForCustom(2000);
        getRestaurantUI().waitForVisibility(txt_firstItemBrandInListView);
        return getRestaurantUI().getText(txt_firstItemBrandInListView);
    }

    public String getFirstItemNameInListView() throws InterruptedException {
        getRestaurantUI().waitForCustom(2000);
        getRestaurantUI().waitForVisibility(txt_firstItemNameInListView);
        return getRestaurantUI().getText(txt_firstItemNameInListView);
    }

    public boolean isBrandDataDisplayedInListView() throws InterruptedException {
        getRestaurantUI().waitForCustom(2000);
        try {
            String brandText = getFirstItemBrandInListView();
            return brandText != null && !brandText.trim().isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public void clearAndEditItemName(String newItemName) throws InterruptedException {
        getRestaurantUI().waitForVisibility(editItemNameTextField);
        getRestaurantUI().clearUsingJavaScript(editItemNameTextField);
        getRestaurantUI().waitForCustom(1000);
        getRestaurantUI().sendKeys(editItemNameTextField, newItemName);
    }
    public void clickSaveItemBtnOnEditPopup() throws InterruptedException {
        getRestaurantUI().waitForClickability(saveItemBtn);
        getRestaurantUI().click(saveItemBtn);
        getRestaurantUI().waitForCustom(5000);

    }

    public void typeOnStandingOrderTitle(String title) throws InterruptedException {
        getRestaurantUI().clear(tbx_titleStandingOrder);
        getRestaurantUI().waitForCustom(1000);
        getRestaurantUI().sendKeys(tbx_titleStandingOrder, title);
    }

    public void clickYes() throws InterruptedException {
        getRestaurantUI().click(btn_yes);
        getRestaurantUI().waitForCustom(1000);
    }

    public boolean isCartEmpty(){
        getRestaurantUI().waitForVisibility(txt_cartEmpty);
        return getRestaurantUI().isDisplayed(txt_cartEmpty);
    }


}