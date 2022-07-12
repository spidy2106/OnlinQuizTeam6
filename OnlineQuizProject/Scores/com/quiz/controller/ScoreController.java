package com.quiz.controller;

import java.util.List;

import com.quiz.model.QuizScore;
import com.quiz.service.ScoreService;

public class ScoreController {
	
	ScoreService scoreservice;


	public ScoreController() {
		scoreservice = new ScoreService();
	}


	public int insertScore(QuizScore quizscore) {
		
		int result=scoreservice.insertScore(quizscore);	
		return result;
	}

	
	public int updateScore(QuizScore quizscore) {
		
		int result=scoreservice.updateScore(quizscore);	
		return result;
	}

	
	public int deleteScore(int studentid) {
		
		int result=scoreservice.deleteScore(studentid);
		return result;
	}

	
	public List<QuizScore> getAllScores() {
		List<QuizScore> list = scoreservice.getAllScores();
		return list;
	}

	
	public List<QuizScore> getScoresByTeacherId(int teacherid) {
		List<QuizScore> list = scoreservice.getScoresByTeacherId(teacherid);
		return list;

	}

	
	public List<QuizScore> getScoresByTestId(int testid) {
		
		List<QuizScore> list = scoreservice.getScoresByTestId(testid);
		return list;

	}

	
	public QuizScore getScoreByStudentId(int studentid) {
		
		QuizScore quizscore = scoreservice.getScoreByStudentId(studentid);
		return quizscore;
	}
}
