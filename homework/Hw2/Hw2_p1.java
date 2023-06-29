
import java.util.Scanner;
import java.io.*;

public class Hw2_p1 {

	static class Employee {
		private String name;
		private float salary;
		public Employee() {}
		
		public Employee(String n, float s) {
			name = n;
			salary = s;
		}
		
		public String getName() {return name;}
		public float getSalary() {return salary;}
		public void setName(String n) {name = n;}
		public void setSalary(float s) {salary = s;}
	
		public String toString() {
			String s = new String();
			s = s + "\tName = " + name;
			s = s + "\tSalary = " + salary;
			return s;
		}
	}

	

	public static int salaryBetween(Employee[] a, double low, double high) {


		int count = 0;   
		float largest = 0;  
		float lowest = 0;  
		float summ = 0;

		System.out.println("\nAll employees with salary between " + low + " and " + high);
		System.out.println();// this line to make a gap 

		for (Employee e : a) { 
			if (lowest == 0 || lowest > e.salary) { lowest = e.salary; } 
			if (largest == 0 || e.salary > largest) { largest = e.salary; } 
			if (e.salary >= low && e.salary <= high ) { System.out.println(e); count ++; } 
			summ = summ + e.salary;                                              
		}
		
		System.out.println();
		System.out.println("lowest salary = " + lowest); 
		System.out.println("Highest salary = " + largest); 
		System.out.println("Average salary = " + summ/a.length);  
		return count;
	}
	
	public static void main(String[] args) throws IOException {

		int numEmp = 10;
		Employee[] empArray = new Employee[numEmp];


		try {
			File myObj = new File("C:\\Users\\ikarg\\Desktop\\Work\\java_projects\\untitled\\src\\text.txt");
			int count = 0 ;
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			empArray[count] = new Employee(data.substring(0, data.indexOf(" ")-1), Float.parseFloat(data.replaceAll("[^0-9]", "")));
			count += 1;
			}

      		myReader.close();
		  } catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		  }

		System.out.println("\nAll employees\n");
		for (Employee e: empArray) { 
			System.out.println(e);
		}
		
		double low = 20000;
		double high = 30000;
		
		int numSalaryBetween = salaryBetween(empArray, low, high);
		
		System.out.println("\nNumber of employees with salary between " + low + 
		 		           " and " + high + " = " + numSalaryBetween);

	}
}









