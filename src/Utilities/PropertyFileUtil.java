package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtil {

	public static String getValueForKey(String Key) throws Exception {

		Properties configProperties = new Properties();

		FileInputStream fis = new FileInputStream("D:\\Nivas.sri\\Automation\\Stock_Accounting\\PropertiesFile\\Repository.properties");

		configProperties.load(fis);

		return (String) configProperties.get(Key);

	}
}
