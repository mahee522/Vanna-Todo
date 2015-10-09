
public class Traingle {

	public static void main(String[] args) {
		
		int c=0,n=15;
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=i;j++)
			{
				if(c!=n)
				{
					c++;
					System.out.print(c+" ");
				}
				else
				{
					break;
				}
				
			}
			System.out.println("\n");
		}

	}

}

/*select * from dept where emp_name='srikanth';
*/