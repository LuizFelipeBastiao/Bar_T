package bar;

public class Main {

	public static void main(String args[]) {

		if (args.length != 4) {
			System.out.println("Uso: java bar.Main <qtdClientes> <qtdGarcons> <capacidade> <rodadas>");
			return;
		}

		int qtdClientes = Integer.parseInt(args[0]);
		int qtdGarcons = Integer.parseInt(args[1]);
		int capacidade = Integer.parseInt(args[2]);
		int rodadas = Integer.parseInt(args[3]);

		Bartender bartender = new Bartender();
		Bar bar = new Bar(rodadas);

		for (int i = 0; i < qtdGarcons; i++) {
			Garcom g = new Garcom(Nome.nomeAleatorio(), capacidade, bartender, bar);
			bar.addGarcom(g);
			g.start();
		}

		for (int i = 0; i < qtdClientes; i++) {

			Cliente c = new Cliente(Nome.nomeAleatorio(), bar);
			c.start();
		}
	}
}
