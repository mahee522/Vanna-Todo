import java.math.BigDecimal;


public class CurrencyRepresentInJava {

	public static void main(String[] args) {
		double d=2.15;
		double d1=1.10;
		System.out.println(d-d1);
		BigDecimal bd=new BigDecimal(2.15);
		BigDecimal bd1=new BigDecimal(1.10);
		System.out.println(bd.subtract(bd1));
	}

}
