import java.io.BufferedReader;
import java.io.InputStreamReader;

public class unix implements Runnable {
   private Thread t;
   private String threadName;
   
   unix( String name) {
      threadName = name;
      System.out.println("Creating " +  threadName );
   }
   
   public void run() {
      System.out.println("Running " +  threadName );
      try {
    	 String[] cmd = {"/bin/bash","-c",lab1_gui.InputText.getText()};
 		 Process p= Runtime.getRuntime().exec(cmd);

 		 String s;
 		    System.out.println(p.getOutputStream());
 		    BufferedReader stdInput = new BufferedReader(new 
 		            InputStreamReader(p.getInputStream()));
 		    lab1_gui.OutputText.setText(null);
 		    while((s=stdInput.readLine())!=null){
 		     System.out.println(s);
 		     lab1_gui.OutputText.append(s+ "\n");
 		     
 		    }
         
      }catch (Exception e) {
         System.out.println("Thread " +  threadName + " interrupted.");
      }
      System.out.println("Thread " +  threadName + " exiting.");
   }
   
   public void start () {
      System.out.println("Starting " +  threadName );
      if (t == null) {
         t = new Thread (this, threadName);
         t.start ();
      }
   }
}
