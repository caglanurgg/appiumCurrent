package pages.ArabamPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class HomePage {
    public AndroidDriver<AndroidElement> driver;

    // Constructor
    public HomePage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    // "İlan Ver" butonunu bulan fonksiyon
    public AndroidElement ilanVerButton() {
        return driver.findElementByAccessibilityId("İlan Ver");
       // return driver.findElement(By.accessibilityId("İlan Ver"));
    }

    // "İlan Ver" butonuna tıklama fonksiyonu
    public void clickIlanVerButton() {
        ilanVerButton().click();
    }

    // "İlan Ara" butonunu bulan fonksiyon
    public AndroidElement vehicleSearchButton() {
        return driver.findElement(By.id("com.dogan.arabam:id/action_vehicle_search"));
    }

    // "İlan Ara" butonuna tıklama fonksiyonu
    public void clickVehicleSearchButton() {
        vehicleSearchButton().click();
    }
}
