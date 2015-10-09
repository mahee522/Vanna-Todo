
public class AbstractConstruct{

	public static void main(String[] args) {
		Server s=new Tomcat("Apache Tomcat");
		s.start();

	}

}
abstract class Server
{
	protected final String name;
	public Server(String name)
	{
		this.name=name;
	}
	public abstract boolean start();
}
class Tomcat extends Server
{
 public Tomcat(String name) {
		super(name);
	}
	@Override
	public boolean start() {
		System.out.println(this.name+" Started successfully");
		return true;
	}
	
}