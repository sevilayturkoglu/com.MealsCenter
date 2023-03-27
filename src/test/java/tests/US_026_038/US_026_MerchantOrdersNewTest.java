package tests.US_026_038;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MerchantPage;
import pages.Merchant_US_026_Page;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US_026_MerchantOrdersNewTest extends TestBaseReport {

    Merchant_US_026_Page merchant_us_026_page=new Merchant_US_026_Page();
    MerchantPage merchantPage=new MerchantPage();
    SoftAssert softAssert=new SoftAssert();
    @Test(priority = 5)
    public void testTC_02601(){
        merchant_us_026_page=new Merchant_US_026_Page();
        merchantPage=new MerchantPage();
        extentTest = extentReports.createTest("testTC_02601", "New Orders option and All orders text should be visible.");
        merchantPage.merchantLogin();
        extentTest.info("Browser is opened ,admin page is opened");
        extentTest.info("Orders Link is clicked.");
        merchantPage.merchantMenuLeftSide("Orders");
        extentTest.info("New Orders Link is clicked.");
        merchant_us_026_page.newOrdersLink.click();
        extentTest.pass("New Orders are visible .");
        softAssert.assertTrue(merchant_us_026_page.newOrderText.isDisplayed());
        softAssert.assertAll();

    }

    @Test(priority = 10)

    public void TC_02602(){
        merchant_us_026_page=new Merchant_US_026_Page();
        merchantPage=new MerchantPage();
        extentTest = extentReports.createTest("testTC_02602", "A new product should be able to added.");
        merchantPage.merchantLogin();
        extentTest.info("Browser is opened ,admin page is opened");
        extentTest.info("Orders Link is clicked.");
        merchantPage.merchantMenuLeftSide("Orders");
        extentTest.info("New Orders Link is clicked.");
        merchant_us_026_page.newOrdersLink.click();

        extentTest.info("Before total price is found as a String.");
        String beforeTotalText=merchant_us_026_page.beforeTotal.getText();//48.66$
        String beforeStringPrice= beforeTotalText.replaceAll("\\D","");
        int beforePrice=Integer.parseInt(beforeStringPrice);
        extentTest.info("String price is changed to integer price number.");
        merchant_us_026_page.addButton.click();
        extentTest.info("Add button is clicked.");
        ReusableMethods.waitForClickablility(merchant_us_026_page.firstProduct,3);
        extentTest.info("It should be waited until the first product is clickable.");
        extentTest.info("New Orders Link is clicked.");
        merchant_us_026_page.firstProduct.click();
        ReusableMethods.waitForClickablility(merchant_us_026_page.choosenProduct,3);
        extentTest.info("It should be waited until the choosen product is clickable.");
        //The user clicks again choosen product's image.
        merchant_us_026_page.choosenProduct.click();
        extentTest.info("Choosen product's image is clicked.");

        merchant_us_026_page.addToOrder.click();
        extentTest.info("Add to order box is clicked.");
        ReusableMethods.waitForClickablility(merchant_us_026_page.crossXSign,3);
        extentTest.info("It should be waited until the the cross sign is clickable.");
        merchant_us_026_page.crossXSign.click();
        extentTest.info("Cross =x sign is clicked.");
        extentTest.info("Total account is found as a String.");
        String afterTotalText=merchant_us_026_page.afterTotal.getText();
        String afterStringPrice= afterTotalText.replaceAll("\\D","");
        int afterPrice=Integer.parseInt(afterStringPrice);
        extentTest.info("Total account is found as  a integer .");
        extentTest.pass("Total account is bigger than before total account.");
        softAssert.assertTrue(afterPrice>beforePrice);
        softAssert.assertAll();

    }

    @Test(priority = 15)

    public void TC_02603(){
        merchant_us_026_page=new Merchant_US_026_Page();
        merchantPage=new MerchantPage();
        extentTest = extentReports.createTest("testTC_02601", "New Orders option and All orders text should be visible.");
        merchantPage.merchantLogin();
        extentTest.info("Browser is opened ,admin page is opened");
        extentTest.info("Orders Link is clicked.");
        merchantPage.merchantMenuLeftSide("Orders");
        extentTest.info("New Orders Link is clicked.");
        merchant_us_026_page.newOrdersLink.click();
        extentTest.info("Edit buttons to click the product is checked.");
        String expectedElement="Edit";
        String allBodyElements=merchant_us_026_page.allBody.getText();
        extentTest.fail("Edit buttons to click the product is invalid.");
        softAssert.assertTrue(allBodyElements.contains(expectedElement));
        softAssert.assertAll();

    }
    @Test(priority = 20)

    public  void TC_02604(){
        merchant_us_026_page=new Merchant_US_026_Page();
        merchantPage=new MerchantPage();
        extentTest = extentReports.createTest("testTC_02601", "New Orders option and All orders text should be visible.");
        merchantPage.merchantLogin();
        extentTest.info("Browser is opened ,admin page is opened");
        extentTest.info("Orders Link is clicked.");
        merchantPage.merchantMenuLeftSide("Orders");
        extentTest.info("New Orders Link is clicked.");
        merchant_us_026_page.newOrdersLink.click();
        extentTest.info("Delete it button to click the product is checked.");

        String allBodyTexts= merchant_us_026_page.allBody.getText();
        String expectedText="Delete it";

        extentTest.fail("Delete it button to click the product is invalid.");
        softAssert.assertTrue(allBodyTexts.contains(expectedText));
        softAssert.assertAll();






    }


}
