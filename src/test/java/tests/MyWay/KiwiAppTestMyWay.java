package tests.MyWay;

import io.appium.java_client.TouchAction;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.KiwiPage.KiwiPageMyWay;
import utilities.ConfigReader;
import utilities.MyWayDriver;
import pages.KiwiPage.KiwiPage;
import utilities.ReusableMethods;

import java.net.MalformedURLException;

import static utilities.MyWayDriver.driver;

public class KiwiAppTestMyWay {

    private KiwiPageMyWay kiwiPageMyWay;

    @BeforeTest
    public void setup() throws MalformedURLException {
        // KiwiApp için gerekli appPackage ve appActivity değerleri
        String appPackage = "com.skypicker.main";
        String appActivity = "com.kiwi.android.feature.splash.impl.ui.SplashActivity";

        // Driver başlatılıyor
        MyWayDriver.getAndroidDriver(appPackage, appActivity);
        kiwiPageMyWay = new KiwiPageMyWay();
    }

    @Test
    public void kiwiTest() throws InterruptedException {
        // 1- Uygulamanın yüklendiği doğrulanır
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"));

        // 2- Uygulamanın başarıyla açıldığı doğrulanır
        Thread.sleep(2000);
        Assert.assertTrue(kiwiPageMyWay.continueAsAGuest.isDisplayed());

        // 3- Misafir olarak devam et'e tıklanır
        kiwiPageMyWay.continueAsAGuest.click();

        // 4- Açılışta çıkan adımları geçmek için 3 kez tıklama yapılır
        for (int i = 0; i < 3; i++) {
            ReusableMethods.koordinatTiklamaMethodu(515, 1688, 1000);
        }

        // 5- Trip type "One Way" olarak seçilir
        Thread.sleep(2000);
        ReusableMethods.koordinatTiklamaMethodu(296, 621, 1000);
        ReusableMethods.koordinatTiklamaMethodu(205, 1454, 1000);

        // 6- Kalkış ülkesi seçeneğine tıklanır ve varsayılan ülke kaldırılır
        ReusableMethods.koordinatTiklamaMethodu(511, 760, 1000);
        ReusableMethods.koordinatTiklamaMethodu(1012, 135, 1000);

        // 7- Kalkış yapılacak ülke/sehir girilir ve "Choose" butonuna tıklanır
        kiwiPageMyWay.departure.sendKeys("Ivalo");
        ReusableMethods.koordinatTiklamaMethodu(354, 289, 1000);
        kiwiPageMyWay.choose.click();

        // 8- varis ulkesi secenegine tiklanir ve gidilecek ulke girilir



        // 9- gidis tarihi eylul ayinin 21 i olarak secilir ve set date e tiklanir

        // 10- search butonuna tiklanir

        // 11- en ucuz ve aktarmasiz filtrelemeleri yapilir

        // 12- gelen bilet fiyati kaydedilir ve kullanicinin telefonuna sms olarak gonderilir
    }

    @AfterTest
    public void tearDown() {
        MyWayDriver.closeDriver();
    }
}
