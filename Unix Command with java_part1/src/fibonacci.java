
public class fibonacci implements Runnable {
   private Thread t;
   private String threadName;
   static int n1=0,n2=1,n3=0;
   static int count;
   
   fibonacci( String name) {
      threadName = name;
      System.out.println("Creating " +  threadName );
   }
   static void printFibonacci(int count){  
	  
	    if(count>0){    
	         n3 = n1 + n2;    
	         n1 = n2;    
	         n2 = n3;    
	         System.out.print(" "+n3); 
	         lab1_gui.OutputText.append(" "+Integer.toString(n3));
	         printFibonacci(count-1); 
	         
	     }    
	 }    
   public void run() {
      System.out.println("Running " +  threadName );
      
    	  String input=lab1_gui.InputText.getText();
    	  count=Integer.parseInt(input);
    	  System.out.print(n1+" "+n2);//printing 0 and 1 
    	  lab1_gui.OutputText.setText(null);
    	  lab1_gui.OutputText.append("0"+" "+"1");
    	 
    	  
    	  printFibonacci(count-2);//n-2 because 2 numbers are already printed   
         
      
   }
   
   public void start () {
      System.out.println("Starting " +  threadName );
      if (t == null) {
         t = new Thread (this, threadName);
         t.start ();
      }
   }
}
