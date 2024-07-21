package com.oke.league;

import java.sql.Connection;

public class Main {
	static DBHandler database = new DBHandler(); 
	static Connection conn;
	
    public static void main( String[] args )
    {
    	conn = database.createConnection();
    	
    	System.out.println("Closing database in 3..2..1..");
    	
    	database.closeConnection(conn);
    }
}
