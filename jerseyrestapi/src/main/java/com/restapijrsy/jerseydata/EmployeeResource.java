package com.restapijrsy.jerseydata;


import java.util.ArrayList;


import java.sql.*;

public class EmployeeResource {

	ArrayList<Employee> empList=new ArrayList<Employee>();
	Connection conn;
	String url="jdbc:mysql://127.0.0.1:3306/SG_Resources";
	String user="root";
	String password="12345678";
	
	public EmployeeResource()
	{

	}
	
	public ArrayList<Employee> selectAllEmployees() {
		
		ArrayList<Employee> empList= new ArrayList<Employee>();
		
		try {
		 Class.forName("com.mysql.jdbc.Driver");	
		 conn = DriverManager.getConnection(url, user, password);
		 Statement st=conn.createStatement();
		 ResultSet rs=st.executeQuery("select * from EmployeeDetails");
		 
		 while (rs.next())
		 {
			 Employee e=new Employee();
			 e.setEmpId(rs.getInt(1));
			 e.setEmpName(rs.getString(2));
			 e.setEmpLocation(rs.getString(3));	
			 empList.add(e);
		 }
		}
		catch (Exception e)
		{
			e.printStackTrace();
			empList=null;
			
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		}
		return empList;
	}

	public Employee selectEmpById(int empId) {
		Employee emp=new Employee();
		
		try {			
			Class.forName("com.mysql.jdbc.Driver");			
			conn = DriverManager.getConnection(url,user,password);			
			PreparedStatement ps = conn.prepareStatement("select * from EmployeeDetails where emp_id = ?");			
			ps.setInt(1, empId);
			System.out.println("Setting the Employee Id : " + empId);
			ResultSet rs=ps.executeQuery();
			
			System.out.println("Query Executed Successfully");
			if (rs.next())
			{
			   emp.setEmpId(rs.getInt(1));
			   emp.setEmpName(rs.getString(2));
			   emp.setEmpLocation(rs.getString(3));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			emp=null;
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
	}

	public int insertEmployee(Employee emp) {
		
		int returncode;
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			
			PreparedStatement ps=conn.prepareStatement("insert into EmployeeDetails values (?,?,?) ");
			ps.setInt(1, emp.getEmpId());
			ps.setString(2, emp.getEmpName());
			ps.setString(3, emp.getEmpLocation());
			
			returncode=ps.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
}
