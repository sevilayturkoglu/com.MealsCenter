package tests.US_012_024_036;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import utilities.TestBaseReport;

public class US_012 extends TestBaseReport {

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
    public void CuisineTypeCheckTest01() {

        // Log in and got to the home page
        UserPage userPage = new UserPage();
        userPage.userLoginBeing();

        extentTest = extentReports.createTest("different local cuisines page test","Cuisine pages should include convenient stores");
        extentTest.info("The user home page is accessible.");

        SoftAssert softAssert = new SoftAssert();

        // click appeared cuisines
        String[] appearCuisines = {"American", "Mediterranean", "Sandwiches", "Italian", "Mexican", "Burgers", "Japanese", "Thai"};

        for (String cuisineName : appearCuisines) {

            userPage.choseAppearedCuisine(cuisineName);

            extentTest.info("On the user home page, The '" + cuisineName + " cuisine' item is clickable.");

            extentTest.info("On the '" + cuisineName + " cuisine' page, The word '" + cuisineName + "' appears in the descriptions of the stores ");

        }

        // click more cuisines
        String[] moreCuisines = {"Chinese", "Kosher", "Halal", "Vegetarian"};

        for (String cuisineName : moreCuisines) {

            userPage.chooseCuisineAtMore(cuisineName);

            extentTest.info("On the user home page, drop down 'More' and The '" + cuisineName + " cuisine' item is clickable.");

            extentTest.info("On the '" + cuisineName + " cuisine' page, The word '" + cuisineName + "' appears in the descriptions of the stores ");
        }

        softAssert.assertAll();

    }

}
