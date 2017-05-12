package DBControl;

import java.sql.SQLException;
import java.sql.Statement;

public class DBCreate {

	public static void create() throws ClassNotFoundException, SQLException
	{
		 Statement stmt = DBConnection.getDBConnection().getConnection().createStatement();
	      String sql = "CREATE TABLE Server " +
	                   "(ID INTEGER PRIMARY KEY  AUTOINCREMENT     NOT NULL," +
	                   " nom           TEXT  UNIQUE   NOT NULL, " + 
	                   " dispo           TINYINT    NOT NULL, " + 
	                   " ip            char(15)     NOT NULL)"; 
	                   
	      stmt.executeUpdate(sql);
	      stmt.close();
	       stmt = DBConnection.getDBConnection().getConnection().createStatement();
	       sql = "CREATE TABLE Sound " +
	                   "(id INTEGER PRIMARY KEY AUTOINCREMENT    NOT NULL," +
	                   " titre           char(250)    , " +
	                   " artiste           char(250)    , " +
	                   " album           char(250)    , " +
	                   " cover           TEXT    , " +
	                   " url           TEXT    , " +
	                   " idserver INT)"; 
	                   
	      stmt.executeUpdate(sql);
	      stmt.close();
	}
	
	public static void main( String args[] ) throws ClassNotFoundException, SQLException
	  {
		DBCreate.create();
	}
}
