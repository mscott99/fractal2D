package game;

abstract class Guy {
    int Identity ;
	String name;
	//the number of rocks the players possess
    int numRocks = 3;
    //their guess, this is known by the other players
    int choice;
    //what the player puts in his hands
    int rocksInHand;
    
    
    public abstract int startTurn();
	public abstract int Turn();
}

