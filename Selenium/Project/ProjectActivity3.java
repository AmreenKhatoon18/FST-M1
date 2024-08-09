package fstProject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class ProjectActivity3 {
	public static void main(String[] args) {
		
	        // Set the path to your chromedriver executable
			WebDriverManager.firefoxdriver().setup();
		      
	        WebDriver driver = new FirefoxDriver();

	        // Navigate to the login page
	        driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");

	        try {
	            // Find the username field and enter username
	            WebElement usernameField = driver.findElement(By.id("txtUsername"));
	            usernameField.sendKeys("orange");

	            // Find the password field and enter password
	            WebElement passwordField = driver.findElement(By.id("txtPassword"));
	            passwordField.sendKeys("orangepassword123");

	            // Click on the login button
	            WebElement loginButton = driver.findElement(By.id("btnLogin"));
	            loginButton.click();

	            // Wait for the homepage to load (you might need to add explicit waits here)

	            // Example verification: Check if the dashboard element is present
	            WebElement dashboardElement = driver.findElement(By.id("dashboard-quick-launch-panel-menu_holder"));
	            if (dashboardElement.isDisplayed()) {
	                System.out.println("Login successful. Homepage loaded.");
	            } else {
	                System.out.println("Login failed. Homepage not loaded.");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Close the browser
	            driver.quit();
	        }
	    }     
           
}
