package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	@Query(value="select* from employee where name=?",nativeQuery=true)
	public List<Employee> getByName(String a);
	
	@Query(value="select * from employee where exp>?&&exp<? ",nativeQuery=true)
	public List<Employee> getByNames(int a,int b);
	
	@Query(value="select e from Employee e where e.name=:p")
	public List<Employee> getByaName(@Param("p") String a);
	
	@Query(value="select * from employee order by salary ",nativeQuery=true)
	public List<Employee> sortbySalary();
	
	@Query(value="select* from employee where name like ?% OR name like %?",nativeQuery=true)
	public List<Employee> word(char a,char b);

}

