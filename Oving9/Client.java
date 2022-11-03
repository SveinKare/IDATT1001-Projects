import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student Per = new Student("Per Jensen");
        Student Bjørn = new Student("Bjørn Jensen");
        Student Kari = new Student("Kari Jensen");
        Oppgaveoversikt oppgOversikt = new Oppgaveoversikt();

        boolean quit = false;
        while(!quit){
            visMeny();
            try{
                int valg = scanner.nextInt();
                switch (valg){
                    case 1:
                    System.out.println("Velg metode");
                        visStudMeny();
                        int valg2 = scanner.nextInt();
                        switch(valg2){
                            case 1:
                                System.out.println(Per.getNavn());
                                System.out.println(Bjørn.getNavn());
                                System.out.println(Kari.getNavn());
                                break;
                            case 2:
                                System.out.println("Per: " + Per.getAntOpp());
                                System.out.println("Bjørn: " + Bjørn.getAntOpp());
                                System.out.println("Kari: " + Kari.getAntOpp());
                                break;
                            case 3:
                                System.out.println("Velg student");
                                System.out.println("1. Per");
                                System.out.println("2. Bjørn");
                                System.out.println("3. Kari");
                                int studValg = scanner.nextInt();
                                System.out.println("Skriv inn øking");
                                int øking = scanner.nextInt();
                                switch(studValg){
                                    case 1:
                                        Per.økAntOpp(øking);
                                        break;
                                    case 2:
                                        Bjørn.økAntOpp(øking);
                                        break;
                                    case 3:
                                        Kari.økAntOpp(øking);
                                        break;
                                }
                                break;
                            case 4:
                                System.out.println(Per.toString());
                                System.out.println(Bjørn.toString());
                                System.out.println(Kari.toString());
                                break;
                            case 5:
                                break;
                        }
                        break;

                    case 2:
                        visOppgMeny();
                        int valg3 = scanner.nextInt();
                        scanner.nextLine();
                        switch(valg3){
                            case 1:
                                System.out.println(oppgOversikt.getAntStud());
                                break;
                            case 2:
                                System.out.println("Skriv inn navnet på studenten");
                                String navn3 = scanner.nextLine();
                                System.out.println(oppgOversikt.antOppg(navn3));
                                break;
                            case 3:
                                System.out.println("Skriv inn et navn til studenten");
                                String navn = scanner.nextLine();
                                oppgOversikt.regStudent(navn);
                                System.out.println("Studenten er registrert.");
                                break;
                            case 4:
                                System.out.println("Skriv inn navnet på studenten");
                                String navn2 = scanner.nextLine();
                                System.out.println("Skriv inn et heltall");
                                int øking = scanner.nextInt();
                                oppgOversikt.økAntOppg(navn2, øking);
                                System.out.println(String.format("%s fikk godkjent %s oppgaver.", navn2, Integer.toString(øking)));
                                break;
                            case 5:
                                System.out.println(oppgOversikt.toString());
                                break;
                        }
                        break;

                    case 3:
                        quit = true;
                        break;
                }
            } catch (IllegalArgumentException e){
                System.out.println(e);
            } catch (Exception e){
                scanner.nextLine();
                System.out.println("Vennligst tast inn en gyldig verdi.");
            }
        }
        scanner.close();
        
    }

    
    static void visMeny(){
        System.out.println("Skriv inn et tall for å velge et alternativ");
        System.out.println("1. Test Student-metoder");
        System.out.println("2. Test Oppgaveoversikt-metoder");
        System.out.println("3. Avslutt");
    }

    static void visStudMeny(){
        System.out.println("1. getNavn");
        System.out.println("2. getAntOpp");
        System.out.println("3. økAntOpp");
        System.out.println("4. To-string");
        System.out.println("5. Tilbake");
    }

    static void visOppgMeny(){
        System.out.println("Velg en metode");
        System.out.println("1. getAntStud");
        System.out.println("2. antOppg");
        System.out.println("3. regStudent");
        System.out.println("4. økAntOppg");
        System.out.println("5. To string");
        System.out.println("6. Tilbake");
    }
}
