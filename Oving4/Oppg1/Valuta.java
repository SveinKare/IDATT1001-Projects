public class Valuta{
    //Kurs som attribute
    private double exRate;

    //Constructor
    public Valuta(double exRateIn){
        exRate = exRateIn;
    }

    //Konverterer til norske kroner
    public double toNok(double amount){
        return amount*exRate;
    }

    //Konverterer fra norske kroner
    public double fromNok(double amount){
        return amount*(1/exRate);
    }
}