package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Employee;
import com.app.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Transaction tx=null;
		//try with resource
		try(Session ses=HibernateUtil.getSf().openSession()) {
		tx=ses.beginTransaction();
		Employee emp=new Employee(12,"b",26);
		ses.save(emp);
		tx.commit();
		} catch (Exception e) {
		e.printStackTrace();
		tx.rollback();
		}

	}

}
