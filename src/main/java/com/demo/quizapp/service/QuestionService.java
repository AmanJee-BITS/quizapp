package com.demo.quizapp.service;

import com.demo.quizapp.Question;
import com.demo.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionsByLanguage(String language) {
        return questionDao.findByLanguage(language);
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "Success";
    }
}