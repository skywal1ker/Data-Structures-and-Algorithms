import java.util.Scanner;
import java.io.*;


public class Hw3 {

	static class Employee {

		private String name;
		float salary;
		
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
	
	public static void main(String[] args) {

	    MyLinkedList<Employee> empList = new MyLinkedList<>();
	    MyLinkedList.Node<Employee> aNode = null;
	    MyLinkedList.Node<Employee> cursor = null;
	          try {
	        	  
	        	  /**
	        	   * Adds an element to the end of the list.
	        	   * @param myReader -- .txt file path
	        	   * @param data -- to read each line until the end
	        	   * @param e -- employee object
	        	   */
	        	  
	        	  // This part will be open the .txt file 
	        	  //If it is not opening, please try put here whole path to the .txt file. like this ("C:\\Users\\ikarg\\eclipse-workspace\\Hw3\\src\\employee_info.txt")
	              Scanner myReader = new Scanner(new File("C:\\\\Users\\\\ikarg\\\\eclipse-workspace\\\\Hw3\\\\src\\\\employee_info.txt"));
	              while (myReader.hasNextLine()) {
	              String data = myReader.nextLine();   
	              
	              //this part to add value and create object from the txt file to our object, 
	  			// here i used method that grabs only string value, substring range and indexof 
	  			// but on the second part I used regular expression that allows grab only digits   
	              Employee e = new Employee(data.substring(0, data.indexOf(" ")-1), Float.parseFloat(data.replaceAll("[^0-9]", ""))); 

	         //Here it add the first element o
	          if (empList.isEmpty())  {empList.addFirst(e);}
	        //Here it will add the last element
	          else if(empList.size == 1 && empList.head.getElement().getSalary() < e.getSalary()) {empList.addLast(e); }
	  
	          
	          else {
	        	  /**
	        	   * Adds an element to the end of the list.
	        	   * @param aNode -- Node element that should be first
	        	   * @param cursor -- Node element that comes after aNode
	        	   */
	        	  
	        	  
	        	//this is for before 
	            aNode = empList.head;
	          //this is for after 
	            cursor = empList.head.getNext(); 

	            // if value most biggest or lowest, it will add on the top and tail accordingly 
	            if (empList.tail.getElement().getSalary() < e.getSalary()) {empList.addLast(e);}
	            else if (aNode.getElement().getSalary() > e.getSalary() ) {empList.addFirst(e);}
	            
	            //this part for detect the right place , 
	            //here I used while loop to compare eSalary with cursor element,
	            // if it is true, eSalary more than cursor's salary, it will switch to the next element(node to the cursor, cursor to the next element) and then will add addbetween if cursor e less than cursor. 
	            else {while(e.getSalary() > cursor.getElement().getSalary()){aNode = cursor; cursor = cursor.getNext();} empList.addBetween(aNode, cursor, e);}
          

	      }
	            
	          }
	         // after reading we need close the file
	        myReader.close(); } catch (FileNotFoundException x) { System.out.println("An error occurred."); x.printStackTrace(); }
	          
	        //Here I printed final result 
	        System.out.println();
	        System.out.println("\tAll employees in the linked list:");
	        System.out.println();
	        System.out.println(empList);
	      
	      
	      }
}
