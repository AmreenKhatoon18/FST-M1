package fstProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProjectActivity7 {
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

            // c. On the new page, find the Qualification option on the left side menu and click it.
            WebElement qualificationMenu = driver.findElement(By.id("menu_pim_viewQualifications"));
            qualificationMenu.click();

            // d. Add Work Experience and click Save.
            WebElement addWorkExperienceButton = driver.findElement(By.id("addWorkExperience"));
            addWorkExperienceButton.click();

            WebElement company = driver.findElement(By.id("experience_employer"));
            company.sendKeys("Company Name");

            WebElement jobTitle = driver.findElement(By.id("experience_jobtitle"));
            jobTitle.sendKeys("Job Title");

            WebElement fromDate = driver.findElement(By.id("experience_from_date"));
            fromDate.clear();
            fromDate.sendKeys("yyyy-mm-dd");

            WebElement toDate = driver.findElement(By.id("experience_to_date"));
            toDate.clear();
            toDate.sendKeys("yyyy-mm-dd");

            WebElement comments = driver.findElement(By.id("experience_comments"));
            comments.sendKeys("Work experience details...");

            WebElement saveButton = driver.findElement(By.id("btnWorkExpSave"));
            saveButton.click();

            // Add a small wait to observe the changes (optional)
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // e. Close the browser.
            driver.quit();
        }
    }
}
