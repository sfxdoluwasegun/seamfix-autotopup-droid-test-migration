package admin;


import com.aventstack.extentreports.Status;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.TestBase;
import utils.TestUtils;

public class ScheduledTopUp extends TestBase {

    @Test
    public void ScheduledTopUpMyNumOneOff() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//android.widget.CheckedTextView[@text='Schedule Airtime']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/fab_add_schedule")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_mode_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='My phone number']")).click();

        //------------------------------------------//

        getDriver().findElement(By.id("com.seamfix.autotopup:id/frequency_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='ONE-OFF']")).click();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/date_picker")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/next")).click();
        Thread.sleep(1500);
        getDriver().findElement(By.xpath("//android.view.View[@text='29']")).click();
        getDriver().findElement(By.id("android:id/button1")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/time_picker_wrapper")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        //TestUtils.ScrollTo("com.seamfix.autotopup:id/input_form_container", "com.seamfix.autotopup:id/proceed_button");
        String scrollViewContainer_finder = "new UiSelector().resourceIdMatches(\".*id/input_form_container\")";
        String neededElement_finder = "new UiSelector().resourceIdMatches(\".*id/proceed_button\")";

        WebElement abc = getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(" + scrollViewContainer_finder + ")" +
                ".scrollIntoView(" + neededElement_finder + ")"));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).sendKeys("50");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        TestUtils.PinMethod();
        Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/fab_add_schedule")));
        Thread.sleep(1000);
        TestUtils.assertSearchText("XPATH", "//android.widget.Toast[1]", "Request completed!");


    }

    @Test
    public void ScheduledTopUpMyNumDaily() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/fab_add_schedule")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_mode_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='My phone number']")).click();

        //------------------------------------------//

        getDriver().findElement(By.id("com.seamfix.autotopup:id/frequency_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='DAILY']")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/time_picker_wrapper")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        //TestUtils.scrollUntilElementIsVisible("ID", "com.seamfix.autotopup:id/proceed_button");
        String scrollViewContainer_finder = "new UiSelector().resourceIdMatches(\".*id/input_form_container\")";
        String neededElement_finder = "new UiSelector().resourceIdMatches(\".*id/proceed_button\")";

        WebElement abc = getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(" + scrollViewContainer_finder + ")" +
                ".scrollIntoView(" + neededElement_finder + ")"));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).sendKeys("50");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        TestUtils.PinMethod();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/fab_add_schedule")));
        Thread.sleep(1000);
        TestUtils.assertSearchText("XPATH", "//android.widget.Toast[1]", "Request completed!");



    }

    @Test
    public void ScheduledTopUpMyNumWeekly() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/fab_add_schedule")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_mode_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='My phone number']")).click();

        //------------------------------------------//

        getDriver().findElement(By.id("com.seamfix.autotopup:id/frequency_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='WEEKLY']")).click();
        Thread.sleep(500);
        //select day
        getDriver().findElement(By.id("com.seamfix.autotopup:id/weekly_options_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Sunday']")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/time_picker_wrapper")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        //TestUtils.scrollUntilElementIsVisible("ID", "com.seamfix.autotopup:id/proceed_button");
        String scrollViewContainer_finder = "new UiSelector().resourceIdMatches(\".*id/input_form_container\")";
        String neededElement_finder = "new UiSelector().resourceIdMatches(\".*id/proceed_button\")";

        WebElement abc = getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(" + scrollViewContainer_finder + ")" +
                ".scrollIntoView(" + neededElement_finder + ")"));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).sendKeys("50");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        TestUtils.PinMethod();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/fab_add_schedule")));
        Thread.sleep(1000);
        TestUtils.assertSearchText("XPATH", "//android.widget.Toast[1]", "Request completed!");



    }

    @Test
    public void ScheduledTopUpMyNumMonthlyFistday() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/fab_add_schedule")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_mode_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='My phone number']")).click();

        //------------------------------------------//

        getDriver().findElement(By.id("com.seamfix.autotopup:id/frequency_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='MONTHLY']")).click();
        Thread.sleep(1000);
        //select month
        getDriver().findElement(By.id("com.seamfix.autotopup:id/monthly_options_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='the first day of the month']")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/time_picker_wrapper")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        //TestUtils.scrollUntilElementIsVisible("ID", "com.seamfix.autotopup:id/proceed_button");
        String scrollViewContainer_finder = "new UiSelector().resourceIdMatches(\".*id/input_form_container\")";
        String neededElement_finder = "new UiSelector().resourceIdMatches(\".*id/proceed_button\")";

        WebElement abc = getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(" + scrollViewContainer_finder + ")" +
                ".scrollIntoView(" + neededElement_finder + ")"));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).sendKeys("50");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        TestUtils.PinMethod();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/fab_add_schedule")));
        Thread.sleep(1000);
        TestUtils.assertSearchText("XPATH", "//android.widget.Toast[1]", "Request completed!");



    }


    @Test
    public void ScheduledTopUpMyNumMonthlyLastday() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/fab_add_schedule")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_mode_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='My phone number']")).click();

        //------------------------------------------//

        getDriver().findElement(By.id("com.seamfix.autotopup:id/frequency_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='MONTHLY']")).click();
        Thread.sleep(1000);
        //select month
        getDriver().findElement(By.id("com.seamfix.autotopup:id/monthly_options_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='the last day of the month']")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/time_picker_wrapper")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        //TestUtils.scrollUntilElementIsVisible("ID", "com.seamfix.autotopup:id/proceed_button");
        String scrollViewContainer_finder = "new UiSelector().resourceIdMatches(\".*id/input_form_container\")";
        String neededElement_finder = "new UiSelector().resourceIdMatches(\".*id/proceed_button\")";

        WebElement abc = getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(" + scrollViewContainer_finder + ")" +
                ".scrollIntoView(" + neededElement_finder + ")"));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).sendKeys("50");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        TestUtils.PinMethod();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/fab_add_schedule")));
        Thread.sleep(1000);
        TestUtils.assertSearchText("XPATH", "//android.widget.Toast[1]", "Request completed!");



    }

    @Test
    public void ScheduledTopUpMyNumMonthlySpecificday() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/fab_add_schedule")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_mode_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='My phone number']")).click();

        //------------------------------------------//

        getDriver().findElement(By.id("com.seamfix.autotopup:id/frequency_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='MONTHLY']")).click();
        Thread.sleep(500);
        //select month
        getDriver().findElement(By.id("com.seamfix.autotopup:id/monthly_options_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='a specific day of the month']")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/set_button")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/time_picker_wrapper")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        //TestUtils.scrollUntilElementIsVisible("ID", "com.seamfix.autotopup:id/proceed_button");
        String scrollViewContainer_finder = "new UiSelector().resourceIdMatches(\".*id/input_form_container\")";
        String neededElement_finder = "new UiSelector().resourceIdMatches(\".*id/proceed_button\")";

        WebElement abc = getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(" + scrollViewContainer_finder + ")" +
                ".scrollIntoView(" + neededElement_finder + ")"));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).sendKeys("50");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        TestUtils.PinMethod();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/fab_add_schedule")));
        Thread.sleep(1000);
        TestUtils.assertSearchText("XPATH", "//android.widget.Toast[1]", "Request completed!");

    }

    public void withNumberMethod() throws InterruptedException {
        Thread.sleep(1000);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/network_carrier_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='GLO-NG']")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/phone_number_input")).clear();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/phone_number_input")).sendKeys(TestUtils.generatePhoneNumber());
        Thread.sleep(1000);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/full_name_input")).clear();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/full_name_input")).sendKeys("Osepadeolu sunday");
        Thread.sleep(1000);

    }

    @Test
    public void ScheduledTopUpInputNumOneOff() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(1000);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/fab_add_schedule")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_mode_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Type a phone number']")).click();

        //------------------------------------------//
        withNumberMethod();
        //------------------------------------------//
        getDriver().findElement(By.id("com.seamfix.autotopup:id/frequency_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='ONE-OFF']")).click();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/date_picker")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/next")).click();
        Thread.sleep(1500);
        getDriver().findElement(By.xpath("//android.view.View[@text='29']")).click();
        getDriver().findElement(By.id("android:id/button1")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/time_picker_wrapper")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        //TestUtils.ScrollTo("com.seamfix.autotopup:id/input_form_container", "com.seamfix.autotopup:id/proceed_button");
        String scrollViewContainer_finder = "new UiSelector().resourceIdMatches(\".*id/input_form_container\")";
        String neededElement_finder = "new UiSelector().resourceIdMatches(\".*id/proceed_button\")";

        WebElement abc = getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(" + scrollViewContainer_finder + ")" +
                ".scrollIntoView(" + neededElement_finder + ")"));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).sendKeys("50");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        TestUtils.PinMethod();
        Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/fab_add_schedule")));
        Thread.sleep(1000);
        TestUtils.assertSearchText("XPATH", "//android.widget.Toast[1]", "Request completed!");


    }

    @Test
    public void ScheduledTopUpInputNumDaily() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/fab_add_schedule")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_mode_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Type a phone number']")).click();

        //------------------------------------------//
        withNumberMethod();
        //------------------------------------------//

        getDriver().findElement(By.id("com.seamfix.autotopup:id/frequency_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='DAILY']")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/time_picker_wrapper")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        //TestUtils.scrollUntilElementIsVisible("ID", "com.seamfix.autotopup:id/proceed_button");
        String scrollViewContainer_finder = "new UiSelector().resourceIdMatches(\".*id/input_form_container\")";
        String neededElement_finder = "new UiSelector().resourceIdMatches(\".*id/proceed_button\")";

        WebElement abc = getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(" + scrollViewContainer_finder + ")" +
                ".scrollIntoView(" + neededElement_finder + ")"));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).sendKeys("50");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        TestUtils.PinMethod();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/fab_add_schedule")));
        Thread.sleep(1000);
        TestUtils.assertSearchText("XPATH", "//android.widget.Toast[1]", "Request completed!");



    }

    @Test
    public void ScheduledTopUpInputNumWeekly() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/fab_add_schedule")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_mode_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Type a phone number']")).click();

        //------------------------------------------//
        withNumberMethod();
        //------------------------------------------//

        getDriver().findElement(By.id("com.seamfix.autotopup:id/frequency_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='WEEKLY']")).click();
        Thread.sleep(500);
        //select day
        getDriver().findElement(By.id("com.seamfix.autotopup:id/weekly_options_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Sunday']")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/time_picker_wrapper")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        //TestUtils.scrollUntilElementIsVisible("ID", "com.seamfix.autotopup:id/proceed_button");
        String scrollViewContainer_finder = "new UiSelector().resourceIdMatches(\".*id/input_form_container\")";
        String neededElement_finder = "new UiSelector().resourceIdMatches(\".*id/proceed_button\")";

        WebElement abc = getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(" + scrollViewContainer_finder + ")" +
                ".scrollIntoView(" + neededElement_finder + ")"));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).sendKeys("50");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        TestUtils.PinMethod();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/fab_add_schedule")));
        Thread.sleep(1000);
        TestUtils.assertSearchText("XPATH", "//android.widget.Toast[1]", "Request completed!");



    }

    @Test
    public void ScheduledTopUpInputNumMonthlyFistday() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/fab_add_schedule")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_mode_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Type a phone number']")).click();

        //------------------------------------------//
        withNumberMethod();
        //------------------------------------------//

        getDriver().findElement(By.id("com.seamfix.autotopup:id/frequency_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='MONTHLY']")).click();
        Thread.sleep(1000);
        //select month
        getDriver().findElement(By.id("com.seamfix.autotopup:id/monthly_options_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='the first day of the month']")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/time_picker_wrapper")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        //TestUtils.scrollUntilElementIsVisible("ID", "com.seamfix.autotopup:id/proceed_button");
        String scrollViewContainer_finder = "new UiSelector().resourceIdMatches(\".*id/input_form_container\")";
        String neededElement_finder = "new UiSelector().resourceIdMatches(\".*id/proceed_button\")";

        WebElement abc = getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(" + scrollViewContainer_finder + ")" +
                ".scrollIntoView(" + neededElement_finder + ")"));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).sendKeys("50");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        TestUtils.PinMethod();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/fab_add_schedule")));
        Thread.sleep(1000);
        TestUtils.assertSearchText("XPATH", "//android.widget.Toast[1]", "Request completed!");

    }


    @Test
    public void ScheduledTopUpInputNumMonthlyLastday() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/fab_add_schedule")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_mode_spinner")).click();

        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Type a phone number']")).click();

        //------------------------------------------//
        withNumberMethod();
        //------------------------------------------//

        getDriver().findElement(By.id("com.seamfix.autotopup:id/frequency_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='MONTHLY']")).click();
        Thread.sleep(1000);
        //select month
        getDriver().findElement(By.id("com.seamfix.autotopup:id/monthly_options_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='the last day of the month']")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/time_picker_wrapper")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        //TestUtils.scrollUntilElementIsVisible("ID", "com.seamfix.autotopup:id/proceed_button");
        String scrollViewContainer_finder = "new UiSelector().resourceIdMatches(\".*id/input_form_container\")";
        String neededElement_finder = "new UiSelector().resourceIdMatches(\".*id/proceed_button\")";

        WebElement abc = getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(" + scrollViewContainer_finder + ")" +
                ".scrollIntoView(" + neededElement_finder + ")"));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).sendKeys("50");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        TestUtils.PinMethod();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/fab_add_schedule")));
        Thread.sleep(1000);
        TestUtils.assertSearchText("XPATH", "//android.widget.Toast[1]", "Request completed!");



    }

    @Test
    public void ScheduledTopUpInputNumMonthlySpecificday() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/fab_add_schedule")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_mode_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Type a phone number']")).click();

        //------------------------------------------//
        withNumberMethod();
        //------------------------------------------//

        getDriver().findElement(By.id("com.seamfix.autotopup:id/frequency_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='MONTHLY']")).click();
        Thread.sleep(500);
        //select month
        getDriver().findElement(By.id("com.seamfix.autotopup:id/monthly_options_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='a specific day of the month']")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/set_button")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/time_picker_wrapper")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        //TestUtils.scrollUntilElementIsVisible("ID", "com.seamfix.autotopup:id/proceed_button");
        String scrollViewContainer_finder = "new UiSelector().resourceIdMatches(\".*id/input_form_container\")";
        String neededElement_finder = "new UiSelector().resourceIdMatches(\".*id/proceed_button\")";

        WebElement abc = getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(" + scrollViewContainer_finder + ")" +
                ".scrollIntoView(" + neededElement_finder + ")"));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).sendKeys("50");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        TestUtils.PinMethod();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/fab_add_schedule")));
        Thread.sleep(1000);
        TestUtils.assertSearchText("XPATH", "//android.widget.Toast[1]", "Request completed!");

    }


    public void ChooseFromSavedProfile() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(getDriver(), 30);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Saved Profiles']")));
        Thread.sleep(2000);
        String fullname=getDriver().findElement(By.xpath("//android.widget.TextView[@bounds='[114,194][706,245]']")).getText();
        String successMessage=fullname+"'s profile selected";
        getDriver().findElement(By.xpath("//android.widget.ImageView[@bounds='[24,347][104,427]']")).click();
        Thread.sleep(500);
        //TestUtils.assertSearchText("XPATH", "//android.widget.Toast[1]", successMessage);
        testInfo.get().log(Status.INFO, "A profile is selected" + "");
        Thread.sleep(1000);

    }

    @Test
    public void ScheduledTopUpSavedProfileOneOff() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(1000);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/fab_add_schedule")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_mode_spinner")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Choose from saved profiles']")).click();

        //------------------------------------------//
        ChooseFromSavedProfile();
        //------------------------------------------//
        getDriver().findElement(By.id("com.seamfix.autotopup:id/frequency_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='ONE-OFF']")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/date_picker")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/next")).click();
        Thread.sleep(1500);
        getDriver().findElement(By.xpath("//android.view.View[@text='29']")).click();
        getDriver().findElement(By.id("android:id/button1")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/time_picker_wrapper")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        //TestUtils.ScrollTo("com.seamfix.autotopup:id/input_form_container", "com.seamfix.autotopup:id/proceed_button");
        String scrollViewContainer_finder = "new UiSelector().resourceIdMatches(\".*id/input_form_container\")";
        String neededElement_finder = "new UiSelector().resourceIdMatches(\".*id/proceed_button\")";

        WebElement abc = getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(" + scrollViewContainer_finder + ")" +
                ".scrollIntoView(" + neededElement_finder + ")"));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).sendKeys("50");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        TestUtils.PinMethod();
        Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/fab_add_schedule")));
        Thread.sleep(1000);
        TestUtils.assertSearchText("XPATH", "//android.widget.Toast[1]", "Request completed!");


    }

    @Test
    public void ScheduledTopUpSavedProfileNumDaily() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/fab_add_schedule")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_mode_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Choose from saved profiles']")).click();

        //------------------------------------------//
        ChooseFromSavedProfile();
        //------------------------------------------//

        getDriver().findElement(By.id("com.seamfix.autotopup:id/frequency_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='DAILY']")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/time_picker_wrapper")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        //TestUtils.scrollUntilElementIsVisible("ID", "com.seamfix.autotopup:id/proceed_button");
        String scrollViewContainer_finder = "new UiSelector().resourceIdMatches(\".*id/input_form_container\")";
        String neededElement_finder = "new UiSelector().resourceIdMatches(\".*id/proceed_button\")";

        WebElement abc = getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(" + scrollViewContainer_finder + ")" +
                ".scrollIntoView(" + neededElement_finder + ")"));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).sendKeys("50");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        TestUtils.PinMethod();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/fab_add_schedule")));
        Thread.sleep(1000);
        TestUtils.assertSearchText("XPATH", "//android.widget.Toast[1]", "Request completed!");



    }

    @Test
    public void ScheduledTopUpSavedProfileWeekly() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/fab_add_schedule")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_mode_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Choose from saved profiles']")).click();

        //------------------------------------------//
        ChooseFromSavedProfile();
        //------------------------------------------//

        getDriver().findElement(By.id("com.seamfix.autotopup:id/frequency_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='WEEKLY']")).click();
        Thread.sleep(500);
        //select day
        getDriver().findElement(By.id("com.seamfix.autotopup:id/weekly_options_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Sunday']")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/time_picker_wrapper")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        //TestUtils.scrollUntilElementIsVisible("ID", "com.seamfix.autotopup:id/proceed_button");
        String scrollViewContainer_finder = "new UiSelector().resourceIdMatches(\".*id/input_form_container\")";
        String neededElement_finder = "new UiSelector().resourceIdMatches(\".*id/proceed_button\")";

        WebElement abc = getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(" + scrollViewContainer_finder + ")" +
                ".scrollIntoView(" + neededElement_finder + ")"));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).sendKeys("50");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        TestUtils.PinMethod();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/fab_add_schedule")));
        Thread.sleep(1000);
        TestUtils.assertSearchText("XPATH", "//android.widget.Toast[1]", "Request completed!");



    }

    @Test
    @Parameters("pwd")
    public void ScheduledTopUpSavedProfileMonthlyFistday(String pwd) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(500);
        if (pwd!="call") {
            getDriver().findElement(By.id("com.seamfix.autotopup:id/fab_add_schedule")).click();
        }
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_mode_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Choose from saved profiles']")).click();

        //------------------------------------------//
        ChooseFromSavedProfile();
        //------------------------------------------//

        getDriver().findElement(By.id("com.seamfix.autotopup:id/frequency_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='MONTHLY']")).click();
        Thread.sleep(1000);
        //select month
        getDriver().findElement(By.id("com.seamfix.autotopup:id/monthly_options_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='the first day of the month']")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/time_picker_wrapper")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        //TestUtils.scrollUntilElementIsVisible("ID", "com.seamfix.autotopup:id/proceed_button");
        String scrollViewContainer_finder = "new UiSelector().resourceIdMatches(\".*id/input_form_container\")";
        String neededElement_finder = "new UiSelector().resourceIdMatches(\".*id/proceed_button\")";

        WebElement abc = getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(" + scrollViewContainer_finder + ")" +
                ".scrollIntoView(" + neededElement_finder + ")"));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).sendKeys("50");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        Thread.sleep(1000);
        if (pwd!="call") {
            getDriver().findElement(By.id("android:id/button1")).click();
        }
        TestUtils.PinMethod();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/view_container")));
        Thread.sleep(1000);
        TestUtils.assertSearchText("XPATH", "//android.widget.Toast[1]", "Request completed!");

    }


    @Test
    public void ScheduledTopUpSavedProfileMonthlyLastday() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/fab_add_schedule")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_mode_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Choose from saved profiles']")).click();

        //------------------------------------------//
        ChooseFromSavedProfile();
        //------------------------------------------//

        getDriver().findElement(By.id("com.seamfix.autotopup:id/frequency_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='MONTHLY']")).click();
        Thread.sleep(1000);
        //select month
        getDriver().findElement(By.id("com.seamfix.autotopup:id/monthly_options_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='the last day of the month']")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/time_picker_wrapper")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        //TestUtils.scrollUntilElementIsVisible("ID", "com.seamfix.autotopup:id/proceed_button");
        String scrollViewContainer_finder = "new UiSelector().resourceIdMatches(\".*id/input_form_container\")";
        String neededElement_finder = "new UiSelector().resourceIdMatches(\".*id/proceed_button\")";

        WebElement abc = getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(" + scrollViewContainer_finder + ")" +
                ".scrollIntoView(" + neededElement_finder + ")"));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).sendKeys("50");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        TestUtils.PinMethod();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/fab_add_schedule")));
        Thread.sleep(1000);
        TestUtils.assertSearchText("XPATH", "//android.widget.Toast[1]", "Request completed!");

    }

    @Test
    public void ScheduledTopUpSavedProfileMonthlySpecificday() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/fab_add_schedule")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_mode_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Choose from saved profiles']")).click();

        //------------------------------------------//
        ChooseFromSavedProfile();
        //------------------------------------------//

        getDriver().findElement(By.id("com.seamfix.autotopup:id/frequency_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='MONTHLY']")).click();
        Thread.sleep(500);
        //select month
        getDriver().findElement(By.id("com.seamfix.autotopup:id/monthly_options_spinner")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='a specific day of the month']")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/set_button")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/time_picker_wrapper")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        //TestUtils.scrollUntilElementIsVisible("ID", "com.seamfix.autotopup:id/proceed_button");
        String scrollViewContainer_finder = "new UiSelector().resourceIdMatches(\".*id/input_form_container\")";
        String neededElement_finder = "new UiSelector().resourceIdMatches(\".*id/proceed_button\")";

        WebElement abc = getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(" + scrollViewContainer_finder + ")" +
                ".scrollIntoView(" + neededElement_finder + ")"));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_amount_input")).sendKeys("50");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/button1")).click();
        TestUtils.PinMethod();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/fab_add_schedule")));
        Thread.sleep(1000);
        TestUtils.assertSearchText("XPATH", "//android.widget.Toast[1]", "Request completed!");

    }

    @Test
    public void editScheduledTopup() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/fab_add_schedule")));
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Osepadeolu Sunday']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/action_edit_profile")).click();
        //edit this to saved
        ScheduledTopUpSavedProfileMonthlyFistday("call");
        Thread.sleep(1500);
        TestUtils.assertSearchText("XPATH", "//android.widget.TextView[@bounds='[20,845][304,896]']", "1st of Every month");
        //String ScheduledNow = getDriver().findElement(By.xpath("//android.widget.TextView[@text='a specific day of the month']")).getText();

    }

    @Test
    public void DeactivateScheduledTopup(){
         WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/activate_button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/fab_add_schedule")));
        TestUtils.assertSearchText("XPATH", "//android.widget.Toast[1]", "Schedule has been updated");

    }



}
