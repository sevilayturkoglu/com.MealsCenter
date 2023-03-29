package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class MerchantOrderProcessing {
   public MerchantOrderProcessing(){
       PageFactory.initElements(Driver.getDriver(),this);
   }

    //kendi alanim


    @FindBy(xpath = "//a[.='Orders'])")
    public WebElement merchantOrdersButton;
    ////a[.='Orders']

    @FindBy(xpath = "//a[text()='New Orders']")
    public WebElement merchantNewOrdersButtonu;
    //Bu x path bir onceki user story ile cakisabilir.
    // Cunku iliskili. Soldaki merchant new orders'i accept yapmak icin kullandim.

    @FindBy(xpath = "(//h5[@class='m-0'])[3]")
    public WebElement merchantNewOrdersOrderNummer;
    //Bu x path ile sectigimiz bir urunun new orders dan order numarasini aliyoruz.

    @FindBy(xpath = "//span[text()='Accepted']")
    public WebElement merchantNewOrdersAcceptedButonu;
    //Bu x path de bir onceki user story de aliabilir ve cakisabilir.

    @FindBy(xpath = "//h5[.='Orders Processing']")
    public WebElement merchantOrderProcessingText;
    //order>order processing>body
    //order processing yazisi body de gorunuyor mu?

    @FindBy(xpath= "//a[.='Orders Processing']")
    public WebElement merchantOrdersProcessingButton;


    @FindBy(xpath = "//div/p[@class='m-0']")
    public List<WebElement> merchantOrdersProcessingList;

    @FindBy(xpath = "//div[@class='ronded-green']")
    public WebElement merchantOrdersProcessingListNumber;
    //get text diyip listede kac tane eleman oldugunu sayi olarak gorebilirsiniz.


    @FindBy(xpath = "//h5[text()='Delivery information :']")
    public WebElement deliveryInformation;
    //orders> orders Processing> Bodysinde information yazisi

    @FindBy(xpath = "(//h5[@class='m-0'])[3]")
    public WebElement orderNumber;
    //order processing bolumundeki body den ready to pick butonunun altindaki orders numberi


    @FindBy(xpath = "//span[text()='Ready for pickup']")
    public WebElement menchantReadyforPick;

}
