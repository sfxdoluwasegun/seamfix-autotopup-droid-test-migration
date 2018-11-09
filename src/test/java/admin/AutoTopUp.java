package admin;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.TestBase;
import utils.TestUtils;

import static utils.TestUtils.assertSearchText;
import static utils.TestUtils.generatePhoneNumber;

public class AutoTopUp extends TestBase {
    @Test
    public void AutoTopupWithNumber  () throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        getDriver().findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/imageView2")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/fab_add_autotop_profile")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Select Network Carrier']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='MTN-NG']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/phone_number_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/phone_number_input")).sendKeys(generatePhoneNumber());
        getDriver().findElement(By.id("com.seamfix.autotopup:id/full_name_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/full_name_input")).sendKeys("Osepadeolu Sunday");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/email_address_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/email_address_input")).sendKeys("sunepastar@gmail.com");
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Select Threshold']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='10.00']")).click();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).sendKeys("100");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_limit_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_limit_input")).sendKeys("1000");
        String scrollViewContainer_finder = "new UiSelector().resourceIdMatches(\".*id/autotopup_input_form_container\")";
        String neededElement_finder = "new UiSelector().resourceIdMatches(\".*id/proceed_button\")";

        WebElement abc = getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(" + scrollViewContainer_finder + ")" +
                ".scrollIntoView(" + neededElement_finder + ")"));
        Thread.sleep(1000);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_cycle_spinner")).click();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_cycle_spinner")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='DAILY']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/confirm_button")).click();
        Thread.sleep(500);

        getDriver().findElement(By.xpath("//android.widget.TextView[@text='1']")).click();
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='2']")).click();
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='3']")).click();
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='4']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/fab_add_autotop_profile")));
        WebElement toastView = getDriver().findElement(By.xpath("//android.widget.Toast[1]"));
        String text = toastView.getAttribute("name");
        //System.out.println(text);
        assertSearchText("XPATH", "//android.widget.Toast[1]", "Request completed!");

    }


}
