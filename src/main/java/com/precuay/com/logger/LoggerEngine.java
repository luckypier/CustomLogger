package com.precuay.com.logger;

import java.util.ArrayList;
import com.precuay.com.logger.configuration.PropertiesFacade;
import com.precuay.com.logger.type.ConsoleLogger;
import com.precuay.com.logger.type.LoggerAbstract;
import com.precuay.com.logger.type.DatabaseLogger;
import com.precuay.com.logger.type.FileLogger;

/**
 * This is the facade class for the logging functionality.
 * 
 * By default console, text file and database are active. The last ones create these files in user.home directory :
 * - logFilePierre.txt
 * - logDbPierre.mv.db
 *   
 * For more configuration settings see configuration.properties file. 
 * 
 * @author Pierre Recuay
 * 
 */
public class LoggerEngine {

	private static LoggerEngine instance;
	private PropertiesFacade propertiesFacade;
	
	private ArrayList<LoggerAbstract> loggerImpls;
	
	private boolean messageEnabled;
	private boolean warningEnabled;
	private boolean errorEnabled;
	
	private static final String CONFIG_CONSOLE_ENABLED = "console.enabled";
	private static final String CONFIG_FILE_ENABLED = "file.enabled";
	private static final String CONFIG_DB_ENABLED = "db.enabled";
	
	private static final String CONFIG_LEVEL_MESSAGE = "level.message.enabled";
	private static final String CONFIG_LEVEL_WARNING = "level.warning.enabled";
	private static final String CONFIG_LEVEL_ERROR = "level.error.enabled";

	private LoggerEngine() {
		
		propertiesFacade = new PropertiesFacade(); 
		
		loggerImpls = new ArrayList<LoggerAbstract>();
		
		loggerImpls.add(new ConsoleLogger(propertiesFacade, CONFIG_CONSOLE_ENABLED ));
		loggerImpls.add(new FileLogger(propertiesFacade, CONFIG_FILE_ENABLED ));
		loggerImpls.add(new DatabaseLogger(propertiesFacade, CONFIG_DB_ENABLED ));	
		
		messageEnabled = propertiesFacade.getBoolean(CONFIG_LEVEL_MESSAGE);
		warningEnabled = propertiesFacade.getBoolean(CONFIG_LEVEL_WARNING);
		errorEnabled = propertiesFacade.getBoolean(CONFIG_LEVEL_ERROR);
	}

	/**
	 * Thread safe Singleton
	 * @return LoggerEngine
	 */
	public synchronized static LoggerEngine getInstance() {
		if (instance == null) {
			instance = new LoggerEngine();
		}
		return instance;
	}
	
	private void log(final String txt) {
		
		for(LoggerAbstract impl : loggerImpls){
			if(impl.isEnabled())
				impl.log(txt);
		}
		
	}

	public void message(final String text) {
		if(messageEnabled)
			this.log(text);
	}

	public void warning(final String text) {
		if(warningEnabled)
			this.log(text);
	}

	public void error(final String text) {
		if(errorEnabled)
			this.log(text);
	}

}
