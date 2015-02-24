package animalGame;

import java.io.IOException;
import java.util.Map.Entry;
import java.util.Scanner;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

/**
 * 
 * @author Pratik Bidkar
 * This class will call the factory method .
 * This class iterates through the xml to ask the initial set of questions at level 1 of
 * logical decision tree
 *
 */
public class PlayGame {
	
	Factory factory = null;
	public void game(String qns,QuestionXML xmlQns) throws JSONException, IOException, ParseException{
		
		if(qns.equalsIgnoreCase("s") && !(xmlQns.getQuestions().isEmpty()) ){
			// start asking qns from xml nodes as filter level 1
			for(Entry<String, String> entry : xmlQns.getQuestions().entrySet()){
				
					factory = new Factory();
					Scanner m = new Scanner(System.in);
					System.out.println(entry.getValue()+"?" + "\n Enter Y or N");
					String answer = m.next();
					
					if(answer.equalsIgnoreCase("Y")){
						// call a method from factory and return the questions from the respective json object
						// get the current xml question, send it alongwith the 
						factory.JSONQuestionObject(entry.getKey(), xmlQns);
						break;
					}
					else if(answer.equalsIgnoreCase("n")){
						// remove the asked question from map and recurse
						xmlQns.getQuestions().remove(entry.getKey());
						game("s",xmlQns);
					}
					else{
						System.out.println("Enter a valid choice (Y/N)");
					}
				
				m.close();
				break;
			}
			
			
		}
		else{
			System.out.println("Enter a valid input");
		}
		
	}

}
