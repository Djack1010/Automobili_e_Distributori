
public class DistributoreBenzina {
  
  // variabili di istanza della classe
  public double deposito;
  // COMMENTO PER AGGIUNGERE UNA MODIFICA
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
  public void vendi(double euro) {
    deposito = deposito - (euro / euroPerLitro);
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
    // TODO implementare...
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
