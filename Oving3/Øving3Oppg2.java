import static javax.swing.JOptionPane.*;
class Øving3Oppg2{
    public static void main (String[] args){
        while(true) {
            try{
                //Tar input. Avslutter loopen dersom inputen er "exit"
                String numberInput = showInputDialog("Skriv inn et tall, eller skriv inn \"Exit\" for å avslutte: ");
                if(numberInput.equalsIgnoreCase("exit")){
                    System.out.println("Takk for nå!");
                    break;
                }
                int number = Integer.parseInt(numberInput);

                //Definerer en boolean
                boolean prime = true;

                //Hvis tallet er delelig med 2, er det ikke et primtall
                if (number%2==0){
                    System.out.println("Tallet er ikke et primtall.");
                    prime = false;
                }
                else{
                    //Deler så med oddetall
                    for(int i = 3;i<number;i+=2){
                        if(number%i==0){
                            System.out.println("Tallet er ikke et primtall.");
                            //Variabel prime blir false dersom tallet er delelig med et av oddetallene. 
                            prime = false;
                            break;
                        }
                    }
                }
                //Hvis prime ikke har blitt false, må tallet være et primtall
                if(prime){
                    System.out.println("Tallet er et primtall.");
                }
            }
            //Avslutter programmet dersom brukerer trykker "Cancel" på dialogboksen, da det gir en null-verdi til variabelen
            catch(NullPointerException f){
                System.out.println("Takk for nå!");
                break;
            }
            catch(Exception e){
                System.out.println("Vennligst tast inn et heltall");
            }
            
        }
    }
}