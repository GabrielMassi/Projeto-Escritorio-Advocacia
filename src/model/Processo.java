package model;

import java.util.Date;
import java.util.ArrayList;

public class Processo {

	private final long numero;
	
	private static long increment = 0;
	
	private final Date dataAbertura = new Date();
	
	private EFaseProcesso fase;
	
	private Cliente cliente;
	
	private Pessoa parteContraria;
	
	private ArrayList<Audiencia> audiencias = new ArrayList<>();
	
	private IConta conta;
	
	private Tribunal tribunal;
	
//-------------------

	public Processo(Cliente cliente, Pessoa parteContraria, Tribunal tribunal) {
		this.numero = increment;
		increment++;
		this.cliente = cliente;
		this.parteContraria = parteContraria;
		this.tribunal = tribunal;
		this.fase = EFaseProcesso.INICIAL;
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

	public void addAudiencia(Audiencia a) {
		audiencias.add(a);
	}
	
	public double getTotalCustas() {
		return this.getConta().getTotalDespesas();
	}
	
	public StringBuilder getAudiencias() {
		StringBuilder sb = new StringBuilder();
		//TODO implement
		return sb;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.getCliente().getPessoa().getNome() + " vs " + this.getParteContraria().getNome());
		sb.append("\nNumero do Processo: " + this.getNumero());
		sb.append("\nData de abertura: " + this.getDataAbertura());
		sb.append("\nTribunal: " + this.getTribunal().getSigla() + "\n\n");
		
		return sb.toString();
		
	}
	
	
}
