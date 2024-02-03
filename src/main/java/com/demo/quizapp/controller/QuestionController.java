package com.demo.quizapp.controller;

import com.demo.quizapp.Question;
import com.demo.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @GetMapping("/allQuestions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/language/{language}")
    public List<Question> getQuestionsByLanguage(@PathVariable String language){
        return questionService.getQuestionsByLanguage(language);
    }

    @PostMapping("/add")
    public String addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
}
