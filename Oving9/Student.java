/**
 * Klassen brukes av Oppgaveoversikt-klassen for å føre inn nye studenter i registeret
 */
public class Student{
    private String navn;
    private int antOppg = 0;
    /**
     * Konstruktør
     * @param navn (String) Navnet på studenten
     */
    public Student(String navn){
        this.navn = navn;
    }

    /**
     * Get-metode for navn
     * @return navnet på studenten (String)
     */
    public String getNavn(){
        return navn;
    }

    /**
     * Get-metode for antall oppgaver
     * @return antOppg (int)
     */
    public int getAntOpp(){
        return antOppg;
    }

    /**
     * Øker antOppg med oppgitt parameter
     * @param øking (int) 
     */
    public void økAntOpp(int øking){
        antOppg += øking;
    }

    /**
     * Representerer objektet som en String
     * @return Navn og antall oppgaver godkjent (String)
     */
    @Override
    public String toString(){
        return "Navn: " + navn + ", Antall oppgaver godkjent: " + Integer.toString(antOppg);
    }
}