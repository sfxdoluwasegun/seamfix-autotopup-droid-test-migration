package admin;

import com.aventstack.extentreports.Status;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestBase;
import org.testng.annotations.Test;

import static utils.TestBase.getDriver;

public class TransactionLog extends TestBase {
    @Test
    public void TransactionsTest() throws Exception {

        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//android.widget.CheckedTextView[@text='Transaction Logs']")).click();
        Thread.sleep(1000);
        AssertDetails();
    }

    public static void AssertDetails() throws Exception {

        //Passport Details
        String heading = getDriver().findElement(By.id("com.seamfix.autotopup:id/transaction_heading")).getText();
        String body = getDriver().findElement(By.xpath("//android.widget.TextView[@bounds='[18,242][702,334]']")).getText();

        String NA = "";

        String[] toList = {"Transaction heading:" + heading, "Transaction body:" + body};
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
