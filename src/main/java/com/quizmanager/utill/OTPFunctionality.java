/**
 * 
 */
package com.quizmanager.utill;

import java.util.Random;

import org.springframework.stereotype.Component;

/**
 * @author sahana
 *
 */
@Component
public class OTPFunctionality {

	private static Random random = new Random();

	private OTPFunctionality() {

	}

	public static String getOTP() {
		int len = 6;

		String values = "0123456789";

		String otp = "";

		for (int i = 0; i < len; i++) {
			otp = otp + values.charAt(random.nextInt(values.length()));

		}
		return otp.trim();
	}

}
