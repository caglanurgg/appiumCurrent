package tests.day5_6;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllCurrencyPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class allCurrencyConverterTest {

    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
    // bu satirla esitligin sagini sola atadim
    // Driver icerisindeki 24-63 satir araligini calistirmis oldum

    AllCurrencyPage currencyPage = new AllCurrencyPage();

    @Test
    public void testAllCurrencyApp() throws InterruptedException, IOException {

        // 1- all  currency uygulamasinin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.smartwho.SmartAllCurrencyConverter"));

        // 2- uygulamanin acildigi dogrulanir
        Assert.assertTrue(currencyPage.toolBar.isDisplayed());

        // 3- cevirmek istedigimiz para birimi won olarak secilir
        ReusableMethods.koordinatTiklamaMethodu(416,336,1000);
        ReusableMethods.scrollWithUiScrollableAndClick("KRW");

        // 4- cevrilecek olan para birimi TL olarak secilir
        ReusableMethods.koordinatTiklamaMethodu(384,508,1000);
        ReusableMethods.scrollWithUiScrollableAndClick("TRY");

        // 5- cevrilen tutar screenShot olarak kaydedilir
        ReusableMethods.scrollWithUiScrollable("1");
        currencyPage.ciftsifir.click();
        Thread.sleep(1000);

        ReusableMethods.getScreenshot("SonucEkranGoruntusu");

        // 2.YONTEM
        // File screenshot=driver.getScreenshotAs(OutputType.FILE);
        // FileUtils.copyFile(screenshot,new File("krwToTRY.jpg"));

        // 6- Ardindan won un tl karsiligi olan tl degeri kaydedilir
        String sonucAlani=currencyPage.sonucAlani.getText();

        // 7- kullaniciya sms olarak bildirilir
        driver.sendSMS("555555555555","100 KRW UN TRY DEGERI :" + sonucAlani);
    }
}
