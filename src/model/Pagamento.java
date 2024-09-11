package model;

import java.util.Date;

import util.EFormaPagamento;

public class Pagamento extends Transacao{

	private EFormaPagamento forma;
	
//------------------------
	
	public Pagamento(EFormaPagamento forma, double valor) {
		super(valor);
		this.forma = forma;
	}
	
	public EFormaPagamento getForma() {
		return forma;
	}

	public void setForma(EFormaPagamento forma) {
		this.forma = forma;
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
		return "Pagamento [forma=" + forma + ", data=" + getData() + ", valor=" + getValor() + "] \n\n";
	}
	
}
