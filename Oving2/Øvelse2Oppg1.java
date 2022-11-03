import static javax.swing.JOptionPane.*;
class Øvelse2Oppg1{
    public static void main (String[] args){
        //Using try here to avoid errors from text inputs
        try{
        //Reads input and converts to int
        String yearInput = showInputDialog("Enter year: ");
        int year = Integer.parseInt(yearInput);
        //Checking if the year is divisible by 100
        if (year%100 == 0){
            //Checking if the year is a leap year
            if (year%400 == 0){
                System.out.println("The year " + year + " is a leap year.");
            }
            else{
                System.out.println("The year " + year + " is not a leap year.");
            }
        }
        //Checking if the year is a leap year
        else if (year%4 == 0){
            System.out.println("The year " + year + " is a leap year.");
        }
        else{
            System.out.println("The year " + year + " is not a leap year.");
        }
        }
        //Catch statement for invalid inputs
        catch (Exception e){
            System.out.println("The input value must be an integer.");
        }
    }
}