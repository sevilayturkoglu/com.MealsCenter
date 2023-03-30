package tests.US_003_004_007_019_031;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserPage;
import pages.UserPageBodyFooter;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US_007_ContactUsTest extends TestBaseReport {
    UserPage userPage;
    UserPageBodyFooter userPageBodyFooter;

    @Test(priority = 10)
    public void TC_00701_ContactUsTest(){
        userPage=new UserPage();
        userPageBodyFooter=new UserPageBodyFooter();

        extentTest=extentReports.createTest("Contact Page Test","Is Contact Page is visible, active and executes intented action");
        userPageBodyFooter.userFooter();
        extentTest.info("navigated to meals center and footer is seen");
        userPageBodyFooter.UserPageFooterContuctUs.isEnabled();
        extentTest.pass("Contact us is active");
        ReusableMethods.bekle(1);
        userPageBodyFooter.UserPageFooterContuctUs.click();
        extentTest.info("Contact us clicked");

        String expectedText="Contact Us";
        String actualText=userPageBodyFooter.UserPageContuctUsText.getText();
        Assert.assertEquals(expectedText,actualText);
        extentTest.pass("Expected contact us text is same with actual contact us text");

        userPageBodyFooter.UserPageContuctUsPhone.isDisplayed();
        extentTest.info("Call us Phone Number is visible");
        userPageBodyFooter.UserPageContuctUsEmail.isDisplayed();
        extentTest.info("email us mail address is visible");


    }
    @Test(priority = 20)
    public void TC_00702_ContactUsMessageTest(){
        userPage=new UserPage();
        userPageBodyFooter=new UserPageBodyFooter();
        extentTest=extentReports.createTest("Contact us Message Test","Expected text and actual text should be same");
        userPageBodyFooter.contuctUsMethod();
        extentTest.info("Contact Us Method runned");

        String expected="Your request has been sent.";
        String actual=userPageBodyFooter.UserPageContuctUsYourMessageText.getText();
        Assert.assertEquals(expected,actual);
        extentTest.pass("Contact us Message Test is PASSED");

    }

}
