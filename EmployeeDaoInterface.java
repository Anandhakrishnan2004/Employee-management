package Employee_app;

/**
 * @author Hridya
 *
 */
public interface EmployeeDaoInterface {

//	CRUD Operations to be performed
//	Module 1 create employee
	public void createEmployee(Employee emp);

//	Module 2 show all employee
	public void showAllEmployee();

//	Module 3 show employee based on id 
	public void showEmployeeBasedOnID(int id);

//	Module 4 update employee
	public void updateEmployee(int id, String name, double salary , int age);

//	Module 5 delete employee
	public void deleteEmployee(int id);

}
