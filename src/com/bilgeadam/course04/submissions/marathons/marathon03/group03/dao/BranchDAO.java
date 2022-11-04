package com.bilgeadam.course04.submissions.marathons.marathon03.group03.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import com.bilgeadam.course04.submissions.marathons.marathon03.group03.model.Branch;
import com.bilgeadam.course04.submissions.marathons.marathon03.group03.util.HibernateUtil;

import jakarta.persistence.TypedQuery;

public class BranchDAO implements DatabaseCRUDable<Branch>{
	@Override
	public ArrayList<Branch> retrieve() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT xxx FROM Branch AS xxx";  
		TypedQuery<Branch> typedQuery = session.createQuery(hql, Branch.class);
		
		ArrayList<Branch> data = (ArrayList<Branch>)typedQuery.getResultList();
		return data;
	}

	@Override
	public Branch find(long oid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "SELECT xxx FROM Branch AS xxx WHERE xxx.oid =: key";  
		TypedQuery<Branch> typedQuery = session.createQuery(hql, Branch.class);
		typedQuery.setParameter("key", oid);
		
		Branch data = (Branch)typedQuery.getSingleResult();
		return data;
	}
}
