/**
 * 
 */
package com.quizmanager.service;

import java.util.List;

import com.quizmanager.dto.CreateExam;
import com.quizmanager.dto.ExamDetails;
import com.quizmanager.dto.Question;

/**
 * @author sahana
 *
 */
public interface ExamService {

	public List<ExamDetails> getExamDetailsList();

	public ExamDetails getQuestionsByExamID(Integer examID);

	public String saveuserselectedAnswer(String ans, String qid, String userId);

	public Question getQuestionsbyID(Integer qid,Integer examId);

	public void saveExamHistory(String useremail, Integer qid, String options, String examId);

	public String submitExam(String examId, String userId);

	public ExamDetails createQuiz(CreateExam examDetails, String useremail, String examID);
}
