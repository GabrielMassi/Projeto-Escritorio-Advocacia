package model;

import java.util.Date;

import util.EFaseProcesso;

import java.util.ArrayList;

public class Processo {

	private final long numero;
	
	private static long increment = 0;
	
	private final Date dataAbertura = new Date();
	
	private EFaseProcesso fase;
	
	private Cliente cliente;
	
	private Pessoa parteContraria;
	
	private Advogado advogado;
	
	private ArrayList<Audiencia> audiencias = new ArrayList<>();
	
	private IConta conta;
	
	private Tribunal tribunal;
	
//-------------------

	public Processo(Cliente cliente, Pessoa parteContraria, Tribunal tribunal, Advogado advogado) {
		this.numero = increment;
		increment++;
		this.cliente = cliente;
		this.parteContraria = parteContraria;
		this.tribunal = tribunal;
		this.advogado = advogado;
		this.fase = EFaseProcesso.INICIAL;
		this.conta = new Conta();
	}
	
	public long getNumero() {
		return numero;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public IConta getConta() {
		return this.conta;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public Pessoa getParteContraria() {
		return parteContraria;
	}
	
	public Advogado getAdvogado() {
		return advogado;
	}

	public void setAdvogado(Advogado advogado) {
		this.advogado = advogado;
	}
	
	public Tribunal getTribunal() {
		return tribunal;
	}

	public void setTribunal(Tribunal tribunal) {
		this.tribunal = tribunal;
	}
	
	

	public EFaseProcesso getFase() {
		return fase;
	}

	public void setFase(EFaseProcesso fase) {
		this.fase = fase;
	}

	public void addAudiencia(String recomend) {
		Audiencia a = new Audiencia(this, recomend);
		audiencias.add(a);
	}
	
	public double getTotalCustas() {
		return this.getConta().getTotalDespesas();
	}
	
	public StringBuilder getAudiencias() {
		StringBuilder sb = new StringBuilder();
		for (Audiencia a : audiencias) {
			sb.append("\n" + a.getRecomendacoes() + "\n");
		}
		return sb;
	}
	
	public String nomeVS() {
		return this.cliente.getPessoa().getNome() + " vs " + this.parteContraria.getNome();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.nomeVS());
		sb.append("\nNumero do Processo: " + this.getNumero());
		sb.append("\nData de abertura: " + this.getDataAbertura());
		sb.append("\nAdvogado: " + this.getAdvogado().getPessoa().getNome());
		sb.append("\nTribunal: " + this.getTribunal().getSigla() + "\n\n");
		
		return sb.toString();
		
	}
	
	
}
