package clfiles;
import java.io.Serializable;
public class employee_details implements Serializable {
	private static final long serialVersionUID = 1L;
    private String emp_name;
	private int id;
	private String department_name;
	private String subfield_name;
	public employee_details(String emp_name,int id,String department_name,String subfield_name) {
		this.emp_name=emp_name;
		this.id=id;
		this.department_name=department_name;
		this.subfield_name=subfield_name;
		
	}
	 public String getname() {
		 return emp_name;
		 
	}
	 public int getid() {
		 return id;
	 }
	 public String getdepartment() {
		 return department_name;
		 
	 }
	 public String getsubfield() {
		 return subfield_name;
		 
	 }
	 public String toString() {
		 return "Employee Details: \n"+"EMPLOYEE NAME:"+emp_name+"\n EMPLOYEE ID:"+id+"\n DEPARTMENT_NAME:"+department_name+"\n SUBFIELD_NAME:"+subfield_name;
		 
	 }
	

}
