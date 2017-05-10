package com.precuay.com.logger.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

import com.precuay.com.logger.configuration.PropertiesFacade;

public class LogJdbc {
	
	PropertiesFacade propertiesFacade;
	
	protected Connection dbConnection;
	private static final String DB_DRIVER = "org.h2.Driver";
	protected static final String DB_FILE_PATH = "~/logDbPierre";
	private static final String DB_CONNECTION = "jdbc:h2:"+DB_FILE_PATH;
	private static final String CONFIG_DB_USER = "db.user";
	private static final String CONFIG_DB_PASSWORD = "db.password";
	
	public LogJdbc(PropertiesFacade propertiesFacade) {
		this.propertiesFacade = propertiesFacade;
	}
	
	public void getNewConnection() {
		this.dbConnection = null;
		try {
			Class.forName(DB_DRIVER);
			this.dbConnection = 
					DriverManager.getConnection(
							DB_CONNECTION, 
							propertiesFacade.getString(CONFIG_DB_USER), 
							propertiesFacade.getString(CONFIG_DB_PASSWORD));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
