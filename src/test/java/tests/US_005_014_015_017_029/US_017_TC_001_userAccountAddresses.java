package tests.US_005_014_015_017_029;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import utilities.*;

import java.time.Duration;

public class US_017_TC_001_userAccountAddresses extends TestBaseReport {

    /*
    As a user, I would like to have a page on the site
    where I can view, add, delete and change the payment information
    of my account.
     */

    UserPage userPage = new UserPage();
    SoftAssert softAssert = new SoftAssert();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void CrudUserPageTest(){

        userPage.userLoginSariye();
        extentTest = extentReports.createTest("User  Page Visibility Test", "User page of the user,should be visible.");
        extentTest.info("chrome browser and user page is active");
        ReusableMethods.bekle(3);
        extentTest.info("It is waited 3 seconds.");
        userPage.userUstDropDownButton.click();
        extentTest = extentReports.createTest("User dropdown menu ", "User dropdown,should be visible.");
        extentTest.info("user dropdown is active");
        ReusableMethods.bekle(3);
        userPage.userDDPaymentOptions.click();
        ReusableMethods.bekle(3);
        extentTest.info("User payment options is clicked.");

        String expectedResult = " Payments Options ";
        String actualResult = userPage.userDDPaymentOptions.getText();

        // adding cash payment
        userPage.userAddNewPaymentButton.click();
        ReusableMethods.bekle(3);

        userPage.userAddCashOnDeliveryButton.click();
        ReusableMethods.bekle(3);

        userPage.userAddCashButton.click();
        ReusableMethods.bekle(2);
        userPage.closeAddCashFrame.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        softAssert.assertTrue(wait.until(ExpectedConditions.invisibilityOf(userPage.closeAddCashFrame)));
        extentTest.info("cash payment option frame is closed");
        ReusableMethods.bekle(3);

        // adding stripe payment
        userPage.userAddStripeButton.click();
        actions.sendKeys(userPage.userAddCardNumberPlaceHolder);
        actions.sendKeys(ConfigReader.getProperty("validCardNumber")+ Keys.TAB);
        //Form body locatte kaldimgit branch










        // deleting cash payment method from account
        userPage.userCashPaymentDelete.click();








        // adding kaart
        //userPage.userAddNewPaymentButton.click();
        //ReusableMethods.bekle(3);







        /*
        String expectedPaymentMethodText = "Default";
        String actualPaymentMethodText = merchantPage.paymentMethodDefault.getText();
        softAssert.assertTrue(actualPaymentMethodText.contains(expectedPaymentMethodText));
        extentTest.pass("Verified  that Cash On delivery is default");
        softAssert.assertAll();

         */


    }


}
