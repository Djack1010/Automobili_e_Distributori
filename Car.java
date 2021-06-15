/*
 * author: Ciro
 */
public class Car 
{
  private String nome;
  private float resa;
  private float serbatoio;
  private float maxSerbatoio; // aggiunta capacita' massima del serbatoio
  private Wheels ruote;

  private float MAX_PRESSIONE = 2.5f; // assegnamo di default una pressione massima

  // Costruttore
  public Car(String n, float r, float max) {
    nome = n;
    resa = r;
    serbatoio = 0;
    maxSerbatoio = max;
    ruote = new Wheels(MAX_PRESSIONE);
  }
  
  public float setGas(float qta) { 
	   
    	if (qta <= (maxSerbatoio - serbatoio)) {
    		serbatoio += qta;
    		return 0;
    	}
    	else {
    		float reso = qta - (maxSerbatoio - serbatoio);
    		serbatoio = maxSerbatoio;
    		return reso;
    	}
  }

  public void drive(float percorso) {
    
    float resaReale = 0;
    
  	for(int i=0; i<percorso; i++) {
      resaReale = (ruote.getPressioneRuote() * resa) / MAX_PRESSIONE;
      serbatoio = serbatoio - (1 / resaReale);
      ruote.setStatoRuote(1);
      ruote.setPressioneRuote(1);
      if (serbatoio < 0) {
    	  serbatoio = 0; // Forzo il serbatoio a VUOTO se andato in negativo
    	  return;
      }
    }
  }
  
  // Il metodo sfrutta quello della classe Wheels
  public int controlloRuote() { 
	  return ruote.controlloRuote(); 
  } 
  
  public float getGas() { 
	  return serbatoio;
  }
  
  public void stampaInfo(){
    System.out.println("serbatoio (" + serbatoio + "), " + ruote.stampaInfo());
    System.out.println();
  }
  
  // METODO CHE RESTITUISCE LE PROPRIETA' DEI PNEUMATICI MONTATI
  public Wheels getRuote() { 
	  return ruote; 
  }

  // Aggiungo i metodi 'get' e 'set' mancanti
  public String getNome() {
		return nome;
  }

  public void setNome(String nome) {
		this.nome = nome;
  }

  public float getResa() {
		return resa;
  }

  public void setResa(float resa) {
		this.resa = resa;
  }

  public float getMaxSerbatoio() {
		return maxSerbatoio;
  }  

}
