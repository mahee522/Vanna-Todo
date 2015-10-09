
public class Pass {

	public static void main(String[] args) {
	
		Pass p=new Pass();
		p.start();

	}
	void start()
	{
		String s1="slip";
		String s2=fix(s1);
		System.out.println(s1+"  "+s2);
	}
	String fix(String s1)
	{
		s1=s1+"stream";
		System.out.println(s1+" ");
		return "stream";
		
	}

}
