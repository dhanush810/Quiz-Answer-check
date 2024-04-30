package com.dhanunsh.AnswerCheck.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dhanush.AnswerCheck.Repository.PlayerRepository;
import com.dhanush.AnswerCheck.Service.GameService;
import com.dhanush.AnswerCheck.model.Player;


@RestController
public class MainController {
	
	 @Autowired
	 private GameService gameService;
	 
	 @Autowired
	 private PlayerRepository playerRepository;

	    @PostMapping("/answer")
	    public ResponseEntity<String> answerQuestion(@RequestParam String playerId,
	                                                 @RequestParam String questionId,
	                                                 @RequestParam String answer) {
	        boolean isCorrect = gameService.answerQuestion(playerId, questionId, answer);
	        if (isCorrect) {
	            return ResponseEntity.ok("Correct answer! Points awarded.");
	        } else {
	            return ResponseEntity.ok("Incorrect answer! No points awarded.");
	        }
	    }
	    @GetMapping("/quiz")
	    public List<Player> getAllPlayers() {
	        return playerRepository.findAll();
	    }
}
