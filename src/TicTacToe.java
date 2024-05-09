//Imported Packages that is used on Game.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {
    int boardheight = 600;
    int boardwidth = 650;
    //Mehak Commit (place)
    JFrame frame = new JFrame("Tic Tac Toe");

    TicTacToe(){
        frame.setVisible(true);
        frame.setSize(boardwidth,boardheight);
        frame.setLocationRelativeTo(null); // Opening location on Center of Screen
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// For Exiting Program when you click on X on the top right
        frame.setLayout(new BorderLayout());

   
    }
}
