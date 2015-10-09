
public class ConvertInt {
public static void main(String[] args) {
	String s="2";
	System.out.println("String type int value: "+s);
	int i=Integer.parseInt(s);
	System.out.println("with parse int method: "+i);
	
	int t=Integer.valueOf(s);
	System.out.println("with valuOf() method "+t);
	
	char ch[]=s.toCharArray();
	for(int k=0;k<ch.length;k++)
	{
		int p=(int)ch[k];
		System.out.println(p);
	}
	
}
}
