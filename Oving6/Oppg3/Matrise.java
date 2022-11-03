package Oppg3;

final class Matrise{
    private final int[][] matrise;
    Matrise(int[][] matriseInn){
        //Sjekker at matrisen har gyldig format (altså at alle linjene har like mange søyler)
        boolean valid = true;
        for(int i = 0; i < matriseInn.length; i++){
            if(!(matriseInn[0].length == matriseInn[i].length)){
                valid = false;
            }
        }
        //Initialiserer matrisen med linjer og søyler tilsvarende parameterene dersom formatet er gyldig
        if(valid){
            this.matrise = new int[matriseInn.length][matriseInn[0].length];
            //Kopierer element for element for å gjøre matrisen immutable. 
            for(int i = 0; i < matrise.length; i++){
                for(int i2 = 0; i2 < matrise[0].length; i2++){
                    matrise[i][i2] = matriseInn[i][i2];
                }
            }
        }
        //Kaster exception dersom formatet er ugyldig
        else{
            throw new IllegalArgumentException("Array has incorrect format to convert to matrix.");
        }
    }

    //Metode for å addere en matrise
    public int[][] addMatrise(Matrise inputMatrise){
        int[][] matrise2 = inputMatrise.matrise;
        //Metoden tar et objekt av klassen Matrise som parameter. Sjekker om antall linjer og søyler er likt
        if(matrise.length == matrise2.length && matrise[0].length == matrise2[0].length){
            //Lager nytt array
            int[][] tempMatrise = new int[matrise.length][matrise[0].length];
            //Legger sammen element for element
            for(int i = 0; i < matrise.length; i++){
                for(int i2 = 0; i2 < matrise[0].length; i2++){
                    tempMatrise[i][i2] = matrise[i][i2] + matrise2[i][i2];
                }
            }
            return tempMatrise;
        } else{
            return null;
        }
    }

    //Metode for å multiplisere matrisen med en annen
    public int[][] multMatrise(Matrise inputOb){
        int[][] matrise2 = inputOb.matrise;
        //Sjekker om antall søyler i matrise er lik antall linjer i matrise2
        if(matrise[0].length == matrise2.length){
            //Resulterende matrise har antall linjer lik matrise og antall søyler lik matrise2
            int[][] tempMatrise = new int[matrise.length][matrise2[0].length];
            //For-løkke for hver linje
            for(int i = 0; i < tempMatrise.length; i++){
                //For-løkke for hver søyle
                for(int i2 = 0; i2 < tempMatrise[0].length; i2++){
                    int element = 0;
                    //For-løkke for å regne elementene.
                    for(int i3 = 0; i3 < matrise[0].length; i3++){
                        element += matrise[i][i3] * matrise2[i3][i2];
                    }
                    //Elementet blir lagt i tilhørende indeks i tempMatrise
                    tempMatrise[i][i2] = element;
                }
            }
            return tempMatrise;
        }else{
            return null;
        }
    }

    //Metode for å transponere matrisen
    public int[][] tpMatrise(){
        int[][] tempMatrise = new int[matrise[0].length][matrise.length];
        for(int i = 0; i < tempMatrise.length; i++){
            for(int i2 = 0; i2 < tempMatrise[0].length; i2++){
                tempMatrise[i][i2] = matrise[i2][i];
            }
        }
        return tempMatrise;
    }



    //Get-metode som returnerer kopi av matrisen
    public int[][] getMatrise(){
        //Lager nytt array med samme dimensjoner
        int[][] tempMatrise = new int[matrise.length][matrise[0].length];
        //Kopierer linje for linje
        for(int i = 0; i < matrise.length; i++){
            for (int i2 = 0; i2 < tempMatrise[0].length; i2++){
                tempMatrise[i][i2] = matrise[i][i2];
            }
        }
        return tempMatrise;
    }
}

