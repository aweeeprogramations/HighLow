public class Deck {

    private Card[] cards;
    private int cardsUsed;

    public Deck() {
        this.cards = new Card[52];
        this.cardsUsed = 0;
        createDeck();
        shuffle();
    }

    private void createDeck() {

        int value = 2;
        for(int index = 0; index < 52 ; index++)
        {
            if(index < 13)
            {
                this.cards[index] = new Card(value, "Copas");
            }
            else if(index >= 13 && index < 26 )
            { 
                this.cards[index] = new Card(value, "Espadas");

            }
            else if(index >= 26 && index < 39)
            { 
                this.cards[index] = new Card(value, "Ouros");                

            }
            else if(index >= 39)
            { 
                this.cards[index] = new Card(value, "Paus");              
            }

            if(value == 14)
            {
                value = 2;
            }
            else
            {
                value++;
            }
        }           
    }

    public void shuffle() {
        this.cardsUsed = 0;
        Card temp;
        for(int index = 0; index < 52 ; index++)
        {
            int posicaoAleatoria = (int) (Math.random() * 52);
            temp = this.cards[index];
            this.cards[index] = this.cards[posicaoAleatoria];
            this.cards[posicaoAleatoria] = temp;
        }
    }

    public Card dealCard() {
        if (cardsLeft() == 0) {
        return null;
        }

        Card carta = this.cards[this.cardsUsed];
    
        this.cardsUsed++;
        return carta;
    }

    public int cardsLeft() {
        return 52 - this.cardsUsed;
    }
}