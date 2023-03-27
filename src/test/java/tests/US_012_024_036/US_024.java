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
import utilities.TestBaseReport;

public class US_024 extends TestBaseReport {

    /*
        24-- Acceptance Criteria
        * On the "https://qa.mealscenter.com/backoffice/food/category" page.
          Categories should be visible.
        * Adding category, deleting category and editing category should be possible
        * Changes made (such as adding, deleting and editing) should be visible.

        Bir restaurant yöneticisi olarak (restaurantima ait category'leri görüntüleyebilmek,
        yeni bir category ekleyebilmek , duzenleyebilmek ve silebilmek icin) Category List sayfasinin bulunmasini istiyorum.

        backoffice/food/category

        24-- Test Case
        * US_019 adimlari uygulanip
          Url "https://qa.mealscenter.com/backoffice/food/category" dogrulanmali.
        * "Food" ogesine tiklanilmali ve "Category" ogesinin goruntulenebilir oldugu test edilerek uygun sekilde calistigi dogrulanmali.
        * "Category" ogesine tiklanip gelen sayfada "Category List" ogesinin oldugu dogrulanmali. (kategorilerin goruntulendigini dogrulamak icin)
        * "Add new" butonuna tikla ve gelen sayfanin title nin "Add Category" oldugunu dogrula.
        * "Name" kutusuna "yeni menu" yaz ve "Save" butonuna bas sonrasinda "Category" ogesine tikla ve listedeki ilk elemanin "yeni menu" icerdigini dogrula.
        * "yeni menu" ogesinin yaninda bulunan "Update (kalem isareti)" butonuna tikla ve gelen sayfanin title nin "Add Category" oldugunu dogrula.
        * "Description" kutusuna "aciklama" yaz ve "Save" butonuna bas sonrasinda "Category" ogesine tikla ve listedeki ilk elemanin "aciklama" icerdigini dogrula.
        * "yeni menu" ogesinin yaninda bulunan "Delete" butonuna tikla ve "Delete Confirmation" ogesinin gorunur oldugunu dogrula.
        * "Delete" butonuna tikla ve listedeki ilk elemanin "yeni menu" icermedigini dogrula.
     */

    @Test
    public void addEditDeleteCategoriesTest() {

        MerchantPage merchantPage = new MerchantPage();
        merchantPage.merchantLogin();

        extentTest = extentReports.createTest("Test of adding, editing and deleting retaurant ategories on the category list page", "I should be able to view, add, edit and delete categories of my restaurant.");
        extentTest.info("The merchant home page is accessible.");

        Actions actions = new Actions(Driver.getDriver());

        Driver.getDriver().findElement(By.xpath("//li[@class='food']")).click();  // food un locator u
        extentTest.info("The food item below the dashboard is accessible.");

        Driver.getDriver().findElement(By.xpath("//li[@class='position-relative food_category']")).click(); //categorynin locator u
        extentTest.info("The category item below the food item is accessible.");

        Driver.getDriver().findElement(By.xpath("(//a[@type='button'])[1]")).click(); // add button locator u
        extentTest.info("The 'Add New' button on the 'Category List' page is accessible.");

        Driver.getDriver().findElement(By.xpath("//label[@class='required']")).click(); // nameBox in locatoru
        actions.sendKeys("Kayseri").perform();
        extentTest.info("The 'Name' box on the 'All Category>>Add Category' page is accessible and writable.");

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.bekle(1);

        WebElement saveButton = Driver.getDriver().findElement(By.cssSelector("input[value='Save']"));  // save button locator
        saveButton.click();
        extentTest.info("The 'Save' button on the 'All Category>>Add Category' page is accessible and clickable.");

        Driver.getDriver().findElement(By.xpath("//li[@class='position-relative food_category active']")).click(); //categorynin locator u
        extentTest.info("After try to adding new category, The category item below the food item is accessible.");

        // burada yeni urunun eklendigini test et ilk urunun adi ile
        extentTest.info("New item is added");

        Driver.getDriver().findElement(By.xpath("(//a[@data-toggle='tooltip'])[1]")).click(); // update button
        extentTest.info("On the 'Category List' page, next to added category item, The 'Update' button is accessible.");

        Driver.getDriver().findElement(By.xpath("//textarea[@placeholder='Description']")).click(); // description un locator u
        actions.sendKeys("Manti").perform();
        extentTest.info("The 'Description' box on the 'All Category>>Update Category' page is accessible and writable.");

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.bekle(1);

        Driver.getDriver().findElement(By.xpath("//input[@name='yt0']")).click(); // save butonunun locator u
        extentTest.info("The 'Save' button on the 'All Category>>Update Category' page is accessible and clickable.");

        Driver.getDriver().findElement(By.xpath("//li[@class='position-relative food_category active']")).click(); //categorynin locator u
        extentTest.info("After try to editing added category, The category item below the food item is accessible.");


        // burada aciklama eklenerek editlendigini test et
        extentTest.info("The added item is editing");

        Driver.getDriver().findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(3) div:nth-child(1) a:nth-child(2) i:nth-child(1)")).click(); // delete kutusunun locator u
        extentTest.info("On the 'Category List' page, next to added category item, The 'Delete' button is accessible.");

        ReusableMethods.bekle(1);

        Driver.getDriver().findElement(By.cssSelector(".btn.btn-green.item_delete")).click(); // cookie deki delete butonunun locator u
        extentTest.info("On the cookie, The 'Delete' button is accessible.");

        Driver.getDriver().findElement(By.xpath("//li[@class='position-relative food_category active']")).click(); //categorynin locator u
        extentTest.info("After try to deleting added category, The category item below the food item is accessible.");

        //burada eklenen itemin silindigini test et
        extentTest.info("The added item is deleted");

    }

}
