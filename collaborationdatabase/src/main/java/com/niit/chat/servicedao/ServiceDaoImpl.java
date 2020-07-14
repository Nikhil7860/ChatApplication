package com.niit.chat.servicedao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.chat.dao.UserInfoDao;
import com.niit.chat.model.UserInfo;

@Service(value = "serviceDao")
public class ServiceDaoImpl implements ServiceDao {
	@Autowired
	private UserInfoDao userInfoDao;
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addUser(UserInfo user) {
		return userInfoDao.addUser(user);
	}

	@Override
	public boolean deleteUser(UserInfo userInfo) {
		return userInfoDao.deleteUser(userInfo);
	}

	@Override
	public boolean updateUser(UserInfo user) {
		return userInfoDao.updateUser(user);
	}

	@Override
	public UserInfo getUserById(int userId) {
		return userInfoDao.getUserById(userId);
	}

	@Override
	public List<UserInfo> getAllUser() {
		return sessionFactory.getCurrentSession().createQuery("from UserInfo where userName!='admin'").list();
	}

	@Override
	public UserInfo getUserEmail(String emailId) {
		Query query = sessionFactory.getCurrentSession().createQuery("from UserInfo where userEmail=:emailId");
		UserInfo user = (UserInfo) query.setParameter("emailId", emailId).getSingleResult();
		return user;
	}

}
