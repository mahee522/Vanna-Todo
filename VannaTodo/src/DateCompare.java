import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateCompare {

	public static void main(String[] args) {
		DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("Comparing two dates with comapreTo method");
		Date d=new Date(12-06-1991);
		Date d1=new Date(16-03-2010);
		
		System.out.println(d.compareTo(d1));
		
		Calendar cl=Calendar.getInstance();
		
		Calendar cl2=Calendar.getInstance();
		cl.setTime(d);
		cl2.setTime(d1);
		System.out.println(cl.equals(cl2));

	}

}
