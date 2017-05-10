package com.precuay.com.logger.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.precuay.com.logger.LoggerEngine;

public class PropertiesFacade {
	
	private final String CONFIG_FILE = "configuration.properties";
	private Properties properties;
	
	public PropertiesFacade() {
		try {

			InputStream input = LoggerEngine.class.getClassLoader().getResourceAsStream(CONFIG_FILE);

			// load a properties file from class path, inside static method
			properties = new Properties();
			properties.load(input);


		} catch (IOException ex) {
			throw new RuntimeException("Fatal error loading properties file"); 
		}
	}

	public String getString(final String key) {
		return (String)properties.get(key);
	}
	
	public boolean getBoolean(final String key) {
		return Boolean.parseBoolean((String)properties.get(key));
	}
}
