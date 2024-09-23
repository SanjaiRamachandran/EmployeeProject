package com.employee.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.exception.AgeException;
import com.employee.exception.NameException;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
	@Autowired
	EmployeeService es;
	
	@PostMapping(value="/postEmployee")
	public String postEmp(@RequestBody Employee e) {
		return es.postEmp(e);
	}
	@GetMapping(value="/getDetails")
	public List<Employee> getDetails() {
		return es.getDetails();
	}
	@GetMapping(value="/getId/{a}")
	public Employee getId(@PathVariable int a) {
		return es.getId(a);
	}
	@PostMapping(value="/postEmployees")
	public String postEmps(@RequestBody List<Employee> e) {
		return es.postEmps(e);
	}
	@GetMapping(value="/getName")
	public List<String> getName(){
		return es.getName();
	}
	@GetMapping(value="/maxSalary")
	public Employee maxSalary() {
		return es.maxSalary();
	}
	@GetMapping(value="/sumAge")
	public int sumAge() {
		return es.sumAge();
	}
	@GetMapping(value="/avgSalary")
	public Double avgSalary() {
		return es.avgSalary();
	}
	
	@GetMapping(value="/con")
	public List<Employee> con() {
		return es.con();
	}
	@GetMapping(value="/sortDetails")
	public List<Employee> sortDetails(){
		return es.sortDetails();
	}
	@GetMapping(value="/countExp")
	public Long countExp(){
		return es.countExp();
	}
	@GetMapping(value="/countField")
	public Map<String,Long> countField(){
		return es.countField();
	}
	@GetMapping(value="/QueryDetail/{a}")
	public List<Employee> getByName(@PathVariable String a){
		return es.getByName(a);
	}
	@GetMapping(value="/QueryDetails")
	public List<Employee> getByNames(@RequestParam int a,@RequestParam int b){
		return es.getByNames(a,b);
	}
	@GetMapping(value="/JQueryDetails/{a}")
	public List<Employee> getByaName(@PathVariable String a){
		return es.getByaName(a);
	}
	@GetMapping(value="sortbysalary")
	public List<Employee> sortbySalary(){
		return es.sortbySalary();
		
			}
	@GetMapping(value="word/{a}/{b}")
	public List<Employee> word(@PathVariable char a,@PathVariable char b){
		return es.word(a,b);
}
	@GetMapping(value="getIdName/{a}")
	public String getIdName(@PathVariable int a) throws NameException {
		return es.getIdName(a);
	}
	@GetMapping(value="/getIdAge/{a}")
	public Employee getIdAge(@PathVariable int a) throws AgeException {
		return es.getIdAge(a);
	}
	@GetMapping(value="/getNameLast")
	public List<Character> getLastName(){
		return es.getLastName();
	}
	@GetMapping(value="/getNameAge")
	public List<Object> getNameAge(){
		return es.getNameAge();
	}
}
