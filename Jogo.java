import java.util.Random;

public class Jogo {
    public static void main(String[] args) throws Exception {
        final String itens [] = {"Javali selvagem", "amora", "batata frita", "onça", "bola de ouro"};
        var gerador = new Random();
        var p1 = new Personagem("Cristiano Ronaldo", 10, 9, 0);
        var p2 = new Personagem("Messi", 10, 10, 5);
        int oQueFazer;
        int qualItem;
        for (int i = 0; i<4; i++) {
            p1.adicionarItem(itens[gerador.nextInt(5)]);
        }
        
        while(!p1.morreu() && !p2.morreu()){
            oQueFazer = gerador.nextInt(2);
            switch(oQueFazer){
                case 0:
                    p1.comer();
                    p2.dormir();
                    break;
                case 1:
                    p1.cacar();
                    p2.comer();
                    break;
                default:
                    p1.dormir();
                    p2.cacar();
                    break;
            }
            System.out.println(p1);
            System.out.println(p2);
            System.out.printf("\n");
            Thread.sleep(3000);
        }

        if(p1.morreu()){
            System.out.println(p1.nome + " morreu...");
        }   
        else{
            System.out.println(p2.nome + " morreu...");
        }
    }
}
