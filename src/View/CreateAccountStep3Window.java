package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

import Controller.ProgramController;
import Model.Program;

public class CreateAccountStep3Window {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccountStep3Window c = new CreateAccountStep3Window();
					c.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreateAccountStep3Window() {
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
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(34, 54, 200, 200);
		frame.getContentPane().add(textPane);
		textPane.setText("1.Film");
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(244, 54, 200, 200);
		frame.getContentPane().add(textPane_1);
		textPane_1.setText("2.Film");
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(454, 54, 200, 200);
		frame.getContentPane().add(textPane_2);
		textPane_2.setText("3.Film");
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(34, 265, 200, 200);
		frame.getContentPane().add(textPane_3);
		textPane_3.setText("4.Film");
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setBounds(244, 265, 200, 200);
		frame.getContentPane().add(textPane_4);
		textPane_4.setText("5.Film");
		
		JTextPane textPane_5 = new JTextPane();
		textPane_5.setBounds(454, 265, 200, 200);
		frame.getContentPane().add(textPane_5);
		textPane_5.setText("6.Film");
		
		JButton btnDoldur = new JButton("Bring");
		btnDoldur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = CreateAccountStep2Window.chooseKinds.get(0);
				int j = CreateAccountStep2Window.chooseKinds.get(1);
				int k = CreateAccountStep2Window.chooseKinds.get(2);
				System.out.println(i+"--"+j+"--"+k);
				ProgramController pc = new ProgramController();
				
				List<Integer> retList = new ArrayList<Integer>();
				
				retList = pc.getProgramIDByKind(i);
				//System.out.println(retList.toString());
				
				Program p = new Program();
				p = pc.getProgramByID(retList.get(0));
				
				textPane.setText(textPane.getText() + p.getId() + "\n");
				textPane.setText(textPane.getText() + p.getName() + "\n");
				textPane.setText(textPane.getText() + p.getType() + "\n");
				textPane.setText(textPane.getText() + p.getKind().toString() + "\n");
				textPane.setText(textPane.getText() + p.getEpisodeCount() + "\n");
				textPane.setText(textPane.getText() + p.getEpisodeTime() + "\n");
				textPane.setText(textPane.getText() + p.getScore() + "\n");
					
				
				Program t = new Program();
				t = pc.getProgramByID(retList.get(1));
				
				textPane_1.setText(textPane_1.getText() + t.getId() + "\n");
				textPane_1.setText(textPane_1.getText() + t.getName() + "\n");
				textPane_1.setText(textPane_1.getText() + t.getType() + "\n");
				textPane_1.setText(textPane_1.getText() + t.getKind().toString() + "\n");
				textPane_1.setText(textPane_1.getText() + t.getEpisodeCount() + "\n");
				textPane_1.setText(textPane_1.getText() + t.getEpisodeTime() + "\n");
				textPane_1.setText(textPane_1.getText() + t.getScore() + "\n");
				
				retList.clear();
				retList = pc.getProgramIDByKind(j);
				
				Program o = new Program();
				o = pc.getProgramByID(retList.get(0));
				
				textPane_2.setText(textPane_2.getText() + o.getId() + "\n");
				textPane_2.setText(textPane_2.getText() + o.getName() + "\n");
				textPane_2.setText(textPane_2.getText() + o.getType() + "\n");
				textPane_2.setText(textPane_2.getText() + o.getKind().toString() + "\n");
				textPane_2.setText(textPane_2.getText() + o.getEpisodeCount() + "\n");
				textPane_2.setText(textPane_2.getText() + o.getEpisodeTime() + "\n");
				textPane_2.setText(textPane_2.getText() + o.getScore() + "\n");
				
				Program l = new Program();
				l = pc.getProgramByID(retList.get(1));
				
				textPane_3.setText(textPane_3.getText() + l.getId() + "\n");
				textPane_3.setText(textPane_3.getText() + l.getName() + "\n");
				textPane_3.setText(textPane_3.getText() + l.getType() + "\n");
				textPane_3.setText(textPane_3.getText() + l.getKind().toString() + "\n");
				textPane_3.setText(textPane_3.getText() + l.getEpisodeCount() + "\n");
				textPane_3.setText(textPane_3.getText() + l.getEpisodeTime() + "\n");
				textPane_3.setText(textPane_3.getText() + l.getScore() + "\n");
				
				retList.clear();
				retList = pc.getProgramIDByKind(k);
				
				Program m = new Program();
				m = pc.getProgramByID(retList.get(0));
				
				textPane_4.setText(textPane_4.getText() + m.getId() + "\n");
				textPane_4.setText(textPane_4.getText() + m.getName() + "\n");
				textPane_4.setText(textPane_4.getText() + m.getType() + "\n");
				textPane_4.setText(textPane_4.getText() + m.getKind().toString() + "\n");
				textPane_4.setText(textPane_4.getText() + m.getEpisodeCount() + "\n");
				textPane_4.setText(textPane_4.getText() + m.getEpisodeTime() + "\n");
				textPane_4.setText(textPane_4.getText() + m.getScore() + "\n");
				
				Program n = new Program();
				n= pc.getProgramByID(retList.get(1));
				
				textPane_5.setText(textPane_5.getText() + n.getId() + "\n");
				textPane_5.setText(textPane_5.getText() + n.getName() + "\n");
				textPane_5.setText(textPane_5.getText() + n.getType() + "\n");
				textPane_5.setText(textPane_5.getText() + n.getKind().toString() + "\n");
				textPane_5.setText(textPane_5.getText() + n.getEpisodeCount() + "\n");
				textPane_5.setText(textPane_5.getText() + n.getEpisodeTime() + "\n");
				textPane_5.setText(textPane_5.getText() + n.getScore() + "\n");
				
			}
		});
		btnDoldur.setBounds(664, 54, 89, 23);
		frame.getContentPane().add(btnDoldur);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePageWindow hp = new HomePageWindow();
				hp.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnHome.setBounds(664, 442, 89, 23);
		frame.getContentPane().add(btnHome);
		
		
	}
}
