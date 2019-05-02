package com.quizmanager.dao;

import java.io.Serializable;
import java.util.List;

import com.quizmanager.dto.ExamDetails;
import com.quizmanager.dto.ExamHistory;
import com.quizmanager.dto.Question;

public interface ExamDAO {

	public List<ExamDetails> getAllExamList();

	ExamDetails getQuestionsByExamID(Integer examID);

	public Serializable saveExamHistory(ExamHistory examHistory);

	public Question getQuestionsbyID(Integer qid, Integer examID);

	public List<ExamHistory> getExamresult(String examId, String userId);

	public ExamDetails saveExamDetails(ExamDetails examDetails2);

	Question getQuestionByID(Integer id);

	public void deleteExamHistory(ExamHistory examHistory);
}
