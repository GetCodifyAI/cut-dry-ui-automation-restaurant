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
    By txt_catalog = By.xpath("//span[contains(text(), 'Catalog')]");
    By btn_catalog = By.xpath("//span[text()='Catalog']");
    By btn_catalogToOrderGuide = By.xpath("//span[text()='Order Guide']");
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
    By lbl_itemPriceReviewCart = By.xpath("//td[text()='Total:']/following-sibling::td");
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
    By btn_save = By.xpath("//button[contains(@class, 'btn btn-primary') and contains(text(), 'Save')]");
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
    String deliveryDateOrderHistory = "//*[contains(text(),'#') and text()='ID']/../../preceding-sibling::td[2][text()='DATE']";
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
    By dropdown_delivery = By.xpath("(//div[text()='Delivery to Hayes:']/following-sibling::div//div[text()='Select Days...'])[1]");
    String txt_deliveryDay = "//div[text()='DAY']/preceding-sibling::input[@type='checkbox']";
    String txt_deliveryLastBeforeDay = "(//div[contains(@class, 'cd_themed_select__option')]//input[@type='checkbox'])[last()-1]";
    By btn_setStandingOrder = By.xpath("//button[text()='Set Standing Order']");
    By btn_resetStandingOrder = By.xpath("//button[text()='Reset Standing Order']");
    By txt_success = By.xpath("//h2[text()='Success']");
    By txt_reviewStandingOrders = By.xpath("//div[text()='Review Standing Order']");
    By btn_editStandingOrderIcon = By.xpath("//button[@title='Edit']");
    By btn_deleteStandingOrderIcon = By.xpath("//button[@title='Delete']");
    By txt_deletePopup = By.xpath("//h2[text()='Are you sure?']");
    String standingOrder = "//div[text()=' (QUANTITY items for $PRICE)']";
    By btn_pauseStandingOrderIcon = By.xpath("//button[@title='Pause']");
    By txt_pausedStandingOrders = By.xpath("//div[contains(text(),'(Paused) ')]");
    By btn_resumeStandingOrderIcon = By.xpath("//button[@title='Resume']");
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


















    public boolean isPreviousDraftOrderNoDisplayed() throws InterruptedException {
        /*restaurantUI.waitForElementEnabledState(btn_previousDraftOrderNo, true);
        restaurantUI.waitForCustom(2000);*/
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
        restaurantUI.click(icon_deleteSearchItem);
        restaurantUI.clearUsingJavaScript(tbx_catalogSearch);
        restaurantUI.click(tbx_catalogSearch);
        restaurantUI.waitForCustom(2000);
        restaurantUI.sendKeys(tbx_catalogSearch, item);
        restaurantUI.click(btn_OGAndCatalogSearch);
        restaurantUI.waitForCustom(4000);
    }

    public void typeToSearchOnOrderGuide(String item) {
        restaurantUI.click(icon_deleteSearchItem);
        restaurantUI.sendKeys(tbx_orderGuideSearch, item);
        restaurantUI.click(btn_OGAndCatalogSearch);
        try {
            restaurantUI.waitForCustom(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

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
        return restaurantUI.isDisplayed(btn_duplicateOrderYes);
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
        restaurantUI.clickUsingJavaScript(btn_edit);
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

    public void clickOnCloseEditor() throws InterruptedException {
        restaurantUI.click(btn_closeEditor);
        restaurantUI.refreshPage();
        try {
            restaurantUI.waitForCustom(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
public void clickOnCloseOrderGuideEditor(){
    restaurantUI.waitForClickability(btn_closeEditor);
    restaurantUI.clickUsingJavaScript(btn_closeEditor);
    restaurantUI.waitForVisibility(tbx_orderGuideSearch);
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

    public void selectDeliveryDateLine(String date) throws InterruptedException {
        By lbl_selectStartDate = By.xpath(dynamicToXPath.replace("DAY", date));
        restaurantUI.waitForVisibility(lbl_selectStartDate);
        restaurantUI.click(lbl_selectStartDate);
        restaurantUI.waitForCustom(5000);
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
        return restaurantUI.isDisplayed(ratingOverlayIframe,5);
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
        restaurantUI.isDisplayed(btn_placeOrder);
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
        restaurantUI.scrollToElement(sectionDeleteBtn);
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

    public void clickEditItemBtn(String itemname) throws InterruptedException {
        restaurantUI.waitForCustom(3000);
        restaurantUI.waitForVisibility(By.xpath(editItemBtn.replace("ITEMNAME",itemname)));
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
            restaurantUI.waitForCustom(5000);
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
        try {
            restaurantUI.waitForCustom(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
    public boolean isEditOrderTextDisplayed(){
        restaurantUI.waitForVisibility(editOrderPage);
        return restaurantUI.isDisplayed(editOrderPage);
    }
    public Double getItemPriceOnCheckoutButtonViaPDP() throws InterruptedException {
        restaurantUI.waitForVisibility(btn_checkOutPDP);
        restaurantUI.waitForCustom(8000);
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
        String result = businessName.substring(0, businessName.indexOf("Test"));
        System.out.println(result);
        try {
            restaurantUI.waitForCustom(3000);
            restaurantUI.waitForVisibility(By.xpath(txt_customerProfile.replace("BUSINESSNAME",result)));
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(By.xpath(txt_customerProfile.replace("BUSINESSNAME",result)));
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
    public void clickOnPlaceOrderSW() {
        restaurantUI.click(btn_placeOrderSW );
    }

    public String getItemNameFirstMultiOUM() throws InterruptedException {
//        restaurantUI.scrollToElementStable(lbl_firstMultiOUMItemName,3);
        restaurantUI.scrollToElementAccurate(lbl_firstMultiOUMItemName,2);
        restaurantUI.waitForElementEnabledState(lbl_firstMultiOUMItemName,true);
        restaurantUI.waitForCustom(3000);
        return restaurantUI.getText(lbl_firstMultiOUMItemName);
    }

    public String IsCustomOrderTextDisplayed() throws InterruptedException {
        restaurantUI.waitForVisibility(btn_sortCustomOrder);
        restaurantUI.waitForCustom(4000);
        String dropdownText = restaurantUI.getText(btn_sortCustomOrder);
        return dropdownText;

    }


    public String getItemCodeFirstMultiOUM() throws InterruptedException {
//        restaurantUI.scrollToElementStable(lbl_firstMultiOUMItemCode,3);
        restaurantUI.waitForVisibility(lbl_firstMultiOUMItemCode);
        restaurantUI.waitForCustom(3000);
        return restaurantUI.getText(lbl_firstMultiOUMItemCode);
    }

    private double extractPriceStable(By priceLocator) throws InterruptedException {
        restaurantUI.waitForVisibility(priceLocator);
        String tagName = restaurantUI.getElement(priceLocator).getTagName();
        String priceText;

        if (tagName.equals("input")) {
            priceText = restaurantUI.getText(priceLocator, "value");
        } else if (tagName.equals("div")) {
            priceText = restaurantUI.getText(priceLocator);
        } else {
            priceText = restaurantUI.getText(priceLocator);
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
        int totalColumnCount = restaurantUI.countElements(lbl_orderGuideTableColumn);

        for (int i = 1; i <= totalColumnCount; i++) {
            String columnName = restaurantUI.getText(By.xpath(lbl_orderGuideTableColumnName.replace("COUNT", String.valueOf(i))));
            if ("price".equalsIgnoreCase(columnName)) {
                restaurantUI.waitForVisibility(By.xpath(lbl_firstMultiOUMItemCodeLB.replace("COUNT", String.valueOf(i))));
                restaurantUI.waitForCustom(3000);
                return restaurantUI.getText(By.xpath(lbl_firstMultiOUMItemCodeLB.replace("COUNT", String.valueOf(i))));
            }
        }
        return null;
    }

    public String getItemNameFirstMultiOUMLB() throws InterruptedException {
        int totalColumnCount = restaurantUI.countElements(lbl_orderGuideTableColumn);

        for (int i = 1; i <= totalColumnCount; i++) {
            String columnName = restaurantUI.getText(By.xpath(lbl_orderGuideTableColumnName.replace("COUNT", String.valueOf(i))));
            if ("price".equalsIgnoreCase(columnName)) {
                restaurantUI.scrollToElementStable(By.xpath(lbl_firstMultiOUMItemNameLB.replace("COUNT", String.valueOf(i))),3);
                restaurantUI.waitForVisibility(By.xpath(lbl_firstMultiOUMItemNameLB.replace("COUNT", String.valueOf(i))));
                restaurantUI.waitForCustom(3000);
                return restaurantUI.getText(By.xpath(lbl_firstMultiOUMItemNameLB.replace("COUNT", String.valueOf(i))));
            }
        }
        return null;
    }

    public String getItemUOMQuantity(String code,String uom){
        return restaurantUI.getText(By.xpath(tbx_itemQuantityUOM.replace("CODE", code).replace("UOM", uom)), "value");
    }

    public void ClickOnMultiUomDropDownOG(String code)throws InterruptedException{
        restaurantUI.waitForVisibility(By.xpath(multiUomDropDownOG.replace("CODE", code)));
        restaurantUI.click(By.xpath(multiUomDropDownOG.replace("CODE", code)));
        restaurantUI.click(multiUomOption);
        restaurantUI.waitForCustom(3000);
    }
    public void clickOGAddToCartPlusIcon(String code,String uom)throws InterruptedException{
        restaurantUI.waitForVisibility(By.xpath(btn_OGAddToCartPlusQuantity.replace("CODE", code).replace("UOM", uom)));
        restaurantUI.click(By.xpath(btn_OGAddToCartPlusQuantity.replace("CODE", code).replace("UOM", uom)));
        restaurantUI.waitForCustom(3000);
    }

    public void clickAddToCartMinusIcon(String code,String uom) throws InterruptedException {
        restaurantUI.waitForVisibility(By.xpath(btn_OGRemoveToCartMinusQuantity.replace("CODE", code).replace("UOM", uom)));
        restaurantUI.click(By.xpath(btn_OGRemoveToCartMinusQuantity.replace("CODE", code).replace("UOM", uom)));
        restaurantUI.waitForCustom(3000);
    }

    public double getActiveItemPriceMultiOUM(String position) throws InterruptedException {
        return extractPriceStable(By.xpath(lbl_itemPriceMultiOUM.replace("UOM", position)));
    }

    public Double getItemPriceOnMultiOUMCheckout() throws InterruptedException {
        restaurantUI.waitForVisibility(btn_orderCheckoutReview);
        restaurantUI.waitForCustom(4000);
        String priceText = restaurantUI.getText(btn_orderCheckoutReview).replace("$", "").replace(",", "");
        return Double.valueOf(priceText);
    }

    public Double getItemPriceReviewCartMultiUOM(String position) {
        restaurantUI.waitForVisibility(By.xpath(lbl_cartItemUnitPriceReviewMultiUOM.replace("UOM", position)));
        String tagName = restaurantUI.getElement(By.xpath(lbl_cartItemUnitPriceReviewMultiUOM.replace("UOM", position))).getTagName();
        String priceText;
        if (tagName.equals("input")) {
            priceText = restaurantUI.getText(By.xpath(lbl_cartItemUnitPriceReviewMultiUOM.replace("UOM", position)), "value");
        } else {
            priceText = restaurantUI.getText(By.xpath(lbl_cartItemUnitPriceReviewMultiUOM.replace("UOM", position)));
        }

        return Double.valueOf(priceText.replace("$", "").replace("/cs", "").replace("/pkg", "").trim());

    }
    public boolean isCombinedPopupDisplayed() {
        return restaurantUI.isDisplayed(combinedOrderPopUp);
    }
    public void clickContinueCombined(){
        restaurantUI.click(combinedOrderContinue);
    }
    public boolean isSetSubstitutionTextDisplayed()throws InterruptedException{
        restaurantUI.waitForCustom(2000);
        return restaurantUI.isDisplayed(txtSetSubstitution);
    }
    public void clickChooseSub(){
        restaurantUI.click(btn_chooseSub);
    }
    public void clickSelectSub(){
        restaurantUI.waitForVisibility(btn_selectSub);
        restaurantUI.clickUsingJavaScript(btn_selectSub);
    }
    public void clickCloseSub(){
        restaurantUI.click(btn_closeSub);
    }
    public void clickEditSub(){
        restaurantUI.click(btn_editSub);
    }
    public void clickRemovePreviousSub(){
        restaurantUI.click(btn_notSelectSub);
    }
    public void clickSaveSelection(){
        restaurantUI.waitForVisibility(btn_saveSelection);
        restaurantUI.click(btn_saveSelection);
    }
    public boolean isTopCategoryPicksDisplayed(){
        return restaurantUI.isDisplayed(lbl_topCategoryPicks);
    }
    public boolean isCompareSimilarItemsDisplayed(){
        return restaurantUI.isDisplayed(section_compareSimilar);
    }
    public boolean isRecommendedForYouItemNameDisplayed(String code){
        return restaurantUI.isDisplayed(By.xpath(lbl_recommendedForYouItem.replace("CODE",code )));
    }
    public boolean isRecommendedBySalesRepDisplayed(String code) {
        return restaurantUI.isDisplayed(By.xpath(lbl_recommendedBySalesRep.replace("CODE", '#'+code)));
    }
    public boolean isDontForgetToOrderDisplayed(){
        restaurantUI.scrollToElement(section_dontForget);
        return restaurantUI.isDisplayed(section_dontForget);
    }
    public boolean isMoreFromThisBrandDisplayed(){
        return restaurantUI.isDisplayed(section_moreFromThisBrand);
    }

    public String getItemNameFirstMultiOUMCoupa() throws InterruptedException {
      restaurantUI.uiScrollTop();
        restaurantUI.scrollToElementStpByStep(lbl_firstMultiOUMItemNameCoupa,3);
//        restaurantUI.waitForElementEnabledState(lbl_firstMultiOUMItemNameCoupa,true);
        restaurantUI.waitForCustom(3000);
        return restaurantUI.getText(lbl_firstMultiOUMItemNameCoupa);
    }


    public String getItemCodeFirstMultiOUMCoupa() throws InterruptedException {
//        restaurantUI.scrollToElementStable(lbl_firstMultiOUMItemCodeCoupa,3);
        restaurantUI.waitForVisibility(lbl_firstMultiOUMItemCodeCoupa);
        restaurantUI.waitForCustom(3000);
        return restaurantUI.getText(lbl_firstMultiOUMItemCodeCoupa);
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
        restaurantUI.waitForVisibility(priceLocator);
        String tagName = restaurantUI.getElement(priceLocator).getTagName();
        String priceText;

        if (tagName.equals("input")) {
            priceText = restaurantUI.getText(priceLocator, "value");
        } else if (tagName.equals("div")) {
            priceText = restaurantUI.getText(priceLocator);
        } else {
            priceText = restaurantUI.getText(priceLocator);
        }

        System.out.println("Extracted Price: " + priceText);
        priceText = priceText.replace("$", "").replace(",", "").split("/")[0].trim();

        return Double.valueOf(priceText);
    }
    public void refreshCustomersPage(){
        restaurantUI.refreshPage();
    }
    public boolean isAddSubstitutionTextDisplayed()throws InterruptedException{
        restaurantUI.waitForCustom(2000);
        return restaurantUI.isDisplayed(txtSubstitution);
    }
    public void clickSubstitution()throws InterruptedException{
        restaurantUI.click(txtSubstitution);
    }
    public boolean isSetSubstitutionPopUpDisplayed()throws InterruptedException{
        restaurantUI.waitForCustom(2000);
        return restaurantUI.isDisplayed(txtSetSubstitutionPopUp);
    }
    public boolean isOrderMinPopupDisplayed(){
        restaurantUI.waitForVisibility(txt_popupAlertOrderMin);
        return restaurantUI.isDisplayed(txt_popupAlertOrderMin);
    }
    public boolean isMinOrderBannerDisplayed(){
        restaurantUI.waitForVisibility(txt_minOrderBanner);
//        restaurantUI.waitForVisibility(txt_minOrderBanner);
        restaurantUI.refreshPage();
        return restaurantUI.isDisplayed(txt_minOrderBanner);
    }
    public void clickOK(){
        restaurantUI.waitForClickability(btn_OK);
        restaurantUI.click(btn_OK);
    }
    public void clickOnYes(){
        restaurantUI.waitForVisibility(btn_yes);
        restaurantUI.click(btn_yes);
    }
    public void clickonInvoice(){
        restaurantUI.click(btn_invoice);
    }
    public boolean isFirstRecordDisplayed(){
        return restaurantUI.isDisplayed(cb_inInvoiceTable);
    }
    public void clickEditSubstitutionsAccess(){
        restaurantUI.waitForVisibility(substitutionsAccessEditBtn);
        restaurantUI.scrollToElement(substitutionsAccessEditBtn);
        restaurantUI.click(substitutionsAccessEditBtn);
    }
    public void editSubstitutionStatus(String status){
        restaurantUI.click(substitutionDropDown);
        restaurantUI.waitForVisibility(By.xpath(substitutionOption.replace("STATUS", status)));
        restaurantUI.click(By.xpath(substitutionOption.replace("STATUS", status)));
    }
    public void saveCatalogAccessChanges(){
        restaurantUI.clickWithScrollAndHover(Savebtn);
        try {
            restaurantUI.waitForCustom(4000);
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
        restaurantUI.scrollToElement(By.xpath(recentOrder.replace("ID",id)));
        return restaurantUI.isDisplayed(By.xpath(recentOrder.replace("ID",id)));
    }
    public void isPreviousDraftOrderYesDisplayed() throws InterruptedException {
         restaurantUI.click(btn_previousDraftOrderYes);
    }
    public void clickOnRemoveFromOrderGuideStable(String name) throws InterruptedException {
        restaurantUI.waitForVisibility(By.xpath(removeItemOnOG.replace("NAME",name)));
        restaurantUI.click(By.xpath(removeItemOnOG.replace("NAME",name)));
        restaurantUI.waitForCustom(4000);
    }
    public void typeToSearchOnHome(String item) throws InterruptedException {
        restaurantUI.waitForCustom(3000);
        restaurantUI.clearUsingJavaScript(tbx_homeSearch);
        restaurantUI.click(tbx_homeSearch);
        restaurantUI.waitForCustom(2000);
        restaurantUI.sendKeys(tbx_homeSearch, item);
        restaurantUI.waitForCustom(4000);
    }
    public void clickSearchHome()throws InterruptedException{
        restaurantUI.click(btn_homeSearch);
    }
    public boolean isEditItemPopupDisplayed(){
        restaurantUI.waitForVisibility(txt_editItem);
        return restaurantUI.isDisplayed(txt_editItem);
    }
    public void clickOnCaseUnit()throws InterruptedException{
        restaurantUI.waitForClickability(caseUnit);
        restaurantUI.clickUsingJavaScript(caseUnit);
    }
    public boolean isMultiUomDropDownDisplayed(String code)throws InterruptedException{
        restaurantUI.waitForCustom(5000);
        return restaurantUI.isDisplayed(By.xpath(multiUomDropDownIndicator.replace("CODE", code)));
    }
    public void clickSaveOnUOMEditor(){
        restaurantUI.waitForClickability(saveItemBtn);
        restaurantUI.clickUsingJavaScript(saveItemBtn);
        try {
            restaurantUI.waitForCustom(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isRecentOrderTextDisplayed()throws InterruptedException{
        restaurantUI.scrollToElement(txt_recentOrder);
        return restaurantUI.isDisplayed(txt_recentOrder);
    }
    public boolean isDoNotSubstituteTextDisplay()throws InterruptedException{
        return restaurantUI.isDisplayed(txt_doNotSubstitute);
    }
    public void clickClosePopUp(){
        restaurantUI.waitForVisibility(btn_close_);
        restaurantUI.click(btn_close_);
    }
    public boolean isLastColumnDisplay(String column)throws InterruptedException{
        return restaurantUI.isDisplayed(By.xpath(lastColumn.replace("COLUMN",column)));
    }
    public void clickOnCustomerCode(String code) {
        restaurantUI.click(By.xpath(txt_customerCode.replace("CODE", code)));
    }
    public void clickOnEditAccHolds(){
        try {
            restaurantUI.waitForCustom(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        restaurantUI.waitForVisibility(btn_editAccHold);
        restaurantUI.click(btn_editAccHold);
    }
    public void clickOnAccDropdown(){
        restaurantUI.waitForVisibility(dropdown_acc);
        restaurantUI.click(dropdown_acc);
    }
    public void clickOnHardHold(){
        restaurantUI.waitForVisibility(txt_hardHold);
        restaurantUI.click(txt_hardHold);
    }
    public void clickOnSaveDP(){
        restaurantUI.waitForVisibility(btn_save_DP);
        restaurantUI.clickWithFallback(btn_save_DP);
        try {
            restaurantUI.waitForCustom(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isHardHoldSelected(){
        return restaurantUI.isDisplayed(lbl_hardHold);
    }
    public boolean isAccountHoldPopUpDisplay()throws InterruptedException{
        return restaurantUI.isDisplayed(accountOnHold);
    }
    public boolean isAccountHoldMessageDisplay(String message)throws InterruptedException{
        return restaurantUI.isDisplayed(By.xpath(accountHoldMessage.replace("MESSAGE",message)));
    }
    public void increaseFirstRowQtySpecificCustomer() throws InterruptedException {
        restaurantUI.click(btn_increaseQtyFirstRow);
    }
    public boolean isDeliveryDateOrderHistoryDisplayed(String id , String date){
        return restaurantUI.isDisplayed(By.xpath(deliveryDateOrderHistory.replace("ID", id).replace("DATE",date)));
    }
    public void clickOnPickUpDateStable() throws InterruptedException{
        restaurantUI.waitForCustom(4000);
        restaurantUI.click(btn_pickUpDateStable);
    }
    public boolean isFulfilmentTypeOrderHistoryDisplayed(String id , String type){
        return restaurantUI.isDisplayed(By.xpath(fulfillmentTypeOrderHistory.replace("ID", id).replace("TYPE",type)));
    }
    public void selectDeliveryDateLineStable(String day, boolean isNextMonth) throws InterruptedException {
        if (isNextMonth) {
            restaurantUI.click(btn_nextMonth);
            restaurantUI.waitForCustom(1000); // wait after clicking next month
        }

        By lbl_selectStartDate = By.xpath(dynamicToXPathStable.replace("DAY", day));
        restaurantUI.waitForVisibility(lbl_selectStartDate);
        restaurantUI.click(lbl_selectStartDate);
        restaurantUI.waitForCustom(5000);
    }
    public boolean isReviewOrderFulfilmentTypeDisplayed(String type){
        return restaurantUI.isDisplayed(By.xpath(reviewOrderFulfilment.replace("TYPE",type)));
    }
    public boolean isEditOrderGuideOptionDisplay()throws InterruptedException{
        return restaurantUI.isDisplayed(btn_edit);
    }
    public boolean isAddFromCatalogHeartItemDisplay(){
        return restaurantUI.isDisplayed(btn_addToOrderGuide);
    }
    public void clickOnDeleteOrderGuide(){
        restaurantUI.waitForClickability(btn_deleteOrderGuide);
        restaurantUI.click(btn_deleteOrderGuide);
    }
    public boolean isPurchaseHistoryDisplay(){
        return restaurantUI.isDisplayed(txt_purchaseHistoryCatalog);
    }
    public boolean isLastOrderDisplay(String order){
        return restaurantUI.isDisplayed(By.xpath(lastOrderDetails.replace("ORDER",order)));
    }
    public void clickLastOrderDetailsCatalog(String name)throws InterruptedException{
        restaurantUI.click(By.xpath(lbl_lastOrderDetails.replace("NAME",name)));
    }
    public void clickLastOrderOG(String code)throws InterruptedException{
        restaurantUI.click(By.xpath(purchaseHistoryOG.replace("CODE",code)));
    }
    public boolean isSpecialOrderNoteDisplay(String note)throws InterruptedException{
        return restaurantUI.isDisplayed(By.xpath(txt_specialOrderNote.replace("NOTE",note)));
    }
    public void clickOGDropdown(){
        restaurantUI.waitForVisibility(lbl_orderGuide);
        restaurantUI.click(lbl_orderGuide);
    }
    public void selectOrderGuide(String name){
        restaurantUI.waitForVisibility(By.xpath(dropDownOrderGuide.replace("NAME",name)));
        restaurantUI.click(By.xpath(dropDownOrderGuide.replace("NAME",name)));
    }
    public void clickCatalogListView(){
        restaurantUI.click(btn_listView);
    }
    public boolean isAddToOrderGuideListViewDisplay(){
        return restaurantUI.isDisplayed(btn_addToOrderGuideListView);
    }
    public void clickLocationGuide(){
        restaurantUI.click(lbl_locationGuide);
    }
    public boolean IsLocationOrderGuideDisplay(String name){
       return restaurantUI.isDisplayed(By.xpath(dropDownLocationOrderGuide.replace("NAME",name)));
    }
    public void clickEditCatalogAccess(){
        restaurantUI.click(catalogAccessEditBtn);
    }
    public void clickOnDisableCatalogAccessOption(){
        restaurantUI.click(catalogAccessEnableOption);
        restaurantUI.waitForVisibility(catalogAccessDisableOption);
        restaurantUI.click(catalogAccessDisableOption);
    }

    public void clickOnEnableCatalogAccessOption(){
        restaurantUI.click(catalogAccessDisableOption);
        restaurantUI.waitForVisibility(catalogAccessEnableOption);
        restaurantUI.click(catalogAccessEnableOption);
    }
    public boolean isCatalogAccessEnableDisplayed(){
        return restaurantUI.isDisplayed(lbl_catalogAccessEnable,10);
    }
    public boolean isCatalogAccessDisabled(){
        restaurantUI.refreshPage();
        return restaurantUI.isDisplayed(catalogAccessDisableTxt);
    }
    public boolean isCatalogButtonDisplay() {
        return restaurantUI.isDisplayed(btn_catalog);
    }
    public void typePONumber(String poNumber) throws InterruptedException {
        restaurantUI.waitForCustom(3000);
        restaurantUI.clear(txt_poNumber);
        restaurantUI.sendKeys(txt_poNumber,poNumber);
    }
    public boolean isPONumberErrorDisplay(String error){
        return restaurantUI.isDisplayed(By.xpath(pONumberError.replace("ERROR", error)));
    }
    public boolean isCatalogFilterDisplayed(String filter){
        return restaurantUI.isDisplayed(By.xpath(catalogFilter.replace("FILTER", filter)));
    }
    public void clickCatalogFilter(String filter)throws InterruptedException{
        restaurantUI.click(By.xpath(catalogFilter.replace("FILTER", filter)));
    }
    public boolean isCatalogFilterTagDisplayed(String tag){
        return restaurantUI.isDisplayed(By.xpath(catalogFilterTag.replace("TAG", tag)));
    }
    public boolean isEditOrderGuideTextCatalogDisplayed() {
        return restaurantUI.isDisplayed(txt_editOrderGuideCatalog);
    }
    public boolean isCatalogNewArrivalFilterTagDisplayed(String tag){
        return restaurantUI.isDisplayed(By.xpath(catalogFilterTagNewArrival.replace("TAG", tag)));
    }
    public boolean isCatalogFilterDisplayTag(String name,String tag){
        return restaurantUI.isDisplayed(By.xpath(newItemTagCatalog.replace("NAME", name).replace("TAG",tag)));
    }
    public boolean isOrderGuideItemTagDisplayTag(String name,String tag){
        return restaurantUI.isDisplayed(By.xpath(itemTagOG.replace("NAME", name).replace("TAG",tag)));
    }
    public boolean isPDPItemDisplayTag(String name,String tag){
        return restaurantUI.isDisplayed(By.xpath(newItemTagPDP.replace("NAME", name).replace("TAG",tag)));
    }
    public boolean isCatalogSearchItemCodeDisplay(String code){
        return restaurantUI.isDisplayed(By.xpath(catalogSearchItemCode.replace("CODE", code)));
    }
    public void clickCartSummery()throws InterruptedException{
        restaurantUI.click(btn_cartSummery);
    }
    public boolean isCartSummaryDisplay(String count){
        return restaurantUI.isDisplayed(By.xpath(cartSummary.replace("COUNT", count)));
    }
    public boolean isCartSummaryValueDisplay(String name){
        return restaurantUI.isDisplayed(By.xpath(cartSummaryValue.replace("NAME", name)));
    }
    public void clickMenu()throws InterruptedException{
        restaurantUI.click(btn_menu);
    }
    public boolean isUserNameDisplay(String name){
        return restaurantUI.isDisplayed(By.xpath(txt_userName.replace("NAME", name)));
    }
    public boolean isDistributorNameDisplay(String name){
        return restaurantUI.isDisplayed(By.xpath(txt_distributorName.replace("NAME", name)));
    }
    public void clickCloseMenu()throws InterruptedException{
        restaurantUI.click(btn_closeMenu);
    }
    public void clickOnPlusIconInCatalogStable(String name){
        restaurantUI.waitForVisibility(By.xpath(btn_catalogPlusStable.replace("NAME", name)));
        restaurantUI.click(By.xpath(btn_catalogPlusStable.replace("NAME", name)));
    }
    public void clickSendToERP()throws InterruptedException{
        restaurantUI.click(btn_sendERP);
    }
    public boolean isSendToERPButtonDisplayed()throws InterruptedException{
        return restaurantUI.isDisplayed(btn_sendERP);
    }
    public boolean isNotesToCustomerDisplayed(String note){
        return restaurantUI.isDisplayed(By.xpath(txt_notesToCustomer.replace("NOTE",note)));
    }
    public boolean isSubmitERPPopUpDisplayed()throws InterruptedException{
        return restaurantUI.isDisplayed(txt_submitERP);
    }
    public boolean isOrderSentERPPopUpDisplayed()throws InterruptedException{
        return restaurantUI.isDisplayed(txt_OrderSentERP);
    }
    public boolean isOrderSubmissionStepDisplayed(String step){
        return restaurantUI.isDisplayed(By.xpath(txt_OrderSubmissionStep.replace("STEP",step)));
    }
    public void clickOnTimeline() {
        restaurantUI.clickUsingJavaScript(btn_timeline);
    }
    public void clickConfirm(){
        restaurantUI.waitForClickability(btn_confirm);
        restaurantUI.click(btn_confirm);
    }
    public void clickSubmittedOrder(String id){
        restaurantUI.click(By.xpath(submittedOrder.replace("ID", id)));
    }
    public void clickSimpleListView(){
        restaurantUI.waitForClickability(dropdown_option_SimpleListView);
        restaurantUI.click(dropdown_option_SimpleListView);
    }
    public boolean isSimpleListViewTextDisplay()throws InterruptedException{
        return restaurantUI.isDisplayed(txt_simpleListView);
    }
    public void clickSortOptionOG(String option)throws InterruptedException{
        restaurantUI.click(By.xpath(sortOptionOG.replace("OPTION",option)));
    }
    public boolean isSortOptionDisplay(String option)throws InterruptedException{
        restaurantUI.waitForCustom(2000);
        return restaurantUI.isDisplayed(By.xpath(sortResult.replace("OPTION",option)));
    }
    public void selectSortOptions(){
        restaurantUI.waitForVisibility(dropdown_SortOptions);
        restaurantUI.click(dropdown_SortOptions);
    }
    public void clickOnProductStable(String name){
        restaurantUI.scrollToElementStable(By.xpath(txt_productStable.replace("NAME", name)));
        restaurantUI.waitForVisibility(By.xpath(txt_productStable.replace("NAME", name)));
        restaurantUI.clickUsingJavaScript(By.xpath(txt_productStable.replace("NAME", name)));
    }
    public void clickOnPlusIconCatalogStable(String name){
        restaurantUI.scrollToElement(By.xpath(txt_productStableAddToCart.replace("NAME", name)));
        restaurantUI.waitForVisibility(By.xpath(txt_productStableAddToCart.replace("NAME", name)));
        restaurantUI.click(By.xpath(txt_productStableAddToCart.replace("NAME", name)));
    }
    public void clickOnUploadOrder() {
        restaurantUI.waitForClickability(btn_uploadOrder);
        restaurantUI.click(btn_uploadOrder);
    }
    public boolean isUploadToOrderTextDisplay()throws InterruptedException{
        return restaurantUI.isDisplayed(txt_uploadToOrder);
    }
    public String getItemQuantity(String code){
        return restaurantUI.getText(By.xpath(tbx_itemQuantity.replace("CODE", code)), "value");
    }
    public void clickRecentSubmitOrder(String id)throws InterruptedException{
        restaurantUI.scrollToElementStable(By.xpath(btn_editRecentOrder.replace("ORDERID",id)));
        restaurantUI.clickUsingJavaScript(By.xpath(btn_editRecentOrder.replace("ORDERID",id)));
    }
    public boolean isRecentSubmitOrderDisplay(String id)throws InterruptedException{
        return restaurantUI.isDisplayed(By.xpath(btn_editRecentOrder.replace("ORDERID",id)));
    }
    public boolean isRecentSubmitOrderQuantityDisplay(String id,String quantity)throws InterruptedException{
        return restaurantUI.isDisplayed(By.xpath(btn_editRecentOrderQuantity.replace("ORDERID",id).replace("QUANTITY",quantity)));
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
        restaurantUI.click(dropdown_option_QuickAdd);
    }
    public boolean isQuickAddViewDisplay()throws InterruptedException{
        return restaurantUI.isDisplayed(txt_QuickAddView);
    }
    public boolean isQuickAddOptionDisplay()throws InterruptedException{
        return restaurantUI.isDisplayed(dropdown_option_QuickAdd);
    }
    public void enterItemCodeQuickAdd(String code)throws InterruptedException{
        restaurantUI.click(lbl_itemCode);
        restaurantUI.sendKeys(lbl_itemCode,code);
    }
    public void enterItemQuantity(String code)throws InterruptedException{
        restaurantUI.click(lbl_itemQuantity);
        restaurantUI.sendKeys(lbl_itemQuantity,code);
    }
    public void clickVerifyItem()throws InterruptedException{
        restaurantUI.click(btn_verifyItem);
    }
    public void clickSaveAndReview()throws InterruptedException{
        restaurantUI.waitForCustom(5000);
        restaurantUI.click(btn_saveAndReview);
    }
    public boolean isPreviousDraftOrderNoDisplayedSub() throws InterruptedException {
        return restaurantUI.isDisplayed(btn_previousDraftOrderNo,5);
    }
    public String getItemQuantityReviewPage(String code){
        restaurantUI.waitForVisibility(By.xpath(quantityReviewPage.replace("CODE",code)));
        return restaurantUI.getText(By.xpath(quantityReviewPage.replace("CODE",code)), "value");
    }
    public void clickOrderGuideView(){
        restaurantUI.waitForClickability(dropdown_option_OrderGuideView);
        restaurantUI.click(dropdown_option_OrderGuideView);
    }
    public String getItemQuantitySimpleListView(String code){
        restaurantUI.waitForVisibility(By.xpath(quantitySimpleListView.replace("CODE",code)));
        return restaurantUI.getText(By.xpath(quantitySimpleListView.replace("CODE",code)), "value");
    }
    public void clearSearchField()throws InterruptedException{
        restaurantUI.click(icon_deleteSearchItem);
        restaurantUI.waitForCustom(3000);
    }
    public boolean isItemVerifiedPopUpDisplay()throws InterruptedException{
        restaurantUI.waitForCustom(5000);
        return restaurantUI.isDisplayed(txt_itemVerified);
    }
    public void clickPlusQryFirstRowStable(){
        restaurantUI.click(btn_increaseQtyFirstRowStable);
    }
    public boolean isManageStandingOrdersDisplay()throws InterruptedException{
        return restaurantUI.isDisplayed(dropdown_option_ManageStandingOrders);
    }
    public void clickManageStandingOrders()throws InterruptedException{
        restaurantUI.click(dropdown_option_ManageStandingOrders);
        restaurantUI.waitForCustom(4000);
    }
    public boolean isManageStandingOrdersPopUpDisplay()throws InterruptedException{
        return restaurantUI.isDisplayed(txt_ManageStandingOrders);
    }
    public boolean isCreateStandingOrdersButtonDisplay()throws InterruptedException{
        return restaurantUI.isDisplayed(btn_CreateStandingOrders);
    }
    public void clickCreateStandingOrders()throws InterruptedException{
        restaurantUI.click(btn_CreateStandingOrders);
        restaurantUI.waitForCustom(4000);
    }
    public void clickOnRemoveDelivery() {
        if (restaurantUI.isDisplayed(btn_removeDelivery)){
            restaurantUI.click(btn_removeDelivery);
        }
    }
    public void clickOnDropdownDelivery() {
        restaurantUI.click(dropdown_delivery);
    }
    public void clickOnDeliveryDateStanding(String day) {
        restaurantUI.waitForVisibility(By.xpath(txt_deliveryDay.replace("DAY", day)));
        restaurantUI.click(By.xpath(txt_deliveryDay.replace("DAY", day)));
        restaurantUI.waitForElementEnabledState(By.xpath(txt_deliveryDay.replace("DAY", day)),true);
    }
    public void clickOnDeliveryDateAsLastBefore() {
        restaurantUI.waitForVisibility(By.xpath(txt_deliveryLastBeforeDay));
        restaurantUI.click(By.xpath(txt_deliveryLastBeforeDay));
        restaurantUI.waitForElementEnabledState(By.xpath(txt_deliveryLastBeforeDay),true);
    }
    public void setStandingOrder(){
        restaurantUI.waitForElementEnabledState(btn_setStandingOrder,true);
        restaurantUI.waitForClickability(btn_setStandingOrder);
        try {
            restaurantUI.waitForCustom(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        restaurantUI.click(btn_setStandingOrder);
    }
    public void resetStandingOrder(){
        restaurantUI.waitForElementEnabledState(btn_resetStandingOrder,true);
        restaurantUI.waitForClickability(btn_resetStandingOrder);
        restaurantUI.click(btn_resetStandingOrder);
    }
    public boolean isStandingOrderSuccessPopupDisplayed(){
        restaurantUI.waitForVisibility(txt_success);
        return restaurantUI.isDisplayed(txt_success);
    }
    public boolean isReviewStandingOrdersDisplayed(){
        restaurantUI.waitForVisibility(txt_reviewStandingOrders);
        return restaurantUI.isDisplayed(txt_reviewStandingOrders);
    }
    public void clickOnStandingOrderEditIcon() throws InterruptedException {
        restaurantUI.waitForVisibility(btn_editStandingOrderIcon);
        restaurantUI.clickWithFallback(btn_editStandingOrderIcon);
        restaurantUI.waitForCustom(3000);
    }
    public void clickOnStandingOrderDeleteIcon() throws InterruptedException {
        restaurantUI.waitForVisibility(btn_deleteStandingOrderIcon);
        restaurantUI.clickWithFallback(btn_deleteStandingOrderIcon);
        restaurantUI.waitForVisibility(txt_deletePopup);
        restaurantUI.waitForClickability(btn_yes);
        restaurantUI.click(btn_yes);
        restaurantUI.waitForCustom(2000);

    }
    public boolean isStandingOrdersDeletedIconDisplay(){
        return restaurantUI.isDisplayed(btn_deleteStandingOrderIcon);
    }
    public boolean isSubmittedStandingOrderDisplayed(String quantity ,String price) {
        try {
            restaurantUI.waitForVisibility(By.xpath(standingOrder.replace("QUANTITY", quantity).replace("PRICE", price)));
        } catch (Exception e) {
            return false;
        }
        return restaurantUI.isDisplayed(By.xpath(standingOrder.replace("QUANTITY", quantity).replace("PRICE", price)));
    }
    public void clickOnStandingOrderPauseIcon() throws InterruptedException {
        restaurantUI.waitForVisibility(btn_pauseStandingOrderIcon);
        restaurantUI.clickWithFallback(btn_pauseStandingOrderIcon);
        restaurantUI.waitForCustom(3000);
    }
    public boolean isStandingOrdersPaused(){
        return restaurantUI.isDisplayed(txt_pausedStandingOrders);
    }
    public void clickOnStandingOrderResumeIcon() throws InterruptedException {
        restaurantUI.waitForVisibility(btn_resumeStandingOrderIcon);
        restaurantUI.clickWithFallback(btn_resumeStandingOrderIcon);
        restaurantUI.waitForCustom(3000);
    }
    public void clickAddToRecentSubmitOrder(String id)throws InterruptedException{
        restaurantUI.scrollToElementStable(By.xpath(btn_addToRecentOrder.replace("ORDERID",id)));
        restaurantUI.clickUsingJavaScript(By.xpath(btn_addToRecentOrder.replace("ORDERID",id)));
    }
    public void increaseReviewQtyStable(String code){
        restaurantUI.click(By.xpath(increaseQuantityReviewPage.replace("CODE",code)));
    }
    public void decreaseReviewQtyStable(String code){
        restaurantUI.click(By.xpath(decreaseQuantityReviewPage.replace("CODE",code)));
    }
    public boolean isTrashCanReviewPage(String code){
        return restaurantUI.isDisplayed(By.xpath(trashCanReviewPage.replace("CODE",code)));
    }
    public boolean isRecentAddedOrderDisplay(String id)throws InterruptedException{
        return restaurantUI.isDisplayed(By.xpath(btn_addRecentOrder.replace("ORDERID",id)));
    }
    public void editCalculateOrderQty(){
        restaurantUI.click(btn_calculateOrderQty);
    }
    public boolean isCalculateOrderQtyDisplayed(){
        return restaurantUI.isDisplayed(lbl_calculateOrderQty);
    }
    public void enterParValue(String num) throws InterruptedException {
        restaurantUI.clearUsingJavaScript(lbl_parValue);
        restaurantUI.sendKeys(lbl_parValue, num);
        restaurantUI.waitForCustom(1000);
    }
    public void enterOnSiteInvValue(String num) throws InterruptedException {
        restaurantUI.clearUsingJavaScript(lbl_OnSiteInvValue);
        restaurantUI.sendKeys(lbl_OnSiteInvValue, num);
        restaurantUI.waitForCustom(1000);
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
        restaurantUI.waitForCustom(4000);
        restaurantUI.click(btn_clearAll);
    }
    public String getCartSummeryValue(String option) throws InterruptedException {
        restaurantUI.waitForVisibility(By.xpath(cartSummeryValue.replace("OPTION",option)));
        restaurantUI.waitForCustom(3000);
        String rawText = restaurantUI.getText(By.xpath(cartSummeryValue.replace("OPTION",option)));
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
        restaurantUI.waitForVisibility(priceLocator);
        String tagName = restaurantUI.getElement(priceLocator).getTagName();
        String priceText;

        if (tagName.equals("input")) {
            priceText = restaurantUI.getText(priceLocator, "value");
        } else if (tagName.equals("div")) {
            priceText = restaurantUI.getText(priceLocator);
        } else {
            priceText = restaurantUI.getText(priceLocator);
        }

        System.out.println("Extracted Price: " + priceText);
        priceText = priceText.replace(":", "").replace("$", "").split("/")[0].trim();

        return Double.valueOf(priceText);
    }
    public boolean isPreAuthorizationTextDisplay(String message)throws InterruptedException{
        return restaurantUI.isDisplayed(By.xpath(txt_preAuthorization.replace("MESSAGE",message)));
    }
    public boolean isConfirmPaymentTextDisplay()throws InterruptedException{
        return restaurantUI.isDisplayed(txt_confirmPayment);
    }
    public void clickContinue(){
        restaurantUI.click(btn_continue);
    }
    public void clickSortOptionsOG(String option)throws InterruptedException{
        restaurantUI.click(By.xpath(sortOptionsOG.replace("OPTION",option)));
    }
    public void clickDeliveryTo()throws InterruptedException{
        restaurantUI.click(lbl_deliveryTo);
    }
    public int isDeliveryAddressDisplay() throws InterruptedException {
        return restaurantUI.countDisplayedElements(deliveryAddress);
    }
    public void clickDeliveryAddress()throws InterruptedException{
        restaurantUI.click(deliveryAddressOption);
    }
    public boolean isSingleAddressDisplay()throws InterruptedException{
        return restaurantUI.isDisplayed(singleDeliveryAddress);
    }
    public void clickAccHoldCloseIcon(){
        restaurantUI.waitForVisibility(btn_accHoldClose_);
        restaurantUI.click(btn_accHoldClose_);
    }
    public boolean isAccountHoldPopUpDisplay(String message)throws InterruptedException{
        return restaurantUI.isDisplayed(By.xpath(accountOnHoldBanner.replace("MESSAGE",message)));
    }
    public void selectDistributorCenter(String center)throws InterruptedException{
        restaurantUI.click(By.xpath(distributorCenter.replace("CENTER",center)));
        restaurantUI.waitForCustom(3000);
    }
    public boolean isCatalogFilterDisplayTagList(String name,String tag){
        return restaurantUI.isDisplayed(By.xpath(listViewTag.replace("NAME", name).replace("TAG",tag)));
    }
    public boolean IsChangeLocationOrderGuideDisplay(String name){
        return restaurantUI.isDisplayed(By.xpath(orderGuideLocation.replace("NAME",name)));
    }
    public boolean isCustomerOrderGuideDisplayed(){
        return restaurantUI.isDisplayed(btn_catalogToOrderGuide);
    }
    public boolean isCatalogDisplayed(){
        return restaurantUI.isDisplayed(txtCatalog);
    }
    public void clickPlaceOrderSoftOrderMinimum(){
        restaurantUI.click(btn_placeOrderSoftOrderMinimum);
    }
    public void selectOrderMinimum(String orderMinimum){
        restaurantUI.click(orderMinimumeditBtn);
        if(!restaurantUI.isCheckboxOrRadioBtnSelected(By.xpath(orderMinimumSelectionRadioBtn.replace("ORDERMINIMUM",orderMinimum)))){
            restaurantUI.click(By.xpath(orderMinimumSelectionRadioBtn.replace("ORDERMINIMUM",orderMinimum)));
            restaurantUI.click(btn_saveEditShipAddress);
        }
        restaurantUI.click(orderMinimumOverlayCloseBtn);
    }
    public boolean isCustomerOnHold(){
        return restaurantUI.isDisplayed(customer_Holds);
    }
    public void clickOnNone(){
        restaurantUI.waitForVisibility(txt_none);
        restaurantUI.click(txt_none);
    }






}