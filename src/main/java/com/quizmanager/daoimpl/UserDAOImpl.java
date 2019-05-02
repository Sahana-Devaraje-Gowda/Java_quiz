package com.quizmanager.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.quizmanager.dao.UserDAO;
import com.quizmanager.dto.UserDetails;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Transactional
	public String saveUser(UserDetails user) {
		String msg = "";
		try {
			hibernateTemplate.save(user);
		} catch (DataIntegrityViolationException e) {
			msg = "user already exist";
		}
		return msg;
	}

	@Transactional
	public UserDetails getUserByEmail(String email) {

		return hibernateTemplate.get(UserDetails.class, email);
	}

	@Transactional
	public void userDetailsUpdate(UserDetails user) {
		hibernateTemplate.update(user);
	}

}
