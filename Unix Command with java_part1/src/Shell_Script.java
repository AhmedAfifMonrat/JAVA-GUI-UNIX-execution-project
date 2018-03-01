import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shell_Script {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

	     String[] cmd = {"/bin/bash","-c","cd /home/ && pwd | ls -al "};
		 Process p= Runtime.getRuntime().exec(cmd);

		 String s;
		    System.out.println(p.getOutputStream());
		    BufferedReader stdInput = new BufferedReader(new 
		            InputStreamReader(p.getInputStream()));
		    while((s=stdInput.readLine())!=null){
		     System.out.println(s);
		     
		    }
		
	}

}
