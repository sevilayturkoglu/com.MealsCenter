package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class UserPage {
    public UserPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    //Login page locators
    @FindBy(xpath = "//a[.='Sign in']")
    public WebElement userSignIn;
    @FindBy(xpath = "//label[@for='username']")
    public WebElement userEmailLogin;
    @FindBy(xpath = "//label[@for='password']")
    public WebElement userPasswordLogin;
    @FindBy(xpath = "//span[.='Sign in']")
    public WebElement userSignInLogin;
    @FindBy(xpath = "//span[.='Decline']")
    public WebElement userCookies;
    @FindBy(xpath = "//h5[.='Login']")
    public WebElement userLoginText;
    //User page locators
    @FindBy(xpath = "//a[@id='dropdownMenuLink']")
    public WebElement userUstDropDownButton;
    @FindBy(xpath = "//a[.= ' More ']")
    public WebElement userCuisineMoreButton;
    @FindBy(xpath = "//div[@class='top-logo']")
    public WebElement userLogo;
    @FindBy(xpath = "(//input[@class='form-control form-control-text'])[1]")
    public WebElement userAdresBox;
    @FindBy(xpath = "(//h6)[2]")
    public WebElement userChooseAddres;
    //Home Headers locators
    @FindBy(xpath = "//a[.=' Cart ']")
    public WebElement userCartButton;
    @FindBy(xpath = "//h5[.='Cart']")
    public WebElement userCartText;
    @FindBy(xpath = "//span[@class='badge small badge-dark rounded-pill']")
    public WebElement userBagButton;
    @FindBy(xpath = "//div[@class='mt-5']")
    public WebElement userBagText;
    @FindBy(xpath = "//i[@class='el-icon el-drawer__close']")
    public WebElement userHeadersClosex;
    @FindBy(xpath = "//h5[.='7-Eleven']")
    public WebElement eleven7;
    @FindBy(xpath = "//a[.=' Add to cart ']")
    public WebElement addToCard;
    @FindBy(xpath = "//div[.='Go to checkout']")
    public WebElement userBagChecOutText;
//User Favorites Locators
   @FindBy(xpath = "(//i[@class='zmdi zmdi-favorite-outline'])[3]")
    public WebElement favouriteTikStarBox;
    @FindBy(xpath = "(//i[@class='zmdi zmdi-favorite-outline'])[5]")
    public WebElement favouriteTikBurgerBox;
    @FindBy(xpath = "//h5[.='Burger King']")
    public WebElement favouriteBurgerKing;
    @FindBy(xpath = "//h5[.='Starbucks']")
    public WebElement favouriteStarbucks;
    @FindBy(xpath = "(//i[@class='zmdi zmdi-favorite text-green'])[1]")
    public WebElement inFavouriteTikBox1;









    //Bu method sizi sayfaya login yapacak
    // Actiginiz Test altina Url yi yazdiktan sonra bu method cagrilacak
    public void userLoginBeing() {
        Driver.getDriver().get(ConfigReader.getProperty("userUrl"));
        UserPage userPage=new UserPage();
        userPage.userCookies.click();
        userSignIn.click();
        Actions actions = new Actions(Driver.getDriver());
        userEmailLogin.click();
        actions.sendKeys(ConfigReader.getProperty("userSevilay")).sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("userSevilayPassword")).perform();
        userSignInLogin.click();
        ReusableMethods.bekle(2);
        userPage.userAdresBox.sendKeys("100000");
        ReusableMethods.waitForVisibility(userPage.userChooseAddres,10);
        userPage.userChooseAddres.click();
        ReusableMethods.bekle(1);//bekleme varsa back olabilir
        userLogo.click();
    }

    //Bu method size  ust sagda hesabinizin ayrintilarinin oldugu dropDowni acacak sizi gitmek istediginiz yere goturecek ve
    // oraya gittiginizi dogrulayacak.Siz method argumenti olarak gitmek istediginiz yeri ve
    // URL nin sonunda yazan kismi ekleyeceksiniz, Or: menuName=" My orders "  ; expecdUrl="orders"  gibi

    public void userUstDDMenu(String menuName, String expecdUrl) {
        ReusableMethods.bekle(1);
        userUstDropDownButton.click();
        ReusableMethods.bekle(1);
        Driver.getDriver().findElement(By.xpath("//a[.=' " + menuName + " ']")).click();
        String actualUrl = Driver.getDriver().getCurrentUrl();
        System.out.println(actualUrl);
        System.out.println(expecdUrl);
        Assert.assertTrue(actualUrl.contains(expecdUrl));

    }
//Bu methoda sayfada acik olanlardan gitmek istediginiz cuisine nameini yazacaksiniz
// ,sizi oraya goturecek oradaki texti alip sizi oraya goturdugunu dogrulayacak
    //Method argumenti olarak sadece sayfada gorulen cuisine adi yazin "Mediterranean" gibi
    public void userChoseAppearCuisine(String cuisineName) {
        Driver.getDriver().findElement(By.xpath("//div[@class='col cuisineMainPage']/a[.='" + cuisineName + "']")).click();
        String actualPageText = Driver.getDriver().findElement(By.xpath("//h4[.='American']")).getText();
        String expectedPageText = cuisineName;
        Assert.assertEquals(actualPageText, expectedPageText);
    }
    //Bu method sizi sayfada more drop downi altinda olan gitmek istediginiz cuisine nameini yazacaksiniz
// ,sizi oraya goturecek oradaki texti alip sizi oraya goturdugunu dogrulayacak
    //Method argumenti olarak sadece sayfada gorulen cuisine adi yazin "Kosher" gibi
    public void UserChoseCuisineMore(String cuisineName) {
        userCuisineMoreButton.click();
        Driver.getDriver().findElement(By.xpath("(//a[.='" + cuisineName + "'])[1]")).click();
        String actualPageText = Driver.getDriver().findElement(By.xpath("//h4[.='" + cuisineName + "']")).getText();
        String expectedPageText = cuisineName;
        Assert.assertEquals(actualPageText, expectedPageText);
    }
}