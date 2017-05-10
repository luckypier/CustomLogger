package com.precuay.com.logger.type;

import java.util.Properties;

import com.precuay.com.logger.configuration.PropertiesFacade;

/**
 * Superclass for Logger implementations
 * @author Pierre Recuay
 *
 */
public abstract class LoggerAbstract {
	
	protected PropertiesFacade propertiesFacade;
	
	protected boolean enabled = true;
	
	protected String stringTrace;
	
	public LoggerAbstract(final PropertiesFacade propertiesFacade, final String enabledKey){
		
		this.propertiesFacade = propertiesFacade;
		setEnabled(propertiesFacade.getBoolean(enabledKey));
		
		//only initialize if its enabled
		if(isEnabled())
			initialize();
		
	}
	
	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public abstract void initialize();
	
	public abstract void log(final String txt);
}
