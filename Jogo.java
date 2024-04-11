import java.util.Random;

public class Jogo {
    public static void main(String[] args) throws Exception {
        var gerador = new Random();
        var p1 = new Personagem("Cristiano Ronaldo", 10, 9, 0);
        var p2 = new Personagem("Messi", 10, 10, 5);
        int oQueFazer;
        
        while(true){

            oQueFazer = gerador.nextInt(2);
            switch(oQueFazer){
                case 0:
                    p1.comer();
                    p2.dormir();
                    break;
                case 1:
                    p1.cacar();
                    p2.comer();
                default:
                    p1.dormir();
                    p2.cacar();
                    break;
            }
            System.out.printf("\n");
            Thread.sleep(3000);
        }
    }
}
