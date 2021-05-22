package uninter;

/*
 * Jogadas do Computador em sequência ordenada decrescente.
 * Vai percorrer o tabuleiro do fim ao início e jogar na
 * primeira posição que encontrar vazia.
 */
public class ComputadorC extends Computador {

    @Override
    public void jogar(Tabuleiro tabuleiro) {
    	for (int i = (tabuleiro.getPosicaoTab().size() - 1); i > 0; i--) {
            if(tabuleiro.getPosicaoTab().get(i) == 0) {
                tabuleiro.setPosicaoTab(i, 2);
                break;
            }
        }

        super.jogar(tabuleiro);
    }
}
