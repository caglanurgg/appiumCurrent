package tests.day2;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class HesapMakinesiTest {

    AndroidDriver<AndroidElement> driver;

    @Test
    public void hesapMakinesiTest() throws MalformedURLException {

        DesiredCapabilities capabilities= new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");


        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\Cagla\\IdeaProjects\\appiumCurrent\\Apps\\Calculator_8.4 (503542421)_Apkpure.apk");
        // app capabilities degeri bir uygulamayi yuklemek icin kullanilan degerdir.
        // bu capability eger ki uygulama yuklu degilse onu kontrol eder ve yukler
        // eger yuklu ise  uygulamanin yuklu olup olmadigini kontrol eder
        // ve yukluyse uygulamayi acar


      driver= new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // uygulamanin yuklendigini dogrular(isInstalled)
        Assert.assertTrue(driver.isAppInstalled("com.google.android.calculator"));

        // uygulamanin acildigini dogrular
        Assert.assertTrue(driver.findElementById("com.google.android.calculator:id/clr").isDisplayed());

        // 4000 un 7 katininin 28000 oldugunu hesap makinasindan dogrulayalim

        driver.findElementByAccessibilityId("4").click();

        for (int i = 0; i < 3; i++) {
            driver.findElementByAccessibilityId("0").click();
        }

        driver.findElementByAccessibilityId("multiply").click();

        driver.findElementByAccessibilityId("7").click();
        String islemSonucu =driver.findElementById("com.google.android.calculator:id/result_preview").getText();

        int istedigimSonuc=28000;

        Assert.assertEquals(Integer.parseInt(islemSonucu),istedigimSonuc);
    }
    }

