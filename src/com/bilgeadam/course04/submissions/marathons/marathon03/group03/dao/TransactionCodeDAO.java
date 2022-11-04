package com.bilgeadam.course04.submissions.marathons.marathon03.group03.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import com.bilgeadam.course04.submissions.marathons.marathon03.group03.model.TransactionCode;
import com.bilgeadam.course04.submissions.marathons.marathon03.group03.util.HibernateUtil;

import jakarta.persistence.TypedQuery;

public class TransactionCodeDAO implements DatabaseCRUDable<TransactionCode>{
	@Override
	public ArrayList<TransactionCode> retrieve() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT xxx FROM TransactionCode AS xxx";  
		TypedQuery<TransactionCode> typedQuery = session.createQuery(hql, TransactionCode.class);
		
		ArrayList<TransactionCode> data = (ArrayList<TransactionCode>)typedQuery.getResultList();
		return data;
	}

	@Override
	public TransactionCode find(long oid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "SELECT xxx FROM TransactionCode AS xxx WHERE xxx.oid =: key";  
		TypedQuery<TransactionCode> typedQuery = session.createQuery(hql, TransactionCode.class);
		typedQuery.setParameter("key", oid);
		
		TransactionCode data = (TransactionCode)typedQuery.getSingleResult();
		return data;
	}
}
