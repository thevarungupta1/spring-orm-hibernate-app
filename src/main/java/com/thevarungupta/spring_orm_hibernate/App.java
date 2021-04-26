package com.thevarungupta.spring_orm_hibernate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.thevarungupta.spring_orm_hibernate.dao.EmployeeDao;
import com.thevarungupta.spring_orm_hibernate.entities.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        EmployeeDao dao = context.getBean("employeeDao", EmployeeDao.class);
        
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       boolean flag = true;
       
       while(flag) {
    	   System.out.println("*********************");
           System.out.println("PRESS 1: Add Employee");
           System.out.println("PRESS 2: Get All Employee");
           System.out.println("PRESS 3: Get Employee by Id");
           System.out.println("PRESS 4: Delete Employee");
           System.out.println("PRESS 5: Update Employee");
           System.out.println("PRESS 6: Exit");
           System.out.println("*********************");   
           
           try {
        	   int input = Integer.parseInt(br.readLine());
        	   
        	   switch (input) {
		       		case 1:
		       			// add employee
		       			System.out.println("Enter employee id: ");
		       			int id = Integer.parseInt(br.readLine());
		       			
		       			System.out.println("Enter employee name:");
		       			String name = br.readLine();
		       			
		       			System.out.println("Enter employee email:");
		       			String email = br.readLine();
		       			
		       			Employee newEmployee = new Employee();
		       			newEmployee.setId(id);
		       			newEmployee.setName(name);
		       			newEmployee.setEmail(email);
		       			
		       			dao.addEmployee(newEmployee);
		       			System.out.println("Employee inserted successfully");
		       			
		       			break;
		       		case 2:
		       			// get all
			       		List<Employee> employees =  dao.getAllEmployees();
			       		System.out.println("All Employeed...");
			       		for(Employee employee: employees) {
			       			System.out.println(employee);
			       		}
		       			break;
		       		case 3:
		       			// get employee by id
		       			System.out.println("Enter employee id: ");
		       			int searchId = Integer.parseInt(br.readLine());
		       			Employee serachEmployee = dao.getEmployeeById(searchId);
		       			System.out.println("Searched Employeed...");
		       			System.out.println(serachEmployee);
		       			break;
		       		case 4:
		       			// delete
		       			System.out.println("Enter employee id: ");
		       			int deleteId = Integer.parseInt(br.readLine());
		       			dao.deleteEmployee(deleteId);
		       			System.out.println("employee deleted successfully");
		       			break;
		       		case 5:
			       		// update employee
		       			System.out.println("Enter employee id: ");
		       			int updateId = Integer.parseInt(br.readLine());
		       			
		       			System.out.println("Enter employee name:");
		       			String updateName = br.readLine();
		       			
		       			System.out.println("Enter employee email:");
		       			String updateEmail = br.readLine();
		       			
		       			Employee updateEmployee = new Employee();
		       			updateEmployee.setId(updateId);
		       			updateEmployee.setName(updateName);
		       			updateEmployee.setEmail(updateEmail);
		       			
		       			dao.updateEmployee(updateEmployee);
		       			System.out.println("update done successfully");
		       			
		       			break;
		       		case 6:
		       			System.out.println("Thank you");
		       			System.out.println("Closing...");
		       				flag = false;
		       			break;
		       	
		       		default:
		       			System.out.println("Choose option between 1 - 6");
		              } 	   
			
			} catch (Exception e) {				
				System.out.println(e.getMessage());
			}
       
       }
       
    }
}
