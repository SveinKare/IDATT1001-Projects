public class Spiller{
    private int sumPoeng;
    //Kaster terning med Random
    void kastTerning(){
        java.util.Random terning = new java.util.Random();
        if(sumPoeng > 100){
            sumPoeng -= (terning.nextInt(6) + 1);
        }else{
            sumPoeng += (terning.nextInt(6) + 1);
        }
    }
    //Henter poengsum
    int getSumPoeng(){
        return sumPoeng;
    }
    //Sjekker om en spiller er ferdig
    boolean erFerdig(){
        return sumPoeng == 100;
    }
}