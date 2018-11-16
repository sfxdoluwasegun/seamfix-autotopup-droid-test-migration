package admin;

import com.aventstack.extentreports.Status;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.TestBase;

public class Bonuses extends TestBase {

    @Test
    public void Bonus() throws Exception {

        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//android.widget.CheckedTextView[@text='Bonuses']")).click();
        Thread.sleep(1000);
        AssertDetails();
    }

    @Test
    public void referralsBonus() throws Exception {
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='REFERRALS']")).click();
        AssertDetails();
    }

    public static void AssertDetails() throws Exception {
        Thread.sleep(1000);
        //Passport Details
        String heading = getDriver().findElement(By.id("com.seamfix.autotopup:id/transaction_subheading")).getText();

        String NA = "";

        String[] toList = {"Transaction balance:" + heading};
        for (String field : toList) {
            String name = "";
            String val = NA;
            try {
                String[] fields = field.split(":");
                name = fields[0];
                val = fields[1];
                Assert.assertNotEquals(val, NA);
                testInfo.get().log(Status.INFO, name + " : " + val);
            } catch (Error e) {
                testInfo.get().error(name + " : " + val);
            }
        }
    }

}
