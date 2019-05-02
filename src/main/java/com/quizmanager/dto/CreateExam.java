package com.quizmanager.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class CreateExam {

	private String description;

	private String question;

	private String correctAnswer;

	private String a;

	private String b;

	private String c;

	private String d;

	private String examId;

	private String typeofQuestion;
	
	
	/**
	 * @return the typeofQuestion
	 */
	public String getTypeofQuestion() {
		return typeofQuestion;
	}

	/**
	 * @param typeofQuestion the typeofQuestion to set
	 */
	public void setTypeofQuestion(String typeofQuestion) {
		this.typeofQuestion = typeofQuestion;
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
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the correctAnswer
	 */
	public String getCorrectAnswer() {
		return correctAnswer;
	}

	/**
	 * @param correctAnswer the correctAnswer to set
	 */
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CreateExam [description=");
		builder.append(description);
		builder.append(", question=");
		builder.append(question);
		builder.append(", correctAnswer=");
		builder.append(correctAnswer);
		builder.append(", a=");
		builder.append(a);
		builder.append(", b=");
		builder.append(b);
		builder.append(", c=");
		builder.append(c);
		builder.append(", d=");
		builder.append(d);
		builder.append("]");
		return builder.toString();
	}

}