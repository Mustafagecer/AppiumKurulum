import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium03 {
    @Test
    public void test() throws InterruptedException, MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Emulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\Acer\\AppiumKurulum\\Apps\\gestureTool.apk");
        //noReset
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);
//http://localhost:4723/wd/hub
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        Thread.sleep(4000);
        //id ile bulduk
        // driver.findElementById("com.davemac327.gesture.tool:id/addButton").click();
        // id bu sekildede yazabilirsiniz
        // driver.findElementById("addButton").click();
        //xpath index ile bulduk
        // driver.findElementByXPath("(//android.widget.Button)[2]").click();
        //xpath text
        driver.findElementByXPath("//android.widget.Button[@text='Test']").click();

  /*
        lunch GestureTool app
        click test button
        verify title "Test a gesture"
        close app
        /*
        lunch GestureTool app
        click test button
        verify title "Test a gesture"
        close app
         */
        Thread.sleep(3000);
    //   String expectedTitle2 = "Adana";
    //   String actualTitle2 = driver.findElementById("(//android.widget.Button)[3]").getText();
    //   Assert.assertEquals(actualTitle2,expectedTitle2);

        String expectedTitle = "Test a gesture";
        String actualTitle = driver.findElementById("android:id/title").getText();

        Assert.assertEquals(actualTitle,expectedTitle);

        driver.navigate().back();

        //session kapat
        driver.quit();


    }
}
