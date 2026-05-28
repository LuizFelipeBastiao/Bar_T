package bar;

import java.util.Random;

public class Pedido {

	private String descricao;
	public boolean pronto = false;

	String[] bebidas = { "Cerveja", "Chopp", "Refrigerante Cola", "Refrigerante Guaraná", "Refrigerante Laranja",
			"Refrigerante Limão", "Água Mineral", "Água com Gás", "Suco de Laranja", "Suco de Limão", "Suco de Abacaxi",
			"Suco de Morango", "Suco de Maracujá", "Suco de Uva", "Suco de Melancia", "Caipirinha", "Caipiroska",
			"Caipifruta", "Vinho Tinto", "Vinho Branco", "Vinho Rosé", "Espumante", "Whisky", "Vodka", "Gin", "Tequila",
			"Cachaça", "Rum", "Conhaque", "Licor de Chocolate", "Licor de Morango", "Licor de Café", "Licor de Menta",
			"Martini", "Dry Martini", "Sex on the Beach", "Mojito", "Cosmopolitan", "Margarita", "Bloody Mary",
			"Piña Colada", "Negroni", "Aperol Spritz", "Energético Red Bull", "Energético Monster", "Energético Burn",
			"Catuaba", "Jurupinga", "Corote", "Dose Pura", "Todinho" };
	private String[] acompa = { "Amendoim", "Torresmo", "Batata Frita", "Mandioquinha Frita", "Aipim Frito",
			"Porção de Calabresa", "Linguiça Assada", "Queijo Coalho", "Queijo Mussarela", "Queijo Provolone", "Salame",
			"Presunto", "Azeitona", "Picles", "Cebola Pickles", "Palmito", "Ovo de Codorna", "Bolinho de Bacalhau",
			"Bolinho de Carne", "Coxinha", "Rissole", "Pastelzinho", "Empada", "Kibe", "Isca de Peixe",
			"Camarão Empanado", "Frango à Passarinho", "Asinha de Frango", "Filezinho de Frango", "Carne Seca",
			"Carne de Sol", "Pão de Alho", "Pão com Manteiga", "Torrada", "Mandioca Cozida", "Batata Doce Frita",
			"Cebola Empanada", "Anéis de Cebola", "Milho Cozido", "Pipoca", "Castanha de Caju", "Castanha-do-Pará",
			"Nozes", "Amêndoas", "Passas", "Batata Palha", "Churrasco Espeto", "Espetinho de Carne",
			"Espetinho de Frango", "Espetinho de Coração" };

	private String descr = criaDescricao(bebidas, acompa);

	String criaDescricao(String[] bebidas, String[] acompa) {

		Random rand = new Random();
		int r = rand.nextInt(bebidas.length);
		int rr = rand.nextInt(acompa.length);

		if (r % 3 == 0 || r % 5 == 0) {
			return bebidas[r] + " acompanhado de " + acompa[rr];
		} else {
			return bebidas[r];
		}
	}

	public Pedido() {
		descricao = descr;
	}

	public String getDescricao() {
		return descricao;
	}
}
