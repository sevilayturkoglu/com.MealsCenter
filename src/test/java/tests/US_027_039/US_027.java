package tests.US_027_039;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MerchantPage;

import pages.MerchantOrderProcessing;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

import java.util.ArrayList;
import java.util.List;

public class US_027 extends TestBaseReport {
    MerchantPage merchantPage;
    MerchantOrderProcessing merchantOrderProcessing;

    @Test
    public void test2701(){
        merchantPage=new MerchantPage();
        merchantPage.merchantLogin();
        extentTest = extentReports.createTest("test2701", "the order processing's list should be visible.");
        merchantOrderProcessing=new MerchantOrderProcessing();
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//a[.='Orders']")).isDisplayed());
        extentTest.info("The order's button is visible.");
        merchantPage.merchantMenuLeftSide("Orders");
        extentTest.info("The order's button is clicked.");
        ReusableMethods.bekle(1);
        extentTest.info("It is waited for 1 second.");
        merchantPage.merchantMenuLeftSide("Orders Processing");
        extentTest.info("Orders processing is clicked.");
        Assert.assertTrue(merchantOrderProcessing.merchantOrdersProcessingButton.isDisplayed());
        extentTest.info("The order processing's  button is visible.");
        Assert.assertTrue(merchantOrderProcessing.merchantOrdersProcessingButton.isEnabled());
        extentTest.info("The order processing's  button is clicked.");
        Assert.assertTrue(merchantOrderProcessing.merchantOrderProcessingText.isDisplayed());
        extentTest.pass("Verified that the order processing's list is visible.");
}

    @Test
    public void test2702(){
        merchantPage=new MerchantPage();
        merchantPage.merchantLogin();
        extentTest=extentReports.createTest("test2702","The Orders Processing page list all the  orders that are accepted.");
        merchantOrderProcessing=new MerchantOrderProcessing();
        merchantPage.merchantMenuLeftSide("Orders");
        extentTest.info("Orders button is clicked.");
        merchantOrderProcessing.merchantNewOrdersButtonu.click();
        extentTest.info("New Orders button is clicked.");
        String acceptedOrders=merchantOrderProcessing.merchantNewOrdersOrderNummer.getText();
        System.out.println(merchantOrderProcessing.merchantNewOrdersOrderNummer.getText());
        merchantOrderProcessing.merchantNewOrdersAcceptedButonu.click();
        extentTest.info("Orders Accepted button is clicked.");
        Driver.getDriver().navigate().refresh();
        extentTest.info("It is refreshed.gi");
        merchantOrderProcessing.merchantOrdersProcessingButton.click();
        extentTest.info("Orders processing button is clicked.");

        List<WebElement> orderProcessinglistesi=merchantOrderProcessing.merchantOrdersProcessingList;
        extentTest.info("Orders processing list is created.");
        List<String> orderPro=new ArrayList<>();

        for (WebElement each:orderProcessinglistesi
        ) {
            String element=each.getText();
            orderPro.add(element);
        }
        System.out.println(orderPro);

        ReusableMethods.bekle(3);
        extentTest.info("It is waited for 3 seconds.");

        Assert.assertTrue(orderPro.contains(acceptedOrders));
        extentTest.pass("Verified that the accepted items is visible in de list.");

    }

    @Test
    public void test2703(){
        merchantPage=new MerchantPage();
        merchantPage.merchantLogin();
        extentTest=extentReports.createTest("test2703","The Orders Processing page should display the order details such as order number, customer name, delivery address, and order items.");
        merchantOrderProcessing=new MerchantOrderProcessing();
        merchantPage.merchantMenuLeftSide("Orders");
        extentTest.info("Orders button is clicked.");
        merchantOrderProcessing.merchantOrdersProcessingButton.click();
        extentTest.info("Orders Processing button is clicked.");
        Assert.assertTrue(merchantOrderProcessing.deliveryInformation.isDisplayed());
        extentTest.pass("Verified that the product's name, delivery address, and order information appear.");

    }

    @Test
    public void test2704(){
        merchantPage=new MerchantPage();
        merchantOrderProcessing=new MerchantOrderProcessing();
        merchantPage.merchantLogin();
        extentTest=extentReports.createTest("test2704","the ready to pick button can be clicked.");
        merchantPage.merchantMenuLeftSide("Orders");
        extentTest.info("Orders button is clicked.");
        merchantOrderProcessing.merchantOrdersProcessingButton.click();
        extentTest.info("Orders Processing button is clicked.");
        Assert.assertTrue(merchantOrderProcessing.menchantReadyforPick.isDisplayed());
        extentTest.pass("Verified that ready to pick button is visible");
        Assert.assertTrue(merchantOrderProcessing.menchantReadyforPick.isEnabled());
        extentTest.pass("Verified that ready to pick button is enabled.");
    }
    @Test
    public void test2705(){
        merchantPage=new MerchantPage();
        merchantPage.merchantLogin();
        extentTest=extentReports.createTest("test2705","When the ready to pick button is pressed, the product should drop from the order processing list.");
        merchantPage.merchantMenuLeftSide("Orders");
        extentTest.info("Orders button is clicked.");
        merchantOrderProcessing=new MerchantOrderProcessing();
        merchantOrderProcessing.merchantOrdersProcessingButton.click();
        extentTest.info("Orders Processing button is clicked.");
        String acceptedOrderName=merchantOrderProcessing.orderNumber.getText();
        System.out.println(acceptedOrderName);

        merchantOrderProcessing.menchantReadyforPick.click();
        extentTest.info("ReadytoPick button is clicked.");
        ReusableMethods.bekle(3);
        extentTest.info("It is waited for 3 seconds.");
        Driver.getDriver().navigate().refresh();
        extentTest.info("It is refreshed.");
        List<WebElement> orderprocessinglistesi=merchantOrderProcessing.merchantOrdersProcessingList;
        extentTest.info("Orders processing list is created.");
        List<String> orderPro=new ArrayList<>();

        for (WebElement each:orderprocessinglistesi
        ) {
            String element=each.getText();
            orderPro.add(element);
        }
        System.out.println(orderPro);

        ReusableMethods.bekle(3);
        extentTest.info("It is waited for 3 seconds.");
        Assert.assertFalse(orderPro.contains(acceptedOrderName));
        extentTest.pass("Verified that the selected product has been removed from the list.");






    }



}