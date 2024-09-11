package model;

import java.util.Date;

public class Despesa extends Transacao{

	private String descricao;
	
//------------------------
	
	public Despesa(String descricao, double valor) {
		super(valor);
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return super.getValor();
	}

	public void setValor(double valor) {
		super.setValor(valor);
	}


	public Date getData() {
		return super.getData();
	}
	
	@Override
	public String toString() {
		return "Pagamento [ data=" + getData() + ", valor=" + getValor() + "]\n" + "descrição: " + descricao + "\n\n";
	}
	
}
