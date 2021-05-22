package uninter;

/*
 * Jogadas do Computador em sequência ordenada crescente.
 * Vai percorrer o tabuleiro do início ao fim e jogar na
 * primeira posição que encontrar vazia.
 */
public class ComputadorA extends Computador {

    @Override
    public void jogar(Tabuleiro tabuleiro) {
        for (int i = 0; i < tabuleiro.getPosicaoTab().size(); i++) {
            if(tabuleiro.getPosicaoTab().get(i) == 0) {
                tabuleiro.setPosicaoTab(i, 2);
                break;
            }
        }

        super.jogar(tabuleiro);
    }
}
