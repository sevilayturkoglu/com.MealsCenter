package tests.US_008_020_032;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MerchantPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

import java.util.ArrayList;
import java.util.List;

public class US_032_MerchantAttributesIngredients extends TestBaseReport {

    MerchantPage merchantPage = new MerchantPage();
    SoftAssert softAssert = new SoftAssert();
    Actions actions = new Actions(Driver.getDriver());


    @Test(priority = 1)
    public void TC_3210_ControlIngredientsMenu() {

        //  1- Login as merchants

        merchantPage = new MerchantPage();
        merchantPage.merchantLogin();
        extentTest=extentReports.createTest("Controling ingredients menu in the Attributes and its functions","Ability to enable the ingredients menu");

        //  2-Verify  the “merchant/dashboard” page is visiable

        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "merchant/dashboard";
        softAssert.assertTrue(actualUrl.contains(expectedUrl));
        extentTest.info("Merchant/dashboard is seen");

        //  3-Verify the “Attributes” is visible and clickable in the menu

        softAssert.assertTrue(merchantPage.attributes.isDisplayed());
        softAssert.assertTrue(merchantPage.attributes.isEnabled());
        extentTest.info("Attributes menu is enabled");
        ReusableMethods.bekle(1);

        //  4-Verify the list of Attributes include Ingredients  visible and  clickable

        merchantPage.merchantMenuLeftSide("Attributes");
        actions = new Actions(Driver.getDriver());
        actions.moveToElement(merchantPage.attributes).clickAndHold();
        extentTest.info("Attributes menu is clickable");
        ReusableMethods.bekle(1);

        // 5-Verify the Ingredients is enabled

        merchantPage.ingredients.click();
        String actualIngredientsUrl = Driver.getDriver().getCurrentUrl();
        String expectedIngredientsUrl = "ingredients_list";
        softAssert.assertTrue(actualIngredientsUrl.contains(expectedIngredientsUrl));
        extentTest.info("Ingredienst menu is seen");
        ReusableMethods.bekle(1);
        extentTest.info("the page is closed");
        extentTest.pass("Ingredienst menu is available");
        softAssert.assertAll();
        Driver.closeDriver();

    }

    @Test(priority = 5)
    public void TC_3211_sortSizeNumberList() {

        // 1-Sort the items according to their number

        merchantPage = new MerchantPage();
        merchantPage.merchantLogin();
        extentTest=extentReports.createTest("Controling the ingredients are sorted by number","Ability to the ingredients list sorting by number");
        merchantPage.attributes.click();
        extentTest.info("Attributes menu is clicked");
        merchantPage.ingredients.click();
        extentTest.info("Size menu is clicked");
        merchantPage.sortForNumber();
        ReusableMethods.bekle(2);
        softAssert.assertTrue(merchantPage.sortingNumber.isEnabled());
        extentTest.pass("The number of the ingredients are sorted");
        extentTest.info("the page is closed");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(priority = 10)
    public void TC_3212_sortNameList() {

        // 1-Sort the items according to their names

        merchantPage = new MerchantPage();
        merchantPage.merchantLogin();
        extentTest=extentReports.createTest("Controling the ingredients are sorted by name","Ability to the ingredients list sorting by name");
        merchantPage.attributes.click();
        extentTest.info("Attributes menu is clicked");
        merchantPage.ingredients.click();
        extentTest.info("ingredients menu is clicked");
        merchantPage.sortForName();
        ReusableMethods.bekle(2);
        softAssert.assertTrue(merchantPage.sortingName.isEnabled());
        extentTest.pass("The names of the ingredients are sorted");
        Driver.closeDriver();
        extentTest.info("the page is closed");


    }

    @Test(priority = 15)
    public void TC_3213_sortActionsList() {

        // 1-Sort the items according to their actions

        merchantPage = new MerchantPage();
        merchantPage.merchantLogin();
        extentTest=extentReports.createTest("Controling the ingredients are sorted by action","Ability to the ingredients list sorting by action");
        merchantPage.attributes.click();
        merchantPage.ingredients.click();
        merchantPage.sortFoActions();
        ReusableMethods.bekle(2);
        softAssert.assertTrue(merchantPage.sortingAction.isEnabled());
        Driver.closeDriver();
    }

    @Test(priority = 20)
    public void TC_3214_searchBox() {

        // 1-Verify the searchbox

        merchantPage = new MerchantPage();
        merchantPage.merchantLogin();
        extentTest=extentReports.createTest("Controling the searchbox is active","Ability to the serach box is functional");
        merchantPage.attributes.click();
        extentTest.info("Attributes menu is clicked");
        merchantPage.ingredients.click();
        extentTest.info("ingredients menu is clicked");
        merchantPage.searchBox.sendKeys(ConfigReader.getProperty("searchIngredients"));
        ReusableMethods.bekle(2);
        merchantPage.searchButton.click();
        ReusableMethods.bekle(2);
        extentTest.info("Searchbox is clicked");
        softAssert.assertTrue(merchantPage.searchBox.isEnabled());
        softAssert.assertTrue(merchantPage.searchButton.isEnabled());
        extentTest.pass("The search Box is activated");
        Driver.closeDriver();
        extentTest.info("the page is closed");


    }

    @Test(priority = 25)
    public void TC_3215_CreateIngredients() {

        // 1- Login as merchants

        merchantPage = new MerchantPage();
        merchantPage.merchantLogin();
        extentTest=extentReports.createTest("Controling creation of a new attributes item ","Ability to create a new attributes item");
        ReusableMethods.bekle(2);

        // 2-Click the “Attributes” in the menu

        merchantPage.attributes.click();
        extentTest.info("Attributes menu is clicked");
        ReusableMethods.bekle(2);

        // 3-Click the “ingredients” in the menu

        merchantPage.ingredients.click();
        extentTest.info("ingredients menu is clicked");
        ReusableMethods.bekle(2);

        // 4-Verify the "Ingredients_list" is enabled

        String actualIngredientsUrl = Driver.getDriver().getCurrentUrl();
        String expectedIngredientsUrl = "ingredients_list";
        softAssert.assertTrue(actualIngredientsUrl.contains(expectedIngredientsUrl));
        extentTest.info("ingredients list page is enabled");
        ReusableMethods.bekle(1);

        // 5-Verify the “ + Add new” link is visible and enable

        softAssert.assertTrue(merchantPage.plusSymbol.isDisplayed());
        softAssert.assertTrue(merchantPage.plusSymbol.isEnabled());
        extentTest.info("+ Add new button is enabled");
        ReusableMethods.bekle(2);

        List<WebElement> ingredientsListFirst = merchantPage.sortingNameList;
        List<String> ingredientsListFirstStr = new ArrayList<>();


        for (WebElement each : ingredientsListFirst) {
            ingredientsListFirstStr.add(each.getText().substring(0, 8));
        }

        System.out.println(ingredientsListFirstStr);
        extentTest.info("The current ingredients are listed");


        // 6-Click the “+ Add new” link

        merchantPage.plusSymbol.click();
        extentTest.info("+ Add new button is clicked");
        ReusableMethods.bekle(2);

        // 7- Verify the “size_create” page is enabled

        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "ingredients_create";
        softAssert.assertTrue(actualUrl.contains(expectedUrl));
        extentTest.info("ingredients create page is enabled");
        ReusableMethods.bekle(2);

        // 8- Verify the “Ingredients Name” box is active

        merchantPage.ingredientsNameElementi.sendKeys(ConfigReader.getProperty("ingredientsName"));
        ReusableMethods.bekle(2);
        softAssert.assertTrue(merchantPage.ingredientsNameElementi.isDisplayed());
        extentTest.info("A new ingredients name is enabled ");

        actions = new Actions(Driver.getDriver());
        actions.click(merchantPage.ingredientsNameElementi)
                .sendKeys(Keys.TAB).perform();

        // 9-Verify the “Status” box is active and options are selective

        merchantPage.statusElementleri.click();
        extentTest.info("Status box is clicked");
        softAssert.assertTrue(merchantPage.statusElementleri.isDisplayed());
        actions.click(merchantPage.statusElementleri)
                .sendKeys(Keys.TAB).perform();

        Select select = new Select(merchantPage.statusElementleri);
        select.selectByValue("publish");
        extentTest.info(" The publish option is selected ");

        // 10- Verify the “Item translation” box is visiable and clickable

        actions = new Actions(Driver.getDriver());

        merchantPage.itemTranslation.click();
        softAssert.assertTrue(merchantPage.itemTranslation.isDisplayed());
        softAssert.assertTrue(merchantPage.itemTranslation.isEnabled());
        actions.click(merchantPage.itemTranslation)
                .sendKeys(Keys.TAB).perform();
        extentTest.info("The item translation is clicked ");

        //11- Verify the “Japanese translation” box is visiable

        actions = new Actions(Driver.getDriver());

        actions.click(merchantPage.japaneseTranslation).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).perform();
        merchantPage.japaneseTranslation.sendKeys(ConfigReader.getProperty("japanese"));
        extentTest.info("An japanese word is sent");

        String actualJapanese = merchantPage.japaneseTranslation.getText();
        String expectedJapanese = "japonca";
        softAssert.assertTrue(actualJapanese.contains(expectedJapanese));
        softAssert.assertTrue(merchantPage.japaneseTranslation.isDisplayed());
        extentTest.info("An japanese word is written");
        ReusableMethods.bekle(1);

        actions.click(merchantPage.japaneseTranslation).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

        // 12-Verify the “Arabic translation” box is visiable

        actions = new Actions(Driver.getDriver());

        actions.click(merchantPage.arabicTranslation).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).perform();
        merchantPage.arabicTranslation.sendKeys(ConfigReader.getProperty("arabic"));
        extentTest.info("An arabic word is sent");

        String actualArabic = merchantPage.arabicTranslation.getText();
        String expectedArabic = "arapca";
        softAssert.assertTrue(actualArabic.contains(expectedArabic));
        softAssert.assertTrue(merchantPage.arabicTranslation.isDisplayed());
        actions.click(merchantPage.arabicTranslation).sendKeys(Keys.TAB).perform();
        extentTest.info("An arabic word is written");
        ReusableMethods.bekle(1);

        //13- Verify the “Save” button is visible and active

        actions = new Actions(Driver.getDriver());

        actions.click(merchantPage.arabicTranslation).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).perform();
        softAssert.assertTrue(merchantPage.attSaveButton.isDisplayed());
        ReusableMethods.bekle(2);
        softAssert.assertTrue(merchantPage.attSaveButton.isEnabled());
        extentTest.info("Save button is enabled");
        ReusableMethods.bekle(2);
        merchantPage.attSaveButton.click();
        extentTest.info("Save button is clicked");

        // 14-Verify the new item visible in the “ingredients_list” page

        String actUrl = Driver.getDriver().getCurrentUrl();
        String expUrl = "ingredients_list";
        softAssert.assertEquals(actUrl, expUrl);
        ReusableMethods.bekle(2);

        List<WebElement> ingredientsListLast = merchantPage.sortingNameList;
        List<String> ingredientsListLastStr = new ArrayList<>();


        for (WebElement each : ingredientsListLast) {
            ingredientsListLastStr.add(each.getText().substring(0, 8));
        }

        System.out.println(ingredientsListLastStr);

        Assert.assertFalse(ingredientsListLastStr.contains(ingredientsListFirstStr));
        extentTest.info("The current list and the new list are compared");

        // 15-Close Driver

        Driver.closeDriver();
        extentTest.pass("The new size item is created");
        extentTest.info("the page is closed");


    }


    @Test(priority = 30)
    public void TC_3216_PozitifUpdateIngredients() {

        // 1-Login as Merchants

        merchantPage = new MerchantPage();
        merchantPage.merchantLogin();
        extentTest=extentReports.createTest("Controling the update of a ingredients item ","Ability to update a ingredients item");

        // 2-Click the “Attributes” in the menu

        merchantPage.attributes.click();
        extentTest.info("attributes is clicked");
        ReusableMethods.bekle(2);

        // 3-Click the “ingredients” in the menu

        merchantPage.ingredients.click();
        extentTest.info("ingredients menu is clicked");
        ReusableMethods.bekle(2);

        // 4-Verify the “ingredients_list” page is visible and enable

        String actualIngredientsUrl = Driver.getDriver().getCurrentUrl();
        String expectedIngredientsUrl = "ingredients_list";
        softAssert.assertTrue(actualIngredientsUrl.contains(expectedIngredientsUrl));
        extentTest.info("ingredients list menu is enabled");
        ReusableMethods.bekle(2);

        // 5-Verify the “Update” link is visible and enable to edit the size.

        Assert.assertTrue(merchantPage.updateButonu1.isEnabled());
        extentTest.info("Update button is enabled");
        merchantPage.updateButonu1.click();

        // 6-Verify the “ingredients_update/id/” page is  enabled

        String actualUpdateUrl = Driver.getDriver().getCurrentUrl();
        String expectedUpdateUrl = "ingredients_update/id";
        softAssert.assertTrue(actualUpdateUrl.contains(expectedUpdateUrl));
        extentTest.info("the update ingredients page is seen");
        ReusableMethods.bekle(2);

        // 7-Verify the “ingredients Name” box is active

        merchantPage.ingredientsNameElementi.clear();
        merchantPage.ingredientsNameElementi.sendKeys(ConfigReader.getProperty("upDatedIngredientsName"));
        extentTest.info("The name is changed");
        ReusableMethods.bekle(2);

        actions = new Actions(Driver.getDriver());
        actions.click(merchantPage.ingredientsNameElementi)
                .sendKeys(Keys.TAB).perform();

        // 8-Verify the “Status” box is active and options are selective


        merchantPage.statusElementleri.click();
        extentTest.info("status button is clicked");
        actions.click(merchantPage.statusElementleri)
                .sendKeys(Keys.TAB).perform();

        Select select = new Select(merchantPage.statusElementleri);
        select.selectByValue("publish");
        extentTest.info("publish option is selected");
        ReusableMethods.bekle(1);

        // 9- Verify the “Item translation” box is visiable and clickable

        actions = new Actions(Driver.getDriver());

        merchantPage.itemTranslation.click();
        extentTest.info("Item translation is clicked");
        softAssert.assertTrue(merchantPage.itemTranslation.isDisplayed());
        softAssert.assertTrue(merchantPage.itemTranslation.isEnabled());
        extentTest.info("Item translation is enabled");
        actions.click(merchantPage.itemTranslation)
                .sendKeys(Keys.TAB).perform();

        // 10- Verify the “Japanese translation” box is visiable

        actions = new Actions(Driver.getDriver());

        actions.click(merchantPage.japaneseTranslation).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).perform();

        merchantPage.japaneseTranslation.clear();
        extentTest.info("Japanese word is cleaned");

        ReusableMethods.bekle(1);
        merchantPage.japaneseTranslation.sendKeys(ConfigReader.getProperty("japanese"));
        extentTest.info("New japanese word is written");


        String actualJapanese = merchantPage.japaneseTranslation.getText();
        String expectedJapanese = "japonca";
        softAssert.assertTrue(actualJapanese.contains(expectedJapanese));
        softAssert.assertTrue(merchantPage.japaneseTranslation.isDisplayed());
        extentTest.info("Japanese box is enabled");
        ReusableMethods.bekle(1);

        actions.click(merchantPage.japaneseTranslation).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

        // 11-Verify the “Arabic translation” box is visiable

        actions = new Actions(Driver.getDriver());

        actions.click(merchantPage.arabicTranslation).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).perform();

        merchantPage.arabicTranslation.clear();
        extentTest.info("arabic word is cleaned");
        ReusableMethods.bekle(1);
        merchantPage.arabicTranslation.sendKeys(ConfigReader.getProperty("arabic"));
        extentTest.info("New arabic word is written");

        String actualArabic = merchantPage.arabicTranslation.getText();
        String expectedArabic = "arapca";
        softAssert.assertTrue(actualArabic.contains(expectedArabic));
        softAssert.assertTrue(merchantPage.arabicTranslation.isDisplayed());
        extentTest.info("Arabic box is enabled");

        actions.click(merchantPage.arabicTranslation).sendKeys(Keys.TAB).perform();
        ReusableMethods.bekle(1);

        // 12- Verify the “Save” button is visible and active

        softAssert.assertTrue(merchantPage.attSaveButton.isDisplayed());
        ReusableMethods.bekle(2);
        softAssert.assertTrue(merchantPage.attSaveButton.isEnabled());
        extentTest.info("Save button is enabled");
        ReusableMethods.bekle(2);

        merchantPage.attSaveButton.click();
        extentTest.info("Save button is clicked");
        ReusableMethods.bekle(2);

        // 13-Verify the updated is successful

        softAssert.assertTrue(merchantPage.updated.isDisplayed());
        extentTest.pass("the item is updated");

        // 14-Close the page

        Driver.closeDriver();
        extentTest.info("the page is closed");
    }

    @Test(priority = 35)
    public void TC_3217_NegatifUpdateIngredients() {

        //  1-Login as Merchant

        merchantPage = new MerchantPage();
        merchantPage.merchantLogin();
        extentTest=extentReports.createTest("Controling the negative scenario update of a ingredients item ","the negative scenario ability update a ingredients item");

        // 2-Click the “Attributes” in the menu

        merchantPage.attributes.click();
        extentTest.info("the attributes is clicked");
        ReusableMethods.bekle(2);

        // 3-Click the “ingredients” in the menu

        merchantPage.ingredients.click();
        extentTest.info("the ingredients menu is clicked");
        ReusableMethods.bekle(2);

        // 4-Verify the “ingredients_list” page is visible and enable

        String actualIngredientsUrl = Driver.getDriver().getCurrentUrl();
        String expectedIngredientsUrl = "ingredients_list";
        softAssert.assertTrue(actualIngredientsUrl.contains(expectedIngredientsUrl));
        extentTest.info("the ingredients list page is seen");

        ReusableMethods.bekle(2);

        // 5-Verify the “Update” link is visible and enable to edit the size.

        softAssert.assertTrue(merchantPage.updateButonu1.isEnabled());
        merchantPage.updateButonu1.click();
        extentTest.info("the update link is enabled");

        // 6-Verify the “Size_update/id/” page is  enabled

        String actualUpdateUrl = Driver.getDriver().getCurrentUrl();
        String expectedUpdateUrl = "Ingredients_update/id";
        softAssert.assertTrue(actualUpdateUrl.contains(expectedUpdateUrl));
        extentTest.info("the update page is enabled");
        ReusableMethods.bekle(2);

        // 7-Verify the “ingredients Name” box is active

        merchantPage.ingredientsNameElementi.clear();
        extentTest.info("the box is cleared");
        merchantPage.ingredientsNameElementi.sendKeys(ConfigReader.getProperty("notUpdatedIngrdnstName"));
        extentTest.info("an invalid text is written");
        ReusableMethods.bekle(2);

        // 8-Verify the “Status” box is active and options are selective

        actions = new Actions(Driver.getDriver());
        actions.click(merchantPage.ingredientsNameElementi)
                .sendKeys(Keys.TAB).perform();

        merchantPage.statusElementleri.click();
        actions.click(merchantPage.statusElementleri)
                .sendKeys(Keys.TAB).perform();


        Select select = new Select(merchantPage.statusElementleri);
        for (int i = 0; i < select.getOptions().size(); i++) {
            if (select.getOptions().get(i).getText().equalsIgnoreCase(toString())) {
                select.getOptions().get(i).click();
                break;
            }
        }
        extentTest.info("the status option is selected");

        // 9- Verify the “Item translation” box is visiable and clickable

        merchantPage.itemTranslation.click();
        softAssert.assertTrue(merchantPage.itemTranslation.isDisplayed());
        softAssert.assertTrue(merchantPage.itemTranslation.isEnabled());
        actions.click(merchantPage.itemTranslation)
                .sendKeys(Keys.TAB).perform();
        extentTest.info("the item translation is enabled");


        // 10- Verify the “Japanese translation” box is visiable

        actions = new Actions(Driver.getDriver());

        actions.click(merchantPage.japaneseTranslation).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).perform();

        merchantPage.japaneseTranslation.clear();
        extentTest.info("the japanese translation box is cleared");
        ReusableMethods.bekle(1);
        merchantPage.japaneseTranslation.sendKeys(ConfigReader.getProperty("japanese"));

        String actualJapanese = merchantPage.japaneseTranslation.getText();
        String expectedJapanese = "japonca";
        softAssert.assertTrue(actualJapanese.contains(expectedJapanese));
        softAssert.assertTrue(merchantPage.japaneseTranslation.isDisplayed());
        extentTest.info("an japanese word is written");
        ReusableMethods.bekle(1);

        actions.click(merchantPage.japaneseTranslation).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

        // 11-Verify the “Arabic translation” box is visiable

        actions = new Actions(Driver.getDriver());

        actions.click(merchantPage.arabicTranslation).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).perform();

        merchantPage.arabicTranslation.clear();
        extentTest.info("the arabic translation box is cleared");
        ReusableMethods.bekle(1);
        merchantPage.arabicTranslation.sendKeys(ConfigReader.getProperty("arabic"));

        String actualArabic = merchantPage.arabicTranslation.getText();
        String expectedArabic = "arapca";
        softAssert.assertTrue(actualArabic.contains(expectedArabic));
        softAssert.assertTrue(merchantPage.arabicTranslation.isDisplayed());

        actions.click(merchantPage.arabicTranslation).sendKeys(Keys.TAB).perform();
        extentTest.info("an arabic word is written");
        ReusableMethods.bekle(1);

        // 12- Verify the “Save” button is visible and active

        softAssert.assertTrue(merchantPage.attSaveButton.isDisplayed());
        softAssert.assertTrue(merchantPage.attSaveButton.isEnabled());
        extentTest.info("the save button is enabled");
        ReusableMethods.bekle(2);

        merchantPage.attSaveButton.click();
        ReusableMethods.bekle(2);

        // 13-Verify the updated is not successful

        Assert.assertTrue(merchantPage.notUpdated.isDisplayed());
        extentTest.pass("The ingredients item is not updated");

        // 14-Close the page

        Driver.closeDriver();
        extentTest.info("The browser is closed");

    }

    @Test(priority = 40)
    public void TC_3218_DeleteIngredients() {

        // 1-Login as Merchants

        merchantPage = new MerchantPage();
        merchantPage.merchantLogin();
        extentTest=extentReports.createTest("Controling the ingredients are deleted","Ability to delete a ingredients item");
        ReusableMethods.bekle(2);

        // 2-Click the “Attributes” in the menu

        merchantPage.attributes.click();
        extentTest.info("the attributes is clicked");
        ReusableMethods.bekle(2);

        // 3-Click the “Ingredients” in the menu

        merchantPage.ingredients.click();
        extentTest.info("the ingredients menu is clicked");
        ReusableMethods.bekle(2);

        // 4-Verify the “ingredients_list” page is visible and enable

        String actualSizeUrl = Driver.getDriver().getCurrentUrl();
        String expectedSizeUrl = "ingredients";
        softAssert.assertTrue(actualSizeUrl.contains(expectedSizeUrl));
        extentTest.info("ingredientslist page is seen");
        ReusableMethods.bekle(2);

        List<WebElement> ingredientsListFirst = merchantPage.sortingNameList;
        List<String> ingredientsListFirstStr = new ArrayList<>();


        for (WebElement each : ingredientsListFirst) {
            ingredientsListFirstStr.add(each.getText().substring(0, 8));
        }

        System.out.println(ingredientsListFirstStr);
        extentTest.info("the ingredients are listed");

        // 5-Verify the “Delete” link is visible and enable to delete the size.

        softAssert.assertTrue(merchantPage.deleteButton1.isEnabled());
        merchantPage.deleteButton1.click();
        extentTest.info("the delete buton is clicked");
        ReusableMethods.bekle(2);

        // 6-Verify the “Delete Confirmation” box is usable.

        softAssert.assertTrue(merchantPage.deleteConfirmationMessage.isDisplayed());
        merchantPage.deleteConfirmButton.click();
        extentTest.info("the delete confirmation is clicked");
        ReusableMethods.bekle(3);

        List<WebElement> ingredientsListLast = merchantPage.sortingNameList;
        List<String> ingredientsListLastStr = new ArrayList<>();


        for (WebElement each : ingredientsListLast) {
            ingredientsListLastStr.add(each.getText().substring(0, 8));
        }

        System.out.println(ingredientsListLastStr);
        extentTest.info("The last items are listed");

        Assert.assertFalse(ingredientsListLastStr.contains(ingredientsListFirstStr));
        extentTest.pass("an item is deleted");

        // 7-Close the page  //

        Driver.closeDriver();
        extentTest.info("the page is closed");
    }
}


