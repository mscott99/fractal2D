package game;

public class Player extends Guy{
    
    
  
    Player(String name, int identity){
    	
    	
      this.name = name;
      this.Identity= identity;
    }
    
    @Override
    public  int startTurn(){
        
        
         try {
                Thread.sleep(Question.TIME);
            } catch (InterruptedException e) {
                
            }
         
         
         //for the sake of grammar
        if (numRocks > 1){
         rocksInHand = Question.questionInt(name + ", choose how many rocks you want to take, you have "+ numRocks + " rocks", 0, numRocks);
        }
        else{
             rocksInHand = Question.questionInt(name + ", choose how many rocks you want to take, you have "+ numRocks + " rock", 0, numRocks);
        }
        
        return(rocksInHand);
        
    
        
    }
    
    @Override
    public int  Turn(){
        //System.out.println( +", Your turn");
        
         try {
                Thread.sleep(Question.TIME);
            } catch (InterruptedException e) {
                
            }
        
        choice =Question.questionInt(name + ", How many rocks are their in total?",0, 20000);
        while(RockPlay.previousAnswers.get(1).contains(choice)){
        	
        	choice = Question.questionInt("the answer was already taken, choose again.", 0, 50);
        }
        //here there is a Serializable class, or something like that
        RockPlay.previousAnswers.get(0).add(Identity);
    	RockPlay.previousAnswers.get(1).add(choice);
        return(choice);
        
    }

}



