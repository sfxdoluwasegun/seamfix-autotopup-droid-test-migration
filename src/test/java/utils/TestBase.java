package utils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase {


    public static ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();
    public static ExtentReports reports;
    public static ExtentHtmlReporter htmlReporter;
    private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
    public static ThreadLocal<ExtentTest> testInfo = new ThreadLocal<ExtentTest>();
    public static String URLbase = "AutotopUp.ng";
    public static String toAddress;


    public static AndroidDriver getDriver() {
        return driver.get();
    }

    String devices;
    static String[] udid;

    @Parameters("groupReport")
    @BeforeSuite
    public void setUp(String groupReport) {

        {
            try {
                devices = TestUtils.executeAdbCommand("adb devices");
                devices = devices.replaceAll("List of devices attached", " ");
                devices = devices.replaceAll("device", " ").trim();
                udid = devices.split(" ");
            } catch (IOException e) {
                System.out.println("No devices found: " + e.toString());

            }
        }

        htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + groupReport));
        htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir") + "/resources/extent-config.xml"));
        reports = new ExtentReports();
        reports.setSystemInfo("POC", URLbase);
        reports.attachReporter(htmlReporter);
    }

    @BeforeMethod(description = "fetch test cases name")
    public void register(Method method) {

        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ExtentTest child = parentTest.get().createNode(method.getName());
        testInfo.set(child);
        testInfo.get().assignCategory("Sanity");
    }

    @AfterMethod(description = "to display the result after each test method")
    public void captureStatus(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = TestUtils.addScreenshot();
            testInfo.get().addScreenCaptureFromPath(screenshotPath);
            testInfo.get().fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP)
            testInfo.get().skip(result.getThrowable());
        else
            testInfo.get().pass(result.getName() + " Test passed");

        reports.flush();
    }

    @AfterSuite
    @Parameters("toMails")
    public void cleanup(String toMails) {
        toAddress = toMails;
        SendMail.ComposeGmail("Auto Top Up Automated Test Report <seamfix.test.report@gmail.com>", toAddress);

        getDriver().quit();
    }

    @AfterClass
    public void closeApp() {
        getDriver().quit();
    }

    @BeforeClass
    @Parameters({"systemPort", "deviceNo"})
    public void startApp(String systemPort, int deviceNo) throws IOException {
        deviceNo = deviceNo - 1;
        while (deviceNo >= udid.length) {
            deviceNo = deviceNo - 1;
        }
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("autoGrantPermissions", true);
            capabilities.setCapability("unicodeKeyboard", true);
            capabilities.setCapability("resetKeyboard", true);
            capabilities.setCapability("noReset", false);
            capabilities.setCapability("browserName", "Android");
            capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, systemPort);
            capabilities.setCapability(MobileCapabilityType.UDID, udid[deviceNo].trim());
            capabilities.setCapability("deviceName", "SeamfixTab");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("appPackage", "com.seamfix.autotopup");
            capabilities.setCapability("appActivity", "com.seamfix.autotopup.activities.LaunchActivity");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

            driver.set(new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities));
            System.out.println("++++++++++UIAUTOMATOR 2 DRIVER INSTANCE RUNNING++++++++++++");

        } catch (WebDriverException e) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.UDID, udid[deviceNo].trim());
            capabilities.setCapability("autoGrantPermissions", true);
            capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, systemPort);
            capabilities.setCapability("unicodeKeyboard", true);
            capabilities.setCapability("resetKeyboard", true);
            capabilities.setCapability("noReset", false);
            capabilities.setCapability("browserName", "Android");
            capabilities.setCapability("deviceName", "SeamfixTab");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("appPackage", "com.seamfix.autotopup");
            capabilities.setCapability("appActivity", "com.seamfix.autotopup.activities.LaunchActivity");

            driver.set(new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities));
            System.out.println("++++++++++UIAUTOMATOR DRIVER INSTANCE RUNNING++++++++++++");

        }

        ExtentTest parent = reports.createTest(getClass().getName());
        parentTest.set(parent);
    }

    @Test
    @Parameters("email")
    public static void login(String email) throws InterruptedException {
        Thread.sleep(500);
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/app_title")));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/login_button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/toolbar")));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/email_address_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/email_address_input")).sendKeys(email);
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
