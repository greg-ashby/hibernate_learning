package com.gregashby.hibernate.util;

import java.util.Date;

import org.hibernate.Session;

import com.gregashby.hibernate.model.Department;
import com.gregashby.hibernate.model.Employee;

public class HibernateTest {

	public static void main(String[] args) {
		try {
			Employee employee = new Employee();
			employee.setName("Greg");
			employee.setRole("Developer");
			employee.setInsertTime(new Date());

			Employee george = new Employee();
			george.setName("George");
			george.setRole("Developer");
			george.setInsertTime(new Date());

			Department department = new Department();
			department.setName("the only department");

			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			session.save(department);
			employee.setDepartment(department);
			george.setDepartment(department);
			
			session.save(employee);
			session.save(george);
			session.getTransaction().commit();

			System.out.println("Employee created with ID: " + employee.getId());
		} catch (Throwable e) {
			HibernateUtil.getSessionFactory().close();
		}
	}

}
