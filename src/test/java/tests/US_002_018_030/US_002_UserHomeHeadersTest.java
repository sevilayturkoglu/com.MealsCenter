package tests.US_002_018_030;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class US_002_UserHomeHeadersTest {

    UserPage userPage = new UserPage();
    SoftAssert softAssert = new SoftAssert();

    @Test(priority = 5)
    public void mealsLogoSignInTest() {
        userPage = new UserPage();
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        ReusableMethods.bekle(3);
        userPage.userCookies.click();
        softAssert.assertTrue(userPage.userLogo.isDisplayed());
        softAssert.assertTrue(userPage.userLogo.isEnabled());
        softAssert.assertTrue(userPage.userSignIn.isDisplayed());
        userPage.userSignIn.click();
        String actualLoginText = userPage.userLoginText.getText();
        String expectedLoginText = "Login";
        softAssert.assertEquals(actualLoginText, expectedLoginText);
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(priority = 10)
    public void BeforeOrderCartBagTest() {
        userPage = new UserPage();

        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        ReusableMethods.bekle(3);
        userPage.userCookies.click();
        softAssert.assertTrue(userPage.userCartButton.isDisplayed());
        userPage.userCartButton.click();
        String actualCartText = userPage.userCartText.getText();
        String excpectedCartText = "Cart";
        ReusableMethods.bekle(1);
        softAssert.assertEquals(actualCartText, excpectedCartText);
        ReusableMethods.bekle(1);
        userPage.userHeadersClosex.click();

        ReusableMethods.bekle(1);

        softAssert.assertTrue(userPage.userBagButton.isDisplayed());
        userPage.userBagButton.click();
        ReusableMethods.bekle(1);
        String actualBagText = userPage.userBagText.getText();
        String expectedBagText = "You don't have any orders here!\n" +
                "let's change that!";
        ReusableMethods.bekle(2);
        softAssert.assertEquals(actualBagText, expectedBagText);
        userPage.userHeadersClosex.click();
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(priority = 15)
    public void AfterOrderCartBagTest() {

        userPage = new UserPage();
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        ReusableMethods.bekle(3);
        userPage.userCookies.click();
        userPage.userAdresBox.sendKeys("100000");
        ReusableMethods.waitForVisibility(userPage.userChooseAddres, 10);
        userPage.userChooseAddres.click();
        userPage.eleven7.click();
        String eleven7Text = userPage.eleven7.getText();
        userPage.addToCard.click();
        userPage.userLogo.click();
        userPage.userCartButton.click();
        String actualCartText = userPage.userBagChecOutText.getText();
        String excpectedCartText = "Go to checkout";
        ReusableMethods.bekle(1);
        softAssert.assertEquals(actualCartText, excpectedCartText);
        userPage.userHeadersClosex.click();
        ReusableMethods.bekle(1);
        userPage.userBagButton.click();
        ReusableMethods.bekle(1);
        String actualBagText = userPage.userBagChecOutText.getText();
        String excpectedBagText = "Go to checkout";
        ReusableMethods.bekle(1);
        softAssert.assertEquals(actualBagText, excpectedBagText);
        userPage.userHeadersClosex.click();
        softAssert.assertAll();
        Driver.closeDriver();
    }
}