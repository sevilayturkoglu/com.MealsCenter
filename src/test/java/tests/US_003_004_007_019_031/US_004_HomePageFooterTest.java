package tests.US_003_004_007_019_031;

import org.testng.annotations.Test;
import pages.UserPage;
import pages.UserPageBodyFooter;
import utilities.TestBaseReport;

public class US_004_HomePageFooterTest extends TestBaseReport {

    UserPageBodyFooter userPageFooter;
    UserPage userPage;
    @Test
    public void TC_00401_FooterTextTest(){

        userPageFooter=new UserPageBodyFooter();
        extentTest=extentReports.createTest("Footer control","Is footer functions is visible and active");
        userPageFooter.userFooter();
        extentTest.info("Navigated to mealscenter page");

        userPageFooter.UserPageFooterMealsCenterLogo.isEnabled();
        extentTest.info("Meals Center Logo is active");

        userPageFooter.UserPageFooterMealsCenterCorp.isDisplayed();
        extentTest.info("Meals Center Corp. text is visible");
        userPageFooter.UserPageFooterContuctUs.isEnabled();
        extentTest.info("Contuct Us is active");
        userPageFooter.UserPageFooterTermsAndConditions.isEnabled();
        extentTest.info("Terms And Conditions is active");
        userPageFooter.UserPageFooterPrivacyPolicy.isEnabled();
        extentTest.info("Privacy Policy is active");

        userPageFooter.UserPageFooterBusiness.isDisplayed();
        extentTest.info("Business is visible");
        userPageFooter.UserPageFooterBecomeAPartner.isEnabled();
        extentTest.info("Become a Partner is active");


        userPageFooter.UserPageFooterBlog.isDisplayed();
        extentTest.info("Blog is visible");
        userPageFooter.UserPageFooterBlogDiscoverTheBestVeg.isEnabled();
        extentTest.info("Blog1 is active");
        userPageFooter.UserPageFooterBlogHowTheBenefits.isEnabled();
        extentTest.info("Blog2 is active");
        userPageFooter.UserPageFooterBlogHowTo.isEnabled();
        extentTest.info("Blog3 is active");
        userPageFooter.UserPageFooterBlogDiscoverHealtyFood.isEnabled();
        extentTest.info("Blog4 is active");

        userPageFooter.UserPageFooterFacebookLogo.isEnabled();
        extentTest.info("Facebook Logo is active");
        userPageFooter.UserPageFooterInstagramLogo.isEnabled();
        extentTest.info("Instagram Logo is active");
        userPageFooter.UserPageFooterLinkedinLogo.isEnabled();
        extentTest.info("Linkedin Logo is active");
        userPageFooter.UserPageFooterTwitterLogo.isEnabled();
        extentTest.info("Twitter Logo is active");
        userPageFooter.UserPageFooterYoutubeLogo.isEnabled();
        extentTest.info("Youtube Logo is active");

        userPageFooter.UserPageFooterAppStoreLogo.isDisplayed();
        extentTest.info("AppStore Logo is visible");
        userPageFooter.UserPageFooterGooglePlayLogo.isDisplayed();
        extentTest.info("Google Play Logo is visible");

        userPageFooter.UserPageFooterMealsCenterLink.isEnabled();
        extentTest.info("Meals Center Link is active");
    }
}
