package tests.US_009_021_033;



import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import utilities.ConfigReader;
import utilities.Driver;

import utilities.ReusableMethods;
import utilities.TestBaseReport;


public class US_009_PrivacyPoliciesTest extends TestBaseReport {
    UserPage userPage = new UserPage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void TC_00901_privacyPoliciesTest(){
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        UserPage userPage= new UserPage();
        userPage=new UserPage();
        extentTest=extentReports.createTest("Go to the page as a visitor. Verifying the Privacy Policy page");
        userPage.userCookies.click();
        extentTest.info("cookies clicked");
        ReusableMethods.bekle(3);
        userPage.privacyPolicy.sendKeys(Keys.ENTER);
        extentTest.info("Privacy Policy link clicked");
        String actualPrivacyPoliciesUrl = Driver.getDriver().getCurrentUrl();
        extentTest.info("URL received to verify access to page");
        String expectPrivacyPoliciesUrl= "privacy-policy";
        extentTest.info("It has been verified whether the page to be entered and the actual URL are the same.");
        softAssert.assertTrue(actualPrivacyPoliciesUrl.contains(expectPrivacyPoliciesUrl));
        ReusableMethods.bekle(2);
        extentTest.pass("Verified access to Privacy Policy page");
        softAssert.assertAll();







    }
}
