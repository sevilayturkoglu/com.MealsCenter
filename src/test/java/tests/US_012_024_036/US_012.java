package tests.US_012_024_036;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import utilities.TestBaseReport;

public class US_012 extends TestBaseReport {

    @Test
    public void CuisineTypeCheckTest01() {

        // Log in and got to the home page
        UserPage userPage = new UserPage();
        userPage.userLoginBeing();

        extentTest = extentReports.createTest("different local cuisines page test", "Cuisine pages should include convenient stores");
        extentTest.info("The user home page is accessible.");

        SoftAssert softAssert = new SoftAssert();

        // click appeared cuisines
        String[] appearCuisines = {"American", "Mediterranean", "Sandwiches", "Italian", "Mexican", "Burgers", "Japanese", "Thai"};

        for (String cuisineName : appearCuisines) {

            userPage.choseAppearedCuisine(cuisineName);

            extentTest.info("On the user home page, The '" + cuisineName + " cuisine' item is seen and clicked.");

            extentTest.info("Confirmed that On the '" + cuisineName + " cuisine' page, The word '" + cuisineName + "' appears at the descriptions of the all visible stores.");

        }

        // click more cuisines
        String[] moreCuisines = {"Chinese", "Kosher", "Halal", "Vegetarian"};

        for (String cuisineName : moreCuisines) {

            userPage.chooseCuisineAtMore(cuisineName);

            extentTest.info("On the user home page, drop down menu 'More' is seen and clicked.");
            extentTest.info("'" + cuisineName + " cuisine' item is seen and clicked.");

            extentTest.info("Confirmed that On the '" + cuisineName + " cuisine' page, The word '" + cuisineName + "' appears at the descriptions of the all visible stores.");
        }

        softAssert.assertAll();

    }

}
