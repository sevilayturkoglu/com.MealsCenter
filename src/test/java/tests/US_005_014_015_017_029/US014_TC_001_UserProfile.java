package tests.US_005_014_015_017_029;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;



public class US014_TC_001_UserProfile {


    UserPage userPage = new UserPage();


    @Test (groups = "smoke")
    public void userProfileTest() {

        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));



        if (userPage.userCookies.isDisplayed()) {

            userPage.userCookies.click();
            userPage.userSignIn.click();

            Actions actions = new Actions(Driver.getDriver());
            userPage.userEmailLogin.click();
            actions.sendKeys(ConfigReader.getProperty("userLoginEmailSariye")).sendKeys(Keys.TAB)
                    .sendKeys(ConfigReader.getProperty("userLoginPasswordSariye")).perform();

            actions.click(userPage.userSignInLogin).perform();

            actions.moveToElement(userPage.userUstDropDownButton).click();

            ReusableMethods.bekle(2);

            actions.sendKeys(Keys.ARROW_DOWN).perform();

            ReusableMethods.bekle(2);

            actions.sendKeys(Keys.ENTER).perform();

            String actualUrl = Driver.driver.getCurrentUrl();
            String expectedUrl = "https://qa.mealscenter.com/account/profile";


            Assert.assertEquals(actualUrl,expectedUrl,"profile page is active");


            //Driver.closeDriver();


            //if no cookies
        } else {
            userPage.userSignIn.click();

            Actions actions = new Actions(Driver.getDriver());
            userPage.userEmailLogin.click();
            actions.sendKeys(ConfigReader.getProperty("userLoginEmailSariye")).sendKeys(Keys.TAB)
                    .sendKeys(ConfigReader.getProperty("userLoginPasswordSariye")).perform();
            actions.click(userPage.userSignInLogin).perform();

            actions.moveToElement(userPage.userUstDropDownButton).click();

            ReusableMethods.bekle(2);

            actions.sendKeys(Keys.ARROW_DOWN).perform();

            ReusableMethods.bekle(2);

            actions.sendKeys(Keys.ENTER).perform();

            Driver.closeDriver();
        }


    }

}
