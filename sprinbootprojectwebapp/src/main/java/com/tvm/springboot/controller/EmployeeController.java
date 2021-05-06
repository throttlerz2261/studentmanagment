package com.tvm.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.tvm.springboot.repository.EmployeeRepository;
import com.tvm.springboot.service.EmployeeService;
import java.util.List;
import com.tvm.springboot.model.Employee;
@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeRepository employeeRepository;
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees",employeeService.getAllEmployees());
		return "index";
	}
	@GetMapping("/showNewEmployeeForm")
	public String showNewemployeeForm(Model model) {
		Employee employee=new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
		
	}
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value="id") long id,Model model) {
		Employee employee=employeeService.getEmployeeById(id);
		model.addAttribute("employee",employee);
		return "update_employee";
		
	}
	@GetMapping("deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value="id") long id) {
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}
	@GetMapping("/{id}")
	public String showsearch(@PathVariable(value="id") long id,Model model) {
		Employee employee=employeeService.getEmployeeById(id);
		model.addAttribute("employee",employee);
		return "update_employee";
	}
}
		
	


