package com.bilgeadam.course04.submissions.marathons.marathon03.group03.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import com.bilgeadam.course04.submissions.marathons.marathon03.group03.model.AccountTypes;
import com.bilgeadam.course04.submissions.marathons.marathon03.group03.util.HibernateUtil;

import jakarta.persistence.TypedQuery;

public class AccountTypesDAO implements DatabaseCRUDable<AccountTypes> {
	@Override
	public ArrayList<AccountTypes> retrieve() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT xxx FROM AccountTypes AS xxx";
		TypedQuery<AccountTypes> typedQuery = session.createQuery(hql, AccountTypes.class);

		ArrayList<AccountTypes> data = (ArrayList<AccountTypes>) typedQuery.getResultList();
		return data;
	}

	@Override
	public AccountTypes find(long oid) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		String hql = "SELECT xxx FROM Account AS xxx WHERE xxx.oid =: key";
		TypedQuery<AccountTypes> typedQuery = session.createQuery(hql, AccountTypes.class);
		typedQuery.setParameter("key", oid);

		AccountTypes data = (AccountTypes) typedQuery.getSingleResult();
		return data;
	}
}
