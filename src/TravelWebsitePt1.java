import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelWebsitePt1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\EarlHans Geñoso\\Desktop\\Resources\\driver_v1\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.get("https://www.easyjet.com/en");
		driver.findElement(By.id("ensCloseBanner")).click();
		// click the search bar origin
		driver.findElement(By.cssSelector("input[name='origin']")).click();
		// put a text in field of origins/from
		driver.findElement(By.cssSelector("input[name='origin']")).sendKeys("London");
		// wait when the elements are visible and get the dropdown list suggestions for origins/from
		List<WebElement> origins = new WebDriverWait(driver, 20)
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#ui-id-1 li>a>span")));
		// display all the list using for loop and choose Stansted
		for(WebElement origin: origins) {
			if(origin.getText().contains("Stansted")) {
				origin.click();
			}
		}
		// click the search bar destination
		driver.findElement(By.cssSelector("input[name='destination']")).click();
		// put a text in field of destinations/to
		driver.findElement(By.cssSelector("input[name='destination']")).sendKeys("a");
		// wait when the elements are visible and get the dropdown list suggestions for destinations/to
		List<WebElement> destinations = new WebDriverWait(driver, 20)
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#ui-id-2 li>a>span")));
		// display all the list using for loop and choose Scotland
		for(WebElement destination: destinations) {
			if(destination.getText().contains("Scotland")) {
				destination.click();
			}
		}
		
	}
}
