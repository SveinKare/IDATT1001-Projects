public class MinRandom{
    //Lager et Random objekt
    private java.util.Random randomObjekt = new java.util.Random();

    //Metode for tilfeldig heltall i et intervall
    public int nesteHeltall(int nedre, int ovre){
        int nInt = randomObjekt.nextInt(ovre - nedre);
        return nInt += nedre;
    }

    //Metode for tilfeldig desimaltall i et intervall
    public double nesteDesimaltall(double nedre, double ovre){
        double nDouble01 = randomObjekt.nextDouble();
        nDouble01 *= (ovre-nedre);
        return nDouble01 += nedre;
    }
    public static void main(String[] args){
        MinRandom test = new MinRandom();
        //Test for desimaltall funksjon
        for (int i = 0; i < 10000; i++){
            double tall = test.nesteDesimaltall(8.34, 56.74);
            if(tall < 8.34 || tall > 56.74){
                System.out.println("Out of bounds.");
                break;
            } else{
                System.out.println(tall);
            }
        }
        //Test for heltallfunksjon
        for (int i = 0; i < 10000; i++){
            int tall = test.nesteHeltall(43, 75);
            if(tall < 43 || tall > 75){
                System.out.println("Out of bounds.");
                break;
            } else{
                System.out.println(tall);
            }
        }
    }   



}