package model;

import java.util.Date;

public class Transacao {

	
	private final Date data = new Date();
	
	private double valor;
		
	//------------------------
		
	public Transacao(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}


	public Date getData() {
		return data;
	}
	
}


