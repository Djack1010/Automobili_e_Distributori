public class Wheels {
  
  private float statoRuote; // km percorsi per valutare l'usura delle ruote
  private float pressioneRuote;
  
  public Wheels(float maxPressione) {
    statoRuote = 0;
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
    
  public void controlloRuote(){
  
  	if (statoRuote > 300 && pressioneRuote < 1.5) {
  	  System.out.println("Necessario controllare e gonfiare le ruote");
  	  return;
  	}
  	
  	if (statoRuote > 300) {
  	  System.out.println("Necessario controllare le ruote");
  	  return;
  	}
  	
  	if (pressioneRuote < 1.5){
  	  System.out.println("Necessario gonfiare le ruote");
  	  return;
  	}
  	
  	System.out.println("Ruote in perfetto stato, nessuna operazione richiesta");
  }
  
  public String stampaInfo() { return "statoRuote (" + statoRuote + "), pressioneRuote (" + pressioneRuote + ")"; }
  
}
