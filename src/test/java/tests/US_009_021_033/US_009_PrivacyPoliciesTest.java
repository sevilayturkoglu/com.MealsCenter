package tests.US_009_021_033;


import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;



public class US_009_PrivacyPoliciesTest {
    UserPage userPage = new UserPage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void privacyPoliciesTest(){
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        UserPage userPage= new UserPage();
        userPage=new UserPage();
        userPage.userCookies.click();
        ReusableMethods.bekle(3);
        userPage.privacyPolicy.sendKeys(Keys.ENTER);

        // softAssert.assertTrue(userPage.privacyPolicyYazisi.isDisplayed());
        String actualPrivacyPoliciesUrl = Driver.getDriver().getCurrentUrl();
        String expectPrivacyPoliciesUrl= "privacy-policy";
        softAssert.assertTrue(actualPrivacyPoliciesUrl.contains(expectPrivacyPoliciesUrl));
        ReusableMethods.bekle(2);

        softAssert.assertAll();
        Driver.closeDriver();





    }
}
