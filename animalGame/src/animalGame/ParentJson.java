package animalGame;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public abstract class ParentJson {
	
	protected JSONObject jsonQuestionStore = new JSONObject();
	JSONArray jsonArray=null;
	int index = 0;
	public JSONObject getJsonQuestionStore() {
		return jsonQuestionStore;
	}

	public void setJsonQuestionStore(JSONObject jsonQuestionStore) {
		this.jsonQuestionStore = jsonQuestionStore;
	}
	
	
	// declare a json here
	// create it sseter and getter
	// fn which will iterate over json and all its questions, should be overriden
	// by child classes
	// json should store keys similar to xml node attributes and the
	// respective questions
	  public void showAllQuestions(String keys, String filePath) throws JSONException, IOException, ParseException{
		  
		  FileReader reader = null;
		try {
			reader = new FileReader(filePath);
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(reader);
			JSONObject jsonObj = new JSONObject(obj.toString());
			
			jsonArray = (JSONArray)jsonObj.getJSONArray(keys.toLowerCase());
			
			
			JSONObject innerJsonObject = null ;
			
			
			while(index<jsonArray.length()){
				
				innerJsonObject = jsonArray.getJSONObject(index);
				JsonMapper jm = new JsonMapper();
				JSONArray result = jm.loadFromMapper(keys.toLowerCase());
					
					if(result.length()!=0){
						String temp = result.getString(index);
						startQuestions(temp, innerJsonObject);
						index++;
					}
					else{
						System.out.println("json array is empty");
					}
				}
				System.out.println("The type of "+keys.toLowerCase()+"  you are guessing is not in the database");
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		   
	  }

	private void startQuestions(String temp2, JSONObject innerJsonObject) throws JSONException {
		int count = 2 ;
		for(int i =0 ; i<(innerJsonObject.getJSONArray(temp2)).length();i++){
			Scanner in = new Scanner(System.in);
			System.out.println(innerJsonObject.getJSONArray(temp2).getString(i).split(":")[0] + " Enter (Y/N)");
			
			String input = in.next();
			if(input.equalsIgnoreCase("n")&& count!=0 && 
					!(innerJsonObject.getJSONArray(temp2).getString(i).split(":")[1].equalsIgnoreCase(input)) ){
				count--;
				continue;
			}else if(input.equalsIgnoreCase("y") && 
					!(innerJsonObject.getJSONArray(temp2).getString(i).split(":")[1].equalsIgnoreCase(input))){
				count--;
				continue;
			}
			else if(innerJsonObject.getJSONArray(temp2).getString(i).split(":")[1].equalsIgnoreCase(input)){
				continue;
			}
			else if(count==0){
				break;
			}
			System.out.println("Thank you for playing the game!");
			in.close();
			System.exit(0);
		}
	}
	

}
