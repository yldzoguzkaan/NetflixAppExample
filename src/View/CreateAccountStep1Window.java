package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Controller.UserController;
import Model.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateAccountStep1Window {

	public JFrame frame;
	private JTextField txt_username;
	private JTextField txt_email;
	private JTextField txt_password;
	private JTextField txt_date;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccountStep1Window window = new CreateAccountStep1Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreateAccountStep1Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCreateAnAccount = new JLabel("USER INFORMATION WINDOW");
		lblCreateAnAccount.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblCreateAnAccount.setBounds(180, 33, 401, 53);
		frame.getContentPane().add(lblCreateAnAccount);
		
		JLabel lblUsername = new JLabel("USERNAME:");
		lblUsername.setBounds(268, 106, 150, 14);
		frame.getContentPane().add(lblUsername);
		
		txt_username = new JTextField();
		txt_username.setBounds(268, 120, 150, 20);
		frame.getContentPane().add(txt_username);
		txt_username.setColumns(10);
		
		JLabel lblEmail = new JLabel("EMA\u0130L:");
		lblEmail.setBounds(268, 151, 150, 14);
		frame.getContentPane().add(lblEmail);
		
		txt_email = new JTextField();
		txt_email.setBounds(268, 164, 150, 20);
		frame.getContentPane().add(txt_email);
		txt_email.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setBounds(268, 195, 150, 14);
		frame.getContentPane().add(lblPassword);
		
		txt_password = new JTextField();
		txt_password.setBounds(268, 208, 150, 20);
		frame.getContentPane().add(txt_password);
		txt_password.setColumns(10);
		
		JLabel lblBrthOfDate = new JLabel("DATE OF BIRTH:");
		lblBrthOfDate.setBounds(268, 239, 150, 14);
		frame.getContentPane().add(lblBrthOfDate);
		
		txt_date = new JTextField();
		txt_date.setBounds(268, 252, 150, 20);
		frame.getContentPane().add(txt_date);
		txt_date.setColumns(10);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User usr = new User();
				usr.setUsername(txt_username.getText());
				usr.setEmail(txt_email.getText());
				usr.setPassword(txt_password.getText());
				usr.setDate(txt_date.getText());
				UserController uc = new UserController();
				Boolean ret = uc.CreateUser(usr);
				if(ret == false) {
					JOptionPane.showMessageDialog(frame,"Error during user registration!");
				}else {
					JOptionPane.showMessageDialog(frame,"Registration successful!");
					CreateAccountStep2Window c22 = new CreateAccountStep2Window();
					c22.frame.setVisible(true);
					frame.dispose();
				}
			}
		});
		btnNext.setBounds(353, 283, 65, 23);
		frame.getContentPane().add(btnNext);
		
		JButton btnPrev = new JButton("PREV");
		btnPrev.setBounds(268, 283, 65, 23);
		frame.getContentPane().add(btnPrev);
	}
}
