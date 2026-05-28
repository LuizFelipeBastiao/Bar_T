package bar;

import java.util.Random;

public class Cliente extends Thread {
	private String nome;
	private Bar bar;
	Pedido pedido;

	public Cliente(String nome, Bar bar) {
		this.nome = nome;
		this.bar = bar;
	}

	public void run() {
		Random r = new Random();
		int contadorPedidos = 0;
		while (!bar.estaFechado()) {
			contadorPedidos++;
			pedido = new Pedido();
			try {
				Garcom g = procurarGarcom(contadorPedidos);
				if (g == null)
					break;
				synchronized (pedido) {
					while (!pedido.pronto) {
						pedido.wait();
					}
				}
				System.out.println("Cliente " + nome + " recebeu o pedido " + pedido.getDescricao());

				Thread.sleep(1000 * (1 + r.nextInt(3)));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				return;
			}

		}

		System.out.println("Cliente " + nome + " foi embora");
	}

	public Garcom procurarGarcom(int contadorPedidos) throws InterruptedException {
		synchronized (bar) {
			while (!bar.estaFechado()) {
				for (Garcom g : bar.getGarcons()) {
					if (!g.estaOcupado()) {
						g.anotarPedido(pedido);
						if (g.chegouLim()) {
							g.ficarOcupado();
						}
						if (contadorPedidos == 1) {
							System.out.println("Cliente " + nome + " fez o primeiro pedido: " + pedido.getDescricao()
									+ ", com o garçom " + g.getNome());
						} else {
							System.out.println("Cliente " + nome + " fez mais um pedido: " + pedido.getDescricao()
									+ ", com o garçom " + g.getNome());
						}
						bar.notifyAll();
						return g;
					}

				}
				System.out.println("Cliente " + nome + " nao achou um garçom disponível, esperando...");
				bar.wait();
			}

			return null;
		}

	}

	public String getNome() {
		return nome;
	}

	public Pedido getPedido() {
		return pedido;
	}
}
