package pages.KiwiPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.MyWayDriver;

public class KiwiPageMyWay {
    // Constructor
    public KiwiPageMyWay() {
        PageFactory.initElements(MyWayDriver.driver, this);
    }

    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public AndroidElement continueAsAGuest;

    @FindBy(xpath = "//*[@class='android.widget.EditText']")
    public AndroidElement departure;

    @FindBy(xpath = "//*[@text='Choose']")
    public AndroidElement choose;


}
