  package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propertiesUtility {
	public String getDataFromProperties(String key) throws Exception {
		FileInputStream fis=new FileInputStream(ipathutility.propertiespath);
		Properties prop=new Properties();
		prop.load(fis);
		String value=prop.getProperty(key);
		return value;
		
	}
	

}
