//Author
//Edoardo

public class Car 
{
  // TODO: aggiungere anche la capacitÃ  massima del serbatorio, e implementare controlli per assicurarsi che il gas immagazzinato non ecceda la capacitÃ  massima
 // FATTO
  private String nome;
  private float resa;
  private float serbatoio;
  private float maxSerbatoio;
  public Wheels ruote;
  public float serbatoio0backup;
  
  private float MAX_PRESSIONE = 2.5f;

  public Car(String n, float r, int ms) {
    nome = n;
    resa = r;
    serbatoio = 0;
    maxSerbatoio = ms;
    ruote = new Wheels(MAX_PRESSIONE);
  }

  public float getGas() { return serbatoio; }
  public float getMaxGas() { return maxSerbatoio; }

  public void setGas(float qta) { 			
	  serbatoio = serbatoio0backup; //lascio il check del serbatoio max anche qua per quando viene usato il setGas e non il vendi
	  if ((serbatoio + qta) > maxSerbatoio) {
		  	  
			  System.out.println("Hai provato a mettere " + ((serbatoio + qta) - maxSerbatoio) + " litri in più rispetto alla tua capacità massima");
			  serbatoio = maxSerbatoio;
	  }
	   else {
		   serbatoio += qta;
		   
			  
	   }
	  }

  public void drive(float percorso) {
    float resaReale = 0;
    int i = 0;
    while (i < percorso) {
    	if ((serbatoio - (1 / (ruote.getPressioneRuote() * resa) /MAX_PRESSIONE)) < 0.05) {  // funzione della riserva (meno di 0,05 litri per evitare che vada in negativo)
      	  	serbatoio0backup = serbatoio;
    		serbatoio = 0;
    		break;
        }
        else
        {
      	  resaReale = (ruote.getPressioneRuote() * resa) / MAX_PRESSIONE;
            serbatoio = serbatoio - (1 / resaReale);
            ruote.setStatoRuote(1);
            ruote.setPressioneRuote(1); 
            i++;
        }
    }
  }
  
  // TODO: refactor controlloRuote(): il metodo deve restituire un intero
  //   0 -> se tutto ok
  //   1 -> se vanno controllate le ruote                                    FATTO
  //   2 -> se vanno gonfiate le ruote
  //   3 -> se vanno sia controllate che gonfiate
  public void controlloRuote() { 
	  if (ruote.controlloRuote() == 0 ) {
		  System.out.println("Ruote in perfetto stato, nessuna operazione richiesta");
	  }
	  if (ruote.controlloRuote() == 1 ) {
		  System.out.println("Necessario controllare le ruote");
	  }
	  if (ruote.controlloRuote() == 2 ) {
		  System.out.println("Necessario gonfiare le ruote");
	  }
	  if (ruote.controlloRuote() == 3 ) {
		  System.out.println("Necessario controllare e gonfiare le ruote");
	  }
	  } 
  
  public void stampaInfo(){
    System.out.println("serbatoio (" + serbatoio + "), " + ruote.stampaInfo());
  }

public Wheels getRuote() {
	return ruote;
}

}
