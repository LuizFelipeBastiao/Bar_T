package bar;

import java.util.ArrayList;

public class Bartender {
	private String nome;
	private boolean ocupado = false;
	private ArrayList<Pedido> pedidosSendoPreparados = new ArrayList<>();
	private ArrayList<Pedido> pedidosProntos = new ArrayList<>();

	public String getNome() {
		return this.nome;
	}

	public boolean estaOcupado() {
		if (this.ocupado == true)
			return false;
		return true;
	}

	public void pegarPedido(Pedido pedido) {
		pedidosSendoPreparados.add(pedido);
	}

}
