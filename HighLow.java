import java.util.Scanner;

public class HighLow {

    public void startGame() {
        int points = 0;
        double averagepoints = 0;
        int totalPoints = 0;
        int max = Integer.MAX_VALUE;
        Deck deck = new Deck();
        Card cardplay = deck.dealCard();

        Scanner input = new Scanner(System.in);

        for (int rounds = 1; rounds < max;) {

            System.out.println("A carta que calhou foi: " + cardplay);
            System.out.println("Cartas restantes no baralho: " + deck.cardsLeft());

            String choice = "";

            while (!choice.equals("A") && !choice.equals("B")) {
                
                System.out.println("Acha que a proxima carta e mais alta (A) ou baixa (B): ");
                choice = input.nextLine().toUpperCase();

                if (!choice.equals("A") && !choice.equals("B")) {
                    System.out.println("Input errado");
                }

            }

            Card nextcard = deck.dealCard();

            if (nextcard == null) {
                System.out.println("O baralho de cartas acabou!");
                totalPoints += points;
                averagepoints = (double) totalPoints / rounds;
                System.out.println("Total de rondas jogadas: " + rounds);
                System.out.println("A sua media de pontos foi: " + averagepoints);
                return;
            }

            System.out.println("A carta que calhou foi: " + nextcard);

            switch (choice) {
                case "A":
                    if (nextcard.getValue() > cardplay.getValue()) {
                        System.out.println("Acertou");
                        points++;
                        cardplay = nextcard;
                        break;
                    } else {
                        System.out.println("Errou");
                        System.out.println("Acabou com: " + points + "pontos");
                        boolean respostaValida = false;
                        while (!respostaValida) {
                            System.out.println("Deseja continuar a jogar (S/N): ");
                            String continueplaying = input.nextLine().toUpperCase();

                            switch (continueplaying) {
                                case "S":
                                    totalPoints += points;
                                    points = 0;
                                    rounds++;
                                    cardplay = deck.dealCard();
                                    respostaValida = true;
                                    break;
                                case "N":
                                    totalPoints += points;
                                    averagepoints = (double) totalPoints / rounds;
                                    System.out.println("A sua media de pontos foi: " + averagepoints);
                                    System.out.println("Total de rondas jogadas: " + rounds);
                                    return;
                                default:
                                    System.out.println("Input errado");
                                    break;
                            }
                        }
                        break;
                    }
                case "B":
                    if (nextcard.getValue() < cardplay.getValue()) {
                        System.out.println("Acertou");
                        points++;
                        cardplay = nextcard;
                        break;
                    } else {
                        System.out.println("Errou");
                        System.out.println("Acabou com: " + points);
                        boolean respostaValida = false;
                        while (!respostaValida) {
                            System.out.println("Deseja continuar a jogar (S/N): ");
                            String continueplaying = input.nextLine().toUpperCase();
                            switch (continueplaying) {
                                case "S":
                                    totalPoints += points;
                                    points = 0;
                                    rounds++;
                                    cardplay = deck.dealCard();
                                    respostaValida = true;
                                    break;
                                case "N":
                                    totalPoints += points;
                                    averagepoints = (double) totalPoints / rounds;
                                    System.out.println("A sua media de pontos foi: " + averagepoints);
                                    System.out.println("Total de rondas jogadas: " + rounds);
                                    return;
                                default:
                                    System.out.println("Input errado");
                                    break;
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Input errado");
                    break;
            }
        }
    }
}
