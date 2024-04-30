package com.dhanush.AnswerCheck.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dhanush.AnswerCheck.model.Player;

public interface PlayerRepository extends MongoRepository<Player, String>{
	
}
