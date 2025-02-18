package clfiles;
import java.util.*;
public class subfield {
private String subfield_name;
private List<employee_details> Employees;
  public subfield(String subfield_name)
  {
	  this.subfield_name=subfield_name;
	  this.Employees=new ArrayList<>();
  }
  public void add_employee(employee_details staff)
  {
	  Employees.add(staff);
  }
  public List<employee_details> getstaff(){
	  return Employees;
  }
  public String getsubfield_name() {
	  return subfield_name;
  }
}
