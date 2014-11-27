package br.ufms.jasane.ia.caixeiro.oo;

public class Trajeto implements Comparable {

	private int vetor[];
	private double distancia;

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

	public double getDistancia() {
		calcularDistancia();
		return distancia;
	}

	public void calcularDistancia() {
		// System.out.println("Calculo distancia de ");
		// printVetor();
		// System.out.println("");
		distancia = Distancias.matriz[0][vetor[0]];
		// System.out.println(distancia + " == " +
		// Distancias.matriz[0][vetor[0]]);
		for (int i = 1; i < vetor.length; i++) {
			// System.out.print(distancia);
			distancia = distancia + Distancias.matriz[vetor[i - 1]][vetor[i]];
			// System.out.print(" =+ " + Distancias.matriz[vetor[i -
			// 1]][vetor[i]]
			// + " = " + distancia + "\n");
		}
		// System.out.println(distancia + "+= "
		// + Distancias.matriz[vetor[vetor.length - 1]][0]);
		distancia = distancia + Distancias.matriz[vetor[vetor.length - 1]][0];
		// System.out.println(distancia);
	}

	public void printVetor() {
		for (int i = 0; i < vetor.length; i++)
			System.out.print(vetor[i] + " ");

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
