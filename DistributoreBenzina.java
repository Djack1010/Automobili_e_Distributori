//Lorenzo Tozzetti

public class DistributoreBenzina {

	// variabili di istanza della classe
	public static double deposito = 0;
	public double euroPerLitro;

	// costruttore della classe
	public DistributoreBenzina(double unPrezzoPerLitro) {
		setEuroPerLitro(unPrezzoPerLitro);
		setDeposito(0);
	}

	// metodi della classe
	public static void rifornisci(double unaQuantita) {
		deposito += unaQuantita;
	}

	public float vendi(double euro, Car c) {
		deposito -= (euro / euroPerLitro);
		double resto = (c.setGas(euro / euroPerLitro) * euroPerLitro);
		
		return (float)resto;
	}

	public void aggiorna(double unPrezzoPerLitro) {
		euroPerLitro = unPrezzoPerLitro;
	}

	public double getBenzina() {
		return deposito;
	}

	public void manutenzioneRuote(Wheels ruote) {

		if (ruote.getStatoRuote() > 300)
			ruote.ripristinoStatoRuote();

		if (ruote.getPressioneRuote() < 1.5)
			ruote.ripristinoRuote(); 
		// Il metodo ripristinoRuote setta la pressione di nuovo al massimo

	}

	// metodi getter e setter
	public double getDeposito() {
		return deposito;
	}

	public void setDeposito(double deposito) {
		this.deposito = deposito;
	}

	public double getEuroPerLitro() {
		return euroPerLitro;
	}

	public void setEuroPerLitro(double euroPerLitro) {
		this.euroPerLitro = euroPerLitro;
	}

}
