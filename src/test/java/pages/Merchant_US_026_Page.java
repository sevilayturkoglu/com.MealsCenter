package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class Merchant_US_026_Page {
    public Merchant_US_026_Page() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//li[@class='position-relative orders_new']")
    public WebElement newOrdersLink;
    @FindBy(xpath = "//h5[text()='New Orders']")
    public WebElement newOrderText;
    @FindBy(xpath = "(//h6[@class='m-0'])[2]")
    public WebElement beforeTotal;
    @FindBy(xpath = "//a[@class='btn btn-green small']")
    public WebElement addButton;
    @FindBy(xpath = "(//p[@class='m-0 mt-1 text-truncate'])[1]")
    public WebElement firstProduct;
    @FindBy(xpath = "(//img[@class='rounded lozad loaded'])[1]")
    public WebElement choosenProduct;
    @FindBy(xpath = "(//span[@class='label'])[1]")
    public WebElement addToOrder;

    @FindBy(xpath = "(//span[text()='×'])[10]")
    public WebElement crossXSign;
    @FindBy(xpath = "(//h6[@class='m-0'])[2]")
    public WebElement afterTotal;
    @FindBy(css = "div[class='card-body pt-3']")
    public WebElement allBody;
}