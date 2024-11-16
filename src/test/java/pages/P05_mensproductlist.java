package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utility.BrowserDriver;

import static org.junit.Assert.assertEquals;

public class P05_mensproductlist extends BrowserDriver {
    public static String mens_category_xpath="//a[@id='ui-id-5']//span[contains(text(),'Men')]";
    public static String HW_categoty_xpath="//a[contains(text(),'Hoodies & Sweatshirts')]";
    public static String jackets_categoty_xpath="//a[contains(text(),'Jackets')]";
    public static String tees_categoty_xpath="//a[contains(text(),'Tees')]";
    public static String tanks_categoty_xpath="//a[contains(text(),'Tanks')]";
    public static String pants_categoty_xpath="//a[contains(text(),'Pants')]";
    public static String shorts_categoty_xpath="//a[contains(text(),'Shorts')]";

    public static void mens_category()throws Exception{
        getDriver().findElement(By.xpath(mens_category_xpath)).click();
    }
    public static void user_select_category_mensHW()throws Exception{
       Thread.sleep(4000);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,100)", "");
        getDriver().findElement(By.xpath(HW_categoty_xpath)).click();
    }
    public static void mensHW_category_page()throws Exception{
        String hwurl = getDriver().getCurrentUrl();
        assertEquals(hwurl,"https://magento.softwaretestingboard.com/men/tops-men/hoodies-and-sweatshirts-men.html");
        getDriver().navigate().back();
    }

    public static void user_select_category_mensjackets()throws Exception{
        getDriver().findElement(By.xpath(jackets_categoty_xpath)).click();
    }

    public static void mensjackets_category_page()throws Exception{
        String jacketsurl = getDriver().getCurrentUrl();
        assertEquals(jacketsurl,"https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html");
        getDriver().navigate().back();
    }
    public static void user_select_category_menstees()throws Exception{

        getDriver().findElement(By.xpath(tees_categoty_xpath)).click();
    }

    public static void menstees_category_page()throws Exception{
        String teesurl = getDriver().getCurrentUrl();
        assertEquals(teesurl,"https://magento.softwaretestingboard.com/men/tops-men/tees-men.html");
        getDriver().navigate().back();
    }

    public static void user_select_category_mens_t()throws Exception{
        getDriver().findElement(By.xpath(tanks_categoty_xpath)).click();
    }
    public static void mens_t_category_page()throws Exception{
        String bturl = getDriver().getCurrentUrl();
        assertEquals(bturl,"https://magento.softwaretestingboard.com/men/tops-men/tanks-men.html");
        getDriver().navigate().back();
    }

    public static void user_select_category_menspants()throws Exception{
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,300)", "");
        Thread.sleep(5000);
        getDriver().findElement(By.xpath(pants_categoty_xpath)).click();
    }

    public static void menspants_category_page()throws Exception{
        String pantsurl = getDriver().getCurrentUrl();
        assertEquals(pantsurl,"https://magento.softwaretestingboard.com/men/bottoms-men/pants-men.html");
        getDriver().navigate().back();
    }
    public static void user_select_category_mensshorts()throws Exception{
        getDriver().findElement(By.xpath(shorts_categoty_xpath)).click();
    }

    public static void mensshorts_category_page()throws Exception{
        String shortsurl = getDriver().getCurrentUrl();
        assertEquals(shortsurl,"https://magento.softwaretestingboard.com/men/bottoms-men/shorts-men.html");
    }





}
