package model;

import java.util.ArrayList;

import util.EFormaPagamento;

public class Conta implements IConta {

	private ArrayList<Transacao> transacoes = new ArrayList<>();

//------------------
	
	@Override
	public void addPagamento(EFormaPagamento forma, double valor) {
		Pagamento p = new Pagamento(forma, valor);
		transacoes.add(p);
	}

	@Override
	public void addDespesa(String descricao, double valor) {
		Despesa d = new Despesa(descricao, valor);
		transacoes.add(d);
	}

	@Override
	public double getTotalPagamentos() {
		int total = 0;
		for (Transacao p : transacoes) {
			if(p.getClass() == Pagamento.class)
				total+=p.getValor();
		}
		return total;
	}

	@Override
	public double getTotalDespesas() {
		int total = 0;
		for (Transacao d : transacoes) {
			if(d.getClass() == Despesa.class)
				total+=d.getValor();
		}
		return total;
	}

	@Override
	public double getSaldoConta() {
		return this.getTotalPagamentos() - this.getTotalDespesas();
	}

	@Override
	public StringBuilder getExtrato() {
		StringBuilder sb = new StringBuilder();
		
		for (Transacao t : transacoes) {
			sb.append(t.toString());
		}
		
		return null;
	}

}
