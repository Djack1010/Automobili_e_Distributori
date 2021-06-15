// commento pb

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

  // se il serbatoio della macchina non è sufficiente per contenere la benzina che si sta acquistando,
  // il metodo restituisce il resto dovuto in euro
  public float vendi(int euro, Car macchina) {
    // calcolo i litri di benzina per la quantità di euro in input ed inizializzo la variabile per il resto
    double litriRifornimento = euro / euroPerLitro;
    float resto = 0;
    
    // controllo se il distributore ha sufficiente benzina per il rifornimento richesto
    if (litriRifornimento > deposito){
      resto += (litriRifornimento - deposito) * euroPerLitro;
      litriRifornimento = deposito;
    }
    
    // faccio rifornimento alla macchina, salvando eventuali litri restituiti che non sono 
    //   entrati nel serbatoio per eccedenza della capacità
    float litriEccesso = macchina.setGas((float) litriRifornimento);
    
    // aggiungo al resto la quantità di litri in eccesso sul serbatorio (se presente)
    resto += litriEccesso * euroPerLitro;
    
    // sottraggo dal deposito distributore i litri di rifornimento reali fatti (reinserendo eventuali eccessi)
    deposito -= (litriRifornimento - litriEccesso);
    
    // restituisco il resto
    return resto;    
  }

  public void aggiorna(double unPrezzoPerLitro) {
    euroPerLitro = unPrezzoPerLitro;
  }

  public double getBenzina() {
    return deposito;
  } 
  
  public void manutenzioneRuote(Wheels ruote){
    switch(ruote.controlloRuote()) {
	case 3:
	  ruote.gonfiaRuote();
	  ruote.manutenzioneRuote();
	  break;
	case 2:
	  ruote.gonfiaRuote();
	  break;
	case 1:
	  ruote.manutenzioneRuote();
	  break;
    }
    return;
    
    // Altra possibile soluzione usando costrutto if
    /*
    
    int statusRuote = ruote.controlloRuote();
    
    if (statusRuote == 0)
      return;
     
    if (statusRuote == 1 || statusRuote == 3)
      ruote.manutenzioneRuote();
    
    if (statusRuote == 2 || statusRuote == 3)
      ruote.gonfiaRuote();
    
    return;    
    
    */
    
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
