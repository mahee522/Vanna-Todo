
public class MyRunnable implements Runnable {

	@Override
	public void run() {
		
	System.out.println("this is run method");	
	}
	public static void main(String[] args) {
		new Thread(new MyRunnable()).start();
		/*new MyRunnable().start();
		new Thread(MyRunnable).run();
		new Runnable(MyRunnable).start();*/
	}

}
