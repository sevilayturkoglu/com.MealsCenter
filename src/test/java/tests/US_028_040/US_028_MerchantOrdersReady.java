package tests.US_028_040;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MerchantOrdersReady;
import pages.MerchantPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

import java.util.ArrayList;
import java.util.List;

public class US_028_MerchantOrdersReady extends TestBaseReport {
    MerchantPage merchantPage;
    MerchantOrdersReady merchantOrdersReady;

    @Test
    public void TC_02801_OrderReady() {
        merchantPage = new MerchantPage();
        merchantPage.merchantLogin();
        extentTest = extentReports.createTest("test2801", "the order ready's list should be visible.");
        merchantOrdersReady = new MerchantOrdersReady();
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//a[.='Orders']")).isDisplayed());
        extentTest.info("The order's button is visible.");
        merchantPage.merchantMenuLeftSide("Orders");
        extentTest.info("The order's button is clicked.");
        ReusableMethods.bekle(3);
        extentTest.info("It is waited for 3 second.");
        merchantPage.merchantMenuLeftSide("Orders Ready");
        extentTest.info("Orders Ready is clicked.");
        Assert.assertTrue(merchantOrdersReady.merchantOrdersReadyButton.isDisplayed());
        extentTest.info("The order ready's  button is visible.");
        Assert.assertTrue(merchantOrdersReady.merchantOrdersReadyButton.isEnabled());
        extentTest.info("The order ready's  button is clicked.");
        Assert.assertTrue(merchantOrdersReady.merchantOrdersReadyText.isDisplayed());
        extentTest.pass("Verified that the order ready's list is visible.");
    }

    @Test
    public void TC_02802_OrderReadyList() {
        merchantPage = new MerchantPage();
        merchantPage.merchantLogin();
        extentTest=extentReports.createTest("test2802","The Orders Ready page list all the  orders that are ready for pickup.");
        merchantOrdersReady = new MerchantOrdersReady();
        merchantPage.merchantMenuLeftSide("Orders");
        extentTest.info("Orders button is clicked.");
        merchantOrdersReady.merchantOrderProcessingButtonu.click();
        extentTest.info("Order Processing button is clicked.");
        String readyforpickupOrders = merchantOrdersReady.merchantOrdersReadyOrderNummer.getText();
        System.out.println(merchantOrdersReady.merchantOrdersReadyOrderNummer.getText());
        merchantOrdersReady.merchantReadyForPickupButonu.click();
        extentTest.info("Orders Ready for pickup button is clicked.");
        Driver.getDriver().navigate().refresh();
        extentTest.info("It is refreshed");
        merchantOrdersReady.merchantOrdersReadyButton.click();
        extentTest.info("Orders ready button is clicked.");

        List<WebElement> ordersreadylistesi = merchantOrdersReady.merchantOrdersReadyList;
        extentTest.info("Orders ready list is created.");
        List<String> ordersReady = new ArrayList<>();

        for (WebElement each : ordersreadylistesi
        ) {
            String element = each.getText();
            ordersReady.add(element);
        }
        System.out.println(ordersReady);

        ReusableMethods.bekle(3);
        extentTest.info("It is waited for 3 seconds.");

        Assert.assertFalse(ordersReady.contains(readyforpickupOrders));
        extentTest.pass("Verified that the ready for pickup items is visible in de list.");
    }

    @Test
    public void TC_02803_OrderReadyInformation() {
        merchantPage = new MerchantPage();
        merchantPage.merchantLogin();
        extentTest=extentReports.createTest("test2803","The Orders Ready page should display the order details such as order number, customer name, delivery address, and order items.");
        merchantOrdersReady = new MerchantOrdersReady();
        merchantPage.merchantMenuLeftSide("Orders");
        extentTest.info("Orders button is clicked.");
        merchantOrdersReady.merchantOrdersReadyButton.click();
        extentTest.info("Orders ready button is clicked.");
        Assert.assertTrue(merchantOrdersReady.deliveryInformation.isDisplayed());
        extentTest.pass("Verified that the product's name, delivery address, and order information appear.");
    }

    @Test
    public void TC_02804_DeliverdButton() {
        merchantPage = new MerchantPage();
        merchantOrdersReady = new MerchantOrdersReady();
        merchantPage.merchantLogin();
        extentTest=extentReports.createTest("test2804","the delivery button is clickabled.");
        merchantPage.merchantMenuLeftSide("Orders");
        extentTest.info("Orders button is clicked.");
        merchantOrdersReady.merchantOrdersReadyButton.click();
        extentTest.info("Orders ready button is clicked.");
        Assert.assertTrue(merchantOrdersReady.merchantDeliverd.isDisplayed());
        extentTest.pass("Verified that delivery button is visible.");
        Assert.assertTrue(merchantOrdersReady.merchantDeliverd.isEnabled());
        extentTest.pass("Verified that delivery button is enabled.");
    }

    @Test
    public void TC_02805_DeliverdButton(){
        merchantPage = new MerchantPage();
        merchantPage.merchantLogin();
        extentTest = extentReports.createTest("test2805", "When the delivery button is pressed, the product should drop from the order ready list.");
        merchantPage.merchantMenuLeftSide("Orders");
        extentTest.info("Orders button is clicked.");
        merchantOrdersReady = new MerchantOrdersReady();
        merchantOrdersReady.merchantOrdersReadyButton.click();
        extentTest.info("Orders ready button is clicked.");
        String ReadyForPickupOrderName = merchantOrdersReady.merchantOrdersReadyOrderNummer.getText();
        System.out.println(ReadyForPickupOrderName);

        merchantOrdersReady.merchantDeliverd.click();
        extentTest.info("Delivery button is clicked.");
        ReusableMethods.bekle(3);
        extentTest.info("It is waited for 3 seconds.");
        Driver.getDriver().navigate().refresh();
        extentTest.info("It is refreshed.");

        List<WebElement> ordersreadylistesi = merchantOrdersReady.merchantOrdersReadyList;
        extentTest.info("Orders ready list is created.");
        List<String> ordersReady = new ArrayList<>();

        for (WebElement each : ordersreadylistesi
        ) {
            String element = each.getText();
            ordersReady.add(element);
        }
        System.out.println(ordersReady);

        ReusableMethods.bekle(3);
        extentTest.info("It is waited for 3 seconds.");

        Assert.assertFalse(ordersReady.contains(ReadyForPickupOrderName));
        extentTest.pass("Verify that the selected product has been removed from the list.");

    }
}
