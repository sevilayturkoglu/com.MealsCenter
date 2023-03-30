package tests.US_005_014_015_017_029;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class US_005_UserLogin extends TestBaseReport {

    UserPage userPage = new UserPage();


    @Test (groups = "smoke")
    public void TC_00501_UserLoginPozitifTest() {

        userPage.userLoginSariye();
        extentTest = extentReports.createTest("User  Page Visibility Test", "User page of the user,should be visible.");
        extentTest.info("chrome browser and user page is active");



    }

    @Test(groups = "smoke")
    public void TC_00502_NegatifLoginTest1() {
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
    public void TC_00503_NegatifLoginTest2() {
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
    public void TC_00504_NegatifLoginTest3() {
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
