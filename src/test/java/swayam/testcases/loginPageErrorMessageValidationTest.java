package swayam.testcases;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import swayam.commontestconfiguration.Retry;
import swayam.commontestconfiguration.baseclass;

public class loginPageErrorMessageValidationTest extends baseclass {

	//@Test(dataProvider = "getData", retryAnalyzer = Retry.class)

	 @Test(dataProvider = "getData")
	public void validateErrorMessage(HashMap<String, String> input) {

		loginpage.login(input.get("email"), input.get("pwd"));
		Assert.assertEquals("Login Successfully", loginpage.getErrorMessage());
	}

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//swayam//JSONtestdata//logindata.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

		/*
		 * HashMap<String, String> map = new HashMap<String, String>(); map.put("Email",
		 * "adv@gmail.com"); map.put("pwd", "dbsfjd");
		 * 
		 * HashMap<String, String> map1 = new HashMap<String, String>();
		 * map1.put("Email", "testselenium@mailinator.com"); map1.put("pwd",
		 * "Qwerty123");
		 */

	}

}
