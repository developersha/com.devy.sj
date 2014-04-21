package prop;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

// Class to write properties into file
public class PropertiesWriter {

	// default file name
	static String fileName = "config.properties";

	private PropertiesWriter() {
	}

	// Get the instance of PropertiesWriter
	// if file doesn't exist - create new file
	// if file exists - return instance
	public static PropertiesWriter getInstance(String propFileName)
			throws Exception {
		
		// check if properties file already exists
		if (FileUtils.isExists(propFileName)) 
		{
			throw new Exception(String.format(
					"Properties file with name '%s' already exists. ",
					propFileName));
		}

		fileName = propFileName;
		return new PropertiesWriter();
	}

	
	public void write(String key, String value) throws Exception {

		Properties properties = new Properties();

		InputStream input = null;
		try {

			if (FileUtils.isExists(fileName)) {

				input = new FileInputStream(fileName);

				// make sure key/value is not overridden
				properties.load(input);
				String existingValue = "";
				existingValue = properties.getProperty(key);

				if (existingValue != "") {
					throw new Exception(String.format(
							"Key '%s' exists in .properties file.", key));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		OutputStream output = null;

		try {
			output = new FileOutputStream(fileName);

			properties.setProperty(key, value);

			// save properties file to project root folder
			properties.store(output, null);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
