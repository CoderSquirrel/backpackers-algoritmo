package br.ufms.jasane.ia.caixeiro.oo;

public class Trajeto implements Comparable {

	private int vetor[];
	private int distancia;

	public Trajeto(int[] vetor) {
		this.vetor = vetor;
		calcularDistancia();
	}

	public int[] getVetor() {
		return vetor;
	}

	public int getVetorAt(int pos) {
		return this.vetor[pos];
	}

	public void setVetorAt(int pos, int value) {
		this.vetor[pos] = value;
		calcularDistancia();
	}

	public int getDistancia() {
		return distancia;
	}

	private void calcularDistancia() {
		distancia = Distancias.matriz[0][vetor[0]];
		for (int i = 1; i < vetor.length; i++) {
			distancia = distancia + Distancias.matriz[vetor[i - 1]][vetor[i]];
		}
		distancia = distancia + Distancias.matriz[0][vetor[vetor.length - 1]];
	}

	@Override
	public int compareTo(Object obj) {
		Trajeto o = (Trajeto) obj;
		if (this.distancia < o.getDistancia()) {
			return -1;
		}
		if (this.distancia > o.getDistancia()) {
			return 1;
		}
		return 0;
	}
}
