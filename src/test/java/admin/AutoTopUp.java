package admin;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.TestBase;
import utils.TestUtils;

public class AutoTopUp extends TestBase {
    @Test
    public void AutoTopupWithNumber  () throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        getDriver().findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/imageView2")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/fab_add_autotop_profile")).click();
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Select Network Carrier']")).click();
      /*  getDriver().findElement(By.cssSelector("#mat-option-2 > span.mat-option-text")).click();
        getDriver().findElement(By.id("autoRechargeFullname")).clear();
        getDriver().findElement(By.id("autoRechargeFullname")).sendKeys("Osepadeolu Sunday");
        getDriver().findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Full name should be first name and last name without special charaters e.g John Doe'])[1]/following::div[4]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//mat-option/span")).click();
        String number= TestUtils.generateSerialNumber()+"0000";
        getDriver().findElement(By.id("autoRechargePhoneNumber")).clear();
        getDriver().findElement(By.id("autoRechargePhoneNumber")).sendKeys(number);
        getDriver().findElement(By.id("autoRechargeTopupAmount")).clear();
        getDriver().findElement(By.id("autoRechargeTopupAmount")).sendKeys("1000");
        getDriver().findElement(By.cssSelector("#autoRechargeThreshold > div.mat-select-trigger > div.mat-select-arrow-wrapper")).click();
        getDriver().findElement(By.xpath("//mat-option[2]/span")).click();
        getDriver().findElement(By.id("autoRechargeTopupLimit")).sendKeys("1000");
        getDriver().findElement(By.xpath("//div[8]/mat-form-field/div/div/div")).click();
        getDriver().findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='DAILY'])[1]/following::span[1]")).click();
        getDriver().findElement(By.id("autoRechargeProceed")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("autoRechargeConfirmationProceed")).click();

        Thread.sleep(1500);
        TestUtils.assertSearchText("XPATH", "(.//*[normalize-space(text()) and normalize-space(.)='Initialising your Autotopup contents...'])[1]/following::div[4]", "Successfully created auto recharge profile.");

        //getDriver().findElement(By.id("autoRechargePaymentProfileProceed")).click();
        Thread.sleep(1000);
        //assertSearchText("ID", "addCard", "Add a Debit Card");


*/
    }


}
