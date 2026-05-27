package bar;

import java.util.ArrayList;

public class Garcom extends Thread {
	private String nome;
	ArrayList<Pedido> pedidos;
	public int lim;
	boolean ocupado = false;
	private Bartender bartender;
	private ArrayList<Garcom> garcons;

	public Garcom(String nome, int lim, Bartender bartender, ArrayList<Garcom> garcons) {
		this.nome = nome;
		this.pedidos = new ArrayList<>();
		this.lim = lim;
		this.bartender = bartender;
		this.garcons = garcons;
	}

	public void run() {
		try {
			while (true) {
				Pedido p;
				synchronized (garcons) {
					while (pedidos.isEmpty()) {
						garcons.wait();
					}
					p = pedidos.remove(0);
					System.out.println("O " + nome + " foi entregar o pedido " + p.getDescricao() + " para o Bartender.");
				}
				System.out.println("O " + nome + " foi entregar o pedido " + p.getDescricao() + " para o Bartender.");
				bartender.pegarPedido(p);
				synchronized (garcons) {
					if (pedidos.size() < lim) {
						ocupado = false;
					}
					garcons.notifyAll();
				}
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public String getNome() {
		return this.nome;
	}

	// Os metodos abaixo devem ser chamados dentro de synchronized(garcons)
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
}
