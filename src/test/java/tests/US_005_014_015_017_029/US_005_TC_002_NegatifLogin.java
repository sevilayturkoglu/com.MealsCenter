package tests.US_005_014_015_017_029;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_005_TC_002_NegatifLogin {


    @Test
    public void negatifLoginTest1() {
        UserPage userPage = new UserPage();
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        if (userPage.userCookies.isDisplayed()) {

            userPage.userCookies.click();
            userPage.userSignIn.click();

            Actions actions = new Actions(Driver.getDriver());
            userPage.userEmailLogin.click();
            actions.sendKeys(ConfigReader.getProperty("userLoginEmailSariye")).sendKeys(Keys.TAB)
                    .sendKeys(ConfigReader.getProperty("invalidPassword2")).perform();

            actions.click(userPage.userSignInLogin).perform();

            Assert.assertTrue(userPage.userEmailLogin.isEnabled());

            Driver.closeDriver();


            //if no cookies
        } else {
            userPage.userSignIn.click();

            Actions actions = new Actions(Driver.getDriver());
            userPage.userEmailLogin.click();
            actions.sendKeys(ConfigReader.getProperty("userLoginEmailSariye")).sendKeys(Keys.TAB)
                    .sendKeys(ConfigReader.getProperty("invalidPassword2")).perform();
            actions.click(userPage.userSignInLogin).perform();


            // //Verify that the user is logged in and redirected
            // to their account dashboard


            Assert.assertTrue(userPage.userEmailLogin.isEnabled());
            Driver.closeDriver();
        }

    }


    @Test
    public void negatifLoginTest2() {
        UserPage userPage = new UserPage();
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        if (userPage.userCookies.isDisplayed()) {

            userPage.userCookies.click();
            userPage.userSignIn.click();

            Actions actions = new Actions(Driver.getDriver());
            userPage.userEmailLogin.click();
            actions.sendKeys(ConfigReader.getProperty("invalidEmail1")).sendKeys(Keys.TAB)
                    .sendKeys(ConfigReader.getProperty("userLoginPasswordSariye")).perform();

            actions.click(userPage.userSignInLogin).perform();

            Assert.assertTrue(userPage.userEmailLogin.isEnabled());

            Driver.closeDriver();


            //if no cookies
        } else {
            userPage.userSignIn.click();

            Actions actions = new Actions(Driver.getDriver());
            userPage.userEmailLogin.click();
            actions.sendKeys(ConfigReader.getProperty("invalidEmail1")).sendKeys(Keys.TAB)
                    .sendKeys(ConfigReader.getProperty("invalidPassword2")).perform();
            actions.click(userPage.userSignInLogin).perform();


            // //Verify that the user is logged in and redirected
            // to their account dashboard


            Assert.assertTrue(userPage.userEmailLogin.isEnabled());
            Driver.closeDriver();
        }

    }

    @Test
    public void negatifLoginTest3() {
        UserPage userPage = new UserPage();
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        if (userPage.userCookies.isDisplayed()) {

            userPage.userCookies.click();
            userPage.userSignIn.click();

            Actions actions = new Actions(Driver.getDriver());
            userPage.userEmailLogin.click();
            actions.sendKeys(ConfigReader.getProperty("invalidEmail1")).sendKeys(Keys.TAB)
                    .sendKeys(ConfigReader.getProperty("invalidPassword3")).perform();

            actions.click(userPage.userSignInLogin).perform();

            Assert.assertTrue(userPage.userEmailLogin.isEnabled());

            Driver.closeDriver();



            //if no cookies
        } else {
            userPage.userSignIn.click();

            Actions actions = new Actions(Driver.getDriver());
            userPage.userEmailLogin.click();
            actions.sendKeys(ConfigReader.getProperty("invalidEmail1")).sendKeys(Keys.TAB)
                    .sendKeys(ConfigReader.getProperty("invalidPassword3")).perform();
            actions.click(userPage.userSignInLogin).perform();


            // //Verify that the user is logged in and redirected
            // to their account dashboard


            Assert.assertTrue(userPage.userEmailLogin.isEnabled());

            Driver.closeDriver();


        }

    }

}
