package swayam.testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import swayam.commontestconfiguration.baseclass;
import swayam.pageobjectsclass.homepage;
import swayam.pageobjectsclass.loginpage;

public class StandaloneTest extends baseclass {

	@Test(dataProvider = "getData")
	public void submitOrder(String email, String pwd) throws IOException {

		homepage homepage = loginpage.login(email, pwd);
		homepage.addToCart();

		/*
		 * Thread.sleep(2000); // clickOnCart button
		 * driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click
		 * ();// mycart page // click on checkOut btn
		 * driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click(
		 * );// payment method page // click on selectCountry WebElement selectcontry =
		 * driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
		 * selectcontry.sendKeys("India");
		 * 
		 * List<WebElement> countries = driver .findElements(By.
		 * xpath("//section[@class='ta-results list-group ng-star-inserted']")); for
		 * (WebElement singlecontry : countries) { String text = singlecontry.getText();
		 * if (text.contains("India")) { singlecontry.click(); break; } } WebDriverWait
		 * wait = new WebDriverWait(driver, Duration.ofSeconds(20)); wait.until(
		 * ExpectedConditions.visibilityOfElementLocated(By.
		 * xpath("//div[@class='actions']/a[contains(text(),'Place Order' )]")));
		 * driver.findElement(By.
		 * xpath("//div[@class='actions']/a[contains(text(),'Place Order' )]")).click();
		 * driver.findElement(By.
		 * xpath("//div[@class='actions']/a[contains(text(),'Place Order' )]")).click();
		 */
	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "testselenium@mailinator.com", "Qwerty123" }, { "sdfsh@gmail.com", "smdbs" } };

	}

}
