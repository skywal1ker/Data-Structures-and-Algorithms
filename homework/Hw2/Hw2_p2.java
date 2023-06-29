
import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;

public class Hw2_p2 {

	static class Employee {

		private String name;
		private float salary;
		
		public Employee() {
		
		}
		
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

	      /** 
   * @param input  = linkedlist of objects, low range and high range
   * This method calculates largest, lowest and average salaries, given range
   * @return //return count of employees with salary between range
   */ 

	public static int salaryBetween(LinkedList<Employee> employees, float low, float high) {

		
		//name of variable count
		//variable used for counting employees salary between 70,000 and 100000
		int count = 0;

		//name of largest salary variable 
		//used to save the highest salary
		float largest = 0; 

		//name of lowest salary variable 
		//used to save the lowest salary
		float lowest = 0;   

		//name of SUM variable 
		//used to save the SUM Salary of ALL Employees
		float summ = 0;      

		System.out.println("\nAll employees with salary between " + low + " and " + high);
		System.out.println(); // this line to make a gap 

		//Calculating Employees data with for loop with if statements
		for (int i = 0; i < employees.size(); i++) { 




			//using lowest variable
			//using if statement below to find lowest value of salari in the list
			if (lowest == 0 || lowest > employees.get(i).salary) { lowest = employees.get(i).salary; } 



			//using largest variable
			//using if statement below to find largest value of salari in the list
			if (largest == 0 || employees.get(i).salary > largest) { largest = employees.get(i).salary; } 


			//using low and high input of method in if condition
			//checking if Employee Salary is in range
			//increminting count if condition true
			if (employees.get(i).salary >= low && employees.get(i).salary <= high ) {  
				count ++;
				System.out.println(employees.get(i)); }


			//total salary sum of all employees
			summ = summ + employees.get(i).salary;                                

		}

		System.out.println();
		
		// printing lower salary
		System.out.println("lowest salary = " + lowest);

		//printing largest salary
		System.out.println("Highest salary = " + largest);

		// calculating average salary of employees 
		System.out.println("Average salary = " + summ/employees.size());  

		//return count of employees with salary between range
		return count;
	}
	
	public static void main(String[] args) throws IOException {

		LinkedList<Employee> empList = new LinkedList<>();
		
		// write a code segment here that reads input file and adds all employees
		try {

			//here to create file object
			File myObj = new File("employee_info.txt");

			//here to scan file
			Scanner myReader = new Scanner(myObj);

			//here I used while loop, it will be itearate untill data finished in the file that connected to read
			while (myReader.hasNextLine()) {
			String data = myReader.nextLine();         


			// this part to filling empty linkedlist
			// here i used method that grabs only string value, substring range and indexof 
			// but on the second part I used regular expression that allows grab only digits  
			empList.add(new Employee(data.substring(0, data.indexOf(" ")-1), Float.parseFloat(data.replaceAll("[^0-9]", ""))));
			}

			// after reading we need close the file
            myReader.close();
		  } catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		  }

		// print all employees in the empArray
		System.out.println("\nAll employees\n");
		for (Employee e: empList) {
			System.out.println(e);
		}
		
		// set low and high
		// test with different values
		float low = 70000;
		float high = 100000;
		
		// // invoke salaryBetween method
		int numSalaryBetween = salaryBetween(empList, low, high);
		
		System.out.println("\nNumber of employees with salary between " + low + 
		 		           " and " + high + " = " + numSalaryBetween);

	}
}




