package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import utility.BrowserDriver;



import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;


public class P06_addtocart extends BrowserDriver {

    public static String open_product_xpath = "//img[@alt='Push It Messenger Bag']";
    public static String product_add_to_card_xpath = "//*[@id=\"product-addtocart-button\"]";
    public static String minicart_xpath = "/html/body/div[2]/header/div[2]/div[1]/a";
    public static String view_cart_xpath = " //span[normalize-space()='View and Edit Cart']";
    public static String cart_item_xpath = "//*[@id=\"shopping-cart-table\"]/tbody";
   public static String empty_cart_msg_xpath="//*[@id=\"maincontent\"]/div[3]/div/div[2]/p[1]";
    public static String delete_btn_xpath ="//a[@class='action action-delete']";
    public static String update_btn_xpath ="//a[@title='Edit item parameters']";
    public static String qty_xpath =" //input[@id='qty']";
    public static String update_cart_xpath = "//span[normalize-space()='Update Cart']";
    public static String discount_dropdown_xpath = "//div[@id='block-discount']//div[@role='tab']";
    public static String enter_coupon_xpath = "//input[@id='coupon_code']";
    public static String apply_discount_xpath="//*[@id=\"discount-coupon-form\"]/div/div[2]/div/button";
    public static String invalid_coupon_msg_xpath= "//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div";

    public static void open_product() throws Exception {
        getDriver().findElement(By.xpath(open_product_xpath)).click();
        Thread.sleep(2000);
    }



    public static void add_to_cart_button() throws Exception {

      Thread.sleep(5000);
        getDriver().findElement(By.xpath(product_add_to_card_xpath)).click();
        JavascriptExecutor js= (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,200)","");
    }
    public static void check_cart() throws Exception {
        Thread.sleep(10000);
        getDriver().findElement(By.xpath(minicart_xpath)).click();
        getDriver().findElement(By.xpath(view_cart_xpath)).click();
    }
    public static void cart_item() throws Exception {
        Thread.sleep(3000);
        List<WebElement> items = getDriver().findElements(By.xpath(cart_item_xpath));
       if(items.size()<=0){
           SoftAssert softAssert = new SoftAssert();
           String actualmsg= getDriver().findElement(By.xpath(empty_cart_msg_xpath)).getText();
           String currentmsg="You have no items in your shopping cart.";
           softAssert.assertEquals(actualmsg,currentmsg);
       }
       else{
           System.out.print("item added successfully");
       }
    }

    public static void delete_item() throws Exception {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement delete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(delete_btn_xpath)));
        delete.click();

    }
    public static void update_item() throws Exception {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement update = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(update_btn_xpath)));
        update.click();
    }
    public static void add_qty() throws Exception {

        getDriver().findElement(By.xpath(qty_xpath)).clear();
        getDriver().findElement(By.xpath(qty_xpath)).sendKeys("2");
    }
    public static void update_button() throws Exception {
        getDriver().findElement(By.xpath(update_cart_xpath)).click();
    }

    public static void apply_discount_code() throws Exception {
        getDriver().findElement(By.xpath(discount_dropdown_xpath)).click();
        getDriver().findElement(By.xpath(enter_coupon_xpath)).sendKeys("mahmoud123");
        getDriver().findElement(By.xpath(apply_discount_xpath)).click();
    }
    public static void invalid_coupon() throws Exception {
        Thread.sleep(3000);
        String actualinvalid_msg =  getDriver().findElement(By.xpath(invalid_coupon_msg_xpath)).getText();
        assertEquals("The coupon code \"mahmoud123\" is not valid.",actualinvalid_msg);
    }

}

