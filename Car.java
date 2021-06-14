/* MARILINA D'ANDRETTA */

public class Car  
{
  // TODO: aggiungere anche la capacitÃ  massima del serbatorio, e implementare controlli per assicurarsi che il gas immagazzinato non ecceda la capacitÃ  massima
  private String nome;
  private float resa;
  private float serbatoio;
  private Wheels ruote;
  //private Engine motore;  //private Engine.EngineType motore;??
  
  private float MAX_PRESSIONE = 2.5f;
  private float MAX_SERBATOIO; //Aggiunta quantità MEDIA massima di un serbatoio

  public Car(String n, float r, float m) { // NON SONO SICURA CHE LE VARIABILI SIANO SCRITTE NEL MODO CORRETTO // Engine.EngineType m???
    nome = n;
    resa = r;
    serbatoio = 0;
    MAX_SERBATOIO = m;
    //motore = m;
    ruote = new Wheels(MAX_PRESSIONE);
  }

  public float getGas() { 
    
    if (serbatoio < 0f)  
      serbatoio = 0f;
    
    return serbatoio;
  }
  
  public Wheels getRuote() { return ruote; }
  
  public float setGas(float qta){ //REFACTORING DEL METODO
    
  float spazioDisponibile = MAX_SERBATOIO - serbatoio;//calcola lo spazio disponibile nel serbatoio

  if (qta > spazioDisponibile) {
    serbatoio = MAX_SERBATOIO;
    float benzinaInEccesso = qta - spazioDisponibile; //calcola la benzina in eccesso
    return benzinaInEccesso; //benzina in eccesso  
  }
  else {
    serbatoio += qta;
    return 0;   
  }
    
  }

  
  public void drive(float percorso) {
  
    float resaReale = 0;
      
    for(int i=0; i<percorso; i++) {
      
      resaReale = (ruote.getPressioneRuote() * resa) / MAX_PRESSIONE;
      serbatoio = serbatoio - (1 / resaReale);
      ruote.setStatoRuote(1);
      ruote.setPressioneRuote(1);
      
      if (serbatoio <= 0) //aggiunto controllo sul livello del serbatoio
        return;
      
      }
                          
    }
                                         
  // TODO: refactor controlloRuote(): il metodo deve restituire un intero
  //   0 -> se tutto ok
  //   1 -> se vanno controllate le ruote
  //   2 -> se vanno gonfiate le ruote
  //   3 -> se vanno sia controllate che gonfiate
  public void controlloRuote() { ruote.controlloRuote(); } //refactor del metodo controlloRuote()
  
  public void stampaInfo(){
    System.out.println("serbatoio (" + serbatoio + "), " + ruote.stampaInfo());
  }

}
