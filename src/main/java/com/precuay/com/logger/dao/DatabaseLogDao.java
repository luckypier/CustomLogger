package com.precuay.com.logger.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.precuay.com.logger.Log;
import com.precuay.com.logger.configuration.PropertiesFacade;

public class DatabaseLogDao extends LogJdbc implements LogDao {
	
	public DatabaseLogDao(final PropertiesFacade propertiesFacade) {
		super(propertiesFacade);
		
		try {
			getNewConnection();
			
			this.dbConnection.setAutoCommit(false);
			Statement stmt = this.dbConnection.createStatement();
			
			//1
			stmt.execute("CREATE TABLE IF NOT EXISTS LOG(type varchar(10), text varchar(255))");
			
			stmt.close();
			this.dbConnection.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				this.dbConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void insertLog(Log log) {
		
		try {
			
			getNewConnection();
			
			this.dbConnection.setAutoCommit(false);
			Statement stmt = this.dbConnection.createStatement();
			
			//2
			stmt.execute(
					"INSERT INTO LOG(type, text) VALUES('"+log.getType()+"', '"+log.getText()+"')");
			
			//3
//			ResultSet rs = stmt.executeQuery("select * from LOG");
//			while (rs.next()) {
//				System.out.println(rs.getString("type") + rs.getString("text"));
//			}

			stmt.close();
			this.dbConnection.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				this.dbConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public String getLastLog() {
		// TODO Auto-generated method stub
		return null;
	}

}
