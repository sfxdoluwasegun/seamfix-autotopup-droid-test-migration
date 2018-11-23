package admin;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.TestBase;
import utils.TestUtils;

public class PaymentOptions extends TestBase {

    @Test
    public void AddMasterCard() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//android.widget.CheckedTextView[@text='My Payment Options']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/cards_page_button")));

        getDriver().findElement(By.id("com.seamfix.autotopup:id/cards_page_button")).click();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/fab_add_card")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Master Card']")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/payBtn")).click();
        Thread.sleep(3000);
        TestUtils.acceptAlert();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/proceed_button")));
        Thread.sleep(1000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Your Card was successfully added']")));
        TestUtils.assertSearchText("XPATH", "//android.widget.TextView[@text='Your Card was successfully added']", "Your Card was successfully added");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();

    }

    @Test
    public void AddVisaCard() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 45);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/fab_add_card")));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/fab_add_card")).click();
        Thread.sleep(600);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Visa Card']")).click();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/payBtn")).click();
        Thread.sleep(2000);
        TestUtils.acceptAlert();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/proceed_button")));
        Thread.sleep(1000);
        TestUtils.assertSearchText("XPATH", "//android.widget.TextView[@text='Your Card was successfully added']", "Your Card was successfully added");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        Thread.sleep(1000);

    }

    @Test
    public void CardStatus() throws InterruptedException {

        String Cardstatus=getDriver().findElement(By.id("com.seamfix.autotopup:id/card_status")).getText();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/switchCompat_card")).click();

        Thread.sleep(2000);
        TestUtils.acceptAlert();

        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/fab_add_card")));
        if (Cardstatus=="Active"){
            TestUtils.assertSearchText("ID", "com.seamfix.autotopup:id/card_status", "Active");
        }else{
            TestUtils.assertSearchText("ID", "com.seamfix.autotopup:id/card_status", "Inactive");
        }
    }
    @Test
    public void WalletStatus() throws InterruptedException {

        getDriver().findElement(By.id("com.seamfix.autotopup:id/wallet_page_button")).click();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/switchCompat_wallet")).click();

        Thread.sleep(2000);
        TestUtils.acceptAlert();

        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/fab_topup_wallet")));

        testInfo.get().log(Status.INFO, "Wallet activated" + "");
    }

    @Test
    public void WalletThroughBank() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/wallet_page_button")).click();
        //WalletStatus();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/fund_wallet_button")).click();
        Thread.sleep(1000);
        TestUtils.assertSearchText("ID", "com.seamfix.autotopup:id/fund_wallet_instructions_view", "You can fund your Wallet by making a cash deposit or a bank transfer to any of the Bank Account(s) below:\n" +
                "\n" +
                "Account Name: Seamfix Nig Ltd\n" +
                "Account Number: 2020200322\n" +
                "Bank: United Bank For Africa Plc\n" +
                "\n" +
                "\n" +
                "On successful payment, kindly submit details of the transaction by clicking the Proceed button below to provide the needed information and your Wallet will be credited within an hour of payment confirmation.");

        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        Thread.sleep(1500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/payer_name_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/payer_name_input")).sendKeys("Osepadeolu Sunday");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/amount_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/amount_input")).sendKeys("50");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/transaction_date_picker")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("android:id/next")).click();
        Thread.sleep(1500);
        getDriver().findElement(By.xpath("//android.view.View[@text='29']")).click();
        getDriver().findElement(By.id("android:id/button1")).click();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/bank_reference_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/bank_reference_input")).sendKeys("123456");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/submit_button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/proceed_button")));
        TestUtils.assertSearchText("ID", "com.seamfix.autotopup:id/success_label_view", "Your request has been successfully submitted, your wallet will be credited as soon as the payment is confirmed");
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='PROCEED']")).click();

    }

   /* public void WalletStatus() throws InterruptedException {
        String Cardstatus=getDriver().findElement(By.id("com.seamfix.autotopup:id/card_status")).getText();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/switchCompat_wallet")).click();
        Thread.sleep(1000);
        TestUtils.acceptAlert();
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fab_add_card")));
        if (Cardstatus=="Active"){
            TestUtils.assertSearchText("ID", "com.seamfix.autotopup:id/card_status", "Active");
        }else{
            TestUtils.assertSearchText("ID", "com.seamfix.autotopup:id/card_status", "Inactive");
        }
    }
*/
    @Test
    public void WalletThroughMasterCard() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//android.widget.CheckedTextView[@text='My Payment Options']")).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/wallet_page_button")));
        getDriver().findElement(By.id("com.seamfix.autotopup:id/wallet_page_button")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/fab_topup_wallet")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Master Card']")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_wallet_amount_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_wallet_amount_input")).sendKeys("1000");
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/payBtn")).click();
        Thread.sleep(3000);
        TestUtils.acceptAlert();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/proceed_button")));
        Thread.sleep(1000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Your Wallet was successfully topped up']")));
        TestUtils.assertSearchText("XPATH", "//android.widget.TextView[@text='Your Wallet was successfully topped up']", "Your Wallet was successfully topped up");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();


    }

    @Test
    public void WalletThroughVisaCard() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/fab_topup_wallet")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Visa Card']")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_wallet_amount_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_wallet_amount_input")).sendKeys("1000");
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/payBtn")).click();
        Thread.sleep(2000);
        TestUtils.acceptAlert();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/proceed_button")));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Your Wallet was successfully topped up']")));
        TestUtils.assertSearchText("XPATH", "//android.widget.TextView[@text='Your Wallet was successfully topped up']", "Your Wallet was successfully topped up");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();

    }

    @Test
    public void WalletThroughVerveCard() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/fab_topup_wallet")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Verve Card']")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_wallet_amount_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/topup_wallet_amount_input")).sendKeys("1000");
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/payBtn")).click();
        Thread.sleep(3500);
        TestUtils.acceptAlert();
        Thread.sleep(400);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='1']")).click();
        Thread.sleep(300);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='2']")).click();
        Thread.sleep(300);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='3']")).click();
        Thread.sleep(300);
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='4']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.seamfix.autotopup:id/proceed_button")));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Your Wallet was successfully topped up']")));
        TestUtils.assertSearchText("XPATH", "//android.widget.TextView[@text='Your Wallet was successfully topped up']", "Your Wallet was successfully topped up");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();

    }


    @Test
    public void WalletThroughBankCard() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/fab_topup_wallet")).click();
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Pay with Bank']")).click();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/bank_list_spinner")).click();
        getDriver().findElement(By.xpath("//android.widget.TextView[@text='Zenith Bank']")).click();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/account_number_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/account_number_input")).sendKeys(TestUtils.generateSerialNumber()+"12");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/amount_input")).clear();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/amount_input")).sendKeys("1000");
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();
        Thread.sleep(3500);
        TestUtils.acceptAlert();
        Thread.sleep(500);
        getDriver().findElement(By.id("com.seamfix.autotopup:id/birthday_picker")).click();
        getDriver().findElement(By.id("android:id/button1")).click();
        getDriver().findElement(By.id("com.seamfix.autotopup:id/proceed_button")).click();

    }

}
