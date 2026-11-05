/**
 * Representa uma carta de jogar com um valor numérico e um naipe.
 */
public class Card {

    // Atributos privados: o valor numérico da carta e o respetivo naipe
    private int value;
    private String suit;

    /**
     * Cria uma nova carta com o valor e naipe especificados.
     * 
     * @param value valor numérico da carta (2 a 14)
     * @param suit  naipe da carta (Copas, Espadas, Ouros, Paus)
     */
    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    /**
     * Devolve o valor numérico da carta.
     * 
     * @return o valor da carta.
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Devolve o naipe da carta.
     * 
     * @return o naipe da carta em formato de texto.
     */
    public String getSuit() {
        return this.suit;
    }

    /**
     * Devolve a representação textual legível da carta,
     * convertendo os valores de 11 a 14 nas respetivas figuras (Valete, Rainha,
     * Rei, Ás).
     * 
     * @return descrição da carta com o seu nome e naipe.
     */
    @Override
    public String toString() {
        String specialname;

        switch (this.value) {
            case 11:
                specialname = "Valete (11)";
                break;
            case 12:
                specialname = "Rainha (12)";
                break;
            case 13:
                specialname = "Rei (13)";
                break;
            case 14:
                specialname = "Ás (14)";
                break;
            default:
                specialname = String.valueOf(this.value);
                break;
        }

        return specialname + " de " + this.suit;
    }
}