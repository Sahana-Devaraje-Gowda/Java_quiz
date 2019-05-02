/**
 * 
 */
package com.quizmanager.service;

import com.quizmanager.dto.UserDetails;

/**
 * @author sahana
 *
 */
public interface UserService {
	public String saveUser(UserDetails user);

	public UserDetails validateUser(UserDetails details);

	public String forgotPassword(String email);
	
	public void userDetailsUpdate(String email,String password);
}
