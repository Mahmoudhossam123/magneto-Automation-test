package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utility.BrowserDriver;

import static org.junit.Assert.assertEquals;

public class P04_womenproductlist extends BrowserDriver {
    public static String Women_xpath="//span[normalize-space()='Women']";
    public static String HW_categoty_xpath="//main[@id='maincontent']//ul[1]//li[1]//a[1]";
    public static String jackets_categoty_xpath="//main[@id='maincontent']//ul[1]//li[2]//a[1]";
    public static String tees_categoty_xpath="//a[contains(text(),'Tees')]";
    public static String B_t_categoty_xpath="//a[contains(text(),'Bras & Tanks')]";
    public static String pants_categoty_xpath="//a[contains(text(),'Pants')]";
    public static String shorts_categoty_xpath="//a[contains(text(),'Shorts')]";

    public static void women_category()throws Exception{
        getDriver().findElement(By.xpath(Women_xpath)).click();
    }
    public static void user_select_category_HW()throws Exception{
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,200)", "");
        getDriver().findElement(By.xpath(HW_categoty_xpath)).click();
    }
    public static void HW_category_page()throws Exception{
        String hwurl =  getDriver().getCurrentUrl();
        assertEquals(hwurl,"https://magento.softwaretestingboard.com/women/tops-women/hoodies-and-sweatshirts-women.html");
        getDriver().navigate().back();
    }

    public static void user_select_category_jackets()throws Exception{
        getDriver().findElement(By.xpath(jackets_categoty_xpath)).click();
    }

    public static void jackets_category_page()throws Exception{
        String jacketsurl =  getDriver().getCurrentUrl();
        assertEquals(jacketsurl,"https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html");
        getDriver().navigate().back();
    }
    public static void user_select_category_tees()throws Exception{

        getDriver().findElement(By.xpath(tees_categoty_xpath)).click();
    }

    public static void tees_category_page()throws Exception{
        String teesurl = getDriver().getCurrentUrl();
        assertEquals(teesurl,"https://magento.softwaretestingboard.com/women/tops-women/tees-women.html");
        getDriver().navigate().back();
    }

    public static void user_select_category_bt()throws Exception{
        getDriver().findElement(By.xpath(B_t_categoty_xpath)).click();
    }
    public static void bt_category_page()throws Exception{
        String bturl = getDriver().getCurrentUrl();
        assertEquals(bturl,"https://magento.softwaretestingboard.com/women/tops-women/tanks-women.html");
        getDriver().navigate().back();
    }

    public static void user_select_category_pants()throws Exception{
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,300)", "");
        Thread.sleep(5000);
        getDriver().findElement(By.xpath(pants_categoty_xpath)).click();
    }

    public static void pants_category_page()throws Exception{
        String pantsurl = getDriver().getCurrentUrl();
        assertEquals(pantsurl,"https://magento.softwaretestingboard.com/women/bottoms-women/pants-women.html");
        getDriver().navigate().back();
    }
    public static void user_select_category_shorts()throws Exception{
        getDriver().findElement(By.xpath(shorts_categoty_xpath)).click();
    }

    public static void shorts_category_page()throws Exception{
        String shortsurl = getDriver().getCurrentUrl();
        assertEquals(shortsurl,"https://magento.softwaretestingboard.com/women/bottoms-women/shorts-women.html");
    }





}
