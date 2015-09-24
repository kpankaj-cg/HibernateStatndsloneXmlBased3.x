package com.pkcorp.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pkcorp.models.Employee;
import com.pkcorp.utils.HibernateUtils;

public class EmployeeService {
	Session session;

	public EmployeeService() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		session = sessionFactory.openSession();
	}

	public void addEmployee() {
		System.out.println("Maven + Hibernate + H2");

		session.beginTransaction();
		Employee employee = new Employee();

		//employee.setId(3);
		employee.setName("Pankaj");
		employee.setCity("Thane");
		employee.setSalary(100.00);

		session.save(employee);
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public void getEmployees() {
		session.beginTransaction();
		List<Employee> employeeList = session.createQuery("from Employee")
				.list();
		System.out.println("employee Data = " + employeeList);
	}

	public static void main(String[] args) {
		EmployeeService service = new EmployeeService();
		service.addEmployee();
		service.getEmployees();
	}
}
