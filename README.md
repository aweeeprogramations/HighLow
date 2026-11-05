# Projeto HighLow - Programação Orientada a Objetos

## Sobre o Jogo
Este projeto foi desenvolvido para a disciplina de POO. Trata-se de um jogo simples de cartas chamado **HighLow**, onde o objetivo do jogador é adivinhar se a próxima carta retirada do baralho tem um valor mais alto (A) ou mais baixo (B) do que a carta que está atualmente na mesa.

## Como o Código foi Implementado
O projeto está dividido em classes com responsabilidades bem separadas:

* **Card.java**: Representa uma carta individual. Guarda o valor numérico (de 2 a 14, onde o 14 é o Ás) e o naipe (Copas, Espadas, Ouros, Paus). O método `toString()` foi alterado para mostrar no ecrã os nomes das cartas especiais (Valete, Rainha, Rei e Ás).
* **Deck.java**: Representa o baralho de 52 cartas. Trata de criar todas as cartas no início, baralhá-las aleatoriamente através do método `shuffle()` e retirar cartas uma a uma com o `dealCard()`.
* **HighLow.java**: É a classe que controla o jogo. Tem métodos separados para mostrar o estado da mesa, ler os palpites do jogador, avaliar se acertou ou errou, e controlar as rondas. No final, calcula e apresenta o total de rondas jogadas e a pontuação média obtida.
* **Main.java**: É apenas o ponto de entrada do programa, criando o objeto do jogo e chamando o método `startGame()`.

## Como Correr
Basta abrir o projeto no VS Code e executar o ficheiro `Main.java` clicando em **Run**.

---
**Trabalho realizado por:**
* Diogo Almeida - a22506107
* Gabriel Marques - a22600719
* Afonso Cabral - a22506076
* Grupo: 2

## Repositório GitHub
O código e o histórico de commits deste projeto podem ser consultados em:
https://github.com/aweeeprogramations/HighLow
