package br.ufms.jasane.ia.caixeiro.oo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtils {

	public int[][] readRquestFile() {
		int[][] prices;
		File origin = new File("cities.json");
		try {
			FileReader reader = new FileReader(origin);
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			JSONArray pricesArray = (JSONArray) jsonObject.get("prices");

//			prices new int[pricesArray.size()][]	;
			
			
			System.out.println(Math.sqrt(pricesArray.size()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int[][] sendResponseFile() {
		throw new UnsupportedOperationException();
	}
}
