package animalGame;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * This class contains the mapper json which contains the mapping for 
 * json keys and its respective nested json keys.
 * The method displays the questions from the respective json file
 * The function parses the json file, extracts the json
 * @author Pratik Bidkar
 *
 */
abstract class JsonMapper {
	
	public static JSONArray loadFromMapper(String keyToMatch) throws IOException, ParseException, JSONException{
		FileReader reader = null;
		reader = new FileReader("mapper.json");
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(reader);
		JSONObject jsonObj = new JSONObject(obj.toString());
		
		 Iterator<?> keys = jsonObj.keys();

	        while( keys.hasNext() ){
	            String key = (String)keys.next();
	            if(key.equalsIgnoreCase(keyToMatch)){
	            	return (JSONArray)jsonObj.get(key);
	            }
	            
	        }
	        reader.close();        
	return null;
		
	}
	

}
