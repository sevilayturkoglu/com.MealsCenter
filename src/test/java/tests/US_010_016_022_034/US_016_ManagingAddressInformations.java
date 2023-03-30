package tests.US_010_016_022_034;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MerchantInformationPage;
import pages.UserPage;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US_016_ManagingAddressInformations extends TestBaseReport {

    UserPage userPage = new UserPage();
    MerchantInformationPage merchantInformationPage = new MerchantInformationPage();


    @Test
    public void TC_01601_ManagingAddressInformationsTest(){

        merchantInformationPage = new MerchantInformationPage();

        userPage= new UserPage();
        extentTest = extentReports.createTest("The Test of the Managing Address Informations", "Can I view, add, delete, change the informations of address in my acoount?");


        userPage.userLoginBeing();
        extentTest.info("As a user, I log in");

        userPage.userUstDDMenu("Addresses","https://qa.mealscenter.com/account/addresses");
        extentTest.info("Goes to addresses in my account");

        WebElement theTextofAddnewAddress= Driver.getDriver().findElement(By.xpath("//a[text()='Addresses']"));

        String actualText=theTextofAddnewAddress.getText();
        String expectedText="Address";

        extentTest.info("the view of the address page");
        Assert.assertTrue(actualText.contains(expectedText));

        extentTest.pass("My test is passed");

        Driver.getDriver().findElement(By.xpath("(//a[text()=' Add new address '])[1]")).isEnabled(); // enable to "add new address"
        extentTest.pass("Add new Address is enabled");

        Driver.getDriver().findElement(By.xpath("(//a[@class='btn normal small'])[1]")).isEnabled();// edit
        extentTest.pass("Edit is enabled");
        Driver.getDriver().findElement(By.xpath("(//a[@class='btn normal small'])[2]")).isEnabled(); // delete
        extentTest.pass("delete is enabled");

        WebElement addNewAddress = Driver.getDriver().findElement(By.xpath("//div[.=' Add new address ']"));
        extentTest.info("adding new address");
        ReusableMethods.bekle(2);

        addNewAddress.click();
        extentTest.info("clicking the new address");

        WebElement changeAddress= Driver.getDriver().findElement(By.xpath("(//input[@class='form-control form-control-text'])[1]"));
        extentTest.info("find the change address section");
        ReusableMethods.bekle(2);

        changeAddress.sendKeys("Canal Street, New York, NY 10013, USA",Keys.ENTER);
        extentTest.info("enter new address");

        ReusableMethods.bekle(2);

        WebElement newAddress = Driver.getDriver().findElement(By.xpath("(//a[@href='javascript:;'])[8]"));
        extentTest.info("finding location of the new address");
        JSUtilities.scrollToElement(Driver.getDriver(),newAddress);

        newAddress.click();

        merchantInformationPage.changedAddressSaveButton.click();

        ReusableMethods.bekle(2);

      String actualaddedAddress =  Driver.getDriver().findElement(By.xpath("(//div[@class='module truncate-overflow']/p)[1]")).getText();
      String expectedAddedAddress= "Canal Street";

      extentTest.pass("the test of the changing address");

        Assert.assertTrue(actualaddedAddress.contains(expectedAddedAddress));
        extentTest.pass("the new address is added");

        ReusableMethods.bekle(2);
        Driver.getDriver().findElement(By.xpath("(//a[.='Delete'])[1]")).click();
        extentTest.info("deleting the new address");

        Driver.getDriver().findElement(By.xpath("(//button[@type='button'])[11]")).click();
        extentTest.info("confirmation of the delete: click yes");










    }


}
