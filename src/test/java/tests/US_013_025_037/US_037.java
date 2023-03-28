package tests.US_013_025_037;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminPage;
import pages.MerchantPage;
import pages.UserPage;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US_037 extends TestBaseReport {

    UserPage userPage = new UserPage();
    SoftAssert softAssert = new SoftAssert();
    AdminPage adminPage = new AdminPage();
    MerchantPage merchantPage = new MerchantPage();
    Actions actions = new Actions(Driver.getDriver());
    @Test(priority = 1)
    public void viewMerchantsListTest(){
        merchantPage = new MerchantPage();
        extentTest = extentReports.createTest("viewMerchantsListTest","An admin should be able to view\n" +
                "Merchants List" );
        adminPage = new AdminPage();
        adminPage.adminLoginOl();
        extentTest.info("Admin signed in");
        merchantPage.merchantMenuLeftSide("Merchant");
        extentTest.info("Merchant link is clicked");
        adminPage.listlink.click();
        extentTest.info("List link is clicked");
        String expectedText = "All Merchant";
        String actualText = adminPage.allMerchantText.getText();
        softAssert.assertEquals(actualText,expectedText);
        extentTest.pass("Verified that All Merchant is visible");
        softAssert.assertAll();
        //Driver.closeDriver();
    }
    @Test(priority = 10)
    public void changeInfoMerchantTest(){
        merchantPage = new MerchantPage();
        actions= new Actions(Driver.getDriver());
        extentTest = extentReports.createTest("changeInfoMerchantTest","An admin should be able to change\n" +
                "information about merchants" );
        adminPage = new AdminPage();
        adminPage.adminLoginOl();
        extentTest.info("Admin signed in");
        merchantPage.merchantMenuLeftSide("Merchant");
        extentTest.info("Merchant link is clicked");
        adminPage.listlink.click();
        extentTest.info("List link is clicked");
        actions.moveToElement(adminPage.autoLoginButton).perform();
        ReusableMethods.wait(3);
        adminPage.editMerchantButton.click();

        adminPage.merchantFromAllMerchant.click();
        extentTest.info("merchantFromAllMerchant link is clicked");
        softAssert.assertTrue(adminPage.merchantFromAllMerchant.isSelected());
        extentTest.pass("merchantFromAllMerchant link is selected");
        softAssert.assertAll();
        //Driver.closeDriver();
    }
    @Test(priority = 20)
    public void deleteInfoMerchantTest(){
        extentTest = extentReports.createTest("deleteInfoMerchantTest","An admin should be able to delete\n" +
                "information about merchants" );
        adminPage = new AdminPage();
        adminPage.adminLoginOl();
        extentTest.info("Admin signed in");
        merchantPage.merchantMenuLeftSide("Merchant");
        extentTest.info("Merchant link is clicked");
        adminPage.listlink.click();
        extentTest.info("List link is clicked");
        adminPage.merchantFromAllMerchant.click();
        extentTest.info("merchantFromAllMerchant link is clicked");
        softAssert.assertTrue(adminPage.merchantFromAllMerchant.isSelected());
        extentTest.pass("merchantFromAllMerchant link is selected");
        softAssert.assertAll();
        //Driver.closeDriver();
    }

}
