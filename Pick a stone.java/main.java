import java.util.Random;
import java.util.Scanner;


public class main {
final static public int time = 500;

static int winner;
public static int questionInt(String n, int low, int high){
	 try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			
		}
		System.out.println(n);
		boolean i = true;
		
		int lol = 0;
		
		while(i){
			boolean j = true;
		Scanner first = new Scanner(System.in);
		if(first.hasNextInt()){
		lol = first.nextInt();
		}
		else{
			j = false;
		}
		if(lol <= high && lol >= low && j){
			i = false;
				
		}else{

			System.out.println("Sorry, the answer is not valid. Try again:");
		}
		}
		
		return(lol);
		
	}
	
	
	public static String questionString(String n){
		
		 try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				
			}
		 boolean w = true;
		 System.out.println(n);
		 String saviour = " ";
		 while(w){
		
		Scanner second = new Scanner(System.in);
		if(second.hasNextLine()){
		saviour = second.nextLine();
		w = false;
		}else{
			System.out.println("Sorry, the answer is not valid. Try again:");
		}
		
		}
		return(saviour);
	}

	



 public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		//int numTotalComputers = questionInt("How many computers?",1,3);
//Window testing = new Window();

//testing.setVisible(true);
	 
	 
	int rocksInGame;
	
	int numTotalPlayers = questionInt("How many players?",1,3);

	int numTotalComputers = questionInt("How many computers?",0,3);
	
	
	computer[] comput= new computer[numTotalComputers];
	player[] play = new player[numTotalPlayers];
	
	for(int i = 0; i< comput.length;i++){
		comput[i] = new computer("computer" + (i+1));
		
	}
	for(int i = 0; i< play.length; i++){
		play[i] = new player(questionString("player" + (i+1)+"'s name:"));
		
		
	}
	
	guy[] bro = new guy[comput.length + play.length];
	
	
	
	
	
	
	//ordre aleatoire
	for(int i = 0; i < comput.length; i++){
		Random r = new Random();
		int re;
		boolean hey = false;
		do{
			re = r.nextInt(bro.length);
			if(bro[re] == null){
					
				bro[re] = comput[i];
				hey = true;
				
			}
		}while(hey == false);
		
	}
	//ordre aleatoire
	for(int i = 0; i < play.length; i++){
		
		
		boolean hey = false;
		do{
			Random rand = new Random();
			int re = rand.nextInt(bro.length);
			if(bro[re] == null){
					
				bro[re] = play[i];
				hey = true;
			}
			
		}while(hey == false);
	}
	
	 try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			
		}
	System.out.print("the order of the game is: ");
	for(int i =0 ; i< (bro.length-1); i++){
		
		System.out.print(bro[i].name + ", ");
		
	}
	System.out.println(bro[bro.length-1].name + ".");
	

	 boolean check = true;
	 int start = 0;
	 
	 //continue jusqua la fin du jeu
	 while(check){
	rocksInGame = 0;
	
for(int i = 0; i < bro.length; i++){
		
		rocksInGame += bro[i].numRocks;
		
	}
	
	int numTotalRocks = 0;
	for(int i =0; i< bro.length; i++){
		
		numTotalRocks += bro[i].startTurn();
		
	}
	//le tour des joueurs
	
	System.out.println();
	

try {
	Thread.sleep(1000);
} catch (InterruptedException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}


//faire jouer les joueurs et changer le premier qui joue, 
//  tout en gardant l'ordre definit aleatoirement plus haut
	
	
	for(int i = start; i< bro.length + start; i++){
		int result = i % bro.length;
		
		bro[result].Turn(rocksInGame);
	
	} 
	start ++;
	
	
	System.out.println();
	try {
		Thread.sleep(time);
	} catch (InterruptedException e) {
		
		
	}
	
	boolean hey = true;

	 for(int i =0; i< bro.length; i++){
		
		if(bro[i].choice == numTotalRocks){
			
			System.out.println(bro[i].name + " has won the set");
			bro[i].numRocks --;
			
			hey = false;

		}
		
	
	}

if(hey){
	//pluriel/singulier de rocks
	if(numTotalRocks <1){
	System.out.println("no winner for this set, there was " + numTotalRocks+ " rocks");
	}else{
		System.out.println("no winner for this set, there was " + numTotalRocks+ " rock");
	}
	}
	
	for(int i =0; i< bro.length; i++){
		if(bro[i].numRocks == 0){
			
			check = false;
			winner = i;
		}
		
		
	}
	  
	 }
	 try {
		Thread.sleep(time);
	} catch (InterruptedException e) {}
	 
	 System.out.println();
	System.out.println("and the winner is............" );	  
		  
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {}	 
		 
	System.out.print("3");
		  
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {}	 
		 
	System.out.print("  2");
		  
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {}	 
		 
	System.out.print("  1");
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {}
	
	System.out.println();
	
	System.out.println(bro[winner].name + "!!!!!!!!!!!!!!!!");
		  //find the resul
      
	 
}
}






