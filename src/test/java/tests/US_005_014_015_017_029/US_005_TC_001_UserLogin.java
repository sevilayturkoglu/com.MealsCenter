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
    SoftAssert softAssert = new SoftAssert();
    Actions actions ;

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

            Actions actions = new Actions(Driver.getDriver());
            userPage.userEmailLogin.click();
            actions.sendKeys(ConfigReader.getProperty("userLoginEmailSariye")).sendKeys(Keys.TAB)
                    .sendKeys(ConfigReader.getProperty("userLoginPasswordSariye")).perform();

            actions.click(userPage.userSignInLogin).perform();


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