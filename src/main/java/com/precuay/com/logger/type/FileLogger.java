package com.precuay.com.logger.type;

import com.precuay.com.logger.Log;
import com.precuay.com.logger.configuration.PropertiesFacade;
import com.precuay.com.logger.dao.FileLogDao;
import com.precuay.com.logger.dao.LogDao;

public class FileLogger extends LoggerAbstract {
	
	private LogDao fileLogDao;
	
	public FileLogger(final PropertiesFacade propertiesFacade, final String enabledKey) {
		super(propertiesFacade, enabledKey);
	}
	
	public void initialize() {
		this.stringTrace = "--FILE-- ";
		fileLogDao  = new FileLogDao();
		
		System.out.println("FileLogger initialized");
		
	}

	public void log(final String txt) {
		Log log = new Log();
		log.setType(this.stringTrace);
		log.setText(txt);
		fileLogDao.insertLog(log);
	}

}
