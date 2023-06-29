
public class Employee {

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
