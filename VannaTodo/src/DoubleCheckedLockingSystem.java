
public class DoubleCheckedLockingSystem {

}
class CreateSingleTonObject
{
	private CreateSingleTonObject instance;
	public CreateSingleTonObject getInstance()
	{
		if(instance==null)
		{
			synchronized (CreateSingleTonObject.class) {
				if(instance==null)
					instance=new CreateSingleTonObject();
			}
		}
		return instance;
		
	}
	public void disp()
	{
		System.out.println("Object is created");
	}
}