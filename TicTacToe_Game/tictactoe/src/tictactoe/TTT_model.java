
//This is the game called Tic Tac Toe and this is the code of this game.

package tictactoe;



// This class represents the Tic-Tac-Toe game model.
public class TTT_model {
    private String[] panel; // The game board
    private String chance;   // Current player's chance ("X" or "O")

    // Constructor initializes the game board and sets the initial chance to "X".
    public TTT_model() {
        panel = new String[9];
        initializePanel();  // Set up the board
        chance = "X";       // Initialize chance
    }

    // Initializes the game board with underscores.
    private void initializePanel() {
        for (int k = 0; k < 9; k++) {
            panel[k] = "_";
        }
    }

    // Getter method to retrieve the current player's chance.
    public String getChance() {
        return chance;
    }

    // Getter method to retrieve the game board.
    public String[] getPanel() {
        return panel;
    }

    // Method to print the current state of the game board.
    public void printPanel() {
        System.out.println("-------------");
        System.out.println("| " + panel[0] + " | " + panel[1] + " | " + panel[2] + " |");
        System.out.println("-------------");
        System.out.println("| " + panel[3] + " | " + panel[4] + " | " + panel[5] + " |");
        System.out.println("-------------");
        System.out.println("| " + panel[6] + " | " + panel[7] + " | " + panel[8] + " |");
        System.out.println("-------------");
    }

    // Method to check if there is a winner or a draw.
    public String chooseChampion() {
        for (int k = 0; k < 8; k++) {
            String rule = "";
            // Check each rule for a possible winner
            switch (k) {
                case 0:
                    rule = panel[0] + panel[1] + panel[2];
                    break;
                case 1:
                    rule = panel[3] + panel[4] + panel[5];
                    break;
                case 2:
                    rule = panel[6] + panel[7] + panel[8];
                    break;
                case 3:
                    rule = panel[0] + panel[3] + panel[6];
                    break;
                case 4:
                    rule = panel[1] + panel[4] + panel[7];
                    break;
                case 5:
                    rule = panel[2] + panel[5] + panel[8];
                    break;
                case 6:
                    rule = panel[0] + panel[4] + panel[8];
                    break;
                case 7:
                    rule = panel[2] + panel[4] + panel[6];
                    break;
            }
            // Check for X winner
            if (rule.equals("XXX")) {
                return "X";
            }
            // Check for O winner
            else if (rule.equals("OOO")) {
                return "O";
            }
        }

        // Check for a draw
        boolean isDraw = true;
        for (int i = 0; i < 9; i++) {
            if (!panel[i].equals("X") && !panel[i].equals("O")) {
                isDraw = false;
                break;
            }
        }

        if (isDraw) {
            return "draw";
        }

        return null; // No winner or draw yet
    }

    // Method to make a move on the game board.
    public boolean makeMove(int row, int col) {
        int num1 = 3 * (row - 1) + (col - 1);
        // Check if the move is valid
        if (!(num1 >= 0 && num1 < 9) || !panel[num1].equals("_")) {
            return false; // Invalid move
        }

        panel[num1] = chance; // Place the player's mark on the board

        // Switch to the other player's chance
        if (chance.equals("X")) {
            chance = "O";
        } else {
            chance = "X";
        }

        return true; // Valid move
    }
}
