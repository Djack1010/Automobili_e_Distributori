public class Car 
{
  // TODO: aggiungere anche la capacità massima del serbatorio, e implementare controlli per assicurarsi che il gas immagazzinato non ecceda la capacità massima
  //======FATTO======
  private String nome;
  private float resa;
  private float serbatoio;
  private float maxSerbatoio;
  private Wheels ruote;
  
  private float MAX_PRESSIONE = 2.5f;

  public Car(String n, float r, float ms)
  {
    nome = n;
    resa = r;
    serbatoio = 0;
    maxSerbatoio = ms;
    ruote = new Wheels(MAX_PRESSIONE);
  }

  public float getGas()
  {
	  return serbatoio;
  }

  public void setGas(float qta)
  {
	  if(maxSerbatoio < serbatoio + qta)
	  {
		  System.out.println("Limite raggiunto");
		  serbatoio += qta - ( serbatoio + qta - maxSerbatoio);
		  return;
	  }
	  serbatoio += qta;
  }
  
  public float getMax()
  {
	  return maxSerbatoio;
  }
  
  public Wheels getRuote()
  {
	  return ruote;
  }

  public void drive(float percorso)
  {
	  float resaReale = 0;
  	  
      for(int i=0; i<percorso && serbatoio > 0; i++)
      {
    	  resaReale = (ruote.getPressioneRuote() * resa) / MAX_PRESSIONE;
    	  if(serbatoio - (1 / resaReale) < 0)
    	  {
    		  ruote.setStatoRuote(serbatoio * resa); //indecisione se mantenere l'argomento attuale o impostare a 1 come nell'altro caso
    		  ruote.setPressioneRuote(serbatoio * resa); //idem come sopra
    		  serbatoio = 0;
    	  }
    	  else
    	  {
    		  serbatoio = serbatoio - (1 / resaReale);
              ruote.setStatoRuote(1);
              ruote.setPressioneRuote(1);
    	  }
      }
    
  }
  
  // TODO: refactor controlloRuote(): il metodo deve restituire un intero
  //   0 -> se tutto ok
  //   1 -> se vanno controllate le ruote
  //   2 -> se vanno gonfiate le ruote
  //   3 -> se vanno sia controllate che gonfiate
  //======FATTO======
  public int controlloRuote()
  {
	  return ruote.controlloRuote();
  } 
  
  public void stampaInfo()
  {
    System.out.println("serbatoio (" + serbatoio + "), " + ruote.stampaInfo());
  }

}
