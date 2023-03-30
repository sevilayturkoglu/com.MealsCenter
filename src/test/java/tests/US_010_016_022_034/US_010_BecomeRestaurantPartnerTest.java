package tests.US_010_016_022_034;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import pages.VisitorPage;
import utilities.*;

public class US_010_BecomeRestaurantPartnerTest extends TestBaseReport {

    UserPage userPage = new UserPage();
    VisitorPage visitorPage;

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void TC_01001_BecomeRestaurantPartnerTest() {

        visitorPage = new VisitorPage();
        userPage = new UserPage();

        extentTest = extentReports.createTest("As a restaurant owner, having a page", "Entering and Applying the necessary information to be the site");

        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();

        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        extentTest.info("Starts to main page and to the URL of the mealsCenter ");

        ReusableMethods.bekle(3);

        userPage.userCookies.click();
        extentTest.info("declining the cookies");

        JSUtilities.scrollToBottom(Driver.getDriver());
        extentTest.info(" goes to the bottom of the page to click 'Become a Partner'");

        ReusableMethods.bekle(2);

        visitorPage.becomeRestaurantPartner.click();
        extentTest.info("clicking the button 'Become a Partner'");

        visitorPage.theTitleofBecomingPartner.getText();
        extentTest.info("The Title of 'Become Restaurant partner'");

        String theActualTitle= visitorPage.theTitleofBecomingPartner.getText();
        String expectedTitle= "Become Restaurant partner";

        Assert.assertTrue(theActualTitle.contains(expectedTitle));
        extentTest.pass("'Become Restaurant partner' text is displayed");

        visitorPage.partnerStoreName.click();
        actions.sendKeys(faker.name().fullName()).
                sendKeys(Keys.TAB).
                sendKeys("22204").perform();

        extentTest.info("choosing a store name and address from faker");

        ReusableMethods.bekle(3);

        actions.sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();

        actions.sendKeys(Keys.TAB).
                sendKeys(faker.internet().emailAddress()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(faker.phoneNumber().phoneNumber()).
                sendKeys(Keys.TAB).perform();
        extentTest.info("entering e-mailAddress and phoneNumber from faker");

        visitorPage.partnerCommissionButton.click();
        extentTest.info("clicking commission choice");
        ReusableMethods.bekle(2);

        JSUtilities.scrollToElement(Driver.getDriver(), visitorPage.partnerStoreSubmit);
        visitorPage.partnerStoreSubmit.click();
        extentTest.info("clicking button of submit of necesssary information");

        ReusableMethods.bekle(2);

        JSUtilities.scrollToElement(Driver.getDriver(), visitorPage.partnerUserFirstName);
        extentTest.info("goes to information section under the name of the register user");

        ReusableMethods.bekle(2);

        visitorPage.partnerUserFirstName.sendKeys(faker.name().firstName());
        extentTest.info("choose a first name from faker");

      actions.sendKeys(Keys.TAB).
              sendKeys(faker.name().lastName()).
              sendKeys(Keys.TAB).
              sendKeys(faker.internet().emailAddress()).
              sendKeys(Keys.TAB).
              sendKeys(Keys.TAB).
              sendKeys(faker.phoneNumber().cellPhone()).
              sendKeys(Keys.TAB).
              sendKeys(faker.name().username()).
              sendKeys(Keys.TAB).
              sendKeys("123456").
              sendKeys(Keys.TAB).
              sendKeys(Keys.TAB).
              sendKeys("123456").
              sendKeys(Keys.TAB).
              sendKeys(Keys.TAB).
              sendKeys(Keys.TAB).
              sendKeys(Keys.TAB).perform();

      extentTest.info("entering lastName, emailAdress, phoneNumber,user name from faker");

      visitorPage.partnerUserSignUp.click();
      extentTest.info("clicking the partner user registration");

      System.out.println(visitorPage.contactedMessage.getText());

      String actualContactedMessage=visitorPage.contactedMessage.getText();
      String expectedMessage="You'll be contacted soon!";

      Assert.assertTrue(actualContactedMessage.contains(expectedMessage));
      extentTest.pass("verified that the restaurant owner will be contacted soon ");

    }

    }
