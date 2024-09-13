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
public class ProjectActivity4 {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Android Emulator"); // Set your device/emulator name
        caps.setCapability("platformName", "Android");
        caps.setCapability("browserName", "Chrome"); // Use Chrome browser
        caps.setCapability("noReset", true);

        // Set up Appium driver
        AppiumDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Open the URL in Chrome
        driver.get("https://v1.training-support.net/selenium");

        // Scroll down to find the To-Do List card and click it
        MobileElement toDoListCard = driver.findElement(By.xpath("//android.view.View[contains(@text, 'To-Do List')]"));
        toDoListCard.click();

        // Wait for the To-Do List page to load
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Add the first task
        MobileElement inputField = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='taskInput']"));
        inputField.sendKeys("Add tasks to list");
        driver.findElement(By.xpath("//android.widget.Button[@text='Add Task']")).click();

        // Add the second task
        inputField.sendKeys("Get number of tasks");
        driver.findElement(By.xpath("//android.widget.Button[@text='Add Task']")).click();

        // Add the third task
        inputField.sendKeys("Clear the list");
        driver.findElement(By.xpath("//android.widget.Button[@text='Add Task']")).click();

        // Strike out each task by clicking on them
        List<MobileElement> tasks = driver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id, 'taskText')]"));
        for (MobileElement task : tasks) {
            task.click();
        }

        // Clear the list
        driver.findElement(By.xpath("//android.widget.Button[@text='Clear List']")).click();

        // Assertion: Verify that the task list is cleared and number of tasks is zero
        List<MobileElement> remainingTasks = driver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id, 'taskText')]"));
        Assert.assertEquals(remainingTasks.size(), 0, "The task list was not cleared!");

        // Close the driver
        driver.quit();
    }
}
