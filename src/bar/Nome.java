package bar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Nome {
	private static final String[] nomes = { "Alexandre", "Amanda", "Ana", "Beto", "Bob", "Bruna", "Carlos", "Carol",
			"Daniel", "Danilo", "Donizete", "Eliza", "Enzo", "Erik", "Felipe", "Gabriel", "Guilherme", "Gustavo",
			"Ícaro", "Isa", "Isaac", "Isabel", "Italo", "Helena", "Henrique", "Joao", "Joana", "Jose", "Josias",
			"Jorge", "Lidia", "Leandro", "Lucas", "Luiz", "Matheus", "Marcos", "Micael", "Natan", "Neymar", "Priscila",
			"Rebeca", "Ricardo", "Roberto", "Rodrigo", "Samara", "Tatiane", "Tiago", "Valmor", "Vanessa", "Vitor",
			"Yasmin" };
	private static final String[] sobrenomes = { "Amaral", "Alfonsin", "Atreides", "Angonese", "Banner", "Bastiao",
			"Carvalho", "Correia", "Coimbra", "de Jesus", "de Medeiros", "de Melo", "da Silva", "dos Santos",
			"de Souza", "Deividson", "Freeman", "Harkonen", "Hochschild", "Jackson", "Junior", "Lima", "Mazzuco",
			"Mecias", "Meneguel", "Moraes", "Parker", "Pessini", "Pereira", "Potter", "Recalcatti", "Sampaio",
			"Schimit", "Schultz", "Shwatsneger", "Simoni", "Taborga", "Teixeira", "Treter", "Tavares", "Yamada",
			"Yamamoto", "Zimmer" };

	private static ArrayList<String> nomesDisponiveis;
	private static ArrayList<String> sobrenomesDisponiveis;

	public static void abastecerNomes() {
		nomesDisponiveis = new ArrayList<>(Arrays.asList(nomes));
		Collections.shuffle(nomesDisponiveis);
	}

	public static void abastecerSobrenomes() {
		sobrenomesDisponiveis = new ArrayList<>(Arrays.asList(sobrenomes));
		Collections.shuffle(sobrenomesDisponiveis);
	}

	public static String nomeAleatorio() {
		if (nomesDisponiveis == null || nomesDisponiveis.isEmpty())
			abastecerNomes();
		if (sobrenomesDisponiveis == null || sobrenomesDisponiveis.isEmpty())
			abastecerSobrenomes();

		return nomesDisponiveis.remove(0) + " " + sobrenomesDisponiveis.remove(0);
	}
}
