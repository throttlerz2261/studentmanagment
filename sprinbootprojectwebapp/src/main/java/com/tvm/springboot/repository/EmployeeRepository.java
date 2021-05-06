package com.tvm.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.tvm.springboot.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	

}
