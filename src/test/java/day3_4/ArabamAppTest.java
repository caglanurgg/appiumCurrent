package day3_4;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
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
        Thread.sleep(2000);

        // 2- uygulamanin basarili bir sekilde acildigi dogrulanir
        Assert.assertTrue(driver.findElementByAccessibilityId("İlan Ver").isDisplayed());
        Thread.sleep(1000);

        // 3- alt menuden ilan ara butonuna tiklanir
        driver.findElementById("com.dogan.arabam:id/action_vehicle_search").click();
        Thread.sleep(1000);

        // 4- kategori olarak otomobil secilir
        driver.findElementByXPath("//*[@text='Otomobil']").click();
        Thread.sleep(2000);

        // 5- arac olarak volvo secilir
        TouchAction action = new TouchAction<>(driver);
        Thread.sleep(2000);
        action
                .press(PointOption.point(537,1600)) // ekranda kaydirma islemini baslatmak icin belirledigimiz ilk baslangic noktasi
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
                // kaydirma islemi gerceklesirken baslangic noktası (press) ile son (moveTo) arasinda gecen zaman
                // eger bu sure arttirilirsa gidilen yol mesafe miktari kisalir yani daha az yol kat ederiz
                // eger bu sure azaltilirsa gidilen yol mesafe miktari artar yani daha fazla yol kat etmis oluruz.

                .moveTo(PointOption.point(537,200)) // ekranda kaydirma islemini bitirmek icin kaydirdigimiz son nokta
                .release() // parmagimizi ekrandan kaldirma ve kaydirma islemini sonlandirma
                .perform(); // verilen action gorevlerini yerine getirme

        driver.findElementByXPath("//*[@text='Volvo']").click();
        Thread.sleep(2000);

        // 6- arac markasi olarak V90 Cross Country secilir
        TouchAction action2 = new TouchAction<>(driver);
        Thread.sleep(2000);
        action
                .press(PointOption.point(541,1556))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(541,826))
                .release()
                .perform();

        driver.findElementByXPath("//*[@text='V90 Cross Country']").click();
        Thread.sleep(2000);

        // 7- 2.0 B5 secilir
        driver.findElementByXPath("//*[@text='2.0 B5']").click();
        Thread.sleep(2000);

        // 8- Paket secimi yapilir
        driver.findElementByXPath("//*[@text='Plus Bright']").click();
        Thread.sleep(1000);

        // 9- Ucuzdan pahaliya siralama yaparak filtreleme yapilir
        driver.findElementByXPath("//*[@text='Sıralama']").click();
        Thread.sleep(1000);

        driver.findElementByXPath("//*[@text='Fiyat - Ucuzdan Pahalıya']").click();
        Thread.sleep(2000);

        // 10- gelen en ucuz arabanin 500.000 tl'den buyuk oldugu dogrulanir
        String enUcuzAracFiyati = driver.findElementByXPath("//*[@resource-id='com.dogan.arabam:id/tvPrice']").getText();
        System.out.println(enUcuzAracFiyati); // Örn: 3.775.000 TL

        enUcuzAracFiyati= enUcuzAracFiyati.replaceAll("\\D","");
        System.out.println(enUcuzAracFiyati); //3775000

        Assert.assertTrue(Integer.parseInt(enUcuzAracFiyati ) > 50000);
    }
}
