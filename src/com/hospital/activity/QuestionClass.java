package com.hospital.activity;
import java.util.ArrayList;
class QuestionClass {
	private String questionText;
	private ArrayList<String> answers;
	private int answer;
	QuestionClass(String aQuestionText, ArrayList<String> aAnswers, int aAnswer) {
		this.questionText=new String(aQuestionText);
		this.answers=aAnswers;
		this.answer=aAnswer;
	}
	public String getQuestionText() {
		return questionText;
	}
	public ArrayList<String> getAnswers() {
		return answers;
	}
	public int getAnswer() {
		return answer;
	}
}