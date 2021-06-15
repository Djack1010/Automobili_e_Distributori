//Author
//Edoardo

public class Wheels {
  
  private float statoRuote; // km percorsi per valutare l'usura delle ruote
  private float pressioneRuote;
  private float initialPressioneRuote;
  
  public Wheels(float maxPressione) {
    statoRuote = 0;
    pressioneRuote = maxPressione;  // inizializzo ruote gonfie al massimo, 2.5 bar
    initialPressioneRuote = maxPressione;   //nuova variabile per salvarmi la max pressione del veicolo quando faccio manutenzione
  }
  
  public float getStatoRuote() { return statoRuote; }
  public float getPressioneRuote() { return pressioneRuote; }
  
  public void setStatoRuote(float percorso) { statoRuote += percorso; }
  public void setPressioneRuote(float percorso) { 
    pressioneRuote -= 0.1f * (percorso/50);
    if (pressioneRuote < 0.2f)
      pressioneRuote = 0.01f; 
  }
  
  public void manutenzioneRuote() {   // manutenzione ruote con check per lo stato e per la pressione!!
	  if (statoRuote > 300) {
		  statoRuote = 0; 
	  }
	  if (pressioneRuote < 1.5) {
	  pressioneRuote = initialPressioneRuote;
	  }
	  System.out.println("Manutenzione ruote effettuata!! Pressione: " + pressioneRuote + " Stato Ruote: " + statoRuote);
  }
  
  public int controlloRuote(){
  
  	if (statoRuote > 300 && pressioneRuote < 1.5) {
  	  return 3;
  	}
  	
  	if (statoRuote > 300) {
  	  return 1;
  	}
  	
  	if (pressioneRuote < 1.5){
  	  return 2;
  	}
  	  return 0;
  }
  
  public String stampaInfo() { return "statoRuote (" + statoRuote + "), pressioneRuote (" + pressioneRuote + ")"; }
  
}
