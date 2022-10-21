package swayam.pageobjectsclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage extends AbstratctComponents {

	WebDriver driver;

	public loginpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// WebElement userid=driver.findElement(By.id("userEmail"));
	// WebElement pwd=driver.findElement(By.id("userPassword"));
	// WebElement loginbtn=driver.findElement(By.id("login"));

	@FindBy(id = "userEmail")
	WebElement userid;

	@FindBy(id = "userPassword")
	WebElement pwd;

	@FindBy(id = "login")
	WebElement loginbtn;

	@FindBy(css = ".ngx-toastr")
	WebElement errorMsg;

	public homepage login(String uname, String pw) {
		userid.sendKeys(uname);
		pwd.sendKeys(pw);
		loginbtn.click();
		return new homepage(driver);
	}

	public String getErrorMessage() {
		waitForElementToAppear(errorMsg);
		return errorMsg.getText();

	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

}
