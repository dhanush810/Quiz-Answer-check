package com.dhanush.AnswerCheck.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhanush.AnswerCheck.Repository.PlayerRepository;
import com.dhanush.AnswerCheck.Repository.QuestionRepository;
import com.dhanush.AnswerCheck.model.Player;
import com.dhanush.AnswerCheck.model.Quiz;

@Service
public class GameService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public boolean answerQuestion(String playerId, String questionId, String answer) {
        Player player = playerRepository.findById(playerId)
                                         .orElseThrow(() -> new IllegalArgumentException("Player not found"));
        Quiz question = questionRepository.findById(questionId)
                                              .orElseThrow(() -> new IllegalArgumentException("Question not found"));

        boolean isCorrect = answer.equals(question.getCorrectAnswer());
        int score = calculateScore(isCorrect);
        player.setScore(player.getScore() + score);
        playerRepository.save(player);

        return isCorrect;
    }

    private int calculateScore(boolean isCorrect) {
        return isCorrect ? 100 : 0; // Adjust the score calculation as needed
    }
}
