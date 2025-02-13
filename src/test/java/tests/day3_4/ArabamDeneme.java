package tests.day3_4;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ArabamPage.HomePage;
import pages.ArabamPage.VehicleSearchPage;
import utilities.arabamDriver;

import java.net.MalformedURLException;
import java.time.Duration;

public class ArabamDeneme {

    private HomePage homePage;

    @BeforeTest
    public void setup() throws MalformedURLException {
        // Driver'ı başlatıyoruz
        homePage = new HomePage(arabamDriver.getDriver());
    }

    @Test
    public void arabamTest() throws MalformedURLException, InterruptedException {
        // 1- Uygulamanın başarılı bir şekilde yüklendiği doğrulanır
        Assert.assertTrue(arabamDriver.getDriver().isAppInstalled("com.dogan.arabam"));

        // 2- Uygulamanın başarılı bir şekilde açıldığı doğrulanır
        Assert.assertTrue(homePage.ilanVerButton().isDisplayed());

        // 3- Alt menüden ilan ara butonuna tıklanır
        homePage.clickVehicleSearchButton();

        // 4- Kategori olarak otomobil seçilir
        homePage.driver.findElementByXPath("//*[@text='Otomobil']").click();

        // 5- Araç olarak Volvo seçilir
        TouchAction action = new TouchAction<>(homePage.driver);
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

        homePage.driver.findElementByXPath("//*[@text='Volvo']").click();
        Thread.sleep(2000);

        // 6- arac markasi olarak V90 Cross Country secilir
        TouchAction action2 = new TouchAction<>(homePage.driver);
        Thread.sleep(2000);
        action
                .press(PointOption.point(541,1556))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(541,826))
                .release()
                .perform();

        homePage.driver.findElementByXPath("//*[@text='V90 Cross Country']").click();
        Thread.sleep(2000);

        // 7- 2.0 B5 secilir
        homePage.driver.findElementByXPath("//*[@text='2.0 B5']").click();
        Thread.sleep(2000);

        // 8- Paket seçimi yapılır
        homePage.driver.findElementByXPath("//*[@text='Plus Bright']").click();
        Thread.sleep(1000);

        // 9- Sıralama yapılır
        homePage.driver.findElementByXPath("//*[@text='Sıralama']").click();
        Thread.sleep(1000);
        homePage.driver.findElementByXPath("//*[@text='Fiyat - Ucuzdan Pahalıya']").click();
        Thread.sleep(2000);

        // 10- En ucuz aracın fiyatı doğrulanır
        String enUcuzAracFiyati = homePage.driver.findElementByXPath("//*[@resource-id='com.dogan.arabam:id/tvPrice']").getText();
        System.out.println(enUcuzAracFiyati); // Örn: 3.775.000 TL

        enUcuzAracFiyati = enUcuzAracFiyati.replaceAll("\\D", "");
        Assert.assertTrue(Integer.parseInt(enUcuzAracFiyati) > 50000); //3775000
    }

    @AfterTest
    public void tearDown() {
        // Test bitiminde driver'ı kapatıyoruz
        arabamDriver.closeDriver();
    }
}
