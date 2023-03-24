package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MerchantSheculdePage {
    public MerchantSheculdePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.='Scheduled']")
    public WebElement merchantSheculdeButton;
    @FindBy(xpath = "//div[.='Sort']")
    public WebElement schuldeSortButton;
    @FindBy(xpath = "//div[.='Payment status']")
    public WebElement paymantStatusButton;
    @FindBy(xpath = "//button[@title='Order type']")
    public WebElement orderTypeButton;
    @FindBy(xpath = "(//div[@class='d-flex align-items-center'])//p")
    public List<WebElement> orderId;
    @FindBy(xpath = "(//p[@class='m-0']/b)[2]")
    public WebElement customerNameBeforeSearchText;
    @FindBy(xpath = "//input[@type='search']")
    public WebElement customerNameSearchBox;
    @FindBy(xpath = "(//p[@class='m-0']/b)[1]")
    public WebElement customerNameAfterSearchText;
    @FindBy(xpath = "//li[@class='chevron selected']")
    public WebElement orderTypeText;
    @FindBy(xpath = "//p[@class='m-0']/u")
    public List<WebElement> allOrderDate;
    @FindBy(xpath = "//p[@class='m-0']/b")
    public List<WebElement> allCustomerName;

SoftAssert softAssert=new SoftAssert();

public void accordingToCustomName(String customerName){
    customerNameSearchBox.sendKeys(customerName);
    List<WebElement>customElementList=allCustomerName;
    List<String>allChooseCustomerNameList=new ArrayList<>();
    for (WebElement each : customElementList) {
        allChooseCustomerNameList.add( each.getText());
    }
    for (int i = 0; i < allChooseCustomerNameList.size()-1; i++) {
        softAssert.assertTrue(allChooseCustomerNameList.get(i).equals(customerName));
    }
    softAssert.assertAll();

}
    public void orderTypeList(String orderTypes) {//bunun yerine data provider kullandim
        orderTypeButton.click();
        Driver.getDriver().findElement(By.xpath("(//span[.='" + orderTypes + "'])[1] ")).click();
    }

    public void paymentStatus(String status) {
        Driver.getDriver().findElement(By.xpath("//span[.='" + status + "']")).click();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        String paymentActualStatus = Driver.getDriver().findElement(By.xpath("(//span[.='" + status + "'])[2]")).getText();
        String paymentexcpectedStatus = status;
        softAssert.assertEquals(paymentActualStatus, paymentexcpectedStatus);
        softAssert.assertAll();
    }

    public void sortSchulde(String sortType) {

        Driver.getDriver().findElement(By.xpath("//span[.='" + sortType + "']")).click();
        if (sortType.equals("Order ID - Descending")) {
            List<WebElement> orderId1 =orderId;
            List<Integer> actualLisSort = new ArrayList<>();
            String gecici="";
            for (WebElement element : orderId1) {
                if (element.getText().contains("#")) {
                    gecici= element.getText().substring(7,12);
                    actualLisSort.add(Integer.parseInt(gecici));
                }
            }
            for (int i = 0; i < actualLisSort.size()-1; i++) {
                if(actualLisSort.get(i)>actualLisSort.get(i+1)) {
                    softAssert.assertTrue(true);
                }else{
                    softAssert.assertTrue(false);
                }
            }
        }
        if (sortType.equals("Order ID - Ascending")) {
            List<WebElement> orderId1 = orderId;
            List<Integer> orderNumber = new ArrayList<>();
            List<Integer> actualLisSort = new ArrayList<>();
            String xxx = "";
            for (WebElement element : orderId1) {
                if (element.getText().contains("#")) {
                    xxx = element.getText();
                    xxx=xxx.substring(7,12);
                    orderNumber.add(Integer.parseInt(xxx));
                    actualLisSort.add(Integer.parseInt(xxx));
                }}
            Collections.sort(orderNumber);
            softAssert.assertEquals(actualLisSort, orderNumber);
        }
        if (sortType.equals("Delivery Time - Ascending")) {
            List<WebElement>allDateLocate=allOrderDate;
            List<Integer>dateList=new ArrayList<>();
            String dateTemp="";
            for (WebElement each: allDateLocate) {
                dateTemp= each.getText().replaceAll("\\D","").substring(0,2);
                dateList.add(Integer.parseInt(dateTemp));
            }
            System.out.println(dateList);

            for (int i = 0; i < dateList.size()-1; i++) {
                if (dateList.get(i) >= dateList.get(i + 1)) {
                    softAssert.assertTrue(true);
                } else {
                    softAssert.assertTrue(false);//Bug olabilir dikkat et,Ascendinge gore siralanmamis sonuc [28, 28, 28, 28, 24, 25]cikti
                }
            }
        }
        if (sortType.equals("Delivery Time - Descending")) {
            List<WebElement>allDateLocate=allOrderDate;
            List<Integer>dateList=new ArrayList<>();
            List<Integer>dateListSorted=new ArrayList<>();
            String dateTemp="";
            for (WebElement each: allDateLocate) {
                dateTemp=each.getText().replaceAll("\\D","").substring(0,2);
                dateList.add(Integer.parseInt(dateTemp));
                dateListSorted.add(Integer.parseInt(dateTemp));
            }
            Collections.sort(dateListSorted);
            softAssert.assertEquals(dateList,dateListSorted);
        }
        softAssert.assertAll();
    }

}
