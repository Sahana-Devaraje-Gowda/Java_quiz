/**
 * 
 */
package com.quizmanager.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author sahana
 *
 */
@Entity
@Table(name = "MCQOptions")
public class Answers {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer mcqOptionId;

	@Column
	private String a;

	@Column
	private String b;

	@Column
	private String c;

	@Column
	private String d;

	/**
	 * @return the mcqOptionId
	 */
	public Integer getMcqOptionId() {
		return mcqOptionId;
	}

	/**
	 * @param mcqOptionId the mcqOptionId to set
	 */
	public void setMcqOptionId(Integer mcqOptionId) {
		this.mcqOptionId = mcqOptionId;
	}

	/**
	 * @return the a
	 */
	public String getA() {
		return a;
	}

	/**
	 * @param a the a to set
	 */
	public void setA(String a) {
		this.a = a;
	}

	/**
	 * @return the b
	 */
	public String getB() {
		return b;
	}

	/**
	 * @param b the b to set
	 */
	public void setB(String b) {
		this.b = b;
	}

	/**
	 * @return the c
	 */
	public String getC() {
		return c;
	}

	/**
	 * @param c the c to set
	 */
	public void setC(String c) {
		this.c = c;
	}

	/**
	 * @return the d
	 */
	public String getD() {
		return d;
	}

	/**
	 * @param d the d to set
	 */
	public void setD(String d) {
		this.d = d;
	}

}