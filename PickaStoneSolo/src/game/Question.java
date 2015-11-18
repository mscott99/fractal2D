package game;

import java.util.Scanner;

public class Question {
	//Why is the constant time in this class? It had to be somewhere
	
	final static public int TIME =150;
	static Scanner scanner= new Scanner(System.in);
	static Scanner scannerLine = new Scanner(System.in); //the scanner first scanner desnt work for
	static Scanner instructionsScanner = new Scanner(System.in);
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
		//used only for the instructions question
	static private String findString(){
		
		     String answer= instructionsScanner.nextLine();
		     
			     if("y".equals(answer)){
			    	 
			    	 return("This is a game where each players chooses a certain number of rocks "+'\n'+
			     "from the ones he posesses. Then, each player tryes to guess the total amount of rocks " + '\n'+
			     "chosen by all players. You cannot guess a number if it has already been guessed by a "+'\n'+
			     "previous player. If you win a round, you loose a rock. If you get to zero rocks "+'\n'+
			     "before any other player, you win. Enter your answers for the displayed questions " +'\n'+
			     "in numbers or in letters depending on the question, then press enter. This version "+'\n'+
			     "of the game plays with one human and up to five computers."
			    			 );
			    	 
			    	
				
				}else if("n".equals(answer)){
					return("");
				}
		else{
			
			System.out.println("Sorry, the answer is not valid. Try again:");
			return(findString());
			//here, we want it to run only if scanner.nextInt did'nt. the last part of the code we want it to run anyways
		}
		
	}
		
	
	

	static int questionInt(String question, int low, int high){
		  //stored as fields to be used by the recursion functions
		 try {
		        Thread.sleep(Question.TIME);
		    } catch (InterruptedException e) {
		    }
		
		minInt = low;
		maxInt = high;
		System.out.println();
		System.out.println(question);
		
		return(findInt());
	
	}



//this doesnt need recursion; there is no risk 
	static String questionString(String n){
     
		//pause before asking, question; program is more friendly
		
		
		System.out.println();
		System.out.println(n);
     
      
      return(scannerLine.nextLine()); 
 }
	
	
	
	
	static void questionInstructions(){
		try {
	        Thread.sleep(Question.TIME);
	    } catch (InterruptedException e) {}
		System.out.println();
		
		System.out.println("This is the Pick-a-Stone solo game. Do you need instructions? (answer y (yes) or n (no))");
		
		String result = findString();
		
		if("".equals(result)==false){
		
			System.out.println(result);
		}
	}
}




