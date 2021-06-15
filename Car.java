public class Car 
// vediamo un po' se riesco a committare 'sto commento...
{
  // TODO: aggiungere anche la capacità massima del serbatorio, e implementare controlli per assicurarsi che il gas immagazzinato non ecceda la capacità massima
  private String nome;
  private float resa;
  private float serbatoio;
  private Wheels ruote;
  
  private float MAX_PRESSIONE = 2.5f;

  public Car(String n, float r) {
    nome = n;
    resa = r;
    serbatoio = 0;
    ruote = new Wheels(MAX_PRESSIONE);
  }

  public float getGas() { return serbatoio; }

  public void setGas(float qta) { serbatoio += qta; }

  public void drive(float percorso) {
  
    float resaReale = 0;
  	  
    for(int i=0; i<percorso; i++) {
      resaReale = (ruote.getPressioneRuote() * motore.getResa()) / MAX_PRESSIONE;
      serbatoio = serbatoio - (1 / resaReale);
      ruote.setStatoRuote(1);
      ruote.setPressioneRuote(1);
    }
    
  }
  
  // TODO: refactor controlloRuote(): il metodo deve restituire un intero
  //   0 -> se tutto ok
  //   1 -> se vanno controllate le ruote
  //   2 -> se vanno gonfiate le ruote
  //   3 -> se vanno sia controllate che gonfiate
  public void controlloRuote() { ruote.controlloRuote(); } 
  
  public void stampaInfo(){
    System.out.println("serbatoio (" + serbatoio + "), " + ruote.stampaInfo());
  }

}
