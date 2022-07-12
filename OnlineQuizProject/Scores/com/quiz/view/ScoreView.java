package com.quiz.view;

import java.util.List;
import java.util.Scanner;

import com.quiz.controller.ScoreController;
import com.quiz.model.QuizScore;

public class ScoreView {
	public static void main(String[] args) throws Exception {
        ScoreController scorectl = new ScoreController();
        int result;
        QuizScore quizscore = null;
        int studentid;
        int testid = 0;
        int teacherid = 0;
        int score;
        int choice;
        while(true)
        {
        	System.out.println("1. Add Score");
    		System.out.println("2. Update Score");
    		System.out.println("3. Delete Score");
    		System.out.println("4. View All Scores");
    		System.out.println("5. View a Student Mark");
    		System.out.println("0. Exit ");
    		Scanner sc = new Scanner(System.in);
    		System.out.println("Enter your choice");
    		 choice = sc.nextInt();
    
        switch (choice) {
		case 1:
			System.out.println("Enter Student Id, Test Id, Teacher Id, Score");
			studentid = sc.nextInt();
			testid=sc.nextInt();
			teacherid=sc.nextInt();
			score=sc.nextInt();
			quizscore = new QuizScore(studentid,testid,teacherid,score);
			result = scorectl.insertScore(quizscore);
			if (result > 0)
				System.out.println("Score Inserted");
			else
				System.out.println("Score not inserted");
			break;
			
		case 2:
			System.out.println("Enter Student Id, Test Id, Teacher Id, Score");
			studentid = sc.nextInt();
			testid=sc.nextInt();
			teacherid=sc.nextInt();
			score=sc.nextInt();
			quizscore = new QuizScore(studentid,testid,teacherid,score);
			result = scorectl.updateScore(quizscore);
			if (result > 0)
				System.out.println("Score Updated");
			else
				System.out.println("Score not Updated");
			break;
		case 3:
			System.out.println("Enter Studentid");
			studentid=sc.nextInt();
			result=scorectl.deleteScore(studentid);
			if (result > 0)
				System.out.println("Score deleted");
			else
				System.out.println("Score not found");
			break;
			
		case 4:
			
			List<QuizScore> list=scorectl.getAllScores();
			for(QuizScore qs : list){
				System.out.println(qs.getStudentid()+"\t"+qs.getTestid()+" "+qs.getTeacherid()+" "+qs.getScore());
			}
		break;
		case 5:
			System.out.println("Enter studentid");
			studentid=sc.nextInt();
			quizscore=scorectl.getScoreByStudentId(studentid);
			System.out.println("Student ID: "+ quizscore.getStudentid());
			System.out.println("Test ID: "+ quizscore.getTestid());
			System.out.println("Teacher ID: "+ quizscore.getTeacherid());
			System.out.println("Score: "+ quizscore.getScore());
			
		break;	
		case 0: System.exit(0);
        
      
        
	}
        }
	}
	

        }
