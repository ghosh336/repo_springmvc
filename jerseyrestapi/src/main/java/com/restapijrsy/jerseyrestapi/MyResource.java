
package com.restapijrsy.jerseyrestapi;

import java.util.*;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.restapijrsy.jerseydata.Employee;
import com.restapijrsy.jerseydata.EmployeeResource;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/myresource")
public class MyResource {
    
	EmployeeResource er=new EmployeeResource();
	
    @GET 
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Path("/getallemps")
    public ArrayList<Employee> getIt() {
    	
    	 	System.out.println("Initiating the DB call.........");
    		ArrayList<Employee> empList= null;
    		empList = er.selectAllEmployees();
        return empList;
    }
    
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/getSpecEmp/{empid}")
    public Employee getSpecEmp(@PathParam("empid") int empId)
    {   	
    	  Employee e=null;
    	  e=er.selectEmpById(empId);   	  
      return e;
    }

    @POST
    @Produces("text/plain")
    @Path("/createEmployee")
    public String addEmployee(Employee e)
    {
    	  int return_code=-1;
    	  
    	  return_code=er.insertEmployee(e);
    	  
    	  if( return_code == 0 )
    		  return "Success";
    	  else
    	      return "failure";	  
    }
}
