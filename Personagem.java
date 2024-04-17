import java.util.Random;

public class Personagem {
    // variáveis de instância(objeto)
    String nome;
    int energia;
    private int fome;
    private int sono;
    final String itensPossiveis [] = {"Javali selvagem", "amora", "batata frita", "onça", "bola de ouro"};
    VetorDinamico itens = new VetorDinamico();

    // esse é o construtor padrão
    // criado automaticamente pelo compilador, ainda que não seja escrito
    // explicitamente
    Personagem() {
        nome = null;
        energia = 10;
        fome = 0;
        sono = 0;

        for(int i = 0; i < 4; i++){
            adicionarItem();
        }
    }

    // construtor personalizado
    // o que viabiliza a sua existência é a sobrecarga de construtores
    Personagem(String nome, int energia, int fome, int sono) {
        this.nome = nome;
        if (energia >= 0 && energia <= 10)
            this.energia = energia;
        if (fome >= 0 && fome <= 10)
            this.fome = fome;
        if (sono >= 0 && sono <= 10)
            this.sono = sono;

        for(int i = 0; i < 4; i++){
            adicionarItem();
        }
    }

    void adicionarItem() {
        var gerador = new Random();
        itens.adicionar(itensPossiveis[gerador.nextInt(5)]);
    }

    void cacar() {
        if (energia >= 2) {
            System.out.printf("%s esta cacando...\n", nome);
            energia -= 2; // energia = energia - 2;
            adicionarItem();
        } else {
            System.out.printf("%s esta sem energia para cacar...\n", nome);
        }
        fome = Math.min(fome + 1, 10);
        // resolver com o ternário
        sono = sono < 10 ? sono + 1 : sono;
    }

    void comer() {
        // se tiver fome
        // comer e reduzir o valor de fome de 1
        // aumentar o valor de energia de 1
        // caso contrario
        // so vai avisar que esta sem fome
        switch (fome) {
            case 0:
                System.out.printf("%s esta sem fome....\n", nome);
                break;
            default:
                if(itens.estaVazio()){
                    System.out.printf("%s não pode comer, pois não possui itens\n", nome);
                }
                else{
                    System.out.printf("%s esta comendo...\n", nome);
                    --fome;
                    energia = (energia == 10 ? energia : energia + 1);
                    itens.removerNoFinal();
                }    
        }
    }

    void dormir() {
        if (sono >= 1) {
            System.out.printf("%s esta dormindo...\n", nome);
            sono -= 1;
            energia = Math.min(energia + 1, 10);
        } else {
            System.out.printf("%s esta sem sono...\n", nome);
        }
    }

    Boolean morreu(){
        if(energia<=0)return true;
        return false;
    }

    public String toString() {
        var sb = new StringBuilder("");
        sb.append(nome);
        sb.append(": (e:").append(energia);
        sb.append(", f:").append(fome);
        sb.append(", s:").append(sono).append(")");
        sb.append("\nItens: ");
        for(String item : itens.getElementos()){
            sb.append("|").append(item).append("|");
        }
        return sb.toString();
        // return String.format(
        //         "%s: (e:%d, f:%d, s:%d)",
        //         nome, energia, fome, sono);
    }
}