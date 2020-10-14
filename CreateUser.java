package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateUser {

	WebDriver driver;
	WebDriverWait wait;


	@Given("^Open a browser$")
	public void openBrowser() throws Throwable {
       driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs");
		wait = new WebDriverWait(driver, 30);
	}

	@When("^Navigate to Alchemy Jobs and log in$")
	public void logIn() throws Throwable {
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
		driver.manage().window().maximize();

		driver.findElement(By.id("user_login")).clear();
		driver.findElement(By.id("user_login")).sendKeys("root");

		driver.findElement(By.id("user_pass")).clear();
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");

		driver.findElement(By.id("wp-submit")).click();
	}

	@Then("^Locate the left hand menu and click the menu item that has Users$")
	public void clickOnUsers() {
		driver.findElement(By.xpath("//a/div[text()='Users']")).click();
	}

	@And("^Locate the Add New button and click it$")
	public void clickAddNewButton() {
		driver.findElement(By.linkText("Add New")).click();
	}

	@Then("^Fill in the necessary details$")
	public void fillInUserDetails() {
		driver.findElement(By.id("user_login")).clear();
		driver.findElement(By.id("user_login")).sendKeys("Subbu");

		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("subbu@gmail.com");
	}

	@And("^Click the Add New User button$")
	public void clickAddNewUserButton() {
		driver.findElement(By.id("createusersub")).click();
	}

	@Then("^Verify that the user was created$")
	public void verifyUserCreation() {
		driver.findElement(By.id("user-search-input")).clear();
		driver.findElement(By.id("user-search-input")).sendKeys("Subbu");

		driver.findElement(By.id("search-submit")).click();

		String actualUserName = driver.findElement(By.linkText("Subbu")).getText();

		Assert.assertEquals(actualUserName, "Subbu");
	}

	@And("^Close the browser$")
	public void closeTheBrowser() throws Throwable {
		driver.quit();
	}
}