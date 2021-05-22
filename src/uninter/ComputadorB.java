package uninter;

import java.util.Random;

/*
 * Jogadas do Computador em sequência aleatória
 */
public class ComputadorB extends Computador {

    @Override
    public void jogar(Tabuleiro tabuleiro) {
        Random random = new Random();	// Usa a classe Random para sortear
        int pos = random.nextInt(9);	// um número aleatório até 9.

        int posicao = (int) tabuleiro.getPosicaoTab().get(pos);

        if(posicao == 0)
            tabuleiro.setPosicaoTab(pos, 2); // Seta a posição sorteada, caso não esteja marcada
        else
            this.jogar(tabuleiro);  // Se inválida, tenta outra jogada sorteando um novo número

        super.jogar(tabuleiro);
    }
}
