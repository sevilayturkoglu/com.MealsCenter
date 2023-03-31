package tests.US_008_020_032;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US_008_UserTermsConditions extends TestBaseReport {

    UserPage userPage = new UserPage();
    SoftAssert softAssert = new SoftAssert();
    Actions actions = new Actions(Driver.getDriver());

    @Test(priority = 10)
    public void TC_0801_TermsAndConditions(){

        userPage = new UserPage();
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        extentTest=extentReports.createTest("Controling the Terms and Conditions link is enable","Ability to enable the Terms and Conditions");
        extentTest.info("Browser baslatildi MealsCenter urlye gidildi");
        ReusableMethods.bekle(3);
        userPage.userCookies.click();
        ReusableMethods.bekle(2);
        extentTest.info("Cookies is accepted");



        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
        ReusableMethods.bekle(2);

        softAssert.assertTrue(userPage.termsAndConditions.isDisplayed());
        softAssert.assertTrue(userPage.termsAndConditions.isEnabled());
        extentTest.pass("the Terms and Conditions link is enabled");
        extentTest.info("Driver is closed");
        Driver.closeDriver();

    }

    @Test(priority = 20)
    public void TC_0802_ContactUs(){

        userPage = new UserPage();
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        extentTest=extentReports.createTest("Controling the Contact info link is enable","Ability to enable the the Contact info");
        ReusableMethods.bekle(2);
        userPage.userCookies.click();
        extentTest.info("Cookies is accepted");

        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
        ReusableMethods.bekle(2);

        userPage.termsAndConditions.click();
        ReusableMethods.bekle(2);
        extentTest.info("Terms and Conditions link is clicked");

        String actualTermsAndConditionUrl = Driver.driver.getCurrentUrl();
        String expectedTermsAndConditionUrl = "terms-and-conditions";
        Assert.assertTrue(actualTermsAndConditionUrl.contains(expectedTermsAndConditionUrl));
        extentTest.info("Terms and Conditions page is enabled");
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        userPage.contactUs.click();
        ReusableMethods.bekle(2);
        extentTest.info("contactUs link is clicked");

        Assert.assertTrue(userPage.contactUs.isDisplayed());
        Assert.assertTrue(userPage.contactUs.isSelected());
        extentTest.fail("the contactUs link is NOT clickable and Not enabled");

        softAssert.assertAll();
        Driver.closeDriver();

    }

}

