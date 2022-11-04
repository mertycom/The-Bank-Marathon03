package com.bilgeadam.course04.submissions.marathons.marathon03.group03.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import com.bilgeadam.course04.submissions.marathons.marathon03.group03.model.TransactionType;
import com.bilgeadam.course04.submissions.marathons.marathon03.group03.util.HibernateUtil;

import jakarta.persistence.TypedQuery;

public class TransactionTypeDAO implements DatabaseCRUDable<TransactionType>{
	@Override
	public ArrayList<TransactionType> retrieve() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT xxx FROM TransactionType AS xxx";  
		TypedQuery<TransactionType> typedQuery = session.createQuery(hql, TransactionType.class);
		
		ArrayList<TransactionType> data = (ArrayList<TransactionType>)typedQuery.getResultList();
		return data;
	}

	@Override
	public TransactionType find(long oid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "SELECT xxx FROM TransactionType AS xxx WHERE xxx.oid =: key";  
		TypedQuery<TransactionType> typedQuery = session.createQuery(hql, TransactionType.class);
		typedQuery.setParameter("key", oid);
		
		TransactionType data = (TransactionType)typedQuery.getSingleResult();
		return data;
	}
}
