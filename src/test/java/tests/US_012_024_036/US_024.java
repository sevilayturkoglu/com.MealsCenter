package tests.US_012_024_036;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.MerchantPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_024 {

    /*

        US_024  As a restaurant manager (to be able to view the categories of my restaurant, add a new category, edit and delete) I want to have the Category List page.
        24-- Acceptance Criteria

        * On the "https://qa.mealscenter.com/backoffice/food/category" page.
          Categories should be visible.
        * Adding category, deleting category and editing category should be possible
        * Changes made (such as adding, deleting and editing) should be visible.

        24-- Test Case

       * Follow the US_019 steps and
           Verify the url "https://qa.mealscenter.com/backoffice/food/category".
        * Verify that it works properly by clicking on the "Food" item and testing that the "Category" item is viewable.
        * Verify that there is a "Category List" item on the page that comes up after clicking on the "Category" item. (to verify that the categories are displayed)
        * Click the "Add new" button Type "Kayseri" in the "Name" box and click the "Save" button,
          then click "Category" and verify that the first item in the list contains "Kayseri".
        * Click the "Update (symbol: pen)" button next to the "Kayseri" item and verify that the title of the page is "Add Category".
        * Type "Manti" in the "Description" box and press the "Save" button, then click "Category" and verify that the first item in the list contains "Manti".
        * Click the "Delete" button next to the "Kayseri" item and verify that the "Delete Confirmation" item is visible.
        * Click the "Delete" button and verify that the first item in the list does not contain "Kayseri".


     */

    @Test
    public void MerchantAddEditDeleteCategoryTest01 () {

        // Merchant ana sayfaya giris yap ve git
        MerchantPage merchantPage = new MerchantPage();
        merchantPage.merchantLogin();
        ReusableMethods.bekle(1);

        // food a tikla
        Driver.getDriver().findElement(By.xpath("//li[@class='food']")).click(); // food un xpath i

        // category e tikla
        Driver.getDriver().findElement(By.xpath("//*[@id='yw0']/li[7]/ul/li[1]/a")).click(); // category nin xpath i
        ReusableMethods.bekle(1);

        Driver.getDriver().findElement(By.xpath("(//a[@type='button'])[1]")).click(); // add button un xpath i

        WebElement nameBox =  Driver.getDriver().findElement(By.xpath("//label[@class='required']")); // nameBox xpath
        nameBox.sendKeys("Nusret");

        WebElement saveButton = Driver.getDriver().findElement(By.xpath("//input[@type='submit']")); //saveButton xpath
        saveButton.click();










    }
}
