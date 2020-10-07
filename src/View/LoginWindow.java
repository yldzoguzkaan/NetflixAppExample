package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.UserController;
import Model.User;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class LoginWindow {

	private JFrame frame;
	private JTextField txt_email;
	private JTextField txt_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
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
	public LoginWindow() {
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
		
		JLabel lblNetflxLognPage = new JLabel("NETFLIX LOGIN PAGE");
		lblNetflxLognPage.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNetflxLognPage.setBounds(235, 150, 281, 63);
		frame.getContentPane().add(lblNetflxLognPage);
		
		txt_email = new JTextField();
		txt_email.setBounds(273, 246, 203, 20);
		frame.getContentPane().add(txt_email);
		txt_email.setColumns(10);
		
		JLabel lblEmalAdress = new JLabel("EMAIL ADRESS:");
		lblEmalAdress.setBounds(273, 224, 203, 14);
		frame.getContentPane().add(lblEmalAdress);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setBounds(273, 277, 203, 14);
		frame.getContentPane().add(lblPassword);
		
		txt_password = new JTextField();
		txt_password.setBounds(273, 302, 203, 20);
		frame.getContentPane().add(txt_password);
		txt_password.setColumns(10);
		
		JButton btnLogn = new JButton("LOGIN");
		btnLogn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t_email = txt_email.getText();
				String t_password = txt_password.getText();
				
				UserController uc = new UserController();
				User usr = uc.GetUser(t_email, t_password);
				
				if(usr.getId() == 0) {
					JOptionPane.showMessageDialog(frame,"User is not found! Please create an account!");
				}else {
					JOptionPane.showMessageDialog(frame,usr.toString());
					HomePageWindow hp = new HomePageWindow();
					hp.frame.setVisible(true);
					frame.dispose();
				}
			}
		});
		btnLogn.setBounds(273, 333, 203, 23);
		frame.getContentPane().add(btnLogn);
		
		JButton btnCreate = new JButton("CREATE ACCOUNT");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateAccountStep1Window caso = new CreateAccountStep1Window();
				caso.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnCreate.setBounds(273, 392, 201, 23);
		frame.getContentPane().add(btnCreate);
		
		JLabel lblOr = new JLabel("OR");
		lblOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOr.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblOr.setBounds(273, 367, 203, 14);
		frame.getContentPane().add(lblOr);
	}
}
