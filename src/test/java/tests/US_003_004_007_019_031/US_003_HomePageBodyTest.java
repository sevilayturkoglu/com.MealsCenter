package tests.US_003_004_007_019_031;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import pages.UserPageBodyFooter;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US_003_HomePageBodyTest extends TestBaseReport {

    UserPageBodyFooter userPageBody=new UserPageBodyFooter();
    UserPage userPage = new UserPage();
    SoftAssert softAssert = new SoftAssert();
       @DataProvider
    public static Object[][] readBlock() {
        String[][] number = {{"1"}, {"2"}, {"3"}};
        return number;
    }

    @Test(dataProvider = "readBlock")
    public void visibilityOfProfilePageTest(String sayi) {
        userPage = new UserPage();
        userPageBody=new UserPageBodyFooter();
        extentTest=extentReports.createTest("Read Blog Test","Read buttons should be active and when clicked executes intented action");
        userPageBody.readBlog(sayi);
        extentTest.pass("Active read buttons executes intented action");
        Driver.closeDriver();
    }

    @Test
    public void cousineSelect(){
        userPage=new UserPage();
        userPageBody=new UserPageBodyFooter();
        extentTest=extentReports.createTest("Body Cousine Select Test","Cousines should be selected");
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        extentTest.info("Open Home Page");
        ReusableMethods.bekle(2);
        userPage.userCookies.click();
        extentTest.info("reject cookies");
        ReusableMethods.bekle(2);
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("page_down");
        ReusableMethods.bekle(2);
        userPage.userChoseAppearCuisine("American");
        extentTest.pass("cousine selected");
    }
    @Test
    public void userBodyTest(){
        userPage=new UserPage();
        userPageBody=new UserPageBodyFooter();
        extentTest=extentReports.createTest("Body basliklari kontrol","Is body functions visible and active");
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        extentTest.info("Browser lounched, navigated to MealsCenter");
        ReusableMethods.bekle(3);
        userPage.userCookies.click();
        extentTest.info("Cookies rejected");
        userPageBody.UserPageBodyPopularNearby.isDisplayed();
        extentTest.pass("Popular Nearby is visible");
        userPageBody.UserPageBodyNoMinimumOrder.isDisplayed();
        extentTest.pass("No min order is visible");
        userPageBody.UserPageBodyTrackDelivery.isDisplayed();
        extentTest.pass("Track Your Delivery is visible");
        userPageBody.UserPageBodyDeliveryOnTime.isDisplayed();
        extentTest.pass("Delivery on time is visible");
        userPageBody.UserPageBodyNewRestaurant.isDisplayed();
        extentTest.pass("New Restaurant is visible");
        userPageBody.UserPageBodyBestRestaurants.isDisplayed();
        extentTest.pass("Best Restaurants with Meals Center is visible");
        userPageBody.UserPageBodyMobileApp.isDisplayed();
        extentTest.pass("Mobile App img is visible");
        userPageBody.UserPageBodyComingSoon.isDisplayed();
        extentTest.pass("Coming soon... is visible");
        userPageBody.UserPageBodyJoin.isEnabled();
        extentTest.pass("User Body Page Join button is active");

        softAssert.assertAll();
    }
}
