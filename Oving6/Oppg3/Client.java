package Oppg3;

public class Client {
    public static void main(String[] args) {
        //Lager to matriser
        int[][] matrise1 = {
            {1, 2, 3, 4}, 
            {4, 5, 6, 5},
            {2, 4, 1, 2},
            {1, 2, 3, 4}
        };
        Matrise objekt = new Matrise(matrise1);
        int[][] matrise2 = {
            {5, 8, 3, 4}, 
            {1, 5, 5, 6},
            {6, 4, 2, 7}, 
            {2, 15, 2, 1}
        };
        Matrise objekt2 = new Matrise(matrise2);
        //Tester addisjons-metoden og printer resultatet
        pResult(objekt.addMatrise(objekt2));

        //Tester multuplikasjons-metoden og printer resultatet
        pResult(objekt.multMatrise(objekt2));

        //Tester transponerings-metoden
        pResult(objekt.tpMatrise());


    }
    //Metode for å printe en matrise
    static void pResult(int [][] input){
        if (input == null){
            System.out.println("Operation is not possible.");
        } else{
            for(int i = 0; i < input.length; i++){
                System.out.print("|");
                for(int i2 = 0; i2 < input[0].length; i2++){
                    System.out.print(" " + input[i][i2]);
                }
                System.out.println(" |");
            }
        }
        System.out.println();
    }
}
