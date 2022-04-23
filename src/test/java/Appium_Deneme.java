import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium_Deneme {

    @Test
    public void test() throws MalformedURLException {
        //Open Appium
        //Open Android Studio and click on the More action and Virtual Device manager
        //Run the imaginal device
        //To be sure the connection between Android device and Appium, open cmd on the start and type "adb devices" and click enter
        //You should get
        // List of devices attached
        //emulator-5554   device
        //Test senaryolarini gelistirmek icin sanal cihazda ayarlar bölümünde devoloping kismini ve usb debugging kismini aktif yapmak gerek
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");//With Which platform do you want to work
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");//With Which platform do you want to work
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");//With Which version do you want to work
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Acer\\AppiumKurulum\\Apps\\apiDemos.apk");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        desiredCapabilities.setCapability("appPackage", "com.davemac327.gesture.tool.CreateGestureActivity");
        desiredCapabilities.setCapability("appActivity", "com.davemac327.gesture.tool.CreateGestureActivity");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        /* Sonra Appiumdan Inspect bölümünü ac ve sag alttaki Json representation bölümüne bunu yapisitir
        {
          "platformName": "Android",
          "automationName": "UiAutomator2",
          "deviceName": "AndroidEmulator",
          "platformVersion": "10.0",
          "app": "C:\\Users\\Acer\\AppiumKurulum\\Apps\\gestureTool.apk"
        }
                 */


    }
}
