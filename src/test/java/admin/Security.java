package admin;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.TestBase;
import utils.TestUtils;

public class Security extends TestBase {

    @Test
     public void changePin() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']")).click();
        getDriver().findElement(By.xpath("//android.widget.CheckedTextView[@text='Settings']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Security']")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/change_pin_view")).click();
         TestUtils.PinMethod();
         Thread.sleep(2000);
         newPinMethod();
         Thread.sleep(500);
         //confirme new pin
         newPinMethod();

        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='You have successfully updated your PIN']")));
        TestUtils.assertSearchText("XPATH", "//android.widget.TextView[@text='You have successfully updated your PIN']", "You have successfully updated your PIN");

        //proceed
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();


        getDriver().findElement(By.id("com.seamfix.autotopup:id/change_pin_view")).click();
        newPinMethod();
        Thread.sleep(2000);
        TestUtils.PinMethod();
        Thread.sleep(500);
        //confirme new pin
        TestUtils.PinMethod();

        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='You have successfully updated your PIN']")));
        TestUtils.assertSearchText("XPATH", "//android.widget.TextView[@text='You have successfully updated your PIN']", "You have successfully updated your PIN");

        //proceed
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();

    }

    public void resetPin() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']")).click();

    }

    @Test
    public void deactivatePin() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(3000);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/pin_state_switch")).click();
        Thread.sleep(1000);
        TestUtils.acceptAlert();
        TestUtils.PinMethod();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/pin_state_switch")));
        TestUtils.assertSearchText("ID", "com.seamfix.autotopup:id/pin_state_switch']", "OFF");

    }


    @Test
    public void activatePin() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(3000);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/pin_state_switch")).click();
        Thread.sleep(1000);
        TestUtils.acceptAlert();
        TestUtils.PinMethod();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/pin_state_switch")));
        TestUtils.assertSearchText("ID", "com.seamfix.autotopup:id/pin_state_switch']", "ON");

    }

    public static void newPinMethod() throws InterruptedException {
        Thread.sleep(200);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='1']")).click();
        Thread.sleep(200);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='2']")).click();
        Thread.sleep(200);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='3']")).click();
        Thread.sleep(200);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='5']")).click();

    }
}
