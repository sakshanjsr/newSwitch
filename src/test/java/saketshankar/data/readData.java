package saketshankar.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class readData {

	
	public List<HashMap<String, String>> readJSONdata() throws IOException {
		String jsonContect = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\saketshankar\\data\\data.json" ) , StandardCharsets.UTF_16);
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String, String>> data = mapper.readValue(jsonContect, new TypeReference<List<HashMap<String, String>>>()  {});
		return data;
	}
}
