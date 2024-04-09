
//This is the game called Tic Tac Toe and this is the code of this game.

package tictactoe;

import java.util.Scanner;
import java.util.InputMismatchException;

// This class contains the main program for the Tic-Tac-Toe game.
public class Main_program {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TTT_model game = new TTT_model(); // Create an instance of the Tic-Tac-Toe game model

        System.out.println("Tic-Tac-Toe!");
        System.out.println("Current board layout:");
        game.printPanel(); // Display the initial game board

        // The game loop where players take turns until there is a winner or a draw
        while (true) {
            System.out.println("Player " + game.getChance() + ", enter row and column (1-3) to place your mark:");

            int row, col;
            try {
                // Get player input for row and column
                row = in.nextInt();
                col = in.nextInt();
            } catch (InputMismatchException e) {
                // Handle non-numeric input
                System.out.println("Invalid input. Please enter numbers.");
                in.nextLine(); // Consume the invalid input
                continue;      // Continue to the next iteration of the loop
            }

            // Check if the input values are within the valid range
            if (row < 1 || row > 3 || col < 1 || col > 3) {
                System.out.println("Invalid input. Row and column must be between 1 and 3.");
                continue; // Continue to the next iteration of the loop
            }

            // Attempt to make a move on the game board
            if (!game.makeMove(row, col)) {
                System.out.println("Invalid move. The slot is already taken or out of range.");
                continue; // Continue to the next iteration of the loop
            }

            System.out.println("Current board layout:");
            game.printPanel(); // Display the updated game board

            // Check if there is a winner or if the game is a draw
            String result = game.chooseChampion();
            if (result != null) {
                if (result.equalsIgnoreCase("draw")) {
                    System.out.println("It's a draw! Thanks for playing.");
                } else {
                    System.out.println(result + " wins!");
                }
                break; // Exit the game loop
            }
        }

        in.close(); // Close the Scanner
    }
}
