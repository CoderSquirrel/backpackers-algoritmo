package br.ufms.jasane.ia.caixeiro.oo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonUtils {

	public Double[][] readRquestFile(JSONObject obj) {
		Double[][] prices;
		JSONArray pricesArray = (JSONArray) obj.get("prices");
		prices = new Double[pricesArray.size()][pricesArray.size()];
		for (int i = 0; i < pricesArray.size(); i++) {
			JSONObject tmp = (JSONObject) pricesArray.get(i);
			for (int j = 0; j < tmp.size(); j++) {
				JSONObject aux = (JSONObject) tmp.get("" + j + "");
				String n = aux.get("price").toString();
				prices[i][j] = Double.parseDouble(n);
			}
		}
		for (int i = 0; i < prices.length; i++) {
			for (int j = 0; j < prices.length; j++) {
				System.out.print(prices[i][j] + " | ");
			}
			System.out.println("");
		}

		return prices;
	}

	public int[][] sendResponseFile() {
		throw new UnsupportedOperationException();
	}
}
