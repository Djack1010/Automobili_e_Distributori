// Author
// Edoardo

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

  // TODO: vendi deve modificare anche il serbatorio dell'auto che sta rifornendo        FATTO
  // quindi deve prendere in input euro ma anche un oggetto Car a cui farÃ  rifornimento di gas in base all'importo pagato
  public float vendi(float euro, Car macchina) {
	float litriPerEuro =  (float) (euro/euroPerLitro);   //cast necessario
	float maxSerbatoio = macchina.getMaxGas();
	float serbatoio = macchina.getGas();
	float resto = 0f;
	
	if (((serbatoio + litriPerEuro) > maxSerbatoio) && ((deposito - litriPerEuro) < 0)){
		System.out.println("Errore, hai provato a mettere più benzina di quella che il distributore"
				+ " possa erogare e più di quanto la tua macchina ne possa contenere");
		
		float eccedenza1 = (serbatoio + litriPerEuro) - maxSerbatoio;
		float eccedenza2 = (float) (litriPerEuro - deposito);
		float eccedenza = eccedenza1 + eccedenza2;
		deposito = deposito - (litriPerEuro - eccedenza) + (macchina.serbatoio0backup);
		macchina.setGas(litriPerEuro);
		resto = (float) (eccedenza * euroPerLitro);
		return resto;
		}
	
	if ((serbatoio + litriPerEuro) > maxSerbatoio) {     // funzione per non far erogare piu benzina di quanta ne possa contenere
		float eccedenza = (serbatoio + litriPerEuro) - maxSerbatoio;
		macchina.setGas(litriPerEuro); // faccio il setgas al massimo senza l'eccedenza per gestire il resto, gestisco eccedenza del maxserbatoio in Car.java per evitare bug quando viene chiamato il setGas.
		deposito = deposito - (litriPerEuro - eccedenza) + (macchina.serbatoio0backup); // rimuovo la "riserva" perchè è benzina effettiva che c'è nel serbatoio
		resto = (float) (eccedenza * euroPerLitro);
		return resto;	
	}
		
	if ((deposito - litriPerEuro) < 0) {    // funzione per non fare andare in negativo il distributore
		float eccedenza = (float) (litriPerEuro - deposito);
		resto = (float) (eccedenza * euroPerLitro);
		macchina.setGas(litriPerEuro - eccedenza);
		deposito = 0;
		System.out.println("Distributore ha finito la benzina");
		return resto;
		
	}
	if (((serbatoio + litriPerEuro) <= maxSerbatoio) && ((deposito - litriPerEuro) >= 0)) {   // se nessuna delle condizioni precedenti, erogo benzina normalmente
		macchina.setGas(litriPerEuro);
	    deposito = deposito - litriPerEuro;
	    System.out.println("Ho venduto " + litriPerEuro + " litri di benzina");
		resto = 0f;
	}
	return resto;
}
  
  // TODO: implementare un metodo che prende in input un oggetto Wheels e
  //   fornisce la manutenzione necessaria (controlla le ruote e riporta lo             FATTO
  //   statoRuote a 0, controlla la pressione e riporta la pressione al massimo)
  public void manutenzioneRuote(Wheels ruote){
    // TODO implementare...  FATTO
	  ruote.manutenzioneRuote();
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
