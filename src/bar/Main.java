package bar;

import java.util.ArrayList;

public class Main {

	public static void main(String args[]) {
		ArrayList<Cliente> clientes = new ArrayList<>();
		ArrayList<Garcom> garcons = new ArrayList<>();
		Bartender bartender = new Bartender();

		for (int i = 0; i < 2; i++) {
			garcons.add(new Garcom("Garcom " + (i + 1), 2, bartender, garcons));
		}

		for (Garcom g : garcons) {
			g.start();
		}

		for (int i = 0; i < 4; i++) {
			Pedido p = new Pedido(i + 1, "pedido " + (i + 1));
			Cliente c = new Cliente("Cliente " + (i + 1), p, garcons);
			clientes.add(c);
			c.start();
		}
	}
}
