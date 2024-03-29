package tests.US_013_025_037;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MerchantPage;
import pages.UserPage;
import utilities.*;

public class US_013 extends TestBaseReport {

    UserPage userPage = new UserPage();
    SoftAssert softAssert = new SoftAssert();
    MerchantPage merchantPage = new MerchantPage();


    @Test
    public void TC_01301_ProductAddtoCartTest(){
        merchantPage = new MerchantPage();
        extentTest = extentReports.createTest("productAddtoCartTest","A product must be able to be added to \n" +
                "the cart" );
        userPage = new UserPage();
        merchantPage = new MerchantPage();
        userPage.userLoginBeing();
        extentTest.info("User signed in");
        ReusableMethods.wait(5);
        JSUtilities.clickWithJS(Driver.getDriver(),merchantPage.merchantSubwayLink);
        extentTest.info("Subway link is clicked");
        merchantPage.addToCartButton.click();
        extentTest.info("Add to cart link is clicked");
        merchantPage.checkoutButton.click();
        extentTest.info("Checkout link is clicked");
        String expectedProductText = "Oven-Roasted Turkey";
        String actualProductText = merchantPage.cartText.getText();
        softAssert.assertEquals(actualProductText,expectedProductText);
        extentTest.pass("Verified  that the product appears on the cart");
        softAssert.assertAll();
         //Driver.closeDriver();
    }
    @Test
    public void TC_01302_PaymentTest(){
        merchantPage = new MerchantPage();
        extentTest = extentReports.createTest("paymentTest"," the payment must be able to be made");
        userPage = new UserPage();
        userPage.userLoginBeing();
        merchantPage=new MerchantPage();
        extentTest.info("User signed in");
        JSUtilities.clickWithJS(Driver.getDriver(),merchantPage.merchantSubwayLink);
        extentTest.info("Subway link is clicked");
        merchantPage.addToCartButton.click();
        extentTest.info("Add to cart link is clicked");
        merchantPage.checkoutButton.click();
        extentTest.info("Checkout link is clicked");
        JSUtilities.clickWithJS(Driver.getDriver(),merchantPage.cashOnDeliveryLink);
        extentTest.info("Cash On delivery link is clicked");
        merchantPage.addCashButton.click();
        extentTest.info("Add cash button is clicked");
        String expectedPaymentMethodText = "Default";
        String actualPaymentMethodText = merchantPage.paymentMethodDefault.getText();
        softAssert.assertTrue(actualPaymentMethodText.contains(expectedPaymentMethodText));
        ReusableMethods.bekle(1);
        extentTest.pass("Verified  that Cash On delivery is default");
        softAssert.assertAll();
        //Driver.closeDriver();
    }
    @Test
    public void TC_01303_addressTest(){
        merchantPage = new MerchantPage();
        extentTest = extentReports.createTest("addressTest"," An address must be able to be entered");
        userPage = new UserPage();
        merchantPage = new MerchantPage();
        userPage.userLoginBeing();
        extentTest.info("User signed in");
        JSUtilities.clickWithJS(Driver.getDriver(),merchantPage.merchantSubwayLink);
        extentTest.info("Subway link is clicked");
        merchantPage.addToCartButton.click();
        extentTest.info("Add to cart link is clicked");
        merchantPage.checkoutButton.click();
        extentTest.info("Checkout link is clicked");
        JSUtilities.clickWithJS(Driver.getDriver(),merchantPage.addNewAddressLink);
        extentTest.info("Add new address link is clicked");
        merchantPage.enterDeliveryAddressBox.sendKeys("11");
        extentTest.info("Entered new address");
        ReusableMethods.waitForVisibility(userPage.userChooseAddres,10);
        JSUtilities.clickWithJS(Driver.getDriver(),merchantPage.addNewAddressLink);
        merchantPage.newSelectedAddress.click();
        extentTest.info("Clicked new address");
        merchantPage.newAddressSaveButton.click();
        extentTest.info("New address save button is clicked");
        JSUtilities.scrollToElement(Driver.getDriver(), merchantPage.savedAddressBox);
        String expectedNewAddressText = "11 Howard";
        String actualNewAddressText = merchantPage.savedAddressBox.getText();
        System.out.println(actualNewAddressText);
        softAssert.assertTrue(actualNewAddressText.contains(expectedNewAddressText));
        extentTest.pass("Verified that address is entered");
        softAssert.assertAll();
      // Driver.closeDriver();
    }
    @Test
    public void TC_01304_AvailableToPurchaseTest(){
        merchantPage = new MerchantPage();
        extentTest = extentReports.createTest("availableToPurchaseTest"," the product is available for purchase");
        userPage = new UserPage();
        merchantPage = new MerchantPage();
        userPage.userLoginBeing();
        extentTest.info("User signed in");
        ReusableMethods.wait(5);
        JSUtilities.clickWithJS(Driver.getDriver(),merchantPage.merchantSubwayLink);
        extentTest.info("Subway link is clicked");
        merchantPage.addToCartButton.click();
        extentTest.info("Add to cart link is clicked");
        merchantPage.checkoutButton.click();
        extentTest.info("Checkout link is clicked");
        JSUtilities.clickWithJS(Driver.getDriver(),merchantPage.cashOnDeliveryLink);
        extentTest.info("Cash On delivery link is clicked");
        merchantPage.addCashButton.click();
        extentTest.info("Add cash button is clicked");
        softAssert.assertTrue(merchantPage.placeOrderButton.isDisplayed());
        extentTest.pass("Verified that the product is available for purchase");
        ReusableMethods.bekle(1);
        softAssert.assertAll();
       // Driver.closeDriver();
    }
}

