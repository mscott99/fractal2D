package game;

import java.util.Scanner;

public class Question {
	//Why is the constant time in this class? It had to be somewhere
	
	final static public int TIME = 150;
	static Scanner scanner= new Scanner(System.in);
	static Scanner scannerLine = new Scanner(System.in); //the scanner first scanner desnt work for
	private static int minInt;               // line reading, leave a comment if you know why
	private static int maxInt;
	
	
	

	//used with recursion in questionInt. Recursion is actually used if their is an error from the user
	static private int findInt(){
	
		if(scanner.hasNextInt()){
		     int answer= scanner.nextInt();
			
			     if(answer<=maxInt&& answer>=minInt){
			    	 
			    	 
			    	 return(answer);
				
				}
		}else{
			scanner.next();  //here, we want it to run only if scanner.nextInt did'nt. the last part of the code we want it to run anyways
		}
		System.out.println("Sorry, the answer is not valid. Try again:");
		           
		return(findInt());
		
		//avoid error
		
		
	}
		
		
	
	

	static int questionInt(String question, int low, int high){
		  //stored as fields to be used by the recursion functions
		minInt = low;
		maxInt = high;
		System.out.println(question);
		return(findInt());
	
	}



//this doesnt need recursion; there is no risk
	static String questionString(String n){
     
		//pause before asking, question; program is more friendly
     
      System.out.println(n);
      
      return(scannerLine.nextLine()); 
 }
}
