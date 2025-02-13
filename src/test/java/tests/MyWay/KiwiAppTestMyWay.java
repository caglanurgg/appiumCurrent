package tests.MyWay;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.MyWayDriver;
import pages.KiwiPage;

import java.net.MalformedURLException;

public class KiwiAppTestMyWay {

    private KiwiPage kiwiPage;

    @BeforeTest
    public void setup() throws MalformedURLException {
        // KiwiApp için gerekli appPackage ve appActivity değerleri
        String appPackage = "com.skypicker.main";
        String appActivity = "com.kiwi.android.feature.splash.impl.ui.SplashActivity";

        // Driver'ı başlatıyoruz
        kiwiPage = new KiwiPage(MyWayDriver.getAndroidDriver(appPackage, appActivity));
    }

    @Test
    public void kiwiTest() throws InterruptedException {
        // Test işlemleri yapılır
    }

    @AfterTest
    public void tearDown() {
        // Test bitiminde driver'ı kapatıyoruz
        MyWayDriver.closeDriver();
    }
}
