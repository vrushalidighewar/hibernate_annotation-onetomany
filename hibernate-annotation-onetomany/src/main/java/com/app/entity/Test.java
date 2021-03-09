package com.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToOne;

import org.hibernate.Session;

public class Test {

	public void save() {
		
		Employee employee=new Employee();
		employee.setName("ABC");
		
		Address a1=new Address();
		a1.setCity("Pune");
		a1.setPincode(445236);
		a1.setEmployee(employee);
		
		Address a2=new Address();
		a2.setCity("Nashik");
		a2.setPincode(456321);
		a2.setEmployee(employee);
		
		List<Address> addresses=new ArrayList<Address>();
		addresses.add(a1);
		addresses.add(a2);
		
		employee.setAddresses(addresses);
		
		Session session=HibernateUtility.getSession().openSession();
		session.save(employee);
		
		session.beginTransaction().commit();
		System.out.println("successful");
	}
	
	public void selectAll() {
		
		HibernateUtility.getSession().openSession().createCriteria(Employee.class).list().forEach(System.out::println);
	}
	
	public void Update() {
		
		Session session=HibernateUtility.getSession().openSession();
		
		Employee employee=(Employee) session.get(Employee.class,11);
		employee.setName("PQR");
		
		
	}
	
	public void delete() {
		selectAll();
		Session session=HibernateUtility.getSession().openSession();
		Employee employee=(Employee) session.get(Employee.class, 10);
		session.delete(employee);
		session.beginTransaction().commit();
	}

	public static void main(String[] args) {
		Test t=new Test();
		t.save();
		t.selectAll();
		t.Update();
		t.delete();
	}
}

