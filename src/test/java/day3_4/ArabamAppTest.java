package day3_4;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ArabamAppTest {

    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        System.out.println("Setup başlıyor...");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        capabilities.setCapability("appPackage", "com.dogan.arabam");
          /*
        appPackage, calistiracak oldugunuz uygulamayi baslatabilmek icin kullandigimiz capability.
        Buraya uygulamanin kimlik bilgisini girerek uzerinde calisacak oldugunuz uygulamayi baslatabiliriz.
         */


        capabilities.setCapability("appActivity", "com.dogan.arabam.presentation.feature.home.HomeActivity");
         /*
        appActivity, uygulamanin hangi sayfasi uzerinde calisacaksak o activity'yi bulmamiz lazim
        apk info --> app details --> activities
         */


        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        // eger false kullanirsak uygulama calistiktan sonra yapilacak adimlari gerceklestirir uygulamayi islem bittikten sonra SIFIRLAR
        // eger true olursa uygulama calistiktan sonra yapilacak adimlari gercceklestirir uygulamayi islem bittikten sonra SIFIRLAMAZ

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("Setup tamamlandı.");
    }

    @Test
    public void arabamTest() throws InterruptedException {
        // 1- uygulamanin basarili bir sekilde yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));
        Thread.sleep(2500);

        // 2- uygulamanin basarili bir sekilde acildigi dogrulanir
        Assert.assertTrue(driver.findElementByAccessibilityId("İlan Ver").isDisplayed());
        Thread.sleep(2500);

        // 3- alt menuden ilan ara butonuna tiklanir
        driver.findElementById("com.dogan.arabam:id/action_vehicle_search").click();

        // 4- kategori olarak otomobil secilir
        driver.findElementByXPath("//*[@text='Otomobil']").click();

        // 5- arac olarak volvo secilir


        // 6- arac markasi olarak secilir
    }
}
