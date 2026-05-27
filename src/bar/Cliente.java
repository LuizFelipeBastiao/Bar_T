package bar;

import java.util.ArrayList;

public class Cliente extends Thread {
	private String nome;
	private Pedido pedido;
	private ArrayList<Garcom> garcons;

	public Cliente(String nome, Pedido pedido, ArrayList<Garcom> garcons) {
		this.nome = nome;
		this.pedido = pedido;
		this.garcons = garcons;
	}

	public void run() {

		try {
			Garcom garcom = procurarGarcom();
			garcom.anotarPedido(pedido);

		} catch (InterruptedException e) {

		}

	}

	public Garcom procurarGarcom() throws InterruptedException {
		while (true) {
			for (Garcom g : garcons) {
				if (!g.estaOcupado()) {
					return g;
				} else
					continue;
			}
			wait();
		}
	}

	}

	public String getNome() {
		return nome;
	}

	public Pedido getPedido() {
		return pedido;
	}
}
