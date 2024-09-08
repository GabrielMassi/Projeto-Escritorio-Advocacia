package model;

import java.util.ArrayList;

import java.lang.StringBuilder;

public class Advogado {

	private Pessoa pessoa;
	
	private final String oab;
	
	private String curriculo;
	
	private ArrayList<Processo> processos = new ArrayList<>();	
	
//-----------------------
	
	public Advogado(Pessoa pessoa, String oab, String curriculo) {
		super();
		this.pessoa = pessoa;
		this.oab = oab;
		this.curriculo = curriculo;
	}

	public String getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(String curriculo) {
		this.curriculo = curriculo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public String getOab() {
		return oab;
	}
	
	public void addProcesso(Processo p) {
		this.processos.add(p);
	}
	
	public StringBuilder getProcessos() {
		StringBuilder sb = new StringBuilder();
		for (Processo p : processos) {
			sb.append("\n\nProcesso de n° " + p.getNumero());
			sb.append("\n\t Cliente:" + p.getCliente().getPessoa().getNome());
			sb.append("\n\t Parte Contrária: " + p.getParteContraria().getNome());
			sb.append("\n\t Status: " + p.getFase());
		}
		
		return sb;
	}
	
}
