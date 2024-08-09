package fstProject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class ProjectActivity2 {
	public static void main(String[] args) {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

            try {
                // Navigate to the webpage
                driver.get("http://alchemy.hguy.co/orangehrm");

                // Find the header image element
                WebElement headerImage = driver.findElement(By.cssSelector("img[src*='/orangehrm/symfony/web/webres_5d69118beeec64']"));

                // Get the URL of the header image
                String imageUrl = headerImage.getAttribute("src");
                System.out.println("Header image URL: " + imageUrl);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // Close the browser
                driver.quit();
            }
        }
}