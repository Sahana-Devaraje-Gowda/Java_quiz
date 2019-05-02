/**
 * 
 */
package com.quizmanager.serviceimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizmanager.dao.ExamDAO;
import com.quizmanager.dto.Answers;
import com.quizmanager.dto.CreateExam;
import com.quizmanager.dto.ExamDetails;
import com.quizmanager.dto.ExamHistory;
import com.quizmanager.dto.Question;
import com.quizmanager.service.ExamService;
import com.quizmanager.utill.ResultsEmailImpl;

/**
 * @author sahana
 *
 */
@Service("examService2")
public class ExamServiceImpl implements ExamService {

	@Autowired
	ExamDAO examDAO;

	@Autowired
	ResultsEmailImpl resultsEmailImpl;

	@Override
	public List<ExamDetails> getExamDetailsList() {
		return examDAO.getAllExamList();
	}

	@Override
	public ExamDetails getQuestionsByExamID(Integer examID) {
		ExamDetails examDetails = null;

		if (examID != null) {
			examDetails = examDAO.getQuestionsByExamID(examID);
		}
		return examDetails;
	}

	@Override
	public String saveuserselectedAnswer(String ans, String qid, String userId) {

		ExamHistory examHistory = new ExamHistory();
		String msg = "";
		if (userId != null && qid != null) {

			examHistory.setUserId(userId);
			examHistory.setQuestionId(Integer.parseInt(qid));
			if (ans == null) {
				ans = "Not Selected";
			}
			examHistory.setAns(ans);
			examHistory.setCreatedtime(new Date());
			Serializable id = examDAO.saveExamHistory(examHistory);
			int value = (int) id;
			if (value > 0) {
				msg = "saved";
			} else {
				msg = "fail";
			}
		}
		return msg;
	}

	@Override
	public Question getQuestionsbyID(Integer qid, Integer examId) {
		Question question = examDAO.getQuestionsbyID(qid + 1, examId);
		if (question == null) {
			if (qid < 500) {
				Question question1 = this.getQuestionsbyID(qid + 1, examId);
				if (question1 != null) {
					return question1;
				}}
			
		}
		return question;
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void saveExamHistory(String useremail, Integer qid, String options, String examId) {
		if (useremail != null && qid != null && options != null && qid != 0 ) {
			Question question = examDAO.getQuestionByID(qid);
			ExamHistory examHistory = new ExamHistory();
			examHistory.setActuallyAns(question.getCorrectAnswer());
			examHistory.setQuestionId(qid);
			examHistory.setAns(options);
			examHistory.setUserId(useremail);
			examHistory.setExamId(examId);
			examHistory.setCreatedtime(new Date());
			examDAO.saveExamHistory(examHistory);
		}
	}

	@Override
	public String submitExam(String examId, String userId) {
		List<ExamHistory> examHistories = examDAO.getExamresult(examId, userId);
		ExamDetails examdetails = examDAO.getQuestionsByExamID(Integer.parseInt(examId));
		int totlaQuestionssize = examdetails.getQuestions().size();
		Integer correctAns = 0;
		for (ExamHistory examHistory : examHistories) {
			if (examHistory.getActuallyAns().equals(examHistory.getAns())) {
				correctAns++;
			}
		}
		String result = "You got " + correctAns + " out of " + totlaQuestionssize;
		String email = "";
		for (ExamHistory examHistory : examHistories) {
			email = examHistory.getUserId();
			examDAO.deleteExamHistory(examHistory);
		}
		resultsEmailImpl.sendEmail(email, result);
		 System.out.println("result "+correctAns);
		return Integer.toString(correctAns);
	}

	@Override
	public ExamDetails createQuiz(CreateExam examDetails, String useremail, String examID) {
		ExamDetails examDetails2 = null;
		if (examDetails != null) {
			examDetails2 = new ExamDetails();
			examDetails2.setCreatedBy(useremail);
			examDetails2.setCreatedOn(new Date());
			examDetails2.setDescription(examDetails.getDescription());
			examDetails2.setExamStatus("Active");

			List<Question> questions = new ArrayList<Question>();

			Question question = new Question();
			question.setQuestion(examDetails.getQuestion());
			if (examDetails.getCorrectAnswer().equalsIgnoreCase("A")) {
				question.setCorrectAnswer(examDetails.getA());

			} else if (examDetails.getCorrectAnswer().equalsIgnoreCase("B")) {
				question.setCorrectAnswer(examDetails.getB());

			} else if (examDetails.getCorrectAnswer().equalsIgnoreCase("C")) {
				question.setCorrectAnswer(examDetails.getC());

			} else if (examDetails.getCorrectAnswer().equalsIgnoreCase("D")) {
				question.setCorrectAnswer(examDetails.getD());
			} else {
				question.setCorrectAnswer(examDetails.getCorrectAnswer());

			}

			question.setQuestiondescrption(examDetails.getTypeofQuestion());
			Answers answers = new Answers();
			answers.setA(examDetails.getA());
			answers.setB(examDetails.getB());
			answers.setC(examDetails.getC());
			answers.setD(examDetails.getD());

			question.setAnswers(answers);

			questions.add(question);
			examDetails2.setQuestions(questions);

			if (examID != null) {
				examDetails2.setExamId(Integer.parseInt(examID));
			}
			examDetails2 = examDAO.saveExamDetails(examDetails2);
		} else {
				throw new NullPointerException("Invalid Exam Details ");
		}
		return examDetails2;
	}

}
