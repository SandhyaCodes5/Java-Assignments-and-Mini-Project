package myPackage;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.IOException;
class Employee{
	int id;
	String name;
	String department;
	int salary;
	Employee(int id, String name, String department, int salary){
		this.id=id;
		this.name=name;
		this.department=department;
		this.salary=salary;
	}
	public void displayInformation() {
		System.out.println("Display employee information");
		System.out.println("Employee id: " + id);
		System.out.println("Employee name: " + name);
		System.out.println("Employee department: " + department);
		System.out.println("Employee salary: " + salary);
	}
}
public class Main {
	public static void main(String[] args) {
		ArrayList<Employee> loadedList = new ArrayList<>();
	    try {
	    	FileWriter writer= new FileWriter("employee.txt");
	    	writer.write("101, Aman, Engineering, 39000\n");
	    	writer.write("102, Sita, Doctor, 46000\n");
	    	writer.write("103, Aaron, Business, 80000\n");
	    	writer.close();
	    	FileReader reader = new FileReader("employee.txt");
	    	BufferedReader br = new BufferedReader(reader);
	    	String line;
	    	while((line = br.readLine()) != null) {
	    		String[] data = line.split(",");
	    		int id = Integer.parseInt(data[0].trim());
	    		String name = data[1].trim();
	    		String department = data[2].trim();
	    		int salary = Integer.parseInt(data[3].trim());
	    		Employee emp = new Employee(id, name, department, salary);
	    		loadedList.add(emp);
	    	}
	    	br.close();
			for(Employee emp : loadedList) {
				emp.displayInformation();
			}
	    }
	    catch(NumberFormatException e) {
	    	System.out.println("Invalid employee data!");
	    }
	    catch(IOException e) {
	    	System.out.println("File error!");
	    }
	}
}
