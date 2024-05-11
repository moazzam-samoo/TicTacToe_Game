//Imported Packages that is used on Game.

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class TicTacToe {
    int boardheight = 600;
    int boardwidth = 650;
    JFrame frame = new JFrame("Tic Tac Toe");
    JLabel textlabel = new JLabel();
    JPanel textpanel = new JPanel();
    JPanel boardpanel = new JPanel();

    JButton[][] board = new JButton[3][3];

    String playerX = "X";
    String playerO = "O";
    String currentPlayer = playerO;
    boolean gameOver = false;

    int turns = 0;

    TicTacToe() {
        frame.setVisible(true);
        frame.setSize(boardwidth, boardheight);
        frame.setLocationRelativeTo(null); // Opening location on Center of Screen
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// For Exiting Program when you click on X on the top right
        frame.setLayout(new BorderLayout());

        textlabel.setBackground(Color.black);
        textlabel.setForeground(Color.WHITE);
        textlabel.setFont(new Font("Arial", Font.BOLD, 50));
        textlabel.setHorizontalAlignment(JLabel.CENTER); // Set our text on center instead of left
        textlabel.setText("Tic-Tac-Toe");
        textlabel.setOpaque(true);

        textpanel.setLayout(new BorderLayout());
        textpanel.add(textlabel);
        frame.add(textpanel, BorderLayout.NORTH);

        boardpanel.setLayout(new GridLayout(3, 3)); // Creates 3 By 3 Layout
        boardpanel.setBackground(Color.black);
        frame.add(boardpanel);


        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                JButton tile = new JButton();
                board[r][c] = tile;
                boardpanel.add(tile);

                // Color inside the Boxes
                tile.setBackground(Color.BLACK);
                tile.setForeground(Color.WHITE);
                tile.setFont(new Font("Arial", Font.BOLD, 120));
                tile.setFocusable(false);

                // Clicking the Tile sets text of Current Player so either  ( X or O )
                tile.addActionListener(e -> {
                    JButton tile1 =(JButton) e.getSource();
                    if (gameOver) return;

                    // Makes it so You can't overwrie on a tile
                    if (Objects.equals(tile1.getText(), "")) {

                        tile1.setText(currentPlayer);

                        turns++;
          checkWinner();

                        // Shows who's turn is it
                        if (!gameOver) {
                            currentPlayer = Objects.equals(currentPlayer, playerO) ? playerX : playerO;
                            textlabel.setText(currentPlayer+ "'s turn.");
                        }


                    }


                });

            }
        }

    }
        
        void checkWinner () {
            // Horizontal
         for (int r = 0; r < 3; r++) {
                if (Objects.equals(board[r][0].getText(), "")) continue;

                if (Objects.equals(board[r][0].getText(), board[r][1].getText()) &&
                        Objects.equals(board[r][1].getText(), board[r][2].getText())) {

                    for(int i = 0; i < 3 ; i++){
                        setWinner(board[r][i]);
                    }

                   gameOver = true;
                    return;

                }
            }


            //Vertical
        for (int c = 0; c < 3; c++) {
            if (Objects.equals(board[0][c].getText(), "")) continue;
        
            if (Objects.equals(board[0][c].getText(), board[1][c].getText()) &&
                    Objects.equals(board[1][c].getText(), board[2][c].getText())) {
                for (int i = 0; i < 3; i++) {
                    setWinner(board[i][c]);
                }
                gameOver = true;
                return;
            }
        }
            // Diagonally
            if (Objects.equals(board[0][0].getText(), board[1][1].getText()) &&
                    Objects.equals(board[1][1].getText(), board[2][2].getText()) &&
                    !Objects.equals(board[0][0].getText(), "")) {
                for (int i = 0; i < 3; i++) {
                    setWinner(board[i][i]);
                }
                gameOver = true;
                return;
            }
   
            // Anti Diagonally
   if (Objects.equals(board[0][2].getText(), board[1][1].getText()) &&
           Objects.equals(board[1][1].getText(), board[2][0].getText()) &&
           !Objects.equals(board[0][2].getText(), "")) {
   setWinner(board[0][2]);
   setWinner(board[1][1]);
   setWinner(board[2][0]);
   gameOver = true;
   return;
            }
            if (turns==9) {
                for(int r = 0; r < 3 ; r++){
                    for(int c = 0; c < 3; c++){
                        setTie(board[r][c]);
                    }
                }

                gameOver = true;
            }
        }


      void setWinner(JButton tile){
          tile.setForeground(Color.green);
          tile.setBackground(Color.DARK_GRAY);
         textlabel.setText(currentPlayer + " is the Winner!");
        } 


    void setTie(JButton tile){
        tile.setBackground(Color.RED);
        tile.setForeground(Color.DARK_GRAY);
        textlabel.setText("Tie");

    }
    }