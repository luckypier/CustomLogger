package com.precuay.com.logger.type;

import java.util.Properties;

import com.precuay.com.logger.configuration.PropertiesFacade;

public class ConsoleLogger extends LoggerAbstract {


	public ConsoleLogger(final PropertiesFacade propertiesFacade, final String enabledKey) {
		super(propertiesFacade, enabledKey);
		this.stringTrace = "CONSOLE- ";
	}

	public void initialize() {
		System.out.println("ConsoleLogger, no initialization needed");
		
	}
	
	public void log(String txt) {
		System.out.println(stringTrace+txt);
	}

}
