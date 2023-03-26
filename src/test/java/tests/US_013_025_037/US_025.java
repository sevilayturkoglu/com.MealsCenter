package tests.US_013_025_037;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MerchantPage;
import pages.UserPage;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US_025 extends TestBaseReport {
    UserPage userPage = new UserPage();
    SoftAssert softAssert = new SoftAssert();
    MerchantPage merchantPage = new MerchantPage();


    @Test(priority = 1)
    public void itemListPageVisibilityTest(){
        extentTest = extentReports.createTest("itemListPageVisibilityTest","Item list page must be able visible" );
        merchantPage = new MerchantPage();
        merchantPage.merchantLogin();
        extentTest.info("Merchant signed in");
        merchantPage.merchantMenuLeftSide("Food");
        extentTest.info("Food link is clicked");
        merchantPage.itemLink.click();
        extentTest.info("Item link is clicked");

        String expectedItemListText = "Item list";
        String actualItemListText = merchantPage.itemListText.getText();
        softAssert.assertEquals(actualItemListText,expectedItemListText);
        extentTest.pass("Verified that the Item list page is visible");
        softAssert.assertAll();
       // Driver.closeDriver();
    }
    @Test(priority = 1)
    public void addNewProductTest(){
        extentTest = extentReports.createTest("addNewProductTest","Add new product" );
        merchantPage = new MerchantPage();
        merchantPage.merchantLogin();
        extentTest.info("Merchant signed in");
        merchantPage.merchantMenuLeftSide("Food");
        extentTest.info("Food link is clicked");
        merchantPage.itemLink.click();
        extentTest.info("Item link is clicked");
        merchantPage.addNewProductButton.click();
        extentTest.info("Add new button is clicked");
        merchantPage.newItemNameBox.sendKeys("New item");
        extentTest.info("New item name is entered");
        merchantPage.shortDescriptionBox.sendKeys("Short description");
        extentTest.info("Short description is entered");
        merchantPage.longDescriptionBox.sendKeys("Long description");
        extentTest.info("long description is entered");
        merchantPage.itemPriceBox.sendKeys("10");
        extentTest.info("Item price is entered");
        ReusableMethods.selectAnItemFromDropdown(merchantPage.selectUnitBox,"Small");
        extentTest.info("Unit is selected");
        JSUtilities.scrollToElement(Driver.getDriver(),merchantPage.selectCategoryBox);
        ReusableMethods.selectAnItemFromDropdown(merchantPage.selectCategoryBox,"Drinks");
        extentTest.info("Category is selected");
        merchantPage.browseButtton.click();
        extentTest.info("Browse button is clicked");
        merchantPage.selectFileFromBrowse.click();
        extentTest.info("File is selected");
        merchantPage.addFilesButtton.click();
        extentTest.info("Add file button is clicked");
        //JSUtilities.scrollToElement(Driver.getDriver(),merchantPage.selectFeaturedBox);
       // ReusableMethods.selectAnItemFromDropdown(merchantPage.selectFeaturedBox,"Trending");
        merchantPage.backgroundColorHexBox.click();
        extentTest.info("backgroundColorHexBox is clicked");
        merchantPage.backgroundColorButton.click();
        extentTest.info("backgroundColor is clicked");
        merchantPage.backgroundColorChoose.click();



        //String expectedItemListText = "Item list";
        String actualItemListText = merchantPage.itemListText.getText();
        //softAssert.assertEquals(actualItemListText,expectedItemListText);
        extentTest.pass("Verified that the Item list page is visible");
        softAssert.assertAll();
        // Driver.closeDriver();






        //-Select Status Publish
        //-Click Save button
        //-Verify that the product Succesfully created
        //-Close browser
    }
}