/**
 * Representa um baralho completo de 52 cartas de jogar.
 * O baralho pode ser baralhado e as cartas podem ser retiradas uma a uma.
 */

public class Deck {

    // Atributos do baralho: o conjunto de 52 cartas e o contador de cartas
    // retiradas
    private Card[] cards;
    private int cardsUsed;

    /**
     * Construtor que cria um novo baralho com 52 cartas e baralha-o de seguida.
     */
    public Deck() {
        this.cards = new Card[52];
        this.cardsUsed = 0;
        createDeck();
        shuffle();
    }

    /**
     * Cria e preenche as 52 cartas do baralho distribuídas pelos 4 naipes
     * (Copas, Espadas, Ouros e Paus), com valores de 2 a 14 (Ás).
     */
    private void createDeck() {

        int value = 2;
        for (int index = 0; index < 52; index++) {
            if (index < 13) {
                this.cards[index] = new Card(value, "Copas");
            } else if (index >= 13 && index < 26) {
                this.cards[index] = new Card(value, "Espadas");

            } else if (index >= 26 && index < 39) {
                this.cards[index] = new Card(value, "Ouros");

            } else if (index >= 39) {
                this.cards[index] = new Card(value, "Paus");
            }

            if (value == 14) {
                value = 2;
            } else {
                value++;
            }
        }
    }

    /**
     * Baralha o baralho aleatoriamente e reinicia o contador de cartas usadas.
     */
    public void shuffle() {
        this.cardsUsed = 0;
        Card temp;
        // Algoritmo de troca: troca cada carta com outra numa posição aleatória
        for (int index = 0; index < 52; index++) {
            int posicaoAleatoria = (int) (Math.random() * 52);
            temp = this.cards[index];
            this.cards[index] = this.cards[posicaoAleatoria];
            this.cards[posicaoAleatoria] = temp;
        }
    }

    /**
     * Retira e devolve a próxima carta do baralho.
     * 
     * @return a próxima carta, ou null se já não restarem cartas no baralho.
     */
    public Card dealCard() {
        if (cardsLeft() == 0) {
            return null;
        }

        Card carta = this.cards[this.cardsUsed];

        this.cardsUsed++;
        return carta;
    }

    /**
     * Devolve o número de cartas que ainda restam no baralho.
     * 
     * @return quantidade de cartas restantes.
     */
    public int cardsLeft() {
        return 52 - this.cardsUsed;
    }
}