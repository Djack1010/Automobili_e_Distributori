/***********************************************
*	Paolo Bondi - Corso TIC (UF6) - 04/06/21   *
*	Esercizio2 - Automobili e distributori v2  *											
***********************************************/

public class DistributoreBenzina {
  
  // variabili di istanza della classe
  public double deposito;
  public double euroPerLitro;
  
  //  costruttore della classe
  public DistributoreBenzina(double unPrezzoPerLitro){
    setEuroPerLitro(unPrezzoPerLitro);
    setDeposito(0);
  }
  
  
  //  metodi della classe
  public void rifornisci(double unaQuantita) {
    deposito = deposito + unaQuantita;
  }

  // TODO: vendi deve modificare anche il serbatorio dell'auto che sta rifornendo
  // quindi deve prendere in input euro ma anche un oggetto Car a cui farà rifornimento di gas in base all'importo pagato
  // FATTO
  
  public float vendi(int euro, Car c) {
	float quantitaAcquistabile = (float) euro/(float) euroPerLitro;      				// >>> nuovo
	float quantitaAcquistabileBkp = quantitaAcquistabile;								// >>> nuovo
	float serbatoioDisponibileBkp = c.serbatoioDisponibile();							// >>> nuovo
	double depositoBkp = deposito;														// >>> nuovo
	int tipo = 0;
	float r = 0.0f;
	
	// Sono stati aggiunti i controlli sia sul serbatoio che sul deposito
	// Il resto viene calcolato quando il serbatoio può contenere meno benzina di quella acquistabile con l'importo caricato
	// e quando il distributore ha meno benzina di quella acquistabile
	
	if ((quantitaAcquistabile <= c.serbatoioDisponibile()) && (quantitaAcquistabile <= deposito))
	{
		tipo = 1;
		deposito = deposito - (quantitaAcquistabile);
	    c.setGas(quantitaAcquistabile);
	    // r = 0.0f;
	}
	
	else if ((quantitaAcquistabile <= c.serbatoioDisponibile()) && (quantitaAcquistabile > deposito))
	{
		tipo = 2;
		quantitaAcquistabile = (float) deposito;
		deposito = deposito - (quantitaAcquistabile);		// il deposito si azzera
	    c.setGas(quantitaAcquistabile);
	    r = (float)(quantitaAcquistabileBkp - quantitaAcquistabile)*(float)euroPerLitro;
	}
	
	else if ((quantitaAcquistabile > c.serbatoioDisponibile()) && (c.serbatoioDisponibile() >= deposito))
	{
		tipo = 3;
		quantitaAcquistabile = (float) deposito;
		deposito = deposito - (quantitaAcquistabile);		// il deposito si azzera
	    c.setGas(quantitaAcquistabile);
	    r = (float)(quantitaAcquistabileBkp - quantitaAcquistabile)*(float)euroPerLitro;
	}
	
	else if ((quantitaAcquistabile > c.serbatoioDisponibile()) && (c.serbatoioDisponibile() < deposito))
	{
		tipo = 4;
		quantitaAcquistabile = c.serbatoioDisponibile();
		deposito = deposito - (quantitaAcquistabile);		
	    c.setGas(quantitaAcquistabile);
	    r = (float)(quantitaAcquistabileBkp - quantitaAcquistabile)*(float)euroPerLitro;
	}
	
	
	/*             TABELLA DI VERIFICA CALCOLI
		
	System.out.println();
	System.out.println("-------------------------------------------------------------------");
	System.out.println("Tipo                    : " + tipo);
	System.out.println("importo da spendere     : " + euro);
	System.out.println("Quantità aqu. teorica   : " + quantitaAcquistabileBkp + " - " + quantitaAcquistabileBkp*euroPerLitro);
	System.out.println("Quantità aqu. effettiva : " + quantitaAcquistabile + " - " + quantitaAcquistabile*euroPerLitro);
	System.out.println("Serbatoio disp (prima)  : " + serbatoioDisponibileBkp + " - " + serbatoioDisponibileBkp*euroPerLitro);
	System.out.println("Serbatoio disp (dopo)   : " + c.serbatoioDisponibile() + " - " + c.serbatoioDisponibile()*euroPerLitro);
	System.out.println("Deposito (prima)        : " + depositoBkp + " - " + depositoBkp*euroPerLitro);
	System.out.println("Deposito (dopo)         : " + deposito + " - " + deposito*euroPerLitro);
	System.out.println("Resto                   : " + r);
	System.out.println("-------------------------------------------------------------------");
	System.out.println();
	
	*/
		
	return  r;
  }

  public void aggiorna(double unPrezzoPerLitro) {
    euroPerLitro = unPrezzoPerLitro;
  }

  public double getBenzina() {
    return deposito;
  } 
  
  // TODO: implementare un metodo che prende in input un oggetto Wheels e
  // fornisce la manutenzione necessaria (controlla le ruote e riporta lo
  // statoRuote a 0, controlla la pressione e riporta la pressione al massimo)
  // FATTO
  
  public void manutenzioneRuote(Wheels ruote){
    // TODO implementare...
	// FATTO  
	// ruote.manutenzioneRuote();	  
	   
	// definisco una variabile per scegliere la manutenzione da effettuare
	int checkRuote = ruote.controlloRuote();
	
	if (checkRuote == 1 || checkRuote == 3) {
		ruote.setAzzeraRuote();
	}
	  
	if (checkRuote == 2 || checkRuote == 3) {
		ruote.setMaxPressioneRuote();
	} 
	
	return;
	 	  
  }  
    
  // metodi getter e setter 
  public double getDeposito() {
    return deposito;
  }
  public void setDeposito(double deposito) {
    this.deposito = deposito;
  }
  public double getEuroPerLitro() {
    return euroPerLitro;
  }
  public void setEuroPerLitro(double euroPerLitro) {
    this.euroPerLitro = euroPerLitro;
  }
  
  

}
