package animalGame;

import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FishJSON extends ParentJson{
	
	JSONObject fishJSONQuestionStore = new JSONObject();
	
	public FishJSON() throws JSONException, IOException{
		
	}
	
	
	private JSONObject addQuestions() throws JSONException, IOException{
				
		JSONObject dolphinarr = new JSONObject();
		dolphinarr.append("dolphin","Is it often found in captivity");
		dolphinarr.append("dolphin","Does the animal make sweet sounds underwater");
		dolphinarr.append("dolphin","Does it have great speeds");
		dolphinarr.append("dolphin","Is it found in rivers also");
		dolphinarr.append("dolphin","Is it found in gray, blakc and white colors");
		dolphinarr.append("dolphin","Does it frequently come out of water to breathe");
		dolphinarr.append("dolphin","Are you thinking of a dolphin");
		//dolphinarr.toJSONObject(dolphinarr);
		
		JSONObject sharkArray = new JSONObject();
		sharkArray.append("shark","Is it rarely found in captivity");
		sharkArray.append("shark","Is the most dangerous predator of oceans");
		sharkArray.append("shark","Does it have great speeds");
		sharkArray.append("shark","Is it found in gray and white colors");
		sharkArray.append("shark","Does it have strongest and sharpest teeth");
		sharkArray.append("shark","Are you thinking of a shark");
		
		this.fishJSONQuestionStore.append("fishes", dolphinarr );
		this.fishJSONQuestionStore.append("fishes", sharkArray );
		
		FileWriter file = new FileWriter("fishJSON.txt");
		file.write(this.fishJSONQuestionStore.toString());
        System.out.println("Successfully Copied JSON Object to File...");
		return this.fishJSONQuestionStore;
	}

}
