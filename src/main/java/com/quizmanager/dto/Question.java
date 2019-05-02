package com.quizmanager.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer qid;

	@Column
	private String questiondescrption;

	@Column
	private String question;

	@Column(name = "answer")
	private String correctAnswer;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)

	private Answers answers;

	/**
	 * @return the qid
	 */
	public Integer getQid() {
		return qid;
	}

	/**
	 * @param qid the qid to set
	 */
	public void setQid(Integer qid) {
		this.qid = qid;
	}

	/**
	 * @return the questiondescrption
	 */
	public String getQuestiondescrption() {
		return questiondescrption;
	}

	/**
	 * @param questiondescrption the questiondescrption to set
	 */
	public void setQuestiondescrption(String questiondescrption) {
		this.questiondescrption = questiondescrption;
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
	 * @return the answers
	 */
	public Answers getAnswers() {
		return answers;
	}

	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(Answers answers) {
		this.answers = answers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Question [qid=");
		builder.append(qid);
		builder.append(", questiondescrption=");
		builder.append(questiondescrption);
		builder.append(", question=");
		builder.append(question);
		builder.append(", correctAnswer=");
		builder.append(correctAnswer);
		builder.append(", answers=");
		builder.append(answers);
		builder.append("]");
		return builder.toString();
	}

}