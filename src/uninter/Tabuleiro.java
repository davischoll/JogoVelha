package uninter;

import java.util.ArrayList;
import java.util.Scanner;

public class Tabuleiro {  // Inicia atributos e cria métodos da Classe Tabuleiro

    private String[][] tabuleiro = { 
        { "[ ]", " ", "[ ]", " ", "[ ]" },
        { "   ", " ", "   ", " ", "   " },
        { "[ ]", " ", "[ ]", " ", "[ ]" },
        { "   ", " ", "   ", " ", "   " },
        { "[ ]", " ", "[ ]", " ", "[ ]" } 
    };

    private int status = 0;
    private ArrayList<Integer> posicaoTab;

    public Tabuleiro() {	// Método Construtor da Classe
        this.posicaoTab = new ArrayList<>();

        for (int i = 0; i < 9; i++) {	// Inicializa arrays
            this.posicaoTab.add(0);
        }
    }

    public void setTab(String value, int li, int co) {	// Preenche tabuleiro
        this.tabuleiro[li][co] = value;
    }

    public void visualizar() {		// Método que exibe tabuleiro na tela
        for (String[] row : this.tabuleiro) {

            for (String column : row) {
                System.out.print(column);
            }

            System.out.println();
        }

        System.out.println();
    }   

    public int validaJogada(String str) {  // Método que verifica se a posição jogada é válida

        while (!str.matches("[1-9]")) {
            System.out.println("\nJogada inválida!");
            @SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
            System.out.print("Informe uma posição vazia no tabuleiro (1-9): ");
            str = scan.next();

            return this.validaJogada(str);
        }

        return Integer.parseInt(str);
    }

    public void setStatus(int jogador) {  // Define status do jogo
        this.status = jogador;
    }

    public int getStatus() {	// Obtêm o status atual do jogo
        return this.status;
    }

    public ArrayList<Integer> getPosicaoTab() {
        return posicaoTab;
    }

    public void setPosicaoTab(int posicao, int item) {
        this.posicaoTab.set(posicao, item);
        this.atualizarTabuleiro(posicao, item);
    }

    // Método que marca o símbolo de cada jogador no tabuleiro:
    private void atualizarTabuleiro(int posicao, int item) {
        String marcador = "[O]";  // Computador

        if(item == 1)
            marcador = "[X]";	  // Jogador Humano

        switch(posicao) {
            case 0: this.setTab(marcador, 0, 0); break;
            case 1: this.setTab(marcador, 0, 2); break;
            case 2: this.setTab(marcador, 0, 4); break;
            case 3: this.setTab(marcador, 2, 0); break;
            case 4: this.setTab(marcador, 2, 2); break;
            case 5: this.setTab(marcador, 2, 4); break;
            case 6: this.setTab(marcador, 4, 0); break;
            case 7: this.setTab(marcador, 4, 2); break;
            case 8: this.setTab(marcador, 4, 4); break;
        }
    }

    // Método que verifica se houve empate. Retorna true caso todas as posições sejam preenchidas
    public boolean empatou() {
        int count = 0;

        count = this.getPosicaoTab().stream()
					                .filter((item) -> (item != 0))
					                .map((_item) -> 1)
					                .reduce(count, Integer::sum);

        return (count == 9);
    }
}
