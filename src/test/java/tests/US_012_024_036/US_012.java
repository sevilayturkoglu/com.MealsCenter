package tests.US_012_024_036;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Objects;

public class US_012 {

    /*

        US_012  As a user, I would like to have a page with restaurants of different local cuisines.

        12-- Acceptance Criteria

        * Cuisine types on the "https://qa.mealscenter.com/" page should be clickable.
        * The descriptions of the stores on the opened page should include the cuisine name on the page.

        12-- Test Case

        * Follow the US_005 steps and
           The url "https://qa.mealscenter.com/" must be verified.
         * It should be verified that the name of the cuisine that appears on the page that comes up after clicking on the Cuisine type
           is included in the store description on the page.
         * The name of the cuisine that appears after clicking on the "More" dropdown on the page and clicking on the cuisine type,
           It should be verified that it is included in the description of the store on the page.

     */

    @Test
    public void CuisineTypeCheckTest01 () {

        // giris yap anasayfaya git
        UserPage userPage = new UserPage();
        userPage.userLoginBeing();
        userPage.userLogo.click(); // tam olarak anasayfa baslangicinda olmadigimiz icin anasayfaya cekiyoruz.


        // page down yap cuisineleri gormek icin
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);


        SoftAssert softAssert = new SoftAssert();

        //cuisine tikla

        String[] appearCuisines = {"American","Mediterranean","Sandwiches","Italian","Mexican","Burgers","Japanese","Thai"};
        for (int i = 0; i <= 7;) {
            String type = appearCuisines[i];
            Driver.getDriver().findElement(By.xpath("//div[@class='col cuisineMainPage']/a[.='" + type + "']")).click();
            String actCuisine = Driver.getDriver().findElement(By.xpath("//h4[@class='m-0']")).getText(); // cuisine sayfasindaki buyuk baslik
            String expCuisine = Driver.getDriver().findElement(By.xpath("(//div[@class='row align-items-center'])[1]")).getText();
            System.out.println(actCuisine);
            System.out.println(expCuisine);
            softAssert.assertTrue(expCuisine.contains(actCuisine));
            userPage.userLogo.click();
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            ReusableMethods.bekle(1);
            i++;
        }

        String[] moreCuisines = {"Chinese","Kosher","Halal","Vegetarian"};
        for (int i = 0; i <= 3;) {
            String type = moreCuisines[i];
        userPage.userCuisineMoreButton.click();
        Driver.getDriver().findElement(By.xpath("(//a[.='" + type + "'])[1]")).click();
            String actCuisine = Driver.getDriver().findElement(By.xpath("//h4[@class='m-0']")).getText(); // cuisine sayfasindaki buyuk baslik
            String expCuisine = Driver.getDriver().findElement(By.xpath("(//div[@class='row align-items-center'])[1]")).getText();
            System.out.println(actCuisine);
            System.out.println(expCuisine);
            softAssert.assertTrue(expCuisine.contains(actCuisine));
            userPage.userLogo.click();
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            ReusableMethods.bekle(1);
            i++;
        }

        softAssert.assertAll();

    }
}
