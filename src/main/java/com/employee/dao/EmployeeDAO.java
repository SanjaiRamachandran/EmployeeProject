package com.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@Repository
public class EmployeeDAO {
	@Autowired
	EmployeeRepository er;
	
	public String postEmp(@RequestBody Employee e) {
		er.save(e);
		return "Completed";
}
	public List<Employee> getDetails() {
		return er.findAll();
	}
	public Employee getId(@PathVariable int a) {
		return er.findById(a).get();
	}
	public String postEmps(@RequestBody List<Employee> e) {
		er.saveAll(e);
		return "Successfully Updated";
	}
	public List<Employee> getByName(String a){
		return er.getByName(a);
	}
	public List<Employee> getByNames(int a,int b){
		return er.getByNames(a,b);
	}
	public List<Employee> getByaName(String a){
		return er.getByaName(a);
	}
	public List<Employee> sortbySalary(){
		return er.sortbySalary();
	}
	public List<Employee> word(char a,char b){
		return er.word(a,b);
}
	public String getIdName(int a) {
		return er.findById(a).get().getName();
	}
	public Employee getIdAge(int a) {
		return er.findById(a).get();
	}
}