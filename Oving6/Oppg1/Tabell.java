package Oppg1;
class Tabell{
    public static void main(String[] args){
        //Lager array og random objekt
        int[] antall = new int[10];
        java.util.Random random = new java.util.Random();

        for (int i = 1; i <= 100000; i++){
            antall[random.nextInt(10)] += 1;
        }

        int counter = 0;
        for (int number : antall){
            System.out.println(counter + ":" + number);
            counter++;
        }
    }
}