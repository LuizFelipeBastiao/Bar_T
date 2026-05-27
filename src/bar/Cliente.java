package bar;

import java.util.ArrayList;

public class Cliente extends Thread {
	private String nome;
	Pedido pedido;
	private ArrayList<Garcom> garcons;

	public Cliente(String nome, Pedido pedido, ArrayList<Garcom> garcons) {
		this.nome = nome;
		this.pedido = pedido;
		this.garcons = garcons;
	}

	public void run() {
		try {
			Garcom g = procurarGarcom();
			synchronized (pedido) {
				while (!pedido.pronto) {
					pedido.wait();
				}
			}
			System.out.println(g.getNome() + " entregou o pedido para " + nome + ".");
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public Garcom procurarGarcom() throws InterruptedException {
		synchronized (garcons) {
			while (true) {
				for (Garcom g : garcons) {
					if (!g.estaOcupado()) {
						g.anotarPedido(pedido);
						if (g.chegouLim()) {
							g.ficarOcupado();
						}
						System.out.println(nome + " fez o pedido " + pedido.getDescricao() + " com " + g.getNome());
						garcons.notifyAll();
						return g;
					}
				}
				garcons.wait();
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
