package prop;

import java.io.File;

//Set of file utilities 
public class FileUtils {

	//Check if file exists
	public static Boolean isExists(String fileName) {
		File f = new File(fileName);
		
		// exists() may return true for directory
		return (f.exists() && !f.isDirectory()); 
	}

}
