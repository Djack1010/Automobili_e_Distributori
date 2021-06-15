/*
 * author: Ciro
 */
public class Wheels {
  
  private float statoRuote; // km percorsi per valutare l'usura delle ruote
  private float pressioneRuote;
  private float maxPressione; // contiene la pressione massima che si puo assegnare
  final private int CHECK_STATUS = 300; // valore di controllo per sostituire i pneumatici
  final private float CHECK_PRESSURE = 1.5f; // valore di controllo per gonfiare le ruote
   
  public Wheels(float maxPr) {
    statoRuote = 0;
    pressioneRuote = maxPr; // inizializzo ruote gonfie al massimo, 2.5 bar
    maxPressione = maxPr; 
  }
  
  public void setStatoRuote(float percorso) { 
	  statoRuote += percorso; 
  }
  
  public void setPressioneRuote(float percorso) { 
    pressioneRuote -= 0.1f * (percorso/50);
    if (pressioneRuote < 0.2f)
      pressioneRuote = 0.01f; 
  }
    
  public int controlloRuote(){
	  // variabile che assume il valore dello stato dei pneumatici
	  int codiceControllo = 0;
	  
	  // Estrazione variabili condizionali per verificare lo stato dei pneumatici
	  boolean ruoteUsateSgonfie = statoRuote>CHECK_STATUS && pressioneRuote<CHECK_PRESSURE;
	  boolean ruoteUsate = statoRuote> CHECK_STATUS && pressioneRuote >=CHECK_PRESSURE;
	  boolean ruoteSgonfie = statoRuote<= CHECK_STATUS && pressioneRuote< CHECK_PRESSURE;
	  boolean ruoteOk = statoRuote<= CHECK_STATUS && pressioneRuote >=CHECK_PRESSURE;
	  
	  if (ruoteOk) codiceControllo = 0;
	  if (ruoteUsate) codiceControllo = 1;
	  if (ruoteSgonfie) codiceControllo =  2;
	  if (ruoteUsateSgonfie) codiceControllo = 3;
	  
	  return codiceControllo;
  }
  
  public String stampaInfo() { 
	  return "statoRuote (" + statoRuote + "), pressioneRuote (" + pressioneRuote + ")";
  }

  public int getCHECK_STATUS() {
	return CHECK_STATUS;
  }

  public float getCHECK_PRESSURE() {
	return CHECK_PRESSURE;
  }
  
  public float getStatoRuote() { 
	  return statoRuote; 
  }
  
  public float getPressioneRuote() { 
	  return pressioneRuote; 
  }
  
  // METODO PER RIPORTARE LA PRESSIONE DEI PNEUMATICI AL MASSIMO
  public void setMaxPressioneRuote() { 
	  pressioneRuote = maxPressione; 
  }
  
  //METODO PER RIPORTARE A 0 LO STATO DEI PNEUMATICI
  public void setAzzeraStatoRuote() { 
	  statoRuote = 0;
  }

}
