package com.quiz.model;

public class QuizScore {
	
	 private int studentid;
	 private int teacherid;
	 private int testid;
	 private int score;
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	public int getTestid() {
		return testid;
	}
	public void setTestid(int testid) {
		this.testid = testid;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public QuizScore(int studentid, int teacherid, int testid, int score) {
		super();
		this.studentid = studentid;
		this.teacherid = teacherid;
		this.testid = testid;
		this.score = score;
	}
	 
	 
	

}
