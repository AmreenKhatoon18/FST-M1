import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
public class ProjectActivity3 {
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
        driver.findElement(By.id("com.google.android.keep:id/editable_title")).sendKeys("Test Note with Reminder");

        // Add a small description
        driver.findElement(By.id("com.google.android.keep:id/edit_note_text")).sendKeys("This is a test note with a reminder.");

        // Click the reminder icon
        driver.findElement(By.id("com.google.android.keep:id/menu_reminder")).click();

        // Select "Afternoon" for the reminder
        driver.findElement(By.xpath("//android.widget.TextView[@text='Afternoon']")).click();

        // Press the back button to save the note and return to the main screen
        driver.navigate().back();
        driver.navigate().back(); // Ensure you are back on the main screen

        // Switch to the "Reminders" page
        driver.findElement(By.xpath("//android.widget.TextView[@text='Reminders']")).click();

        // Assertion: Check if the note was added with a reminder
        MobileElement addedReminderNote = driver.findElement(By.xpath("//android.widget.TextView[@text='Test Note with Reminder']"));
        Assert.assertTrue(addedReminderNote.isDisplayed(), "The note with a reminder was not added successfully!");

        // Close the driver
        driver.quit();
    }
}
