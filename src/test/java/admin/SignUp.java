package admin;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.TestBase;
import utils.TestUtils;

import java.util.Random;

public class SignUp extends TestBase {
    String random = TestUtils.generateRandomNumber();
    String email = "test"+random+"@yopmail.com";
    String firstName = "User"+random;
    String lastName = "UserLast"+random;
    String phoneNumber = TestUtils.generatePhoneNumber();

    Random r = new Random();
    int Low = 1;
    int High = 5;
    int result = r.nextInt(High-Low) + Low;

    @Test
    public void signUpForm() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);

        Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/app_title")));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/signup_button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='TERMS AND CONDITIONS']")));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/reject_button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/app_title")));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/signup_button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='TERMS AND CONDITIONS']")));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/accept_button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Join AutoTopUp']")));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/firstname_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/firstname_input")).sendKeys(firstName);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/lastname_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/lastname_input")).sendKeys(lastName);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/email_address_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/email_address_input")).sendKeys(email);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/password_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/password_input")).sendKeys("password");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/network_carrier_spinner")).click();
        if(result == 1){
            getDriver().findElement(By.xpath("//android.widget.TextView[@text='GLO-NG']")).click();
        }else if(result == 2){
            getDriver().findElement(By.xpath("//android.widget.TextView[@text='9MOBILE-NG']")).click();
        }else if(result == 3){
            getDriver().findElement(By.xpath("//android.widget.TextView[@text='MTN-NG']")).click();
        }else {
            getDriver().findElement(By.xpath("//android.widget.TextView[@text='AIRTEL-NG']")).click();
        }
        getDriver().findElement(By.id("com.seamfix.autotopup:id/phone_number_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/phone_number_input")).sendKeys(phoneNumber);

        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/welcome_text")));
        TestUtils.assertSearchText("ID", "com.seamfix.autotopup:id/welcome_text", "Congratulations User!");
        Thread.sleep(500);
    }

    @Test
    public void activateAccount() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/activate_btn")));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/activate_btn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/welcome_text")));
        TestUtils.assertSearchText("ID", "com.seamfix.autotopup:id/welcome_text", "SECURITY INFORMATION");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/got_it_btn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/header_container")));

    }

    @Test
    public void paymentMethod() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/header_container")));
        if(result == 1){
            payWithMasterCard();

        }else if(result == 2){
            getDriver().findElement(By.xpath("//android.widget.TextView[@text='Visa Card']")).click();
        }else if(result == 3){
            getDriver().findElement(By.xpath("//android.widget.TextView[@text='Verve Card']")).click();
        }else {
            getDriver().findElement(By.xpath("//android.widget.TextView[@text='Pay with Bank']")).click();
        }

    }

    public void payWithMasterCard() throws InterruptedException{

        WebDriverWait wait = new WebDriverWait(getDriver(), 30);

        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Master Card']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/payment_option_logo")));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/cardNumberEdt")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/cardNumberEdt")).sendKeys("4084084084084081");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/expiryDateEdt")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/expiryDateEdt")).sendKeys("01/19");
            /*getDriver().findElement(By.id("com.seamfix.autotopup:id/cvvEdt")).clear();
            getDriver().findElement(By.id("com.seamfix.autotopup:id/cvvEdt")).sendKeys("");*/
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/alertTitle")));
        getDriver().findElement(By.id("android:id/button1")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/success_logo")));
        TestUtils.assertSearchText("ID", "com.seamfix.autotopup:id/success_label_view", "Your account activation was successful!");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        if(TestUtils.isElementPresent("ID", "com.seamfix.autotopup:id/alertTitle")){
            getDriver().findElement(By.id("android:id/button2")).click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Dashboard']")));

    }
}
