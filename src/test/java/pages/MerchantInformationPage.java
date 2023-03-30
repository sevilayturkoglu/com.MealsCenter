package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MerchantInformationPage {

    public MerchantInformationPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[text()='Merchant']")
    public WebElement merchantDashboard;

    @FindBy(xpath ="//a[text()='Information']")
    public WebElement  merchantInformation;

    @FindBy(xpath ="//a[text()='Update Information']")
    public WebElement  uptadeInformation;

    @FindBy(xpath ="(//button[@class='btn btn-info'])[1]")
    public WebElement  browserButtonLogo;

    @FindBy(xpath = "(//p[@class='m-0']//strong)[1]")
    public WebElement  selectLogoPhoto;

    @FindBy(xpath = "(//span[text()='Add Files'])[1]")
    public WebElement addButtonLogo;


    @FindBy(xpath ="(//button[@class='btn btn-info'])[2]")
    public WebElement browserButtonHeader;

 //  @FindBy(xpath = "/html/body/div[1]/div[3]/div/div/div/div/div/div[2]/form/div[4]/div[4]/div[3]/div/div/div[2]/div[2]/ul/li[4]/img")
 //  public WebElement  selectHeaderPhoto;

     @FindBy(xpath ="(//li)[129]")
    public WebElement selectHeaderPhoto;

    @FindBy(xpath ="(//span[text()='Add Files'])[2]")
    public WebElement addButtonHeader;



    @FindBy(xpath = "(//input[@class='form-control form-control-text'])[5]")
    public WebElement deliveryDistanceCovered;

    @FindBy(xpath ="//option[@value='mi']")
    public WebElement milesOrKmDDm;


    @FindBy(xpath ="//input[@value='Save']")
    public WebElement saveButton;


    @FindBy(xpath = "//button[@class='btn btn-green w-100']")
    public WebElement changedAddressSaveButton;

    @FindBy(tagName = "(//div[@class='module truncate-overflow']/p)[1]")
    public WebElement addedAddress;

}
