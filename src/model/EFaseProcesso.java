package model;

public enum EFaseProcesso {
	INICIAL("Inicial"), INSTRUCAO("Instrução"), DECISAO("Decisão"), RECURSO("Recurso"), ENCERRADO(null);
	
	public final String label;

    private EFaseProcesso(String label) {
        this.label = label;
    }
}
