import java.util.Random;

public class Jogo {
    public static void main(String[] args) throws Exception {
        var gerador = new Random();
        var p1 = new Personagem("Cristiano Ronaldo", 10, 9, 0);
        int oQueFazer;
        
        while(!p1.morreu()){
            oQueFazer = gerador.nextInt(3);
            switch(oQueFazer){
                case 0:
                    p1.comer();
                    break;
                case 1:
                    p1.cacar();
                    break;
                default:
                    p1.dormir();
                    break;
            }
            System.out.println(p1);
            System.out.printf("\n");
            Thread.sleep(1000);
        }

        if(p1.morreu()){
            System.out.println(p1.nome + " morreu...");
        }   
    }
}
