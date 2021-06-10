# Automobili_e_Distributori

Modificare due metodi dentro Car.java e DistributoreBenzina.java in modo che gestiscano anche resti/litri in eccedenza su un rifornimento di benzina. Fate attenzione alle variazioni sulle dichiarazioni del metodo, che adesso restituiscono un oggetto 'float' entrambe e non più 'void'. Queste dichiarazioni devono essere rispettate per far funzionare le soluzioni con il file di test 'MappaDistributori.java' (senza ovviamente andare a modificarlo).

### Car.java
```
// se l'importo in input eccede la capacità del serbatoio, 
// la differenza viene riportata come output
public float setGas(float qta)
```
### DistributoreBenzina.java
```
// se il serbatoio della macchina non è sufficiente per contenere la benzina che si sta acquistando,
// il metodo restituisce il resto dovuto in euro
public float vendi(int euro, Car macchina)
```
