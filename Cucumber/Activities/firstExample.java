package stepDefinitions;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class firstExample extends BaseClass {
    @BeforeAll
    public static void setUp() {
        // Setup browser
        WebDriverManager.firefoxdriver().setup();
        // Initialize Firefox Driver
        WebDriver driver = new FirefoxDriver();;
    }

    @AfterAll
    public static void tearDown() {
        // Close the browser
    	driver.quit();
    }

    @Given("the user is on the TS homepage")
    public void openTSHomepage() {
        // Open the Training Support home page
    	driver.get("https://v1.training-support.net");
        // Assertion
        Assertions.assertEquals("Training Support", driver.getTitle());
    }

    @When("the user clicks on the About Us link")
    public void clickAboutLink() {
        // Find and click About Us link
    	driver.findElement(By.id("about-link")).click();
    }

    @Then("the user is redirected to the About page")
    public void verifyAboutPage() {
        // Assertion
        Assertions.assertEquals("About Training Support", driver.getTitle());
    }
}

