package animalGame;

import java.io.IOException;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

/**
 * 
 * @author Pratik Bidkar
 * This class behaves like a factory and will give you the appropriate JSON
 * that will be required at the runtime
 */
public class Factory {
	
	public Factory(){}
	
	public void JSONQuestionObject(String questionKey, QuestionXML qnsObj) throws JSONException, IOException, ParseException{
		
		if(questionKey.equalsIgnoreCase("fishes")){
			ParentJson jsonObject = new FishJSON();
			jsonObject.showAllQuestions(questionKey,"fish.json");
		}
		else if(questionKey.equalsIgnoreCase("amphibians")){
			ParentJson jsonObject = new AmphibianJSON();
			jsonObject.showAllQuestions(questionKey,"amphibian.json");
		}
		else if(questionKey.equalsIgnoreCase("mammals")){
			ParentJson jsonObject = new MammalJSON();
			jsonObject.showAllQuestions(questionKey,"mammals.json");
		}
		else if(questionKey.equalsIgnoreCase("birds")){
			ParentJson jsonObject = new BirdsJSON();
			jsonObject.showAllQuestions(questionKey,"birds.json");
		}
		else if(questionKey.equalsIgnoreCase("reptiles")){
			ParentJson jsonObject = new ReptilesJSON();
			jsonObject.showAllQuestions(questionKey,"reptiles.json");
		}
		
	}

}
