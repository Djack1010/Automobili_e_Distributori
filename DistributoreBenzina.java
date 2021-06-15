
/*
 * author: Ciro
 */
public class DistributoreBenzina {
  
  // variabili di istanza della classe
  public float deposito;
  public float euroPerLitro;
  
  //  costruttore della classe
  public DistributoreBenzina(double unPrezzoPerLitro){
    aggiornaPrezzoCarburante((float)unPrezzoPerLitro);
    setDeposito(0);
  }
  
  
  //  metodi della classe
  public void rifornisci(double unaQuantita) {
    deposito = deposito + (float)unaQuantita;
  }

  public float vendi(float euro, Car c) {
	  
	  float carburanteReso;
	  float qtaPagata = euro/euroPerLitro;
	  
	  if (qtaPagata <= deposito) {
		  carburanteReso = c.setGas(qtaPagata);
		  deposito = deposito - qtaPagata + carburanteReso ;
		  return carburanteReso * euroPerLitro;
	  }
	  else {
		  float carburanteNonVersato = qtaPagata - deposito;
		  carburanteReso = c.setGas(deposito);
		  deposito = 0;
		  return (carburanteNonVersato + carburanteReso) * euroPerLitro;
	  }	  
  }

  public void aggiornaPrezzoCarburante(float unPrezzoPerLitro) {
    euroPerLitro = unPrezzoPerLitro;
  }

  public double getBenzina() {
    return deposito;
  } 
   
  // Metodo che effetta la manutenzione in funzione dello stato delle ruote
  public void manutenzioneRuote(Wheels ruote){
  
	/* definisco una variabile per scegliere la
       manutenzione da effettuare */
	int checkRuote = ruote.controlloRuote(); 	
	switch(checkRuote) {
	case 0: break;
	case 1: 
		ruote.setAzzeraStatoRuote();
		break;
	case 2:
		ruote.setMaxPressioneRuote();
		break;
	case 3:
		ruote.setMaxPressioneRuote();
    	ruote.setAzzeraStatoRuote();
    	break;	
}
  }  
   
  // metodi getter e setter 
  public double getDeposito() {
    return deposito;
  }
  public void setDeposito(float deposito) {
    this.deposito = deposito;
  }
  public double getEuroPerLitro() {
    return euroPerLitro;
  }
  
}