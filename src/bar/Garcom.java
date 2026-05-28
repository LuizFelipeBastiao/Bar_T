package bar;

import java.util.ArrayList;
import java.util.List;

public class Garcom extends Thread {
	private String nome;
	ArrayList<Pedido> pedidos;
	public int lim;
	boolean ocupado = false;
	private Bartender bartender;
	private Bar bar;

	public Garcom(String nome, int lim, Bartender bartender, Bar bar) {
		this.nome = nome;
		this.pedidos = new ArrayList<>();
		this.lim = lim;
		this.bartender = bartender;
		this.bar = bar;
	}

	public void run() {
		try {
			while (!bar.estaFechado()) {
				recebeMaximoPedidos();
				List<Pedido> leva = registraPedidos();
				entregaPedidos(leva);
				synchronized (bar) {
					if (bar.estaFechado() && pedidos.isEmpty())
						break;
					ocupado = false;
					bar.notifyAll();
				}

				bar.incrementaRodada();
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public String getNome() {
		return this.nome;
	}

	public boolean estaOcupado() {
		return this.ocupado;
	}

	public void ficarOcupado() {
		this.ocupado = true;
	}

	public void desocupar() {
		this.ocupado = false;
	}

	public boolean chegouLim() {
		return pedidos.size() >= lim;
	}

	public boolean temPedidos() {
		return pedidos.size() > 0;
	}

	public void anotarPedido(Pedido pedido) {
		pedidos.add(pedido);
	}

	private void recebeMaximoPedidos() throws InterruptedException {
		synchronized (bar) {
			while (pedidos.size() < lim && !bar.estaFechado()) {
				bar.wait();
			}
		}
	}

	private List<Pedido> registraPedidos() throws InterruptedException {
		List<Pedido> leva;
		synchronized (bar) {
			leva = new ArrayList<>(pedidos);
			pedidos.clear();
			System.out.println("Garçom " + nome + " foi para a copa com " + leva.size() + " pedidos");
		}

		for (Pedido p : leva) {
			bartender.pegarPedido(p);
		}
		System.out.println("Garçom " + nome + " voltou da copa");
		return leva;
	}

	private void entregaPedidos(List<Pedido> leva) {
		for (Pedido p : leva) {
			synchronized (p) {
				p.pronto = true;
				p.notifyAll();
			}
		}

	}
}
