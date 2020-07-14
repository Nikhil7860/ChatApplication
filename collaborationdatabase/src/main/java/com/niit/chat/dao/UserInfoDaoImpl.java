package com.niit.chat.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.chat.model.Authorization;
import com.niit.chat.model.UserInfo;

@Repository(value = "userInfoDao")
@Transactional
public class UserInfoDaoImpl implements UserInfoDao {
	private static final Logger log = LoggerFactory.getLogger(UserInfoDaoImpl.class);
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public boolean addUser(UserInfo user) {
		Session session = sessionFactory.getCurrentSession();
		log.debug("user data is going to end");
		try {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setConfrimPassword(passwordEncoder.encode(user.getConfrimPassword()));
			sessionFactory.getCurrentSession().save(user);
			Authorization auth = new Authorization();

			auth.setUserName(user.getUserEmail());

			session.save(auth);

			log.debug("user data added successfully");

			return true;

		} catch (HibernateException exception) {
			log.error(exception.getMessage());
			return false;
		}
	}

	public boolean updateUser(UserInfo user) {
		Session session = sessionFactory.getCurrentSession();
		log.debug("user data is going to update");
		try {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setConfrimPassword(passwordEncoder.encode(user.getConfrimPassword()));

			session.update(user);

			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public UserInfo getUserById(int userId) {
		log.debug("user by Id is going to run");
		try {
			UserInfo user = (UserInfo) sessionFactory.getCurrentSession().createQuery("from UserInfo where userId=?")
					.setParameter(0, userId).uniqueResult();

			System.out.println("dao user by id" + user.getUserId());
			return user;

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<UserInfo> getAllUser() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from UserInfo where userName!='admin'").list();
		}

		catch (HibernateException e) {

			e.printStackTrace();
			throw e;
		}
	}

	public UserInfo getUserEmail(String emailId) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from UserInfo where userEmail=:emailId");
			UserInfo user = (UserInfo) query.setParameter("emailId", emailId).getSingleResult();
			return user;
		} catch (HibernateException e) {

			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteUser(UserInfo userInfo) {
		log.debug("user data is going to update");
		try {
			Session session = sessionFactory.getCurrentSession();

			session.delete(userInfo);

			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public UserInfo getUserByName(String userName) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from UserInfo where userName=:userName");
			UserInfo user = (UserInfo) query.setParameter("userName", userName).getSingleResult();
			return user;
		} catch (HibernateException e) {

			e.printStackTrace();
			return null;
		}
	}

}
