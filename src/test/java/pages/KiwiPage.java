package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KiwiPage {

    public KiwiPage(AndroidDriver<AndroidElement> androidDriver) {
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);
    }












}
