package fstProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class ProjectActivity9 {
    public static void main(String[] args) {
        // Set up the WebDriver and open the browser
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // a. Open the OrangeHRM page and login with credentials provided
            driver.get("https://your-orangehrm-url.com");
            driver.findElement(By.id("txtUsername")).sendKeys("your-username");
            driver.findElement(By.id("txtPassword")).sendKeys("your-password");
            driver.findElement(By.id("btnLogin")).click();

            // b. Navigate to the “My Info” page.
            WebElement myInfoMenu = driver.findElement(By.id("menu_pim_viewMyDetails"));
            myInfoMenu.click();

            // c. Locate the left-hand menu.
            // d. Click on the “Emergency Contacts” menu item
            WebElement emergencyContactsMenu = driver.findElement(By.id("menu_pim_viewEmergencyContacts"));
            emergencyContactsMenu.click();

            // e. Retrieve information about all the contacts listed in the table.
            WebElement contactsTable = driver.findElement(By.id("emgcontact_list"));
            List<WebElement> rows = contactsTable.findElements(By.tagName("tr"));

            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                for (WebElement cell : cells) {
                    System.out.print(cell.getText() + " | ");
                }
                System.out.println();
            }

            // Add a small wait to observe the output (optional)
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // f. Close the browser.
            driver.quit();
        }
    }
}

