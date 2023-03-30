package tests.US_005_014_015_017_029;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import utilities.*;

import java.time.Duration;

public class US_017_UserAccountAddresses extends TestBaseReport {

    /*
    As a user, I would like to have a page on the site
    where I can view, add, delete and change the payment information
    of my account.
     */

    UserPage userPage = new UserPage();
    SoftAssert softAssert = new SoftAssert();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void TC_01701_CrudUserPageTest(){

        userPage.userLoginSariye();
        extentTest = extentReports.createTest("User  Page Visibility Test", "User page of the user,should be visible.");
        extentTest.info("chrome browser and user page is active");
        ReusableMethods.bekle(3);
        extentTest.info("It is waited 3 seconds.");
        userPage.userUstDropDownButton.click();
        extentTest = extentReports.createTest("User dropdown menu ", "User dropdown,should be visible.");
        extentTest.info("user dropdown is active");
        ReusableMethods.bekle(3);
        userPage.userDDPaymentOptions.click();
        ReusableMethods.bekle(3);
        extentTest.info("User payment options is clicked.");

        String expectedResult = " Payments Options ";
        String actualResult = userPage.userDDPaymentOptions.getText();

        // adding cash payment
        userPage.userAddNewPaymentButton.click();
        ReusableMethods.bekle(3);

        userPage.userAddCashOnDeliveryButton.click();
        ReusableMethods.bekle(3);

        userPage.userAddCashButton.click();
        ReusableMethods.bekle(2);
        userPage.closeAddCashFrame.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        softAssert.assertTrue(wait.until(ExpectedConditions.invisibilityOf(userPage.closeAddCashFrame)));
        extentTest.info("cash payment option frame is closed");
        ReusableMethods.bekle(3);

        // deleting cash payment method from account
        //userPage.userCashPaymentDelete.click();
        ReusableMethods.bekle(5);

        // adding stripe payment

        userPage.userAddStripeButton.click();
        WebElement framem=Driver.getDriver().findElement(By.xpath("//iframe[@title='Secure card payment input frame']"));
        Driver.getDriver().switchTo().frame(framem);
        ReusableMethods.bekle(3);
        Driver.getDriver().findElement(By.xpath("//input[@name='cardnumber']")).sendKeys("4242 4242 4242 4242");
        Driver.getDriver().findElement(By.xpath("//input[@name='exp-date']")).sendKeys("04 / 24");
        Driver.getDriver().findElement(By.xpath("//input[@name='cvc']")).sendKeys("242");
        Driver.getDriver().findElement(By.xpath("//input[@name='postal']")).sendKeys("42424");
        Driver.getDriver().switchTo().parentFrame();
        Driver.getDriver().findElement(By.xpath("//span[.='Add Stripe']")).click();


        ReusableMethods.bekle(5);

        // deleting stripe
       //actions.sendKeys(Keys.PAGE_UP).perform();
       //actions.sendKeys(Keys.PAGE_UP).perform();
       //Driver.getDriver().findElement(By.xpath("(//a[@id='dropdownMenuLink'])[1]")).click();
       //ReusableMethods.bekle(5);
       //Driver.getDriver().findElement(By.xpath("(//a[.='Delete'])[1]")).click();


    }

}



