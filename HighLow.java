import java.util.Scanner;

/**
 * Classe principal do jogo HighLow.
 * Responsável por gerir a lógica das rondas, a interação com o utilizador
 * através da consola e o cálculo das pontuações finais.
 */
public class HighLow {

    // Atributos de estado do jogo partilhados entre todos os métodos
    private Deck deck = new Deck();
    private Scanner input = new Scanner(System.in);
    private int totalrounds = 0;
    private int roundpoints = 0;
    private Card cardplay;
    private int totalpoints = 0;
    private double averagepoints = 0;

    /**
     * Inicia o jogo e controla o ciclo principal das rondas
     * enquanto o jogador quiser continuar a jogar e houver cartas no baralho.
     */
    public void startGame() {
        cardplay = deck.dealCard();
        boolean continuegame = true;

        while (continuegame && deck.cardsLeft() > 0) {
            showRoundInfo();
            boolean gotright = lowerHigher();

            if (!gotright) {
                totalpoints += roundpoints;
                totalrounds++;

                continuegame = continueGame();

                if (continuegame) {
                    roundpoints = 0;
                    cardplay = deck.dealCard();
                }

            }
        }
        endGame();
    }

    /**
     * Mostra no ecrã a carta atual em jogo e a quantidade de cartas restantes no baralho.
     */
    public void showRoundInfo() {
        System.out.println("A carta que calhou foi: " + cardplay);
        System.out.println("Cartas restantes no baralho: " + deck.cardsLeft());
    }

    /**
     * Lê o palpite do jogador (A para mais alta, B para mais baixa), retira a próxima carta
     * e compara os valores para determinar se o jogador acertou ou errou.
     * @return true se o jogador acertou a previsão, false se errou ou a carta for igual.
     */
    public boolean lowerHigher() {

        String choice = "";

        System.out.println("Acha que a proxima carta e mais alta (A) ou baixa (B): ");
        choice = input.nextLine().toUpperCase();

        Card nextcard = deck.dealCard();

        if (nextcard == null) {
            return false;
        }

        System.out.println("A carta era: " + nextcard);

        // Avalia o palpite do jogador com base na carta retirada
        switch (choice) {
            case "A":
                if (nextcard.getValue() > cardplay.getValue()) {
                    System.out.println("Acertou");
                    cardplay = nextcard;
                    roundpoints++;
                    return true;
                } else {
                    System.out.println("Errou ou é igual");
                    return false;
                }
            case "B":
                if (nextcard.getValue() < cardplay.getValue()) {
                    System.out.println("Acertou");
                    cardplay = nextcard;
                    roundpoints++;
                    return true;
                } else {
                    System.out.println("Errou ou é igual");
                    return false;
                }
            default:
                System.out.println("Input errado");
                return false;
        }
    }

    /**
     * Pergunta ao jogador se deseja jogar outra ronda e valida o input (S/N).
     * @return true se o jogador responder 'S', false se responder 'N'.
     */
    public boolean continueGame() {

        System.out.println("Deseja continuar a jogar (S/N): ");
        String continueplaying = input.nextLine().toUpperCase();
        while (!continueplaying.equals("S") && !continueplaying.equals("N")) {
            System.out.println("Input errado. Deseja continuar a jogar (S/N): ");
            continueplaying = input.nextLine().toUpperCase();
        }
        if (continueplaying.equals("S")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Termina o jogo, apresenta o total de rondas jogadas e calcula a média de pontos obtida.
     */
    public void endGame() {
        System.out.println("Total de rondas jogadas: " + totalrounds);
        if (totalrounds > 0) {
            averagepoints = (double) totalpoints / totalrounds;
            System.out.println("A sua media de pontos foi: " + averagepoints);
        }
    }
}
