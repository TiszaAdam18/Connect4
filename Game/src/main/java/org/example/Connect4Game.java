package org.example;

import java.util.Random;
import java.util.Scanner;

public class Connect4Game {
    private Board board;
    private Player player;
    private Player computer;
    private boolean playerTurn;

    public Connect4Game() {
        board = new Board();
        playerTurn = true;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérem adja meg a nevét: ");
        String playerName = scanner.nextLine();
        player = new Player(playerName, 'X');
        computer = new Player("Gép", 'Y');
        System.out.println("Szia, " + player.getName() + "! Köszöntjük a Connect 4 játékban!");

        board.printBoard();

        while (true) {
            if (playerTurn) {
                System.out.println(player.getName() + " (" + player.getDisc() + "), Válassz egy oszlopot (0-tól 6-ig): ");
                int column = scanner.nextInt();
                if (board.dropDisc(player.getDisc(), column)) {
                    board.printBoard();
                    if (board.checkWin(player.getDisc())) {
                        System.out.println(player.getName() + " Győzelem");
                        break;
                    }
                    playerTurn = false;
                } else {
                    System.out.println("Az oszlop tele van. Próbáld újra");
                }
            } else {
                System.out.println(computer.getName() + " (" + computer.getDisc() + ") Most a gép jön...");
                int column = new Random().nextInt(7);
                if (board.dropDisc(computer.getDisc(), column)) {
                    board.printBoard();
                    if (board.checkWin(computer.getDisc())) {
                        System.out.println(computer.getName() + " Győzelem");
                        break;
                    }
                    playerTurn = true;
                }
            }

            if (board.isBoardFull()) {
                System.out.println("Döntetlen lett.");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Connect4Game game = new Connect4Game();
        game.startGame();
    }
}

