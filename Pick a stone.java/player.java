



import java.util.*;

public class player extends guy{
	
	main timer = new main();
	
	player(String n){
		
		name = n;
		
	}
	
	@Override
	public  int startTurn(){
		
		main hell = new main();
		 try {
				Thread.sleep(timer.time);
			} catch (InterruptedException e) {
				
			}
		if (numRocks > 1){
		 rocksInHand = hell.questionInt(name + ", choose how many rocks you want to take, you have "+ numRocks + " rocks", 0, numRocks);
		}
		else{
			 rocksInHand = hell.questionInt(name + ", choose how many rocks you want to take, you have "+ numRocks + " rock", 0, numRocks);
		}
		return(rocksInHand);
		
	
		
	}
	
	@Override
	public int  Turn(int h){
		//System.out.println( +", Your turn");
		
		 try {
				Thread.sleep(timer.time);
			} catch (InterruptedException e) {
				
			}
		choice =timer.questionInt(name + ", How many rocks are their in total?",0, 50);
		
		return(choice);
		
	}

}


