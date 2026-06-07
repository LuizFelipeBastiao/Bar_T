package bar;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		int qtdClientes;
		int qtdGarcons;
		int capacidade;
		int rodadas;

		if (args.length == 4) {
			qtdClientes = Integer.parseInt(args[0]);
			qtdGarcons = Integer.parseInt(args[1]);
			capacidade = Integer.parseInt(args[2]);
			rodadas = Integer.parseInt(args[3]);
		} else {
			try (Scanner scanner = new Scanner(System.in)) {
				System.out.println("Digite os valores no terminal: <qtdClientes> <qtdGarcons> <capacidade> <rodadas>");
				qtdClientes = scanner.nextInt();
				qtdGarcons = scanner.nextInt();
				capacidade = scanner.nextInt();
				rodadas = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Uso: digite 4 números inteiros no terminal.");
				return;
			}
		}

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
