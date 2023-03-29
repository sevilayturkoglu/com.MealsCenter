package tests.US_003_004_007_019_031;

import org.testng.annotations.Test;
import pages.UserPage;
import pages.UserPageBodyFooter;
import utilities.TestBaseReport;

public class US_004_HomePageFooterTest extends TestBaseReport {

    UserPageBodyFooter userPageFooter;
    UserPage userPage;
    @Test
    public void footerTextTest(){

        userPageFooter=new UserPageBodyFooter();
        extentTest=extentReports.createTest("Footer control","Is footer functions is visible and active");
        userPageFooter.userFooter();
        extentTest.info("Navigated to mealscenter page");

        userPageFooter.UserPageFooterMealsCenterLogo.isEnabled();
        extentTest.pass("Meals Center Logo is active");

        userPageFooter.UserPageFooterMealsCenterCorp.isDisplayed();
        extentTest.pass("Meals Center Corp. text is visible");
        userPageFooter.UserPageFooterContuctUs.isEnabled();
        extentTest.pass("Contuct Us is active");
        userPageFooter.UserPageFooterTermsAndConditions.isEnabled();
        extentTest.pass("Terms And Conditions is active");
        userPageFooter.UserPageFooterPrivacyPolicy.isEnabled();
        extentTest.pass("Privacy Policy is active");

        userPageFooter.UserPageFooterBusiness.isDisplayed();
        extentTest.pass("Business is visible");
        userPageFooter.UserPageFooterBecomeAPartner.isEnabled();
        extentTest.pass("Become a Partner is active");


        userPageFooter.UserPageFooterBlog.isDisplayed();
        extentTest.pass("Blog is visible");
        userPageFooter.UserPageFooterBlogDiscoverTheBestVeg.isEnabled();
        extentTest.pass("Blog1 is active");
        userPageFooter.UserPageFooterBlogHowTheBenefits.isEnabled();
        extentTest.pass("Blog2 is active");
        userPageFooter.UserPageFooterBlogHowTo.isEnabled();
        extentTest.pass("Blog3 is active");
        userPageFooter.UserPageFooterBlogDiscoverHealtyFood.isEnabled();
        extentTest.pass("Blog4 is active");

        userPageFooter.UserPageFooterFacebookLogo.isEnabled();
        extentTest.pass("Facebook Logo is active");
        userPageFooter.UserPageFooterInstagramLogo.isEnabled();
        extentTest.pass("Instagram Logo is active");
        userPageFooter.UserPageFooterLinkedinLogo.isEnabled();
        extentTest.pass("Linkedin Logo is active");
        userPageFooter.UserPageFooterTwitterLogo.isEnabled();
        extentTest.pass("Twitter Logo is active");
        userPageFooter.UserPageFooterYoutubeLogo.isEnabled();
        extentTest.pass("Youtube Logo is active");

        userPageFooter.UserPageFooterAppStoreLogo.isDisplayed();
        extentTest.pass("AppStore Logo is visible");
        userPageFooter.UserPageFooterGooglePlayLogo.isDisplayed();
        extentTest.pass("Google Play Logo is visible");

        userPageFooter.UserPageFooterMealsCenterLink.isEnabled();
        extentTest.pass("Meals Center Link is active");
    }
}
