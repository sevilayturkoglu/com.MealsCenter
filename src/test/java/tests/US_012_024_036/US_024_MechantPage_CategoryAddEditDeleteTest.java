package tests.US_012_024_036;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MerchantPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US_024_MechantPage_CategoryAddEditDeleteTest extends TestBaseReport {

    MerchantPage merchantPage = new MerchantPage();
    SoftAssert softAssert = new SoftAssert();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void addEditDeleteCategoriesTest() {

        extentTest = extentReports.createTest("Test of adding, editing and deleting retaurant ategories on the category list page", "I should be able to view, add, edit and delete categories of my restaurant.");

        merchantPage.merchantLogin();
        extentTest.info("The merchant home page is accessible.");

        Driver.getDriver().findElement(By.xpath("//li[@class='food']")).click();  // food un locator u
        extentTest.info("The food item below the dashboard is seen and clicked.");

        Driver.getDriver().findElement(By.xpath("//li[@class='position-relative food_category']")).click(); //categorynin locator u
        extentTest.info("The category item below the food item is seen and clicked.");

        Driver.getDriver().findElement(By.xpath("(//a[@type='button'])[1]")).click(); // add button locator u
        extentTest.info("The 'Add New' button on the 'Category List' page is seen and clicked.");

        Driver.getDriver().findElement(By.xpath("//label[@class='required']")).click(); // nameBox in locatoru
        String storeName = "Kayseri";
        actions.sendKeys(storeName).perform();
        extentTest.info("The 'Name' box on the 'All Category>>Add Category' page is seen and typed.");

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);
        WebElement saveButton = Driver.getDriver().findElement(By.cssSelector("input[value='Save']"));  // save button locator
        saveButton.click();
        extentTest.info("The 'Save' button on the 'All Category>>Add Category' page is seen and clicked.");

        Driver.getDriver().findElement(By.xpath("//li[@class='position-relative food_category active']")).click(); //categorynin locator u
        extentTest.info("After try to adding new category, The category item below the food item is clicked.");

        String firstName = Driver.getDriver().findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(2) h6:nth-child(1)")).getText();
        softAssert.assertTrue(firstName.contains(storeName));
        extentTest.info("Confirmed that a new item is added");

        ////////////////////////////////////////////

        Driver.getDriver().findElement(By.xpath("(//a[@data-toggle='tooltip'])[1]")).click(); // update button
        extentTest.info("On the 'Category List' page, next to added category item, The 'Update' button  seen and clicked.");

        Driver.getDriver().findElement(By.xpath("//textarea[@placeholder='Description']")).click(); // description un locator u
        String description = "Manti";
        actions.sendKeys(description).perform();
        extentTest.info("The 'Description' box on the 'All Category>>Update Category' page is seen and typed.");

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.bekle(1);

        Driver.getDriver().findElement(By.xpath("//input[@name='yt0']")).click(); // save butonunun locator u
        extentTest.info("The 'Save' button on the 'All Category>>Update Category' page is seen and clicked.");

        Driver.getDriver().findElement(By.xpath("//li[@class='position-relative food_category active']")).click(); //categorynin locator u
        extentTest.info("After try to editing added category, The category item below the food item is clicked.");

        String firstDescription = Driver.getDriver().findElement(By.xpath("//p[contains(text(),'0 Items')]")).getText();
        softAssert.assertTrue(firstDescription.contains(description));
        extentTest.info("Confirmed that the new item is edited");

        ////////////////////////////////////////////

        Driver.getDriver().findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(3) div:nth-child(1) a:nth-child(2) i:nth-child(1)")).click(); // delete kutusunun locator u
        extentTest.info("On the 'Category List' page, next to added category item, The 'Delete' button is seen and clicked.");

        ReusableMethods.bekle(1);

        Driver.getDriver().findElement(By.cssSelector(".btn.btn-green.item_delete")).click(); // cookie deki delete butonunun locator u
        extentTest.info("On the cookie, The 'Delete' button is seen and clicked.");

        Driver.getDriver().findElement(By.xpath("//li[@class='position-relative food_category active']")).click(); //categorynin locator u
        extentTest.info("After try to deleting added category, The category item below the food item is clicked.");

        ReusableMethods.bekle(1);

        String lastFirstName = Driver.getDriver().findElement(By.xpath(" //tbody/tr[1]/td[2]/h6[1]")).getText();

        softAssert.assertFalse(lastFirstName.contains(storeName));
        extentTest.info("Confirmed that the new item is deleted");

        softAssert.assertAll();

    }

}
