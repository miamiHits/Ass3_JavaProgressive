package FourInArowPCK;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class FourInArow extends JFrame{
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


    public FourInArow() {
        super ("WELCOME 2 four in a row game !!!");

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
        setVisible(true);
        setSize(game.getBOARD_WIDTH(), game.getBOARD_HEIGHT());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleButtonClicked(e.getY());
            }
        });
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleButtonClicked(0);
            }
        } );
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleButtonClicked(1);
            }
        } );
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleButtonClicked(2);
            }
        } );
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleButtonClicked(3);
            }
        } );
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleButtonClicked(4);
            }
        } );
        btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleButtonClicked(5);
            }
        } );
        btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleButtonClicked(6);
            }
        } );
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearGame();
            }
        } );

        while (true) {
            game.setBOARD_WIDTH(getWidth());
            game.setBOARD_HEIGHT(getHeight());
            game.setWidth(game.getBOARD_WIDTH() / (game.getROWS() + 1));
            game.setHeight(game.getBOARD_HEIGHT() / (game.getCOLS() + 1));
            game.repaint();
        }
    }

    private void handleButtonClicked(int i) {
        game.mgX = i;
        game.mgY = 0;
        game.calcCell();
    }

    private void clearGame() {
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        game.clearBoard();

    }


}
