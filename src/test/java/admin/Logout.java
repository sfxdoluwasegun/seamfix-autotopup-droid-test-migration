package admin;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.TestBase;
import utils.TestUtils;

import static utils.TestBase.getDriver;
@Test
public class Logout extends TestBase {
      @Test
      public void logout() throws InterruptedException {

          WebDriverWait wait = new WebDriverWait(getDriver(), 30);

          Thread.sleep(1000);
          getDriver().findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']")).click();
          Thread.sleep(1000);
          TestUtils.scrollDown();
          getDriver().findElement(By.xpath("//android.widget.CheckedTextView[@text='Log Out']")).click();
          Thread.sleep(1000);
          TestUtils.assertSearchText("ID", "com.seamfix.autotopup:id/app_title", "AUTOTOPUP ");

    }
}
