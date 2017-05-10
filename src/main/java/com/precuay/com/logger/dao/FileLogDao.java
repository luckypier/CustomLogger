package com.precuay.com.logger.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import com.precuay.com.logger.Log;

public class FileLogDao implements LogDao {

	private File file;
	private FileWriter fstream;

	public FileLogDao() {

		try {
			String filePath = System.getProperty("user.home") + File.separator + "logFilePierre.txt";
			file = new File(filePath);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public synchronized void insertLog(final Log log) {
		
		StringBuffer sb = new StringBuffer();
		sb.append(log.getType());
		sb.append(log.getText());

		try {
			fstream = new FileWriter(file, true);
			BufferedWriter fbw = new BufferedWriter(fstream);
			fbw.write(sb.toString());
			fbw.newLine();
			fbw.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public String getLastLog() {
		// TODO Auto-generated method stub
		return null;
	}

}
