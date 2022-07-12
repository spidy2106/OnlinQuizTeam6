package com.quiz.service;

import java.util.List;

import com.quiz.model.QuizScore;

public interface ScoreCrud {
	
	int insertScore(QuizScore quizscore);
	int updateScore(QuizScore quizscore);
	int deleteScore(int studentid);
	List<QuizScore> getAllScores();
	List<QuizScore> getScoresByTeacherId(int teacherid);
	List<QuizScore> getScoresByTestId(int testid);
	QuizScore getScoreByStudentId(int studentid);
	
	

}
