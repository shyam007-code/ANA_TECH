package src;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import clfiles.subfield;
import clfiles.*;


public class Main_app {
	private static List<employee_details> employeeList=new ArrayList<>();
	private static final String FILE_NAME="employee.dat";
	private static List<Departments> departments=new ArrayList<>();
    public static void main(String[] args) {
		initialize_Departments();
		loadFromFile();
		Scanner scanner=new Scanner(System.in);
		int choice;
		do {
			System.out.println("\n ---ANA Technologies Employee Management ---");
			System.out.println("1.Add Employee");
			System.out.println("2.Search Employee");
			System.out.println("3.Exit");
			System.out.println("Enter your choice:");
		while(!scanner.hasNextInt()) {
			System.out.print("please enter a valid number");
			scanner.next();
			
		}
		choice=scanner.nextInt();
		switch(choice) {
		case 1:
			addEmployee(scanner);
			break;
			
		case 2:
			searchEmployee(scanner);
			break;
		case 3:
			saveToFile();
			System.out.println("exiting the prgram.Goodbye!");
			break;
		default:
			System.out.println("Invalid choice! Please select again.");
			
		}
		
		
			}
		while (choice != 3);
		scanner.close();
		
		
	}
	private static void initialize_Departments() {
		Departments dep1 =new FINANCE();  //subfields and department class 
		dep1.addsubfield(new subfield("accounts"));
		dep1.addsubfield(new subfield("payroll"));
		dep1.addsubfield(new subfield("finance"));
		Departments dep2 =new IT();
		dep2.addsubfield(new subfield("Java"));
		dep2.addsubfield(new subfield(".net"));
		dep2.addsubfield(new subfield("Python"));
		Departments dep3 =new ITES();
		dep3.addsubfield(new subfield("devops"));
		dep3.addsubfield(new subfield("support"));
		dep3.addsubfield(new subfield("CSR"));
		
		departments.add(dep1);
		departments.add(dep2);
		departments.add(dep3);
		
	}
	private static void addEmployee(Scanner scanner) {
		scanner.nextLine();
		
		System.out.println("Enter Employee name:");
		String name=scanner.nextLine();
		int id;
		while(true) {
		System.out.println("Enter Employee ID:");
		if(scanner.hasNextInt()) {
			id=scanner.nextInt();
			scanner.nextLine();
			break;
			
		}
		else
		{
			System.out.println("Invalid Id.please enter a numeric value");
			scanner.next();
			
		}
	}
	System.out.println("Select department");
	for(int i=0;i<departments.size();i++)
	{
		System.out.println((i+1)+"."+departments.get(i). getdept());
		
	}
	int deptchoice=getUserChoice(scanner,departments.size());
	Departments selectedDept=departments.get(deptchoice - 1);
	System.out.println("select subfield in"+selectedDept.getdept()+":");
	List<subfield> subfields=selectedDept.getsubfield();
	for(int i=0;i<subfields.size();i++) {
		System.out.println((i+1)+"."+subfields.get(i).getsubfield_name());
		
		
	}
	int subfieldchoice=getUserChoice(scanner,subfields.size());
	subfield selectedsubfield=subfields.get(subfieldchoice - 1);
    employee_details emp=new employee_details(name,id,selectedDept.getdept(),selectedsubfield.getsubfield_name());
    employeeList.add(emp);
    selectedsubfield.add_employee(emp);
    System.out.println("Employee added sucessfully!");
	}
	private static void searchEmployee(Scanner scanner) {
		System.out.println("Search by (1) Name or (2) ID? Enter choice:");
		int choice=getUserChoice(scanner,2);
		boolean found=false;
		if(choice==1)
		{
		System.out.println("Enter Employeee Name to search:");
		scanner.nextLine();
		String name=scanner.nextLine();
		
		for (employee_details emp : employeeList) {
			if (emp. getname().equalsIgnoreCase(name)) {
				System.out.println("\n" +emp+".");
				found= true;
				
				
			}
			
		}
	}else{
		System.out.print("Enter employee ID to search:");
		int id =scanner.nextInt();
		scanner.nextLine();
		for ( employee_details emp : employeeList) {
			if(emp.getid()==id) {
				System.out.println("\n"+emp);
				found=true;
				
			}
		}
			
	}
	if(!found) {
		System.out.println("Employee not found");
		
	 }
 }
	private static int getUserChoice(Scanner scanner,int maxOption) {
		int choice;
		while(true) {
			System.out.print("Enter your choice(1-"+maxOption+"):");
			if (scanner.hasNextInt()) {
				choice=scanner.nextInt();
				scanner.nextLine();
				if(choice>=1 && choice<=maxOption) {
					break;
				}
				else {
					System.out.println("Invalid choice. Please select a number between 1 and "+maxOption+".");
					
				}
			}
				else {
					System.out.println("Invalid input.please enter a numeric value.");
					scanner.next();
					
				}
			}
			return choice;
		}
		private static void saveToFile() {
			
		try( ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(FILE_NAME)))
		{
			oos.writeObject(employeeList);
			System.out.println("Employee data saved successfully");
			oos.close();
			
		}
		catch(IOException e) {
			System.out.println("Error Saving data:"+e.getMessage());
			
		}
		
		}
		@SuppressWarnings("unchecked")
		private static void loadFromFile() {
			File file=new File(FILE_NAME);
			if (!file.exists()) {
				return;
			}
			try{ObjectInputStream ois=new ObjectInputStream(new FileInputStream(FILE_NAME)); 
			   employeeList=(List<employee_details>) ois.readObject();
				System.out.println("Employee data loaded successfully.");
				ois.close();
			}catch(IOException |ClassNotFoundException  e) {
				System.out.println("Error loading data:"+e.getMessage());
			}
		}
		
	}
    
	
    


