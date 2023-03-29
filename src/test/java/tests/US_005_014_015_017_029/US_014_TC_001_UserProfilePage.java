package tests.US_005_014_015_017_029;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

import java.time.Duration;

public class US_014_TC_001_UserProfilePage extends TestBaseReport {

    UserPage userPage = new UserPage();
    SoftAssert softAssert = new SoftAssert();

    @Test(groups = "smoke")
    public void testUserProfilePage() {
        userPage=new UserPage();
        userPage.userLoginSariye();
        extentTest = extentReports.createTest("User  Page Visibility Test", "User page of the user,should be visible.");
        extentTest.info("chrome browser and user page is active");
        ReusableMethods.bekle(3);
        extentTest.info("It is waited 3 seconds.");
        userPage.userUstDropDownButton.click();
        ReusableMethods.bekle(3);
        userPage.userManageMyAccount.click();
        ReusableMethods.bekle(3);
        extentTest.info("User Manage my account Link is clicked.");

        String expectedResult = " Manage my account ";
        String actualResult = userPage.userManageMyAccount.getText();

        userPage.userSidebarManageMyAccount.click();
        extentTest.info("Order page is visible and clickable");

        softAssert.assertEquals(actualResult, expectedResult);
        extentTest.info("The actual result and expected result are compared.");
        extentTest.pass("Order page is visible and clickable .");
        softAssert.assertAll();
        ///Driver.closeDriver();
        //extentTest.info("Chrome browser is closed.");


    }

    @Test
    public void testChangePassword() {

        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));

        if (userPage.userCookies.isDisplayed()) {
            userPage.userCookies.click();
        }

        userPage.userSignIn.click();

        Actions actions = new Actions(Driver.getDriver());
        userPage.userEmailLogin.click();
        actions.sendKeys(ConfigReader.getProperty("userLoginEmailSariye"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("userLoginPasswordSariye"))
                .sendKeys(Keys.ENTER)
                .perform();

        // Wait for the dropdown menu to be displayed
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.visibilityOf(userPage.userUstDropDownButton));
        userPage.userUstDropDownButton.click();
        actions.sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .perform();


        wait.until(ExpectedConditions.visibilityOf(userPage.userChangePasswordButton));

        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).click();

        wait.until(ExpectedConditions.visibilityOf(userPage.userOldPassword));

        userPage.userOldPassword.sendKeys(ConfigReader.getProperty("userOldPassword"));
        userPage.userNewPassword.sendKeys(ConfigReader.getProperty("userNewPassword"));
        userPage.userConfirmPassword.sendKeys(ConfigReader.getProperty("userNewPassword"));
        userPage.userChangePasswordSubmit.click();

        wait.until(ExpectedConditions.visibilityOf(userPage.userChangePasswordSuccessMessage));

        String actualMessage = userPage.userChangePasswordSuccessMessage.getText();
        String expectedMessage = "Your password has been successfully changed!";
        Assert.assertEquals(actualMessage, expectedMessage, "Password change was not successful.");
    }
}
