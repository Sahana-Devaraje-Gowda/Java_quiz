package com.quizmanager.serviceimpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizmanager.dao.UserDAO;
import com.quizmanager.dto.UserDetails;
import com.quizmanager.exceptions.UserNotFoundException;
import com.quizmanager.service.UserService;
import com.quizmanager.utill.MailServiceImpl;
import com.quizmanager.utill.OTPFunctionality;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDao;
	@Autowired
	MailServiceImpl mailServiceImpl;

	public String saveUser(UserDetails userDetails) {
		userDetails.setCreatedDate(new Date());
		userDetails.setLastUpdatedBy(userDetails.getUserName());
		userDetails.setLastUpdatedOn(new Date());
		userDetails.setRole("USER");
		userDetails.setStauts("Active");
		userDao.saveUser(userDetails);
		return "";

	}

	@Override
	public UserDetails validateUser(UserDetails details) {

		UserDetails user = userDao.getUserByEmail(details.getEmail());
		if (user == null) {
			throw new UserNotFoundException("User Not Found");
		} else {
			if (details.getPassword().equals(user.getPassword())) {
				return user;
			} else {
				throw new UserNotFoundException("Password Does Not Match");
			}
		}

	}

	@Override
	public String forgotPassword(String email) {
		UserDetails user = userDao.getUserByEmail(email);
		String otp = "";
		if (user == null) {
			throw new UserNotFoundException("User Not Found");
		} else {
			otp = OTPFunctionality.getOTP();
			mailServiceImpl.sendEmail(email, otp);
		}
		return otp;
	}

	@Override
	public void userDetailsUpdate(String email, String password) {
		UserDetails user = userDao.getUserByEmail(email);
		user.setEmail(email);
		user.setPassword(password);
		userDao.userDetailsUpdate(user);

	}

}
