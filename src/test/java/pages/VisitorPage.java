package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class VisitorPage {

    public VisitorPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[.='Become a Partner']")
    public WebElement becomeRestaurantPartner;

    @FindBy(tagName = "h3")
    public WebElement theTitleofBecomingPartner;

    @FindBy(xpath ="//label[.='Store name']")
    public WebElement partnerStoreName;

    @FindBy(xpath = "//input[@placeholder='Store address']")
    public WebElement partnerStoreAddress;

    @FindBy(tagName = "(h6)[1]")
    public WebElement getPartnerStoreAddressClick;

    @FindBy(xpath = "//label[.='Email address']")
    public WebElement partnerStoreEmail;

    @FindBy(xpath = "(//input[@type='text'])[3]")
    public WebElement partnerStorePhone;

    @FindBy(xpath = "//label[@class='custom-control-label']")
    public WebElement partnerCommissionButton;

    @FindBy(xpath = "//button[.='Submit']")
    public WebElement partnerStoreSubmit;

    @FindBy(tagName = "h4")
    public WebElement partnerStoreBenefits;

    @FindBy(xpath = "(//input[@type='text'])[1]")
    public WebElement partnerFirstName;

    @FindBy(xpath = "(//input[@class='form-control form-control-text'])[1]")
    public WebElement partnerUserFirstName;

    @FindBy(xpath ="//span[.='Signup']")
    public WebElement partnerUserSignUp;

    @FindBy(tagName = "h3")
    public WebElement contactedMessage;





















}
