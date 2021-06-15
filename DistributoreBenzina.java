public class DistributoreBenzina {
  
  // variabili di istanza della classe
  public double deposito;
  public float euroPerLitro;
  
  //  costruttore della classe
  public DistributoreBenzina(double unPrezzoPerLitro)
  {
    setEuroPerLitro((float)unPrezzoPerLitro);
    setDeposito(0);
  }
  
  
  //  metodi della classe
  public void rifornisci(double unaQuantita)
  {
    deposito = deposito + unaQuantita;
  }

  // TODO: vendi deve modificare anche il serbatorio dell'auto che sta rifornendo 
  // quindi deve prendere in input euro ma anche un oggetto Car a cui farà rifornimento di gas in base all'importo pagato
  //======FATTO======
  public float vendi(float euro, Car mac)
  {
	  if(mac.getMax() < mac.getGas() + (euro / euroPerLitro))
	  {
		  float benzinaNonInseribile = mac.getGas() + (euro / euroPerLitro) - mac.getMax();
		  deposito = deposito - (euro / euroPerLitro) + benzinaNonInseribile;
		  mac.setGas((euro / euroPerLitro) - benzinaNonInseribile);
		  
		  return benzinaNonInseribile * euroPerLitro;
	  }
	  deposito = deposito - (euro / euroPerLitro);
	  mac.setGas((euro / euroPerLitro));
		
	  return 0;
  }

  public void aggiorna(float unPrezzoPerLitro)
  {
    euroPerLitro = unPrezzoPerLitro;
  }

  public double getBenzina()
  {
    return deposito;
  } 
  
  
  // TODO: implementare un metodo che prende in input un oggetto Wheels e
  //   fornisce la manutenzione necessaria (controlla le ruote e riporta lo
  //   statoRuote a 0, controlla la pressione e riporta la pressione al massimo)
  //======FATTO======
  public void manutenzioneRuote(Wheels ruote)
  {
	  if (ruote.controlloRuote() == 1)
	  {
		  //System.out.println("Necessario controllare le ruote");
		  ruote.resetStatoRuote();
		  return;
	  }
	  	
	  if (ruote.controlloRuote() == 2)
	  {
		  //System.out.println("Necessario gonfiare le ruote");
		  ruote.resetPressioneRuote();
	  	  return;
	  }
	  	
	  if (ruote.controlloRuote() == 3)
	  {
	  	  //System.out.println("Necessario controllare e gonfiare le ruote");
	  	  ruote.resetStatoRuote();
	  	  ruote.resetPressioneRuote();
	  	  return;
	  }
	  	
	  //System.out.println("Ruote in perfetto stato, nessuna operazione richiesta");
	  return;
  }  
  
  
  // metodi getter e setter 
  public double getDeposito() 
  {
    return deposito;
  }
  
  public void setDeposito(double deposito)
  {
    this.deposito = deposito;
  }
  
  public double getEuroPerLitro()
  {
    return euroPerLitro;
  }
  
  public void setEuroPerLitro(float euroPerLitro)
  {
    this.euroPerLitro = euroPerLitro;
  }
  
}