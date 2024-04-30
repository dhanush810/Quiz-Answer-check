package com.dhanush.AnswerCheck.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dhanush.AnswerCheck.model.Quiz;

public interface QuestionRepository extends MongoRepository<Quiz,String>{

}
