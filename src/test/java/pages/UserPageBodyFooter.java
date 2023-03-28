package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

public class UserPageBodyFooter {
    public UserPageBodyFooter(){ PageFactory.initElements(Driver.getDriver(),this);}

// UserPageBody
    @FindBy(xpath = "//h3")
    public WebElement UserPageReadBlogText;

    @FindBy(xpath = "//a[.='Join']")
    public WebElement UserPageBodyJoin;

    @FindBy(xpath = "(//h5)[1]")
    public WebElement UserPageBodyPopularNearby;


    @FindBy(xpath = "(//h5[.='No Minimum Order'])[1]")
    public WebElement UserPageBodyNoMinimumOrder;

    @FindBy(xpath = "(//h5[.='Track your delivery'])[1]")
    public WebElement UserPageBodyTrackDelivery;

    @FindBy(xpath = "(//h5[.='Delivery on time'])[1]")
    public WebElement UserPageBodyDeliveryOnTime;

    @FindBy(xpath = "(//h5[@class='m-0 section-title'])[2]")
    public WebElement UserPageBodyNewRestaurant;

    @FindBy(xpath = "(//img[@class='mobileapp'])[1]")
    public WebElement UserPageBodyMobileApp;

    //(//h5[.='Best restaurants'])[1]
    @FindBy(xpath = "(//h5[.='Best restaurants'])[1]")
    public WebElement UserPageBodyBestRestaurants;

    @FindBy(xpath = "(//h5[.='Coming soon...'])[1]")
    public WebElement UserPageBodyComingSoon;


    public void readBlog(String readNumber){
        UserPage userPage=new UserPage();

        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        ReusableMethods.bekle(1);
        userPage.userCookies.click();
        ReusableMethods.bekle(2);
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);
        Driver.getDriver().findElement(By.xpath("(//a[.='Read'])["+readNumber+"]")).click();



        if(readNumber.equals("1")){
            String actualText=UserPageReadBlogText.getText();
            System.out.println(actualText);
            String expected="Discover the Best Vegetarian Food Delivery Options in Your Area";
            Assert.assertEquals(actualText,expected);
        }
        if(readNumber.equals("2")){
            String actualText=UserPageReadBlogText.getText();
            String expected="The Benefits of Using a Food Delivery Platform for Your Healthy Lifestyle";
            Assert.assertEquals(actualText,expected);
        }
        if(readNumber.equals("3")){
            String actualText=UserPageReadBlogText.getText();
            String expected="How to Eat Healthy with Food Delivery";
            Assert.assertEquals(actualText,expected);
        }
    }

    // UserPageFooter

    @FindBy(xpath = "(//img[@class='img-200'])[2]")
    public WebElement UserPageFooterMealsCenterLogo;

    @FindBy(xpath = "//h6[.='Meals Center Corp.']")
    public WebElement UserPageFooterMealsCenterCorp;

    @FindBy(xpath = "//a[.='Contact us']")
    public WebElement UserPageFooterContuctUs;

    @FindBy(xpath = "//a[.='Terms and conditions']")
    public WebElement UserPageFooterTermsAndConditions;

    @FindBy(xpath = "//a[.='Privacy policy']")
    public WebElement UserPageFooterPrivacyPolicy;

    @FindBy(xpath = "//h6[.='Business']")
    public WebElement UserPageFooterBusiness;

    @FindBy(xpath = "//a[.='Become a Partner']")
    public WebElement UserPageFooterBecomeAPartner;

    @FindBy(xpath = "//h6[.='Blog']")
    public WebElement UserPageFooterBlog;

    @FindBy(xpath = "//i[@class='zmdi zmdi-facebook']")
    public WebElement UserPageFooterFacebookLogo;

    @FindBy(xpath = "//i[@class='zmdi zmdi-instagram']")
    public WebElement UserPageFooterInstagramLogo;

    @FindBy(xpath = "//i[@class='zmdi zmdi-linkedin']")
    public WebElement UserPageFooterLinkedinLogo;

    @FindBy(xpath = "//i[@class='zmdi zmdi-twitter']")
    public WebElement UserPageFooterTwitterLogo;

    @FindBy(xpath = "//i[@class='zmdi zmdi-youtube-play']")
    public WebElement UserPageFooterYoutubeLogo;

    @FindBy(xpath = "//a[.='Discover the Best Vegetarian Food Delivery Options in Your Area']")
    public WebElement UserPageFooterBlogDiscoverTheBestVeg;

    @FindBy(xpath = "//a[.='How to Eat Healthy with Food Delivery']")
    public WebElement UserPageFooterBlogHowTo;

    @FindBy(xpath = "//a[.='The Benefits of Using a Food Delivery Platform for Your Healthy Lifestyle']")
    public WebElement UserPageFooterBlogHowTheBenefits;

    @FindBy(xpath = "//a[.='Discover Healthy Food Delivery Options for Your Whole Family']")
    public WebElement UserPageFooterBlogDiscoverHealtyFood;

    @FindBy(xpath = "(//a[@href='#'])[3]")
    public WebElement UserPageFooterAppStoreLogo;

    @FindBy(xpath = "(//a[@href='#'])[4]")
    public WebElement UserPageFooterGooglePlayLogo;

    @FindBy(xpath = "//a[.='mealscenter.com']")
    public WebElement UserPageFooterMealsCenterLink;

    UserPage userPage=new UserPage();
    public void userFooter(){

        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        ReusableMethods.bekle(2);
        userPage.userCookies.click();
        JSUtilities.scrollToBottom(Driver.getDriver());
    }

    // Contuct Us Test Pages
    @FindBy(tagName = "h3")
    public WebElement UserPageContuctUsText;

    @FindBy(xpath = "(//h2)[1]")
    public WebElement UserPageContuctUsPhone;

    @FindBy(xpath = "(//h2)[1]")
    public WebElement UserPageContuctUsEmail;

    @FindBy(xpath = "//label[@for='AR_contact_fullname']")
    public WebElement UserPageContuctUsFullname;

    @FindBy(xpath = "AR_contact_email_address")
    public WebElement UserPageContuctUsEmailAddress;

    @FindBy(xpath = "//textarea[@placeholder='Your Message']")
    public WebElement UserPageContuctUsYourMessage;

    @FindBy(xpath = "//input[@class='btn btn-green w-100 mt-3']")
    public WebElement UserPageContuctUsYourMessageSubmit;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement UserPageContuctUsYourMessageText;



    public void contuctUsMethod(){
        userPage=new UserPage();
        UserPageBodyFooter userPageBodyFooter=new UserPageBodyFooter();
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        userPage.userCookies.click();
        JSUtilities.scrollToBottom(Driver.getDriver());
        ReusableMethods.bekle(1);
        userPageBodyFooter.UserPageFooterContuctUs.click();
        ReusableMethods.bekle(1);
        Actions actions=new Actions(Driver.getDriver());
        JSUtilities.scrollToElement(Driver.getDriver(),UserPageContuctUsFullname);
        userPageBodyFooter.UserPageContuctUsFullname.click();
        Faker faker= new Faker();
        actions.sendKeys(faker.name().fullName()).sendKeys(Keys.TAB).
                sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).
                sendKeys(faker.expression("Please Contact me by my Email address")).
                sendKeys(Keys.TAB).perform();
        ReusableMethods.bekle(2);
        userPageBodyFooter.UserPageContuctUsYourMessageSubmit.click();
    }







}
