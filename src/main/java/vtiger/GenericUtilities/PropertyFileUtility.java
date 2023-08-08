package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	/*
	 * This method reads Data from propert file based on given key
	 * @param key
	 * @return value
	 * @throws Throwable
	 * 
	 * 
	 */

	public String getDataFromPropertyFile(String key) throws Throwable
{
	FileInputStream fis=new FileInputStream(IConstants.propertyFilePath);
    Properties p=new Properties();
	p.load(fis);
	String value = p.getProperty(key);
	return value;
	}
}
