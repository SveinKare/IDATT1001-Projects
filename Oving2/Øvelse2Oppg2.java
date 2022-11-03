class Øvelse2Oppg2{
    public static void main (String [] args){
        //Regner pris per gram for begge merker
        double pricePerGramA = 35.9/450;
        double pricePerGramB = 39.5/500;
        //Sammenligner med if funksjon
        if (pricePerGramA > pricePerGramB){
            System.out.println("Merke B er billigst.");
        }
        else{
            System.out.println("Merke A er billigst.");
        }
    }
}