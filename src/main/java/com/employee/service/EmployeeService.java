package com.employee.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.employee.dao.EmployeeDAO;
import com.employee.entity.Employee;
import com.employee.exception.AgeException;
import com.employee.exception.NameException;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDAO ed;
	
	public String postEmp(@RequestBody Employee e) {
		return ed.postEmp(e);
	}
	public List<Employee> getDetails() {
		return ed.getDetails();
	}
	public Employee getId(@PathVariable int a) {
		return ed.getId(a);
	}
	public String postEmps(@RequestBody List<Employee> e) {
		return ed.postEmps(e);
	}
    public List<String> getName(){
    List<Employee> emps=ed.getDetails();
    List<String> empNames=emps.stream().map(x->x.getName()).collect(Collectors.toList());
    return empNames;
    }
    public Employee maxSalary() {
    	List<Employee> emps=ed.getDetails();
    	Employee maxSalary=emps.stream().max(Comparator.comparing(Employee::getSalary)).get();
    	return maxSalary;
    }
    public int sumAge() {
    	List<Employee> emps=ed.getDetails();
    	int sumAge=emps.stream().collect(Collectors.summingInt(x->x.getAge()));
    	return sumAge;
    }
    public Double avgSalary() {
    	List<Employee> emps=ed.getDetails();
    	Double avgSalary=emps.stream().collect(Collectors.averagingInt(x->x.getSalary()));
    	return avgSalary;
    }
    public List<Employee> con() {
    	List<Employee> emps=ed.getDetails();
    	List<Employee> con=emps.stream().filter(x->x.getName().startsWith("V")&&x.getGender().equalsIgnoreCase("Male")&&x.getSalary()>5000).collect(Collectors.toList());
    	return con;
    }
    public List<Employee> sortDetails(){
    	List<Employee> emps=ed.getDetails();
    	List<Employee> sortDetails=emps.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
    	return sortDetails;
    }
    public Long countExp() {
    	List<Employee> emps=ed.getDetails();
    	 Long countExp=emps.stream().filter(x->x.getExp()>=5).count();
    	 return countExp;
    }
    public Map<String,Long> countField() {
    	List<Employee> emps=ed.getDetails();
    	Map<String,Long> countField=emps.stream().collect(Collectors.groupingBy(x->x.getField(),Collectors.counting()));
    	return countField;
    }
	public List<Employee> getByName(String a){
		return ed.getByName(a);
	}
	public List<Employee> getByNames(int a,int b){
		return ed.getByNames(a,b);
	}
	public List<Employee> getByaName( String a){
		return ed.getByaName(a);
	}
	public List<Employee> sortbySalary(){
		return ed.sortbySalary();
	}
	public List<Employee> word(char a,char b){
		return ed.word(a,b);
	}
//	public String getIdName(int a) throws NameException {
//		try {
//		if(ed.getIdName(a).equals("Abc")) {
//			return ed.getIdName(a);
//		}
//		else {
//			throw new NameException("Abc is not in that Id");
//		}
//		}
//		catch(Exception e) {
//			 return e.getMessage();
//		}
//		finally {
//			return "Final";
//		}
	public String getIdName(int a) throws NameException {
	if(ed.getIdName(a).equals("Abc")) {
		return ed.getIdName(a);
	}
	else {
		throw new NameException("Abc is not in that Id");
	}
	}
	public Employee getIdAge(int a) throws AgeException {
		if(ed.getIdAge(a).getSalary()<45) {
			return ed.getIdAge(a);
		}
		else {
			throw new AgeException("Retirement Age");
		}
	}
	public List<Character> getLastName(){
		List<Employee> emps=ed.getDetails();
		List<Character> lc=emps.stream().map(x->x.getName().charAt(x.getName().length()-1)).collect(Collectors.toList());
		return lc;

	}
	public List<Object> getNameAge(){
		List<Employee> emps=ed.getDetails();
		List<Object> getNaAg=emps.stream().map(x->x.getName()+" , "+x.getAge()).collect(Collectors.toList());
		return getNaAg;
	}
}


