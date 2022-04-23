import com.github.javafaker.Faker;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Appium12 extends AppiumBase {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        AndroidDriver driver = androidDriver();

        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();

        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//*[@text='5. Preferences from code']").click();
        List<MobileElement> list = driver.findElementsByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").checked(false)");
        List<MobileElement> list1 = driver.findElementsByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").checked(true)");
        System.out.println(list.size());
        System.out.println(list1.size());
        String isChecked = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").checkable(true)").getAttribute("checked");
        System.out.println("isChecked 1: "+isChecked);
        if (isChecked.equals("false")) {
            driver.findElementById("android:id/checkbox").click();
            Thread.sleep(2000);
        }
        System.out.println("isChecked 2: "+isChecked);
        // Checkbox preference tıklı olduğunu onayla
        isChecked = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").checkable(true)").getAttribute("checked");
        Assert.assertTrue(isChecked.equals("true"));

        driver.findElementByXPath("//*[@text='Edit text preference']").click();
        Faker faker = new Faker();
        MobileElement animalName = (MobileElement) driver.findElementById("android:id/edit");
        animalName.clear();
        animalName.sendKeys(faker.cat().name());


        driver.findElementByXPath("//android.widget.Button[@text='TAMAM']").click();
    }
}
