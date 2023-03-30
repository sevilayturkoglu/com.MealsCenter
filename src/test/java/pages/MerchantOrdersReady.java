package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class MerchantOrdersReady {
    public MerchantOrdersReady() {
        PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "//a[.='Orders'])")
    public WebElement merchantOrdersButton;

    @FindBy(xpath = "//a[@href='/backoffice/orders/processing']")
    public WebElement merchantOrderProcessingButtonu;

    @FindBy(xpath = "(//h5[@class='m-0'])[3]")
    public WebElement merchantOrdersReadyOrderNummer;
    //Bu x path ile sectigimiz bir urunun orders Ready dan order numarasini aliyoruz.

    @FindBy(xpath = "//span[.='Ready for pickup']")
    public WebElement merchantReadyForPickupButonu;
    //Bu x path de bir onceki user story de aliabilir ve cakisabilir.

    @FindBy(xpath = "//h5[.='Orders Ready']")
    public WebElement merchantOrdersReadyText;
    //order>orders Ready>body
    //orders Ready yazisi body de gorunuyor mu?

    @FindBy(xpath= "//a[@href='/backoffice/orders/ready']")
    public WebElement merchantOrdersReadyButton;


    @FindBy(xpath = "//div[@class='orders-left-section nice-scroll']") //listenin butun hali
    public List<WebElement> merchantOrdersReadyList;

    @FindBy(xpath = "//div[@class='ronded-green']") //numara dugmesi
    public WebElement merchantOrdersReadyListNumber;
    //get text diyip listede kac tane eleman oldugunu sayi olarak gorebilirsiniz.


    @FindBy(xpath = "//h5[text()='Delivery information :']")
    public WebElement deliveryInformation;
    //orders> orders Ready> Bodysinde information yazisi


    @FindBy(xpath = "//button[@class='btn-yellow btn normal mr-2 font13 mb-3 mb-xl-0']")
    public WebElement merchantDeliverd;

}
