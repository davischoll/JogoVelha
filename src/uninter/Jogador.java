package uninter;

import java.util.ArrayList;
import java.util.Scanner;

public class Jogador {

    private String[] jogadores = {"HUMANO", "COMPUTADOR"};

    private int[][] sequenciasValidas = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9},  // Linhas do tabuleiro
								         {1, 4, 7}, {2, 5, 8}, {3, 6, 9},	 // Colunas
								         {1, 5, 9}, {3, 5, 7}};			 // Diagonais

    public void jogar(Tabuleiro tabuleiro) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe uma posição vazia no tabuleiro (1-9): ");
        String str = scanner.next();

        int pos = tabuleiro.validaJogada(str);	// valida a posição da jogada
        pos--;

        int posicao = (int) tabuleiro.getPosicaoTab().get(pos); // verifica se posição está preenchida

        if(posicao == 0)
            tabuleiro.setPosicaoTab(pos, 1);   // seta a escolha, caso a posição não esteja marcada
        else {           
            System.out.println("\nJogada inválida!");
            this.jogar(tabuleiro);
        }
    }

    /*
     *  Método que verifica se houve um ganhador e retorna o número de quem ganhou:
     *  1: Jogador Humano; 2: Computador; 3: Empate.
     */
    public int validaGanhador(Tabuleiro tabuleiro) {
        ArrayList<Integer> posicoesMarcadas = tabuleiro.getPosicaoTab();

        for (int[] sequenciaValida : this.sequenciasValidas) {
            int countA = 0, countB = 0;

            for(int posicao : sequenciaValida) {                
                if(posicoesMarcadas.get(posicao-1) == 1)
                	countA++;

                if(posicoesMarcadas.get(posicao-1) == 2)
                	countB++;
            }

            if(countA == 3) {
                System.out.println("Ganhador: " + this.getJogador(1) + "!");
                return 1;
            }

            if(countB == 3) {
                System.out.println("Ganhador: " + this.getJogador(2) + "!");
                return 2;
            }
        }

        if(tabuleiro.empatou())
            return 3;

        return 0;
    }

    public String[] getJogadores() {
        return this.jogadores;
    }

    public String getJogador(int jogador) {
        return this.jogadores[jogador-1];
    }
}
