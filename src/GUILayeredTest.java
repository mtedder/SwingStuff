import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class GUILayeredTest {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUILayeredTest window = new GUILayeredTest();
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
	public GUILayeredTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JInternalFrame jFrame1 = new JInternalFrame("New JInternalFrame");
		jFrame1.setVisible(true);
		jFrame1.setBounds(0, 0, 434, 262);
		frame.getContentPane().add(jFrame1);
		
			
			JLabel lblHiThisIs = new JLabel("Hi This is Screen 1");
			lblHiThisIs.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblHiThisIs.setHorizontalAlignment(SwingConstants.CENTER);
			jFrame1.getContentPane().add(lblHiThisIs, BorderLayout.NORTH);
			
			JButton btnGotoScreen = new JButton("Goto Screen 2");
			btnGotoScreen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showScreen2();
				}
			});
			jFrame1.getContentPane().add(btnGotoScreen, BorderLayout.SOUTH);
			
			JInternalFrame jFrame2 = new JInternalFrame("New JInternalFrame");
			jFrame2.setResizable(true);
			jFrame2.setBounds(0, 0, 434, 262);			
			JButton button = new JButton("Back to Page 1");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showSreen1();
				}
			});
			button.setSize(new Dimension(50, 10));
			jFrame2.getContentPane().add(button, BorderLayout.SOUTH);
			jFrame2.getContentPane().add(new JLabel("This is Screen 2"), BorderLayout.CENTER);	
			frame.getContentPane().add(jFrame2);
	
	}

	/*
	 * Show page 1 screen
	 */
	protected void showSreen1() {
		frame.getContentPane().getComponent(1).setVisible(false);
		frame.getContentPane().getComponent(0).setVisible(true);			
	}

	/*
	 * Show page 2 screen
	 */
	protected void showScreen2() {			
		frame.getContentPane().getComponent(0).setVisible(false);
		frame.getContentPane().getComponent(1).setVisible(true);				
	}
}
