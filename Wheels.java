/* MARILINA D'ANDRETTA */

public class Wheels {
  
  private float statoRuote; // km percorsi per valutare l'usura delle ruote
  private float pressioneRuote;
  private float MAX_PRESSIONE = 2.5f;
  
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
  
  public void manutenzioneRuote() { //REFACTOR DEL METODO
    
    if (statoRuote > 300) {
      statoRuote = 0;
    }
    if (pressioneRuote < 1.5) {
      pressioneRuote = MAX_PRESSIONE; 
    }
    else {
    System.out.println("Manutenzione effettuta: lo stato delle ruote è " + statoRuote + "e la pressione delle ruote è " + pressioneRuote);
    }
  }
  
  public int controlloRuote(){ //Modificato il metodo da void in int perchè restituisce valori int
  
    if (statoRuote > 300 && pressioneRuote < 1.5) {
      // System.out.println("Necessario controllare e gonfiare le ruote");
      return 3;
    }
    
    if (statoRuote > 300) {
      //System.out.println("Necessario controllare le ruote");
      return 1;
    }
    
    if (pressioneRuote < 1.5){
      //System.out.println("Necessario gonfiare le ruote");
      return 2;
    }
    
    return 0;
    //System.out.println("Ruote in perfetto stato, nessuna operazione richiesta");
  }
  
  public String stampaInfo() { return "statoRuote (" + statoRuote + "), pressioneRuote (" + pressioneRuote + ")"; }
  
}