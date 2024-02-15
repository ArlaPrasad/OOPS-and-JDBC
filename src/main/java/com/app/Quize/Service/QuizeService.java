package com.app.Quize.Service;

import java.util.ArrayList;
import java.util.List;

import org.apache.el.stream.Optional;
import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.Quize.dao.QuestionDao;
import com.app.Quize.dao.QuizeDao;
import com.app.Quize.model.QuestionWrapper;
import com.app.Quize.model.Questions;
import com.app.Quize.model.Quize;
import com.app.Quize.model.Response;

@Service
public class QuizeService {
	@Autowired
	QuizeDao quizeDao;
	@Autowired
	QuestionDao questiondao;

	public ResponseEntity<String> createQuize(String category, int numQ, String title) {
		List<Questions> questions= questiondao.findRandomQustionsFromCategory(category,numQ);
		
		 Quize quize=new Quize();
		 quize.setTitle(title);
		 quize.setQuestions(questions);
		 quizeDao.save( quize);
		 return new ResponseEntity<>("status",HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizeQuestions(Integer id) {
		 Optional<Quize> quize=quizeDao.findById(id);
		 List<Questions> questionsFromDB=quize.get().getQuestions();
		 List<QuestionWrapper> questionForUser=new ArrayList<>();
		 for(Question q : questionsFromDB) {
			 QuestionWrapper questionwrapper=new QuestionWrapper(q.getId(),q.getQuestionsTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			 questionForUser.add(qw);
		 }
		 return new ResponseEntity<>(questionForUser,HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> response) {
	 
		Quize quize=quizeDao.findById(id).get();
		List<Questions> questions=quize.getQuestion();
		int right=0;
		int i=0;
		for(Response response:responses) {
			if(response.getResponse.equals(questions.get(i).getRightAnswer()));
			right++;
			
			i++;
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}
	

}
