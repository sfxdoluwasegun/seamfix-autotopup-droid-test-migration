package admin;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.TestBase;
import utils.TestUtils;

public class Sharer extends TestBase  {
    @Test
    public void CopyLink() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/share_referral_code")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/copy_referral_code")).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Toast[1]")));
        Thread.sleep(1000);
        TestUtils.assertSearchText("XPATH", "//android.widget.Toast[1]", "Referral Code copied");

    }

    @Test
    public void ShareLink() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(1000);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/share_referral_code")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/title")));
        Thread.sleep(1000);
        TestUtils.assertSearchText("ID", "android:id/title", "Share Referral Code");
        getDriver().findElement(By.xpath("//android.widget.ImageView[@bounds='[66,429][162,525]']")).click();

    }

    @Test
    public void SendLinkBySms() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/share_referral_code_via_sms")));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/share_referral_code_via_sms")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='New message']")));
        Thread.sleep(1000);
        TestUtils.assertSearchText("XPATH", "//android.widget.TextView[@text='New message']", "New message");

    }


}
