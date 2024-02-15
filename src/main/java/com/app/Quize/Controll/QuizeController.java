package com.app.Quize.Controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.Quize.Service.QuizeService;
import com.app.Quize.model.QuestionWrapper;
import com.app.Quize.model.Response;
@RestController
@RequestMapping("quize")
public class QuizeController {
	@Autowired
	QuizeService quizeService;
	
	@PostMapping("create")
	public ResponseEntity< String> createQuize(@RequestParam String category,@RequestParam int numQ,@RequestParam String title ){
		return quizeService .createQuize("category",numQ,"title");
	}
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizeQuestions(@PathVariable Integer id){
		return quizeService.getQuizeQuestions(id);
	}
	@PostMapping("submit/id")
	public ResponseEntity<Integer> submitQuize(@PathVariable Integer id,@RequestBody List<Response> response){
		 
		return  quizeService.calculateResult(id,response);
	}
	 

}
