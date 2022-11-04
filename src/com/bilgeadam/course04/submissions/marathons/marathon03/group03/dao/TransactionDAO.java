package com.bilgeadam.course04.submissions.marathons.marathon03.group03.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import com.bilgeadam.course04.submissions.marathons.marathon03.group03.model.Transaction;
import com.bilgeadam.course04.submissions.marathons.marathon03.group03.util.HibernateUtil;

import jakarta.persistence.TypedQuery;

public class TransactionDAO implements DatabaseCRUDable<Transaction>{
	@Override
	public ArrayList<Transaction> retrieve() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT xxx FROM Transaction AS xxx";  
		TypedQuery<Transaction> typedQuery = session.createQuery(hql, Transaction.class);
		
		ArrayList<Transaction> data = (ArrayList<Transaction>)typedQuery.getResultList();
		return data;
	}

	@Override
	public Transaction find(long oid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "SELECT xxx FROM Transaction AS xxx WHERE xxx.oid =: key";  
		TypedQuery<Transaction> typedQuery = session.createQuery(hql, Transaction.class);
		typedQuery.setParameter("key", oid);
		
		Transaction data = (Transaction)typedQuery.getSingleResult();
		return data;
	}
}
