package Employee_app;
import java.util.Scanner;

/**
 * @author Hridya
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
//object is created
		EmployeeDaoInterface dao = new EmployeeDao();

		System.out.println("                 \tWelcome to - Employee Management App\n");
		//scanner class for input
		Scanner sc = new Scanner(System.in);
		do {

			System.out.println(" \n " + "Enter password for admin-login");
			String response = sc.next();
			if (response.equalsIgnoreCase("admin")) {

				do {
					//interface of application
					System.out.println(
							"\n " + "1. Add Employee" + "\n 2. Show All Employee" + "\n 3. Show Employee based on id"
									+ "\n 4. Update the employee" + "\n 5. Delete the employee\n");

					System.out.println(" Enter Choice !");
					int ch = sc.nextInt();
					
					//Switch statement is used in order to use different module of the application
					switch (ch) 
					//Module 1 in order add a new employee details 
					{
					case 1:
						Employee emp = new Employee();

						System.out.println("\n Enter ID : ");
						int id = sc.nextInt();

						System.out.println("\n Enter Name : ");
						String name = sc.next();

						System.out.println("\n Enter Salary : ");
						double salary = sc.nextDouble();

						System.out.println("\n Enter age : ");
						int age = sc.nextInt();

						emp.setId(id);
						emp.setName(name);
						emp.setSalary(salary);
						emp.setAge(age);
						dao.createEmployee(emp);
						break;
						//Break statement is used , which will take the control over to the switch statement.
					
						//Module 2 in order to display all employee details
					case 2:
						dao.showAllEmployee();
						break;
						//Break statement is used , which will take the control over to the switch statement.
					
						//module 3 in order to display employee details based on the employee id
					case 3:
						System.out.println("Enter id to show the details : ");
						int empid = sc.nextInt();
						dao.showEmployeeBasedOnID(empid);
						break;
						//Break statement is used , which will take the control over to the switch statement.
					
						//module 4 in order to update the employee details
					case 4:
						System.out.println("Enther the employee id to update details : ");
						empid = sc.nextInt();

						System.out.println(" Enter the new ID : ");
					    id = sc.nextInt();
						System.out.println("Enter the new name :");
						name = sc.next();
						System.out.println("Enter the new Salary :");
						salary = sc.nextDouble();
						System.out.println("Enter the new age :");
						age = sc.nextInt();
						dao.updateEmployee(id, name, salary, age);
						break;
						//Break statement is used , which will take the control over to the switch statement.
					
						//module 5 in order to delete the employee details
					case 5:
						System.out.println("\n Enter the employee ID to Delete");
						empid = sc.nextInt();
						dao.deleteEmployee(empid);
						break;
						//Break statement is used , which will take the control over to the switch statement.
					default:
						System.out.println("Enter valid choice !");
						break;
						//Break statement is used , which will take the control over to the switch statement.
					}

				} while (true);
			}
			
			else {
				System.out.println("\n Invalid Entry \n ");
			}
		} while (true);
	}

}
