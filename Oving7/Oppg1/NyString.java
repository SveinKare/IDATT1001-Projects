package Oppg1;
final public class NyString{

    private final String tekst;
    //Konstruktør
    NyString(String inn){
        //Initialiserer objektet tekst med parameteren til konstruktøren
        tekst = new String(inn);
    }

    //Forkorter teksten til en string med første bokstav av hvert ord
    String forkort(){
        //Deler teksten i et array med ord
        String[] ordListe = tekst.split(" ");
        //Lager et array med samme lengde som antall ord
        char[] bokstaver = new char[ordListe.length];
        //Lager for-løkke for hvert ord i array'et
        for (int i = 0; i < ordListe.length; i++){
            //Tar bokstaven i første indeks for hvert ord, og legger i "bokstaver" array'et
            bokstaver[i] = ordListe[i].charAt(0);
        }
        //Lager string objekt av bokstaver array'et og returnerer
        String tempString = new String(bokstaver);
        return tempString;
    }

    String fjernTegn(char bokstav){
        char[] tempArray = tekst.toCharArray();
        char[] returnArray = new char[tempArray.length];
        for(int i = 0; i < tempArray.length; i++){
            if(tempArray[i] != bokstav){
                returnArray[i] = tempArray[i];
            }
        }
        String tempString = new String(returnArray);
        return tempString;
    }
    public static void main(String[] args) {
        String hei = new String("Hei Hade juli kanskej");
        NyString objekt = new NyString(hei);
        System.out.println(objekt.forkort());
        System.out.println(objekt.fjernTegn('j'));
    }
}