package com.adjustSwaggerPetstore.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties config;
	public ConfigDataProvider(){
		File src = new File("./Config/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			config = new Properties();
			config.load(fis);
		} catch (Exception e) {
			System.out.println("Unable to load properties file "+e.getMessage());
		}
	}
	
	public String getDataFromConfig(String keyToSearch){
		return config.getProperty(keyToSearch);
	}
	
	public String getBrowser(){
		System.out.println(config.getProperty("Browser"));
		return config.getProperty("Browser");
	}
	
	public String getAppUrl(){
		return config.getProperty("qaUrl");
	}

}
