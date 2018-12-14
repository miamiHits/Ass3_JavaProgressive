package FourInArowPCK;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//Creating class FourInArowPCK.FourInArow which extends JPanel which is what the game will run on.
//Implements MouseMotionListener for mouse movements, MouseListener for mouse clicks, and Runnable to run the game. 
public class FourInArow extends JFrame{
    // Creating object JFrame to create the window for the game application.
    // Creating object Thread for the speed at which the token shows up.


    public static void main(String[] args) {
        // Creating new Connect4 object.
        new FourInArow();


    }

    public FourInArow() {
        super ("WELCOME 2 four in a row game !!!");
        JButton clearButton = new JButton("Clear");
        JButton btn1 = new JButton("1");
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JButton btn6 = new JButton("6");
        JButton btn7 = new JButton("7");
        JPanel buttonsPanel = new JPanel();
        GamePanel game = new GamePanel();
        setTitle("WELCOME 2 four in a row game !!!");
        setVisible(true);
        setSize(game.fWidth, game.fHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonsPanel.add(btn1);
        buttonsPanel.add(btn2);
        buttonsPanel.add(btn3);
        buttonsPanel.add(btn4);
        buttonsPanel.add(btn5);
        buttonsPanel.add(btn6);
        buttonsPanel.add(btn7);
        buttonsPanel.add(clearButton);
        add(buttonsPanel, BorderLayout.PAGE_END);
        add(game, BorderLayout.CENTER);

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearGame();
            }
        } );

        while (true) {
            game.fWidth = getWidth();
            game.fHeight = getHeight();
            game.width = game.fWidth / (game.nW + 1);
            game.height = game.fHeight / (game.nH + 1);
            game.repaint();
        }
    }

    private void clearGame() {

    }


}
