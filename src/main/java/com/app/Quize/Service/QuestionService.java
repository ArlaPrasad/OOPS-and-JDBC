package com.app.Quize.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.Quize.dao.QuestionDao;
import com.app.Quize.model.Questions;

@Service
public class QuestionService {
	@Autowired
	QuestionDao questiondao;

	public  ResponseEntity<List<Questions>> getAllQuestions() {
		try {
		 return new ResponseEntity<>( questiondao. findAll(),HttpStatus.OK);
	}catch (Exception e) {
		 e.printStackTrace();
	}
		 return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		
	}

	public ResponseEntity<List<Questions>> getQuestionsByCategory(String category) {
		try {
			 return new ResponseEntity<>( questiondao. findAll(),HttpStatus.OK);
		}catch (Exception e) {
			 e.printStackTrace();
		}
			 return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
			
	}

	public String addQuestions(Questions question) {
		 questiondao.save(question);
		 return "success";
	}

}
