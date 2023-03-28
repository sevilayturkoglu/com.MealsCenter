package tests.US_005_014_015_017_029;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_005_TC_001_UserLogin {

    UserPage userPage = new UserPage();

    @Test (groups = "smoke")
    public void userLoginPozitifTest() {


        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        if (userPage.userCookies.isDisplayed()) {

            userPage.userCookies.click();
            userPage.userSignIn.click();

            Actions actions = new Actions(Driver.getDriver());
            userPage.userEmailLogin.click();
            actions.sendKeys(ConfigReader.getProperty("userLoginEmailSariye")).sendKeys(Keys.TAB)
                    .sendKeys(ConfigReader.getProperty("userLoginPasswordSariye")).perform();

            actions.click(userPage.userSignInLogin).perform();

            //Driver.closeDriver();


            //if no cookies
        } else {
            userPage.userSignIn.click();

            Actions actions = new Actions(Driver.getDriver());
            userPage.userEmailLogin.click();
            actions.sendKeys(ConfigReader.getProperty("userLoginEmailSariye")).sendKeys(Keys.TAB)
                    .sendKeys(ConfigReader.getProperty("userLoginPasswordSariye")).perform();
            actions.click(userPage.userSignInLogin).perform();



            // //Verify that the user is logged in and redirected
            // to their account dashboard

            Assert.assertTrue(userPage.userSignIn.isDisplayed());

            Driver.closeDriver();
        }

    }

}
