package tests.US_027_039;

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
        merchantOrderProcessing=new MerchantOrderProcessing();
       //SoftAssert softAssert=new SoftAssert();
       //softAssert.assertTrue(merchant_OrderProcessing.merchantOrdersButton.isDisplayed());
       //Burada x path calismiyor
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//a[.='Orders']")).isDisplayed());
        merchantPage.merchantMenuLeftSide("Orders");
        ReusableMethods.bekle(1);
       merchantPage.merchantMenuLeftSide("Orders Processing");
      Assert.assertTrue(merchantOrderProcessing.merchantOrdersProcessingButton.isDisplayed());
        Assert.assertTrue(merchantOrderProcessing.merchantOrdersProcessingButton.isEnabled());
        Assert.assertTrue(merchantOrderProcessing.merchantOrderProcessingText.isDisplayed());
    }

    @Test
    public void test2702(){
        merchantPage=new MerchantPage();
        merchantPage.merchantLogin();
        merchantOrderProcessing=new MerchantOrderProcessing();
        merchantPage.merchantMenuLeftSide("Orders");
        merchantOrderProcessing.merchantNewOrdersButtonu.click();
        String acceptedOrders=merchantOrderProcessing.merchantNewOrdersOrderNummer.getText();
        System.out.println(merchantOrderProcessing.merchantNewOrdersOrderNummer.getText());
        merchantOrderProcessing.merchantNewOrdersAcceptedButonu.click();
        Driver.getDriver().navigate().refresh();
        merchantOrderProcessing.merchantOrdersProcessingButton.click();

        List<WebElement> orderprocessinglistesi=merchantOrderProcessing.merchantOrdersProcessingList;
        List<String> orderPro=new ArrayList<>();

        for (WebElement each:orderprocessinglistesi
        ) {
            String element=each.getText();
            orderPro.add(element);
        }
        System.out.println(orderPro);

        ReusableMethods.bekle(3);

        Assert.assertTrue(orderPro.contains(acceptedOrders));

    }

    @Test
    public void test2703(){
        merchantPage=new MerchantPage();
        merchantPage.merchantLogin();
        merchantOrderProcessing=new MerchantOrderProcessing();
        merchantPage.merchantMenuLeftSide("Orders");
        merchantOrderProcessing.merchantOrdersProcessingButton.click();
        Assert.assertTrue(merchantOrderProcessing.deliveryInformation.isDisplayed());

    }

    @Test
    public void test2704(){
        merchantPage=new MerchantPage();
        merchantOrderProcessing=new MerchantOrderProcessing();
        merchantPage.merchantLogin();
        merchantPage.merchantMenuLeftSide("Orders");

        merchantOrderProcessing.merchantOrdersProcessingButton.click();
        Assert.assertTrue(merchantOrderProcessing.menchantReadyforPick.isDisplayed());
        Assert.assertTrue(merchantOrderProcessing.menchantReadyforPick.isEnabled());
    }
    @Test
    public void test2705(){
        merchantPage=new MerchantPage();
        merchantPage.merchantLogin();
        merchantPage.merchantMenuLeftSide("Orders");
        merchantOrderProcessing=new MerchantOrderProcessing();
        merchantOrderProcessing.merchantOrdersProcessingButton.click();
        String acceptedOrderName=merchantOrderProcessing.orderNumber.getText();
        System.out.println(acceptedOrderName);

        merchantOrderProcessing.menchantReadyforPick.click();
        ReusableMethods.bekle(3);
        Driver.getDriver().navigate().refresh();

        List<WebElement> orderprocessinglistesi=merchantOrderProcessing.merchantOrdersProcessingList;
        List<String> orderPro=new ArrayList<>();

        for (WebElement each:orderprocessinglistesi
        ) {
            String element=each.getText();
            orderPro.add(element);
        }
        System.out.println(orderPro);

        ReusableMethods.bekle(3);

        Assert.assertFalse(orderPro.contains(acceptedOrderName));






    }



}