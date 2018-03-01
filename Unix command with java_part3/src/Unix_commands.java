import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Unix_commands {
	String reply = "";
	public String execute(String command) {
		StringBuffer output = new StringBuffer();

		Process p;
		try {
			
			String[] cmd1 =  { "/bin/bash", "-c", command};
			p = Runtime.getRuntime().exec(cmd1);
			
			p.waitFor(); 
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = "";
			while ((line = reader.readLine())!= null) {
				output.append(line + "\n");
			}
			reply = output.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reply;
	}
}