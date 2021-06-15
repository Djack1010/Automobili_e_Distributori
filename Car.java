//Lorenzo Tozzetti

public class Car {

	private String nome;
	private double resa;
	private double serbatoio;
	private Wheels ruote;
	private double capacitaMassimaSerbatoio;

	final double MAX_PRESSIONE = 2.5f;

	public Car(String n, double r, double cMS) { // costruttore
		nome = n;
		resa = r;
		serbatoio = 0;
		ruote = new Wheels(MAX_PRESSIONE);
		capacitaMassimaSerbatoio = cMS;
	}

	// metodi set e get

	public double getGas() {
		return serbatoio;
	}

	public double getMaxPressione() {
		return MAX_PRESSIONE;
	}

	public Wheels getRuote() {
		return ruote;
	}

	public float setGas(double qta) {
		serbatoio += qta;
		double resto = 0.0;
		if (serbatoio > capacitaMassimaSerbatoio) {

			resto = serbatoio - capacitaMassimaSerbatoio;
			serbatoio = capacitaMassimaSerbatoio;
			DistributoreBenzina.rifornisci(resto);
			System.out.println("Sono stati re inseriti " + resto + " litri di benza");

		}

		return (float) resto;
	}

	// metodo per simulare la guida

	public void drive(double percorso) {

		double resaReale = 0;

		for (int i = 0; i < percorso; i++) {
			
			if (serbatoio > 0) {
				

			resaReale = (ruote.getPressioneRuote() * resa) / MAX_PRESSIONE;
			serbatoio = serbatoio - (1 / resaReale);
			ruote.setStatoRuote(1);
			ruote.setPressioneRuote(1);
			
			}
			if (serbatoio < 0) serbatoio = 0;
		}
	}

	// controlla stato e pressione delle ruote

	public int controlloRuote() {

		// restituisce:
		// 0 -> se tutto ok
		// 1 -> se vanno controllate le ruote
		// 2 -> se vanno gonfiate le ruote
		// 3 -> se vanno sia controllate che gonfiate

		return ruote.controlloRuote();

	}

	public void stampaInfo() {
		System.out.println("serbatoio (" + serbatoio + "), " + ruote.stampaInfo());
	}
}