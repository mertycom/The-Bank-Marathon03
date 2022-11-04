package com.bilgeadam.course04.submissions.marathons.marathon03.group03.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import com.bilgeadam.course04.submissions.marathons.marathon03.group03.model.Customer;
import com.bilgeadam.course04.submissions.marathons.marathon03.group03.util.HibernateUtil;

import jakarta.persistence.TypedQuery;

public class CustomerDAO implements DatabaseCRUDable<Customer>{
	@Override
	public ArrayList<Customer> retrieve() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT xxx FROM Customer AS xxx";  
		TypedQuery<Customer> typedQuery = session.createQuery(hql, Customer.class);
		
		ArrayList<Customer> data = (ArrayList<Customer>)typedQuery.getResultList();
		return data;
	}

	@Override
	public Customer find(long oid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "SELECT xxx FROM Customer AS xxx WHERE xxx.oid =: key";  
		TypedQuery<Customer> typedQuery = session.createQuery(hql, Customer.class);
		typedQuery.setParameter("key", oid);
		
		Customer data = (Customer)typedQuery.getSingleResult();
		return data;
	}
}
