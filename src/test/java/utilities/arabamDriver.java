package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class arabamDriver {
    private static AndroidDriver<AndroidElement> driver;

    // Mevcut driver yapılandırması
    public static AndroidDriver<AndroidElement> getDriver() throws MalformedURLException {
        if (driver == null) {
            System.out.println("Driver başlatılıyor...");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            capabilities.setCapability("appPackage", "com.dogan.arabam");
            capabilities.setCapability("appActivity", "com.dogan.arabam.presentation.feature.home.HomeActivity");
            capabilities.setCapability(MobileCapabilityType.NO_RESET, false);

            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            System.out.println("Driver başlatıldı.");
        }
        return driver;
    }

    // Driver'ı kapatmak için fonksiyon
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
