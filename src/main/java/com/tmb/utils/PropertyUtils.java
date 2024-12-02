package com.tmb.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.tmb.constants.FrameworkConstants;
import com.tmb.enums.ConfigProperties;
import com.tmb.exceptions.FrameworkExceptions;
import com.tmb.exceptions.PropertyFileIOException;
import com.tmb.exceptions.PropertyFileUsageException;

public final class PropertyUtils {

	static Properties property=new Properties();
	public static final Map<String,String> ConfigMap = new HashMap<>();	
	//public static final Map<ConfigProperties,String> ConfigMap = new EnumMap<>(ConfigProperties.class);
	
	private PropertyUtils()
	{}
	
	// We are loading the property file on static block. 
	static {
		
		try (FileInputStream file=new FileInputStream(FrameworkConstants.getConfigfilepath());){
			
			property.load(file);
			for(Object key: property.keySet())
			//for(ConfigProperties key: ConfigProperties.values())
			{
				// here key is in object form hence we are converting object into string using valueOf method.
				ConfigMap.put(String.valueOf(key), String.valueOf(property.get(key)).trim());
				//ConfigMap.put(key, String.valueOf(property.get(key)).trim()); // trim can remove leading and ending spaces to avoid runtime exp
			}
			
		} 
		catch (IOException e) {	
		// we are not handling filenotfound exp since i/o is parent of that.
		// below we used system.exit(0) to stop the execution when we get exp on Static block
		//bcz static blocks initialize before program starts
		// if any exp that can't terminate the program it will execute rest of the code and shows
		// unwanted messages on log hence we have to stop the execution using exit() method.
			
			
			//throw new PropertyFileIOException("/The properties file is having someproblem");
			e.printStackTrace();
			System.exit(0);
		}
		
	}
	
	
	public static String getVal(ConfigProperties key) // ConfigProperties is enum to restrict the constants for config file
	{
		
		if(Objects.isNull(key.name().toLowerCase()) || Objects.isNull(ConfigMap.get(key.name().toLowerCase())))
		{
			throw new PropertyFileUsageException("The key "+key+" is not found,Please check the config file");
		}
		return ConfigMap.get(key.name().toLowerCase());   // .name().toLowerCase() we converted key into lowercase since we used the caps in ENUM. 
		 
	}


	
	
    // below we were getting the value and checking if key is null or value is null based on the we were throwing and error.
	// Below code is not being used after reading config file into HashMap.
	//public static String getValue(String key) throws Exception
	//{
		//String value="";
		//Properties property=new Properties();
		//FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Config/config.properties");
		//property.load(file);
		//value=property.getProperty(key);
		//if(value==null)
	//	if(property.getProperty(key) == null || Objects.isNull(key))
		//{
		//	throw new Exception("The key "+key+"is not found,Please check the config file");
		//}
		//return value;
	//	return property.getProperty(key);
	//}
	
}

