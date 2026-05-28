package bar;

import java.util.ArrayList;
import java.util.List;

public class Bar {
	final int totalRodadas;
	int rodadaAtual = 0;
	boolean fechado = false;
	final List<Garcom> garcons = new ArrayList<>();

	public Bar(int totalRodadas) {
		this.totalRodadas = totalRodadas;
	}

	public void addGarcom(Garcom g) {
		garcons.add(g);
	}

	public synchronized boolean estaFechado() {
		return fechado;
	}

	public synchronized void fechar() {
		fechado = true;
		System.out.println("Bar fechou");
		notifyAll();
	}

	public synchronized void incrementaRodada() {
		rodadaAtual++;
		if (rodadaAtual >= totalRodadas) {
			fechado = true;
			notifyAll();
		}
	}

	public List<Garcom> getGarcons() {
		return garcons;
	}

}
