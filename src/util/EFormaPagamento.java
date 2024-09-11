package util;

public enum EFormaPagamento {
	PIX("Pix"), CREDITO("Credito"), DEBITO("Debito"), DINHEIRO("Dinheiro"), CHEQUE("Cheque");
	
	public final String label;

    private EFormaPagamento(String label) {
        this.label = label;
    }
	
}
