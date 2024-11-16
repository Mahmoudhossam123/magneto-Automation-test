package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import utility.BrowserDriver;
import utility.FlexibleJsonReader;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static pages.P06_addtocart.minicart_xpath;

public class P07_checkout extends BrowserDriver {

    public static String proceed_checkout_btn_xpath = "//*[@id=\"top-cart-btn-checkout\"]";
    public static String Email_xpath = "//div[@class='control _with-tooltip']//input[@id='customer-email']";
    public static String pass_xpath = "//input[@id='customer-password']";
    public static String loginbtn_xpath = "//span[normalize-space()='Login']";
    public static String first_name_name="firstname";
    public static String last_name_name="lastname";
    public static String company_name = "company";
    public static String street1_name = "street[0]";
    public static String street2_name = "street[1]";
    public static String street3_name = "street[2]";
    public static String city_name = "city";
    public static String state_name = "region_id";
    public static String postal_code_name = "postcode";
    public static String country_drop_box_name = "country_id";
    public static String phone_name = "telephone";
    public static String next_xpath = "//span[normalize-space()='Next']";
    public static String place_order_btn_xpath = "//span[normalize-space()='Place Order']";

    //span[normalize-space()='Next']
    public static void checkout_page() throws InterruptedException {
        Thread.sleep(10000);
        getDriver().findElement(By.xpath(minicart_xpath)).click();
        JavascriptExecutor js= (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,200)","");
        Thread.sleep(2000);
        getDriver().findElement(By.xpath(proceed_checkout_btn_xpath)).click();
        Thread.sleep(4000);
        String currentUrl = getDriver().getCurrentUrl();
        assertEquals(currentUrl, "https://magento.softwaretestingboard.com/checkout/#shipping");
    }


    public static void checkout_login() throws Exception {
        WebDriverWait Wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement emailfield = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Email_xpath)));
        List<Map<String, String>> allData = FlexibleJsonReader.getAllData("src/test/data.json");
        for (Map<String, String> data : allData) {
            String email = data.get("checkout_loginmail");
            emailfield.sendKeys(email);
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pass_xpath)));
            List<Map<String, String>> AllData = FlexibleJsonReader.getAllData("src/test/data.json");
            for (Map<String, String> Data : AllData) {
                String pass = Data.get("checkout_pass");
                passwordField.sendKeys(pass);
                getDriver().findElement(By.xpath(loginbtn_xpath)).click();

            }

        }
    }

    public static void credential() throws Exception {
        List<Map<String, String>> AllData = FlexibleJsonReader.getAllData("src/test/data.json");
        for (Map<String, String> Data : AllData){
            String checkout_email=Data.get("check out email");
            getDriver().findElement(By.xpath(Email_xpath)).sendKeys(checkout_email);
        }
        List<Map<String, String>> allData = FlexibleJsonReader.getAllData("src/test/data.json");
        for (Map<String, String> Data : allData){
            String first_name=Data.get( "firstName");
            getDriver().findElement(By.name(first_name_name)).sendKeys(first_name);
        }
        List<Map<String, String>> alldata = FlexibleJsonReader.getAllData("src/test/data.json");
        for (Map<String, String> Data : alldata){
            String last_name=Data.get( "lastName");
            getDriver().findElement(By.name(last_name_name)).sendKeys(last_name);
        }

        WebDriverWait Wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement company = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(company_name)));
        company.sendKeys("mahmoud");

        List<Map<String, String>> ALLdata = FlexibleJsonReader.getAllData("src/test/data.json");
        for (Map<String, String> Data : ALLdata){
            String street1=Data.get("street1");
            getDriver().findElement(By.name(street1_name)).sendKeys(street1);
        }
        List<Map<String, String>> ALldata = FlexibleJsonReader.getAllData("src/test/data.json");
        for (Map<String, String> Data : ALldata){
            String street2=Data.get("street2");
            getDriver().findElement(By.name(street2_name)).sendKeys(street2);
        }
        List<Map<String, String>> aLLdata = FlexibleJsonReader.getAllData("src/test/data.json");
        for (Map<String, String> Data : aLLdata){
            String street3=Data.get("street3");
            getDriver().findElement(By.name(street3_name)).sendKeys(street3);
        }
        List<Map<String, String>> ALLDATA = FlexibleJsonReader.getAllData("src/test/data.json");
        for (Map<String, String> Data : ALLDATA){
            String city=Data.get( "city");
            getDriver().findElement(By.name(city_name)).sendKeys(city);
        }

        Thread.sleep(5000);
        WebElement dropdownelement = getDriver().findElement(By.name(state_name));
        Select dropdown = new Select(dropdownelement);
        dropdown.selectByVisibleText("Alabama");
        Thread.sleep(3000);


        List<Map<String, String>> ALLDATa = FlexibleJsonReader.getAllData("src/test/data.json");
        for (Map<String, String> Data : ALLDATa){
            String postal_code=Data.get("postal code");
            getDriver().findElement(By.name(postal_code_name)).sendKeys(postal_code);
        }




        WebElement Dropdownelement = getDriver().findElement(By.name(country_drop_box_name));
        Select Dropdown = new Select(Dropdownelement);
        Dropdown.selectByVisibleText("Egypt");
        Thread.sleep(3000);


        List<Map<String, String>> ALlDATa = FlexibleJsonReader.getAllData("src/test/data.json");
        for (Map<String, String> Data : ALlDATa){
            String phone=Data.get("phone");
            getDriver().findElement(By.name(phone_name)).sendKeys(phone);
        }


    }
        public static void next ()throws Exception {
           Thread.sleep(3000);
           WebDriverWait Wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement next = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(next_xpath)));
            next.click();
        }

        public static void place_order ()throws Exception {
        Thread.sleep(4000);
           getDriver().findElement(By.xpath(place_order_btn_xpath)).click();


        }
        public static void success_page ()throws Exception {
            Thread.sleep(3000);
            String currentUrl = getDriver().getCurrentUrl();
            assertEquals(currentUrl, "https://magento.softwaretestingboard.com/checkout/onepage/success/");
        }


}
