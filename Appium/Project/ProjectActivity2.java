import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
public class ProjectActivity2 {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Android Emulator"); // Set your device name
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.google.android.keep"); // Google Keep app package
        caps.setCapability("appActivity", "com.google.android.keep.activities.BrowseActivity"); // Google Keep app activity
        caps.setCapability("noReset", true);

        // Set up Appium driver
        AppiumDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Click the "Create New Note" button
        driver.findElement(By.id("com.google.android.keep:id/new_note_button")).click();

        // Add a title for the note
        driver.findElement(By.id("com.google.android.keep:id/editable_title")).sendKeys("Test Note Title");

        // Add a small description
        driver.findElement(By.id("com.google.android.keep:id/edit_note_text")).sendKeys("This is a description for the test note.");

        // Press the back button to save and go back to the main screen
        driver.navigate().back();
        driver.navigate().back(); // Ensure that you fully return to the list view

        // Assertion: Check if the note was added by verifying if the title is displayed
        MobileElement addedNote = driver.findElement(By.xpath("//android.widget.TextView[@text='Test Note Title']"));
        Assert.assertTrue(addedNote.isDisplayed(), "The note was not added successfully!");

        // Close the driver
        driver.quit();
    }
}
