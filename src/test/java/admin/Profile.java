package admin;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.TestBase;
import utils.TestUtils;

public class Profile extends TestBase {
    @Test
    public void editProfile() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//android.widget.CheckedTextView[@text='Settings']")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='My Profile']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/fab_edit_profile")).click();
        Thread.sleep(1000);
        String FirstName=getDriver().findElement(By.id("com.seamfix.autotopup:id/firstname_update_input")).getText();
        Thread.sleep(1000);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/firstname_update_input")).clear();
        Thread.sleep(100);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/firstname_update_input")).sendKeys(FirstName);


        String secondName=getDriver().findElement(By.id("com.seamfix.autotopup:id/lastname_update_input")).getText();
        Thread.sleep(1000);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/lastname_update_input")).clear();
        Thread.sleep(100);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/lastname_update_input")).sendKeys(secondName);


        //select network
        getDriver().findElement(By.id("com.seamfix.autotopup:id/network_carrier_spinner")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='MTN-NG']")).click();


        //select gender
        getDriver().findElement(By.id("com.seamfix.autotopup:id/gender_spinner")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='OTHER']")).click();

        // submit
        getDriver().findElement(By.id("com.seamfix.autotopup:id/update_profile_button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/fab_edit_profile")));
        Thread.sleep(1000);
        TestUtils.assertSearchText("XPATH", "//android.widget.Toast[1]", "Your profile was updated successfully");

    }

    @Test
    public void UploadImage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);

        getDriver().findElement(By.id("com.seamfix.autotopup:id/change_profile_image_button")).click();
        Thread.sleep(3000);
        //profile image
        getDriver().findElement(By.xpath("//android.widget.ImageView[@bounds='[28,172][352,496]']")).click();

        /*String profilePicture = System.getProperty("user.dir") + "/files/profile-picture.png";
        getDriver().findElement(By.id("profilePicture")).sendKeys(profilePicture);
        */
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/fab_edit_profile")));
        Thread.sleep(1000);

        TestUtils.assertSearchText("XPATH", "//android.widget.Toast[1]", "Your Profile photo was changed successfully");
        Thread.sleep(1000);
    }


    @Test
    @Parameters({"pwd"})
    public void ChangeWrongPassword(String pwd) throws InterruptedException {
        //edit password
        Thread.sleep(2000);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/field_action_button")).click();
         Thread.sleep(1500);
        //Current Password
        getDriver().findElement(By.id("com.seamfix.autotopup:id/current_password_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/current_password_input")).sendKeys("WrongPassword");

        //New Password
        getDriver().findElement(By.id("com.seamfix.autotopup:id/new_password_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/new_password_input")).sendKeys(pwd);

        getDriver().findElement(By.id("com.seamfix.autotopup:id/change_password_button")).click();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);

        TestUtils.assertSearchText("ID", "com.seamfix.autotopup:id/field_info_text", "Incorrect current password entered, please check again");
        Thread.sleep(1000);

    }

    @Test
    @Parameters({"pwd"})
    public void ChangeToTheSamePassword(String pwd) throws InterruptedException {

        //Current Password
        getDriver().findElement(By.id("com.seamfix.autotopup:id/current_password_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/current_password_input")).sendKeys(pwd);

        //New Password
        getDriver().findElement(By.id("com.seamfix.autotopup:id/new_password_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/new_password_input")).sendKeys(pwd);

        getDriver().findElement(By.id("com.seamfix.autotopup:id/change_password_button")).click();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);


        TestUtils.assertSearchText("ID", "com.seamfix.autotopup:id/field_info_text", "You can't reuse your current password.");
        Thread.sleep(1000);

    }

    @Test
    @Parameters({"pwd"})
    public void ChangePassword(String pwd) throws InterruptedException {
        WebDriverWait wait =new WebDriverWait(getDriver(), 30);
        Thread.sleep(2000);
        //Current Password
        getDriver().findElement(By.id("com.seamfix.autotopup:id/current_password_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/current_password_input")).sendKeys(pwd);

        //New Password
        getDriver().findElement(By.id("com.seamfix.autotopup:id/new_password_input")).clear();
        String addPass="add";
        getDriver().findElement(By.id("com.seamfix.autotopup:id/new_password_input")).sendKeys(pwd+addPass);

        getDriver().findElement(By.id("com.seamfix.autotopup:id/change_password_button")).click();

        Thread.sleep(1200);
        TestUtils.assertSearchText("XPATH", "//android.widget.Toast[1]", "Your password was changed successfully");
        Thread.sleep(1000);

        //edit password
        getDriver().findElement(By.id("com.seamfix.autotopup:id/field_action_button")).click();
        Thread.sleep(2000);

        //Current Password
        getDriver().findElement(By.id("com.seamfix.autotopup:id/current_password_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/current_password_input")).sendKeys(pwd+addPass);
        Thread.sleep(100);
        //New Password
        getDriver().findElement(By.id("com.seamfix.autotopup:id/new_password_input")).clear();

        getDriver().findElement(By.id("com.seamfix.autotopup:id/new_password_input")).sendKeys(pwd);

        getDriver().findElement(By.id("com.seamfix.autotopup:id/change_password_button")).click();

        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/fab_edit_profile")));
        TestUtils.assertSearchText("XPATH", "//android.widget.Toast[1]", "Your password was changed successfully");
    }


}
