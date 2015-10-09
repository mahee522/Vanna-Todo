import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ListDateSort {
	String name;
	int id;
	Date date;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
public static void main(String[] args) {
	ListDateSort lds=new ListDateSort("aaa",12,12/12/2012);
	List li=new ArrayList();
}
}
