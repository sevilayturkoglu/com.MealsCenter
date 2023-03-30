package tests.US_005_014_015_017_029;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US_015_UserAccountOrders extends TestBaseReport {

    UserPage userPage = new UserPage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void TC_01501_UserAccountOrderPageTest() {
        userPage=new UserPage();
        userPage.userLoginSariye();
        extentTest = extentReports.createTest("User  Page Visibility Test", "User page of the user,should be visible.");
        extentTest.info("chrome browser and user page is active");
        ReusableMethods.bekle(3);
        extentTest.info("It is waited 3 seconds.");
        userPage.userUstDropDownButton.click();
        ReusableMethods.bekle(3);
        userPage.userDDMMyOrders.click();
        ReusableMethods.bekle(3);
        extentTest.info("Orders Link is clicked.");

        String expectedResult = "Orders";
        String actualResult = userPage.userOrderPageLeftMenuOrderText.getText();


        userPage.userOrderPageLeftMenuOrderText.click();
        extentTest.info("Order page is visible and clickable");

        softAssert.assertEquals(actualResult, expectedResult);
        extentTest.info("The expected result and actual result are compared.");
        extentTest.pass("Order page is visible and clickable .");
        softAssert.assertAll();
        //Driver.closeDriver();
        //extentTest.info("Chrome browser is closed.");

    }


}
