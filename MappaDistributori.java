// commento pb

import java.util.Scanner;

public class MappaDistributori {
  
  public static void main(String atgs[]) {

      DistributoreBenzina esso = new DistributoreBenzina(1.489);
    
      Car panda = new Car("Panda", 20, 50);
      
      panda.setGas(20);
      esso.rifornisci(200.0);
      
      while (esso.getDeposito() > 0){
        
        System.out.println("Situazione attuale: distributore ha ancora " + esso.getDeposito() + " litri di benzina e la macchina ha " + panda.getGas() + " litri nel serbatoio");
      
      	while (panda.getGas() > 0){
      	  System.out.println("Guidi per 30 km...");
      	  panda.drive(30);
      	}
        
        System.out.println("benzina esaurita... necessario rifornimento!");
        panda.stampaInfo();
        
        Scanner in = new Scanner(System.in);
        System.out.printf("Il benzinaio ti chiede: 'Quanto faccio?'   ");
        int s = in.nextInt();
        float resto = esso.vendi(s, panda);
        System.out.println("Ti vengono restituiti " + resto + " euro di resto");
        esso.manutenzioneRuote(panda.getRuote());
        panda.stampaInfo();
        
      }
      
      System.out.println("Il distributore non ha più benzina, sono rimasti " + panda.getGas() + " litri nel serbatoio");
      panda.stampaInfo();
      while (panda.getGas() > 0){
      	  System.out.println("Guidi per 10 km...");
      	  panda.drive(10);
      }
   
      System.out.println("benzina esaurita... fine");
    
  }
}
