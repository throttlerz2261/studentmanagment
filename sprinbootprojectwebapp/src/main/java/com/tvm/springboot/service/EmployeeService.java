package com.tvm.springboot.service;
import com.tvm.springboot.model.Employee;
import java.util.List;
public interface EmployeeService {
	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
	void deleteEmployeeById(long id);
}
