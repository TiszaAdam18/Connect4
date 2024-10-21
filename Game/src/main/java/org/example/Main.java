package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add meg a neved: ");
        String playerName = scanner.nextLine();
        Player human = new Player(playerName, 'X');
        Player computer = new Player("Gép következik.. ", 'Y');
        Board board = new Board(6, 7);

        System.out.println("Üdvözlünk, " + playerName + "! Kezdjük a játékot. Válassz egy sort a korongod lecsúsztatásához.");

        Player currentPlayer = human;
        while (true) {
            board.display();
            System.out.println(currentPlayer.getName() + " lépése:");
            int column;
            if (currentPlayer == human) {
                column = scanner.nextInt();
            } else {
                Random rand = new Random();
                column = rand.nextInt(7);
            }
            Move move = new Move(0, column);  // A sor indexet majd frissítjük a Board osztályban
            if (!board.makeMove(move, currentPlayer.getSymbol())) {
                System.out.println("Érvénytelen lépés, próbáld újra!");
                continue;
            }
            if (board.checkWin(currentPlayer.getSymbol())) {
                board.display();
                System.out.println(currentPlayer.getName() + " nyert!");
                break;
            }
            currentPlayer = currentPlayer == human ? computer : human;
        }
    }
}
