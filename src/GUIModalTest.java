import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIModalTest {

	private JFrame frame;
	private final JButton btnShowDialog = new JButton("Show Modeless Dialog");
	private final JButton btnShow = new JButton("Show");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIModalTest window = new GUIModalTest();
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
	public GUIModalTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnStart = new JButton("Show Modal Dialog");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog loginForm = new JDialog(frame,"Modal Dialog", JDialog.DEFAULT_MODALITY_TYPE.DOCUMENT_MODAL);
				loginForm.getContentPane().add(new JTextArea());
				loginForm.setBounds(0, 0, 300, 300);						
			}
		});
		frame.getContentPane().add(btnStart, BorderLayout.SOUTH);
		btnShowDialog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog menuForm = new JDialog(frame,"Modeless Dialog", JDialog.DEFAULT_MODALITY_TYPE.MODELESS);
				menuForm.getContentPane().add(new JTextArea());
				menuForm.getContentPane().add(new JButton("Select"));
				menuForm.setBounds(0, 0, 300, 300);
				menuForm.setVisible(true);
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(btnShowDialog, BorderLayout.WEST);
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog menuForm = new JDialog(frame,"App Modal Dialog", JDialog.DEFAULT_MODALITY_TYPE.APPLICATION_MODAL);
				menuForm.getContentPane().add(new JTextArea("Insert test here"));
				menuForm.getContentPane().add(new JButton("Next"));
				menuForm.setBounds(0, 0, 300, 300);
				menuForm.setVisible(true);	
				
			}
		});
		
		frame.getContentPane().add(btnShow, BorderLayout.EAST);
	}

}
