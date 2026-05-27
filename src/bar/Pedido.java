package bar;

public class Pedido {

	public int id;
	private String descricao;
	public boolean pronto = false;

	public Pedido(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}
}
