package game;

import java.util.ArrayList;




public class RockPlay {




// we want this to retain what was said and who said it
  static ArrayList<ArrayList<Integer>> previousAnswers;
    
  static int rocksInGame = 0;

  static Guy[] bro;


    



 public static void main(String[] args) {
    
       
        

	 
	 
    
    
    int gameWinner = 40;
    
    
    
    int numTotalPlayers = Question.questionInt("How many players?",1,3);

    int numTotalComputers = Question.questionInt("How many computers?",0,3);
    
    int numGuys= numTotalPlayers + numTotalComputers;
    
    bro = new Guy[numGuys];
   
    
    
    for(int i = 0; i< numTotalPlayers; i++){
        bro[i] = new Player(Question.questionString("player" + (i+1)+"'s name:"),i);
    }
    
    //make the computers
    for(int i = numTotalPlayers; i< numTotalComputers + numTotalPlayers;i++){
        bro[i] = new Computer("computer" + (i+1-numTotalPlayers), Question.questionInt("What do you want the level of "+ "computer" + (i+1-numTotalPlayers)+ " to be? choices: 0,1 ",0,1),i);
    }
    
    
    for(int i = 0; i < bro.length; i++){
		 rocksInGame += bro[i].numRocks;
	 }
    //make the players, by asking their names to the user
    
    
    //make a random order of players
    RandomArraySorter.randomSort(bro);
    
     try {
            Thread.sleep(Question.TIME);
        } catch (InterruptedException e) {
        }
     
    //print the order of the game this is made in two parts for the sake of syntax
    System.out.print("the order of the game is: ");
    for(int i =0 ; i< (bro.length-1); i++){  
        System.out.print(bro[i].name + ", ");  
    }
    System.out.println(bro[bro.length-1].name + ".");
    

     
    boolean gameOver = false;
     int start = 0;
     
     //continue jusqua la fin du jeu
     while(gameOver == false){
    
    	 	 
    	//reset previousAnswers
    	 previousAnswers= null;
    	 previousAnswers = new ArrayList<ArrayList<Integer>>(numGuys);
    	 
    

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
        
        if(bro[i % bro.length].getClass().getName() == "Player"){
        bro[i % bro.length].Turn();
        }else{
        	
        }
    } 
    start ++;
    
    
    System.out.println();
    try {
        Thread.sleep(Question.TIME);
    } catch (InterruptedException e) {
        
        
    }
    //reset value
    boolean thereIsAWinner = false;
   //check if anybody got the right answer
     for(int i =0; i< bro.length; i++){
        
        if(bro[i].choice == numTotalRocks){
            
        	if(--bro[i].numRocks==0){
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
//if there is no winner
     if(thereIsAWinner==false){
    //if/else for the sake of grammar
    	 if(numTotalRocks <1){
    		 System.out.println("no winner for this set, there was " + numTotalRocks+ " rocks");
    	 }else{
    		 System.out.println("no winner for this set, there was " + numTotalRocks+ " rock");
    	 }
     }
      //end of the round
     previousAnswers = null;
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
      
     
}
}






