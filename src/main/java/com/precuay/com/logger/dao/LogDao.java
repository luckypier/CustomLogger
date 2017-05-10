package com.precuay.com.logger.dao;

import java.text.SimpleDateFormat;

import com.precuay.com.logger.Log;

public interface LogDao {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public void insertLog(final Log log);
	
	public String getLastLog();

}
