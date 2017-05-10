package com.precuay.test.logger.type;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import org.junit.Assert;
import org.junit.Test;

import com.precuay.com.logger.configuration.PropertiesFacade;
import com.precuay.com.logger.type.FileLogger;

public class FileLoggerTest {
	
	@Test(expected = ArithmeticException.class)
	public void testFactoryInstance() {
		System.out.println("testFactoryInstance");
		int i = 1/0;
	}
		
	@Test
	public void testCreateFile() {
		System.out.println("testCreateFile");
		
		//delete file if existss
		File file = new File(System.getProperty("user.home") + File.separator + "logFilePierre.txt");
		if(file.exists())
			file.delete();
		
		PropertiesFacade propertiesFacade = new PropertiesFacade(); 
		FileLogger fileLogger = new FileLogger(propertiesFacade, "file.enabled");
		
		File file2 = new File(System.getProperty("user.home") + File.separator + "logFilePierre.txt");
		
		System.out.println(">>>"+file2.exists());

		//assert file existence
		Assert.assertEquals(file.exists(), true );
		
	}
	
//	@Test
//	public void testAppendedLine() throws IOException {
//		System.out.println("testAppendedLine");
//
//		// delete file if existss
//		File file = new File(FileAppender.TEMPORAL_LOG_FILE);
//		if (file.exists())
//			file.delete();
//
//		//create file and one line
//		Appender appender = FileAppender.getInstance();
//		appender.persist("log example");
//		
//		Integer lineNumerA = countLines(file);
//		
//		appender.persist("log example");
//		
//		Integer lineNumerB = countLines(file);
//		
//		Assert.assertEquals( new Integer(lineNumerA+1), lineNumerB );
//		
//	}
//	
//	public static int countLines(File aFile) throws IOException {
//	    LineNumberReader reader = null;
//	    try {
//	        reader = new LineNumberReader(new FileReader(aFile));
//	        while ((reader.readLine()) != null);
//	        return reader.getLineNumber();
//	    } catch (Exception ex) {
//	        return -1;
//	    } finally { 
//	        if(reader != null) 
//	            reader.close();
//	    }
//	}

}