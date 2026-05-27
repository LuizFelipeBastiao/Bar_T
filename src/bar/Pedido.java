package bar;

public class Pedido {

	private enum Status {
		PENDENTE, PREPARANDO, PRONTO, ENTREGUE
	}

	public int id;
	private String descricao;
	private Status status = Status.PENDENTE;

	public Pedido(int id, String descricao) {
		this.descricao = descricao;
	}

	public boolean entregue() {
		if (status == Status.ENTREGUE)
			return true;
		return false;
	}

	public boolean pronto() {
		if (status == Status.PRONTO)
			return true;
		return false;
	}

	public String getDescricao() {
		return this.descricao;
	}
}
