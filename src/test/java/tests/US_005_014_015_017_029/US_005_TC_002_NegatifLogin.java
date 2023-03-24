package tests.US_005_014_015_017_029;

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
        userPage.userCookies.click();
        userPage.userSignIn.click();
        userPage.userEmailLogin.sendKeys(ConfigReader.getProperty("userLoginEmailSariye"));
        userPage.userPasswordLogin.sendKeys(ConfigReader.getProperty("invalidPassword1"));
        userPage.userSignInLogin.click();

        ReusableMethods.bekle(5);

        Assert.assertTrue(userPage.userEmailLogin.isEnabled());
        Driver.closeDriver();
    }


    @Test
    public void negatifLoginTest2() {
        UserPage userPage = new UserPage();
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        userPage.userCookies.click();
        userPage.userSignIn.click();
        userPage.userEmailLogin.sendKeys(ConfigReader.getProperty("invalidEmail1"));
        userPage.userPasswordLogin.sendKeys(ConfigReader.getProperty("invalidPassword1"));
        userPage.userSignInLogin.click();

        ReusableMethods.bekle(5);

        Assert.assertTrue(userPage.userEmailLogin.isEnabled());
        Driver.closeDriver();


    }

    @Test
    public void negatifLoginTest3() {

        UserPage userPage = new UserPage();
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        userPage.userCookies.click();
        userPage.userSignIn.click();
        userPage.userEmailLogin.sendKeys(ConfigReader.getProperty("invalidEmail3"));
        userPage.userPasswordLogin.sendKeys(ConfigReader.getProperty("invalidPassword2"));
        userPage.userSignInLogin.click();

        ReusableMethods.bekle(5);

       Assert.assertTrue(userPage.userEmailLogin.isEnabled());
      Driver.closeDriver();


    }


}
