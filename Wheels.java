// commento pb

public class Wheels {
  
  private float statoRuote; // km percorsi per valutare l'usura delle ruote
  private float pressioneRuote;
  private float maxPressione;
  
  public Wheels(float maxPr) {
    statoRuote = 0;
    maxPressione = maxPr;
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
  
  public void gonfiaRuote(){ pressioneRuote = maxPressione; }
  public void manutenzioneRuote(){ statoRuote = 0; }
    
  // Il metodo restituisce un intero
  //   0 -> se tutto ok
  //   1 -> se vanno controllate le ruote
  //   2 -> se vanno gonfiate le ruote
  //   3 -> se vanno sia controllate che gonfiate
  public int controlloRuote(){
  
  	if (statoRuote > 300 && pressioneRuote < 1.5) {
  	  return 3;
  	}
  	
  	if (pressioneRuote < 1.5){
  	  return 2;
  	}
  	
  	if (statoRuote > 300) {
  	  return 1;
  	}
  	
  	return 0;
  }
  
  public String stampaInfo() { return "statoRuote (" + statoRuote + "), pressioneRuote (" + pressioneRuote + ")"; }
  
}
