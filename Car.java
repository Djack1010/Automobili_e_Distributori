/***********************************************
*	Paolo Bondi - Corso TIC (UF6) - 04/06/21   *
*	Esercizio2 - Automobili e distributori v2  *											
***********************************************/

public class Car 
{
  // TODO: aggiungere anche la capacità massima del serbatorio, e implementare controlli 
  // per assicurarsi che il gas immagazzinato non ecceda la capacità massima
  // FATTO
	
  private String nome;
  private float resa;
  private float serbatoio;
  private Wheels ruote;
  
  private float MAX_PRESSIONE = 2.5f;
  private float MAX_CAPACITA_SERBATOIO = 50f;

    public Car(String n, float r) {
    nome = n;
    resa = r;
    serbatoio = 0;
    setRuote(new Wheels(MAX_PRESSIONE));
    
  }

  public float getGas() { return serbatoio; }
  
  public void setGas(float qta) { serbatoio += qta; }

  public void drive(float percorso) {
  
    float resaReale = 0;
  	  
    for(int i=0; i<percorso; i++) {
      resaReale = (getRuote().getPressioneRuote() * resa) / MAX_PRESSIONE;
      serbatoio = serbatoio - (1 / resaReale);
      
      if(serbatoio < 0) {			// se il serbatoio va sottozero
    	  serbatoio = 0;			// si azzera il serbatoio
    	  break;					// e si forza l'uscita dal ciclo
    	  }
            
      getRuote().setStatoRuote(1);
      getRuote().setPressioneRuote(1);
    }
   }
  
  // TODO: refactor controlloRuote(): il metodo deve restituire un intero
  //   0 -> se tutto ok
  //   1 -> se vanno controllate le ruote
  //   2 -> se vanno gonfiate le ruote
  //   3 -> se vanno sia controllate che gonfiate
  // FATTO
  
  public void controlloRuote() { 
	System.out.println(getRuote().controlloRuote()); 
	} 
  
  public void stampaInfo(){
    System.out.println("serbatoio (" + serbatoio + "), " + getRuote().stampaInfo());
    }
  
  public float serbatoioDisponibile() {
	  return MAX_CAPACITA_SERBATOIO - serbatoio;
	  
  }

public Wheels getRuote() {
	return ruote;
}

public void setRuote(Wheels ruote) {
	this.ruote = ruote;
}

}

