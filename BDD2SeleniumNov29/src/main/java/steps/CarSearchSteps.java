package steps;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CarSearchSteps {

	public static WebDriver driver;

	@Before
	public void setUp() {
		// launch chrome browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Given("I am on the homepage https:\\/\\/www.carsales.com.au\\/")
	public void i_am_on_the_homepage_https_www_carsales_com_au() {
		driver.get("https://www.carsales.com.au");

	}

	@When("I am move to Cars for Sale menu")
	public void i_am_move_to_cars_for_sale_menu() {

		WebElement carForSale = driver.findElement(By.xpath("//a[contains(text(),'Cars For Sale')]"));
		Actions act = new Actions(driver);
		act.moveToElement(carForSale).build().perform();

	}

	@Then("I click on All cars")
	public void i_click_on_all_cars() {
		driver.findElement(By.xpath("//a[contains(text(),'All cars')]")).click();
	}

	@Then("I click on Make")
	public void i_click_on_make() {
		driver.findElement(By.xpath("//div[contains(text(),'Make')]")).click();

	}

	@Then("Select Make as {string}")
	public void select_make_as(String make) {
		driver.findElement(By.cssSelector("input[placeholder='Filter']")).sendKeys(make);
		// Select the radio button
		driver.findElement(By.cssSelector("span.icon-tick")).click();

	}

	@Then("The page title should match {string}")
	public void the_page_title_should_match(String expectedTitle) {
		String actualTitle = driver.getTitle();

		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Then("I click on Search button")
	public void i_click_on_search_button() {
		driver.findElement(By.xpath("//a[contains(text(),'Search')]")).click();

	}

	@Then("I see a list of searched Cars")
	public void i_see_a_list_of_searched_cars() {
		List<WebElement> cars = driver.findElements(By.cssSelector("div.col>h3>a"));
		for (WebElement car : cars) {
			System.out.println("Car name are: " + car.getText());
		}

	}

	/*
	 * @Then("The page title should match Audi cars for sale in Australia - carsales.com.au"
	 * ) public void
	 * the_page_title_should_match_audi_cars_for_sale_in_australia_carsales_com_au()
	 * {
	 * 
	 * }
	 */

}
