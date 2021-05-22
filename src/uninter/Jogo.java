package uninter;

import java.util.Scanner;

public class Jogo {   // Criação da classe principal main, que inicializa o programa

    public static void main(String[] params) {	// Instanciação dos objetos
        Tabuleiro tabuleiro = new Tabuleiro();
        Jogador jogador = new Jogador();
        Computador computador = new Computador();

    String opNivel = "0";	// Criação da variável que recebe a opção do Nível do jogo

        do {
        	Scanner teclado = new Scanner(System.in);
            System.out.println("JOGO DA VELHA");
            System.out.println("#############");
            System.out.println("Escolha o nível de dificuldade do jogo (A | B | C):");

            opNivel = teclado.next().toUpperCase();

            switch(opNivel) {	// Seleção de qual Computador será chamado para jogar
            	case "A": computador = new ComputadorA(); break;
                case "B": computador = new ComputadorB(); break;
                case "C": computador = new ComputadorC(); break;
                default:
                    System.out.println("Opção inválida\n");
                    opNivel = "0";
            }

        } while (opNivel == "0");

        System.out.println("--------------");
        tabuleiro.visualizar();

       	int vez = 1;  // Inicia jogo com o Jogador Humano

        while(tabuleiro.getStatus() == 0) {

            if(vez == 1) {  //Jogador Humano
                System.out.println("Jogador HUMANO, faça sua jogada:");
                jogador.jogar(tabuleiro);
                vez = 2;	// Passa a vez da jogada para o Computador
            }
            else if(vez == 2) {
                computador.jogar(tabuleiro);
                vez = 1;
            }

            tabuleiro.visualizar();
            tabuleiro.setStatus(jogador.validaGanhador(tabuleiro));
            System.out.println("--------------");
        }

        if(tabuleiro.getStatus() == 3)
            System.out.println("EMPATOU!");
    }
}
