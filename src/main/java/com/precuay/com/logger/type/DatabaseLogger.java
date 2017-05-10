package com.precuay.com.logger.type;

import com.precuay.com.logger.Log;
import com.precuay.com.logger.configuration.PropertiesFacade;
import com.precuay.com.logger.dao.DatabaseLogDao;
import com.precuay.com.logger.dao.LogDao;

public class DatabaseLogger extends LoggerAbstract {
	
	private LogDao databaseLogDao; 
	
	public DatabaseLogger(final PropertiesFacade propertiesFacade, final String enabledKey) {
		super(propertiesFacade, enabledKey);
	}
	
	public void initialize() {
		this.stringTrace = "---DB--- ";
		databaseLogDao  = new DatabaseLogDao(propertiesFacade);
		
		System.out.println("DatabaseLogger initialized");
		
	}

	public void log(final String txt) {
		Log log = new Log();
		log.setType(this.stringTrace);
		log.setText(txt);
		databaseLogDao.insertLog(log);
	}
	

}
