package fstProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProjectActivity8 {
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

            // b. Navigate to the Dashboard page and click on the Apply Leave option.
            WebElement dashboardMenu = driver.findElement(By.id("menu_dashboard_index"));
            dashboardMenu.click();

            WebElement applyLeave = driver.findElement(By.id("menu_leave_applyLeave"));
            applyLeave.click();

            // c. Select leave type and duration of the leave.
            WebElement leaveType = driver.findElement(By.id("applyleave_txtLeaveType"));
            leaveType.sendKeys("Annual Leave");

            WebElement fromDate = driver.findElement(By.id("applyleave_txtFromDate"));
            fromDate.clear();
            fromDate.sendKeys("yyyy-mm-dd");

            WebElement toDate = driver.findElement(By.id("applyleave_txtToDate"));
            toDate.clear();
            toDate.sendKeys("yyyy-mm-dd");

            // d. Click Apply.
            WebElement applyButton = driver.findElement(By.id("applyBtn"));
            applyButton.click();

            // e. Navigate to the My Leave page to check the status of the leave application.
            WebElement myLeaveMenu = driver.findElement(By.id("menu_leave_viewMyLeaveList"));
            myLeaveMenu.click();

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


