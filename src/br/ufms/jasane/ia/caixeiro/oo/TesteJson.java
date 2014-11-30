package br.ufms.jasane.ia.caixeiro.oo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TesteJson {

	public static void main(String[] args) {
		JsonUtils jutils = new JsonUtils();
		File origin = new File("cidades.json");
		FileReader reader;
		try {
			reader = new FileReader(origin);
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			// jutils.readRquestFile(jsonObject);
			readRquestFile(jsonObject);
			//
			// JSONObject obj = new JSONObject();
			// JSONArray array1 = new JSONArray();
			// for (int i = 0; i < 4; i++) {
			// JSONArray tmp = new JSONArray();
			// for (int j = 0; j < 4; j++) {
			// tmp.add(Double.parseDouble(j + ""));
			// }
			// array1.add(tmp);
			// }
			//
			// obj.put("prices", array1);
			//
			// System.out.println(obj.toJSONString());
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

	}

	public static void readRquestFile(JSONObject obj) {
		Double[][] prices;
		JSONArray pricesArray = (JSONArray) obj.get("prices");
		prices = new Double[pricesArray.size()][pricesArray.size()];
		for (int i = 0; i < pricesArray.size(); i++) {
			JSONArray tmp = (JSONArray) pricesArray.get(i);
			// JSONObject tmp = (JSONObject) pricesArray.get(i);
			for (int j = 0; j < tmp.size(); j++) {
				String aux = "" + tmp.get(j);
				Double n = Double.parseDouble(aux);
				prices[i][j] = n;
			}
		}
		for (int i = 0; i < prices.length; i++) {
			for (int j = 0; j < prices.length; j++) {
				System.out.print(prices[i][j] + " | ");
			}
			System.out.println("");
		}

	}

}
