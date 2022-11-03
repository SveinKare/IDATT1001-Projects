/**
 * Klassen lager et register over studenter, og holder styr på hvor mange oppgaver de forskjellige studentene har fått godkjent
 * TODO: 
 * Trenger ikke javadoc for konstruktør. 
 * Enkelt testprogram og klientprogram skal være forskjellige filer. 
 * Javadoc til klassen skal beskrive hva klassen gjør
 * Klientprogram må være mer beskrivende
 */
public class Oppgaveoversikt {
    private Student[] studenter;
    private int antStud;
    /**
     * Konstruktør. Lager tomt array først, og lager nye senere for å øke lengden
     */
    public Oppgaveoversikt(){
        studenter = new Student[0];
        antStud = 0;
    }

    /**
     * Get-metode for antall studenter
     * @return antStud (int)
     */
    public int getAntStud(){
        return antStud;
    }

    /**
     * Returnerer antall oppgaver som en student har fått godkjent. Kaster {@link IllegalArgumentException} dersom et ugyldig navn blir oppgitt
     * @param navn (String) Navnet på studenten
     * @return antOppg (int) til en viss student
     */
    public int antOppg(String navn){
        for (Student student:studenter){
            if(student.getNavn().equalsIgnoreCase(navn)){
                return student.getAntOpp();
            }
        }
        throw new IllegalArgumentException("Navnet er ikke i listen");
    }
    /**
     * Utvider array'et "studenter" og fører inn en ny student i listen. Kaster IllegalArgumentException dersom studenten allerede er i registeret
     * @param navn (String) Navnet på studenten
     */
    public void regStudent(String navn){
        for (Student student:studenter){
            if(student.getNavn().equalsIgnoreCase(navn)){
                throw new IllegalArgumentException("Den studenten er allerede registrert.");
            }
        }
        
        
        Student[] temp = new Student[studenter.length+1];
        for (int i = 0; i < studenter.length; i++){
            temp[i] = studenter[i];
        }
        studenter = new Student[studenter.length+1];
        for (int i = 0; i < temp.length; i++){
            studenter[i] = temp[i];
        }

        studenter[studenter.length-1] = new Student(navn);
        antStud += 1;
    }

    /**
     * Øker antall godkjente oppgaver for en viss student
     * @param navn (String) Navnet på studenten
     * @param øking (int) Antallet oppgaver som skal legges til
     */
    public void økAntOppg(String navn, int øking){
        for (Student student:studenter){
            if(student.getNavn().equalsIgnoreCase(navn)){
                student.økAntOpp(øking);
                return;
            }
        }
        throw new IllegalArgumentException("Navnet er ikke i listen");
    }

    /**
     * To-string metode
     * @return (String) Antall studenter øverst, med navn og antall oppgaver for hver student på hver sin linje
     */
    @Override
    public String toString(){
        String temp = "Antall studenter: " + antStud + "\n";
        for (Student student:studenter){
            temp += student.toString();
            temp += "\n";
        }
        return temp;
    }
}
