//Imported Packages that is used on Game.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {
    int boardheight = 600;
    int boardwidth = 650;
    //Mehak Commit (place)
    JFrame frame = new JFrame("Tic Tac Toe");
    JLabel textlabel = new JLabel();
    JPanel textpanel = new JPanel();
    JPanel boardpanel = new JPanel();

    JButton board[][] = new JButton[3][3];

    String playerX="X";
    String playerO="O";
    String currentPlayer= playerO;
    boolean gameOver = false;

    int turns = 0;

    TicTacToe(){
        frame.setVisible(true);
        frame.setSize(boardwidth,boardheight);
        frame.setLocationRelativeTo(null); // Opening location on Center of Screen
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// For Exiting Program when you click on X on the top right
        frame.setLayout(new BorderLayout());

        textlabel.setBackground(Color.black);
        textlabel.setForeground(Color.WHITE);
        textlabel.setFont(new Font("Arial",Font.BOLD,50));
        textlabel.setHorizontalAlignment(JLabel.CENTER); // Set our text on center instead of left
        textlabel.setText("Tic-Tac-Toe");
        textlabel.setOpaque(true);

   
    }
}
