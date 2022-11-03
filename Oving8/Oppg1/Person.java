package Oppg1;

public final class Person{
    private final String fornavn;
    private final String etternavn;
    private final int fødselsår;
    
    /**
     * Konstruktør for Person-klassen
     * @param fornavn
     * @param etternavn
     * @param fødselsår
     */
    Person(String fornavn, String etternavn, int fødselsår){
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.fødselsår = fødselsår;
    }

    /**
     * Get-metode for fornavn
     * @return fornavn
     */
    public String getFornavn(){
        return fornavn;
    }

    /**
     * Get-metode for etternavn
     * @return etternavn
     */
    public String getEtternavn(){
        return etternavn;
    }

    /**
     * Get-metode for fødselsår
     * @return fødselsår
     */
    public int getFødselsår(){
        return fødselsår;
    }
}