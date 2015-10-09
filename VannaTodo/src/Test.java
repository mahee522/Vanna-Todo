
public class Test {

	static int s;
	public static void main(String[] args) {
		int x=0;
		int y=0;
		for (int z = 0; z <5; z++) 
		{
			if ((++x>2)&&(++y>2)) 
			{
				x++;
			}
		}
		System.out.println(x+" "+y);
		
		/*Test test=new Test();
		test.start();
		System.out.println(s);*/

	}
	/*void start()
	{
		int x=7;
		twice(x);
		System.out.println(x+" ");
	}
	void twice(int x)
	{
		x=x*2;
		s=x;
	}
*/
}
