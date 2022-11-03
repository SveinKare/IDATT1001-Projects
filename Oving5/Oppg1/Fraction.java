public class Fraction{
    private int teller;
    private int nevner;

    //Lager metode for forkorting
    private void reduceFrac(){
        if (!(teller > 0 ^ nevner > 0)){
            teller = Math.abs(teller);
            nevner = Math.abs(nevner);
        }
        //Bruker euklids algoritme for å finne høyest felles faktor
        int a = teller;
        int b = nevner;
        int t;
        while (b != 0){
            t = b;
            b = a % b;
            a = t;
        }
        teller /= a;
        nevner /= a;
    }

    //Overloader konstruktøren for å ta både 1 og 2 inputs
    //2 inputs:
    public Fraction(int tellerIn, int nevnerIn){
        //Kaster exception viss nevner er 0
        if(nevnerIn == 0){
            throw new IllegalArgumentException();
        }else {
            teller = tellerIn;
            nevner = nevnerIn;
        }
        reduceFrac();
    }
    //1 input, gir 1 i nevner
    public Fraction(int tellerIn){
        teller = tellerIn;
        nevner = 1;
        reduceFrac();
    }
    //Printer brøken
    public void getFrac(){
        if(teller < 0 || nevner < 0){
            System.out.println("-(" + Math.abs(teller) + "/" + Math.abs(nevner) + ")");
        } else{
            System.out.println(teller + "/" + nevner);
        }
    }

    //Metode for multiplikasjon
    public void mpFrac(int tellerIn, int nevnerIn){
        teller *= tellerIn;
        nevner *= nevnerIn;
        reduceFrac();
    }

    //Metode for divisjon
    public void divFrac(int tellerIn, int nevnerIn){
        teller *= nevnerIn;
        nevner *= tellerIn;
        reduceFrac();
    }
    //Metode for addisjon
    public void addFrac(int tellerIn, int nevnerIn){
        tellerIn *= nevner;
        teller *= nevnerIn;
        nevner *= nevnerIn;
        teller += tellerIn;
        reduceFrac();
    }

    //Metode for subtraksjon
    public void subFrac(int tellerIn, int nevnerIn){
        tellerIn *= nevner;
        teller *= nevnerIn;
        nevner *= nevnerIn;
        teller -= tellerIn;
        reduceFrac();
    }
    public static void main(String[] args){
        Fraction brøk = new Fraction(-5, 2);
        brøk.subFrac(4, -6);
        brøk.getFrac();
    }
}