import static javax.swing.JOptionPane.*;
class Øving3Oppg1{
    public static void main (String[] args){
        //Input
        String startInput = showInputDialog("Skriv ut gangetabellen fra: ");
        String endInput = showInputDialog("Til: ");
        //Try for å unngå exceptions
        try{
            //Konverterer til int
            int startPoint = Integer.parseInt(startInput);
            int endPoint = Integer.parseInt(endInput);
            do {
                //Printer gangetabellene
                System.out.println(startPoint + "-gangen");
                for (int i = 1; i < 11; i++){
                    System.out.println(startPoint*i);
                }
                startPoint++;
            }
            while(startPoint <= endPoint);
        }
        catch (Exception e){
            System.out.println("Inputs must be integers.");
        }
    }
}