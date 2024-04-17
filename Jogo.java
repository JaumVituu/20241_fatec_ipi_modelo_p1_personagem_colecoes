import java.util.Random;

public class Jogo {
    public static void main(String[] args) throws Exception {
        var gerador = new Random();
        var p1 = new Personagem("Cristiano Ronaldo", 10, 9, 0);
        var p2 = new Personagem("Lionel Messi", 8, 5, 5);
        int oQueFazer;
        String campeao = new String();
        
        while(!p1.morreu() || !p2.morreu()){
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

            oQueFazer = gerador.nextInt(3);
            switch(oQueFazer){
                case 0:
                    p2.comer();
                    break;
                case 1:
                    p2.cacar();
                    break;
                default:
                    p2.dormir();
                    break;
            }
            System.out.println(p2);
            System.out.printf("\n\n-----------------------------\n\n");

            if(campeao == null){
                if(p1.morreu()){
                    System.out.println(p1.nome + " morreu...");
                    campeao = p2.nome;
                    
                }
                if(p2.morreu()){
                    System.out.println(p2.nome + " morreu...");
                    campeao = p1.nome;
                }
                if(p1.morreu() || p2.morreu()){
                    System.out.println(campeao + " foi o campeão!");
                }   
            }

            Thread.sleep(500);
        }
    }
}
