import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.List;

public class AndroidApp {

    String userName = System.getenv("LT_USERNAME") == null ?
            "shantanuw" : System.getenv("LT_USERNAME"); //Add username here
    String accessKey = System.getenv("LT_ACCESS_KEY") == null ?
            "AddAccessKeyHere" : System.getenv("LT_ACCESS_KEY"); //Add accessKey here

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    AppiumDriver driver;

    @Test
    @org.testng.annotations.Parameters(value = {"device", "version", "platform"})
    public void AndroidApp1(String device, String version, String platform) {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("build","Java TestNG Android - Pre-installed app");
            capabilities.setCapability("name",platform+" "+device+" "+version);
            capabilities.setCapability("deviceName", device);
            capabilities.setCapability("platformVersion",version);
            capabilities.setCapability("platformName", platform);
            capabilities.setCapability("isRealMobile", true);
            capabilities.setCapability("app", "Stock"); //Enter your app url
            capabilities.setCapability("appPackage", "com.google.android.youtube");
            capabilities.setCapability("appActivity", "com.google.android.youtube.HomeActivity");
            capabilities.setCapability("deviceOrientation", "PORTRAIT");
            capabilities.setCapability("visual", true);

            String hub = "https://" + userName + ":" + accessKey + gridURL;
            driver = new AppiumDriver(new URL(hub), capabilities);

            Thread.sleep(5000);
            MobileElement accountIcon = (MobileElement) driver.findElementByAccessibilityId("Account");
            accountIcon.click();
            Thread.sleep(2000);

            MobileElement signInButton = (MobileElement) driver.findElementById("com.google.android.youtube:id/button");
            signInButton.click();
            Thread.sleep(2000);

            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            try{
                driver.quit();
            }catch(Exception e1){
                e.printStackTrace();
            }
        }


    }
}
