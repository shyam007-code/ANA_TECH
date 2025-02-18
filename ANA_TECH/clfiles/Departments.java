package clfiles;
import java.util.*;

public class Departments extends ANA
{
	protected String department_name;
	protected List<subfield> subfields;
	
	public Departments(String department_name)
	{
		this.department_name=department_name;
		this.subfields=new ArrayList<>();
	}
	public void addsubfield(subfield subfield) {
		subfields.add(subfield);
	}
	public List<subfield>getsubfield(){
		return subfields;
		
	}
	public String getdept()
	{
		return department_name;
	}
}
