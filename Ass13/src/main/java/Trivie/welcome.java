package Trivie;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class welcome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the mk de.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					welcome frame = new welcome();
					frame.setVisible(true);
				} catch (Exception e) {
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public welcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome to Yarden Trivia!!!");
		lblWelcome.setFont(new Font("Jokerman", Font.PLAIN, 18));
		lblWelcome.setBounds(168, 23, 242, 28);
		contentPane.add(lblWelcome);
		
		String msg="This game is very easy to play.You'll be asked some general knowledge questions";
		
		JLabel lblNewLabel_1 = new JLabel("WelcomeViewlbl");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_1.setBounds(10, 93, 476, 14);
		lblNewLabel_1.setText(msg);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("WelcomeViewlbl");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_2.setBounds(10, 118, 414, 14);
		msg="Please choose one answer out of 4 questions ";
		lblNewLabel_2.setText(msg);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("WelcomeViewlbl");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setBounds(10, 153, 440, 14);
		msg="Correct answer will give you 10pts. Incorrect answer will reduce you 5pts";
		lblNewLabel_3.setText(msg);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_10 = new JLabel("WelcomeViewlbl1");
		lblNewLabel_10.setForeground(new Color(255, 0, 0));
		lblNewLabel_10.setFont(new Font("Rockwell Condensed", Font.PLAIN, 18));
		lblNewLabel_10.setBounds(226, 350, 223, 28);
		msg="\t\tBEST OF LUCK!!!";
		lblNewLabel_10.setText(msg);
		contentPane.add(lblNewLabel_10);
		
		JButton btnStart = new JButton("Start Trivia Game !");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
				Login l=new Login();
				l.setVisible(true);
			}
		});
		btnStart.setBounds(10, 405, 300, 23);
		contentPane.add(btnStart);

	}

}
