package Oppg1;

public class ArbTaker {
    //Attributter
    private final Person personalia;
    private final int arbtakernr;
    private final int ansettelsesår;
    private double månedslønn;
    private double skatteprosent;
    private java.util.GregorianCalendar kalender = new java.util.GregorianCalendar();

    /**
     * Konstruktør for klassen
     * @param personalia
     * @param arbtakernr
     * @param ansettelsesår
     * @param månedslønn
     * @param skatteprosent
     */
    public ArbTaker(Person personalia, int arbtakernr, int ansettelsesår, double månedslønn, double skatteprosent){
        this.personalia = personalia;
        this.arbtakernr = arbtakernr;
        this.ansettelsesår = ansettelsesår;
        this.månedslønn = månedslønn;
        this.skatteprosent = skatteprosent;
    }


    /**
     * Get-metode for arbtakernr
     * @return arbtakernr
     */
    public int getArbtakernr(){
        return arbtakernr;
    }

    /**
     * Get-metode for ansettelsesår
     * @return ansettelsesår
     */
    public int getAnsettelsesår(){
        return ansettelsesår;
    }

    /**
     * Get-metode for månedslønn
     * @return månedslønn
     */
    public double getMånedslønn(){
        return månedslønn;
    }

    /**
     * Get-metode for skatteprosent
     * @return skatteprosent
     */
    public double getSkatteprosent(){
        return skatteprosent;
    }

    /**
     * Get-metode for personalia objektet
     * @return personalia
     */
    public Person getPersonalia(){
        return personalia;
    }

    /**
     * Set-metode for månedslønn
     * @param månedslønn
     */
    public void setMånedslønn(double månedslønn){
        this.månedslønn = månedslønn;
    }

    /**
     * Set-metode for skatteprosent
     * @param skatteprosent
     */
    public void setSkatteprosent(double skatteprosent){
        this.skatteprosent = skatteprosent;
    }

    /**
     * Regner skatt per måned. Deler skatteprosent med 100 og ganger med månedslønn. Ganger og deler med 100 for å runde av til 2 desimaler
     * @return Skatt per måned
     */
    public double skattPrMnd(){
        return Math.round(((skatteprosent/100)*månedslønn)*100)/100;
    }

    /**
     * Regner årslønn ut fra månedslønn. Ganger månedslønn med 12.
     * @return årslønn
     */
    public double årslønn(){
        return månedslønn*12;
    }

    /**
     * Regner ut totalt skattetrekk per. Bruker skattPrMnd metoden for å regne skatt per måned, og ganger med 10.5 pga ingen skatt i juni og halv skatt i desember.
     * @return skattetrekk per år
     */
    public double skattPrÅr(){
        return 10.5*skattPrMnd();
    }

    /**
     * Bruker get-metoder fra Person-klassen for å lage en String på formen "etternavn, fornavn"
     * @return navnet på formen "etternavn, fornavn"
     */
    public String navn(){
        return String.format("%s, %s", personalia.getEtternavn(), personalia.getFornavn());
    }

    /**
     * Regner ut alder ved å trekke fødselsår fra nåværende år
     * @return Returnerer alder
     */
    public int alder(){
        return kalender.get(java.util.GregorianCalendar.YEAR) - personalia.getFødselsår();
    }

    /**
     * Regner ut ansiennitet ved å trekke ansettelsesår fra nåværende år
     * @return Antall år ansatt i bedriften
     */
    public int ansiennitet(){
        return kalender.get(java.util.GregorianCalendar.YEAR) - ansettelsesår;
    }

    /**
     * Sjekker om personen har vært ansatt lenger enn antall år gitt som parameter. Bruker ansiennitet for å sjekke
     * @param år
     * @return True dersom ansiennitet er høyere enn "år", false dersom den er lavere.
     */
    public boolean lengerEnn(int år){
        return ansiennitet() > år;
    }
}
