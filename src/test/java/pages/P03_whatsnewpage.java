package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import utility.BrowserDriver;

import java.time.Duration;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;


public class P03_whatsnewpage extends BrowserDriver {
    public static String whatsnew_btn_xpath = "//a[@id='ui-id-3']//span[1]";
    public static String product_xpath="//*[@id=\"maincontent\"]/div[4]/div[1]/div[1]/div[4]/div/div/ol/li[1]";
    public static String product_img_xpath ="//*[@id=\"maincontent\"]/div[4]/div[1]/div[1]/div[4]/div/div/ol/li[1]/div/a/span";
    public static String product_name_xpath ="//*[@id=\"maincontent\"]/div[4]/div[1]/div[1]/div[4]/div/div/ol/li[1]/div/div/strong/a";
    public static String product_price_xpath="//*[@id=\"maincontent\"]/div[4]/div[1]/div[1]/div[4]/div/div/ol/li[1]/div/div/div[2]/span";
    public static String select_product_xpath="//img[@alt='Wayfarer Messenger Bag']";
    public static String compare_product_btn_xpath="//div[@class='product-addto-links']//span[contains(text(),'Add to Compare')]";
    public static String compare_product_list_xpath="//a[normalize-space()='comparison list']";
    public static String product_in_compare_list_xpath="//*[@id=\"product-comparison\"]/tbody[1]/tr/td";
    public static String add_to_wish_list_btn_list_xpath="//span[normalize-space()='Add to Wish List']";
    public static String add_to_wish_list_item="//*[@id=\"item_10267\"]";
    public static String add_to_wish_list_msg_xpath="//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div";


    public static void open_whatsnew_page() throws InterruptedException {
        Thread.sleep(1000);

        getDriver().findElement(By.xpath(whatsnew_btn_xpath)).click();

    }

    public static void navigate_to_page() throws InterruptedException {
        Thread.sleep(1000);
        String currentUrl =  getDriver().getCurrentUrl();
        assertEquals(currentUrl, "https://magento.softwaretestingboard.com/what-is-new.html");
    }

    public static void product_loaded() {
        List<WebElement> products =  getDriver().findElements(By.xpath(product_xpath));
        assertTrue("No products were found on the page!",products.size() > 0);
}

    public static void product_image() {
        List<WebElement> productImages =  getDriver().findElements(By.xpath(product_img_xpath));
        for (WebElement img : productImages) {
            assertTrue(img.isDisplayed());
        }
    }
    public static void product_name() {
        List<WebElement> productNames =  getDriver().findElements(By.xpath(product_name_xpath));
        for (WebElement name : productNames) {
            assertTrue(name.isDisplayed() && !name.getText().isEmpty());
        }
    }
    public static void product_price() {
        List<WebElement> productPrices =  getDriver().findElements(By.xpath(product_price_xpath));
        for (WebElement price : productPrices) {
            assertTrue(price.isDisplayed() && !price.getText().isEmpty());
        }
    }

    public static void select_product() throws Exception {
        getDriver().findElement(By.xpath(select_product_xpath)).click();
        Thread.sleep(2000);
    }
    public static void compare_product() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,100)", "");
        WebDriverWait Wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement compare_btn = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(compare_product_btn_xpath)));
         compare_btn.click();;


    }
    public static void comparison_list_page() throws Exception {
        Thread.sleep(2000);
        getDriver().findElement(By.xpath(compare_product_list_xpath)).click();
            List<WebElement> products =  getDriver().findElements(By.xpath(product_in_compare_list_xpath));
            assertTrue("No products were found on the page!",products.size() > 0);
        getDriver().navigate().back();
        Thread.sleep(3000);




    }
    public static void add_to_wish_list() throws Exception {
        WebDriverWait Wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement addtowish_btn = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(add_to_wish_list_btn_list_xpath)));
        addtowish_btn.click();;
    }

    public static void add_to_wish_list_page() throws Exception{
        Thread.sleep(5000);
        List<WebElement> products =  getDriver().findElements(By.xpath(add_to_wish_list_item));

        if(products.size()>0){
            SoftAssert softAssert = new SoftAssert();
            String actualmsg= getDriver().findElement(By.xpath(add_to_wish_list_msg_xpath)).getText();
            String currentmsg="Wayfarer Messenger Bag has been added to your Wish List. Click here to continue shopping.";
            softAssert.assertEquals(actualmsg,currentmsg);
        }
      else {
          System.out.print("You have no items in your wish list.");
        }

        }
     }
