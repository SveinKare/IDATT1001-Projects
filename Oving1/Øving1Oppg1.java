import static javax.swing.JOptionPane.*;
class Øving1Oppg1 {
    public static void main (String[] args){
        String tommerAvlest = showInputDialog("Skriv inn lengden du vil omforme i tommer: "); //Leser av tommer fra brukeren
        double tommer = Double.parseDouble(tommerAvlest); //Konverterer til double 
        double centimeter = tommer * 2.54; //Gjør om til centimeter
        System.out.println(tommer + " tommer er " + centimeter + " centimeter."); //Printer
    }
}