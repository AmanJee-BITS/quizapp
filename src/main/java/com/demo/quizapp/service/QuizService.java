package com.demo.quizapp.service;

import com.demo.quizapp.dao.QuestionDao;
import com.demo.quizapp.dao.QuizDao;
import com.demo.quizapp.model.Question;
import com.demo.quizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String language, int numQ, String title) {

        List<Question> questions = questionDao.findRandomQuestionsByLanguage(language, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
}
