package bar;

import java.util.ArrayList;

class Garcom extends Thread {
	private String nome;
	private ArrayList<Pedido> pedidos;
	private int lim;
	private boolean ocupado = false;
	private Bartender bartender;

	public Garcom(String nome, int lim, Bartender bartender) {
		this.nome = nome;
		this.pedidos = new ArrayList<>();
		this.lim = lim;
		this.bartender = bartender;
	}

	public void run() {

		try {
			if (bartender.estaOcupado()) {
				if (this.chegouLim()) {
					this.ocupado = true;
					wait();
				}
			}

			bartender.pegarPedido(pedidos.getFirst());

		} catch (InterruptedException e) {

		}
	}

	public String getNome() {
		return this.nome;
	}

	public boolean estaOcupado() {
		if (this.ocupado == true)
			return false;
		return true;
	}

	public void ficarOcupado() {
		this.ocupado = true;
	}

	public boolean chegouLim() {
		if (pedidos.size() >= lim) {
			return true;
		}
		return false;
	}

	public void anotarPedido(Pedido pedido) {

	}

}
