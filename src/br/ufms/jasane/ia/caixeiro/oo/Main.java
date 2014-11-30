package br.ufms.jasane.ia.caixeiro.oo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {
	/**
	 * funcao fitness ou custo quando o valor minino não mudar a cada tantas
	 * gerações
	 * 
	 * @param args
	 */
	static int geracao = 1;
	static int TAXA_MUTACAO = 6;
	static int TAXA_CRUZAMENTO = 3;
	static int TAXA_SELECAO = 5;
	static int MINIMO = 50;
	static int POPULACAO_INICIAL = 20;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		ArrayList<Trajeto> populacao = new ArrayList<Trajeto>();
		Random aleatorio = new Random();
		 File origin = new File("cities.json");
//		File origin = new File(args[0]);
		// File output = new File("result.json");
		FileReader reader;
		FileWriter writer;
		try {
			reader = new FileReader(origin);
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			Distancias.matriz = JsonUtils.readRquestFile(jsonObject);
			Caixeiro.SIZE = Distancias.matriz.length - 1;
			Caixeiro.sort = new int[Distancias.matriz.length];
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

		for (int i = 0; i < POPULACAO_INICIAL; i++) {
			populacao.add(Caixeiro.criar());
		}
		System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
		Collections.sort(populacao);

		Trajeto menor = populacao.get(0);
		double menorAnterior = menor.getDistancia(), menorAtual = 0;

		ArrayList<Trajeto> popAux = new ArrayList<Trajeto>();
		int menorDurante = 0;
		while (menorDurante < MINIMO) {

			int taxa = aleatorio.nextInt(TAXA_SELECAO);
			for (int i = 0; i < taxa; i++) {
				Trajeto novo = new Trajeto(Caixeiro.selecaoRoleta(populacao)
						.getVetor());
				popAux.add(novo);
			}

			if (aleatorio.nextInt(10) < TAXA_CRUZAMENTO) {

				Trajeto filho = Caixeiro.cruzamento(
						populacao.get(aleatorio.nextInt(populacao.size())),
						populacao.get(aleatorio.nextInt(populacao.size())));
				popAux.add(filho);
			}
			if (aleatorio.nextInt(10) < TAXA_MUTACAO) {
				int posMut = aleatorio.nextInt(populacao.size());
				populacao.set(posMut, Caixeiro.mutacao(populacao.get(posMut)));
			}
			if (popAux.size() != 0) {
				populacao = popAux;
				System.setProperty("java.util.Arrays.useLegacyMergeSort",
						"true");
				Collections.sort(populacao);
				Trajeto menorGeracao = populacao.get(0);
				menorAtual = menorGeracao.getDistancia();
				if (menorAtual == menorAnterior) {
					menorDurante++;
				} else if (menorAtual < menorAnterior) {
					menorDurante = 0;
					menorAnterior = menorAtual;
				} else if (menorAtual > menorAnterior) {
					menorDurante = 0;
					menorAnterior = menorAtual;
				}
			} else {
			}
			geracao++;
		}
		System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
		Collections.sort(populacao);

		// try {
		// writer = new FileWriter(output);
		// writer.append(JsonUtils.sendResponseFile(populacao.get(0))
		// .toJSONString());
		// writer.flush();
		// writer.close();
		JsonUtils.sendResponseFile(populacao.get(0));
		// .toJSONString());
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}
}
