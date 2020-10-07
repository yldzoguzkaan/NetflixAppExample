package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import Controller.ProgramController;
import Model.Program;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class HomePageWindow {

	public JFrame frame;
	private JTextField textField;
	private JButton[] btnArr =new JButton[10];
	private JTextPane[] textPaneArr = new JTextPane[10];
	private JTextField textField_1;
	private JButton btnSearch_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePageWindow window = new HomePageWindow();
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
	public HomePageWindow() {
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
		
//		JTextPane textPane = new JTextPane();
//		textPane.setText("1.Film");
//		textPane.setBounds(41, 42, 200, 200);
//		frame.getContentPane().add(textPane);
//		
//		JTextPane textPane_1 = new JTextPane();
//		textPane_1.setText("2.Film");
//		textPane_1.setBounds(251, 42, 200, 200);
//		frame.getContentPane().add(textPane_1);
//		
//		JTextPane textPane_2 = new JTextPane();
//		textPane_2.setText("3.Film");
//		textPane_2.setBounds(461, 42, 200, 200);
//		frame.getContentPane().add(textPane_2);
//		
//		JTextPane textPane_3 = new JTextPane();
//		textPane_3.setText("4.Film");
//		textPane_3.setBounds(41, 253, 200, 200);
//		frame.getContentPane().add(textPane_3);
//		
//		JTextPane textPane_4 = new JTextPane();
//		textPane_4.setText("5.Film");
//		textPane_4.setBounds(251, 253, 200, 200);
//		frame.getContentPane().add(textPane_4);
//		
//		JTextPane textPane_5 = new JTextPane();
//		textPane_5.setText("6.Film");
//		textPane_5.setBounds(461, 253, 200, 200);
//		frame.getContentPane().add(textPane_5);
		
		textField = new JTextField();
		textField.setBounds(41, 11, 521, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Program> asd = new ArrayList<Program>();
				
				ProgramController pc = new ProgramController();
				asd = pc.SearchContentsByName(textField.getText());
				System.out.println(asd.size());
				if(asd.size() == 0) {
					JOptionPane.showMessageDialog(frame,"Movies not Found");
					return;
				}
				for (Program program : asd) {
					System.out.println(program.toString());
				}
				int b=0,c=0;
				
				
				for(int r=1;r<10;r++) {
					textPaneArr[r] = new JTextPane();
					textPaneArr[r].setText("");
				}
				
				for(int t=1;t<asd.size();t++) {
					if(t==4) {
						c+=220;
						b=0;
					}
					textPaneArr[t].setText("");
					//textPaneArr[t] = new JTextPane();
					//textPaneArr[t].setText("1.Film");
					textPaneArr[t].setText(textPaneArr[t].getText() + asd.get(t-1).getId() + "\n");
					textPaneArr[t].setText(textPaneArr[t].getText() + asd.get(t-1).getName() + "\n");
					textPaneArr[t].setText(textPaneArr[t].getText() + asd.get(t-1).getType() + "\n");
					textPaneArr[t].setText(textPaneArr[t].getText() + asd.get(t-1).getKind().toString() + "\n");
					textPaneArr[t].setText(textPaneArr[t].getText() + asd.get(t-1).getEpisodeCount() + "\n");
					textPaneArr[t].setText(textPaneArr[t].getText() + asd.get(t-1).getEpisodeTime() + "\n");
					textPaneArr[t].setText(textPaneArr[t].getText() + asd.get(t-1).getScore() + "\n");
					textPaneArr[t].setBounds(60+b, 60+c, 200, 200);
					frame.getContentPane().add(textPaneArr[t]);
					b+=210;
				}
			}
		});
		btnSearch.setBounds(572, 10, 89, 23);
		frame.getContentPane().add(btnSearch);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(41, 43, 521, 20);
		frame.getContentPane().add(textField_1);
		
		btnSearch_1 = new JButton("SEARCH");
		btnSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Program> asd = new ArrayList<Program>();
				
				ProgramController pc = new ProgramController();
				asd = pc.SearchContentsByKind(textField_1.getText());
				System.out.println(asd.size());
				if(asd.size() == 0) {
					JOptionPane.showMessageDialog(frame,"Movies not Found");
					return;
				}
				for (Program program : asd) {
					System.out.println(program.toString());
				}
				int b=0,c=0;
				
				
				for(int r=1;r<10;r++) {
					textPaneArr[r] = new JTextPane();
					textPaneArr[r].setText("");
				}
				
				for(int t=1;t<asd.size();t++) {
					if(t==4) {
						c+=220;
						b=0;
					}
					textPaneArr[t].setText("");
					//textPaneArr[t] = new JTextPane();
					//textPaneArr[t].setText("1.Film");
					textPaneArr[t].setText(textPaneArr[t].getText() + asd.get(t-1).getId() + "\n");
					textPaneArr[t].setText(textPaneArr[t].getText() + asd.get(t-1).getName() + "\n");
					textPaneArr[t].setText(textPaneArr[t].getText() + asd.get(t-1).getType() + "\n");
					textPaneArr[t].setText(textPaneArr[t].getText() + asd.get(t-1).getKind().toString() + "\n");
					textPaneArr[t].setText(textPaneArr[t].getText() + asd.get(t-1).getEpisodeCount() + "\n");
					textPaneArr[t].setText(textPaneArr[t].getText() + asd.get(t-1).getEpisodeTime() + "\n");
					textPaneArr[t].setText(textPaneArr[t].getText() + asd.get(t-1).getScore() + "\n");
					textPaneArr[t].setBounds(60+b, 60+c, 200, 200);
					frame.getContentPane().add(textPaneArr[t]);
					b+=210;
				}
			}
		});
		btnSearch_1.setBounds(572, 42, 89, 23);
		frame.getContentPane().add(btnSearch_1);
		
		JLabel lblByName = new JLabel("BY NAME");
		lblByName.setBounds(671, 14, 46, 14);
		frame.getContentPane().add(lblByName);
		
		JLabel lblByKnd = new JLabel("BY KIND");
		lblByKnd.setBounds(671, 46, 46, 14);
		frame.getContentPane().add(lblByKnd);
		
		
		//counta göre ekleme yap
		
//		JButton button = new JButton("1");
//		button.setBounds(41, 492, 50, 23);
//		frame.getContentPane().add(button);
		
		ProgramController pc = new ProgramController();
		int prCount = pc.getProgramCount();
		int btCount = (prCount / 6) + 1;
		
		int a=0;
		for(int i=0;i<btCount;i++) {
			btnArr[i] = new JButton(String.valueOf(i));
			btnArr[i].setBounds(41+a, 492, 50, 23);
			frame.getContentPane().add(btnArr[i]);
			a+=75;
		}
		int b=0,c=0;
		Program p = new Program();
		for(int t=1;t<7;t++) {
			p = pc.getProgramByID(t+1);
			if(t==4) {
				c+=220;
				b=0;
			}
			textPaneArr[t] = new JTextPane();
			textPaneArr[t].setText("1.Film");
			textPaneArr[t].setText(textPaneArr[t].getText() + p.getId() + "\n");
			textPaneArr[t].setText(textPaneArr[t].getText() + p.getName() + "\n");
			textPaneArr[t].setText(textPaneArr[t].getText() + p.getType() + "\n");
			textPaneArr[t].setText(textPaneArr[t].getText() + p.getKind().toString() + "\n");
			textPaneArr[t].setText(textPaneArr[t].getText() + p.getEpisodeCount() + "\n");
			textPaneArr[t].setText(textPaneArr[t].getText() + p.getEpisodeTime() + "\n");
			textPaneArr[t].setText(textPaneArr[t].getText() + p.getScore() + "\n");
			textPaneArr[t].setBounds(60+b, 60+c, 200, 200);
			frame.getContentPane().add(textPaneArr[t]);
			b+=210;
		}
		
		
		
	}
}
