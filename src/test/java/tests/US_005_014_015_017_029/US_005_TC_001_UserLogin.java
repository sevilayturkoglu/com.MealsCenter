package tests.US_005_014_015_017_029;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_005_TC_001_UserLogin {

    UserPage userPage = new UserPage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void userLoginPozitifTest() {

        //https://qa.mealscenter.com/account/login
        // accept cookies
        //Verify  login page:
        //userLoginPage.usernameEmailBox.click();

        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        if (userPage.userCookies.isDisplayed()) {

            userPage.userCookies.click();
            userPage.userSignIn.click();
            userPage.userEmailLogin.sendKeys(ConfigReader.getProperty("userLoginEmailSariye"));
            userPage.userPasswordLogin.sendKeys(ConfigReader.getProperty("userLoginPasswordSariye"));
            ReusableMethods.bekle(5);
            userPage.userSignInLogin.click();

            //if no cookies
        } else {
            userPage.userSignIn.click();
            userPage.userEmailLogin.sendKeys(ConfigReader.getProperty("userLoginEmailSariye"));
            userPage.userPasswordLogin.sendKeys(ConfigReader.getProperty("userLoginPasswordSariye"));
            userPage.userSignInLogin.click();
            ReusableMethods.bekle(5);

            // //Verify that the user is logged in and redirected
            // to their account dashboard

            Assert.assertTrue(userPage.userNameHeaderRight.isDisplayed());

            Driver.closeDriver();
        }

    }

}
