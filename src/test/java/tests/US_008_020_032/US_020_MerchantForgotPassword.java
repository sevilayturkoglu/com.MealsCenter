package tests.US_008_020_032;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MerchantPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US_020_MerchantForgotPassword  extends  TestBaseReport{

    MerchantPage merchantPage = new MerchantPage();
    SoftAssert softAssert = new SoftAssert();

    @Test(priority = 10)
    public void TC_2001_PositiveForgotPasswordTesti(){
        // 1-Launch browser

        merchantPage = new MerchantPage();
        Driver.getDriver().get(ConfigReader.getProperty("merchantUrl"));
        extentTest=extentReports.createTest("Controling the Forgot password link is enable","Ability to enable the Forgot password");
        ReusableMethods.bekle(2);

        //  3-Verify  the “Forgot password” link is visible.

        merchantPage.forgotPassword.click();
        extentTest.info("the forgotPassword link is clicked");
        softAssert.assertTrue(merchantPage.forgotPassword.isDisplayed());
        softAssert.assertTrue(merchantPage.forgotPassword.isEnabled());
        extentTest.info("the forgotPassword link is enabled");


        String actualUrl=Driver.getDriver().getCurrentUrl();
        String expectedUrl="https://qa.mealscenter.com/backoffice/resetpswd";
        softAssert.assertEquals(actualUrl,expectedUrl);
        extentTest.info("the Reset password page is enabled");
        ReusableMethods.bekle(2);

        // 4-Verify  the “Forgot password” link is active to create a new password

        merchantPage.merchantEmailAddress.sendKeys(ConfigReader.getProperty("gecerliMail"));
        ReusableMethods.bekle(2);
        merchantPage.requestEmailbutton.click();
        ReusableMethods.bekle(2);
        extentTest.info("the Request e-mail link is clicked");

        softAssert.assertTrue(merchantPage.requestedMail.isDisplayed());
        softAssert.assertTrue(merchantPage.requestedMail.isEnabled());
        extentTest.pass("the Request e-mail link is enabled");
        Driver.closeDriver();

    }

    @Test(priority = 20)
    public void TC_2003_NegativeForgotPasswordTesti1() {

        merchantPage = new MerchantPage();
        Driver.getDriver().get(ConfigReader.getProperty("merchantUrl"));
        extentTest=extentReports.createTest("Controling the Forgot password link is enable","Ability to enable the Forgot password");
        ReusableMethods.bekle(2);

        //  3-Verify  the “Forgot password” link is visible.

        merchantPage.forgotPassword.click();
        extentTest.info("the forgotPassword link is clicked");
        softAssert.assertTrue(merchantPage.forgotPassword.isDisplayed());
        softAssert.assertTrue(merchantPage.forgotPassword.isEnabled());
        extentTest.info("the forgotPassword link is enabled");


        String actualUrl=Driver.getDriver().getCurrentUrl();
        String expectedUrl="https://qa.mealscenter.com/backoffice/resetpswd";
        softAssert.assertEquals(actualUrl,expectedUrl);
        extentTest.info("the Reset password page is enabled");
        ReusableMethods.bekle(2);

        merchantPage.merchantEmailAddress.sendKeys(ConfigReader.getProperty("gecersizMail"));
        ReusableMethods.bekle(2);
        merchantPage.requestEmailbutton.click();
        ReusableMethods.bekle(2);
        extentTest.info("the Request e-mail link is clicked");
        softAssert.assertTrue(merchantPage.mailErrormessage2.isDisplayed());
        extentTest.pass("the Request e-mail link is enabled");
        Driver.closeDriver();

    }

    @Test(priority = 30)
    public void TC_2004_NnegativeForgotPasswordTesti2(){
        merchantPage = new MerchantPage();
        Driver.getDriver().get(ConfigReader.getProperty("merchantUrl"));
        extentTest=extentReports.createTest("Controling the Forgot password link is enable","Ability to enable the Forgot password");
        ReusableMethods.bekle(2);

        //  3-Verify  the “Forgot password” link is visible.

        merchantPage.forgotPassword.click();
        extentTest.info("the forgotPassword link is clicked");
        softAssert.assertTrue(merchantPage.forgotPassword.isDisplayed());
        softAssert.assertTrue(merchantPage.forgotPassword.isEnabled());
        extentTest.info("the forgotPassword link is enabled");


        String actualUrl=Driver.getDriver().getCurrentUrl();
        String expectedUrl="https://qa.mealscenter.com/backoffice/resetpswd";
        softAssert.assertEquals(actualUrl,expectedUrl);
        extentTest.info("the Reset password page is enabled");
        ReusableMethods.bekle(2);

        merchantPage.merchantEmailAddress.sendKeys(ConfigReader.getProperty("notFoundMail"));
        ReusableMethods.bekle(2);
        merchantPage.requestEmailbutton.click();
        ReusableMethods.bekle(2);
        extentTest.info("the Request e-mail link is clicked");
        softAssert.assertTrue(merchantPage.mailErrorMessage1.isDisplayed());
        extentTest.pass("the Forgot password link is active");
        Driver.closeDriver();

    }
}
