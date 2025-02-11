import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class AppiumTest {
    public static void main(String[] args) {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0"); // Versiyon numarasını kontrol et
            capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Cagla\\IdeaProjects\\appiumCurrent\\Apps\\Calculator_8.4 (503542421)_Apkpure.apk");
            capabilities.setCapability("automationName", "UiAutomator2"); // "UiAutomator2" kullanılması önerilir.

            AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

            if (driver.getSessionId() != null) {
                System.out.println("Driver session is established.");
            } else {
                System.out.println("Driver session failed to establish.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


