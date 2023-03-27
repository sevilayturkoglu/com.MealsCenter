package tests.US_005_014_015_017_029;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class UserPageTests {

    UserPage userPage = new UserPage();

    @Test(groups = "smoke")
    public void testUserProfilePage() {

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
        wait.until(ExpectedConditions.visibilityOf(userPage.userUstDropDownButton));

        actions.moveToElement(userPage.userUstDropDownButton).click();
        actions.sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .perform();

        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://qa.mealscenter.com/account/profile";
        Assert.assertEquals(actualUrl, expectedUrl, "Profile page is not active");
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

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(userPage.userUstDropDownButton));

        actions.moveToElement(userPage.userUstDropDownButton).click();
        actions.sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .perform();

        userPage.userManageMyAccount.click();

        wait.until(ExpectedConditions.visibilityOf(userPage.userChangePasswordButton));

        userPage.userChangePasswordButton.click();

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
