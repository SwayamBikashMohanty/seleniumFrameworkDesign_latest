package swayam.pageobjectsclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstratctComponents {
	
	WebDriver driver;
	public AbstratctComponents(WebDriver driver) {
		this.driver=driver;
	}
	
	public void waitForElementToAppear(By findBy) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(
			ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElementToAppear(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(
				ExpectedConditions.visibilityOf(ele));
		}
}
