package com.banking.genericUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Admin
 * This class consists of methods to fetch common data from property file
 */
public class FileUtility {
	/**
	 * This method is used to fetch common data present inside the property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
public String getPropertyKeyValue(String key) throws IOException
{
	FileInputStream fl=new FileInputStream(IPConstants.propertyFilePath);
	Properties pr = new Properties();
	pr.load(fl);
	return pr.getProperty(key);
}
}
