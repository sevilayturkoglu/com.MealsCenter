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
import utilities.TestBaseReport;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class US_038_AdminOrderListTest extends TestBaseReport {
    AdminPage adminPage = new AdminPage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testTC_03801() {
        adminPage = new AdminPage();
        extentTest = extentReports.createTest("testTC_03801", "Orders option should be clicked, All orders text should be visible.");
        adminPage.adminLoginOl();
        extentTest.info("Browser is opened ,admin page is opened");
        ReusableMethods.bekle(4);
        extentTest.info("It is waited 4 seconds.");
        adminPage.ordersLink.click();
        extentTest.info("Orders Link is clicked.");
        adminPage.allOrderLink.click();
        extentTest.info("All order Link is clicked.");
        ReusableMethods.waitForVisibility(adminPage.allOrdersText, 3);
        extentTest.info("It should be waited until All Orders text is visible.");
        String expectedText = "All Orders";
        extentTest.info("All Orders is expected text.");
        String actualResult = adminPage.allOrdersText.getText();
        extentTest.info("Actual text is found.");
        softAssert.assertEquals(actualResult, expectedText);
        extentTest.info("Expected Result and Actual result are compaired.");
        extentTest.pass("All orders are visible .");
        softAssert.assertAll();
        Driver.closeDriver();
        extentTest.info("The browser is closed.");

    }

    @Test
    public void testTC_03802() {
        adminPage = new AdminPage();
        extentTest = extentReports.createTest("testTC_03802", "Cancel, Total refund, Total Orders should be visible");
        extentTest.info("Browser is opened ,admin page is opened");
        adminPage.adminLoginOl();
        ReusableMethods.bekle(4);
        extentTest.info("It is waited 3 seconds.");
        adminPage.ordersLink.click();
        extentTest.info("Orders Link is clicked.");
        adminPage.allOrderLink.click();
        extentTest.info("All order Link is clicked.");
        ReusableMethods.waitForVisibility(adminPage.allOrdersText, 3);
        extentTest.info("It should be waited until All Orders text is visible.");
        extentTest.info("Orders text should be visible");
        extentTest.pass("Orders text is visible .");
        softAssert.assertTrue(adminPage.ordersText.isDisplayed());
        extentTest.info("Cancel text should be visible");
        extentTest.pass("Cansel text is visible .");
        softAssert.assertTrue(adminPage.cancelText.isDisplayed());
        extentTest.info("Total Refund text should be visible");
        extentTest.pass("Total Refund text is visible .");
        softAssert.assertTrue(adminPage.totalRefundText.isDisplayed());
        softAssert.assertTrue(adminPage.totalOrdersText.isDisplayed());
        extentTest.info("Total Orders text should be visible");
        extentTest.pass("Total Orders text is visible .");
        softAssert.assertAll();
        Driver.closeDriver();
        extentTest.info("The browser is closed.");
    }

    @Test
    public void test_TC_03803() {

        adminPage = new AdminPage();
        extentTest = extentReports.createTest("testTC_03803", "By a specific Date Range select option is should be visible");
        ReusableMethods.bekle(5);
        adminPage.adminLoginOl();
        extentTest.info("Browser is opened ,admin page is opened");
        ReusableMethods.bekle(4);
        extentTest.info("It is waited 4 seconds.");
        adminPage.ordersLink.click();
        extentTest.info("Orders Link is clicked.");
        adminPage.allOrderLink.click();
        extentTest.info("All order Link is clicked.");
        ReusableMethods.waitForVisibility(adminPage.orderFiltersButton, 3);
        extentTest.info("It should be waited until Filters button  is visible.");
        adminPage.orderFiltersButton.click();
        extentTest.info("Filters Button is clicked.");
        //Verify that "By a specific Date Range" select option is visible.
        String expectedOption = "By a specific Date Range";
        String allOptionsFilters = adminPage.orderFiltersBody.getText();
        softAssert.assertTrue(allOptionsFilters.contains(expectedOption));
        extentTest.fail("By a specific Date Range select option is not visible");
        softAssert.assertAll();
        Driver.closeDriver();
        extentTest.info("The browser is closed.");
    }

    @Test
    public void testTC_03804() {
        adminPage = new AdminPage();
        extentTest = extentReports.createTest("testTC_03804", "All products should be sorted bi ID Element");
        adminPage.adminLoginOl();
        extentTest.info("Browser is opened ,admin page is opened");
        ReusableMethods.bekle(4);
        extentTest.info("It is waited 4 seconds.");
        adminPage.ordersLink.click();
        extentTest.info("Orders Link is clicked.");
        adminPage.allOrderLink.click();
        extentTest.info("All order Link is clicked.");
        ReusableMethods.waitForVisibility(adminPage.orderOrderId, 3);
        extentTest.info("It should be waited until Order ID link is visible.");
        adminPage.orderOrderId.click();
        extentTest.info("Order ID Link is clicked.");
        adminPage.orderIdElementsMethod();
        List<Integer> sortedIdElements = adminPage.orderIdElementsMethod();
        Collections.sort(sortedIdElements);
        softAssert.assertEquals(sortedIdElements, adminPage.orderIdElementsMethod());
        extentTest.pass("All products were sorted");
        Driver.closeDriver();
        extentTest.info("The browser is closed.");
    }

    @Test
    public void testTC_03805() {

        adminPage = new AdminPage();
        softAssert = new SoftAssert();
        extentTest = extentReports.createTest("testTC_03805", "A order should be able to view as a document.");
        adminPage.adminLoginOl();
        extentTest.info("Browser is opened ,admin page is opened");
        extentTest.info("It is waited for 4 seconds.");
        ReusableMethods.bekle(4);
        adminPage.ordersLink.click();
        extentTest.info("Orders Link is clicked.");
        adminPage.allOrderLink.click();
        extentTest.info("All Order Link is clicked.");
        ReusableMethods.waitForVisibility(adminPage.orderViewSign, 3);
        extentTest.info("It should be waited until View Sign is visible.");
        extentTest.info("View Sign links are clicked.");
        extentTest.info("Summary texts are visible.");

        for (int i = 1; i <= 10; i++) {
            ReusableMethods.bekle(3);
            WebElement viewSign = Driver.getDriver().findElement(By.xpath("(//a[@class='ref_view_order normal btn btn-light tool_tips'])[" + i + "]"));
            JSUtilities.scrollToElement(Driver.getDriver(), viewSign);
            ReusableMethods.bekle(3);
            viewSign.click();
            ReusableMethods.bekle(3);
            WebElement summaryText = Driver.getDriver().findElement(By.xpath("//h5[text()='Summary']"));
            softAssert.assertTrue(summaryText.isDisplayed());
            ReusableMethods.bekle(3);
            Driver.getDriver().navigate().back();
        }
        extentTest.pass("Any orders were seen as a document.");
        extentTest.info("The browser is closed.");
        Driver.getDriver().close();
    }

    @Test
    public void testTC_03806() {
        adminPage = new AdminPage();
        softAssert = new SoftAssert();
        extentTest = extentReports.createTest("testTC_03805", "A order should be able to view as a document.");
        ReusableMethods.bekle(10);
        adminPage.adminLoginOl();
        extentTest.info("Browser is opened ,admin page is opened");
        extentTest.info("It is waited for 4 seconds.");
        ReusableMethods.bekle(4);
        adminPage.ordersLink.click();
        extentTest.info("Orders Link is clicked.");
        adminPage.allOrderLink.click();
        extentTest.info("All Order Link is clicked.");
        ReusableMethods.waitForClickablility(adminPage.orderDownloadSign, 4);
        extentTest.info("It should be waited until Download Sign is visible.");
        extentTest.info("Download Sign links are clicked.");
        extentTest.info("Download documents are visible on the computer.");
        adminPage.orderDownloadSign.click();
        String dynamicPathOfFile = "C:\\Users\\ebasm\\Downloads\\document.pdf";
        softAssert.assertTrue(Files.exists(Paths.get(dynamicPathOfFile)));
        extentTest.pass("Download documents were seen on the computer.");
        extentTest.info("The browser is closed.");
        Driver.getDriver().close();
    }
}