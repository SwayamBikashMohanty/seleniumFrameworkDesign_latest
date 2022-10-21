package swayam.commontestconfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import swayam.pageobjectsclass.loginpage;

public class baseclass {
	public WebDriver driver;
	public loginpage loginpage;

	public WebDriver initializaton() throws IOException {

		Properties prop = new Properties();
		FileInputStream stream = new FileInputStream(
				"C:\\Users\\swaya\\eclipse-workspace\\NewWorkSpace\\seleniumFrameworkDesign\\src\\main\\java\\swayam\\resources\\common.properties");
		prop.load(stream);
		String browsername = prop.getProperty("browser");

		if (browsername.equalsIgnoreCase("chrome")) {
			driver = WebDriverManager.chromedriver().avoidShutdownHook().create();// initialize with chrome
		} else if (browsername.equalsIgnoreCase("firefox")) {

		} else if (browsername.equalsIgnoreCase("edge")) {

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports" + testCaseName + ".png";
	}

	public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException {
		// read json to string
		String jsonContent = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
		// String to hashMap Jackson databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;

	}

	@BeforeMethod
	public loginpage launchApplication() throws IOException {
		driver = initializaton();
		loginpage = new loginpage(driver);
		loginpage.goTo();
		return loginpage;

	}

}
