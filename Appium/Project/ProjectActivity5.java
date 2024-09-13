import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
public class ProjectActivity5 {
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

        // Scroll down to find the Login Form card and click it
        MobileElement loginFormCard = driver.findElement(By.xpath("//android.view.View[contains(@text, 'Login Form')]"));
        loginFormCard.click();

        // Wait for the Login Form page to load
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Test case 1: Correct credentials
        login(driver, "admin", "password");

        // Assertion: Verify the success message for correct credentials
        MobileElement successMessage = driver.findElement(By.id("action-confirmation"));
        Assert.assertEquals(successMessage.getText(), "Welcome Back, admin", "Login with correct credentials failed!");

        // Go back to the login page for the next test case
        driver.navigate().back();

        // Test case 2: Incorrect credentials
        login(driver, "admin", "wrongpassword");

        // Assertion: Verify the failure message for incorrect credentials
        MobileElement failureMessage = driver.findElement(By.id("action-confirmation"));
        Assert.assertEquals(failureMessage.getText(), "Invalid Credentials", "Login with incorrect credentials failed!");

        // Close the driver
        driver.quit();
    }

    // Helper method to handle the login process
    public static void login(AppiumDriver<MobileElement> driver, String username, String password) {
        // Enter username
        MobileElement usernameField = driver.findElement(By.id("username"));
        usernameField.clear();
        usernameField.sendKeys(username);

        // Enter password
        MobileElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys(password);

        // Click on the Log in button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
