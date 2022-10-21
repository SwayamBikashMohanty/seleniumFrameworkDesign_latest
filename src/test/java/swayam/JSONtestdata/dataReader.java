package swayam.JSONtestdata;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.core.type.TypeReference;
/*
 * This class not required separately,i added this class in base class
 */
public class dataReader {

	public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
		// read json to string
		String jsonContent = FileUtils.readFileToString(
				new File(System.getProperty("user.dir") + "//src//test//java//swayam//JSONtestdata//logindata.json"),
				StandardCharsets.UTF_8);
		// String to hashMap Jackson databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;

	}
}
