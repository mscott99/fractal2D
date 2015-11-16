package game;

abstract class Guy {
    int Identity ;
	String name;
    int numRocks = 3;
    int choice;
    int rocksInHand;
    
    
    public abstract int startTurn();
	public abstract int Turn();
}

