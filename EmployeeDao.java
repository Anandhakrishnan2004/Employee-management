package Employee_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Hridya
 *
 */
public class EmployeeDao implements EmployeeDaoInterface {
Connection con;

@Override
	public void createEmployee(Employee emp) {
		con= DBConnection.createDBConnection();
		String query = "insert into employee values (?,?,?,?)";

		try {
			PreparedStatement pstm =con.prepareStatement(query);
			//data is inserted into the database
			pstm.setInt(1, emp.getId());
			pstm.setString(2, emp.getName());
			pstm.setDouble(3, emp.getSalary());
			pstm.setInt(4, emp.getAge());

			int count = pstm.executeUpdate();
			if (count != 0) {
				System.out.println("\nEmployee Inserted Successfully !!!\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void showAllEmployee() {

		con= DBConnection.createDBConnection();
		String query = "select * from employee";

		System.out.println("\n\nEmployee Details : \n");
		System.out.format("\n%s\t%s\t%s\t\t%s\n", "Id", "Name", "Salary", "Age");
		System.out.println("---------------------------------------------");

		try {
			Statement stmt =con.createStatement();
			ResultSet result = stmt.executeQuery(query);

			while (result.next()) {
				System.out.format("%d\t%s\t%f\t%d\n", result.getInt(1), result.getString(2), result.getDouble(3),
						result.getInt(4));
				System.out.println("---------------------------------------------");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void showEmployeeBasedOnID(int id) {

		con= DBConnection.createDBConnection();
		String query = "select * from employee where id = " + id;

		System.out.println("\n\nEmployee Details : \n");
		System.out.format("\n%s\t%s\t%s\t\t%s\n", "Id", "Name", "Salary", "Age");
		System.out.println("---------------------------------------------");

		try {
			Statement stmt =con.createStatement();
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) {
				System.out.format("%d\t%s\t%f\t%d\n", result.getInt(1), result.getString(2), result.getDouble(3),
						result.getInt(4));
				System.out.println("---------------------------------------------\n\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateEmployee(int id, String name, double salary, int age) {
		con= DBConnection.createDBConnection();
		String query = "update employee set name= ?, salary = ?, age= ? where id = ?";
		try {
			PreparedStatement pstm =con.prepareStatement(query);
			pstm.setString(1, name);
			pstm.setInt(4, id);
			pstm.setDouble(2, salary);
			pstm.setInt(3, age);
			
			int count = pstm.executeUpdate();
			if (count != 0) {
				System.out.println("Employee Details Updated Successfully !!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee(int id) {
		con= DBConnection.createDBConnection();
		String query = "delete from employee where id = ?";
		try {
			PreparedStatement pstm =con.prepareStatement(query);
			pstm.setInt(1, id);
			int count = pstm.executeUpdate();
			if (count != 0) {
				System.out.println("Employee Deleted Successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
