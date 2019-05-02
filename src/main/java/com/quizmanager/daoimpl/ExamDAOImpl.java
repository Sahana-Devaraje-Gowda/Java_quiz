/**
 * 
 */
package com.quizmanager.daoimpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.quizmanager.dao.ExamDAO;
import com.quizmanager.dto.ExamDetails;
import com.quizmanager.dto.ExamHistory;
import com.quizmanager.dto.Question;

/**
 * @author sahana
 *
 */
@Repository
public class ExamDAOImpl implements ExamDAO {

	@Autowired
	HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	@Transactional
	public List<ExamDetails> getAllExamList() {
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from ExamDetails");
		return query.list();
	}

	@Transactional
	public ExamDetails getQuestionsByExamID(Integer examID) {
		return hibernateTemplate.get(ExamDetails.class, examID);
	}

	@Transactional
	public Serializable saveExamHistory(ExamHistory examHistory) {
		return hibernateTemplate.save(examHistory);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Question getQuestionsbyID(Integer qid, Integer examId) {
		
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery("from Question where qid=? and examId=?");
		query.setParameter(0, qid);
		query.setParameter(1, examId);
		List<Question> arrayList = query.list();
		Question getquestion = null;
		if (!arrayList.isEmpty()) {
			getquestion = new Question();
			for (Question question : arrayList) {
				getquestion = question;
			}

		}
		return getquestion;
	}

	@Transactional
	public Question getQuestionByID(Integer qid) {
		return hibernateTemplate.get(Question.class, qid);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<ExamHistory> getExamresult(String examId, String userId) {
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery("from ExamHistory where UserId=? and examId=?");
		query.setParameter(0, userId);
		query.setParameter(1, examId);
		return query.list();
	}

	@Transactional
	public ExamDetails saveExamDetails(ExamDetails examDetails2) {
		if (examDetails2.getExamId() != null) {
			ExamDetails details = getQuestionsByExamID(examDetails2.getExamId());
			List<Question> ques = examDetails2.getQuestions();
			List<Question> dump = details.getQuestions();
			for (Question question : ques) {
				dump.add(question);
				details.setQuestions(dump);
			}
			hibernateTemplate.saveOrUpdate(details);
		} else {
			hibernateTemplate.saveOrUpdate(examDetails2);
			return examDetails2;
		}
		return examDetails2;

	}

	@Transactional
	public void deleteExamHistory(ExamHistory examHistory) {
		hibernateTemplate.delete(examHistory);
	}

}
