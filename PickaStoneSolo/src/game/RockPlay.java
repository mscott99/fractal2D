package game;

import java.util.ArrayList;




public class RockPlay {




// we want this to retain what was said and who said it
  static ArrayList<ArrayList<Integer>> previousAnswers;
    
  static int rocksInGame = 0;

  static Guy[] bro;


    



 public static void main(String[] args) {
    
      //must be initialized here
     int gameWinner = 0;
    System.out.println("write the answers to the questions then press enter.");
    
    try {
	    Thread.sleep(Question.TIME );
	} catch (InterruptedException e) {
	    
	}
    
     Guy play = new Player(Question.questionString("What is your name?"),0);
        
    Question.questionInstructions();
    
    
    
    int numTotalComputers = Question.questionInt("How many opponents do you want?",1,10);
    
    int numGuys= 1 + numTotalComputers;
    
    bro = new Guy[numGuys];
    
    bro[0] = play;
    
    play = null;
    
    //make the computers
    for(int i = 1; i< numTotalComputers + 1;i++){
        bro[i] = new Computer("computer" + i, Question.questionInt("What do you want the level of "+ "computer" +i+ " to be? choices: 1,2,3 ",1,3),i);
    }
    
    
   
    //make the players, by asking their names to the user
    
    
    //make a random order of players
    RandomArraySorter.randomSort(bro);
    
     System.out.println();
    //print the order of the game this is made in two parts for the sake of syntax
    System.out.print("the order of the game is: ");
    for(int i =0 ; i< (bro.length-1); i++){  
        System.out.print(bro[i].name + ", ");  
    }
    System.out.println(bro[bro.length-1].name + ".");
    
    System.out.println();
    try {
        Thread.sleep(Question.TIME*10);
    } catch (InterruptedException e) {
    }
     
    boolean gameOver = false;
     int start = 0;
     
     //continue jusqua la fin du jeu
  while(gameOver == false){
    	
    	 //reset rocksInGame
	  	rocksInGame =0;
    	 for(int i = 0; i < bro.length; i++){
    		 rocksInGame += bro[i].numRocks;
    	 }
    	//reset previousAnswers
    	 previousAnswers= null;
    	 previousAnswers = new ArrayList<ArrayList<Integer>>(2);
    	 previousAnswers.add(new ArrayList<Integer>(numGuys));
    	 previousAnswers.add(new ArrayList<Integer>(numGuys));
    

    	 int numTotalRocks = 0;
    	 for(int i =0; i< bro.length; i++){
        
    		 numTotalRocks += bro[i].startTurn();
        
    	 }
    //le tour des joueurs
    
    System.out.println();
    



    
    try {
        Thread.sleep(Question.TIME/2);
    } catch (InterruptedException e) {}
    //this is to put an extra small break between the steps of the game
   
  //faire jouer les joueurs et changer le premier qui joue, 
//  tout en gardant l'ordre definit aleatoirement plus haut
    for(int i = start; i< bro.length + start; i++){
        
        
        bro[i % bro.length].Turn();
        
    } 
    start ++;
    
    
    System.out.println();
    try {
        Thread.sleep(Question.TIME/3);
    } catch (InterruptedException e) {
        
        
    }
    //reset value
    boolean thereIsAWinner = false;
   //check if anybody got the right answer
     for(int i =0; i< bro.length; i++){
        
        if(bro[i].choice == numTotalRocks){
            
        	if(bro[i].numRocks==1){
            	//break the while loop and register who won
        		gameOver = true;
            	gameWinner = i;
            	
            }
            else{
            System.out.println(bro[i].name + " has won the set");
            bro[i].numRocks --;
            
            
            }
            thereIsAWinner=true;
        }
     }   
   // here is no winner
     if(thereIsAWinner==false){
    //if/else for the sake of grammar
    	 if(numTotalRocks <1){
    		 System.out.println("no winner for this set, there was " + numTotalRocks+ " rocks");
    	 }else{
    		 System.out.println("no winner for this set, there was " + numTotalRocks+ " rock");
    	 }
     }
      //end of the round
     System.out.println();
     System.out.println();
     try {
         Thread.sleep(Question.TIME*10);
     } catch (InterruptedException e) {
     }
}
     
     
     
     
     
     try {
        Thread.sleep(Question.TIME);
    } catch (InterruptedException e) {}
     
    
     
     
   //final sequence with style  
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
    
    System.out.println(bro[gameWinner].name + "!!!!!!!!!!!!!!!!");
          //find the resul
    for(int x =0;x<3;x++){
    	System.out.println();
    }
    System.out.println("Game Over");
    System.out.println();
    System.out.println("This game was written by Matthew Scott"); 
    
     
}
}






