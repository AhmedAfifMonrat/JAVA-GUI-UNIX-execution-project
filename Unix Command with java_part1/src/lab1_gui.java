import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class lab1_gui {

	private JFrame frame;
	private JLabel lblInputCommands;
	private JLabel lblOutput;
	public static JTextArea InputText;
	public static JTextArea OutputText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lab1_gui window = new lab1_gui();
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
	public lab1_gui() {
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
		
		
		
		JButton btnUnix = new JButton("Execute Unix");
		btnUnix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unix R1 = new unix( "Thread-2");
			     R1.start();
				
			}
		});
		btnUnix.setBounds(36, 215, 157, 25);
		frame.getContentPane().add(btnUnix);
		
		lblInputCommands = new JLabel("Input Commands");
		lblInputCommands.setBounds(49, 50, 129, 15);
		frame.getContentPane().add(lblInputCommands);
		
		lblOutput = new JLabel("Output");
		lblOutput.setBounds(300, 52, 70, 15);
		frame.getContentPane().add(lblOutput);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 90, 179, 99);
		frame.getContentPane().add(scrollPane);
		
		InputText = new JTextArea();
		scrollPane.setViewportView(InputText);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(250, 90, 168, 99);
		frame.getContentPane().add(scrollPane_1);
		
		OutputText = new JTextArea();
		scrollPane_1.setViewportView(OutputText);
		
		JButton btnFibo = new JButton("Execute Fibonacci");
		btnFibo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 fibonacci R1 = new fibonacci( "Thread-1");
			     R1.start();
			     
			}
		});
		btnFibo.setBounds(250, 215, 168, 25);
		frame.getContentPane().add(btnFibo);
	}
}
