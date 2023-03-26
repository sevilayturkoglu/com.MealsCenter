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
    public void addEditDeleteCategoriesTest () {

        MerchantPage merchantPage = new MerchantPage();
        merchantPage.merchantLogin();

        Actions actions = new Actions(Driver.getDriver());

        Driver.getDriver().findElement(By.xpath("//li[@class='food']")).click();  // food un locator u
        Driver.getDriver().findElement(By.xpath("//li[@class='position-relative food_category']")).click(); //categorynin locator u
        Driver.getDriver().findElement(By.xpath("(//a[@type='button'])[1]")).click(); // add button locator u

        Driver.getDriver().findElement(By.xpath("//label[@class='required']")).click(); // nameBox in locatoru

        actions.sendKeys("Kayseri").perform();

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.bekle(1);

        WebElement saveButton = Driver.getDriver().findElement(By.cssSelector("input[value='Save']"));  // save button locator
        saveButton.click();

        Driver.getDriver().findElement(By.xpath("//li[@class='position-relative food_category active']")).click(); //categorynin locator u

        Driver.getDriver().findElement(By.xpath("(//a[@data-toggle='tooltip'])[1]")).click(); // edit button

        Driver.getDriver().findElement(By.xpath("//textarea[@placeholder='Description']")).click(); // description un locator u

        actions.sendKeys("Manti").perform();

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.bekle(1);

        Driver.getDriver().findElement(By.xpath("//input[@name='yt0']")).click(); // save butonunun locator u

        Driver.getDriver().findElement(By.xpath("//li[@class='position-relative food_category active']")).click(); //categorynin locator u

        Driver.getDriver().findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(3) div:nth-child(1) a:nth-child(2) i:nth-child(1)")).click(); // delete kutusunun locator u

        ReusableMethods.bekle(1);

        Driver.getDriver().findElement(By.cssSelector(".btn.btn-green.item_delete")).click(); // cookie deki delete butonunun locator u


        //   extentTest.info("  ")

        // Iceririk yazisi girilmesi gereken yerlerde faker yada Lorem ipsum kullanilmali














    }


}
