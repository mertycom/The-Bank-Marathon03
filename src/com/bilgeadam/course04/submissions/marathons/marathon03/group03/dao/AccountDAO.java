package com.bilgeadam.course04.submissions.marathons.marathon03.group03.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import com.bilgeadam.course04.submissions.marathons.marathon03.group03.model.Account;
import com.bilgeadam.course04.submissions.marathons.marathon03.group03.util.HibernateUtil;

import jakarta.persistence.TypedQuery;

public class AccountDAO implements DatabaseCRUDable<Account> {
	@Override
	public ArrayList<Account> retrieve() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT xxx FROM Account AS xxx";
		TypedQuery<Account> typedQuery = session.createQuery(hql, Account.class);

		ArrayList<Account> data = (ArrayList<Account>) typedQuery.getResultList();
		return data;
	}

	@Override
	public Account find(long oid) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		String hql = "SELECT xxx FROM Account AS xxx WHERE xxx.oid =: key";
		TypedQuery<Account> typedQuery = session.createQuery(hql, Account.class);
		typedQuery.setParameter("key", oid);

		Account data = (Account) typedQuery.getSingleResult();
		return data;
	}
}
