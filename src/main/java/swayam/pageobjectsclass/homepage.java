package swayam.pageobjectsclass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage extends AbstratctComponents {
	
	WebDriver driver;
	public homepage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}


	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	By allProductName=By.cssSelector("b");
	By addToCartbtn=By.cssSelector(".card-body button:last-of-type");
	
	public void addToCart() {
		WebElement abc = products.stream()
				.filter(product -> product.findElement(allProductName).getText().equals("ZARA COAT 3")).findFirst()
				.orElse(null);
		abc.findElement(addToCartbtn).click();
	}

}
