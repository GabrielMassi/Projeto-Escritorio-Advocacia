package model;

import java.util.Date;
import java.util.ArrayList;

public class Processo {

	private final long numero;
	
	private final Date dataAbertura = new Date();
	
	private EFaseProcesso fase;
	
	private Cliente cliente;
	
	private Pessoa parteContraria;
	
	private ArrayList<Audiencia> audiencias = new ArrayList<>();
	
	private IConta conta;
	
	private Tribunal tribunal;
	
//-------------------

	public Processo(long numero, Cliente cliente, Pessoa parteContraria) {
		this.numero = numero;
		this.cliente = cliente;
		this.parteContraria = parteContraria;
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

	@Override
	public String toString() {
		return "Processo [numero=" + numero + ", dataAbertura=" + dataAbertura + ", cliente=" + cliente + ", conta=" + conta + "]";
	}
	
	
}
