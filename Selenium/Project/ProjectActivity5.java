package fstProject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ProjectActivity5 {
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

            // b. Find the “My Info” menu item and click it.
            WebElement myInfoMenu = driver.findElement(By.id("menu_pim_viewMyDetails"));
            myInfoMenu.click();

            // c. On the new page, click the Edit button.
            WebElement editButton = driver.findElement(By.id("btnSave"));
            editButton.click();

            // d. Fill in the Name, Gender, Nationality, and DOB fields.
            // Filling in First Name
            WebElement firstName = driver.findElement(By.id("personal_txtEmpFirstName"));
            firstName.clear();
            firstName.sendKeys("NewFirstName");

            // Filling in Last Name
            WebElement lastName = driver.findElement(By.id("personal_txtEmpLastName"));
            lastName.clear();
            lastName.sendKeys("NewLastName");

            // Selecting Gender
            WebElement gender = driver.findElement(By.id("personal_optGender_1")); // 1 for Male, 2 for Female
            gender.click();

            // Selecting Nationality
            WebElement nationality = driver.findElement(By.id("personal_cmbNation"));
            nationality.sendKeys("Nationality");

            // Setting Date of Birth
            WebElement dob = driver.findElement(By.id("personal_DOB"));
            dob.clear();
            dob.sendKeys("yyyy-mm-dd");

            // e. Click Save.
            WebElement saveButton = driver.findElement(By.id("btnSave"));
            saveButton.click();

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

