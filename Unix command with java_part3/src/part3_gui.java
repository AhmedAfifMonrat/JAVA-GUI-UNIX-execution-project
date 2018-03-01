import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class part3_gui {

	private JFrame frame;
	private JTextArea UrlText;
	private JTextArea InputText;
	private JTextArea OutputText;
	private JButton btnExecute;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					part3_gui window = new part3_gui();
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
	public part3_gui() {
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
		
		UrlText = new JTextArea();
		UrlText.setBounds(49, 45, 343, 25);
		frame.getContentPane().add(UrlText);
		
		InputText = new JTextArea();
		InputText.setBounds(12, 107, 426, 37);
		frame.getContentPane().add(InputText);
		
		btnExecute = new JButton("Execute");
		btnExecute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					String op = linuxExecute(InputText.getText(), UrlText.getText());
					OutputText.setText(op);
				}
				catch(Exception e1)
				{
					
				}
				
			}
		});
		btnExecute.setBounds(156, 156, 117, 25);
		frame.getContentPane().add(btnExecute);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 211, 369, 64);
		frame.getContentPane().add(scrollPane);
		
		OutputText = new JTextArea();
		scrollPane.setViewportView(OutputText);
		
		JLabel lblUrl = new JLabel("Url");
		lblUrl.setBounds(210, 8, 204, 25);
		frame.getContentPane().add(lblUrl);
		
		JLabel lblInputCommands = new JLabel("Input Commands");
		lblInputCommands.setBounds(156, 82, 163, 15);
		frame.getContentPane().add(lblInputCommands);
	}
	public JTextArea getUrlText() {
		return UrlText;
	}
	public JTextArea getInputText() {
		return InputText;
	}
	public JTextArea getOutputText() {
		return OutputText;
	}
	public JButton getBtnExecute() {
		return btnExecute;
	}
	public String linuxExecute(String command, String host) throws IOException
	{

		Socket clientSocket = new Socket(host, 6400);
		if (clientSocket != null)
		{
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			outToServer.writeBytes(command + "\n");						   
			String line = null;
			String reply = "";
			while ((line = inFromServer.readLine()) != null )
			{
				 if (line.isEmpty()) {
				        break;
				    }
				reply += line;
				reply +="\n";
			}
			inFromServer.close();
			return reply;
		}

		else{	
			return "Not Connected";
		}
	}
}
