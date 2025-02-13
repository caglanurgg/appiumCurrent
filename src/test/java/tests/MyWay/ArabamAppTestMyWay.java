package tests.MyWay;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.MyWayDriver;
import pages.ArabamPage.HomePage;

import java.net.MalformedURLException;

public class ArabamAppTestMyWay {
    private HomePage homePage;

    @BeforeTest
    public void setup() throws MalformedURLException {
        // ArabamApp için gerekli appPackage ve appActivity değerleri
        String appPackage = "com.dogan.arabam";
        String appActivity = "com.dogan.arabam.presentation.feature.home.HomeActivity";

        // Driver'ı başlatıyoruz
        homePage = new HomePage(MyWayDriver.getAndroidDriver(appPackage, appActivity));
    }

    @Test
    public void arabamTest() throws InterruptedException, MalformedURLException {
        // 1- Uygulamanın başarılı bir şekilde yüklendiği doğrulanır
        Assert.assertTrue(MyWayDriver.getAndroidDriver(null, null).isAppInstalled("com.dogan.arabam"));

        // 2- Uygulamanın başarılı bir şekilde açıldığı doğrulanır
        Assert.assertTrue(homePage.ilanVerButton().isDisplayed());

        // 3- Alt menüden ilan ara butonuna tıklanır
        homePage.clickVehicleSearchButton();

        // 4- Kategori olarak otomobil seçilir
        homePage.driver.findElementByXPath("//*[@text='Otomobil']").click();

        // 5- Araç olarak Volvo seçilir
        homePage.driver.findElementByXPath("//*[@text='Volvo']").click();

        // 6- Araç modeli seçilir
        homePage.driver.findElementByXPath("//*[@text='V90 Cross Country']").click();

        // 7- Model seçilir
        homePage.driver.findElementByXPath("//*[@text='2.0 B5']").click();

        // 8- Paket seçimi yapılır
        homePage.driver.findElementByXPath("//*[@text='Plus Bright']").click();

        // 9- Sıralama yapılır
        homePage.driver.findElementByXPath("//*[@text='Sıralama']").click();
        homePage.driver.findElementByXPath("//*[@text='Fiyat - Ucuzdan Pahalıya']").click();

        // 10- En ucuz aracın fiyatı doğrulanır
        String enUcuzAracFiyati = homePage.driver.findElementByXPath("//*[@resource-id='com.dogan.arabam:id/tvPrice']").getText();
        System.out.println(enUcuzAracFiyati);

        enUcuzAracFiyati = enUcuzAracFiyati.replaceAll("\\D", "");
        Assert.assertTrue(Integer.parseInt(enUcuzAracFiyati) > 50000);
    }

    @AfterTest
    public void tearDown() {
        // Test bitiminde driver'ı kapatıyoruz
        MyWayDriver.closeDriver();
    }
}
