import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class ProjectActivity1 {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Android Emulator"); // Set your device name
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.google.android.apps.tasks"); // Google Tasks app package
        caps.setCapability("appActivity", "com.google.android.apps.tasks.ui.TaskListsActivity"); // Google Tasks app activity
        caps.setCapability("noReset", true);

        // Set up Appium driver
        AppiumDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Add the first task
        driver.findElement(By.id("com.google.android.apps.tasks:id/tasks_fab")).click(); // Click add task button
        driver.findElement(By.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Tasks"); // Enter task title
        driver.findElement(By.id("com.google.android.apps.tasks:id/add_task_done")).click(); // Click save button

        // Add the second task
        driver.findElement(By.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        driver.findElement(By.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Keep");
        driver.findElement(By.id("com.google.android.apps.tasks:id/add_task_done")).click();

        // Add the third task
        driver.findElement(By.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        driver.findElement(By.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete the second Activity Google Keep");
        driver.findElement(By.id("com.google.android.apps.tasks:id/add_task_done")).click();

        // Assertion: Check if all three tasks are present in the list
        List<MobileElement> taskList = driver.findElements(By.id("com.google.android.apps.tasks:id/task_name"));
        Assert.assertEquals(taskList.size(), 3, "All tasks have not been added!");

        // Verify task titles
        Assert.assertEquals(taskList.get(0).getText(), "Complete Activity with Google Tasks");
        Assert.assertEquals(taskList.get(1).getText(), "Complete Activity with Google Keep");
        Assert.assertEquals(taskList.get(2).getText(), "Complete the second Activity Google Keep");

        // Close the driver
        driver.quit();
    }
}
