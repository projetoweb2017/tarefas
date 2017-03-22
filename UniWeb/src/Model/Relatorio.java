package Model;


public class Relatorio {
	
	private static Relatorio instance;
	
	private String total;
	private String aprovadas;
	private String reprovadas;
	private String aguardando;
	
    public static Relatorio getInstance() {
        if (instance == null)
            instance = new Relatorio();
        return instance;
    }

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getAprovadas() {
		return aprovadas;
	}

	public void setAprovadas(String aprovadas) {
		this.aprovadas = aprovadas;
	}

	public String getReprovadas() {
		return reprovadas;
	}

	public void setReprovadas(String reprovadas) {
		this.reprovadas = reprovadas;
	}

	public String getAguardando() {
		return aguardando;
	}

	public void setAguardando(String aguardando) {
		this.aguardando = aguardando;
	}

	public static void setInstance(Relatorio instance) {
		Relatorio.instance = instance;
	}

}
