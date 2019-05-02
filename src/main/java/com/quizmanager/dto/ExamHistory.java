/**
 * 
 */
package com.quizmanager.dto;

import java.util.Date;

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
@Table(name = "ExamHistory")
public class ExamHistory {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer examhistoryId;

	@Column
	private String ans;

	@Column
	private Integer questionId;

	@Column
	private String userId;

	@Column
	private String examId;

	@Column
	private Date createdtime;

	@Column
	private String actuallyAns;

	/**
	 * @return the examhistoryId
	 */
	public Integer getExamhistoryId() {
		return examhistoryId;
	}

	/**
	 * @param examhistoryId the examhistoryId to set
	 */
	public void setExamhistoryId(Integer examhistoryId) {
		this.examhistoryId = examhistoryId;
	}

	/**
	 * @return the ans
	 */
	public String getAns() {
		return ans;
	}

	/**
	 * @param ans the ans to set
	 */
	public void setAns(String ans) {
		this.ans = ans;
	}

	/**
	 * @return the questionId
	 */
	public Integer getQuestionId() {
		return questionId;
	}

	/**
	 * @param questionId the questionId to set
	 */
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the examId
	 */
	public String getExamId() {
		return examId;
	}

	/**
	 * @param examId the examId to set
	 */
	public void setExamId(String examId) {
		this.examId = examId;
	}

	/**
	 * @return the createdtime
	 */
	public Date getCreatedtime() {
		return createdtime;
	}

	/**
	 * @param createdtime the createdtime to set
	 */
	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}

	/**
	 * @return the actuallyAns
	 */
	public String getActuallyAns() {
		return actuallyAns;
	}

	/**
	 * @param actuallyAns the actuallyAns to set
	 */
	public void setActuallyAns(String actuallyAns) {
		this.actuallyAns = actuallyAns;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExamHistory [examhistoryId=");
		builder.append(examhistoryId);
		builder.append(", ans=");
		builder.append(ans);
		builder.append(", questionId=");
		builder.append(questionId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", examId=");
		builder.append(examId);
		builder.append(", createdtime=");
		builder.append(createdtime);
		builder.append(", actuallyAns=");
		builder.append(actuallyAns);
		builder.append("]");
		return builder.toString();
	}

}