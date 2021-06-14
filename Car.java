/*
 * author: iRoxa
 */

public class Car 
{
  // TODO: aggiungere anche la capacità massima del serbatorio, e implementare controlli per assicurarsi che il gas immagazzinato non ecceda la capacità massima
  private String nome;
  private float resa;
  private float serbatoio;
  private Wheels ruote;
  
  private float MAX_PRESSIONE = 2.5f;
  private float MAX_CARBURANTE = 50.0f;

  public Car(String n, float r, float m) {
    nome = n;
    resa = r;
    serbatoio = 0;
    ruote = new Wheels(MAX_PRESSIONE);
  }

  public float getGas() { return serbatoio; }

  public float setGas(float qta){						//	restituisce quantità di carburante avanzato
	  float empty = 0;	  
	  if (serbatoio < 0) { serbatoio = 0; }				//	controllo e reimpostazione anche in drive(), ma qui serve al primo rifornimento e ad altre eventuali chiamate future
	  
	  empty = MAX_CARBURANTE - serbatoio; 				//	calcolo quanto carburante entra nel serbatoio
	  
	  if (empty > 0 && empty >= qta) {					//	c'è spazio nel serbatoio ed è maggiore della quantità di carburante richiesta
		  System.out.println("Litri erogati " + qta + " - Litri avanzati 0.0 - setGas()");
		  serbatoio += qta;								//	rifornisco il serbatorio di tutto il carburante richiesto
		  return 0.0f;									//	al benzinaio non resta carburante non erogato
	  }
	  if (empty > 0 && empty < qta) {					//	c'è spazio nel serbatoio ed è inferiore alla quantità di carburante richiesta
		  System.out.println("Litri erogati " + empty + " - Litri avanzati " + (qta - empty) + " - setGas()");
		  serbatoio += empty;							//	rifornisco il serbatoio della quantità rifornibile
		  return qta - empty;							//	al benzinaio resta carburante non erogato
	  }
	  else {		  									//	(empty <= 0.0f) serbatoio pieno	
		  System.out.println("Litri erogati 0 - Litri avanzati " + qta + " - setGas()");
		  return qta;									//	al benzinaio resta tutto il carburante richiesto
	  }
  }

  public Wheels getRuote() { return ruote; }			//	aggiunto per implementare DistributoreBenzina.manutenzioneRuote(Wheels ruote)
  
  public void drive(float percorso) {
  
    float resaReale = 0;
  	  
    for(int i=0; i<percorso; i++) {
      //resaReale = (ruote.getPressioneRuote() * motore.getResa()) / MAX_PRESSIONE;
      resaReale = (ruote.getPressioneRuote() * resa) / MAX_PRESSIONE;
      serbatoio = serbatoio - (1 / resaReale);
      ruote.setStatoRuote(1);
      ruote.setPressioneRuote(1);
	  if (serbatoio <= 0) {			//	aggiungo controllo su livello carburante nel serbatoio durante la guida
		  serbatoio = 0;			//	serve ad evitare numeri negativi
		  return;					//	se il serbatoio è vuoto, l'auto si ferma e il ciclo viene interrotto
	  }
		  
    }
    
  }
  
  // TODO: refactor controlloRuote(): il metodo deve restituire un intero
  //   0 -> se tutto ok
  //   1 -> se vanno controllate le ruote
  //   2 -> se vanno gonfiate le ruote
  //   3 -> se vanno sia controllate che gonfiate  
  public int controlloRuote() {
	  int response = ruote.controlloRuote();
	    if (response == 0)
	    	System.out.println("Ruote in perfetto stato, nessuna operazione richiesta");
	    else if (response == 1) 
	    	System.out.println("Necessario controllare le ruote");
	    else if (response == 2)
	    	System.out.println("Necessario gonfiare le ruote");
	    else
	    	System.out.println("Necessario controllare e gonfiare le ruote"); 
	  return response;
  }
  //	metodo scritto per scrupolo... 
  //	... ho inteso che il refactor di controlloRuote() si riferiva alla classe Wheels
  //	qui mi sembra inutile...
	
  
  
  public void stampaInfo(){
    System.out.println("serbatoio (" + serbatoio + "), " + ruote.stampaInfo());
  }

}
