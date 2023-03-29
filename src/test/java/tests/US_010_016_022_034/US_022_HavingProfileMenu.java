package tests.US_010_016_022_034;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MerchantInformationPage;
import pages.MerchantPage;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US_022_HavingProfileMenu extends TestBaseReport {

    MerchantPage merchantPage = new MerchantPage();

    MerchantInformationPage merchantInformationPage = new MerchantInformationPage();


    @Test
    public void TC_02201_HavingProfileMenu(){

    merchantPage= new MerchantPage();
    merchantInformationPage = new MerchantInformationPage();


        extentTest=extentReports.createTest("The Test of Having Page to edit  the Merchant profile information",
                "Can I edit the Merchant profile information");

        merchantPage.merchantLogin();
        extentTest.info("As a restaurant manager, I log in ");

        merchantInformationPage.merchantDashboard.click();
        extentTest.info("goes to Merchant Dashboard");

        merchantInformationPage.merchantInformation.click();
        extentTest.info("goes to the Merchant Information");

       WebElement updateInformation=  Driver.getDriver().findElement(By.xpath("//a[text()='Update Information']"));
       extentTest.info("goes to Update Information");
        String actualTitle=updateInformation.getText();
        String expectedTitle="Update Information";

        extentTest.info("The test of actual and expected result");
        extentTest.pass("Seen the function of the edit works properly");


        merchantInformationPage.browserButtonLogo.click();
        extentTest.info("clicking to Browser to see photos for the logo");

        ReusableMethods.bekle(2);

        merchantInformationPage.selectLogoPhoto.click();

        extentTest.info("Selecting a photo for the logo");

        ReusableMethods.bekle(2);


        merchantInformationPage.addButtonLogo.click();
        extentTest.info("Adding selected photo for the logo ");

        ReusableMethods.bekle(2);

        merchantInformationPage.browserButtonHeader.click();
        extentTest.info("Clicking to Browser to see photos for the Header");

        ReusableMethods.bekle(3);

        merchantInformationPage.selectHeaderPhoto.click();
        extentTest.info("Selecting a photo for the Header");


        ReusableMethods.bekle(2);

        merchantInformationPage.addButtonHeader.click();
        extentTest.info("Adding selected photo for the header");

        JSUtilities.scrollToBottom(Driver.getDriver());
        ReusableMethods.bekle(3);

        merchantInformationPage.saveButton.click();
        extentTest.info("Saving changes");

        WebElement successfullyUpdated=Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-success']"));
        extentTest.info("Clicking save");

        String actualResult=successfullyUpdated.getText();
        String expectedResult="Succesfully updated";
        extentTest.pass("Succesfully updated");

        Assert.assertTrue(actualResult.contains(expectedResult));
        extentTest.pass("The Test of Having Page to edit the Merchant profile information");


    }


}



