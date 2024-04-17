import java.util.Random;

public class Jogo {
    public static void main(String[] args) throws Exception {
        var gerador = new Random();
        var p1 = new Personagem("Cristiano Ronaldo", 10, 9, 0);
        var p2 = new Personagem("Lionel Messi", 8, 5, 5);
        int oQueFazer;
        String campeao = new String();
        
        while(!p1.morreu() || !p2.morreu()){
            oQueFazer = gerador.nextInt(2);
            if(!p1.morreu() && !p2.morreu()){
                if(oQueFazer == 0)
                    p1.atacar(p2);
                else
                    p2.atacar(p1);
            }

            if(!p1.morreu()){
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
            }
            
            if(!p2.morreu()){
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
            }
            
            if (campeao.isEmpty()){
                if(p2.morreu() && !p1.morreu()){
                    campeao = p1.nome;
                    System.out.println("\n" + p2.nome + " morreu... " + campeao + " se tornou o campeao!\n");
                }
                if(p1.morreu() && !p2.morreu()){
                    campeao = p2.nome;
                    System.out.println("\n" + p1.nome + " morreu... " + campeao + " se tornou o campeao!\n");
                }
                if(p1.morreu() && p2.morreu()){
                    System.out.println("...Ocorreu um empate????");
                }
                
            }

            System.out.printf("\n\n-----------------------------\n\n");
            Thread.sleep(2000);
        }
        if(!campeao.isEmpty())
            System.out.printf("O campeao, %s, morreu.\n\nFim de jogo.",campeao);
    }
}
