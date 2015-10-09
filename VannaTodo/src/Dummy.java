
public class Dummy {

	public static void main(String[] args) {
		java.util.Date date = new java.util.Date();
	      long t = date.getTime();
	      System.out.println(t);
	      java.sql.Date sqlDate = new java.sql.Date(t);
	     // java.sql.Time sqlTime = new java.sql.Time(t);
	      //java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(t);
	      System.out.println("sqlDate=" + sqlDate);
	      //System.out.println("sqlTime=" + sqlTime);
	      //System.out.println("sqlTimestamp=" + sqlTimestamp);
	      

	}

}
