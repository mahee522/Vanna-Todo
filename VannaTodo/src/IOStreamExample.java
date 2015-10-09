import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class IOStreamExample {

	public static void main(String[] args) throws IOException {
		//File f=new File();
		FileInputStream fis=new FileInputStream("C:/Users/MAHI/Desktop/vanna/VannaTodo/src/Myfile.txt");
		/*int x=0;
		@SuppressWarnings("resource")
		FileOutputStream fos=new FileOutputStream("C:/Users/MAHI/Desktop/vanna/VannaTodo/src/Mynewfile.txt");
		while((x=fis.read())!=-1)
		{
			System.out.print((char)x);
			
			fos.write((byte)x);
			
		}*/
		
		/*FileInputStream fis1=new FileInputStream("C:/Users/MAHI/Desktop/vanna/VannaTodo/src/Mynewfile.txt");
		SequenceInputStream sis=new SequenceInputStream(fis,fis1);
		int i;
		while((i=sis.read())!=-1)
		{
			System.out.print((char)i);
		}
		 */
		FileReader fr=new FileReader("C:/Users/MAHI/Desktop/vanna/VannaTodo/src/Mynewfile.txt");
		
		int i,j=0;
		char[] ch=new char[100000];
		
		while((i=fr.read())!=-1)
		{
			ch[j]=(char)i;
			System.out.print((char)i);
			j++;
		}
		String s1String=ch.toString();
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		//System.out.println("\nWhich word do you want to change");
		//String change=sc.next();
		
		System.out.println("\nEnter new word");
		String change1=sc.next();
		
		//String find="";
		/*for(int k=0;k<s1String.length();k++)
		{char ch1=s1String.charAt(i);
			if(ch1!=' ')
			{
				find=find+ch1;
				if(find==change)
				{
					s1String.replace("change", "change1");
					System.out.println(s1String);
				}
			}
				
		}*/
		
		
				System.out.println(s1String.replace("java",change1));
	}

}
