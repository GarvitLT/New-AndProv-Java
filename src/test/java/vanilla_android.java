import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class vanilla_android {
    public static String userName = System.getenv("LT_USERNAME") == null ? "LT_USERNAME"  //Add username here
            : System.getenv("LT_USERNAME");
    public static String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "LT_ACCESS_KEY" //Add accessKey here
            : System.getenv("LT_ACCESS_KEY");

    private static AppiumDriver driver;

    public static void main(String args[]) throws MalformedURLException, InterruptedException {

        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "Galaxy S20");
            capabilities.setCapability("platformVersion", "11");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("isRealMobile", true);
            capabilities.setCapability("app", "APP_URL"); //Enter your app url
            capabilities.setCapability("deviceOrientation", "PORTRAIT");
            capabilities.setCapability("build", "Java Vanilla - Android");
            capabilities.setCapability("name", "Sample Test Java");
            capabilities.setCapability("console", true);
            capabilities.setCapability("network", false);
            capabilities.setCapability("visual", true);
            capabilities.setCapability("autoGrantPermissions", true);
            capabilities.setCapability("devicelog", true);

            driver = new AppiumDriver(new URL("https://" +userName + ":" + accessKey + "@mobile-hub.lambdatest.com/wd/hub"), capabilities);

            //Clicks on Read more
            MobileElement readMoreButton = (MobileElement) driver.findElement(MobileBy.id("com.lambdatest.proverbial:id/readMoreButton"));
            readMoreButton.click();
            Thread.sleep(3000);

            //Back to home page
            MobileElement backButtonReadMorePage = (MobileElement) driver.findElement(MobileBy.id("com.lambdatest.proverbial:id/backButtonReadMorePage"));
            backButtonReadMorePage.click();
            Thread.sleep(3000);

            //Click on location
            MobileElement Location = (MobileElement) driver.findElementByAccessibilityId("Location");
            Location.click();
            Thread.sleep(3000);

            //Back to home page
            driver.navigate().back();
            Thread.sleep(2000);

            //Click on Browser
            MobileElement Browser = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Browser\"]/android.widget.FrameLayout/android.widget.ImageView");
            Browser.click();
            Thread.sleep(3000);

            //Add URL to search box
            MobileElement url = (MobileElement) driver.findElement(MobileBy.id("com.lambdatest.proverbial:id/url"));
            url.sendKeys("https://www.lambdatest.com");

            //Click on find button
            MobileElement find = (MobileElement) driver.findElement(MobileBy.id("com.lambdatest.proverbial:id/find"));
            find.click();
            Thread.sleep(3000);

            //Click on Home button
            MobileElement Home = (MobileElement) driver.findElementByAccessibilityId("Home");
            Home.click();

            //Open the side drawer
            MobileElement Drawer = (MobileElement) driver.findElementByAccessibilityId("drawer open");
            Drawer.click();
            Thread.sleep(3000);

            //Click on Push Notification
            MobileElement Notification = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@text,\"Push Notification\")]");
            Notification.click();

            //Close the side drawer
            MobileElement closeDrawer = (MobileElement) driver.findElementByAccessibilityId("drawer Closed");
            closeDrawer.click();
            Thread.sleep(2000);


        } catch (AssertionError a) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=failed");
            a.printStackTrace();
        }
        
// The driver.quit statement is required, otherwise the test continues to execute, leading to a timeout.
        driver.quit();
    }
    }
