package prop;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesWriter {

	String fileName = "config.properties";

	public void write(String key, String value) {
		//TODO: finish implementation
	}
	
	public void write() {

		Properties properties = new Properties();
		OutputStream output = null;
		try {

			output = new FileOutputStream(fileName);
			properties.setProperty("dayPath", "C:/days/Day.txt");

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
