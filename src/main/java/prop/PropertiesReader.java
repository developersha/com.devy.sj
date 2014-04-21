package prop;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

public class PropertiesReader {

	// default file name
	static String fileName = "config.properties";

	private PropertiesReader() {
	}

	public static PropertiesReader getInstance(String propFileName)
			throws Exception {
		// make sure properties file exists
		if (!FileUtils.isExists(propFileName)) {
			throw new Exception(String.format(
					"Properties file with name '%s' doesn't exist. ",
					propFileName));
		}

		fileName = propFileName;
		return new PropertiesReader();

	}

	public String readByKey(String key) {
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

	public ArrayList<String> readAll() {

		ArrayList<String> list = new ArrayList<String>();
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(fileName);

			// load a properties file
			prop.load(input);

			Set<Object> keys = prop.keySet();

			for (Object key : keys) {
				String value = prop.getProperty(key.toString());
				list.add(String.format("%s=%s", key, value));
			}

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

		return list;
	}
}
