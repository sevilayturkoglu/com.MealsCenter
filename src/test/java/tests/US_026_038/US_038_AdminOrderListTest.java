package tests.US_026_038;

import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminPage;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

import java.util.Collections;
import java.util.List;

public class US_038_AdminOrderListTest {
    AdminPage adminPage = new AdminPage();
    SoftAssert softAssert = new SoftAssert();

    @Test(priority = 5)
    public void testTC_03801() {
         adminPage = new AdminPage();
//The user opens the browser.
        //   The user logs into the webpage:https://qa.mealscenter.com/backoffice/login
        //   The user  types the correct Username and Password and  click Sign-in.

        adminPage.adminLoginOl();
        ReusableMethods.bekle(4);
        //   The user clicks "Orders" link under the Dashboard.
        adminPage.ordersLink.click();
        //   The user  clicks "All order" link under the "Orders".
        adminPage.allOrderLink.click();
        // The user waits until "All Orders"  text is visible.
        ReusableMethods.waitForVisibility(adminPage.allOrdersText, 3);

        //  Verify that "All Orders"  text is visible.

        String expectedText = "All Orders";
        String actualResult = adminPage.allOrdersText.getText();
        softAssert.assertEquals(actualResult, expectedText);

        softAssert.assertAll();
        Driver.closeDriver();

    }

    @Test(priority = 10)
    public void testTC_03802() {


        adminPage = new AdminPage();

        //The user opens the browser.
        //The user logs into the webpage:https://qa.mealscenter.com/backoffice/login
        //The user  types the correct Username and Password and  click Sign-in.
        adminPage.adminLoginOl();
        ReusableMethods.bekle(4);
        //   The user clicks "Orders" link under the Dashboard.
        adminPage.ordersLink.click();
        //   The user  clicks "All order" link under the "Orders".
        adminPage.allOrderLink.click();
        // The user waits until "All Orders"  text is visible.
        ReusableMethods.waitForVisibility(adminPage.allOrdersText, 3);

        //Verify that "Orders" text should be visible
        softAssert.assertTrue(adminPage.ordersText.isDisplayed());

        //Verify that ""Cancel"" text should be visible
        softAssert.assertTrue(adminPage.cancelText.isDisplayed());
        //Verify that ""Total refund"" text should be visible
        softAssert.assertTrue(adminPage.totalRefundText.isDisplayed());
        //Verify that ""Total Orders"" text should be visible
        softAssert.assertTrue(adminPage.totalOrdersText.isDisplayed());
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(priority = 25)
    public void test_TC_03803() {

        adminPage = new AdminPage();

        //The user opens the browser.
        //The user logs into the webpage:https://qa.mealscenter.com/backoffice/login
        //The user  types the correct Username and Password and  click Sign-in.
        adminPage.adminLoginOl();
        ReusableMethods.bekle(4);
        //   The user clicks "Orders" link under the Dashboard.
        adminPage.ordersLink.click();
        //   The user  clicks "All order" link under the "Orders".
        adminPage.allOrderLink.click();
        // The user waits until "Filters"  button is visible.
        ReusableMethods.waitForVisibility(adminPage.filtersButton, 3);

        //The user clicks "Filters" button.
        adminPage.filtersButton.click();
        //Verify that "By a specific Date Range" select option is visible.
        String expectedOption = "By a specific Date Range";
        String allOptionsFilters = adminPage.filtersBody.getText();
        softAssert.assertTrue(allOptionsFilters.contains(expectedOption));

        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(priority = 15)
    public void testTC_03804() {


        adminPage = new AdminPage();


        //The user opens the browser.
        //The user logs into the webpage:https://qa.mealscenter.com/backoffice/login
        //The user  types the correct Username and Password and  click Sign-in.
        adminPage.adminLoginOl();
        ReusableMethods.bekle(4);
        //   The user clicks "Orders" link under the Dashboard.
        adminPage.ordersLink.click();
        //   The user  clicks "All order" link under the "Orders".
        adminPage.allOrderLink.click();
        // The user waits until "Order ID"  link is visible.
        ReusableMethods.waitForVisibility(adminPage.orderId, 3);

//The user clicks "Order ID" link.
        adminPage.orderId.click();
//Verify that all products should be sorted .
        adminPage.orderIdElementsMethod();
        List<Integer> sortedIdElements = adminPage.orderIdElementsMethod();
        Collections.sort(sortedIdElements);
        softAssert.assertEquals(sortedIdElements, adminPage.orderIdElementsMethod());
        Driver.closeDriver();
    }

    @Test(priority = 20)
    public void testTC_03805() {

       adminPage = new AdminPage();


        //The user opens the browser.
        //The user logs into the webpage:https://qa.mealscenter.com/backoffice/login
        //The user  types the correct Username and Password and  click Sign-in.
        adminPage.adminLoginOl();
        ReusableMethods.bekle(4);
        //   The user clicks "Orders" link under the Dashboard.
        adminPage.ordersLink.click();
        //   The user  clicks "All order" link under the "Orders".
        adminPage.allOrderLink.click();
        // The user waits until "eye sign"  is visible.
        ReusableMethods.waitForVisibility(adminPage.eyeSign, 3);

        //The user clicks "eye sign"
        //Verify that "Summary" text is visible.//


        for (int i = 1; i <= 10; i++) {
            ReusableMethods.bekle(3);
            WebElement eyeSign = Driver.getDriver().findElement(By.xpath("(//a[@class='ref_view_order normal btn btn-light tool_tips'])[" + i + "]"));
            JSUtilities.scrollToElement(Driver.getDriver(),eyeSign);
            ReusableMethods.bekle(3);
           eyeSign.click();
            ReusableMethods.bekle(3);

            WebElement summaryText = Driver.getDriver().findElement(By.xpath("//h5[text()='Summary']"));
            softAssert.assertTrue(summaryText.isDisplayed());
            ReusableMethods.bekle(3);
            Driver.getDriver().navigate().back();


        }
        //The user closes the browser.
        Driver.getDriver().close();
    }
}