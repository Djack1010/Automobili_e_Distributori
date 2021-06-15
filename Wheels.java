/***********************************************
*	Paolo Bondi - Corso TIC (UF6) - 04/06/21   *
*	Esercizio2 - Automobili e distributori v2  *											
***********************************************/

public class Wheels {
  
  private float statoRuote; // km percorsi per valutare l'usura delle ruote
  private float pressioneRuote;
  private float maxP;
  
  public Wheels(float maxPressione) {
    statoRuote = 0;
    pressioneRuote = maxPressione; // inizializzo ruote gonfie al massimo, 2.5 bar
    maxP = maxPressione;
  }
  
  public float getStatoRuote() { return statoRuote; }
  public float getPressioneRuote() { return pressioneRuote; }
  
  public void setStatoRuote(float percorso) { statoRuote += percorso; }
  public void setPressioneRuote(float percorso) { 
    pressioneRuote -= 0.1f * (percorso/50);
    if (pressioneRuote < 0.2f)
      pressioneRuote = 0.01f; 
  }
    
  public int controlloRuote(){
  
  	if (statoRuote > 300 && pressioneRuote < 1.5) {
  	  return 3;	// Necessario controllare e gonfiare le ruote
  	}
  	
  	if (statoRuote > 300) {
  	  return 1; // Necessario controllare le ruote
  	}
  	
  	if (pressioneRuote < 1.5){
  	  return 2; // Necessario gonfiare le ruote
  	}
  	  return 0; // Ruote in perfetto stato, nessuna operazione richiesta
  }
     
  public String stampaInfo() { return "statoRuote (" + statoRuote + "), pressioneRuote (" + 
		  							   pressioneRuote + "), statoMacchina (" + controlloRuote()+")" ; }
  
  
  public void setAzzeraRuote() {
	  statoRuote = 0;
	  System.out.println("*** Lo stato delle ruote è stato ripristinato.");
  }
  
  public void setMaxPressioneRuote() {
	  pressioneRuote = maxP;
	  System.out.println("*** La ruote sono state gonfiate.");
  }
   
}
