
//COMMENTO PER AGGIUNGERE UNA MODIFICA
public class Car 
{
  private String nome;
  private float resa;
  private float serbatoio;
  private float capacita;
  private Wheels ruote;
  
  private float MAX_PRESSIONE = 2.5f;

  public Car(String n, float r, float c) {
    nome = n;
    resa = r;
    capacita = c;
    serbatoio = 0;
    ruote = new Wheels(MAX_PRESSIONE);
  }

  public float getGas() { return serbatoio; }

  // se l'importo in input eccede la capacità del serbatoio, 
  // la differenza viene riportata come output
  public float setGas(float qta) { 
    if (serbatoio + qta > capacita) {
      float benzinaEccedente = (serbatoio + qta) - capacita;
      serbatoio = capacita;
      return benzinaEccedente;
    } else {
      serbatoio += qta;
      return 0;
    }
  }
  
  public Wheels getRuote() { return ruote; }

  public void drive(float percorso) {
  
    float resaReale = 0;
  	  
    for(int i=0; i<percorso; i++) {
      resaReale = (ruote.getPressioneRuote() * this.resa) / MAX_PRESSIONE;
      serbatoio = serbatoio - (1 / resaReale);
      ruote.setStatoRuote(1);
      ruote.setPressioneRuote(1);
      
      if (serbatoio < 0){
        serbatoio = 0;
        return;
      }
      
    }
    
  }
  
  public int controlloRuote() { return ruote.controlloRuote(); } 
  
  public void stampaInfo(){
    System.out.println("serbatoio (" + serbatoio + "), " + ruote.stampaInfo());
  }

}
