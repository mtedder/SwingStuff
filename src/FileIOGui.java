import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.*;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;

public class FileIOGui {

	private JFrame frame;
	private String fileName = "myFile.txt";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileIOGui window = new FileIOGui();
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
	public FileIOGui() {
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
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(Color.GRAY);
		textPane.setBounds(20, 11, 404, 206);
		frame.getContentPane().add(textPane);
		
		JButton btnStart = new JButton("Open");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Path path = Paths.get(fileName);
				File myTextFile = path.toAbsolutePath().toFile();
				try {
					BufferedReader reader = new BufferedReader(new FileReader(myTextFile));
					while(reader.ready()){								
						textPane.setText(textPane.getText() + reader.readLine() + "\n");
					}
//					textPane.setText(reader.readLine());
					reader.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnStart.setBounds(30, 228, 89, 23);
		frame.getContentPane().add(btnStart);
		

		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Path path = Paths.get(fileName);
				
//				JOptionPane.showMessageDialog(null, path.getFileName());
				Path absPath = path.toAbsolutePath();
//				JOptionPane.showMessageDialog(null, absPath);
				if(!Files.exists(absPath)){
					try {
						Files.createFile(absPath);						
						
					} catch (IOException e) {
						JOptionPane.showMessageDialog(null, "File creation error!");
					}
				}
				File myTextFile = absPath.toFile();
				PrintWriter writer;
				try {
//					writer = new PrintWriter(myTextFile);
					writer = new PrintWriter(new FileOutputStream(myTextFile, true));
//					writer.write(textPane.getText());
					writer.println(textPane.getText());
//					writer.append(textPane.getText());
//					writer.flush();
					writer.close();		
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
						
			}
		});
		btnSave.setBounds(129, 228, 89, 23);
		frame.getContentPane().add(btnSave);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPane.setText("");
			}
		});
		btnClear.setBounds(228, 228, 89, 23);
		frame.getContentPane().add(btnClear);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(327, 228, 89, 23);
		frame.getContentPane().add(btnExit);
	}
}
