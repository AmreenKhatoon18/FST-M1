package fstProject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class ProjectActivity4 {
	public static void main(String[] args) {
		
        // Set the path to your chromedriver executable
		WebDriverManager.firefoxdriver().setup();
	      
        WebDriver driver = new FirefoxDriver();
        try {
            // Navigate to the OrangeHRM login page
            driver.get("https://orangehrm-demo-6x.orangehrmlive.com/symfony/web/index.php/auth/login");

            // Find username and password fields and login
            WebElement usernameField = driver.findElement(By.id("txtUsername"));
            WebElement passwordField = driver.findElement(By.id("txtPassword"));
            WebElement loginButton = driver.findElement(By.id("btnLogin"));

            // Enter username and password
            usernameField.sendKeys("orange");
            passwordField.sendKeys("orangepassword123");

            // Click login button
            loginButton.click();

            // Wait for PIM option to be clickable in the menu
            WebElement pimMenu = driver.findElement(By.id("menu_pim_viewPimModule"));
            pimMenu.click();

            // Click on Add button to add a new employee
            WebElement addButton = driver.findElement(By.id("menu_pim_addEmployee"));
            addButton.click();

            // Fill in employee details
            WebElement firstNameField = driver.findElement(By.id("firstName"));
            WebElement lastNameField = driver.findElement(By.id("lastName"));
            WebElement employeeIdField = driver.findElement(By.id("employeeId"));

            // Generate a unique employee ID (example: using current timestamp)
            String employeeId = "EMP" + System.currentTimeMillis();
            firstNameField.sendKeys("John");
            lastNameField.sendKeys("Doe");
            employeeIdField.clear();
            employeeIdField.sendKeys(employeeId);

            // Click Save button
            WebElement saveButton = driver.findElement(By.id("btnSave"));
            saveButton.click();

            // Verify employee creation: Navigate to Employee List tab in PIM
            WebElement employeeListTab = driver.findElement(By.id("menu_pim_viewEmployeeList"));
            employeeListTab.click();

            // Search for the newly added employee using their ID
            WebElement employeeIdSearchField = driver.findElement(By.id("empsearch_id"));
            employeeIdSearchField.sendKeys(employeeId);

            WebElement searchButton = driver.findElement(By.id("searchBtn"));
            searchButton.click();

            // Verify if the employee appears in the search results
            WebElement employeeRecord = driver.findElement(By.xpath("//table[@id='resultTable']//td[text()='" + employeeId + "']"));
            if (employeeRecord.isDisplayed()) {
                System.out.println("Employee with ID " + employeeId + " added successfully.");
            } else {
                System.out.println("Failed to add employee with ID " + employeeId + ".");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
	}
}
