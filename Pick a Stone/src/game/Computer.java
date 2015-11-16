package game;
import java.util.ArrayList;
import java.util.Random;

public class Computer extends Guy{
    int difficulty;
//fields are located in guy class
    Computer(String n, int difficulty,int identity ){
    	this.difficulty = difficulty;
    	name = n;
    	this.Identity = identity;
    }
@Override
public int startTurn(){
    
    try {
        Thread.sleep(Question.TIME * 2);
    } catch (InterruptedException e) {}

    Random r = new Random();
    
    rocksInHand = r.nextInt(numRocks + 1);
    
    System.out.println(name + " has chosen his rocks");
    
    return(rocksInHand);
}
//n doit etre le numTotalRocks du main



@Override
 public int Turn(){
		 try {
			    Thread.sleep(Question.TIME * 2);
			} catch (InterruptedException e) {
			    
			}
    
    
	
		   
	if(difficulty == 0){
		    do{
		    	 choice = rocksInHand + new Random().nextInt(RockPlay.rocksInGame - numRocks + 1);
		    }while(RockPlay.previousAnswers.contains(choice));
	}
	
	
	
	
	if(difficulty ==1){
			int rocksTakenIntoAccount=0;
	 	int target = 0;
	 	for(ArrayList<Integer> played : RockPlay.previousAnswers){
			target += played.get(1)-Math.round((RockPlay.rocksInGame-this.numRocks)/(RockPlay.bro.length-1));
			//the choice of the person minus the average of the rocks of all the other players is an approximation to choose what the player was thinking
			
			rocksTakenIntoAccount+=RockPlay.bro[played.get(0)].numRocks;//the minus one: the one is the player playing
		}
	 	if(target <0){
	 		target =0;
	 	}
	 	target+=new Random().nextInt(RockPlay.rocksInGame-rocksTakenIntoAccount); //we add a random number for the rocks not taken into account
	
		//if the number is already taken, we circle away from the target until we find a spot
	
		int distance = 0;
		int posNeg = 1;
	
		boolean addDistance = true;
	
		do{
			choice = target + ((-1)^posNeg)*distance;
	
			if(addDistance){
				distance++;
		
			}
	
			addDistance ^= true;
			posNeg++;
		
		}while(RockPlay.previousAnswers.contains(choice));
	
	}
	
	RockPlay.previousAnswers.add(new ArrayList<Integer>(2){/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{add(Identity);  add(choice);}});
		    //pour une difficulté plus élevé:
		    //choice = rocksInHand + (int)((n - rocksInHand)/2) + w;
			    if(numRocks != 1 && choice != 1){
			    	System.out.println(name + " (he has " + numRocks + " rocks) : I think there are " + choice + " rocks");
			    }
			    else if (numRocks == 1){
			    	System.out.println(name + " (he has " + numRocks + " rock) : I think there are " + choice + " rocks");
			    }
			    else if(choice == 1){
			    	System.out.println(name + " (he has " + numRocks + " rocks) : I think there is " + choice + " rock");
			    }
			    else{
			    	System.out.println(name + " (he has " + numRocks + " rock) : I think there is " + choice + " rock");
			    }
		
		    
		    return(choice);
		
	}	
		
	}



