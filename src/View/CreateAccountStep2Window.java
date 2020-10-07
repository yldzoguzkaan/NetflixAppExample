package View;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class CreateAccountStep2Window {

	public JFrame frame;
	public static List<Integer> chooseKinds = new ArrayList<Integer>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccountStep2Window c22 = new CreateAccountStep2Window();
					c22.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreateAccountStep2Window() {
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
		
		JLabel lblNewLabel = new JLabel("KIND SELECTION W\u0130NDOW");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(116, 29, 390, 75);
		frame.getContentPane().add(lblNewLabel);
		
		
		JLabel lblChose = new JLabel("Your Choices:");
		lblChose.setBounds(79, 99, 70, 14);
		frame.getContentPane().add(lblChose);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(151, 99, 287, 107);
		frame.getContentPane().add(textPane);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateAccountStep3Window c33 = new CreateAccountStep3Window();
				c33.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNext.setBounds(339, 406, 70, 23);
		frame.getContentPane().add(btnNext);
		
		JButton btnPrev = new JButton("PREV");
		btnPrev.setBounds(192, 406, 70, 23);
		frame.getContentPane().add(btnPrev);
		
		JButton btnThriller = new JButton("Thriller");
		btnThriller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText(textPane.getText() + btnThriller.getText() + "\n");
				chooseKinds.add(1);
			}
		});
		btnThriller.setBounds(151, 229, 89, 23);
		frame.getContentPane().add(btnThriller);
		
		JButton btnComedy = new JButton("Comedy");
		btnComedy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText(textPane.getText() + btnComedy.getText() + "\n");
				chooseKinds.add(2);
			}
		});
		btnComedy.setBounds(250, 229, 89, 23);
		frame.getContentPane().add(btnComedy);
		
		JButton btnRomantic = new JButton("Romantic");
		btnRomantic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText(textPane.getText() + btnRomantic.getText() + "\n");
				chooseKinds.add(3);
			}
		});
		btnRomantic.setBounds(349, 229, 89, 23);
		frame.getContentPane().add(btnRomantic);
		
		JButton btnFantastic = new JButton("Fantastic");
		btnFantastic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText(textPane.getText() + btnFantastic.getText() + "\n");
				chooseKinds.add(4);
			}
		});
		btnFantastic.setBounds(151, 265, 89, 23);
		frame.getContentPane().add(btnFantastic);
		
		JButton btnAction = new JButton("Action");
		btnAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText(textPane.getText() + btnAction.getText() + "\n");
				chooseKinds.add(5);
			}
		});
		btnAction.setBounds(250, 265, 89, 23);
		frame.getContentPane().add(btnAction);
		
		JButton btnScifi = new JButton("Sci-Fi");
		btnScifi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText(textPane.getText() + btnScifi.getText() + "\n");
				chooseKinds.add(6);
			}
		});
		btnScifi.setBounds(349, 265, 89, 23);
		frame.getContentPane().add(btnScifi);
		
		JButton btnHorrot = new JButton("Horror");
		btnHorrot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText(textPane.getText() + btnHorrot.getText() + "\n");
				chooseKinds.add(7);
			}
		});
		btnHorrot.setBounds(151, 299, 89, 23);
		frame.getContentPane().add(btnHorrot);
		
		JButton btnHistory = new JButton("History");
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText(textPane.getText() + btnHistory.getText() + "\n");
				chooseKinds.add(8);
			}
		});
		btnHistory.setBounds(250, 299, 89, 23);
		frame.getContentPane().add(btnHistory);
		
		JButton btnCrime = new JButton("Crime");
		btnCrime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText(textPane.getText() + btnCrime.getText() + "\n");
				chooseKinds.add(9);
			}
		});
		btnCrime.setBounds(349, 299, 89, 23);
		frame.getContentPane().add(btnCrime);
		
		JButton btnDrama = new JButton("Drama");
		btnDrama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText(textPane.getText() + btnDrama.getText() + "\n");
				chooseKinds.add(10);
			}
		});
		btnDrama.setBounds(151, 333, 89, 23);
		frame.getContentPane().add(btnDrama);
		
		JButton btnTragedy = new JButton("Tragedy");
		btnTragedy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText(textPane.getText() + btnTragedy.getText() + "\n");
				chooseKinds.add(11);
			}
		});
		btnTragedy.setBounds(250, 333, 89, 23);
		frame.getContentPane().add(btnTragedy);
		
		
		
	}
}
