package Oppg2;

public class Main {
    public static void main(String[] args) {
        TekstBehandling objekt = new TekstBehandling("Dette er en eksempeltekst. Æg skriver for å gjøre øvinger! Det er gøy å kode? Denne teksten tester funksjoner: tror jeg, ha det.");
        System.out.println(objekt.antallOrd());
        System.out.println(objekt.gOrdLengde());
        System.out.println(objekt.ordPerPeriode());
        System.out.println(objekt.erstatt("er", "var"));
        System.out.println(objekt.getTekst());
        System.out.println(objekt.getSTekst());
    }
}
