
public class WrapperTest2 {

	public static void main(String[] args) {
		/*Boolean bool1= new Boolean(true);
		Boolean bool2=new Boolean(false);
		Boolean bool3=new Boolean(false);
		Boolean bool4=new Boolean(bool1);
		System.out.println(bool1.equals(bool4));
		System.out.println(bool2==bool3);
		System.out.println(bool1==bool4);
		*/
		int i,j=1;
		i=(j>1)?2:1;
		switch (i) {
		case 0:
			System.out.println(0);
			break;
		case 1:
			System.out.println(1);
		case 2:
			System.out.println(2);
			break;
		case 3:
			System.out.println(3);
			break;

		}
		

	}

}
