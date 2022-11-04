package com.bilgeadam.course04.submissions.marathons.marathon03.group03.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import com.bilgeadam.course04.submissions.marathons.marathon03.group03.model.TransactionPlatform;
import com.bilgeadam.course04.submissions.marathons.marathon03.group03.util.HibernateUtil;

import jakarta.persistence.TypedQuery;

public class TransactionPlatformDAO implements DatabaseCRUDable<TransactionPlatform> {
	@Override
	public ArrayList<TransactionPlatform> retrieve() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT xxx FROM TransactionPlatform AS xxx";
		TypedQuery<TransactionPlatform> typedQuery = session.createQuery(hql, TransactionPlatform.class);

		ArrayList<TransactionPlatform> data = (ArrayList<TransactionPlatform>) typedQuery.getResultList();
		return data;
	}

	@Override
	public TransactionPlatform find(long oid) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		String hql = "SELECT xxx FROM TransactionPlatform AS xxx WHERE xxx.oid =: key";
		TypedQuery<TransactionPlatform> typedQuery = session.createQuery(hql, TransactionPlatform.class);
		typedQuery.setParameter("key", oid);

		TransactionPlatform data = (TransactionPlatform) typedQuery.getSingleResult();
		return data;
	}
}
