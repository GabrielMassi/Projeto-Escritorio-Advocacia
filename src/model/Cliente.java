package model;

import java.util.ArrayList;

public class Cliente{

	private Pessoa pessoa;
	
	private ArrayList<Processo> processos = new ArrayList<>();
	
//---------------------
	
	public Cliente(Pessoa pessoa){
		this.pessoa = pessoa;
	}
	
	public StringBuilder getExtratoContas() {
		StringBuilder sb = new StringBuilder();
		//TODO implement
		return sb;
	}
	
	public double getSaldoContas() {
		double saldo = 0.00;
		//TODO implement
		return saldo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public ArrayList<Processo> getProcessos() {
		return processos;
	}
	
	public void addProcesso(Processo p) {
		this.processos.add(p);
	}
	
}
