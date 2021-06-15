//Lorenzo Tozzetti


public class Wheels {

	private double statoRuote; // km percorsi per valutare l'usura delle ruote
	private double pressioneRuote;

	public Wheels(double maxPressione) { //costruttore
		statoRuote = 0;
		pressioneRuote = maxPressione; // inizializzo ruote gonfie al massimo, 2.5 bar
	}

	//set e get
	
	public double getStatoRuote() {
		return statoRuote;
	}

	public double getPressioneRuote() {
		return pressioneRuote;
	}

	public void setStatoRuote(float percorso) {
		statoRuote += percorso;
	}

	public void setPressioneRuote(float percorso) {
		pressioneRuote -= 0.1f * (percorso / 50);
		if (pressioneRuote < 0.2f)
			pressioneRuote = 0.01f;
	}
	
	public void ripristinoStatoRuote(){
		statoRuote = 0;
	}
	
	//setta la pressione di nuovo al massimo
	public void ripristinoRuote() {
		pressioneRuote = 2.5;
	}
	
	/*controlla che le ruote siano da controllare e/o gonfiare e restituisce un intero in base
	a cosa si deve fare*/
	public int controlloRuote() {

		if (statoRuote > 300 && pressioneRuote < 1.5)
			return 3;

		if (pressioneRuote < 1.5)
			return 2;

		if (statoRuote > 300)
			return 1;

		return 0;
	}

	public String stampaInfo() {
		return "statoRuote (" + statoRuote + "), pressioneRuote (" + pressioneRuote + ")";
	}

}
