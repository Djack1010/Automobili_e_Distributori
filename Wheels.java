/*
 * author: iRoxa
 */

public class Wheels {
  
  private float statoRuote; // km percorsi per valutare l'usura delle ruote
  private float pressioneRuote;
  private float maxPressure;
  
  public Wheels(float maxPressione) {
    statoRuote = 0;
    maxPressure = maxPressione;		// imposto la pressione massima come variabile d'istanza
    pressioneRuote = maxPressione; // inizializzo ruote gonfie al massimo, 2.5 bar
  }
  
  public float getStatoRuote() { return statoRuote; }
  public float getPressioneRuote() { return pressioneRuote; }
  
  public void setStatoRuote(float percorso) { statoRuote += percorso; }
  public void setPressioneRuote(float percorso) { 
    pressioneRuote -= 0.1f * (percorso/50);
    if (pressioneRuote < 0.2f)
      pressioneRuote = 0.01f; 
  }
  
  public void restoreCondition() {
	  statoRuote = 0;
  }
  
  public void restorePressure() {
	  pressioneRuote = maxPressure;
  }
    
  public int controlloRuote(){  
		if (statoRuote > 300 && pressioneRuote < 1.5)
			return 3; 	// Necessario controllare e gonfiare le ruote
		else if (statoRuote > 300 && pressioneRuote >= 1.5)
			return 1;	// Necessario controllare le ruote
		else if (statoRuote <= 300 && pressioneRuote < 1.5)
			return 2;	// Necessario gonfiare le ruote		
		return 0; 		// Ruote in perfetto stato, nessuna operazione richiesta
  }
  
  public String stampaInfo() { return "statoRuote (" + statoRuote + "), pressioneRuote (" + pressioneRuote + ")"; }
  
}
