interface Count
{
	short counter=0;
	void countUp();
}

public class Program1 implements Count{
/*
	 void Program1() {
		System.out.println("Class program one");
	}*/

	public static void main(String[] args) {
		new Program1();
	}

	@Override
	public void countUp() {
		for (int x = 6; x <counter;x--,++counter) {
			System.out.println(" "+counter );
			
		}
		
	}

}
