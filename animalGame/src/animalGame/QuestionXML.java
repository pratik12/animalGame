package animalGame;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;

public class QuestionXML {

	private HashMap<String, String> questions = new HashMap<String,String>();

	public QuestionXML(){
		
	}
	

	public HashMap<String, String> getQuestions() {
		return questions;
	}

	public void setQuestions(String category, String question) {
		if(category!=null && question!=null)
			this.questions.put(category, question);
		else
			System.out.println("String input cannot be null");
	}
	
	
}
