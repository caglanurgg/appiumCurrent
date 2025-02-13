package pages.ArabamPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class VehicleSearchPage {
    private AndroidDriver<AndroidElement> driver;

    // Sayfa elemanlarını tanımlıyoruz
    private By otomobilCategory = By.xpath("//*[@text='Otomobil']");
    private By volvoVehicle = By.xpath("//*[@text='Volvo']");
    private By v90CrossCountry = By.xpath("//*[@text='V90 Cross Country']");
    private By priceFilter = By.xpath("//*[@text='Fiyat - Ucuzdan Pahalıya']");

    // Constructor
    public VehicleSearchPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    // Sayfa işlemleri
    public void selectCarCategory() {
        driver.findElement(otomobilCategory).click();
    }

    public void selectVolvoCar() {
        driver.findElement(volvoVehicle).click();
    }

    public void selectV90CrossCountry() {
        driver.findElement(v90CrossCountry).click();
    }

    public void sortByPrice() {
        driver.findElement(priceFilter).click();
    }
}
