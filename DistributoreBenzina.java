/*
 * author: iRoxa
 */

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
  public float vendi(double euro, Car auto) {
	float litriPagati = (float)(euro / euroPerLitro);					// calcolo litri di carburante pagati
	float litriNonErogati = auto.setGas(litriPagati);
	float resto = (float)(litriNonErogati * euroPerLitro);				// calcolo eventuale resto per carburante non erogato
    deposito = deposito - litriPagati + litriNonErogati;				// aggiorno litri in deposito
    return resto;
  }

  public void aggiorna(double unPrezzoPerLitro) {
    euroPerLitro = unPrezzoPerLitro;
  }

  public double getBenzina() {
    return deposito;
  } 
  
  
  // TODO: implementare un metodo che prende in input un oggetto Wheels e
  //   fornisce la manutenzione necessaria (controlla le ruote e riporta lo
  //   statoRuote a 0, controlla la pressione e riporta la pressione al massimo)
  public void manutenzioneRuote(Wheels ruote){
    int response = ruote.controlloRuote();    
    if (response == 0)
    	System.out.println("Ruote in perfetto stato, nessuna operazione richiesta");
    else if (response == 1) {
    	System.out.println("Sto ricondizionando le ruote");
    	ruote.restoreCondition();
    }
    else if (response == 2) {
    	System.out.println("Sto gonfiando le ruote");
    	ruote.restorePressure();
    }
    else {
    	System.out.println("Sto ricondizionando e gonfiando le ruote");
    	ruote.restoreCondition();
    	ruote.restorePressure();
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
