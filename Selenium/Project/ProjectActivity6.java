package fstProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProjectActivity6 {
    public static void main(String[] args) {
        // Set up the WebDriver and open the browser
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // a. Open the OrangeHRM page and login with credentials provided.
            driver.get("https://your-orangehrm-url.com");
            driver.findElement(By.id("txtUsername")).sendKeys("your-username");
            driver.findElement(By.id("txtPassword")).sendKeys("your-password");
            driver.findElement(By.id("btnLogin")).click();

            // b. Locate the navigation menu
            WebElement directoryMenu = driver.findElement(By.id("menu_directory_viewDirectory"));

            // c. Verify that the “Directory” menu item is visible and clickable.
            if (directoryMenu.isDisplayed() && directoryMenu.isEnabled()) {
                System.out.println("Directory menu is visible and clickable.");

                // d. If clickable, click on the menu item.
                directoryMenu.click();

                // e. Verify that the heading of the page matches “Search Directory”.
                WebElement heading = driver.findElement(By.tagName("h1"));
                String headingText = heading.getText();
                if (headingText.equals("Search Directory")) {
                    System.out.println("Heading matches 'Search Directory'.");
                } else {
                    System.out.println("Heading does not match 'Search Directory'. Found: " + headingText);
                }
            } else {
                System.out.println("Directory menu is not visible or not clickable.");
            }

            // Add a small wait to observe the changes (optional)
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // f. Close the browser.
            driver.quit();
        }
    }
}
