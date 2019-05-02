package com.quizmanager.dao;

import com.quizmanager.dto.UserDetails;

public interface UserDAO {

	public String  saveUser(UserDetails user);

	public UserDetails getUserByEmail(String email);

	public void  userDetailsUpdate(UserDetails user);

}
