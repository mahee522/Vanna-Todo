import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class TimeDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String t="12 12 2014";
		String t1="12 12 2012";
		SimpleDateFormat sdf=new SimpleDateFormat("dd MM yyyy");
		System.out.println("Welcome");
		try
		{
			Date d1=sdf.parse(t);
			Date d2=sdf.parse(t1);
			long diff=d1.getTime()-d2.getTime();
			System.out.println("Difference in Days "+TimeUnit.DAYS.convert(diff, TimeUnit.MICROSECONDS));
		}
		catch(Exception e)
		{
			e.getStackTrace();
			
		}
	}

}
