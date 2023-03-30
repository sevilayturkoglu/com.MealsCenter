package tests.US_013_025_037;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MerchantPage;
import pages.UserPage;
import utilities.*;
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
    public void TC_03701_ViewMerchantsListTest(){
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
    public void TC_03702_ChangeInfoMerchantTest(){
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
        extentTest.info("Edit link is clicked");
        adminPage.restaurantNameBox.clear();
        extentTest.info("Restaurant name box is cleaned");
        adminPage.restaurantNameBox.sendKeys("New Name");
        extentTest.info("New name is entered");
        adminPage.restaurantSlugBox.clear();
        extentTest.info("Restaurant slug box is cleaned");
        adminPage.restaurantSlugBox.sendKeys("New slug");
        extentTest.info("New slug is entered");
        adminPage.contactNameBox.clear();
        extentTest.info("contactNameBox is cleaned");
        adminPage.contactNameBox.sendKeys("New contact name");
        extentTest.info("New contact name is entered");
        adminPage.contactPhoneBox.clear();
        extentTest.info("contactPhoneBox is cleaned");
        adminPage.contactPhoneBox.sendKeys("+111123456789");
        extentTest.info("New contact phone is entered");
        adminPage.contactEmailBox.clear();
        extentTest.info("contactEmailBox is cleaned");
        adminPage.contactEmailBox.sendKeys("newemail@gmail.com");
        extentTest.info("New contact email is entered");
        adminPage.aboutBox.clear();
        extentTest.info("aboutBox is cleaned");
        adminPage.aboutBox.sendKeys("about");
        extentTest.info("New about is entered");
        adminPage.shortAboutBox.clear();
        extentTest.info("shortAboutBox is cleaned");
        adminPage.shortAboutBox.sendKeys("shortAboutBox");
        extentTest.info("shortAboutBox is entered");
        JSUtilities.scrollToElement(Driver.getDriver(),adminPage.shortAboutBox);
        ReusableMethods.wait(3);
        adminPage.cuisineBox.click();
        adminPage.cuisineBox.click();
        extentTest.info("cuisineBox is clicked");
        adminPage.BurgersLink.click();
        adminPage.BurgersLink.click();
        extentTest.info("BurgersLink is clicked");
        adminPage.servicesBox.click();
        extentTest.info("servicesBox is clicked");
        adminPage.pickupLink.click();
        extentTest.info("pickupLink is clicked");
        JSUtilities.scrollToBottom(Driver.getDriver());
        adminPage.featuredBox.click();
        extentTest.info("featuredBox is clicked");
        adminPage.popularLink.click();
        extentTest.info("popularLink is clicked");
        adminPage.deliveryDistanceBox.sendKeys("1123456789");
        extentTest.info("Delivery Distance is entered");
        ReusableMethods.selectAnItemFromDropdown(adminPage.statusBox,"active");
        ReusableMethods.wait(3);
        adminPage.saveButton.click();
        extentTest.info("saveButton is clicked");
        String expectedtext = "Succesfully updated";
        String actualText = adminPage.succesfullyUptadeText.getText();
        softAssert.assertEquals(actualText,expectedtext);
        extentTest.pass("Verified that merchant informations were succesfully updated");
        softAssert.assertAll();
        //Driver.closeDriver();

    }
    @Test(priority = 20)
    public void TC_03703_DeleteInfoMerchantTest(){
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
