package tests.US_013_025_037;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MerchantPage;
import pages.UserPage;
import utilities.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class US_013 extends TestBaseReport {

    UserPage userPage = new UserPage();
    SoftAssert softAssert = new SoftAssert();
    MerchantPage merchantPage = new MerchantPage();


    @Test
    public void productAddtoCartTest(){
        extentTest = extentReports.createTest("productAddtoCartTest","a product must be able to be added to \n" +
                "the cart" );


        userPage = new UserPage();
        userPage.userLoginBeing();
        extentTest.info("User signed in");
        //userPage.userLogo.click();

        JSUtilities.clickWithJS(Driver.getDriver(),merchantPage.merchantMcDonaldsLink);
        JSUtilities.clickWithJS(Driver.getDriver(),merchantPage.addToCartButton);
        merchantPage.checkoutButton.click();

        String expectedProductText = "Oven-Roasted Turkey";
        String actualProductText = merchantPage.cartText.getText();
        softAssert.assertEquals(actualProductText,expectedProductText);

        /*

        -Click on Home page sign in link
        -Enter the registered e-mail in the e-mail box
        -Enter the registered password in the password box.
        -Click the Sign-in button

        -Click on Merchant link

        -Click on the Add to cart button

        - Click the Checkout button
        -Verify  that the product appears on the cart
        -Close browser

         */
        softAssert.assertAll();
        Driver.closeDriver();

    }

}
