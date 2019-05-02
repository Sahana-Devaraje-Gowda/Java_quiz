package com.quizmanager.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ExamDetails_tab")
public class ExamDetails {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer examId;
	@Column
	private String createdBy;
	@Column
	private String description;
	@Column
	private Date createdOn;
	@Column
	private String examStatus;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "examId", referencedColumnName = "examId")
	private List<Question> questions;

	/**
	 * @return the examId
	 */
	public Integer getExamId() {
		return examId;
	}

	/**
	 * @param examId the examId to set
	 */
	public void setExamId(Integer examId) {
		this.examId = examId;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the examStatus
	 */
	public String getExamStatus() {
		return examStatus;
	}

	/**
	 * @param examStatus the examStatus to set
	 */
	public void setExamStatus(String examStatus) {
		this.examStatus = examStatus;
	}

	/**
	 * @return the questions
	 */
	public List<Question> getQuestions() {
		return questions;
	}

	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExamDetails [examId=");
		builder.append(examId);
		builder.append(", createdBy=");
		builder.append(createdBy);
		builder.append(", description=");
		builder.append(description);
		builder.append(", createdOn=");
		builder.append(createdOn);
		builder.append(", examStatus=");
		builder.append(examStatus);
		builder.append(", questions=");
		builder.append(questions);
		builder.append("]");
		return builder.toString();
	}

}