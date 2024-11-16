package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.asserts.SoftAssert;
import utility.BrowserDriver;
import utility.FlexibleJsonReader;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class P01_User_registration extends BrowserDriver {
    public static String signup_btn_xpath = "//div[@class='panel header']//a[normalize-space()='Create an Account']";
    public static String first_name_xpath = "//input[@id='firstname']";
    public static String last_name_xpath = "//input[@id='lastname']";
    public static String email_xpath = "//input[@id='email_address']";
    public static String pass_xpath = "//input[@id='password']";
    public static String confirmpass_xpath = "//input[@id='password-confirmation']";
    public static String create_account_btn_xpath = "//button[@title='Create an Account']";
    public static String drobdown_xpath="//div[@class='panel header']//button[@type='button']";
    public static String logout_xpath="//div[@aria-hidden='false']//a[normalize-space()='Sign Out']";

    public static String wrong_email_msg_xpath ="//*[@id=\"email_address-error\"]";
    public static String confirm_pass_error_xpath="//*[@id=\"password-confirmation-error\"]";
    public static String messing_value_error_xpath="//*[@id=\"password-confirmation-error\"]";



    public static void signup_btn() throws Exception {
        getDriver().findElement(By.xpath(signup_btn_xpath)).click();
    }

    public static void sendkeys_firstname() throws Exception {

        List<Map<String, String>> allData = FlexibleJsonReader.getAllData("src/test/data.json");
        for (Map<String, String> data : allData) {
            String f_name=data.get("firstName");
            getDriver().findElement(By.xpath(first_name_xpath)).sendKeys(f_name);
        }
    }
    public static void sendkeys_lastname() throws Exception {

        List<Map<String, String>> allData = FlexibleJsonReader.getAllData("src/test/data.json");
        for (Map<String, String> data : allData) {
            String l_name = data.get("lastName");
            getDriver().findElement(By.xpath(last_name_xpath)).sendKeys(l_name);
        }
    }
    public static void sendkeys_email() throws Exception {
        List<Map<String, String>> allData = FlexibleJsonReader.getAllData("src/test/data.json");
        for (Map<String, String> data : allData) {
            String email = data.get("email");
            getDriver().findElement(By.xpath(email_xpath)).sendKeys(email);
        }
    }
    public static void sendkeys_pass() throws Exception {

        List<Map<String, String>> allData = FlexibleJsonReader.getAllData("src/test/data.json");
        for (Map<String, String> data : allData) {
            String pass = data.get("password");
            getDriver().findElement(By.xpath(pass_xpath)).sendKeys(pass);
        }
    }
    public static void sendkeys_confirmpass() throws Exception {
        List<Map<String, String>> allData = FlexibleJsonReader.getAllData("src/test/data.json");
        for (Map<String, String> data : allData) {
            String confirm_pass = data.get("confirm password");
            getDriver().findElement(By.xpath(confirmpass_xpath)).sendKeys(confirm_pass);
        }
    }
    public static void createaccount_btn() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,1000)", "");
        Thread.sleep(3000);
        getDriver().findElement(By.xpath(create_account_btn_xpath)).click();
    }
    public static void signup_successfully() throws InterruptedException {
        Thread.sleep(1000);
        SoftAssert softAssert = new SoftAssert();
        String currentUrl =   getDriver().getCurrentUrl();
        String actualurl="https://magento.softwaretestingboard.com/customer/account/";
        softAssert.assertEquals(actualurl,currentUrl);
        getDriver().findElement(By.xpath(drobdown_xpath)).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath(logout_xpath)).click();
    }
    public static void sendkeys_wrongemail() throws Exception {
        List<Map<String, String>> allData = FlexibleJsonReader.getAllData("src/test/data.json");
        for (Map<String, String> data : allData) {
            String invalid_email = data.get("invalid email");
            getDriver().findElement(By.xpath(email_xpath)).sendKeys(invalid_email);
        }
    }
    public static void sendkeys_wrongconfirmpass() throws Exception {
        List<Map<String, String>> allData = FlexibleJsonReader.getAllData("src/test/data.json");
        for (Map<String, String> data : allData) {
            String wrong_confirm = data.get("different pass");

            getDriver().findElement(By.xpath(confirmpass_xpath)).sendKeys(wrong_confirm);
        }
    }
   public static void confirm_pass_error()throws Exception{
        SoftAssert softAssert = new SoftAssert();
        String currentmsg=getDriver().findElement(By.xpath(confirm_pass_error_xpath)).getText();
        String actualmsg="Please enter the same value again.";
        softAssert.assertEquals(currentmsg,actualmsg);
   }

    public static void messing_value_error()throws Exception{
        SoftAssert softAssert = new SoftAssert();
        String currentmsg=getDriver().findElement(By.xpath(messing_value_error_xpath)).getText();
        String actualmsg="This is a required field.";
        softAssert.assertEquals(currentmsg,actualmsg);
    }
    public static void wrong_email_msg () throws InterruptedException{
        Thread.sleep(1000);
       SoftAssert softassert = new SoftAssert();
       String currentmessage = getDriver().findElement(By.xpath(wrong_email_msg_xpath)).getText();
       String actualmessage="Please enter a valid email address (Ex: johndoe@domain.com).";
       softassert.assertEquals(currentmessage,actualmessage);
    }


}

