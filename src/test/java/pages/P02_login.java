package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import utility.BrowserDriver;
import utility.FlexibleJsonReader;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class P02_login extends BrowserDriver {
    public static String login_btn_xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]";
    public static String email_xpath = "//input[@id='email']";
    public static String password_xpath = "//fieldset[@class='fieldset login']//input[@id='pass']";
    public static String submit_btn_xpath = "//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]";
    public static String invalid_login_msg ="//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div";
    public static String drobdown_xpath="//div[@class='panel header']//button[@type='button']";
    public static String logout_xpath="//div[@aria-hidden='false']//a[normalize-space()='Sign Out']";
    public static  String invalid_email_msg_xpath="//div[@id='email-error']";
    public static void open_home_page() throws InterruptedException {
        getDriver().get("https://magento.softwaretestingboard.com/");
    }

    public static void open_login_page() throws InterruptedException {
        Thread.sleep(5000);
        getDriver().findElement(By.xpath(login_btn_xpath)).click();

    }


    public static void Sendkeys_loginemail() throws Exception {
        List<Map<String, String>> allData = FlexibleJsonReader.getAllData("src/test/data.json");
        for (Map<String, String> data : allData) {
            String email = data.get("email");
            getDriver().findElement(By.xpath(email_xpath)).sendKeys(email);
        }
    }
    public static void Sendkeys_invalidemail () throws Exception {
        List<Map<String, String>> allData = FlexibleJsonReader.getAllData("src/test/data.json");
        for (Map<String, String> data : allData) {
            String invalid_email = data.get("invalid email");
            getDriver().findElement(By.xpath(email_xpath)).sendKeys(invalid_email);
        }

        }



    public static void Sendkeys_loginpass () throws Exception {
        List<Map<String, String>> allData = FlexibleJsonReader.getAllData("src/test/data.json");
        for (Map<String, String> data : allData) {
            String pass = data.get("password");
            getDriver().findElement(By.xpath(password_xpath)).sendKeys(pass);
        }
    }
    public static void Sendkeys_invalidpass () throws Exception {

        List<Map<String, String>> allData = FlexibleJsonReader.getAllData("src/test/data.json");
        for (Map<String, String> data : allData) {
            String invalid_pass = data.get("invalid pass");
            getDriver().findElement(By.xpath(password_xpath)).sendKeys(invalid_pass);
        }
    }
    public static void clickonsubmit_btn () throws InterruptedException {
        JavascriptExecutor js= (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,200)","");
        Thread.sleep(1000);
        getDriver().findElement(By.xpath(submit_btn_xpath)).click();
    }

    public static void login_successfully () throws InterruptedException{
        Thread.sleep(3000);
        String currentUrl =  getDriver().getCurrentUrl();
        assertEquals(currentUrl,"https://magento.softwaretestingboard.com/");
        Thread.sleep(2000);
        getDriver().findElement(By.xpath(drobdown_xpath)).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath(logout_xpath)).click();
    }
    public static void invalid_login_msg () throws InterruptedException{
        WebDriverWait Wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement actualmsg = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(invalid_login_msg)));
        SoftAssert softAssert = new SoftAssert();
        String actual_msg =  actualmsg.getText();
        String expected_msg="The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later";
        softAssert.assertEquals(actual_msg,expected_msg);
    }
    public static void Invalid_email_msg () throws InterruptedException{
        WebDriverWait Wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement actualmsg = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(invalid_email_msg_xpath)));
        SoftAssert softAssert = new SoftAssert();
        String actual_msg =  actualmsg.getText();
        String expected_msg="Please enter a valid email address (Ex: johndoe@domain.com).";
        softAssert.assertEquals(actual_msg,expected_msg);
    }
}