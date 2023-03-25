package tests.US_013_025_037;

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
    public void productAddtoCartTest(){
        extentTest = extentReports.createTest("productAddtoCartTest","A product must be able to be added to \n" +
                "the cart" );


        userPage = new UserPage();
        userPage.userLoginBeing();
        extentTest.info("User signed in");


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
        Driver.closeDriver();

    }

}
