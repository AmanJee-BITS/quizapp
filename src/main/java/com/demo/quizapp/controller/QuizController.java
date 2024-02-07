package com.demo.quizapp.controller;

import com.demo.quizapp.model.QuestionWrapper;
import com.demo.quizapp.model.UserResponse;
import com.demo.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String language, @RequestParam int numQ, @RequestParam String title) {
        return quizService.createQuiz(language, numQ, title);
    }

    @GetMapping("/get/{quizId}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer quizId) {
        return quizService.getQuizQuestions(quizId);
    }

    @PostMapping("/submit/{quizId}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer quizId, @RequestBody List<UserResponse> responses) {
        return quizService.calculateResult(quizId, responses);
    }
}
