package com.stpl.assignment.service;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.stpl.assignment.model.StudentBean;

public class StudentService {

	@Autowired
	SessionFactory factory;

	public void insert(StudentBean studentbean) throws ClassNotFoundException, SQLException, NamingException {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(studentbean);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void delete(StudentBean studentbean) throws NamingException, SQLException {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {

			session.delete(studentbean);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void update(StudentBean studentbean) throws NamingException, SQLException {

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {

			session.update(studentbean);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<StudentBean> display() {
		List<StudentBean> studentList;
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		studentList = session.createCriteria(StudentBean.class).list();
		t.commit();
		return studentList;
	}

	public List<StudentBean> search(int studentid) throws NamingException, SQLException {

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		Criteria criteria = session.createCriteria(StudentBean.class);
		criteria.add(Restrictions.eq("studentid", studentid));
		@SuppressWarnings("unchecked")
		List<StudentBean> list = criteria.list();
		t.commit();
		return list;

	}
}
