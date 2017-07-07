package Klassen;

/**
 * Created by elisabethd on 07.07.17. Copy & paste vom letzten Mal. Hoffentlich funzt es.
 */

public class LiKlasse {
    public String marke;
    public int price;


    public LiKlasse(String Automarke, int Autopreis) {
        this.marke = Automarke;
        this.price = Autopreis;
    }

    public void printAutoDetails() {
        System.out.println("Marke: " + marke);
        System.out.println ("Preis: " + price);


    }
}