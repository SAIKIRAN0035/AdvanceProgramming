/*
Assignment 10
@Author: Saikiran Reddy Yarava 
Student Name: Saikiran Reddy Yarava
Course Name: Advanced Programming concepts (MCIS-5103)
Section Number: 031
Student Number:999903621
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList; // Import for ArrayList
import java.util.List;  // Import for List


//@Author: Saikiran Reddy Yarava 

public class game {
    private JFrame f;
    private JButton[][] buttons;
    private boolean isPlayerX = true;

    /**
     * Constructor for the Tic-Tac-Toe Game class.
     *
     * @param Player1 The symbol for the starting player ('X' or 'O').
     */

// Constructor for the 'game' class, taking a character 'Player1' as a parameter
    public game(char Player1) {
        // Create a new JFrame for the Tic-Tac-Toe game
        f = new JFrame("Tic-Tac-Toe Game");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());

        // Create a 2D array of JButtons to represent the game board
        buttons = new JButton[3][3];

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(3, 3)); 
        // Loop through the rows and columns to create and configure the buttons
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                 // Set the font for the button text to Arial with a size of 100
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 100));
                 // Add an ActionListener to the button using the ButtonClickListener class
                buttons[i][j].addActionListener(new ButtonClickListener());
                // Added the button to the gamePanel
                gamePanel.add(buttons[i][j]);
            }
        }

        f.add(gamePanel, BorderLayout.CENTER);
// Creating the Help button and add an action listener for the game
        JButton helpButton = new JButton("Help");
        helpButton.addActionListener(new HelpButtonClickListener());
        // Add the "Help" button to the JFrame's south position using BorderLayout
        f.add(helpButton, BorderLayout.SOUTH);
        // Set the size of the JFrame to 600x600 pixels
        f.setSize(600, 600);
        f.setVisible(true);
        // Check if 'Player1' is 'O', and if so, make the first move for the AI
        if (Player1 == 'O') {
            makeAIMove();
        }
    }
/**
     * ActionListener for the Help button.
     * When the "Help" button is clicked, this ActionListener displays a message
    * with game guidelines, author information, and the date.
     */
    private class HelpButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
             // Create a message with game guidelines and author information  
            String helpMessage = "Thank you for visiting Tic-Tac-Toe!\n\n" +
                    "Guidelines:\n" +
                    "- Players mark a square (X for the player, O for the computer) in turn.\n" +
                    "- The winner of the game is the first person to get three of their markers in a row (horizontally, vertically, or diagonally).\n" +
                    "- The game is a draw if the board is full and no player has won.\n\n" +
                    "Author: Saikiran Reddy Yarava\n" +
                    "Date: 11/07/2023\n\n" ;

         // Display the help message in a dialog box with an informational icon

            JOptionPane.showMessageDialog(f, helpMessage, "Tic-Tac-Toe Help", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    /**
     * ActionListener for the game buttons.
     * Handles the player's move when a button is clicked.
     */

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Get the button that was clicked
            JButton clickedButton = (JButton) e.getSource();
            if (clickedButton.getText().equals("") && !checkForWinner()) {
                clickedButton.setText("X");

                  // Check if the player has won
                if (checkForWinner()) {
                    JOptionPane.showMessageDialog(f, "You win the game!");
                    resetGame();
                } else {
                    // If there's no winner yet and the board is not full, make the AI's move
                    if (!isBoardFull()) {
                        makeAIMove();
                        if (checkForWinner()) {
                             // Check if the computer has won
                            JOptionPane.showMessageDialog(f, "Computer wins the game!");
                            resetGame();
                        }
                    } else {
                        // If the board is full and no one has won, it's a draw
                        JOptionPane.showMessageDialog(f, "Game draw no one wins!");
                        resetGame();
                    }
                }
            }
        }
    }
 /**
     * Make a move for the AI player (computer).
     * Uses the minimax algorithm to determine the best move for the AI.
     */
    private void makeAIMove() {
        int[] move = minimax(2, "O");
        // Set the chosen button on the game board to "O" (AI's move)
        buttons[move[0]][move[1]].setText("O");
    }
    /**
     * Perform the minimax algorithm to determine the best AI move.
     *
     * @param depth  The depth of the search.
     * @param player The current player ('X' or 'O').
     * @return An array containing the row, column, and score for the best move.
     */

    private int[] minimax(int depth, String player) {
        int[] bestMove = {-1, -1, (player.equals("O")) ? Integer.MIN_VALUE : Integer.MAX_VALUE};
         // If the depth is 0 or there's a winner, evaluate the board state and return the result
        if (depth == 0 || checkForWinner()) {
            bestMove[2] = evaluateBoard();
            return bestMove;
        }
        // Loop through the game board to find the best move
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals("")) {
                    buttons[i][j].setText(player);
                    int[] currentMove = minimax(depth - 1, (player.equals("O")) ? "X" : "O");
                    buttons[i][j].setText("");
                    // Update the best move if a better move is found
                    if ((player.equals("O") && currentMove[2] > bestMove[2]) ||
                            (player.equals("X") && currentMove[2] < bestMove[2])) {
                        bestMove[0] = i;
                        bestMove[1] = j;
                        bestMove[2] = currentMove[2];
                    }
                }
            }
        }
        return bestMove;
    }
    /**
     * Evaluate the current state of the game board and return a score.
     *
     * @return The score for the current board state.
     */

    private int evaluateBoard() {
        // Score the board by evaluating rows, columns, and diagonals
        int score = 0;
        for (int i = 0; i < 3; i++) {
            score += evaluateLine(buttons[i][0].getText(), buttons[i][1].getText(), buttons[i][2].getText());
        }
        for (int i = 0; i < 3; i++) {
            score += evaluateLine(buttons[0][i].getText(), buttons[1][i].getText(), buttons[2][i].getText());
        }
        score += evaluateLine(buttons[0][0].getText(), buttons[1][1].getText(), buttons[2][2].getText());
        score += evaluateLine(buttons[0][2].getText(), buttons[1][1].getText(), buttons[2][0].getText());
        return score;
    }
/**
     * Evaluate a line (row, column, or diagonal) on the game board and return a score.
     *
     * @param cell1 The content of the first cell.
     * @param cell2 The content of the second cell.
     * @param cell3 The content of the third cell.
     * @return The score for the line.
     */
    private int evaluateLine(String cell1, String cell2, String cell3) {
        int score = 0;
        if (cell1.equals(cell2) && cell1.equals("") && !cell3.equals("")) score = 1;
        if (cell1.equals(cell3) && cell1.equals("") && !cell2.equals("")) score = 1;
        if (cell2.equals(cell3) && cell2.equals("") && !cell1.equals("")) score = 1;
        if (cell1.equals(cell2) && cell1.equals("O") && cell3.equals("")) score = 10;
        if (cell1.equals(cell3) && cell1.equals("O") && cell2.equals("")) score = 10;
        if (cell2.equals(cell3) && cell2.equals("O") && cell1.equals("")) score = 10;
        if (cell1.equals(cell2) && cell1.equals("X") && cell3.equals("")) score = -10;
        if (cell1.equals(cell3) && cell1.equals("X") && cell2.equals("")) score = -10;
        if (cell2.equals(cell3) && cell2.equals("X") && cell1.equals("")) score = -10;
        return score;
    }
    /**
     * * Check if there is a winner in the game by examining rows, columns, and diagonals.
     *
     * @return True if there is a winner, false otherwise.
     */

    private boolean checkForWinner() {
        // Check for winning conditions in rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(buttons[i][1].getText()) &&
                    buttons[i][1].getText().equals(buttons[i][2].getText()) &&
                    !buttons[i][0].getText().equals("")) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
             // Check each column for a winning sequence
            if (buttons[0][i].getText().equals(buttons[1][i].getText()) &&
                    buttons[1][i].getText().equals(buttons[2][i].getText()) &&
                    !buttons[0][i].getText().equals("")) {
                return true;
            }
        }
        // Check the main diagonal for a winning sequence
        if (buttons[0][0].getText().equals(buttons[1][1].getText()) &&
                buttons[1][1].getText().equals(buttons[2][2].getText()) &&
                !buttons[0][0].getText().equals("")) {
            return true;
        }
        // Check the other diagonal for a winning sequence
        if (buttons[0][2].getText().equals(buttons[1][1].getText()) &&
                buttons[1][1].getText().equals(buttons[2][0].getText()) &&
                !buttons[0][2].getText().equals("")) {
            return true;
        }
        return false;
    }
    /**
     * Check if the game board is full.
     *
     * @return True if the board is full, false otherwise.
     */

    private boolean isBoardFull() {
         // Check if all cells are occupied
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Reset the game board to its initial state.
     */

    private void resetGame() {
        // Clear all the cells on the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        isPlayerX = true;
    }

    public static void main(String[] args) {
        // Ask the user who starts the game and create a new game instance
        String[] options = {"User wants to start the game(X)", "Computer wants to start the game(O)"};
        int choice = JOptionPane.showOptionDialog(null, "Who wants to start game first?", "Tic-Tac-Toe Game",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        char Player1 = (choice == 0) ? 'X' : 'O';
        new game(Player1);
       
        // Instantiate a new class and call its method
        Gamer gamer = new Gamer();
        gamer.doSomething();
    }
}

//@Author: Saikiran Reddy Yarava 
/**
 * A simple class that displays a message .
 */
class Gamer {
    public void doSomething() {
        System.out.println("Game will be in another tab please move to that tab.");
  }
}

