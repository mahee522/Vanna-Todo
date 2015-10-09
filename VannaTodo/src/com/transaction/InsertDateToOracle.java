package com.transaction;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;

	public class InsertDateToOracle {
	  public static Connection getConnection() throws Exception {
	    String driver = "oracle.jdbc.driver.OracleDriver";
	    String url = "jdbc:oracle:thin:@localhost:1521:databaseName";
	    Class.forName(driver);
	    return DriverManager.getConnection(url, "userName", "password");
	  }

	  public static void main(String args[])throws Exception {
	    String INSERT_RECORD = "insert into TestDates(id, date_column, "
	        + "time_column, timestamp_column) values(?, ?, ?, ?)";
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    try {
	      conn = getConnection();
	      pstmt = conn.prepareStatement(INSERT_RECORD);
	      pstmt.setString(1, "001");

	      java.util.Date date = new java.util.Date();
	      long t = date.getTime();
	      java.sql.Date sqlDate = new java.sql.Date(t);
	      java.sql.Time sqlTime = new java.sql.Time(t);
	      java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(t);
	      System.out.println("sqlDate=" + sqlDate);
	      System.out.println("sqlTime=" + sqlTime);
	      System.out.println("sqlTimestamp=" + sqlTimestamp);
	      pstmt.setDate(2, sqlDate);
	      pstmt.setTime(3, sqlTime);
	      pstmt.setTimestamp(4, sqlTimestamp);
	      pstmt.executeUpdate();
	    } catch (Exception e) {
	      e.printStackTrace();
	      System.out.println("Failed to insert the record.");
	    } finally {
	      pstmt.close();
	      conn.close();
	    }
	  }
	}

