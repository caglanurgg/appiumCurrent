package tests.day5_6;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPage.KiwiPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class KiwiAppTest {

    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
    // bu satirla esitligin sagini sola atadim
    // Driver icerisindeki 24-63 satir araligini calistirmis oldum

    KiwiPage kiwipage = new KiwiPage();

    @Test
    public void kiwiAppTest() throws InterruptedException {

        // 1- Uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled(ConfigReader.getProperty("kiwiKimlik")));

        // 2- Uygulamanin basariyla acildigi dogrulanir ve misafir butonunun gorunurdur ve tiklanilir
        kiwipage.getMisafirButonu().click();

        // 3- ardindan gelecek olan 3 adimda yesil butona basilarak devam edilir
        Thread.sleep(2000);
        TouchAction action = new TouchAction<>(driver);
        for (int i = 0; i < 3; i++) {
        ReusableMethods.koordinatTiklamaMethodu(515,1688,1000);
         }

        // 4-  Trip type,one way olarak secilir
        Thread.sleep(2000);
        ReusableMethods.koordinatTiklamaMethodu(296,621,1000);
        ReusableMethods.koordinatTiklamaMethodu(205,1454,1000);


        // 5- kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        ReusableMethods.koordinatTiklamaMethodu(511,760,1000);
        ReusableMethods.koordinatTiklamaMethodu(1012,135,1000);

        // 6- kalkis yapilacak ulke/sehir girilir ve sec'e tiklanir
        if (driver.isKeyboardShown()) {
        driver.getKeyboard().pressKey("Ivalo");
        } else {
        kiwipage.departurePoint.sendKeys("Ivalo");
        }
        Thread.sleep(1000);

        ReusableMethods.koordinatTiklamaMethodu(303,267,2000);
        kiwipage.getChooseButoon().click();

        // 7- varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        ReusableMethods.koordinatTiklamaMethodu(311,921,1000);
        driver.getKeyboard().pressKey("Istanbul");
        Thread.sleep(1000);

        ReusableMethods.koordinatTiklamaMethodu(274,278,1000);
        kiwipage.getChooseButoon().click();

        // 8- gidis tarihi subat ayinin 22 si olarak secilir ve set date e tiklanir
        ReusableMethods.koordinatTiklamaMethodu(409,1052,1000);
        ReusableMethods.koordinatTiklamaMethodu(964,1154,1000);
        kiwipage.setDateButton.click();

        // 9- search butonuna tiklanir
        kiwipage.searchButton.click();

        // 10- cheapest ve up to 1 stop filtrelemeleri yapilir
        ReusableMethods.koordinatTiklamaMethodu(278,259,2000);
        ReusableMethods.koordinatTiklamaMethodu(292,555,1000);

        ReusableMethods.koordinatTiklamaMethodu(515,248,1000);
        ReusableMethods.koordinatTiklamaMethodu(237,1578,2000);

        // 11- gelen bilet fiyati kaydedilir ve kullanicinin telefonuna sms olarak gonderilir
        String cheapestTicketText = kiwipage.cheapestTicket.getText();
        driver.sendSMS("555555555555","Kiwi uygulamasindaki en ucuz bilet fiyati :" + cheapestTicketText);
}
}
