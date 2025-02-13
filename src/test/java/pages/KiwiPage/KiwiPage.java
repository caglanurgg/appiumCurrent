package pages.KiwiPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

public class KiwiPage {

    public KiwiPage() { PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this); }

    public WebElement getMisafirButonu() {
        WebDriverWait wait = new WebDriverWait(Driver.getAndroidDriver(), 10);
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Continue as a guest']")));
    }

    @FindBy (xpath = "//*[@class()='android.widget.EditText']")
    public WebElement departurePoint;

    @FindBy (xpath = "//*[@text()='Choose']")
    public WebElement chooseButoon;



}
