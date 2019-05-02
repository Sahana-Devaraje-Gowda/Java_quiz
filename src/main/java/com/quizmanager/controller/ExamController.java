/**
 * 
 */
package com.quizmanager.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.quizmanager.dto.CreateExam;
import com.quizmanager.dto.ExamDetails;
import com.quizmanager.dto.Question;
import com.quizmanager.service.ExamService;

/**
 * @author sahana
 *
 */

@RestController
public class ExamController {

	@Autowired
	@Qualifier("examService2")
	ExamService examService;
	
	@Autowired
	HttpSession httpsession;

	@GetMapping("/ExamDetails")
	public List<ExamDetails> examDetails() {
		return examService.getExamDetailsList();
	}

	@PostMapping("/startExam")
	public ExamDetails startExam(@RequestBody ExamDetails examDetails) {
		httpsession.setAttribute("examId", examDetails.getExamId());
		return examService.getQuestionsByExamID(examDetails.getExamId());
	}

	@GetMapping("/startExam")
	public ModelAndView getstartExam() {
		String email = (String) httpsession.getAttribute("email");
		ModelAndView andView = null;
		if (email == null) {
			andView = new ModelAndView("login");
		} else {
			andView = new ModelAndView("quizPaly");
		}
		return andView;
	}

	@PostMapping("/submitExam")
	public String submitExam() {
		Integer examId = (Integer) httpsession.getAttribute("examId");
		String usermail = (String) httpsession.getAttribute("email");
		return examService.submitExam(Integer.toString(examId), usermail);

	}
	

	@PostMapping("/getQuestionsbyID/{qid}/{options}")
	public Question getQuestionsbyID(@PathVariable Integer qid, @PathVariable String options) {
		String useremail = (String) httpsession.getAttribute("email");
		Integer examId = (Integer) httpsession.getAttribute("examId");
		examService.saveExamHistory(useremail, qid, options, Integer.toString(examId));
		Question question = examService.getQuestionsbyID(qid, examId);
		if (question == null) {
			throw new NullPointerException("Exam has Ended");
		}
		return question;
	}

	@GetMapping("/createQuiz")
	public ModelAndView createQuiz() {
		String email = (String) httpsession.getAttribute("email");
		ModelAndView andView = null;
		if (email == null) {
			andView = new ModelAndView("login");
		} else {
			andView = new ModelAndView("createQuiz");
		}
		return andView;
	}

	@PostMapping("/createQuiz")
	public ExamDetails createQuiz(@RequestBody CreateExam examDetails) {
		if (!examDetails.getA().equals("") && !examDetails.getB().equals("") && !examDetails.getC().equals("")
				&& !examDetails.getCorrectAnswer().equals("") && !examDetails.getD().equals("")
				 && !examDetails.getQuestion().equals("")) {
			
			String useremail = (String) httpsession.getAttribute("email");
			String examID = (String) httpsession.getAttribute("detailsExamId");
			ExamDetails details = examService.createQuiz(examDetails, useremail, examID);

			if (details != null) {
				httpsession.setAttribute("detailsExamId", Integer.toString(details.getExamId()));
			}
			return details;
		} else {
			throw new NullPointerException();
		}
	}

	@GetMapping("/invalidsession")
	public String invalidsession() {
		httpsession.removeAttribute("detailsExamId");
		return "";
	}

}
