
class TerningClient{
    public static void main(String[] args){
        //Lager objekt for hver spiller
        Spiller spillerA = new Spiller();
        Spiller spillerB = new Spiller();

        int round = 0;
        //Løkken kjører så lenge ingen av spillerene har 100 poeng eller mer
        while(!spillerA.erFerdig() && !spillerB.erFerdig()){
            //Plusser på runde
            round += 1;

            //Printer rundenummer
            System.out.println("Runde: " + round);

            //Kaster terning for hver spiller
            spillerA.kastTerning();
            spillerB.kastTerning();
            
            //Printer poengsummer
            System.out.println("Spiller A: " + spillerA.getSumPoeng());
            System.out.println("Spiller B: " + spillerB.getSumPoeng());
            
            //Sjekker om noen har vunnet, eventuelt om det er uavgjort, og printer resultatet
            if (spillerA.erFerdig() && spillerB.erFerdig()){
                //Begger er ferdige
                System.out.println("Uavgjort");
            } else if(spillerA.erFerdig()){
                //Spiller A er ferdig, men ikke B
                System.out.println("Spiller A har vunnet.");
            } else if(spillerB.erFerdig()){
                //Spiller B er ferdig, men ikke A
                System.out.println("Spiller B har vunnet.");
            }
        }
    }
}