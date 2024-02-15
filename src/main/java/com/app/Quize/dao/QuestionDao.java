package com.app.Quize.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.Quize.model.Questions;
@Repository

public interface QuestionDao extends JpaRepository<Questions, Integer>{
   List<Questions>findByCategory(String catgory);
   
   @Query(value=" SELETC * FROM questions q where q.category=category ORDER BY RANDOM() LIMIT:numQ",nativeQuery = true)
   List<Questions> findRandomQustionsFromCategory(String category, int numQ);
	   
   
}
