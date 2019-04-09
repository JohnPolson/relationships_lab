package com.codeclan.relationships_lab;

import com.codeclan.relationships_lab.models.Department;
import com.codeclan.relationships_lab.models.Employee;
import com.codeclan.relationships_lab.models.Project;
import com.codeclan.relationships_lab.repositories.DepartmentRepository;
import com.codeclan.relationships_lab.repositories.EmployeeRepository;
import com.codeclan.relationships_lab.repositories.ProjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationshipsLabApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createEmployeeAndDepartment(){
		Department department = new Department("IT");
		departmentRepository.save(department);

		Employee employee = new Employee("John", "Sparrow", 01, department);
		employeeRepository.save(employee);
	}

	@Test
	public void addEmployeesAndProjects(){

		Department department = new Department("IT");
		departmentRepository.save(department);

		Employee employee = new Employee("John", "Sparrow", 01, department);
		employeeRepository.save(employee);

		Project project = new Project("Tortuga", 100);
		projectRepository.save(project);

		project.addEmployee(employee);
		projectRepository.save(project);

	}

}
