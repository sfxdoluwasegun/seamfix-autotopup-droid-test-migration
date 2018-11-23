package admin;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.TestBase;
import utils.TestUtils;

public class Login extends TestBase {

    @Test
    public void loginWithEmptyEmailAndPassword() throws InterruptedException{
        Thread.sleep(500);
        WebDriverWait wait = new WebDriverWait(getDriver(), 45);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/app_title")));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/login_button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/toolbar")));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/email_address_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/email_address_input")).sendKeys("");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/password_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/password_input")).sendKeys("");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/login_button")).click();
        Thread.sleep(500);
        TestUtils.assertSearchText("ID", "com.seamfix.autotopup:id/textinput_error", "Please fill this field");
        TestUtils.assertSearchText("ID", "com.seamfix.autotopup:id/textinput_error", "Please fill this field");
        Thread.sleep(500);


    }

    @Test
    public void loginWithEmptyEmailAndValidPassword() throws InterruptedException{

        getDriver().findElement(By.id("com.seamfix.autotopup:id/email_address_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/email_address_input")).sendKeys("");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/password_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/password_input")).sendKeys("password");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/login_button")).click();
        Thread.sleep(500);
        TestUtils.assertSearchText("ID", "com.seamfix.autotopup:id/textinput_error", "Please fill this field");
        Thread.sleep(500);

    }

    @Test
    public void loginWithValidEmailAndInvalidPassword() throws InterruptedException{
        getDriver().findElement(By.id("com.seamfix.autotopup:id/email_address_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/email_address_input")).sendKeys("test@yopmail.com");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/password_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/password_input")).sendKeys("invalidPassword");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/login_button")).click();
        Thread.sleep(500);

    }

    @Test
    public void loginWithInvalidEmailAndValidPassword() throws InterruptedException{

        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/email_address_input")));
        Thread.sleep(1000);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/email_address_input")).clear();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/email_address_input")).sendKeys("test@yopmail.com");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/password_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/password_input")).sendKeys("password");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/login_button")).click();
        Thread.sleep(500);

    }

    @Test
    public void loginWithInValidEmailAndInvalidPassword() throws InterruptedException{

        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/email_address_input")));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/email_address_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/email_address_input")).sendKeys("invalidEmail@yopmail.com");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/password_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/password_input")).sendKeys("invalidPassword");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/login_button")).click();
        Thread.sleep(500);

    }

    @Test
    public void loginWithValidEmailAndValidPassword() throws InterruptedException{

        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/email_address_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/email_address_input")).sendKeys("test@yopmail.com");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/password_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/password_input")).sendKeys("password");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/login_button")).click();
        Thread.sleep(1000);
        if(TestUtils.isElementPresent("ID", "com.seamfix.autotopup:id/alertTitle")){
            getDriver().findElement(By.id("android:id/button2")).click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Auto Top Up']")));
    }

}
