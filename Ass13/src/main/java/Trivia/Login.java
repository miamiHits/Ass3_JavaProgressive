package Trivia;

import Trivia.welcome;
import Trivie.question2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Login extends JFrame
{

	private JPanel contentPane;
	private JTextField textField;
	protected Component frame;
    public static String username;
    public static int i=0;

	/**
	 * Create the frame.
	 */
	public Login() 
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterUsername = new JLabel("Enter Username");
		lblEnterUsername.setBackground(new Color(211, 211, 211));
		lblEnterUsername.setForeground(new Color(139, 0, 0));
		lblEnterUsername.setFont(new Font("Mongolian Baiti", Font.BOLD | Font.ITALIC, 18));
		lblEnterUsername.setBounds(213, 155, 140, 41);
		//contentPane.add(lblEnterUsername);
		add(lblEnterUsername, BorderLayout.PAGE_START);

		textField = new JTextField();
		textField.setBounds(169, 207, 230, 27);
		add(textField, BorderLayout.CENTER);
		//contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnRules = new JButton("Go back to game rules");
		btnRules.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRules.setForeground(new Color(139, 0, 0));
		btnRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
				welcome w=new welcome();             //welcome page ie. Rules page
				w.setVisible(true);
				
			}
		});
		btnRules.setBounds(158, 277, 200, 23);
		add(btnRules, BorderLayout.PAGE_END);
		//contentPane.add(btnRules);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPlay.setForeground(new Color(139, 0, 0));
		btnPlay.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(textField.getText()!=null && !textField.getText().trim().isEmpty())         //Checks if username is not blank
				{
					username=textField.getText();
					dispose();
					QuestionBankParser bankParser = new QuestionBankParser();
					List<TriviaQuestion> questionsList =  bankParser.parseQuestionBankFile();
					Questionnaire questionnaire = new Questionnaire(questionsList);
					QuestionFrame questionframe = new QuestionFrame(questionnaire);

					
				}
				else
				{
					JOptionPane.showMessageDialog(frame,"Username cannot blank");
				}
			}
		});
		btnPlay.setBounds(310, 277, 89, 23);
		//contentPane.add(btnPlay);
		add(btnPlay, BorderLayout.PAGE_END);

		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnExit.setForeground(new Color(139, 0, 0));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			      System.exit(0);
			}
		});
		btnExit.setBounds(231, 326, 89, 23);
		add(btnExit, BorderLayout.PAGE_END);
		//contentPane.add(btnExit);

	}
			
}
