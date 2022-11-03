import javax.swing.*;
class Client{
    public static void main(String[] args){
        
        boolean runCheck = false;
        do{
            //Lager objekter for hver valuta, kurser er per 01.09.2022
            Valuta euro = new Valuta(10.01);
            Valuta usd = new Valuta(10.0);
            Valuta yen = new Valuta(0.072);

            //Lager array med alternativer
            Object[] options = {"To NOK", "From NOK", "Cancel"};

            //Prompter brukeren om å velge fra eller til NOK
            int choice = JOptionPane.showOptionDialog(null, "Would you like to convert to or from NOK?", "Currency converter", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);

            //Switch statement for de forskjellige valgene
            switch (choice){
                case 0:
                    //Brukeren har valgt "To NOK"

                    //Lager objekter for input
                    JTextField euroAmount = new JTextField(4);
                    JTextField usdAmount = new JTextField(4);
                    JTextField yenAmount = new JTextField(4);
                    //Lager array til prompt
                    Object[] convertPrompt = {"Euro: ", euroAmount, "USD: ", usdAmount, "Yen: ", yenAmount};

                    //Bruker while loop med try statement for å forsikre at brukeren skriver gyldige verdier
                    while(true){
                        //Dialogboks for mengder som skal konverteres
                        int choice2 = JOptionPane.showConfirmDialog(null, convertPrompt, "Enter the amounts you would like to convert", JOptionPane.OK_CANCEL_OPTION);
                        try{
                            //Sjekker om "Ok" eller "Cancel" ble valgt
                            if (choice2 == 0){
                                //Konverterer til doubles
                                double euroAmountDouble = Double.parseDouble(euroAmount.getText());
                                double usdAmountDouble = Double.parseDouble(usdAmount.getText());
                                double yenAmountDouble = Double.parseDouble(yenAmount.getText());

                                //Summerer med hjelp av toNok metoden
                                double total = 0;
                                total += euro.toNok(euroAmountDouble);
                                total += usd.toNok(usdAmountDouble);
                                total += yen.toNok(yenAmountDouble);
                                JOptionPane.showMessageDialog(null, "Your total in NOK is: " + total);
                                break;
                            } else {
                                //Bryter loopen dersom brukeren trykket "Cancel"
                                break;
                            }
                        } catch(Exception e){
                            System.out.println("Please check that your inputs are decimal numbers.");
                        }
                    }
                    //Ferdig med "To NOK"
                    break;
                
                case 1:
                    //Brukeren har valgt "From NOK"
                    //Definerer variabler som trengs senere
                    double amountDouble;
                    double total = 0;
                    //Gir brukeren en meny for å velge valuta
                    Object[] currencies = {"Euro", "USD", "Yen"};
                    Object currencyObject = JOptionPane.showInputDialog(null, "Choose which currency to convert to", "Currency converter", JOptionPane.PLAIN_MESSAGE, null, currencies, null);
                    String currencyString = currencyObject.toString();

                    //Brukeren skriver inn antall. While loop for å unngå feil input
                    while (true){
                        String amountString = JOptionPane.showInputDialog("Input the amount you would like to convert: ");
                        try{
                            amountDouble = Double.parseDouble(amountString);
                            break;
                        } catch (Exception e){
                            System.out.println("Please ensure that your inputs are decimals.");
                        }
                    }


                    switch(currencyString){
                        case "USD":
                            total += usd.fromNok(amountDouble);
                            break;
                        case "Euro":
                            total += euro.fromNok(amountDouble);
                            break;
                        case "Yen":
                            total += yen.fromNok(amountDouble);
                            break;
                    }
                    //Viser resultat og avslutter case
                    JOptionPane.showMessageDialog(null, "Your total is: " + total + " " + currencyString);

                    //Ferdig med "From NOK"
                    break;
                case 2:
                    //Brukeren har valgt "Cancel"
                    runCheck = false;
                    break;
            }
            //Returnerer 0 dersom brukeren trykker "Yes", sjekker med conditional operator om loopen skal brytes
            int runCheckInt = JOptionPane.showOptionDialog(null, "Would you like to continue?", "Currency converter", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
            runCheck = runCheckInt == 0 ? true:false;
            } while(runCheck);
    }
}
