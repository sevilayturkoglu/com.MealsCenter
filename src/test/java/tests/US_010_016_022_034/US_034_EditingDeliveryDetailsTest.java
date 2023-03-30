package tests.US_010_016_022_034;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DeliveryPage;
import pages.MerchantPage;
import pages.UserPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US_034_EditingDeliveryDetailsTest extends TestBaseReport {


    UserPage userPage = new UserPage();
    MerchantPage merchantPage = new MerchantPage();

    DeliveryPage deliveryPage = new DeliveryPage();


    @Test
    public void TC_03401_EditingDeliveryDetails(){

    userPage = new UserPage();
    merchantPage = new MerchantPage();
    deliveryPage= new DeliveryPage();

    extentTest=extentReports.createTest("Having DeliveryPage",
            "The Test of Having Page to edit the delivery details in the Order Type.");

   merchantPage.merchantLogin();
   extentTest.info("Browser starts and the page of merchant is logged in with valid credentials ");

   merchantPage.merchantMenuLeftSide("Order Type");
   extentTest.info("Order Type is clicked in the left side of the dashboardMenu");

   ReusableMethods.bekle(2);

    deliveryPage.orderType.click();
    extentTest.info("clicking orderType");

    deliveryPage.delivery.click();
    extentTest.info("clicking delivery");

    deliveryPage.setting.click();
    extentTest.info("clicking setting");


    ReusableMethods.bekle(2);

    Driver.getDriver().findElement(By.id("AR_option_merchant_service_fee")).clear();
    extentTest.info("clearing the service fee");
    ReusableMethods.bekle(2);

    Driver.getDriver().findElement(By.id("AR_option_merchant_service_fee")).sendKeys("12.00");
    extentTest.info("adding the new price");
    ReusableMethods.bekle(2);


      Driver.getDriver().findElement(By.xpath("//input[@type='submit']")).click();
      extentTest.info("submitting changes");

        String expectedResult="Settings saved";
        String actualResult=deliveryPage.settingsSaved.getText();
        Assert.assertEquals(actualResult,expectedResult);

        extentTest.pass("The Test of Having Page to edit the delivery details in the Order Type");





    }





}
