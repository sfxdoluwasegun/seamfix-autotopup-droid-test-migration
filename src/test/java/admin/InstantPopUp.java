package admin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.TestBase;
import utils.TestUtils;

public class InstantPopUp extends TestBase {


    @Test
    public void InstantPopUpMyNum  () throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(getDriver(), 30);

        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//android.widget.CheckedTextView[@text='Instant TopUp']")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Select Topup Option']")).click();
        Thread.sleep(600);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='My phone number']")).click();

        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).sendKeys("50");

        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        Thread.sleep(2000);
        Alert alert = getDriver().switchTo().alert(); alert.accept();

        PinMethod();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/success_label")));
        Thread.sleep(1000);
        TestUtils.assertSearchText("ID", "com.seamfix.autotopup:id/success_label", "Success!!!");

        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();

    }

    @Test
    public void InstantPopUpNewNum  () throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//android.widget.CheckedTextView[@text='Instant TopUp']")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Select Topup Option']")).click();
        Thread.sleep(600);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Type a phone number']")).click();

        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Select Network Carrier']")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='GLO-NG']")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/phone_number_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/phone_number_input")).sendKeys(TestUtils.generatePhoneNumber());

        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).sendKeys("50");
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        Thread.sleep(2000);
        Alert alert = getDriver().switchTo().alert(); alert.accept();
        PinMethod();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/success_label")));
        TestUtils.assertSearchText("ID", "com.seamfix.autotopup:id/success_label", "Success!!!");

        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();

    }

    @Test
    public void InstantPopUpFromSavedProfiles  () throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//android.widget.CheckedTextView[@text='Instant TopUp']")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Select Topup Option']")).click();
        Thread.sleep(600);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Choose from saved profiles']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//android.widget.ImageView[@bounds='[24,347][104,427]']")).click();
        Thread.sleep(500);

        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).sendKeys("50");

        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        Thread.sleep(2000);
        Alert alert = getDriver().switchTo().alert(); alert.accept();
        PinMethod();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/success_label")));
        TestUtils.assertSearchText("ID", "com.seamfix.autotopup:id/success_label", "Success!!!");

        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();

    }


    public static void PinMethod() throws InterruptedException {
        Thread.sleep(1500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='1']")).click();
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='2']")).click();
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='3']")).click();
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='4']")).click();

    }

}
