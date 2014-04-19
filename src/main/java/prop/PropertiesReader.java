package prop;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

	String fileName = "config.properties";
	
	public String read(String key)
	{				
		Properties prop = new Properties();
		InputStream input = null;
	 
		String property = "";
		
		try {
	 
			input = new FileInputStream(fileName);
	 
			// load a properties file
			prop.load(input);
	 
			property = prop.getProperty(key);
	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return property;
	 
	}
}
